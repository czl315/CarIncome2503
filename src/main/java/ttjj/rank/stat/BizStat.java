package ttjj.rank.stat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import ttjj.dao.BizRankDao;
import ttjj.db.RankStockCommpanyDb;
import ttjj.db.StockAdrCount;
import ttjj.dto.*;
import ttjj.service.BizService;
import ttjj.service.FundFlowService;
import ttjj.service.KlineService;
import ttjj.service.StockService;
import utils.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import static utils.Content.*;

/**
 * 业务概念
 *
 * @author Administrator
 * @date 2022-02-25 10:41
 */
public class BizStat {
    public static void main(String[] args) {
        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//        String date = "2022-05-11";
//        showGianNian(date);//显示概念涨幅排行榜

        List<BigDecimal> adrMinList = Arrays.asList(new BigDecimal("0"), new BigDecimal("1"), new BigDecimal("3"), new BigDecimal("5"), new BigDecimal("7"), new BigDecimal("9"));
        List<Integer> daysList = Arrays.asList(MA_60, MA_40, MA_20, MA_10, MA_5);
        String reportQuete = "";//业绩报表季度  2022Q1
        boolean isShowPriceArea = false;//是否显示价格区间
        long board = DB_RANK_BIZ_F19_BK_MAIN;
        BigDecimal mvMin = NUM_YI_50;
        BigDecimal mvMax = null;

        {
            //        String conceptions = "体外诊断";//医疗-新冠：新冠检测,新冠药物,体外诊断
            String conceptions = "鸿蒙概念";//科技-软件：华为欧拉,鸿蒙概念
//                String conceptions = "国资云概念";//科技-数字经济:数字货币,智慧政务,国资云概念,电子车牌,数据安全,eSIM,电子身份证,东数西算,ETC,VPN,数据中心,云计算,边缘计算,网络安全,华为昇腾,数字经济,跨境支付,移动支付,区块链,京东金融,       ["eSIM"]：5;
//                String conceptions = "华为欧拉";//科技-传媒：华为欧拉,广电,NFT概念,虚拟数字人,快手概念,手游概念,元宇宙概念,盲盒经济

//        String conceptions = "预制菜概念";//消费-食品: 转基因,代糖概念,社区团购,预制菜概念,超级品牌,调味品概念,水产养殖,鸡肉概念,猪肉概念,乳业,人造肉
//        String conceptions = "统一大市场";//消费-物流:统一大市场,快递概念,海洋经济,中俄贸易概念,RCEP概念,进口博览
//        String conceptions = "草甘膦";//资源-农业: 草甘膦,蝗虫防治,生态农业,农业种植,乡村振兴,宠物经济
//        String conceptions = "肝素概念";//医疗-中药：肝素概念,肝炎概念,长寿药,流感,独家药品,中药概念,超级真菌,阿兹海默,幽门螺杆菌概念
//        String conceptions = "青蒿素";//医疗-创新药：CRO ,青蒿素,CAR-T细胞疗法
//        String conceptions = "土地流转";//金融-房地产：地下管网,建筑节能,民爆概念,REITs概念,海绵城市,租售同权,赛马概念,装配建筑,工程机械概念,水利建设,京津冀,中超概念,
//        String conceptions = "动力电池回收";//科技-新能车：刀片电池,盐湖提锂,固态电池,动力电池回收,钠离子电池,锂电池,氟化工   ["盐湖提锂"];股票个数：18;["氟化工"]：21;
//        String conceptions = "磷化工";//资源-化工: 磷化工,钛白粉,氟化工,有机硅,化工原料,
//        String conceptions = "在线旅游";//消费-旅游:在线旅游,航空机场,盲盒经济,影视概念
//        String conceptions = "滨海新区";//地区板块:沪企改革,上海自贸,滨海新区

//        String conceptions = "上证50_";//指数:上证50_,HS300_,茅指数
        }
//        List<RankStockCommpanyDb> stList = StockService.listlikeConception(date, conceptions, board, mvLimit);//查询股票列表-根据概念
//        showAdrCount(date, stList, board, mvLimit, adrMinList, daysList, conceptions, reportQuete);//统计涨跌次数
//
//        Map<String, String> zqMap = new HashMap<>();
//        for (RankStockCommpanyDb stock : stList) {
//            zqMap.put(stock.getF12(), stock.getF14());
//        }
//        StockStat.checkMaDemo(zqMap, date);

//        按板块查询
        List<RankBizDataDiff> bizList = StockService.listBiz(NUM_MAX_99);//查询主题排名by时间类型、显示个数
//        int limit = NUM_MAX_99;//限定个数
        int limit = 1;//限定个数
        int stBizCountTemp = 0;
        for (RankBizDataDiff rankBizDataDiff : bizList) {
            if (--limit < 0) {
                break;
            }
            String biz = "银行";//银行  航空机场    证券
//            String biz = rankBizDataDiff.getF14();
            System.out.println("-------------------------当前stBizCountTemp：" + (++stBizCountTemp) + "---" + biz);
            CondStock condition = new CondStock();
            condition.setDate(date);
            condition.setF139(board);
            condition.setMvMin(mvMin);
            condition.setMvMax(mvMax);
            condition.setType_name(biz);
            List<RankStockCommpanyDb> stList = StockService.findListByCondition(condition);//查询股票列表-根据板块：
            List<StockAdrCount> stockAdrCountList = StockService.showAdrCount(date, stList, board, mvMin,mvMax, adrMinList, daysList, biz, reportQuete, isShowPriceArea);//统计涨跌次数
//            System.out.println("插入成功-涨幅次数统计：" + StockAdrCountService.insertListOrUpdate(stockAdrCountList));

            Map<String, String> zqMap = new HashMap<>();
            for (RankStockCommpanyDb stock : stList) {
                zqMap.put(stock.getF12(), stock.getF14());
            }
            checkMaDemo(zqMap, date);
        }


//        int year = DateUtil.getCurYear();//DateUtil.getCurYear() 2021
//        int month = DateUtil.getCurMonth();//DateUtil.getCurMonth()   12
//        int day = 1;//DateUtil.getCurDay()   27
//        statEtfAdrDb(etfBizSet, year, month, day, 18);//统计涨跌次数-按照天的维度

        //检查资金流向-etf
//        checkFundFlowByEtf(date);

//        //        // 统计涨跌次数-根据每月中的日期
//        String zqmc = "159949";//512800 510050:上证50ETF  512000:券商ETF
//        String begDate = "2020-01-01";//开始时间
//        String endDate = date;//DateUtil.getToday(DateUtil.YYYY_MM_DD)
//        statAdrCountByDay(zqmc, begDate, endDate);

    }

    /**
     * 检查均线
     *
     * @param zqMap
     */
    public static void checkMaDemo(Map<String, String> zqMap, String date) {
//        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);//                        String date = "2022-02-15";
        boolean isUp = true;//检查上涨
        boolean isDown = true;//检查
//        boolean isUp = false;

        List<Integer> maList = new ArrayList<>();
//        maList.add(MA_30);
        maList.add(MA_60);

//        KlineService.checkMa(zqMap, KLT_5, maList, date, isUp,null);// //    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
        KlineService.checkMa(zqMap, KLT_15, maList, date, isUp, isDown, null, true);// //    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
        KlineService.checkMa(zqMap, KLT_30, maList, date, isUp, isDown, null, true);// //    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
        KlineService.checkMa(zqMap, KLT_60, maList, date, isUp, isDown, null, true);// //    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
        KlineService.checkMa(zqMap, KLT_101, maList, date, isUp, isDown, null, true);// //    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
        KlineService.checkMa(zqMap, KLT_102, maList, date, isUp, isDown, null, true);// //    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
    }


    /**
     * 检查均线
     *
     * @param date
     * @param isUp
     */
    private static void maCheck(String date, boolean isUp) {
        Map<String, String> etfBizMap = new HashMap<>();
        List<Integer> maList = new ArrayList<>();
//        maList.add(MA_30);
        maList.add(MA_60);
        etfBizMap = ContentEtf.mapEtfAll;//mapEtfBiz mapEtfIndex    mapEtfAll
        if (isUp) {
//        checkMaDemo(etfBizMap, date, true, maList, KLT_5);//    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
            checkMaDemo(etfBizMap, date, true, maList, KLT_15);//    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
            checkMaDemo(etfBizMap, date, true, maList, KLT_30);//    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
            checkMaDemo(etfBizMap, date, true, maList, KLT_60);//    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
            checkMaDemo(etfBizMap, date, true, maList, KLT_101);//    检查均线:买入信号   KLT_15 KLT_30  KLT_60 KLT_101
        } else {
            checkMaDemo(etfBizMap, date, false, maList, KLT_15);//    检查均线:卖出信号
            checkMaDemo(etfBizMap, date, false, maList, KLT_30);//    检查均线:卖出信号
            checkMaDemo(etfBizMap, date, false, maList, KLT_60);//    检查均线:卖出信号
            checkMaDemo(etfBizMap, date, false, maList, KLT_101);//    检查均线:卖出信号
        }


    }

    /**
     * 统计涨跌次数-根据每月中的日期
     */
    private static void statAdrCountByDay(String zqdm, String begDate, String endDate) {
        String klt = KLT_101;
        List<String> stCodeList = new ArrayList<>();
        stCodeList.add(zqdm);
        BigDecimal adrMin = new BigDecimal("0");

        StatCondStAdrCountBiz condition = new StatCondStAdrCountBiz();//查询条件
        condition.setKlt(klt);
        condition.setType(DB_RANK_BIZ_TYPE_ETF);
        condition.setBegDate(begDate);
        condition.setEndDate(endDate);
        condition.setStCodeList(stCodeList);

        String zqmc = "";
        List<StatRsStAdrCountBiz> rsAll = BizRankDao.findListStatStAdrCount(condition); //  查询-涨跌次数-所有
        for (StatRsStAdrCountBiz statRsStAdrCountBiz : rsAll) {
            zqmc = statRsStAdrCountBiz.getName();
//            System.out.println(JSON.toJSONString(r));
        }
        condition.setAdrMin(adrMin);
        List<StatRsStAdrCountBiz> rsGt0 = BizRankDao.findListStatStAdrCount(condition); //  查询-涨跌次数-涨跌大于n
        for (StatRsStAdrCountBiz r : rsGt0) {
//            System.out.println(JSON.toJSONString(r));
        }

        System.out.println(zqdm + ":" + zqmc);

        List<String> days = new ArrayList<>();

        days = Arrays.asList("01,02,03,04,05".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("06,07,08,09,10".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("06".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("07".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("08".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("09".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("10".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("11".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("12".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("13".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("14".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("15".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("11,12,13,14,15".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("16,17,18,19,20".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("21,22,23,24,25".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("26,27,28,29,30".split(","));
        staticsPct(rsGt0, rsAll, days);
        days = Arrays.asList("31".split(","));
        staticsPct(rsGt0, rsAll, days);

    }

    /**
     * 统计百分比-涨跌次数
     *
     * @param rsGt0
     * @param rsAll
     * @param days
     */
    private static BigDecimal staticsPct(List<StatRsStAdrCountBiz> rsGt0, List<StatRsStAdrCountBiz> rsAll, List<String> days) {
        Map<String, BigDecimal> mapRsGt0 = new HashMap();
        Map<String, BigDecimal> mapRsAll = new HashMap();
        for (StatRsStAdrCountBiz rsGt0Temp : rsGt0) {
            mapRsGt0.put(rsGt0Temp.getRsDate(), rsGt0Temp.getCount());//大于n的次数s
        }
        for (StatRsStAdrCountBiz rsTemp : rsAll) {
            mapRsAll.put(rsTemp.getRsDate(), rsTemp.getCount());//总次数
        }

        List<StatRsStAdrCountKline> rs = new ArrayList<>();
        for (String day : days) {
            StatRsStAdrCountKline statRsStAdrCountKline = new StatRsStAdrCountKline();
            BigDecimal countGt = mapRsGt0.get(day);
            BigDecimal countAll = (mapRsAll.get(day));
            statRsStAdrCountKline.setCountGt(countGt);
            statRsStAdrCountKline.setCountAll(countAll);
            BigDecimal pct = countGt.divide(countAll, 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100"));
            statRsStAdrCountKline.setPctCount(pct);
            statRsStAdrCountKline.setRsDate(day);
            rs.add(statRsStAdrCountKline);
        }
        BigDecimal conutGtSum = new BigDecimal("0");
        BigDecimal conutAllSum = new BigDecimal("0");
        for (StatRsStAdrCountKline r : rs) {
//            System.out.println(JSON.toJSONString(r));
            conutGtSum = conutGtSum.add(r.getCountGt());
            conutAllSum = conutAllSum.add(r.getCountAll());
        }
        BigDecimal pct = conutGtSum.divide(conutAllSum, 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_UP);
        System.out.println("日期：" + JSON.toJSONString(days) + "，上涨概率:" + pct);

        return pct;
    }








    /**
     * 显示概念涨幅排行榜
     */
    private static void showGianNian(String date) {
        List<RankBizDataDiff> rankList = BizService.listConcept(date, DB_RANK_BIZ_TYPE_GAI_NIAN, NUM_MAX_999);//查询主题排名by时间类型、显示个数
        System.out.println("排行榜-概念：");
        for (RankBizDataDiff etf : rankList) {
            System.out.print(etf.getF14() + ",");
//            System.out.print(etf.getF14() + ":" + etf.getF3());
        }
        System.out.println();
    }

    /**
     * 检查均线
     *
     * @param etfBizMap
     * @param date
     * @param isUp
     * @param maList
     * @param kltType
     */
    public static void checkMaDemo(Map<String, String> etfBizMap, String date, boolean isUp, List<Integer> maList, String kltType) {
//        Map<String, String> etfBizMap = ContentEtf.mapEtfAll;//mapEtfBiz mapEtfIndex    mapEtfAll
//        List<RankBizDataDiff> rankEtf = listEtf(date, DB_RANK_BIZ_TYPE_ETF, NUM_MAX_999);//
//        for (RankBizDataDiff etf : rankEtf) {
//            etfBizMap.put(etf.getF12(), etf.getF14());
//        }

        KlineService.checkMa(etfBizMap, kltType, maList, date, isUp, false, null, true);// 检查均线
    }


    /**
     * 统计涨跌次数-按照天的维度
     *
     * @param etfBizSet
     * @param days
     * @return
     */
    private static Map<String, StatEtfUpDown> statEtfAdrDb(Set<String> etfBizSet, int year, int month, int day, int days) {
        Map<String, StatEtfUpDown> statRs = new HashMap<>();
        List<StatEtfUpDown> statEtfUpDownList = new ArrayList<>();
        //按照日期，倒序查询
        for (int i = 0; i <= days; i++) {
            String date = DateUtil.getDateStrAddDaysByFormat(DateUtil.YYYY_MM_DD, year, month, day, i);//查询新增交易的开始时间
            Map<String, Object> condition = new HashMap<>();
            condition.put("list", etfBizSet);
            condition.put("date", date);
            List<RankBizDataDiff> rankListUp = BizRankDao.listEtfBiz(condition);
            if (rankListUp == null) {
                continue;
            }
            for (RankBizDataDiff biz : rankListUp) {
                if (rankListUp == null) {
                    return null;
                }
                String code = biz.getF12();
                StatEtfUpDown statEtfUpDown = new StatEtfUpDown();
                if (statRs.containsKey(code)) {
                    statEtfUpDown = statRs.get(code);
                }
                statEtfUpDown.setCode(biz.getF12());
                statEtfUpDown.setName(StockUtil.formatStName(biz.getF14(),6));
                int oldCountCurContinueUp = statEtfUpDown.getCountCurContinueUp();
                int oldCountCurContinueDown = statEtfUpDown.getCountCurContinueDown();
                int oldCountTotalUp = statEtfUpDown.getCountTotalUp();
                int oldCountTotalDown = statEtfUpDown.getCountTotalDown();
                //  当前连续次数合计-上涨:如果上涨，次数加，否则次数重置为0；下跌次数反之
                if (biz.getF3().compareTo(new BigDecimal("0")) > 0) {
                    statEtfUpDown.setCountCurContinueUp(oldCountCurContinueUp + 1);
                    statEtfUpDown.setCountCurContinueDown(0);
                    statEtfUpDown.setCountTotalUp(oldCountTotalUp + 1);
                } else {
                    statEtfUpDown.setCountCurContinueDown(oldCountCurContinueDown + 1);
                    statEtfUpDown.setCountCurContinueUp(0);
                    statEtfUpDown.setCountTotalDown(oldCountTotalDown + 1);
                }
                statRs.put(code, statEtfUpDown);
            }
        }

        statEtfUpDownList.addAll(statRs.values());
        //排序
        statEtfUpDownList = statEtfUpDownList.stream().filter(e -> e != null).sorted(Comparator.comparing(StatEtfUpDown::getCountTotalUp, Comparator.nullsFirst(Integer::compareTo)).reversed()).collect(Collectors.toList());
        System.out.println();
        for (StatEtfUpDown dto : statEtfUpDownList) {
            String name = dto.getName();
            System.out.print(dto.getCode());
            System.out.print("\t累计-涨跌比:" + dto.getCountTotalUp() + ":" + dto.getCountTotalDown());
            System.out.print(" \t当前连续次数合计-涨跌比:" + dto.getCountCurContinueUp() + ":" + dto.getCountCurContinueDown());
            System.out.print("\t");
            if (name.length() < 4) {
                System.out.print(dto.getName());
            } else {
                System.out.print(dto.getName());
            }
            System.out.println();
        }
        return statRs;
    }


    /**
     * 检查资金流向-etf
     *
     * @param date
     */
    private static void checkFundFlowByEtf(String date) {
        List<RankBizDataDiff> etfList = BizStat.listEtf(date, DB_RANK_BIZ_TYPE_ETF, NUM_MAX_999);//2021-04-16:425;
        for (RankBizDataDiff etf : etfList) {
            //限定总市值10亿
            if (etf.getF20().compareTo(new BigDecimal("1000000000")) > 0) {
                FundFlowService.fundFlowHandler(etf.getF12(), null);
            }
        }
    }

    /**
     * 计算最大净值、最小净值
     *
     * @return
     */
    private static Map<String, Double> handlerMaxJz(List<String> klineList) {
        Map<String, Double> rs = new HashMap<String, Double>();
        Double rsMax = 0.0;
        Double rsMin = 0.0;
        Double lastDwjz = 0.0;
        Double rsNetCloseMin = 0.0;
        Double rsNetCloseMax = 0.0;
        int curTempInt = 0;
        for (String klineStr : klineList) {
            //  日期，开盘，收盘,最高，最低，成交量，成交额，振幅，涨跌幅，涨跌额，换手率
            //"2020-09-30,3389.74,3218.05,3425.63,3202.34,4906229054,6193724911616.00,6.58,-5.23,-177.63,13.40"
            String[] klineArray = klineStr.split(",");
            String shouPan = klineArray[2];
            String netMax = klineArray[3];
            String netMin = klineArray[4];
            String zhangDie = klineArray[8];
            String chengJiaoE = klineArray[6];
            String curDate = klineArray[0];
//            System.out.print("日期:" + curDate + ",");
//            System.out.print("收盘:" + shouPan + ",");
//            System.out.print("涨跌幅:" + zhangDie + ",\t");
//            System.out.print("开盘:" + klineArray[1] + ",\t");
//            System.out.print("最高:" + klineArray[3] + ",");
//            System.out.print("最低:" + klineArray[4] + ",");
//            System.out.print("成交量:\t" + klineArray[5] + ",\t\t");
//            System.out.print("成交额:\t" + klineArray[6] + ",\t\t");
//            System.out.print("振幅:" + klineArray[7] + ",");
//            System.out.print("涨跌额:" + klineArray[9] + ",");
//            System.out.print("换手率:" + klineArray[10] + ",");
//            System.out.println();

//                    System.out.println(JSON.toJSONString(lsjzDataLsjz));
//            String dwJz = lsjzDataLsjz.getDWJZ();//当晚净值
            String dwJz = shouPan;//累计净值

            if (StringUtils.isBlank(dwJz)) {
                dwJz = "0";
            }
            String fsrq = curDate;
//            System.out.println("fsrq:" + fsrq + ",dwjzLong:" + dwJz);

            Double netMaxDou = Double.valueOf(netMax);
            if (netMaxDou > rsMax) {
                rsMax = netMaxDou;
            }
            Double netMinDou = Double.valueOf(netMin);
            if (netMinDou < rsMin || rsMin == 0.0) {
                rsMin = netMinDou;
            }

            //
            Double dwjzLong = Double.valueOf(dwJz);
            if (dwjzLong > rsNetCloseMax) {
                rsNetCloseMax = dwjzLong;
            }
            if (dwjzLong < rsNetCloseMin || rsNetCloseMin == 0.0) {
                rsNetCloseMin = dwjzLong;
            }
        }
        rs.put(Content.keyRsMax, rsMax);
        rs.put(Content.keyRsMin, rsMin);
        rs.put(Content.keyRsNetCloseMin, rsNetCloseMin);
        rs.put(Content.keyRsNetCloseMax, rsNetCloseMax);
        return rs;
    }


    public static List<RankBizDataDiff> listEtf(String date, String type, int pageSize) {
//          http://32.push2.eastmoney.com/api/qt/clist/get?cb=jQuery11240476946102335426_1618637035810&pn=1&pz=20&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=b:MK0021,b:MK0022,b:MK0023,b:MK0024&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f22,f11,f62,f128,f136,f115,f152&_=1618637035811
        String url = "http://32.push2.eastmoney.com/api/qt/clist/get";
        StringBuffer urlParam = new StringBuffer();
        long curTime = System.currentTimeMillis();
        urlParam.append("cb=jQuery11240476946102335426_" + curTime +
                "&pn=1" +//页数
                "&pz=" + pageSize +//每页数量
                "&po=1" +//pageorder:页面排序：0-正序；1-倒序
                "&np=1" +//是否分页：1-分页
                "&ut=bd1d9ddb04089700cf9c27f6f7426281" +
                "&fltt=2" +//浮点数精度
                "&invt=3" +//显示格式：2-"-"；3-"0.0"
                "&fid=f3" +//排序字段
                "&fs=b:MK0021,b:MK0022,b:MK0023,b:MK0024" +
                "&fields=" +
                "f1,f2,f3,f4,f5,f6,f7,f8,f9," +
                "f10,f11,f12,f13,f14,f15,f16,f17,f18,f19," +
                "f20,f21,f22,f23,f24,f25,f26,f27,f28,f29," +
                "f30,f31,f32,f33,f34,f35,f36,f37,f38,f39," +
                "f40,f41,f42,f43,f44,f45,f46,f47,f48,f49," +
                "f50,f51,f52,f53,f54,f55,f56,f57,f58,f59," +
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
//                "f230,f231,f232,f233,f234,f235,f236,f237,f238,f239" +

//                "f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222" +

                "&_=" + curTime);
        String rs = HttpUtil.sendGet(url, urlParam.toString(), "");
//        System.out.println(rs);
        if (rs == null) {
            return null;
        }
        if (rs.startsWith("jQuery")) {
            rs = rs.substring(rs.indexOf("{"));
        }
        if (rs.endsWith(");")) {
            rs = rs.substring(0, rs.length() - 2);
        }
//        System.out.println(rs);//返回结果
        JSONObject rsJsonObj = JSONObject.parseObject(rs);
        if (rsJsonObj == null || !rsJsonObj.containsKey("data")) {
            System.out.println("---------------data---error!!!!!");
            return null;
        }
        JSONObject rsJsonData = rsJsonObj.getJSONObject("data");
        JSONArray rsJsonDataDiff = rsJsonData.getJSONArray("diff");
        List<RankBizDataDiff> rankBizDataDiffList = JSON.parseArray(JSON.toJSONString(rsJsonDataDiff), RankBizDataDiff.class);
        for (RankBizDataDiff row : rankBizDataDiffList) {
//            row.setRs(rs);
            row.setDate(date);
            row.setMonth(DateUtil.getYearMonth(date, DateUtil.YYYY_MM_DD));
            row.setWeekYear(DateUtil.getYearWeek(date, DateUtil.YYYY_MM_DD));
            row.setWeek(DateUtil.getWeekByYyyyMmDd(date, DateUtil.YYYY_MM_DD));
            row.setType(type);
//            System.out.println(JSON.toJSON(row));//每个行业一行数据
        }

        return rankBizDataDiffList;
    }

}
