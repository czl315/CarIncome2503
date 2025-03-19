package ttjj.rank.stat.schedule;

import ttjj.dto.CondStockAdrCount;
import ttjj.dto.EtfAdrCountVo;
import ttjj.dto.RankBizDataDiff;
import ttjj.rank.EtfControl;
import ttjj.service.EtfAdrCountService;
import utils.DateUtil;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static utils.Content.*;

/**
 * 定时任务-etf涨幅统计
 */
public class EtfAdrJob {
    public static int jobCountUpdateUpSum = 0;//定时次数
    static int jobSeconds = 300;//定时间隔时间
    static volatile int jobSecondsUpdateUpSum = 180;//定时间隔时间

    public static void main(String[] args) {
        statShowEtfAdrCountSchedule();
    }


    /**
     * 定时任务-etf涨幅统计
     */
    private static void statShowEtfAdrCountSchedule() {
        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//            String date = "2025-03-03";
        /**
         * 更新基础信息
         */
        new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(() -> {
            try {
                CondStockAdrCount condition = new CondStockAdrCount();
                condition.setDate(date);
                EtfControl.saveOrUpdateListNetLastDay(condition, date);
                jobSeconds++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, jobSeconds, TimeUnit.SECONDS);


        /**
         * 更新-上涨之和
         */
        new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(() -> {
            String methodName = "更新上涨之和（Job）";
            try {
                BigDecimal minMv = null;
                BigDecimal maxMv = null;
                if (jobCountUpdateUpSum % 5 == 0) {
                    minMv = NUM_YI_30;
                    maxMv = null;
                } else if (jobCountUpdateUpSum % 5 == 1) {
                    minMv = NUM_YI_10;
                    maxMv = NUM_YI_30;
                } else if (jobCountUpdateUpSum % 5 == 2) {
                    minMv = NUM_YI_2;
                    maxMv = NUM_YI_10;
                } else if (jobCountUpdateUpSum % 5 == 3) {
                    minMv = NUM_YI_1;
                    maxMv = NUM_YI_2;
                } else if (jobCountUpdateUpSum % 5 == 4) {
                    minMv = null;
                    maxMv = NUM_YI_1;
                }
                List<RankBizDataDiff> etfList = EtfControl.listEtfListLastDayByMarketValue(minMv, maxMv);//1、查询etf列表
                String minMvYi = minMv != null ? minMv.divide(NUM_YI_1).setScale(0, BigDecimal.ROUND_HALF_UP) + "" : "0";
                String maxMvYi = maxMv != null ? maxMv.divide(NUM_YI_1).setScale(0, BigDecimal.ROUND_HALF_UP) + "" : "无上限";
                System.out.println(methodName + ",循环次数：" + jobCountUpdateUpSum + ",最低" + minMvYi + "亿，最高" + maxMvYi + "亿：" + etfList.size());
                EtfControl.updateUpSum(date, etfList);//更新-上涨之和
                jobCountUpdateUpSum++;
                if (jobCountUpdateUpSum > 5) {
                    jobSecondsUpdateUpSum = 300;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 3, jobSecondsUpdateUpSum, TimeUnit.SECONDS);

        /**
         * 更新-上涨之和排序
         */
        new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(() -> {
            String methodName = "更新-上涨之和排序（Job）";
            try {
                EtfControl.updateUpSumOrder(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 100, 600, TimeUnit.SECONDS);

        /**
         * 更新-超过均线信息
         */
        new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(() -> {
            try {
                CondStockAdrCount condition = new CondStockAdrCount();
                condition.setDate(date);
                condition.setMaKltList(Arrays.asList(KLT_15, KLT_30, KLT_60, KLT_101, KLT_102));//价格区间周期列表

                List<EtfAdrCountVo> stockAdrCountList = EtfAdrCountService.listStAdrCount(condition);//查询列表-根据条件
                EtfControl.updateUpMa(date, stockAdrCountList, condition);//更新-超过均线信息
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 5, 300, TimeUnit.SECONDS);

        /**
         * 更新-价格区间
         */
        new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(() -> {
            try {
                CondStockAdrCount condition = new CondStockAdrCount();
                condition.setDate(date);
                condition.setMaKltList(Arrays.asList(KLT_15, KLT_30, KLT_60, KLT_101, KLT_102));//价格区间周期列表

                List<EtfAdrCountVo> stockAdrCountList = EtfAdrCountService.listStAdrCount(condition);//查询列表-根据条件
                EtfControl.updateNetArea(date, stockAdrCountList);//更新-价格区间
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 3, 15, TimeUnit.MINUTES);

        /**
         * 更新最近交易日的涨幅，最近3日
         */
        new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(() -> {
            try {
                CondStockAdrCount condition = new CondStockAdrCount();
                condition.setDate(date);
                condition.setMaKltList(Arrays.asList(KLT_15, KLT_30, KLT_60, KLT_101, KLT_102));//价格区间周期列表

                EtfControl.updateLatestDayAdr(condition, date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 4, 60, TimeUnit.MINUTES);
    }

}
