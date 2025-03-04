package ttjj.rank.stat.schedule;

import ttjj.dto.CondStockAdrCount;
import ttjj.dto.EtfAdrCountVo;
import ttjj.dto.RankBizDataDiff;
import ttjj.rank.EtfControl;
import ttjj.service.EtfAdrCountService;
import utils.DateUtil;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static utils.Content.*;

/**
 * 定时任务-etf涨幅统计
 */
public class EtfAdrJob {
    public static void main(String[] args) {
        statShowEtfAdrCountSchedule();
    }

    /**
     * 定时任务-etf涨幅统计
     */
    private static void statShowEtfAdrCountSchedule() {
        /**
         * 更新基础信息
         */
        new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(() -> {
            String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//            String date = "2025-03-03";
            try {
                CondStockAdrCount condition = new CondStockAdrCount();
                condition.setDate(date);
                EtfControl.saveOrUpdateListNetLastDay(condition, date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 5, TimeUnit.MINUTES);


        /**
         * 更新-上涨之和
         */
        new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(() -> {
            String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//            String date = "2025-03-03";
            try {
                List<RankBizDataDiff> etfList = EtfControl.listEtfListLastDay(null);//1、查询etf列表
                EtfControl.updateUpSum(date, etfList);//更新-上涨之和
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 1, 10, TimeUnit.MINUTES);

        /**
         * 更新-超过均线信息
         */
        new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(() -> {
            String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//            String date = "2025-03-03";
            try {
                CondStockAdrCount condition = new CondStockAdrCount();
                condition.setDate(date);
//        condition.setMvMin(NUM_YI_100);
//        condition.setMvMax(NUM_YI_1000);
                condition.setMaKltList(Arrays.asList(KLT_15, KLT_30, KLT_60, KLT_101, KLT_102));//价格区间周期列表

                List<EtfAdrCountVo> stockAdrCountList = EtfAdrCountService.listStAdrCount(condition);//查询列表-根据条件
                EtfControl.updateUpMa(date, stockAdrCountList, condition);//更新-超过均线信息
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 2, 10, TimeUnit.MINUTES);

        /**
         * 更新-价格区间
         */
        new ScheduledThreadPoolExecutor(1).scheduleAtFixedRate(() -> {
            String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//            String date = "2025-03-03";
            try {
                CondStockAdrCount condition = new CondStockAdrCount();
                condition.setDate(date);
//        condition.setMvMin(NUM_YI_100);
//        condition.setMvMax(NUM_YI_1000);
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
            String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//            String date = "2025-03-03";
            try {
                CondStockAdrCount condition = new CondStockAdrCount();
                condition.setDate(date);
//        condition.setMvMin(NUM_YI_100);
//        condition.setMvMax(NUM_YI_1000);
                condition.setMaKltList(Arrays.asList(KLT_15, KLT_30, KLT_60, KLT_101, KLT_102));//价格区间周期列表

                EtfControl.updateLatestDayAdr(condition, date);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 4, 60, TimeUnit.MINUTES);
    }

}
