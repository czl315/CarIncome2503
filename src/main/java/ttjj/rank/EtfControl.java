package ttjj.rank;

import com.alibaba.fastjson.JSON;
import ttjj.db.EtfAdrCount;
import ttjj.db.RankStockCommpanyDb;
import ttjj.dto.*;
import ttjj.service.*;
import utils.DateUtil;
import utils.StockUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import static utils.ContEtfNameKey.*;
import static utils.ContMapEtfAll.ETF_All;
import static utils.Content.*;

/**
 * ETF涨幅统计
 * 查询etf列表
 * 保存：查询etf列表，批量插入
 * 更新-上涨之和
 * 更新-超过均线信息
 * <p>
 * 数据分析
 * 1、查询每日涨幅最多的Etf
 * 2、均线突破：周、日、60
 * 3、
 */
public class EtfControl {
    static int jobCountUpdateUpSum = 0;

    public static void main(String[] args) {
//        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
        String date = "2025-03-14";
        String today = DateUtil.getToday(DateUtil.YYYY_MM_DD);
        if (!date.equals(today)) {
            System.out.println("注意！！！非今日数据");
        }
//        insertList(date);//保存：查询etf列表，批量插入。250228：1054

        CondStockAdrCount condition = new CondStockAdrCount();
        condition.setDate(date);
//        condition.setMvMin(NUM_YI_100);
//        condition.setMvMax(NUM_YI_1000);
//        condition.setMaKltList(Arrays.asList(KLT_15, KLT_30, KLT_60, KLT_101, KLT_102));//价格区间周期列表

//        saveOrUpdateListNetLastDay(condition, date);//保存或更新ETF涨幅次数-批量更新基础信息
//        List<RankBizDataDiff> etfList = listEtfListLastDayByMarketValue(null, null);//1、查询etf列表
//        updateUpSum(date, etfList);//更新-上涨之和
        updateUpSumOrder(date);
//        List<EtfAdrCountVo> stockAdrCountList = EtfAdrCountService.listStAdrCount(condition);//查询列表-根据条件
//        updateUpMa(date, stockAdrCountList, condition);//更新-超过均线信息
//        updateNetArea(date, stockAdrCountList);//更新-价格区间
//        updateLatestDayAdr(condition, date);


//        condition.setLikeNameList(ContEtfNameKey.ETF_NAME_NAME_LIST_LIKE_CN_HK);//港股指数
//        condition.setLikeNameList(ContEtfNameKey.ETF_NAME_NAME_LIST_LIKE_KEJI_XIN_PIAN);//科技-芯片
//        condition.setLikeNameList(ContEtfNameKey.ETF_NAME_NAME_LIST_LIKE_KEJI_RUAN_JIAN);//科技-软件
//        condition.setLikeNameList(ContEtfNameKey.ETF_NAME_NAME_LIST_LIKE_XIAO_FEI_HK);//
//        condition.setLikeNameList(ContEtfNameKey.INDEX_CN_NOT_NSDK);

//        condition.setLikeNameList(XIAOFEI_FOOD);
//        condition.setLikeNameList(XIAOFEI_HK);
//        condition.setLikeNameList(XIAOFEI_COMMON);
//        condition.setNotLikeNameList(XIAOFEI_HK);

//        condition.setNotLikeNameList(JINRONG);
        condition.setLikeNameList(JINRONG_ZHENGQUAN);


//        condition.setLikeNameList(YILIAO_COMMON);
//        condition.setLikeNameList(YILIAO_CN_MEDICINE);

//        condition.setLikeNameList(INDEX_CN_NOT);

//        condition.setNotLikeNameList(INDEX_300_NOLIKE);

//        condition.setOrderBy(ORDER_FIELD_ADR_UP_SUM_1_10 + DB_DESC);
//        List<EtfAdrCountVo> etfListLikeName = EtfAdrCountService.listEtfAdrCountLikeName(condition);//查询列表，模糊查询：名称列表
//        showStat(etfListLikeName, "JINRONG_ZHENGQUAN", "金融-证券");
//        saveOrUpdateListNetLastDay(condition, date);//保存或更新ETF涨幅次数-批量更新基础信息

//        showStatSimpleByTypeAll();

//        condition.setLikeNameList(Arrays.asList("创业","创大盘","创中盘","创300","创400"));//创业板："创业","创大盘","创中盘","创300","创400"
//        condition.setNotLikeNameList(Arrays.asList("人工智能","科创创业"));
//        condition.setLikeNameList(Arrays.asList("科创","双创"));//科创板：
//        condition.setNotLikeNameList(Arrays.asList("科创芯片","科创信息","科创AI"));//科创板：
//        condition.setLikeNameList(Arrays.asList("标普", "纳", "道", "德", "亚", "沙特","法国", "日经", "日本"));//非国内
//        condition.setLikeNameList(Arrays.asList("2000","1000","800","500","民企","中小100"));//国内指数-中小盘："2000","1000","800","500","民企","中小100"
//        condition.setLikeNameList(Arrays.asList("300"));//沪深300：
//        condition.setNotLikeNameList(Arrays.asList("创300","沪港深300"));//沪深300：
//        condition.setLikeNameList(Arrays.asList("证50","A50"));//上证50：
//        condition.setNotLikeNameList(Arrays.asList("500","深证50"));//上证50：
        //        condition.setLikeNameList(Arrays.asList("上证", "上证指数", "上证综合"));//上证指数：
//        condition.setNotLikeNameList(Arrays.asList("50", "80", "券商"));//上证指数：

    }

    /**
     * 查询单一数据，全部类型
     */
    private static void showStatSimpleByTypeAll() {
        List<List<String>> etfNameList = Arrays.asList(XIAOFEI_WINE, ZIYUAN_NONGYE);
        for (List<String> etfName : etfNameList) {
            CondStockAdrCount condition = new CondStockAdrCount();
            condition.setDate(DateUtil.getToday(DateUtil.YYYY_MM_DD));
            condition.setLimitCount(1);
            condition.setOrderBy(ORDER_FIELD_ADR_UP_SUM_1_10 + DB_DESC);

            condition.setLikeNameList(etfName);

            List<EtfAdrCountVo> etfListLikeName = EtfAdrCountService.listEtfAdrCountLikeName(condition);//查询列表，模糊查询：名称列表

            showStat(etfListLikeName, "KEJI_MORE", "");
        }

    }

    /**
     * ETF涨幅数据：统计数据，模糊查询：名称列表
     *
     * @param etfListLikeName etf列表
     * @param typeEn          类型英文
     * @param typeCn          类型中文
     */
    private static void showStat(List<EtfAdrCountVo> etfListLikeName, String typeEn, String typeCn) {
        if (etfListLikeName == null) {
            System.out.println("数据为null");
        }
        int size6 = 6;
        int size10 = 10;
        int size22 = 22;
        int num = 0;//序号
        for (EtfAdrCountVo vo : etfListLikeName) {
            StringBuffer sb = new StringBuffer();
            sb.append(typeEn + ".put(\"").append(StockUtil.formatStName(vo.getF12(), size6)).append("\"");
            sb.append(", \"" + StockUtil.formatStName(typeCn, size22) + "\");");
//            sb.append(", \"" + StockUtil.formatStName(vo.getF14(), size22) + "\");");
            sb.append("//");
            sb.append(StockUtil.formatStName(vo.getF14(), size22));
            sb.append(StockUtil.formatStName("市值：", size6));
            BigDecimal marketValue = null;
            if (vo.getF20() != null) {
                marketValue = vo.getF20().divide(NUM_YI_1, 2, BigDecimal.ROUND_HALF_UP);
            }
            sb.append(StockUtil.formatDouble(marketValue, size10));
            sb.append(StockUtil.formatStName("累涨：", size6));
            if (vo.getADR_UP_SUM_1_60() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_60().setScale(2, BigDecimal.ROUND_HALF_UP), size10));
            } else {
                sb.append(StockUtil.formatStName("", size10));
            }
            if (vo.getADR_UP_SUM_40_60() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_40_60().setScale(2, BigDecimal.ROUND_HALF_UP), size10));
            } else {
                sb.append(StockUtil.formatStName("", size10));
            }
            if (vo.getADR_UP_SUM_20_40() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_20_40().setScale(2, BigDecimal.ROUND_HALF_UP), size10));
            } else {
                sb.append(StockUtil.formatStName("", size10));
            }
            if (vo.getADR_UP_SUM_1_20() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_20().setScale(2, BigDecimal.ROUND_HALF_UP), size10));
            } else {
                sb.append(StockUtil.formatStName("", size10));
            }
            if (vo.getADR_UP_SUM_1_10() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_10().setScale(2, BigDecimal.ROUND_HALF_UP), size10));
            } else {
                sb.append(StockUtil.formatStName("", size10));
            }
            if (vo.getADR_UP_SUM_1_5() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_5().setScale(2, BigDecimal.ROUND_HALF_UP), size10));
            } else {
                sb.append(StockUtil.formatStName("", size10));
            }

            sb.append(StockUtil.formatInt(++num, size6));
            System.out.println(sb);
        }
    }

    /**
     * ETF涨幅统计：更新最近交易日的涨幅，最近3日
     *
     * @param condition 条件
     */
    public static void updateLatestDayAdr(CondStockAdrCount condition, String date) {
        String methodName = "保存或更新ETF涨幅次数-批量更新基础信息";
        boolean isShowLog = true;
        long begTime = System.currentTimeMillis();
        String klineType = DB_RANK_BIZ_TYPE_ETF;

        List<EtfAdrCount> etfAdrCountList = new ArrayList<>();
        //1、查询etf列表
        List<RankBizDataDiff> etfList = listEtfListLastDay();
        for (RankBizDataDiff etf : etfList) {
            int days = 4;
            //市值过滤
            BigDecimal marketValue = etf.getF20();
            BigDecimal mvMin = condition.getMvMin();
            BigDecimal mvMax = condition.getMvMax();
            if (handlerMarketValueFilter(marketValue, mvMin, mvMax)) {
                continue;
            }

            EtfAdrCount entity = new EtfAdrCount();
            entity.setDate(date);
            entity.setF12(etf.getF12());

            //显示指定日期最近3个K线交易日的涨跌
            StringBuffer sbDaysAdr = new StringBuffer();
            String zqdm = etf.getF12();
            List<Kline> klineListDays = KlineService.kline(zqdm, days, KLT_101, false, null, date, klineType);
            if (klineListDays != null) {
                for (Kline klineListDay : klineListDays) {
                    if (days == 4) {
                        entity.setLatestAdr_3(klineListDay.getZhangDieFu());
                    }
                    if (days == 3) {
                        entity.setLatestAdr_2(klineListDay.getZhangDieFu());
                    }
                    if (days == 2) {
                        entity.setLatestAdr_1(klineListDay.getZhangDieFu());
                    }
                    if (days == 1) {
                        break;
                    }
                    days--;
                }
            }
            entity.setUPDATE_TIME(new Date());

            etfAdrCountList.add(entity);
        }

        int updateCount = 0;
        for (EtfAdrCount etfAdrCount : etfAdrCountList) {
//            if(etfAdrCount.getF14().equals("上证50ETF")){
//                System.out.println(funcName + "更新-特定：" + JSON.toJSONString(etfAdrCount));
//            }
            int updateRs = EtfAdrCountService.update(etfAdrCount);
            if (updateRs != 1) {
                System.out.println(methodName + "更新-失败：" + updateRs + "" + JSON.toJSONString(etfAdrCount));
                System.out.println(methodName + "如果更新失败，可能是没有插入，执行一次插入操作：" + EtfAdrCountService.insert(etfAdrCount));
            } else {
                updateCount++;
            }
        }
        if (isShowLog) {
            System.out.println(methodName + "-需要更新个数:" + etfAdrCountList.size() + ",更新成功个数：" + updateCount + "end,用时：" + (System.currentTimeMillis() - begTime) / 1000);
        }
    }

    /**
     * 保存或更新ETF涨幅次数-批量更新基础信息
     * 如果更新失败，可能是没有插入，执行一次插入操作
     * 更新类型
     *
     * @param condition 市值限定
     * @param date      日期
     * @return 结果
     */
    public static void saveOrUpdateListNetLastDay(CondStockAdrCount condition, String date) {
        long begTime = System.currentTimeMillis();
        boolean isShowLog = true;
        String methodName = "保存或更新ETF涨幅次数-批量更新基础信息";

        List<EtfAdrCount> etfAdrCountList = new ArrayList<>();
        //1、查询etf列表
        List<RankBizDataDiff> etfList = listEtfListLastDay();
        for (RankBizDataDiff etf : etfList) {
            //市值过滤
            BigDecimal marketValue = etf.getF20();
            BigDecimal mvMin = condition.getMvMin();
            BigDecimal mvMax = condition.getMvMax();
            if (handlerMarketValueFilter(marketValue, mvMin, mvMax)) {
                continue;
            }

            String code = etf.getF12();
            EtfAdrCount entity = new EtfAdrCount();
            entity.setDate(date);
            entity.setF12(code);

            if (etf.getF2() != null) {
                entity.setF2(etf.getF2());
            }
            entity.setF3(etf.getF3());
            if (etf.getF4() != null) {
                entity.setF4(new BigDecimal(etf.getF4()));
            }
            entity.setF5(etf.getF5());
            entity.setF6(etf.getF6());
            if (etf.getF7() != null) {
                entity.setF7(new BigDecimal(etf.getF7()));
            }
            if (etf.getF8() != null) {
                entity.setF8(new BigDecimal(etf.getF8()));
            }
            if (etf.getF9() != null) {
                entity.setF9(new BigDecimal(etf.getF9()));
            }
            if (etf.getF10() != null) {
                entity.setF10(BigDecimal.valueOf(etf.getF10()));
            }
            entity.setF14(etf.getF14());
            if (etf.getF15() != null) {
                entity.setF15(new BigDecimal(etf.getF15().toString()));
            }
            if (etf.getF16() != null) {
                entity.setF16(new BigDecimal(etf.getF16().toString()));
            }
            if (etf.getF17() != null) {
                entity.setF17(new BigDecimal(etf.getF17().toString()));
            }
            if (etf.getF18() != null) {
                entity.setF18(new BigDecimal(etf.getF18().toString()));
            }
            entity.setF20(etf.getF20());
            entity.setF62(etf.getF62());
            entity.setF21(etf.getF21());
            entity.setUPDATE_TIME(new Date());

            BigDecimal curAmt = etf.getF2();
            BigDecimal maxAmt = etf.getF15();
            BigDecimal minAmt = etf.getF16();
            BigDecimal yesterdayAmt = etf.getF18();
            entity.setMaxDown(StockUtil.handlerMaxDown(curAmt, maxAmt));//计算最大回撤
            if (curAmt != null && minAmt != null) {
                BigDecimal minRise = curAmt.subtract(minAmt).divide(minAmt, 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP);
                entity.setMinRise(minRise);
            }
            if (maxAmt != null && yesterdayAmt != null) {
                BigDecimal maxPct = maxAmt.subtract(yesterdayAmt).divide(yesterdayAmt, 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_UP);
                entity.setMaxPct(maxPct);
            }
            if (minAmt != null && yesterdayAmt != null) {
                BigDecimal minPct = minAmt.subtract(yesterdayAmt).divide(yesterdayAmt, 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_UP);
                entity.setMinPct(minPct);
            }

            //更新类型
            String type = ETF_All.get(code);
            if (type != null) {
                type = type.replace(" ", "");
                entity.setType_name(type);
            }

            etfAdrCountList.add(entity);
        }

        int rsCountUpdate = 0;
        int rsCountInsert = 0;
        for (EtfAdrCount etfAdrCount : etfAdrCountList) {
//            if(etfAdrCount.getF14().equals("上证50ETF")){
//                System.out.println(funcName + "更新-特定：" + JSON.toJSONString(etfAdrCount));
//            }
            int updateRs = EtfAdrCountService.update(etfAdrCount);
            if (updateRs != 1) {
                rsCountInsert = rsCountInsert + EtfAdrCountService.insert(etfAdrCount);
//                System.out.println(methodName + "更新-失败：" + rs + "" + JSON.toJSONString(etfAdrCount));
//                System.out.println(methodName + "如果更新失败，可能是没有插入，执行一次插入操作：" + rsCountInsert);
            } else {
                rsCountUpdate++;
            }
        }
        if (isShowLog) {
            System.out.println(methodName + "，用时：" + (System.currentTimeMillis() - begTime) / 1000 + ",更新成功：" + rsCountUpdate + ",插入成功：：" + rsCountInsert);
        }

    }

    /**
     * 市值过滤
     * 1、市值为空，不过滤
     * 2、市值低于最低限定市值，过滤
     * 3、市值高于最低限定市值，过滤
     *
     * @param marketValue marketValue
     * @param mvMin       mvMin
     * @param mvMax       mvMax
     * @return
     */
    private static boolean handlerMarketValueFilter(BigDecimal marketValue, BigDecimal mvMin, BigDecimal mvMax) {
//        if(name.equals("上证50ETF1111")){
//            System.out.println("更新-特定：" + JSON.toJSONString(name));
//        }
        if (marketValue == null) {
            return false;
        }
        if (mvMin != null && marketValue.compareTo(mvMin) < 0) {
//            System.out.println("市值过滤(低于最低限定市值)：实际市值/市值限定:" + marketValue.divide(NUM_YI_1, 2, BigDecimal.ROUND_HALF_UP) + "<" + (mvMin == null ? null : mvMin.divide(NUM_YI_1)));
            return true;
        }
        if ((mvMax != null && marketValue.compareTo(mvMax) > 0)) {
            System.out.println("市值过滤(高于最高限定市值)：实际市值/市值限定:" + marketValue.divide(NUM_YI_1, 2, BigDecimal.ROUND_HALF_UP) + ">" + (mvMax == null ? null : mvMax.divide(NUM_YI_1)));
            return true;
        }
        return false;
    }

    /**
     * 保存：查询etf列表，批量插入
     * 1、查询etf列表：一页最多查询n条，需要分多次查询
     * 2、批量插入：先查询是否存在，如果不存在时再插入
     *
     * @param date 日期
     * @return 结果
     */
    private static List<EtfAdrCount> insertList(String date) {

        //1、查询etf列表
        List<RankBizDataDiff> etfList = listEtfListLastDay();

        //批量插入：先查询是否存在，如果不存在时再插入
        List<EtfAdrCount> etfAdrCountList = new ArrayList<>();
        for (RankBizDataDiff rankStockCommpanyDb : etfList) {

            EtfAdrCount entity = new EtfAdrCount();
            entity.setDate(date);
            entity.setF139(rankStockCommpanyDb.getF139());
            if (rankStockCommpanyDb.getF2() != null) {
                entity.setF2(rankStockCommpanyDb.getF2());
            }
            entity.setF3(rankStockCommpanyDb.getF3());
            if (rankStockCommpanyDb.getF4() != null) {
                entity.setF4(new BigDecimal(rankStockCommpanyDb.getF4()));
            }
            entity.setF5(rankStockCommpanyDb.getF5());
            entity.setF6(rankStockCommpanyDb.getF6());
            if (rankStockCommpanyDb.getF7() != null) {
                entity.setF7(new BigDecimal(rankStockCommpanyDb.getF7()));
            }
            if (rankStockCommpanyDb.getF8() != null) {
                entity.setF8(new BigDecimal(rankStockCommpanyDb.getF8()));
            }
            if (rankStockCommpanyDb.getF9() != null) {
                entity.setF9(new BigDecimal(rankStockCommpanyDb.getF9()));
            }
            if (rankStockCommpanyDb.getF10() != null) {
                entity.setF10(BigDecimal.valueOf(rankStockCommpanyDb.getF10()));
            }
            entity.setF12(rankStockCommpanyDb.getF12());
            entity.setF14(rankStockCommpanyDb.getF14());
            if (rankStockCommpanyDb.getF15() != null) {
                entity.setF15(new BigDecimal(rankStockCommpanyDb.getF15().toString()));
            }
            if (rankStockCommpanyDb.getF16() != null) {
                entity.setF16(new BigDecimal(rankStockCommpanyDb.getF16().toString()));
            }
            if (rankStockCommpanyDb.getF17() != null) {
                entity.setF17(new BigDecimal(rankStockCommpanyDb.getF17().toString()));
            }
            if (rankStockCommpanyDb.getF18() != null) {
                entity.setF18(new BigDecimal(rankStockCommpanyDb.getF18().toString()));
            }
            entity.setF20(rankStockCommpanyDb.getF20());
            entity.setF21(rankStockCommpanyDb.getF21());
            entity.setF62(rankStockCommpanyDb.getF62());

            etfAdrCountList.add(entity);
        }

//        System.out.println(bizName + ",涨幅次数统计,插入成功/总数量：" + EtfAdrCountService.insertList(stockAdrCountList) + "：" + stList.size());
        System.out.println(",涨幅次数统计,插入成功/总数量：" + EtfAdrCountService.insertListBeforeFind(etfAdrCountList) + "：" + etfAdrCountList.size());
        return etfAdrCountList;
    }

    /**
     * 更新-价格区间
     *
     * @param date              日期
     * @param stockAdrCountList 更新列表
     */
    public static void updateNetArea(String date, List<EtfAdrCountVo> stockAdrCountList) {
        boolean isShowLog = true;
        long begTime = System.currentTimeMillis();
        String methodName = "ETF涨幅数据：更新-价格区间";

        int updateRs = 0;//更新成功个数
        if (stockAdrCountList == null) {
            System.out.println(methodName + "没有数据需要更新，stockAdrCountList==null");
            return;
        }
        for (EtfAdrCountVo stockAdrCount : stockAdrCountList) {
            EtfAdrCount entity = new EtfAdrCount();
            String zqdm = stockAdrCount.getF12();
            entity.setF12(zqdm);
            entity.setDate(stockAdrCount.getDate());
            entity.setUPDATE_TIME(new Date());

            //处理价格区间
            entity.setNET_AREA_DAY_5(KlineService.handlerPriceAreaRate(zqdm, MA_5, KLT_101, false, "", date, KLINE_TYPE_STOCK));
            entity.setNET_AREA_DAY_10(KlineService.handlerPriceAreaRate(zqdm, MA_10, KLT_101, false, "", date, KLINE_TYPE_STOCK));
            entity.setNET_AREA_DAY_20(KlineService.handlerPriceAreaRate(zqdm, MA_20, KLT_101, false, "", date, KLINE_TYPE_STOCK));
            entity.setNET_AREA_DAY_40(KlineService.handlerPriceAreaRate(zqdm, MA_40, KLT_101, false, "", date, KLINE_TYPE_STOCK));
            entity.setNET_AREA_DAY_60(KlineService.handlerPriceAreaRate(zqdm, MA_60, KLT_101, false, "", date, KLINE_TYPE_STOCK));
//            stockAdrCount.setNET_AREA_DAY_120(KlineService.handlerPriceAreaRate(zqdm, MA_120, KLT_101, false, "", date, KLINE_TYPE_STOCK));
//            stockAdrCount.setNET_AREA_DAY_250(KlineService.handlerPriceAreaRate(zqdm, MA_250, KLT_101, false, "", date, KLINE_TYPE_STOCK));
            //更新
            updateRs += EtfAdrCountService.update(entity);
//            System.out.println("更新-净值区间:" + stockAdrCount.getF14() + StockAdrCountService.update(entity));
        }
        if (isShowLog) {
            System.out.println(methodName + "-需要更新个数:" + stockAdrCountList.size() + ",更新成功个数：" + updateRs + "end,用时：" + (System.currentTimeMillis() - begTime) / 1000);
        }
    }

    /**
     * 更新-超过均线信息:均线净值
     *
     * @param maDate            日期
     * @param stockAdrCountList 需要更新的列表数据
     * @param stockAdrCountCond 条件
     */
    public static void updateUpMa(String maDate, List<EtfAdrCountVo> stockAdrCountList, CondStockAdrCount stockAdrCountCond) {
        long begTime = System.currentTimeMillis();
        boolean isShowLog = true;
        String methodName = "更新-超过均线信息：";
        int updateRs = 0;//更新成功个数
        if (stockAdrCountList == null) {
            System.out.println(methodName + "stockAdrCountList==null");
            return;
        }
        for (EtfAdrCountVo stockAdrCount : stockAdrCountList) {
            EtfAdrCountVo entity = new EtfAdrCountVo();
            entity.setF12(stockAdrCount.getF12());
            entity.setDate(stockAdrCount.getDate());

            boolean isUp = true;//检查上涨
            List<Integer> maList = new ArrayList<>();
            maList.add(MA_60);

            //判断是否超过均线列表：15,30,60
            RankStockCommpanyDb stock = new RankStockCommpanyDb();
            stock.setF12(stockAdrCount.getF12());
            stock.setF14(stockAdrCount.getF14());
            List<String> maKltList = stockAdrCountCond.getMaKltList();
            //显示信息-上涨均线
            boolean isMa15 = false;
            boolean isMa30 = false;
            boolean isMa60 = false;
            boolean isMa101 = false;
            boolean isMa102 = false;
            if (maKltList.contains(KLT_15)) {
//                isMa15 = KlineService.showUpMa(stock, KLT_15, maList, maDate, isUp);//显示信息-上涨均线
                BreakMaDto breakMa = KlineService.breakMaUp(stock, KLT_15, MA_60, maDate);
                if (breakMa == null) {
                    continue;
                }
                entity.setMA_NET_60_15(breakMa.getMaNet());
                isMa15 = breakMa.isMaBreakUp();
                if (isMa15) {
                    entity.setUP_MA_15(KLT_15 + "(" + MA_60 + ")");
                } else {
//                    entity.setUP_MA_15("");
                }
            }
            if (maKltList.contains(KLT_30)) {
//                isMa30 = KlineService.showUpMa(stock, KLT_30, maList, maDate, isUp);//显示信息-上涨均线
                BreakMaDto breakMa = KlineService.breakMaUp(stock, KLT_30, MA_60, maDate);
                if (breakMa == null) {
                    continue;
                }
                entity.setMA_NET_60_30(breakMa.getMaNet());
                isMa30 = breakMa.isMaBreakUp();
                if (isMa30) {
                    entity.setUP_MA_30(KLT_30 + "(" + MA_60 + ")");
                } else {
//                    entity.setUP_MA_30("");
                }
            }
            if (maKltList.contains(KLT_60)) {
//                isMa60 = KlineService.showUpMa(stock, KLT_60, maList, maDate, isUp);//显示信息-上涨均线
                BreakMaDto breakMa = KlineService.breakMaUp(stock, KLT_60, MA_60, maDate);
                if (breakMa == null) {
                    continue;
                }
                entity.setMA_NET_60_60(breakMa.getMaNet());
                isMa60 = breakMa.isMaBreakUp();
                if (isMa60) {
                    entity.setUP_MA_60(KLT_60 + "(" + MA_60 + ")");
                } else {
//                    entity.setUP_MA_60("");
                }
            }
            if (maKltList.contains(KLT_101)) {
//                isMa101 = KlineService.showUpMa(stock, KLT_101, maList, maDate, isUp);//显示信息-上涨均线
                BreakMaDto breakMa = KlineService.breakMaUp(stock, KLT_101, MA_60, maDate);
                if (breakMa == null) {
                    continue;
                }
                entity.setMA_NET_60_101(breakMa.getMaNet());
                isMa101 = breakMa.isMaBreakUp();
                if (isMa101) {
                    entity.setUP_MA_101(KLT_101 + "(" + MA_60 + ")");
                } else {
//                    entity.setUP_MA_101("");
                }
            }
            if (maKltList.contains(KLT_102)) {
//                isMa102 = KlineService.showUpMa(stock, KLT_102, maList, maDate, isUp);//显示信息-上涨均线
                BreakMaDto breakMa = KlineService.breakMaUp(stock, KLT_102, MA_60, maDate);
                if (breakMa == null) {
                    continue;
                }
                entity.setMA_NET_60_102(breakMa.getMaNet());
                isMa102 = breakMa.isMaBreakUp();
                if (isMa102) {
                    entity.setUP_MA_102(KLT_102 + "(" + MA_60 + ")");
                } else {
//                    entity.setUP_MA_102("");
                }
            }

            boolean isHasMa = isMa15 || isMa30 || isMa60 || isMa101 || isMa102;
//            boolean isHasMa = isMa102;
            if (isHasMa) {
                //更新
                int rs = EtfAdrCountService.update(entity);
                updateRs += rs;
                System.out.print(new StringBuffer(methodName).append(stockAdrCount.getF12()).append(",").append(StockUtil.formatStName(stockAdrCount.getF14(), 22)).append(",是否成功：").append(rs).append(",f3:").append(StockUtil.formatDouble(stockAdrCount.getF3(), 6)));
                System.out.print(new StringBuffer(StockUtil.formatStName(entity.getUP_MA_102(), 8)).append(StockUtil.formatStName(entity.getUP_MA_101(), 8)).append(StockUtil.formatStName(entity.getUP_MA_60(), 8)).append(StockUtil.formatStName(entity.getUP_MA_30(), 8)).append(StockUtil.formatStName(entity.getUP_MA_15(), 8)));
                System.out.println(new StringBuffer("5日:" + StockUtil.formatDouble(stockAdrCount.getNET_AREA_DAY_5(), 6)).append("10日:" + StockUtil.formatDouble(stockAdrCount.getNET_AREA_DAY_10(), 6)).append("20日:" + StockUtil.formatDouble(stockAdrCount.getNET_AREA_DAY_20(), 6)).append("40日:" + StockUtil.formatDouble(stockAdrCount.getNET_AREA_DAY_40(), 6)).append("60日:" + StockUtil.formatDouble(stockAdrCount.getNET_AREA_DAY_60(), 6)));
            } else {
                int rs = EtfAdrCountService.update(entity);
                updateRs += rs;
//                System.out.println("更新-超过均线信息:" + stockAdrCount.getF14() + ",未超过任何均线：" + rs + ",f3:" + stockAdrCount.getF3());
//                System.out.println("更新-超过均线信息:" + stockAdrCount.getF14() + "未超过任何均线，不做处理");
            }
        }
        if (isShowLog) {
            System.out.println(methodName + "个数:" + stockAdrCountList.size() + ",更新成功：" + updateRs + "用时：" + (System.currentTimeMillis() - begTime) / 1000);
        }
    }

    /**
     * 更新-上涨之和
     *
     * @param etfList
     */
    public static void updateUpSum(String date, List<RankBizDataDiff> etfList) {
        List<String> dateList = StockService.findListDateBefore(date, 61);//查询n个交易日之前的日期

        //更新-上涨之和
        updateAdrSumByBiz(date, DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_60, dateList, etfList);
        updateAdrSumByBiz(date, DB_STOCK_ADR_COUNT_ADR_UP_SUM_40_60, dateList, etfList);
        updateAdrSumByBiz(date, DB_STOCK_ADR_COUNT_ADR_UP_SUM_20_40, dateList, etfList);
        updateAdrSumByBiz(date, DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_20, dateList, etfList);
        updateAdrSumByBiz(date, DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_40, dateList, etfList);
        updateAdrSumByBiz(date, DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_10, dateList, etfList);
        updateAdrSumByBiz(date, DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_5, dateList, etfList);
        updateAdrSumByBiz(date, DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_3, dateList, etfList);
        updateAdrSumByBiz(date, DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_2, dateList, etfList);
        updateAdrSumByBiz(date, DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_1, dateList, etfList);

    }

    /**
     * 更新-上涨之和排序
     *
     * @param date date
     */
    public static void updateUpSumOrder(String date) {
        List<String> bizNameList = TYPE_ALL;
        for (String type : bizNameList) {
            //更新-上涨之和排序
            updateAdrSumOrderByBiz(date, type, DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_3);
            updateAdrSumOrderByBiz(date, type, DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_5);
            updateAdrSumOrderByBiz(date, type, DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_10);
            updateAdrSumOrderByBiz(date, type, DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_20);
            updateAdrSumOrderByBiz(date, type, DB_STOCK_ADR_COUNT_ADR_UP_SUM_20_40);
            updateAdrSumOrderByBiz(date, type, DB_STOCK_ADR_COUNT_ADR_UP_SUM_40_60);
            updateAdrSumOrderStatByBiz(date, type);
        }
    }

    /**
     * 更新上涨之和
     *
     * @param date
     * @param dateList
     * @param etfList
     * @return
     */
    private static int updateAdrSumByBiz(String date, String dbField, List<String> dateList, List<RankBizDataDiff> etfList) {
        long begTime = System.currentTimeMillis();
        boolean isShowLog = true;
        String methodName = "更新上涨之和-";
        int rs = 0;
        List<EtfAdrCount> etfAdrCountList = new ArrayList<>();
        CondStockAdrCount condStockAdrCount = new CondStockAdrCount();
        condStockAdrCount.setDate(date);

        String endDate = DateUtil.handlerEndDateByDbField(date, dbField, dateList);
        String begDate = DateUtil.handlerBegDateByDbField(date, dbField, dateList);

        //查询每只股票的涨幅
        for (RankBizDataDiff etfVo : etfList) {
            String code = etfVo.getF12();
            String name = etfVo.getF14();

            //计算涨幅累计:只计算正增长
            CondStock conditionStock = new CondStock();//查询条件
            conditionStock.setF12(code);
            conditionStock.setBegDate(begDate);
            conditionStock.setEndDate(endDate);
            BigDecimal adrSum = KlineService.httpAdrSumByKline(conditionStock);

            EtfAdrCount entity = new EtfAdrCount();
            entity.setF12(code);
            entity.setF14(name);
            entity.setDate(date);
            if (adrSum == null) {
//                System.out.println("今日未涨：" + JSON.toJSONString(entity));
                continue;
            } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_1.equals(dbField)) {
                entity.setADR_UP_SUM_1_1(adrSum);
            } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_2.equals(dbField)) {
                entity.setADR_UP_SUM_1_2(adrSum);
            } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_3.equals(dbField)) {
                entity.setADR_UP_SUM_1_3(adrSum);
            } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_5.equals(dbField)) {
                entity.setADR_UP_SUM_1_5(adrSum);
            } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_10.equals(dbField)) {
                entity.setADR_UP_SUM_1_10(adrSum);
            } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_20.equals(dbField)) {
                entity.setADR_UP_SUM_1_20(adrSum);
            } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_40.equals(dbField)) {
                entity.setADR_UP_SUM_1_40(adrSum);
            } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_60.equals(dbField)) {
                entity.setADR_UP_SUM_1_60(adrSum);
            } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_20_40.equals(dbField)) {
                entity.setADR_UP_SUM_20_40(adrSum);
            } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_40_60.equals(dbField)) {
                entity.setADR_UP_SUM_40_60(adrSum);
            }
            etfAdrCountList.add(entity);
        }
        //排序
        //更新涨幅次数
        for (EtfAdrCount stockAdrCount : etfAdrCountList) {
            int updateRs = EtfAdrCountService.update(stockAdrCount);
            if (updateRs != 1) {
                System.out.println("更新ETF-上涨之和-失败：" + rs + "" + JSON.toJSONString(stockAdrCount));
            } else {
                rs++;
            }
        }
        if (isShowLog) {
            System.out.println(methodName + "用时：" + (System.currentTimeMillis() - begTime) / 1000 + ",字段：" + dbField + ",成功个数：" + rs);
        }
        return rs;
    }

    /**
     * 查询etf列表：一页最多查询n条，需要分多次查询，只能查询最近交易日的数据
     *
     * @return
     */
    public static List<RankBizDataDiff> listEtfListLastDay() {
        List<RankBizDataDiff> etfList = new ArrayList<>();
        int maxCount = 100;//最多查询次数
        for (int i = 1; i <= maxCount; i++) {
            List<RankBizDataDiff> curPageEtfList = BizService.listEtf(i, NUM_MAX_99);//查询列表
            if (curPageEtfList.size() > 0) {
//                System.out.println("当前页查询个数：" + curPageEtfList.size());
                etfList.addAll(curPageEtfList);
            } else {
                break;
            }
        }
        return etfList;
    }

    /**
     * 查询etf列表:市值过滤
     *
     * @param minMv 最低市值
     * @return
     */
    public static List<RankBizDataDiff> listEtfListLastDay(BigDecimal minMv) {
        return listEtfListLastDayByMarketValue(minMv, null);
    }

    /**
     * 查询etf列表:市值过滤
     *
     * @param minMv 最低市值
     * @param maxMv 最高市值
     * @return
     */
    public static List<RankBizDataDiff> listEtfListLastDayByMarketValue(BigDecimal minMv, BigDecimal maxMv) {
        boolean isShowLog = false;
        int countMinMvLimit = 0;
        int countMaxMvLimit = 0;
        List<RankBizDataDiff> etfList = listEtfListLastDay();
        if (minMv == null && maxMv == null) {
            return etfList;
        }
        List<RankBizDataDiff> etfListLimit = new ArrayList<>();
        for (RankBizDataDiff etf : etfList) {
            BigDecimal marketValue = etf.getF20();
            //市值过滤
            if (marketValue == null) {
                etfListLimit.add(etf);
                continue;
            }
            if (minMv != null && marketValue.compareTo(minMv) < 0) {
//                    System.out.println("市值低于限定");
                countMinMvLimit++;
                continue;
            }
            if (maxMv != null && marketValue.compareTo(maxMv) > 0) {
//                    System.out.println("市值高于限定");
                countMaxMvLimit++;
                continue;
            }
            etfListLimit.add(etf);
        }
        if (isShowLog) {
            System.out.println("查询etf列表,源数据个数：" + etfList.size() + "||" + "市值低于限定个数：" + countMinMvLimit + "||" + "市值高于限定个数：" + countMaxMvLimit + "||" + "市值过滤符合条件个数：" + etfListLimit.size() + ",校对：" + (countMinMvLimit + countMaxMvLimit + etfListLimit.size()) + "==" + etfList.size());
        }
        return etfListLimit;
    }

    /**
     * 更新上涨累计排序
     *
     * @param date    日期
     * @param bizName 业务名称
     * @param dbField 字段
     */
    private static int updateAdrSumOrderByBiz(String date, String bizName, String dbField) {
        int rs = 0;
        //查询股票列表-根据板块
        CondStockAdrCount condition = new CondStockAdrCount();
        condition.setDate(date);
        condition.setType_name(bizName);
        List<EtfAdrCountVo> stList = EtfAdrCountService.listStAdrCount(condition);

        //排序
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_1.equals(dbField)) {
            stList = stList.stream().filter(e -> e != null).sorted(Comparator.comparing(EtfAdrCountVo::getADR_UP_SUM_1_1, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_2.equals(dbField)) {
            stList = stList.stream().filter(e -> e != null).sorted(Comparator.comparing(EtfAdrCountVo::getADR_UP_SUM_1_2, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_3.equals(dbField)) {
            stList = stList.stream().filter(e -> e != null).sorted(Comparator.comparing(EtfAdrCountVo::getADR_UP_SUM_1_3, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_5.equals(dbField)) {
            stList = stList.stream().filter(e -> e != null).sorted(Comparator.comparing(EtfAdrCountVo::getADR_UP_SUM_1_5, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_10.equals(dbField)) {
            stList = stList.stream().filter(e -> e != null).sorted(Comparator.comparing(EtfAdrCountVo::getADR_UP_SUM_1_10, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_20.equals(dbField)) {
            stList = stList.stream().filter(e -> e != null).sorted(Comparator.comparing(EtfAdrCountVo::getADR_UP_SUM_1_20, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_40.equals(dbField)) {
            stList = stList.stream().filter(e -> e != null).sorted(Comparator.comparing(EtfAdrCountVo::getADR_UP_SUM_1_40, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_20_40.equals(dbField)) {
            stList = stList.stream().filter(e -> e != null).sorted(Comparator.comparing(EtfAdrCountVo::getADR_UP_SUM_20_40, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_40_60.equals(dbField)) {
            stList = stList.stream().filter(e -> e != null).sorted(Comparator.comparing(EtfAdrCountVo::getADR_UP_SUM_40_60, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        }

        int order = 0;
        //查询每只股票的涨幅次数
        for (EtfAdrCountVo etf : stList) {
            EtfAdrCount entity = new EtfAdrCount();
            entity.setF12(etf.getF12());
            entity.setDate(date);
            if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_3.equals(dbField)) {
                entity.setADR_UP_SUM_ORDER_1_3(new BigDecimal(++order));
            }
            if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_5.equals(dbField)) {
                entity.setADR_UP_SUM_ORDER_1_5(new BigDecimal(++order));
            }
            if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_10.equals(dbField)) {
                entity.setADR_UP_SUM_ORDER_1_10(new BigDecimal(++order));
            }
            if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_20.equals(dbField)) {
                entity.setADR_UP_SUM_ORDER_1_20(new BigDecimal(++order));
            }
//            if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_40.equals(dbField)) {
//                entity.setADR_UP_SUM_ORDER_1_40(new BigDecimal(++order));
//            }
            if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_20_40.equals(dbField)) {
                entity.setADR_UP_SUM_ORDER_20_40(new BigDecimal(++order));
            }
            if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_40_60.equals(dbField)) {
                entity.setADR_UP_SUM_ORDER_40_60(new BigDecimal(++order));
            }

            //更新
            int updateRs = EtfAdrCountService.update(entity);
            if (updateRs != 1) {
                System.out.println("更新-上涨之和排序-失败：" + rs + "" + JSON.toJSONString(entity));
            } else {
                rs++;
            }
        }
        System.out.println("更新-上涨之和排序-成功：" + rs);
        return rs;
    }

    /**
     * 更新上涨累计排序的统计数值
     *
     * @param date    日期
     * @param bizName 业务名称
     */
    private static int updateAdrSumOrderStatByBiz(String date, String bizName) {
        String methodName = "更新上涨累计排序的统计数值";
        int rs = 0;
        //查询股票列表-根据板块
        CondStockAdrCount condition = new CondStockAdrCount();
        condition.setDate(date);
        condition.setType_name(bizName);
        List<EtfAdrCountVo> stList = EtfAdrCountService.listStAdrCount(condition);
        BigDecimal adr_up_sum_order_stat = new BigDecimal("0");
        for (EtfAdrCountVo etfAdrCountVo : stList) {
            BigDecimal adr_up_sum_order_1_3 = etfAdrCountVo.getADR_UP_SUM_ORDER_1_3();
            BigDecimal adr_up_sum_order_1_5 = etfAdrCountVo.getADR_UP_SUM_ORDER_1_5();
            BigDecimal adr_up_sum_order_1_10 = etfAdrCountVo.getADR_UP_SUM_ORDER_1_10();
            BigDecimal adr_up_sum_order_1_20 = etfAdrCountVo.getADR_UP_SUM_ORDER_1_20();
            BigDecimal adr_up_sum_order_20_40 = etfAdrCountVo.getADR_UP_SUM_ORDER_20_40();
            BigDecimal adr_up_sum_order_40_60 = etfAdrCountVo.getADR_UP_SUM_ORDER_40_60();
            adr_up_sum_order_stat.add(adr_up_sum_order_1_3);
            adr_up_sum_order_stat.add(adr_up_sum_order_1_5);
            adr_up_sum_order_stat.add(adr_up_sum_order_1_10);
            adr_up_sum_order_stat.add(adr_up_sum_order_1_20);
            adr_up_sum_order_stat.add(adr_up_sum_order_20_40);
            adr_up_sum_order_stat.add(adr_up_sum_order_40_60);
        }

        //排序
        stList = stList.stream().filter(e -> e != null).sorted(Comparator.comparing(EtfAdrCountVo::getADR_UP_SUM_ORDER_STAT, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());

        int order = 0;
        //查询每只股票的涨幅次数
        for (EtfAdrCountVo etf : stList) {
            EtfAdrCount entity = new EtfAdrCount();
            entity.setF12(etf.getF12());
            entity.setDate(date);
            entity.setADR_UP_SUM_ORDER_STAT(new BigDecimal(++order));

            //更新
            int updateRs = EtfAdrCountService.update(entity);
            if (updateRs != 1) {
                System.out.println(methodName + "-失败：" + rs + "" + JSON.toJSONString(entity));
            } else {
                rs++;
            }
        }
        System.out.println(methodName + "-成功：" + rs);
        return rs;
    }
}
