package ttjj.service;

import com.alibaba.fastjson.JSON;
import ttjj.dao.EtfAdrCountDao;
import ttjj.db.EtfAdrCount;
import ttjj.dto.*;
import utils.DateUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;
import static utils.Content.*;

/**
 * ETF涨幅统计
 * @date 2025-02-27 创建
 */
public class EtfAdrCountService {
    private final static Logger logger = Logger.getLogger(EtfAdrCountService.class.getName());

    /**
     * 批量插入
     *
     * @param stockAdrCount
     * @return
     */
    public static Integer insert(EtfAdrCount stockAdrCount) {
        return EtfAdrCountDao.insert(stockAdrCount);
    }

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    public static Integer insertList(List<EtfAdrCount> list) {
        Integer rs = 0;
        if (list == null) {
            return rs;
        }
        for (EtfAdrCount stockAdrCount : list) {
            /**
             * 插入数据库-K线
             */
            int rsSave = EtfAdrCountDao.insert(stockAdrCount);
            //打印保存成功的记录
            if (rsSave > 0) {
                logger.info("保存成功的记录：" + JSON.toJSONString(stockAdrCount));
                rs += rsSave;
            }
        }
        return rs;
    }

    /**
     * 批量插入-先查询是否存在，如果不存在时再插入
     *
     * @param list
     * @return
     */
    public static Integer insertListBeforeFind(List<EtfAdrCount> list) {
        Integer rs = 0;
        if (list == null) {
            return rs;
        }
        for (EtfAdrCount stockAdrCount : list) {
            EtfAdrCount entity = EtfAdrCountDao.findByCondition(stockAdrCount);
            if (entity != null) {
//                logger.info("记录已存在：" + stockAdrCount.getF14());
//                System.out.println("记录已存在：" + stockAdrCount.getF14());
                continue;
            }
            /**
             * 插入数据库-K线
             */
            int rsSave = EtfAdrCountDao.insert(stockAdrCount);
            //打印保存成功的记录
            if (rsSave > 0) {
//                logger.info("保存成功的记录：" + JSON.toJSONString(stockAdrCount));
//                System.out.println("保存成功的记录：" + stockAdrCount.getF14() + JSON.toJSONString(stockAdrCount));
                rs += rsSave;
            }
        }
        return rs;
    }


    /**
     * 批量插入：插入之前先查询是否存在(日期和code)，如果存在则先删除再插入
     *
     * @param list
     * @return
     */
    public static Integer insertListOrUpdate(List<EtfAdrCount> list) {
        Integer rs = 0;
        if (list == null) {
            return rs;
        }
        for (EtfAdrCount stockAdrCount : list) {
            EtfAdrCount entity = EtfAdrCountDao.findByCondition(stockAdrCount);
            if (entity != null) {
                int deleRs = EtfAdrCountDao.deleteByCondition(entity);
                System.out.println("数据已存在，先删除:" + deleRs + ";");//+ JSON.toJSONString(entity)
            }
            //插入数据库-K线
            rs += EtfAdrCountDao.insert(stockAdrCount);
        }
//        System.out.println("批量插入:" + rs);
        return rs;
    }

    /**
     * ETF涨幅数据：查询列表，模糊查询：名称列表
     *
     * @param condition condition
     * @return rs
     */
    public static List<EtfAdrCountVo> listEtfAdrCountLikeName(CondStockAdrCount condition) {
        boolean isShowLog = false;
        long begTime = System.currentTimeMillis();
        String methodName = "ETF涨幅数据：查询列表，模糊查询：名称列表";
//        if(isShowLog){
//            System.out.println(methodName + "-beg:" + DateUtil.getCurDateStrAddDaysByFormat(DateUtil.YYYY_MM_DD_HH_MM_SS, 0));
//        }
        List<EtfAdrCountVo> rs = EtfAdrCountDao.listEtfAdrCountLikeName(condition);
        if(isShowLog){
            System.out.println(methodName   + "，用时：" + (System.currentTimeMillis() - begTime) / 1000);
        }
        return rs;
    }

    /**
     * ETF涨幅数据：查询列表，根据条件
     *
     * @param condition condition
     * @return rs
     */
    public static List<EtfAdrCountVo> findEtfList(CondEtfAdrCount condition) {
        boolean isShowLog = false;
        long begTime = System.currentTimeMillis();
        String methodName = "ETF涨幅数据：查询列表";
//        if(isShowLog){
//            System.out.println(methodName + "-beg:" + DateUtil.getCurDateStrAddDaysByFormat(DateUtil.YYYY_MM_DD_HH_MM_SS, 0));
//        }
        List<EtfAdrCountVo> rs = EtfAdrCountDao.findEtfList(condition);
        if(isShowLog){
            System.out.println(methodName  + DateUtil.getCurDateStrAddDaysByFormat(DateUtil.YYYY_MM_DD_HH_MM_SS, 0) + "，用时：" + new BigDecimal((System.currentTimeMillis() - begTime) / 1000).setScale(2,BigDecimal.ROUND_HALF_UP));
        }
        return rs;
    }

    /**
     * 更新
     *
     * @param stockAdrCount 更新内容和条件
     * @return 结果
     */
    public static Integer update(EtfAdrCount stockAdrCount) {
        return EtfAdrCountDao.update(stockAdrCount);
    }

    /**
     * 查询日净值数据:查询日k线
     *
     * @param stockAdrCountList 涨幅列表
     * @param date              日期
     * @param days           日类型
     * @param compMaType        比较均线类型
     * @param condFind
     */
    public static void handlerNetDay(List<StockAdrCountVo> stockAdrCountList, String date, int days, String compMaType, CondStockAdrCount condFind) {
        if (stockAdrCountList == null) {
            return;
        }
        if (KLT_102.equals(compMaType) && !condFind.isShowMaWeekCountUpDown()) {
            return;
        }
        if (KLT_101.equals(compMaType) && !condFind.isShowMaDayCountUpDown()) {
            return;
        }
        String endDate = date;
        String begDate = StockService.findBegDate(date, days);
        for (StockAdrCountVo stockAdrCountVo : stockAdrCountList) {
            List<Kline> klines = KlineService.kline(stockAdrCountVo.getF12(), days, KLT_101, true, begDate, endDate, KLINE_TYPE_STOCK);
            if (klines == null) {
                continue;
            }
            stockAdrCountVo.setNetDayLast20(klines);

            //比较净值，计算超过次数、低于次数
            int countUpNet = 0;
            int countDownNet = 0;
            BigDecimal compMaNet = null;
            if (KLT_102.equals(compMaType)) {
                compMaNet = stockAdrCountVo.getMA_NET_60_102();
            } else if (KLT_101.equals(compMaType)) {
                compMaNet = stockAdrCountVo.getMA_NET_60_101();
            }
            for (Kline kline : klines) {
                if (kline.getCloseAmt() == null || compMaNet==null) {
                    continue;
                }
                if (kline.getCloseAmt().compareTo(compMaNet) >= 0) {
                    countUpNet++;
                } else {
                    countDownNet++;
                }
            }
            if (KLT_102.equals(compMaType)) {
                if (DAY_20 == days) {
                    stockAdrCountVo.setCountUpMa102Type60LastDay20(countUpNet);
                    stockAdrCountVo.setCountDownMa102Type60LastDay20(countDownNet);
                }
                if (DAY_10 == days) {
                    stockAdrCountVo.setCountUpMa102Type60LastDay10(countUpNet);
                    stockAdrCountVo.setCountDownMa102Type60LastDay10(countDownNet);
                }
            }
            if (KLT_101.equals(compMaType)) {
                if (DAY_20 == days) {
                    stockAdrCountVo.setCountUpMa101Type60LastDay20(countUpNet);
                    stockAdrCountVo.setCountDownMa101Type60LastDay20(countDownNet);
                }
                if (DAY_10 == days) {
                    stockAdrCountVo.setCountUpMa101Type60LastDay10(countUpNet);
                    stockAdrCountVo.setCountDownMa101Type60LastDay10(countDownNet);
                }
            }
        }
    }
}
