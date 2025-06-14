package ttjj.service;

import com.alibaba.fastjson.JSON;
import ttjj.dao.EtfAdrCountDao;
import ttjj.db.EtfAdrCount;
import ttjj.dto.*;
import ttjj.rank.EtfControl;
import ttjj.rank.FupanControl;
import utils.ContentCookie;
import utils.DateUtil;
import utils.StockUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.logging.Logger;

import static utils.ContEtfTypeName.INDEX_CN_CITY;
import static utils.ContEtfTypeName.JINRONG_CASH;
import static utils.Content.*;

/**
 * ETF涨幅统计
 *
 * @date 2025-02-27 创建
 */
public class EtfAdrCountService {
    private final static Logger logger = Logger.getLogger(EtfAdrCountService.class.getName());


    /**
     * 废弃：可用查询限定字段的方法替代
     * 查询每个类型涨幅排序头部的前n个
     *
     * @param date 日期
     */
    @Deprecated
    public static void findTypeTop(String date) {
        //净值区间最高限定
        CondEtfAdrCount condFiter = new CondEtfAdrCount();//过滤条件
        condFiter.setMaxAdrUpSumOrderStat(new BigDecimal("10"));//涨序排序前n的数据
        BigDecimal limitAdrUpSumOrderStat = new BigDecimal("2");//涨序排序前n个限定
        condFiter.setShowCountTypeGroup(limitAdrUpSumOrderStat.intValue());//每个类型限定n个

        int num = 0;//序号
        // 1、查询数据
        CondEtfAdrCount condition = new CondEtfAdrCount();
        condition.setDate(date);
//        condition.setADR_UP_SUM_40_60(new BigDecimal("1"));
//        condition.setType_name(INDEX_CN_NOT_USA);
//        condition.setTypeNameListNotIn(Arrays.asList(ZIYUAN_OIL));
//        condition.setTypeNameListNotIn(Arrays.asList("资源-石油","指数-外盘-美股","科技-汽车","金融-黄金","指数-外盘","科技-香港","医疗-通用","指数-港股","",""));//过滤类型
        condition.setMaxAdrUpSumOrderStat(limitAdrUpSumOrderStat);
        condition.setOrderBy(F3_DESC);
        List<EtfAdrCountVo> stockAdrCountList = EtfAdrCountService.findEtfList(condition);//查询列表-根据条件
        if (stockAdrCountList == null) {
            System.out.println("数据为null");
            return;
        }
        System.out.println();
        System.out.println("查询超过均线列表：日期：" + date);
    }

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
    public static List<EtfAdrCountVo> listEtfAdrCountLikeName(CondEtfAdrCount condition) {
        boolean isShowLog = false;
        long begTime = System.currentTimeMillis();
        String methodName = "ETF涨幅数据：查询列表，模糊查询：名称列表";
//        if(isShowLog){
//            System.out.println(methodName + "-beg:" + DateUtil.getCurDateStrAddDaysByFormat(DateUtil.YYYY_MM_DD_HH_MM_SS, 0));
//        }
        List<EtfAdrCountVo> rs = EtfAdrCountDao.listEtfAdrCountLikeName(condition);
        if (isShowLog) {
            System.out.println(methodName + "，用时：" + (System.currentTimeMillis() - begTime) / 1000);
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
        if (isShowLog) {
            System.out.println(methodName + DateUtil.getCurDateStrAddDaysByFormat(DateUtil.YYYY_MM_DD_HH_MM_SS, 0) + "，用时：" + new BigDecimal((System.currentTimeMillis() - begTime) / 1000).setScale(2, BigDecimal.ROUND_HALF_UP));
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
     * @param days              日类型
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
                if (kline.getCloseAmt() == null || compMaNet == null) {
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

    /**
     * 查询我的ETF持仓
     *
     * @param date
     * @param condition
     */
    public static void findMyPosition(String date, Integer showCountTypeGroup, String orderField, Integer maxAdrUpSumOrderStat, String cookie, CondEtfAdrCount condition) {
        List<String> zqdmList = FupanControl.queryMyStockAssetPositionZqdm(cookie);//查询-我的股票-资产持仓-证券代码
        findByDateOrderByField(date, orderField, showCountTypeGroup, zqdmList, maxAdrUpSumOrderStat, null, condition);
    }

    /**
     * 查询etf涨幅数据：查询条件：日期，类型，净值区间；
     * 过滤条件：涨序排序前n的数据，每个类型限定n个；
     *
     * @param date
     * @param orderField           排序字段
     * @param zqdmList
     * @param maxAdrUpSumOrderStat
     */
    public static List<EtfAdrCountVo> findByDateOrderByField(String date, String orderField, Integer showCountTypeGroup, List<String> zqdmList, Integer maxAdrUpSumOrderStat, Integer maxAdrUpSumTotalRank, CondEtfAdrCount condition) {
        boolean isShowLog = false;
        long begTime = System.currentTimeMillis();
        String methodName = "ETF涨幅数据-查询-：";
        List<EtfAdrCountVo> rs = null;

        if (date.length() == 8) {
            date = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6);
        }

        List<String> typeNameListNotIn = new ArrayList<>();
        typeNameListNotIn.add(JINRONG_CASH);
        typeNameListNotIn.add(INDEX_CN_CITY);
        List<String> typeNameListNotInOri = condition.getTypeNameListNotIn();
        if (typeNameListNotInOri != null) {
            for (String typeName : typeNameListNotInOri) {
                typeNameListNotIn.add(typeName);
            }
        }
        condition.setTypeNameListNotIn(typeNameListNotIn);

        //净值区间最高限定
        CondEtfAdrCount condFiter = new CondEtfAdrCount();//过滤条件
        condFiter.setMaxAdrUpSumOrderStat(maxAdrUpSumOrderStat == null ? null : new BigDecimal(maxAdrUpSumOrderStat));//涨序排序前n的数据
        condFiter.setShowCountTypeGroup(showCountTypeGroup);//每个类型限定n个

        // 查询条件
//        CondEtfAdrCount condition = new CondEtfAdrCount();
        condition.setDate(date);
//        condition.setADR_UP_SUM_1_60(new BigDecimal("1"));
        condition.setTypeNameListNotIn(typeNameListNotIn);//
        condition.setMaxAdrUpSumTotalRank(maxAdrUpSumTotalRank == null ? null : new BigDecimal(maxAdrUpSumTotalRank));
        condition.setOrderBy(orderField);//ORDER_FIELD_F3   ORDER_FIELD_ADR_UP_SUM_1_60  ORDER_FIELD_NET_AREA_DAY_20     + DB_DESC
        if (zqdmList != null && zqdmList.size() > 0) {
            condition.setStCodeList(zqdmList);
        }
//        condition.setMaxNetAreaDay10(null);//净值区间最高限定
//        condition.setMaxNetAreaDay20(new BigDecimal("30"));//净值区间最高限定
        rs = EtfAdrCountService.findEtfList(condition);//查询列表-根据条件
        if (rs == null) {
            System.out.println("数据为null");
            return null;
        }

        System.out.println(methodName + ",日期：" + date + ",排序字段：" + orderField);
        handlerShowEtfAdr(rs, condFiter);//显示etf涨幅统计列表数据
        return rs;
    }

    /**
     * 显示etf涨幅统计列表数据
     *
     * @param stockAdrCountList etf涨幅统计列表
     * @param condFiter         过滤条件
     */
    private static void handlerShowEtfAdr(List<EtfAdrCountVo> stockAdrCountList, CondEtfAdrCount condFiter) {
        StringBuffer sbHead = new StringBuffer();//首行标题信息
        boolean isShowCode = true;
        sbHead.append(StockUtil.formatStName("名称", SIZE_20));
        if (isShowCode) {
            sbHead.append(StockUtil.formatStName("编码", SIZE_8));
        }
        sbHead.append(StockUtil.formatStName("类型", SIZE_16));
        sbHead.append(StockUtil.formatStName("涨和", SIZE_8));
        sbHead.append(StockUtil.formatStName("涨和排序", SIZE_8));
        sbHead.append(StockUtil.formatStName("1_60和", SIZE_8));
        sbHead.append(StockUtil.formatStName("40_60和", SIZE_8));
        sbHead.append(StockUtil.formatStName("20_40和", SIZE_8));
        sbHead.append(StockUtil.formatStName("1_20和", SIZE_8));
        sbHead.append(StockUtil.formatStName("1_10和", SIZE_8));
        sbHead.append(StockUtil.formatStName("1_5和", SIZE_8));
        sbHead.append(StockUtil.formatStName("1_3和", SIZE_8));
        sbHead.append(StockUtil.formatStName("1_2和", SIZE_8));
        sbHead.append(StockUtil.formatStName("1_1和", SIZE_8));
        sbHead.append(StockUtil.formatStName("上3涨", SIZE_8));
        sbHead.append(StockUtil.formatStName("上2涨", SIZE_8));
        sbHead.append(StockUtil.formatStName("上1涨", SIZE_8));
        sbHead.append(StockUtil.formatStName("今涨", SIZE_10));

        sbHead.append(StockUtil.formatStName("超周", SIZE_8));
        sbHead.append(StockUtil.formatStName("超日", SIZE_8));
        sbHead.append(StockUtil.formatStName("超60", SIZE_8));
        sbHead.append(StockUtil.formatStName("超30", SIZE_8));
        sbHead.append(StockUtil.formatStName("超15", SIZE_8));
        sbHead.append(StockUtil.formatStName("超5", SIZE_8));

        sbHead.append(StockUtil.formatStName("序号", SIZE_6));

        sbHead.append(StockUtil.formatStName("跌周", SIZE_8));
        sbHead.append(StockUtil.formatStName("跌日", SIZE_8));
        sbHead.append(StockUtil.formatStName("跌60", SIZE_8));
        sbHead.append(StockUtil.formatStName("跌30", SIZE_8));
        sbHead.append(StockUtil.formatStName("跌15", SIZE_8));
        sbHead.append(StockUtil.formatStName("跌5", SIZE_8));

        sbHead.append(StockUtil.formatStName("周线比", SIZE_8));
        sbHead.append(StockUtil.formatStName("日线比", SIZE_8));
        sbHead.append(StockUtil.formatStName("60分比", SIZE_8));
        sbHead.append(StockUtil.formatStName("30分比", SIZE_8));
        sbHead.append(StockUtil.formatStName("15分比", SIZE_8));
        sbHead.append(StockUtil.formatStName("5分比", SIZE_8));

        //净值区间
        sbHead.append(StockUtil.formatStName("区间5", SIZE_8));
        sbHead.append(StockUtil.formatStName("区间10", SIZE_8));
        sbHead.append(StockUtil.formatStName("区间20", SIZE_8));
        sbHead.append(StockUtil.formatStName("区间40", SIZE_8));
        sbHead.append(StockUtil.formatStName("区间60", SIZE_8));

        sbHead.append(StockUtil.formatStName("市值", SIZE_8));

        //涨序排序
        sbHead.append(StockUtil.formatStName("40_60序", SIZE_8));
        sbHead.append(StockUtil.formatStName("20_40序", SIZE_8));
        sbHead.append(StockUtil.formatStName("20序", SIZE_8));
        sbHead.append(StockUtil.formatStName("10序", SIZE_8));
        sbHead.append(StockUtil.formatStName("5序", SIZE_8));
        sbHead.append(StockUtil.formatStName("3序", SIZE_8));
        sbHead.append(StockUtil.formatStName("涨序排序", SIZE_10));

        System.out.println(sbHead);//首行标题信息

        int num = 0;//序号
        Map<String, Integer> showTypeLimitCountMap = new HashMap<>();//限定类型个数的键值对
        for (EtfAdrCountVo vo : stockAdrCountList) {
            if (condFiter != null) {
                //过滤1：涨序排序前n的数据
                if (vo.getADR_UP_SUM_ORDER_STAT() != null && condFiter.getMaxAdrUpSumOrderStat() != null && vo.getADR_UP_SUM_ORDER_STAT().compareTo(condFiter.getMaxAdrUpSumOrderStat()) > 0) {
                    continue;
                }
                //过滤2：每个类型限定n个
                if (condFiter.getShowCountTypeGroup() != null && checkShowTypeLimit(vo, condFiter.getShowCountTypeGroup(), showTypeLimitCountMap)) {
                    continue;
                }
            }

            StringBuffer sb = new StringBuffer();
            String zqmc = vo.getF14();
            if (zqmc != null && zqmc.length() > 10) {
                zqmc = zqmc.substring(0, 10);
            }
            sb.append(StockUtil.formatStName(zqmc, SIZE_20));//名称
            sb.append(StockUtil.formatStName(vo.getF12(), SIZE_8));
            sb.append(StockUtil.formatStName(vo.getType_name(), SIZE_16));


            if (vo.getADR_UP_SUM_TOTAL() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_TOTAL(), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_TOTAL_RANK() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_TOTAL_RANK(), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_1_60() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_60().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));//1_60和
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_40_60() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_40_60().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));//40_60和
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_20_40() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_20_40().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_1_20() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_20().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_1_10() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_10().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_1_5() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_5().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_1_3() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_3().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_1_2() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_2().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_1_1() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_1().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }

            //上3涨
            if (vo.getLatestAdr_3() != null) {
                sb.append(StockUtil.formatDouble(vo.getLatestAdr_3().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            //上2涨
            if (vo.getLatestAdr_2() != null) {
                sb.append(StockUtil.formatDouble(vo.getLatestAdr_2().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            //上1涨
            if (vo.getLatestAdr_1() != null) {
                sb.append(StockUtil.formatDouble(vo.getLatestAdr_1().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getF3() != null) {
                sb.append(StockUtil.formatDouble(vo.getF3().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_10));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_10));
            }

            sb.append(StockUtil.formatStName(vo.getUP_MA_102() != null ? vo.getUP_MA_102() : "", SIZE_8));//超周
            sb.append(StockUtil.formatStName(vo.getUP_MA_101() != null ? vo.getUP_MA_101() : "", SIZE_8));
            sb.append(StockUtil.formatStName(vo.getUP_MA_60() != null ? vo.getUP_MA_60() : "", SIZE_8));
            sb.append(StockUtil.formatStName(vo.getUP_MA_30() != null ? vo.getUP_MA_30() : "", SIZE_8));
            sb.append(StockUtil.formatStName(vo.getUP_MA_15() != null ? vo.getUP_MA_15() : "", SIZE_8));
            sb.append(StockUtil.formatStName(vo.getUP_MA_5() != null ? vo.getUP_MA_5() : "", SIZE_8));

            sb.append(StockUtil.formatInt(++num, SIZE_6));//序号

            BigDecimal curAmt = vo.getF2() != null ? vo.getF2() : new BigDecimal("0");
            BigDecimal yesterDayAmt = vo.getF18() != null ? vo.getF18() : new BigDecimal("0");
            BigDecimal maNet102 = vo.getMA_NET_60_102();
            BigDecimal maPct102 = handlerMaPct(curAmt, maNet102);
            BigDecimal maNet101 = vo.getMA_NET_60_101();
            BigDecimal maPct101 = handlerMaPct(curAmt, maNet101);
            BigDecimal maNet60 = vo.getMA_NET_60_60();
            BigDecimal maPct60 = handlerMaPct(curAmt, maNet60);
            BigDecimal maNet30 = vo.getMA_NET_60_30();
            BigDecimal maPct30 = handlerMaPct(curAmt, maNet30);
            BigDecimal maNet15 = vo.getMA_NET_60_15();
            BigDecimal maPct15 = handlerMaPct(curAmt, maNet15);
            BigDecimal maNet5 = vo.getMA_NET_60_5();
            BigDecimal maPct5 = handlerMaPct(curAmt, maNet5);
            //跌周-跌落均线：昨日收盘价高于均线价，当前价格低于均线价
            if (maNet102 != null && maPct102 != null && curAmt.compareTo(maNet102) <= 0 && yesterDayAmt.compareTo(maNet102) >= 0) {
                sb.append(StockUtil.formatDouble(maPct102.setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            // 跌日
            if (maNet101 != null && maPct101 != null && curAmt.compareTo(maNet101) <= 0 && yesterDayAmt.compareTo(maNet101) >= 0) {
                sb.append(StockUtil.formatDouble(maPct101.setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            // 跌60
            if (maNet60 != null && maPct60 != null && curAmt.compareTo(maNet60) <= 0 && yesterDayAmt.compareTo(maNet60) >= 0) {
                sb.append(StockUtil.formatDouble(maPct60.setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            // 跌30
            if (maNet30 != null && maPct30 != null && curAmt.compareTo(maNet30) <= 0 && yesterDayAmt.compareTo(maNet30) >= 0) {
                sb.append(StockUtil.formatDouble(maPct30.setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            // 跌15
            if (maNet15 != null && maPct15 != null && curAmt.compareTo(maNet15) <= 0 && yesterDayAmt.compareTo(maNet15) >= 0) {
                sb.append(StockUtil.formatDouble(maPct15.setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            // 跌5
            if (maNet5 != null && maPct5 != null && curAmt.compareTo(maNet5) <= 0 && yesterDayAmt.compareTo(maNet5) >= 0) {
                sb.append(StockUtil.formatDouble(maPct5.setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }

            //周线比
            if (maNet102 != null && maPct102 != null) {
                sb.append(StockUtil.formatDouble(maPct102.setScale(1, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }

            if (maNet101 != null && maPct101 != null) {
                sb.append(StockUtil.formatDouble(maPct101.setScale(1, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }

            if (maPct60 != null && maPct60 != null) {
                sb.append(StockUtil.formatDouble(maPct60.setScale(1, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }

            if (maNet30 != null && maPct30 != null) {
                sb.append(StockUtil.formatDouble(maPct30.setScale(1, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }

            //15分比
            if (maNet15 != null && maPct15 != null) {
                sb.append(StockUtil.formatDouble(maPct15.setScale(1, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            //5分比
            if (maNet5 != null && maPct5 != null) {
                sb.append(StockUtil.formatDouble(maPct5.setScale(1, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }

            //净值区间
            BigDecimal curArea = vo.getNET_AREA_DAY_5();
            if (curArea != null) {
                sb.append(StockUtil.formatDouble(curArea.setScale(0, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            curArea = vo.getNET_AREA_DAY_10();
            if (curArea != null) {
                sb.append(StockUtil.formatDouble(curArea.setScale(0, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            curArea = vo.getNET_AREA_DAY_20();
            if (curArea != null) {
                sb.append(StockUtil.formatDouble(curArea.setScale(0, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            curArea = vo.getNET_AREA_DAY_40();
            if (curArea != null) {
                sb.append(StockUtil.formatDouble(curArea.setScale(0, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            curArea = vo.getNET_AREA_DAY_60();
            if (curArea != null) {
                sb.append(StockUtil.formatDouble(curArea.setScale(0, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }

            BigDecimal marketValue = null;
            if (vo.getF20() != null) {
                marketValue = vo.getF20().divide(NUM_YI_1, 2, BigDecimal.ROUND_HALF_UP);
            }
            sb.append(StockUtil.formatDouble(marketValue, SIZE_8));

            //40_60序
            if (vo.getADR_UP_SUM_ORDER_40_60() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_ORDER_40_60(), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_ORDER_20_40() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_ORDER_20_40(), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_ORDER_1_20() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_ORDER_1_20(), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_ORDER_1_10() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_ORDER_1_10(), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_ORDER_1_5() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_ORDER_1_5(), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_ORDER_1_3() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_ORDER_1_3(), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            if (vo.getADR_UP_SUM_ORDER_STAT() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_ORDER_STAT(), SIZE_10));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_10));
            }

            System.out.println(sb);
        }
    }

    /**
     * 检查限定类型个数显示
     *
     * @param vo                    检查对象
     * @param showTypeLimitCount    限定个数
     * @param showTypeLimitCountMap 限定个数已有键值对
     */
    private static boolean checkShowTypeLimit(EtfAdrCountVo vo, int showTypeLimitCount, Map<String, Integer> showTypeLimitCountMap) {
        String typeName = vo.getType_name();
        Integer typeCount = showTypeLimitCountMap.get(typeName);
        if (typeCount == null) {
            showTypeLimitCountMap.put(typeName, 1);
        } else {
            showTypeLimitCountMap.put(typeName, ++typeCount);
            if (typeCount > showTypeLimitCount) {
//                        System.out.println(typeName + ",个数：" + typeCount + ",超过限定个数" + showTypeLimitCount + "，则不显示");
                return true;
            }
        }
        return false;

    }

    /**
     * 计算均线百分比
     *
     * @param curAmt
     * @param maNet
     * @return
     */
    private static BigDecimal handlerMaPct(BigDecimal curAmt, BigDecimal maNet) {
        BigDecimal maPct = null;
        if (curAmt == null) {
//            System.out.println("当前价null");
            return null;
        }
        if (maNet == null) {
//            System.out.println("均线价null");
            return null;
        }
        maPct = curAmt.subtract(maNet).divide(maNet, 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_UP);
        return maPct;
    }

    public static void main(String[] args) {
        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
        List<String> zqdmList = FupanControl.queryMyStockAssetPositionZqdm(ContentCookie.COOKIE_DFCF);//查询-我的股票-资产持仓-证券代码
        findByDateOrderByField(date, NET_AREA_DAY_20, null, zqdmList, 100, null, null);
//        EtfAdrCountService.findMyPosition(date, null, NET_AREA_DAY_20, null);
    }

}
