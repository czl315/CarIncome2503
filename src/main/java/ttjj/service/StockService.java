package ttjj.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import ttjj.dao.RankStockCommpanyDao;
import ttjj.db.RankStockCommpanyDb;
import ttjj.db.StockAdrCount;
import ttjj.dto.*;
import ttjj.rank.StockControl;
import utils.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static utils.ContTradeDay.mapTradeDay;
import static utils.Content.*;

/**
 * StockService简介
 *
 * @author Administrator
 * @date 2022-07-13 10:01
 */
public class StockService {

    public static void main(String[] args) {
        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//        String date = "2022-09-09";
        List<String> dateList = StockService.findListDateBefore(date, 5, "");//查询n个交易日之前的日期
        for (String dateStr : dateList) {
            System.out.println(dateStr);
        }
    }

    /**
     * 检查股票:状态、是否主板股票、市值限定
     *
     * @param entity
     * @param limitMarketValue
     * @return
     */
    public static boolean checkIsMainStockLimit(RankStockCommpanyDb entity, BigDecimal limitMarketValue) {
        String zqdm = entity.getF12();
        String zqmc = entity.getF14();
        if (entity == null) {
            System.out.println("实体信息为null，不更新db：");
            return false;
        }
        if (StringUtils.isBlank(zqdm)) {
            System.out.println("实体信息异常，不更新db：" + JSON.toJSONString(entity));
            return false;
        }

        //只更新主板板块的价格
        if (entity.getF139() != DB_RANK_BIZ_F139_BK_MAIN) {
//                    System.out.println("均线价格暂不更新（非主板）！" + JSON.toJSONString(entity));
            return false;
        }
        //  市值限定,100亿以下不更新
        if (entity.getF20() != null && entity.getF20().compareTo(limitMarketValue) < 0) {
//                    System.out.println("均线价格暂不更新（100亿以下）！" + JSON.toJSONString(entity));
            return false;
        }

        //检查股票:状态
        if (!checkStockStatus(entity)) {
            return false;
        }

        return true;
    }

    /**
     * 检查股票:状态
     *
     * @param entity 股票
     * @return
     */
    public static boolean checkStockStatus(RankStockCommpanyDb entity) {
        String zqdm = entity.getF12();
        String zqmc = entity.getF14();
        if (entity == null) {
            System.out.println("实体信息为null，不更新db：");
            return false;
        }
        if (StringUtils.isBlank(zqdm)) {
            System.out.println("实体信息异常，不更新db：" + JSON.toJSONString(entity));
            return false;
        }

        // 股票状态过滤：退市、退市整理、未上市、st
        Long stStatus = entity.getF148();
        if (DB_RANK_BIZ_F148_STOCK_STATUS_DELISTED == stStatus || DB_RANK_BIZ_F148_STOCK_STATUS_DELISTING == stStatus) {
//                    System.out.println("均线价格暂不更新（退市、退市整理）！" + JSON.toJSONString(entity));
            return false;
        }
        if (DB_RANK_BIZ_F148_STOCK_STATUS_UNLISTED == stStatus) {
//                    System.out.println("均线价格暂不更新（未上市）！" + JSON.toJSONString(entity));
            return false;
        }
        if (DB_RANK_BIZ_F148_STOCK_STATUS_SUSPENSION == stStatus) {
//                    System.out.println("均线价格暂不更新（暂停上市）！" + JSON.toJSONString(entity));
            return false;
        }
        if (DB_RANK_BIZ_F148_STOCK_STATUS_ST == stStatus) {
//                    System.out.println("均线价格暂不更新（ST股）！" + JSON.toJSONString(entity));
            return false;
        }

        return true;
    }

    /**
     * 查询股票列表-根据概念
     *
     * @param date
     * @param conceptions
     * @param board
     * @param mvMin
     * @return
     */
    public static List<RankStockCommpanyDb> listlikeConception(String date, String conceptions, Long board, BigDecimal mvMin) {
        //        String conceptions = "注射器概念";//科技-芯片：汽车芯片,IGBT概念,中芯概念,第三代半导体,PVDF概念,光刻胶,半导体概念,
//        String conceptions = "毛发医疗";//医疗-医美：毛发医疗,医疗美容,


//        String conceptions = "HIT电池";//科技-光伏: HIT电池,光伏建筑一体化      ,太阳能        ["太阳能"];股票个数：168;
//        String conceptions = "煤化工";//资源-煤炭：煤化工,稀缺资源,
//        String conceptions = "油价相关";//资源-石油：可燃冰,页岩气,油气设服,天然气,油价相关
//        String conceptions = "退税商店";//消费-零售:免税概念,退税商店,新零售,C2M概念,抖音小店
//        String conceptions = "白酒";//消费-酒:白酒,啤酒概念

//        String conceptions = "券商概念";//金融-券商:券商概念,互联金融,参股期货

//        String conceptions = "医废处理";//医疗-制药：维生素,地塞米松,疫苗冷链,阿兹海默,基因测序

//        String conceptions = "低碳冶金";//资源-钢铁：低碳冶金,基本金属,稀土永磁,钛白粉
//        String conceptions = "氦气概念";//资源-气体：氢能源,氦气概念,工业气体
//        String conceptions = "航母概念";//科技-军工: 航母概念,海工装备,军民融合,大飞机,通用航空,天基互联,航天概念,空间站概念,北斗导航,
//        String conceptions = "云游戏";//科技-传媒：云游戏,手游概念,电子竞技,网络游戏,
//        String conceptions = "地热能";//科技-电力:抽水蓄能,虚拟电厂,特高压,绿色电力,风能,
//        String conceptions = "磁悬浮概念";//科技-汽车: 激光雷达,胎压监测,华为汽车,特斯拉
//        String conceptions = "工业母机";//科技-工业: 工业母机,工业4.0
//        String conceptions = "培育钻石";//消费-贵金属: 培育钻石,黄金概念,
//        String conceptions = "人脑工程";//科技-智能: 人脑工程
//        String conceptions = "银行 ";//金融-银行:银行,互联金融
//        String conceptions = "体育产业";//消费-体育：体育产业,
//        String conceptions = "职业教育";//科技-教育:职业教育
//        String conceptions = "上海自贸";//：上海自贸
//        String conceptions = "辅助生殖";//辅助生殖,婴童概念,托育服务
//        String conceptions = "杭州亚运会";//最新概念：土壤修复,智慧灯杆,净水概念,杭州亚运会
        CondStock conditionLikeConception = new CondStock();
        conditionLikeConception.setDate(date);
        String[] conceptionStrs = conceptions.split(",");
        List<String> conpetionList = Arrays.asList(conceptionStrs);
        conditionLikeConception.setConpetionList(conpetionList);
        conditionLikeConception.setF139(board);
        conditionLikeConception.setF20(mvMin);
        List<RankStockCommpanyDb> stListLikeConception = RankStockCommpanyDao.findListLikeConception(conditionLikeConception);
//        System.out.println("概念：" + JSON.toJSONString(conpetionList) + ";" + "股票个数：" + stListLikeConception.size() + ";");
        return stListLikeConception;
    }

    /**
     * 查询列表-根据板块
     *
     * @param boardName
     * @param date
     * @param board
     * @param mvMin
     * @param mvMax
     * @return
     */
    public static List<RankStockCommpanyDb> findListByCondition(String boardName, String date, Long board, BigDecimal mvMin, BigDecimal mvMax) {
        CondStock condition = new CondStock();
        condition.setDate(date);
        condition.setF139(board);
        condition.setF20(mvMin);
        condition.setType_name(boardName);
        return RankStockCommpanyDao.findListByCondition(condition);
    }

    /**
     * 查询列表-根据
     *
     * @param condition 条件
     * @return 结果
     */
    public static List<RankStockCommpanyDb> findListByCondition(CondStock condition) {
        return RankStockCommpanyDao.findListByCondition(condition);
    }

    /**
     * 查询个数
     *
     * @param condition
     * @return
     */
    public static Integer findCountByCondition(CondStock condition) {
        return RankStockCommpanyDao.findCountByCondition(condition);
    }

    /**
     * 查询昨日主题排名
     *
     * @param endCount
     */
    public static List<RankBizDataDiff> listBiz(int endCount) {
        //http://28.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112408110589206747254_1616379873172&pn=1&pz=20&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:2+f:!50&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1616379873199
        long curTime = System.currentTimeMillis();
        StringBuffer urlParam = new StringBuffer();
//        String url = "http://api.fund.eastmoney.com/ztjj/GetZTJJList";
//        urlParam.append("callback=jQuery311015658602123786958_1591838943711&callbackname=fundData");
//        urlParam.append("&st="+findDateType);//查询类型
//        urlParam.append("&_=1614523183291");
        String url = "http://28.push2.eastmoney.com/api/qt/clist/get";
        urlParam.append("cb=jQuery112408110589206747254_" + curTime +
                "&pn=1" +//页数
                "&pz=" + endCount +//每页数量
                "&po=1" +//pageorder:页面排序：0-正序；1-倒序
                "&np=1" +
                "&ut=bd1d9ddb04089700cf9c27f6f7426281" +
                "&fltt=2" +//浮点数精度
                "&invt=3" +//显示格式：-；0.0
                "&fid=f3" +//排序字段
                "&fs=m:90+t:2+f:!50" +
                "&fields=" +
                "f1,f2,f3,f4,f5,f6,f7,f8,f9," +
                "f10,f11,f12,f13,f14,f15,f16,f17,f18,f19," +
                "f20,f21,f22,f23,f24,f25,f26,f27,f28,f29," +
                "f30,f31,f32,f33,f34,f35,f36,f37,f38,f39," +
                "f60,f61,f62,f63,f64,f65,f66,f67,f68,f69," +
                "f70,f71,f72,f73,f74,f75,f76,f77,f78,f79," +
                "f80,f81,f82,f83,f84,f85,f86,f87,f88,f89," +
                "f90,f91,f92,f93,f94,f95,f96,f97,f98,f99," +
                "f100,f101,f102,f103,f104,f105,f106,f107,f108,f109" + "," +
                "f110,f111,f112,f113,f114,f115,f116,f117,f118,f119" + "," +
                "f120,f121,f122,f123,f124,f125,f126,f127,f128,f129" + "," +
                "f130,f131,f132,f133,f134,f135,f136,f137,f138,f139" + "," +
                "f140,f141,f142,f143,f144,f145,f146,f147,f148,f149" + "," +
                "f150,f151,f152,f153,f154,f155,f156,f157,f158,f159" + "," +
                "f160,f161,f162,f163,f164,f165,f166,f167,f168,f169" + "," +
                "f170,f171,f172,f173,f174,f175,f176,f177,f178,f179" + "," +
                "f180,f181,f182,f183,f184,f185,f186,f187,f188,f189" + "," +
                "f190,f191,f192,f193,f194,f195,f196,f197,f198,f199" + "," +
                "f200,f201,f202,f203,f204,f205,f206,f207,f208,f209" + "," +
                "f210,f211,f212,f213,f214,f215,f216,f217,f218,f219" + "," +
                "f220,f221,f222,f223,f224,f225,f226,f227,f228,f229" +
                "&_=" + curTime);
        String rs = HttpUtil.sendGet(url, urlParam.toString(), "");
//        System.out.println(rs);
        /**
         * 如果返回异常，n次重试
         */
        for (int i = 0; i < 10; i++) {
            if (StringUtils.isBlank(rs)) {
                rs = HttpUtil.sendGet(url, urlParam.toString(), "");
            } else {
                break;
            }
        }

        if (rs.startsWith("jQuery")) {
            rs = rs.substring(rs.indexOf("{"));
        }
        if (rs.endsWith(");")) {
            rs = rs.substring(0, rs.length() - 2);
        }
//        System.out.println(rs);//返回结果
        JSONObject rsJsonObj = JSONObject.parseObject(rs);
        for (int i = 0; i < 10; i++) {
            if (rsJsonObj == null || !rsJsonObj.containsKey("data")) {
                System.out.println("查询数据异常，重新查询" + JSON.toJSONString(rsJsonObj));
                rs = HttpUtil.sendGet(url, urlParam.toString(), "");
                rsJsonObj = JSONObject.parseObject(rs);
            } else {
                break;
            }
        }

        JSONObject rsJsonData = rsJsonObj.getJSONObject("data");
        JSONArray rsJsonDataDiff = rsJsonData.getJSONArray("diff");
        List<RankBizDataDiff> rankBizDataDiffList = JSON.parseArray(JSON.toJSONString(rsJsonDataDiff), RankBizDataDiff.class);
//        for (RankBizDataDiff row : rankBizDataDiffList) {
//            System.out.println(JSON.toJSON(row));//每个行业一行数据
//        }
        return rankBizDataDiffList;
    }

    /**
     * 获取均线区间
     *
     * @param netMap
     * @return
     */
    public static BigDecimal handlerMaArea(Map<String, BigDecimal> netMap) {
        BigDecimal curPriceArea = null;
        BigDecimal curPrice = netMap.get(keyRsNetClose);
        BigDecimal minPrice = netMap.get(keyRsMin);
        BigDecimal maxPrice = netMap.get(keyRsMax);
        if (curPrice != null && minPrice != null && maxPrice != null) {
            BigDecimal maxSubMinPrice = maxPrice.subtract(minPrice);
            BigDecimal zero = new BigDecimal("0");
            if (maxSubMinPrice.compareTo(zero) == 0) {
                curPriceArea = zero;
            } else {
                curPriceArea = curPrice.subtract(minPrice).divide(maxSubMinPrice, 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP);
            }
        }
        return curPriceArea;
    }

    /**
     * 查询指定日期之前交易日期列表
     * 数据库查询交易日不准确
     * 查询上证指数的交易日列表
     *
     * @param date             指定日期
     * @param days             限定返回数量
     * @param httpKlineApiType http接口类型
     * @return 日期列表
     */
    public static List<String> findListDateBefore(String date, int days, String httpKlineApiType) {
        boolean isShowLog = false;//是否显示日志
        String methodName = "K线-查询上证指数的交易日列表：";
        long curTime = System.currentTimeMillis();
        List<String> dateList = new ArrayList<>();
        //查询K线-查询交易日列表，http查询上证指数的日k线
        List<Kline> klines = SseService.daykline(ContIndex.SHANG_HAI, days);
        //如果调用上交所失败，东方财富http调用
        if (klines == null) {
            klines = KlineService.kline(ContIndex.SHANG_HAI, days, KLT_101, false, "0", date, DB_RANK_BIZ_TYPE_ZS);
        }
//        System.out.println("k线：" + JSON.toJSONString(klines));
        if (klines != null && klines.size() > 0) {
            klines = klines.stream().filter(e -> e != null).sorted(Comparator.comparing(Kline::getKtime, Comparator.nullsFirst(String::compareTo)).reversed()).collect(Collectors.toList());
            for (Kline kline : klines) {
                dateList.add(kline.getKtime());
            }
        }

        return dateList;
    }

    /**
     * 查询指定日期之后交易日期列表
     *
     * @param date 指定日期
     * @param days 限定返回数量
     * @return 日期列表
     */
    public static List<String> findListDateAfter(String date, int days) {
        List<String> dateList = new ArrayList<>();
        //查询K线-查询交易日列表，http查询上证指数的日k线
        String begDate = date;
        List<Kline> klines = KlineService.kline(ContIndex.SHANG_HAI, days, KLT_101, true, begDate, null, DB_RANK_BIZ_TYPE_ZS);

//        System.out.println("k线：" + JSON.toJSONString(klines));
        if (klines != null && klines.size() > 0) {
            klines = klines.stream().filter(e -> e != null).sorted(Comparator.comparing(Kline::getKtime, Comparator.nullsFirst(String::compareTo)).reversed()).collect(Collectors.toList());
            for (Kline kline : klines) {
                dateList.add(kline.getKtime());
            }
        }

        return dateList;
    }

    /**
     * 查询交易日期列表
     *
     * @param dateCond
     * @return
     */
    public static List<String> findListDateByBegToEnd(DateCond dateCond) {
        return RankStockCommpanyDao.findListDateByBegToEnd(dateCond);
    }

    /**
     * 统计涨跌次数
     */
    public static void statStAdrCount(List<RankStockCommpanyDb> stListLikeConception, String endDate, Integer days, BigDecimal adrMin, Long bk, BigDecimal mvMin, BigDecimal mvMax, Map<String, StockAdrCount> statRsStAdrCountMap) {
        List<String> stCodeList = null;
        if (stListLikeConception == null || stListLikeConception.size() <= 0) {
            System.out.println(JSON.toJSONString(stListLikeConception) + ":查询股票列表为空！");
            return;
        }
        stCodeList = new ArrayList<>();
        for (RankStockCommpanyDb rankStockCommpanyDb : stListLikeConception) {
            stCodeList.add(rankStockCommpanyDb.getF12());
        }

        //查询n个交易日之前的日期,如果不存在，使用减去自然日
        String begDate = findBegDate(endDate, days);

        StatCondStAdrCount condition = new StatCondStAdrCount();
        condition.setF139(bk);
        condition.setMarketValueMin(mvMin);//市值
        condition.setMarketValueMax(mvMax);//市值
        condition.setAdrMin(adrMin);
        condition.setBegDate(begDate);
        condition.setEndDate(endDate);

        if (stCodeList != null && stCodeList.size() > 0) {
            condition.setStCodeList(stCodeList);
        }
        List<StatRsStAdrCount> rs = RankStockCommpanyDao.findListStatStAdrCount(condition); //  查询-股票涨跌次数
        if (rs == null) {
            return;
        }
        for (StatRsStAdrCount stAdrCount : rs) {
            String code = stAdrCount.getCode();

//            BigDecimal score = adrMin.multiply(stAdrCount.getCount());//涨幅得分=上涨幅度*次数
            BigDecimal score = stAdrCount.getCount() != null ? stAdrCount.getCount() : new BigDecimal("0");//涨幅得分=上涨次数
//            System.out.println("days:" + days + ",adrMin:" + adrMin + "=" + JSON.toJSONString(stAdrCount));
//            if ("中国神华".equals(stAdrCount.getName())) {
//                System.out.println(stAdrCount.getCode() + ":" + stAdrCount.getName() + ":" + ",天数：" + days + ",上涨次数：" + stAdrCount.getCount() + ",涨幅标准：" + adrMin + ",上涨得分：" + score);
//            }
            if (statRsStAdrCountMap.containsKey(code)) {
                StockAdrCount stMapDtoOld = statRsStAdrCountMap.get(code);
                BigDecimal countOld = stMapDtoOld.getADR_UP_COUNT_SUM_60() != null ? stMapDtoOld.getADR_UP_COUNT_SUM_60() : new BigDecimal("0");

                if (days == TRADE_DAYS_1) {
                    BigDecimal countOldTemp = stMapDtoOld.getADR_UP_COUNT_1();
                    if (countOldTemp != null) {
                        stMapDtoOld.setADR_UP_COUNT_1(countOldTemp.add(score));
                    } else {
                        stMapDtoOld.setADR_UP_COUNT_1(score);
                    }
                }
                if (days == TRADE_DAYS_2) {
                    BigDecimal countOldTemp = stMapDtoOld.getADR_UP_COUNT_2();
                    if (countOldTemp != null) {
                        stMapDtoOld.setADR_UP_COUNT_2(countOldTemp.add(score));
                    } else {
                        stMapDtoOld.setADR_UP_COUNT_2(score);
                    }
                }
                if (days == TRADE_DAYS_3) {
                    BigDecimal countOldTemp = stMapDtoOld.getADR_UP_COUNT_3();
                    if (countOldTemp != null) {
                        stMapDtoOld.setADR_UP_COUNT_3(countOldTemp.add(score));
                    } else {
                        stMapDtoOld.setADR_UP_COUNT_3(score);
                    }
                }
                if (days == TRADE_DAYS_5) {
                    BigDecimal countOldTemp = stMapDtoOld.getADR_UP_COUNT_5();
                    if (countOldTemp != null) {
                        stMapDtoOld.setADR_UP_COUNT_5(countOldTemp.add(score));
                    } else {
                        stMapDtoOld.setADR_UP_COUNT_5(score);
                    }
                    stMapDtoOld.setADR_UP_COUNT_SUM_60(countOld.add(score));//总和：只计算5日+10日+20+40+60
                }
                if (days == TRADE_DAYS_10) {
                    BigDecimal countOldTemp = stMapDtoOld.getADR_UP_COUNT_10();
                    if (countOldTemp != null) {
                        stMapDtoOld.setADR_UP_COUNT_10(countOldTemp.add(score));
                    } else {
                        stMapDtoOld.setADR_UP_COUNT_10(score);
                    }
                    stMapDtoOld.setADR_UP_COUNT_SUM_60(countOld.add(score));//总和：只计算5日+10日+20+40+60
                }
                if (days == TRADE_DAYS_20) {
                    BigDecimal countOldTemp = stMapDtoOld.getADR_UP_COUNT_20();
                    if (countOldTemp != null) {
                        stMapDtoOld.setADR_UP_COUNT_20(countOldTemp.add(score));
                    } else {
                        stMapDtoOld.setADR_UP_COUNT_20(score);
                    }
                    stMapDtoOld.setADR_UP_COUNT_SUM_60(countOld.add(score));//总和：只计算5日+10日+20+40+60
                }
                if (days == TRADE_DAYS_40) {
                    BigDecimal countOldTemp = stMapDtoOld.getADR_UP_COUNT_40();
                    if (countOldTemp != null) {
                        stMapDtoOld.setADR_UP_COUNT_40(countOldTemp.add(score));
                    } else {
                        stMapDtoOld.setADR_UP_COUNT_40(score);
                    }
                    stMapDtoOld.setADR_UP_COUNT_SUM_60(countOld.add(score));//总和：只计算5日+10日+20+40+60
                }
                if (days == TRADE_DAYS_60) {
                    BigDecimal countOldTemp = stMapDtoOld.getADR_UP_COUNT_60();
                    if (countOldTemp != null) {
                        stMapDtoOld.setADR_UP_COUNT_60(countOldTemp.add(score));
                    } else {
                        stMapDtoOld.setADR_UP_COUNT_60(score);
                    }
                    stMapDtoOld.setADR_UP_COUNT_SUM_60(countOld.add(score));//总和：只计算5日+10日+20+40+60
                }
                statRsStAdrCountMap.put(code, stMapDtoOld);
            } else {
                StockAdrCount stockAdrCount = new StockAdrCount();
                stockAdrCount.setF12(code);
                //-120, -90,-60, -30, -14, -7
                if (days == TRADE_DAYS_1) {
                    stockAdrCount.setADR_UP_COUNT_1(score);
                }
                if (days == TRADE_DAYS_2) {
                    stockAdrCount.setADR_UP_COUNT_2(score);
                }
                if (days == TRADE_DAYS_3) {
                    stockAdrCount.setADR_UP_COUNT_3(score);
                }
                if (days == TRADE_DAYS_5) {
                    stockAdrCount.setADR_UP_COUNT_5(score);
                    stockAdrCount.setADR_UP_COUNT_SUM_60(score);
                }
                if (days == TRADE_DAYS_10) {
                    stockAdrCount.setADR_UP_COUNT_10(score);
                    stockAdrCount.setADR_UP_COUNT_SUM_60(score);
                }
                if (days == TRADE_DAYS_20) {
                    stockAdrCount.setADR_UP_COUNT_20(score);
                    stockAdrCount.setADR_UP_COUNT_SUM_60(score);
                }
                if (days == TRADE_DAYS_40) {
                    stockAdrCount.setADR_UP_COUNT_40(score);
                    stockAdrCount.setADR_UP_COUNT_SUM_60(score);
                }
                if (days == TRADE_DAYS_60) {
                    stockAdrCount.setADR_UP_COUNT_60(score);
                    stockAdrCount.setADR_UP_COUNT_SUM_60(score);
                }
                statRsStAdrCountMap.put(code, stockAdrCount);
            }
        }
//        return statRsStAdrCountMap;
    }

    /**
     * 查询n个交易日之前的日期,日过不存在，使用指定日期减去自然日的日期
     *
     * @param endDate 结束日期
     * @param days    n天之前
     * @return 计算结果日期
     */
    public static String findBegDate(String endDate, Integer days) {
        //如果交易日缓存的第一天是结束日期，从交易日缓存中获取
        String tradeDay0 = mapTradeDay.get(0);
        if (tradeDay0.equals(endDate) && mapTradeDay.size() >= days) {
//            System.out.println("交易日缓存：" + mapTradeDay.get(days));
            return mapTradeDay.get(days);
        }

        List<String> dateList = StockService.findListDateBefore(endDate, days, API_TYPE_SSE);//查询n个交易日之前的日期
        if (dateList != null && dateList.size() > days) {
//            System.out.println("findBegDate.：" + dateList.get(days));
            return dateList.get(days);
        } else {
            System.out.println("查询日期错误.：使用指定日期减去自然日的日期" + JSON.toJSONString(dateList));
            return DateUtil.getCurDateStrAddDaysByFormat(DateUtil.YYYY_MM_DD, days);
        }
    }

    /**
     * 统计股票涨跌幅次数-根据条件
     *
     * @param condition 查询条件
     * @return 统计股票涨跌幅次数
     */
    public static List<StatRsStAdrCount> listStAdrCountByCond(StatCondStAdrCount condition) {
        return RankStockCommpanyDao.findListStatStAdrCount(condition); //  查询-股票涨跌次数
    }

    /**
     * 统计涨跌次数
     *
     * @param date
     * @param stListLikeConception
     * @param daysList
     * @param conpetions
     * @param isShowPriceArea
     */
    public static List<StockAdrCount> showAdrCount(String date, List<RankStockCommpanyDb> stListLikeConception, Long board, BigDecimal mvMin, BigDecimal mvMax, List<BigDecimal> adrMinList, List<Integer> daysList, String conpetions, String reportQuete, boolean isShowPriceArea) {
        List<StockAdrCount> stockAdrCountList = new ArrayList<>();
        Map<String, StockAdrCount> statRsStAdrCountMap = new HashMap<>();
        ExecutorService service = Executors.newCachedThreadPool();// 创建一个的线程池
        for (BigDecimal adrMinTemp : adrMinList) {
            //涨幅超过
            for (Integer days : daysList) {
                service.execute(() -> {
                    StockService.statStAdrCount(stListLikeConception, date, days, adrMinTemp, board, mvMin, mvMax, statRsStAdrCountMap);//统计次数：90
                });
            }
        }

        // 等待子线程结束，再继续执行下面的代码
        service.shutdown();
        while (true) {
            if (service.isTerminated()) {
                System.out.println("service-thread-ok!" + "线程池状态：" + service);
                break;
            }
            try {
//                System.out.println("线程池状态：" + service);
//                service.awaitTermination(20, TimeUnit.SECONDS);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<StockAdrCount> statRsStAdrCountList = new ArrayList<>();
        for (String code : statRsStAdrCountMap.keySet()) {
            StockAdrCount statRsStAdrCount = statRsStAdrCountMap.get(code);
            statRsStAdrCountList.add(statRsStAdrCount);
        }
        statRsStAdrCountList = statRsStAdrCountList.stream().filter(e -> e != null).sorted(Comparator.comparing(StockAdrCount::getADR_UP_COUNT_SUM_60, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());

        Map<String, RankStockCommpanyDb> stDbMap = new HashMap<>();
        for (RankStockCommpanyDb rankStockCommpanyDb : stListLikeConception) {
            stDbMap.put(rankStockCommpanyDb.getF12(), rankStockCommpanyDb);
//                System.out.println(rankStockCommpanyDb.getF12()+":"+rankStockCommpanyDb.getF14()+":"+rankStockCommpanyDb.getF3());
        }
////            checkMaDemo(stMap, date, true, maList, KLT_15);//    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
////            checkMaDemo(stMap, date, true, maList, KLT_30);//    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
////            checkMaDemo(stMap, date, true, maList, KLT_60);//    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
////            checkMaDemo(stMap, date, true, maList, KLT_101);//    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101

        System.out.println("[" + JSON.toJSONString(conpetions) + "]：" + stListLikeConception.size() + ";");
        BigDecimal orderNum = new BigDecimal("0");
        for (StockAdrCount statRsStAdrCount : statRsStAdrCountList) {
            StringBuffer sb = new StringBuffer();
//                System.out.println(JSON.toJSONString(statRsStAdrCount));
            String zqdm = statRsStAdrCount.getF12();
            BigDecimal stAdrCount = statRsStAdrCount.getADR_UP_COUNT_SUM_60();

            RankStockCommpanyDb rankStockCommpanyDb = stDbMap.get(zqdm);
            String biz = StockUtil.formatBizName(rankStockCommpanyDb.getType_name());
            String adr = StockUtil.formatDouble(rankStockCommpanyDb.getF3());
            String liangBi = StockUtil.formatDouble(rankStockCommpanyDb.getF10());
            String stName = StockUtil.handlerStName(rankStockCommpanyDb.getF14());
            BigDecimal curPrice = rankStockCommpanyDb.getF2();
            BigDecimal marketValue = null;
            if (rankStockCommpanyDb.getF20() != null) {
                marketValue = rankStockCommpanyDb.getF20().divide(new BigDecimal("100000000"), 2, BigDecimal.ROUND_HALF_UP);
            }

//            sb.append(stCode).append("\t");
//            sb.append(stName).append("\t");
            sb.append(stAdrCount).append("\t");
            sb.append(biz).append(" ");
            sb.append(adr).append("\t");
            sb.append(marketValue).append("\t");
            sb.append(liangBi).append("\t");
            //            map.put("002432", "");//002432	九安医疗	医疗器械
            String concepPinYin = "mapGn";
            if (ConceptionUtil.stConceptionMap.get(conpetions) != null) {
                concepPinYin = ConceptionUtil.stConceptionMap.get(conpetions);
            }
//            System.out.print(concepPinYin + ".put(\"" + zqdm + "\", \"" + stName + "\");//");//map  map.put("002432", "");//002432	九安医疗	医疗器械
//                System.out.println("mapTemp.put(\"" + stCode + "\", \"" + stName.replace(" ","") + "\");//" + stCode + " " + stName + " " + stAdrCount + " " + biz + " ");
//            System.out.print(sb);

            RankStockCommpanyDb stock = new RankStockCommpanyDb();
            stock.setF12(statRsStAdrCount.getF12());
            StringBuffer maSb = new StringBuffer();
            if (isShowPriceArea) {
                Map<String, Boolean> maUpdateMap = new HashMap<>();
                StockControl.setMaMapType(MA_TYPE_DAY, maUpdateMap);
                StringBuffer sbPriceArea = new StringBuffer();
                StockControl.handlerNetMa(stock, maUpdateMap, date, sbPriceArea, new StockAdrCountVo());//处理均线净值
//            maSb.append("\t").append(",当前价：").append(curPrice);
//            maSb.append("\t").append(",当前：").append(DateUtil.getToday(DateUtil.YYYY_MM_DD_HH_MM_SS));
                System.out.println("价格区间:" + sbPriceArea.toString());
            }
            if (StringUtils.isNotBlank(reportQuete)) {
                ReportService.handlerReport(maSb, stock, reportQuete);
            }
//            System.out.println();

            statRsStAdrCount.setType_name(rankStockCommpanyDb.getType_name());
            statRsStAdrCount.setConception(rankStockCommpanyDb.getConception());
            statRsStAdrCount.setDate(date);
            if (rankStockCommpanyDb.getF2() != null) {
                statRsStAdrCount.setF2(rankStockCommpanyDb.getF2());
            }
            statRsStAdrCount.setF3(rankStockCommpanyDb.getF3());
            if (rankStockCommpanyDb.getF4() != null) {
                statRsStAdrCount.setF4(new BigDecimal(rankStockCommpanyDb.getF4()));
            }
            statRsStAdrCount.setF5(rankStockCommpanyDb.getF5());
            statRsStAdrCount.setF6(rankStockCommpanyDb.getF6());
            if (rankStockCommpanyDb.getF7() != null) {
                statRsStAdrCount.setF7(new BigDecimal(rankStockCommpanyDb.getF7()));
            }
            if (rankStockCommpanyDb.getF8() != null) {
                statRsStAdrCount.setF8(new BigDecimal(rankStockCommpanyDb.getF8()));
            }
            if (rankStockCommpanyDb.getF9() != null) {
                statRsStAdrCount.setF9(new BigDecimal(rankStockCommpanyDb.getF9()));
            }
            statRsStAdrCount.setF10(rankStockCommpanyDb.getF10());
            statRsStAdrCount.setF12(rankStockCommpanyDb.getF12());
            statRsStAdrCount.setF14(rankStockCommpanyDb.getF14());
            if (rankStockCommpanyDb.getF15() != null) {
                statRsStAdrCount.setF15(new BigDecimal(rankStockCommpanyDb.getF15().toString()));
            }
            if (rankStockCommpanyDb.getF16() != null) {
                statRsStAdrCount.setF16(new BigDecimal(rankStockCommpanyDb.getF16().toString()));
            }
            if (rankStockCommpanyDb.getF17() != null) {
                statRsStAdrCount.setF17(new BigDecimal(rankStockCommpanyDb.getF17().toString()));
            }
            if (rankStockCommpanyDb.getF18() != null) {
                statRsStAdrCount.setF18(new BigDecimal(rankStockCommpanyDb.getF18().toString()));
            }
            statRsStAdrCount.setF20(rankStockCommpanyDb.getF20());
            statRsStAdrCount.setF21(rankStockCommpanyDb.getF21());

//            //处理价格区间
//            statRsStAdrCount.setNET_AREA_DAY_5(KlineService.handlerPriceAreaRate(zqdm, MA_5, KLT_101, false, "", date, KLINE_TYPE_STOCK));
//            statRsStAdrCount.setNET_AREA_DAY_10(KlineService.handlerPriceAreaRate(zqdm, MA_10, KLT_101, false, "", date, KLINE_TYPE_STOCK));
//            statRsStAdrCount.setNET_AREA_DAY_20(KlineService.handlerPriceAreaRate(zqdm, MA_20, KLT_101, false, "", date, KLINE_TYPE_STOCK));
//            statRsStAdrCount.setNET_AREA_DAY_40(KlineService.handlerPriceAreaRate(zqdm, MA_40, KLT_101, false, "", date, KLINE_TYPE_STOCK));
//            statRsStAdrCount.setNET_AREA_DAY_60(KlineService.handlerPriceAreaRate(zqdm, MA_60, KLT_101, false, "", date, KLINE_TYPE_STOCK));
//            statRsStAdrCount.setNET_AREA_DAY_120(KlineService.handlerPriceAreaRate(zqdm, MA_120, KLT_101, false, "", date, KLINE_TYPE_STOCK));
//            statRsStAdrCount.setNET_AREA_DAY_250(KlineService.handlerPriceAreaRate(zqdm, MA_250, KLT_101, false, "", date, KLINE_TYPE_STOCK));

            orderNum = orderNum.add(new BigDecimal("1"));
            statRsStAdrCount.setOrder_num(orderNum);

            stockAdrCountList.add(statRsStAdrCount);
        }
        return stockAdrCountList;
    }


    public static List<StockAdrCount> listAdrCount(String date, List<RankStockCommpanyDb> stList, Long board, BigDecimal mvMin, BigDecimal mvMax, List<BigDecimal> adrMinList, List<Integer> daysList) {
        List<StockAdrCount> stockAdrCountList = new ArrayList<>();
        Map<String, StockAdrCount> statRsStAdrCountMap = new HashMap<>();
        ExecutorService service = Executors.newCachedThreadPool();// 创建一个的线程池
        for (BigDecimal adrMinTemp : adrMinList) {
            //涨幅超过
            for (Integer days : daysList) {
                service.execute(() -> {
                    StockService.statStAdrCount(stList, date, days, adrMinTemp, board, mvMin, mvMax, statRsStAdrCountMap);//统计次数：90
                });
            }
        }

        // 等待子线程结束，再继续执行下面的代码
        service.shutdown();
        while (true) {
            if (service.isTerminated()) {
                System.out.println("service-thread-ok!" + "线程池状态：" + service);
                break;
            }
            try {
//                System.out.println("线程池状态：" + service);
//                service.awaitTermination(20, TimeUnit.SECONDS);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<StockAdrCount> statRsStAdrCountList = new ArrayList<>();
        for (String code : statRsStAdrCountMap.keySet()) {
            StockAdrCount statRsStAdrCount = statRsStAdrCountMap.get(code);
            statRsStAdrCountList.add(statRsStAdrCount);
        }
        statRsStAdrCountList = statRsStAdrCountList.stream().filter(e -> e != null).sorted(Comparator.comparing(StockAdrCount::getADR_UP_COUNT_SUM_60, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());

        Map<String, RankStockCommpanyDb> stDbMap = new HashMap<>();
        for (RankStockCommpanyDb rankStockCommpanyDb : stList) {
            stDbMap.put(rankStockCommpanyDb.getF12(), rankStockCommpanyDb);
//                System.out.println(rankStockCommpanyDb.getF12()+":"+rankStockCommpanyDb.getF14()+":"+rankStockCommpanyDb.getF3());
        }

        BigDecimal orderNum = new BigDecimal("0");
        for (StockAdrCount statRsStAdrCount : statRsStAdrCountList) {
            StringBuffer sb = new StringBuffer();
//                System.out.println(JSON.toJSONString(statRsStAdrCount));
            String zqdm = statRsStAdrCount.getF12();
            BigDecimal stAdrCount = statRsStAdrCount.getADR_UP_COUNT_SUM_60();

            RankStockCommpanyDb rankStockCommpanyDb = stDbMap.get(zqdm);

            RankStockCommpanyDb stock = new RankStockCommpanyDb();
            stock.setF12(statRsStAdrCount.getF12());

            statRsStAdrCount.setType_name(rankStockCommpanyDb.getType_name());
            statRsStAdrCount.setConception(rankStockCommpanyDb.getConception());
            statRsStAdrCount.setDate(date);
            if (rankStockCommpanyDb.getF2() != null) {
                statRsStAdrCount.setF2(rankStockCommpanyDb.getF2());
            }
            statRsStAdrCount.setF3(rankStockCommpanyDb.getF3());
            if (rankStockCommpanyDb.getF4() != null) {
                statRsStAdrCount.setF4(new BigDecimal(rankStockCommpanyDb.getF4()));
            }
            statRsStAdrCount.setF5(rankStockCommpanyDb.getF5());
            statRsStAdrCount.setF6(rankStockCommpanyDb.getF6());
            if (rankStockCommpanyDb.getF7() != null) {
                statRsStAdrCount.setF7(new BigDecimal(rankStockCommpanyDb.getF7()));
            }
            if (rankStockCommpanyDb.getF8() != null) {
                statRsStAdrCount.setF8(new BigDecimal(rankStockCommpanyDb.getF8()));
            }
            if (rankStockCommpanyDb.getF9() != null) {
                statRsStAdrCount.setF9(new BigDecimal(rankStockCommpanyDb.getF9()));
            }
            statRsStAdrCount.setF10(rankStockCommpanyDb.getF10());
            statRsStAdrCount.setF12(rankStockCommpanyDb.getF12());
            statRsStAdrCount.setF14(rankStockCommpanyDb.getF14());
            if (rankStockCommpanyDb.getF15() != null) {
                statRsStAdrCount.setF15(new BigDecimal(rankStockCommpanyDb.getF15().toString()));
            }
            if (rankStockCommpanyDb.getF16() != null) {
                statRsStAdrCount.setF16(new BigDecimal(rankStockCommpanyDb.getF16().toString()));
            }
            if (rankStockCommpanyDb.getF17() != null) {
                statRsStAdrCount.setF17(new BigDecimal(rankStockCommpanyDb.getF17().toString()));
            }
            if (rankStockCommpanyDb.getF18() != null) {
                statRsStAdrCount.setF18(new BigDecimal(rankStockCommpanyDb.getF18().toString()));
            }
            statRsStAdrCount.setF20(rankStockCommpanyDb.getF20());
            statRsStAdrCount.setF21(rankStockCommpanyDb.getF21());

            orderNum = orderNum.add(new BigDecimal("1"));
            statRsStAdrCount.setOrder_num(orderNum);

            stockAdrCountList.add(statRsStAdrCount);
        }
        return stockAdrCountList;
    }

    /**
     * 查询股票涨跌个数
     *
     * @param condition
     * @return
     */
    public static Integer count(CondStock condition) {
        return RankStockCommpanyDao.count(condition); //  查询-股票涨跌次数
    }


}
