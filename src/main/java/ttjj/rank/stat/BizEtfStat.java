package ttjj.rank.stat;

import org.springframework.util.StopWatch;
import ttjj.dao.BizRankDao;
import ttjj.dto.*;
import ttjj.service.BizService;
import ttjj.service.EtfService;
import ttjj.service.KlineService;
import ttjj.service.StockService;
import utils.ContMapEtf;
import utils.DateUtil;
import utils.EtfUtil;
import utils.StockUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import static utils.ContMapEtf.INDEX_MORE;
import static utils.Content.*;
import static utils.DateUtil.YYYY_MM_DD;

/**
 * etf
 */
public class BizEtfStat {
    public static void main(String[] args) {
//        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
        String date = "2025-02-28";


        String spDate = null;//
//        String spDate = DateUtil.getAddDays(YYYY_MM_DD, date, 1);//是否显示特定日期涨跌   "2022-05-18"
        CondMa condMa = new CondMa();
        condMa.setOrderField(NET_AREA_DAY_20);//ORDER_FIELD_NET_AREA_DAY_5 ORDER_FIELD_F3 ORDER_FIELD_MAXDOWN    ORDER_FIELD_MINRISE
//        condMa.setOrderDesc(true);//是否倒序
        condMa.setOrderDesc(false);//是否倒序
        condMa.setDate(date);
        condMa.setDays(3);
        condMa.setSpDate(spDate);
        condMa.setShowPriceArea(true);//是否显示价格区间
//        condMa.setKltList(Arrays.asList(KLT_5, KLT_15, KLT_30, KLT_60, KLT_101, KLT_102));//价格区间周期列表
//        condMa.setKltList(Arrays.asList(KLT_15, KLT_30, KLT_60, KLT_101));//价格区间周期列表
        condMa.setKltList(Arrays.asList(KLT_15, KLT_30, KLT_60, KLT_101, KLT_102));//价格区间周期列表
        condMa.setShowUpMa(true);//是否显示-超过均线
        condMa.setShowDownMa(true);//是否显示-跌落均线
        condMa.setShowBreakDownMaMax(true);//是否显示-跌落均线-最高
        condMa.setShowBreakUpMaMin(true);//是否显示-涨上均线-最低
        condMa.setFindKline(true);//是否查询最新k线
        condMa.setShowFlowIn(false);//是否显示资金流入
        condMa.setShowDateMinMax(false);//是否显示日最低点、最高点
        condMa.setShowMaxMin(true);//是否显最低、最高
//        condMa.setShowPct(true);//是否显示均线百分比
        condMa.setShowPct(true);//是否显示均线百分比
//        condMa.setShowPctKltList(Arrays.asList(KLT_15, KLT_30, KLT_60, KLT_101));
        condMa.setShowPctKltList(Arrays.asList(KLT_60, KLT_102));

//        showEtfUpMa(date,condMa);//etf-超过均线

        showRise();//显示涨幅

//        statListEtfAdrArea(null);//计算区间涨幅
//        statListEtfAdrArea(4);//计算区间涨幅
//        statListEtfAdrArea(10);//计算区间涨幅
//        statListEtfAdrArea(20);//计算区间涨幅
//        statListEtfAdrArea(40);//计算区间涨幅
//        statListEtfAdrArea(60);//计算区间涨幅

//        showEtfMv();//显示etf市值
//        statDayMinMaxTime(date);//k线：每日最高点、最低点

//        listEtfBizDb(ContentEtf.mapEtfAll.keySet(), 0, true, true);//列表查询-行业etf-排序：涨跌幅

    }

    /**
     * ETF：计算区间涨幅
     */
    private static void statListEtfAdrArea(Integer areaDays) {
        if (areaDays == null) {
            areaDays = 4;//4:近一周;20:近一月
        }
        statListEtfAdrArea(areaDays, DB_RANK_BIZ_TYPE_ETF);//DB_RANK_BIZ_TYPE_ZS  DB_RANK_BIZ_TYPE_ETF DB_RANK_BIZ_TYPE_BAN_KUAI
//        statListEtfAdrArea(date, areaDays, isDesc, mvMin, mvMax, limit, false,DB_RANK_BIZ_TYPE_BAN_KUAI);

    }

    /**
     * 统计区间涨幅
     *
     * @param areaDays
     */
    private static void statListEtfAdrArea(int areaDays, String type) {
        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//        String date = "2022-11-01";
        boolean isShowCode = true;//是否显示编码
        boolean isCheckFuQuan = false;//是否检查更新复权
        boolean isOrMianEtf = false;//是否必须查询我的主要etf
        boolean isCheckMianEtf = true;//是否必须查询我的主要etf
        boolean isShowEtfInfo = false;//是否显示etf信息
        Map<String, String> etfMap = INDEX_MORE;//INDEX_ALL     INDEX_MORE   XIAOFEI_ALL_TO_MORE

        BigDecimal mvMin = null;//NUM_YI_1000  NUM_YI_50  NUM_YI_100    NUM_YI_0
        BigDecimal mvMax = null;
        int limit = 500;

        boolean isDesc = true;
//        boolean isDesc = false;

//        String endDate = StockService.findBegDate(date, 0);
        String endDate = date;
        String begDate = StockService.findBegDate(date, areaDays);

        Map<String, BizDto> rsMap = new HashMap<>();

        BizDto condition = new BizDto();
        condition.setDate(endDate);
        condition.setType(type);
        condition.setMvMin(mvMin);
        condition.setMvMax(mvMax);
        if (isCheckMianEtf) {//检查是否是主要etf
            condition.setStCodeList(EtfUtil.getMainEtf(etfMap));
        }
//        if (isOrMianEtf) {
//            condition.setMvMinStCodeOrList(getMainEtf(null));//我的主要etf
//        }
        List<BizDto> etfListEndDate = BizService.findListDbBiz(condition);

        for (BizDto etf : etfListEndDate) {
            BizDto rsOne = new BizDto();
            rsOne.setF14(etf.getF14());
            rsOne.setF12(etf.getF12());
            rsOne.setF3(etf.getF3());
            BigDecimal marketValue = null;
            if (etf.getF20() != null) {
                marketValue = etf.getF20().divide(NUM_YI_1, 2, BigDecimal.ROUND_HALF_UP);
            }
            rsOne.setF20(marketValue);
            rsOne.setBegDate(begDate);
            rsOne.setEndDate(endDate);
            rsOne.setEndDateF2(etf.getF2());
            rsMap.put(etf.getF12(), rsOne);
        }

        BizDto condBegDate = new BizDto();
        condBegDate.setDate(begDate);
        condBegDate.setType(type);
        condBegDate.setMvMin(mvMin);
        condBegDate.setMvMax(mvMax);
        if (isCheckMianEtf) {//检查是否是主要etf
            condBegDate.setStCodeList(EtfUtil.getMainEtf(etfMap));
        }
        List<BizDto> etfListBegDate = BizService.findListDbBiz(condBegDate);

        for (BizDto etfBegDate : etfListBegDate) {
            String code = etfBegDate.getF12();
            BigDecimal yestodayNet = etfBegDate.getF18();
            BizDto rsOne = rsMap.get(code);
            if (rsOne == null) {
//                System.out.println("市值已减小：" + JSON.toJSONString(rankStockCommpanyDb));
                continue;
            }
            if (yestodayNet == null) {
//                System.out.println("昨日净值为空：" + JSON.toJSONString(rankStockCommpanyDb));
                continue;
            }
            rsOne.setBegDateF18(yestodayNet);
            rsOne.setF18(yestodayNet);

            //更新复权使用
            rsOne.setF2(etfBegDate.getF2());

            rsMap.put(code, rsOne);
        }

        List<BizDto> rsList = new ArrayList<>();
        //计算区间涨幅
        for (BizDto dto : rsMap.values()) {
            BigDecimal endDateF2 = dto.getEndDateF2();
            BigDecimal begDateF18 = dto.getBegDateF18();
            if (endDateF2 == null) {
//                System.out.println("结束净值为空：" + JSON.toJSONString(dto));
                continue;
            }
            if (begDateF18 == null) {
//                System.out.println("开始净值为空：" + JSON.toJSONString(dto));
                continue;
            }
            BigDecimal adrArea = (endDateF2.subtract(begDateF18)).multiply(new BigDecimal("100")).divide(begDateF18, 2, RoundingMode.HALF_UP);
            dto.setAreaF3(adrArea);
            rsList.add(dto);
        }

        boolean isShowMoreYes = true;
        boolean isShowMoreNo = false;
        if (isDesc) {
            //排序
            rsList = rsList.stream().filter(e -> e != null).sorted(Comparator.comparing(BizDto::getAreaF3, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        } else {
            rsList = rsList.stream().filter(e -> e != null).sorted(Comparator.comparing(BizDto::getAreaF3, Comparator.nullsFirst(BigDecimal::compareTo))).collect(Collectors.toList());
        }
        //区间涨幅
        Map<String, Integer> sizeMap = EtfUtil.showInfoHead(isShowMoreYes, isShowCode, false, null);
        if (isShowEtfInfo) {
            EtfUtil.showInfoEtfType(rsList, begDate, endDate, limit, isShowMoreYes, isShowCode, sizeMap);
        } else {
            EtfUtil.showInfoEtf(rsList, begDate, endDate, limit, isShowMoreYes, isShowCode, sizeMap);
        }
        System.out.println();

        if (isCheckFuQuan) {
            boolean isUpdate = BizService.updateFuQuanBiz(rsList, limit, begDate);//更新复权：前复权，检查当日K线与数据库的数据是否相符，如果不符，进行复权更新
            if (isUpdate) {
                statListEtfAdrArea(areaDays, type);
            }
        }
    }


    /**
     * 每日最高点、最低点
     *
     * @param date
     */
    private static void statDayMinMaxTime(String date) {
        Map<String, String> mapZq = new HashMap<>();
//        mapZq = ContMapEtf.ETF_MV_ZS_CYB;
        mapZq.put("515790", "光伏ETF");//KEJI.put("515790", "光伏ETF       ");//147.52  	-0.18
//        mapZq = MyPositionService.listMyPositionByDate(date);//我的持仓
//        mapZq.put("002027","分众传媒");
        String klineType = null;
//        String klineType = DB_RANK_BIZ_TYPE_ETF;
        for (String zqdm : mapZq.keySet()) {
            String zqmc = mapZq.get(zqdm);
            statDayMinMaxTime(date, zqdm, zqmc, klineType);
        }
    }

    /**
     * 每日最高点、最低点:
     *
     * @param zqdm      编码
     * @param zqmc      名称
     * @param klineType k线类型
     */
    private static void statDayMinMaxTime(String date, String zqdm, String zqmc, String klineType) {
        int days = 60;
        String klt = KLT_15;
//        BigDecimal adrMin = null;
        BigDecimal adrMin = new BigDecimal("1");
        BigDecimal adrMax = null;
//        BigDecimal adrMax = new BigDecimal("0");
        String limitWeek = null;
//        String limitWeek = "一";
        Map<String, KlineDto> mapTimeScore = new HashMap<>();
        //获取最新n个交易日
        System.out.println();
        System.out.print("统计" + zqmc + "最近" + days + "个交易日的数据");
        if (limitWeek != null) {
            System.out.print(",限定周" + limitWeek);
        }
        System.out.println();
        List<Kline> klines = KlineService.kline(zqdm, days, KLT_101, false, null, date, klineType);
        if (klines == null) {
            date = StockService.findBegDate(date, 1);
            klines = KlineService.kline(zqdm, days, KLT_101, false, null, date, klineType);
        }
        if (klines == null) {
            return;
        }
        for (Kline kline : klines) {
            String curDate = kline.getKtime();
//                System.out.println(curDate);
            BigDecimal adr = kline.getZhangDieFu();
            //限定涨跌
            if (adrMin != null && adr.compareTo(adrMin) < 0) {
//                System.out.println(curDate + "(ok)日涨跌低于限定最低涨幅:" + adr + ":" + adrMin);
                continue;
            } else {
//                System.out.println(curDate + "(ok)日涨跌高于限定最低涨幅:" + adr + ":" + adrMin);
            }
            if (adrMax != null && adr.compareTo(adrMax) > 0) {
//                System.out.println(curDate + "(ok)日涨跌高于限定最高涨幅:" + adr + ":" + adrMax);
                continue;
            } else {
//                System.out.println(curDate + "(ok)日涨跌低于限定最高涨幅:" + adr + ":" + adrMax);
            }

            //限定星期几
            if (limitWeek != null) {
                String curDateWeek = DateUtil.getWeekByYyyyMmDd(curDate, DateUtil.YYYY_MM_DD);
                if (curDateWeek != limitWeek) {
                    continue;
                } else {
                    System.out.println(curDate + "限定周一");
                }
            }


            //获取每个交易日的所有5分钟k线
            List<Kline> klineCurDate5MinuteList = KlineService.kline(zqdm, 0, klt, true, curDate, curDate, klineType);
            klineCurDate5MinuteList = klineCurDate5MinuteList.stream().filter(e -> e != null).sorted(Comparator.comparing(Kline::getCloseAmt, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
            BigDecimal initScore = new BigDecimal(klineCurDate5MinuteList.size());
            for (Kline klineCurDate5Minute : klineCurDate5MinuteList) {
                String curTime = klineCurDate5Minute.getKtime();
                String keyCurTime = "";
                if (curTime.length() >= 19) {
                    keyCurTime = curTime.substring(11);
                }
//                    BigDecimal curCloseAmt = klineCurDate5Minute.getCloseAmt();
//                    System.out.println(keyCurTime + ":" + curCloseAmt);

                KlineDto klineDto = new KlineDto();
                klineDto.setZqdm(zqdm);
                klineDto.setZqmc(zqmc);
                klineDto.setKtime(keyCurTime);
                klineDto.setCloseAmt(klineCurDate5Minute.getCloseAmt());
                if (mapTimeScore.containsKey(keyCurTime)) {
                    BigDecimal oldScore = mapTimeScore.get(keyCurTime).getScore();
                    BigDecimal newScore = oldScore.add(initScore);
                    klineDto.setScore(newScore);
                } else {
                    klineDto.setScore(initScore);
                }
                mapTimeScore.put(keyCurTime, klineDto);
                initScore = initScore.subtract(new BigDecimal("1"));
            }
        }


        List<KlineDto> list = new ArrayList<>();
        for (String s : mapTimeScore.keySet()) {
            list.add(mapTimeScore.get(s));
        }
        list = list.stream().filter(e -> e != null).sorted(Comparator.comparing(KlineDto::getScore, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        int i = 0;
        for (KlineDto klineDto : list) {
//            System.out.println(StockUtil.formatStName(++i+"",4) + StockUtil.formatStName(klineDto.getZqmc(),10) + StockUtil.formatStName(klineDto.getKtime().substring(0,5),10) + StockUtil.formatDouble(klineDto.getCloseAmt(),10));
            System.out.println(StockUtil.formatStName(++i + "", 4) + StockUtil.formatStName(klineDto.getZqmc(), 16) + StockUtil.formatStName(klineDto.getKtime().substring(0, 5), 10) + StockUtil.formatDouble(klineDto.getScore(), 10));
        }
        System.out.println();
    }

    /**
     * 显示-etf-市值
     */
    public static void showEtfMv() {
        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//        String date = "2025-02-14";
        Map<String, String> mapMyEtf = ContMapEtf.ETF_All;
        System.out.println(date + "我的etf共收录：" + mapMyEtf.size());
        List<RankBizDataDiff> bizList = BizService.listBiz(date, DB_RANK_BIZ_TYPE_ETF, NUM_MAX_9999);//查询板块行业列表
//        bizList = bizList.stream().filter(e -> e != null).sorted(Comparator.comparing(RankBizDataDiff::getF20, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        bizList = bizList.stream().filter(e -> e != null).sorted(Comparator.comparing(RankBizDataDiff::getF3, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        System.out.println("http etf共：" + bizList.size());
        for (RankBizDataDiff biz : bizList) {
            StringBuffer sb = new StringBuffer();
//            mapMv.put(rankBizDataDiff.getF12(), rankBizDataDiff.getF20());
            String code = biz.getF12();
            String name = biz.getF14();
            String nameFormat = StockUtil.formatStName(name, 24);
            BigDecimal marketValue = biz.getF20().divide(NUM_YI_1, 2, BigDecimal.ROUND_HALF_UP);
            String mvFormat = StockUtil.formatDouble(marketValue, 8);
            BigDecimal adr = biz.getF3();
//            //  名称过滤
//            if (!name.contains("物流") && !name.contains("快递")) {
//            if (!name.contains("软") && !name.contains("数据") && !name.contains("云") && !name.contains("AI") && !name.contains("计算")) {
//                continue;
//            }

//              特定类型

            if (mapMyEtf.keySet().contains(code)) {
                continue;
            }

            sb.append(StockUtil.formatStName(code, 6)).append(" ");
            sb.append(nameFormat).append(" ");
            sb.append(marketValue).append(" ");
//            System.out.println(sb);
//            System.out.println("etf.put(\"" + code + "\", \"" + nameFormat + "\");//" + mvFormat + "\t" + adr + "%");

            //市值判定
            if (marketValue.compareTo(new BigDecimal("0")) > 0) {
                System.out.println("etf.put(\"" + code + "\", \"" + nameFormat + "\");//" + mvFormat + "\t" + adr + "%");
            }
        }
    }

    /**
     * 显示涨幅
     */
    public static void showRise() {
        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//        String date = "2025-02-21";
        boolean isShowAreaRisePctLastDay0ToLastDay20 = true;
        boolean isShowAreaRisePctLastDay20ToLastDay40 = true;
        boolean isShowAreaRisePctLastDay40ToLastDay60 = true;
        int curNo = 1;//序号
        BigDecimal limitMarketValueYi = new BigDecimal("0");
        Map<String, String> mapMyEtf = ContMapEtf.ETF_All;
        System.out.println(date + "我的etf共收录：" + mapMyEtf.size());

        // 查询etf列表，一页最多查询n条，需要分多次查询
        List<BizDto> bizDtoList = new ArrayList<>();
        List<RankBizDataDiff> bizList = new ArrayList<>();
        int maxCount = 100;//最多查询次数
        for (int i = 1; i <= maxCount; i++) {
            List<RankBizDataDiff> curPageEtfList = EtfService.listEtfFromHttp(i, NUM_MAX_99);//查询列表
            if (curPageEtfList.size() > 0) {
//                System.out.println("当前页查询个数：" + curPageEtfList.size());
                bizList.addAll(curPageEtfList);
            } else {
                break;
            }
        }

        //遍历列表，查询最近n个交易日的数据，计算涨幅
        for (RankBizDataDiff rankBizDataDiff : bizList) {
            //  名称过滤
            String name = rankBizDataDiff.getF14();
//            if (!name.contains("软") && !name.contains("数据") && !name.contains("云") && !name.contains("AI") && !name.contains("计算")) {
//            if (!name.contains("物流") && !name.contains("快递")) {
            if (!name.contains("港股科技") && !name.contains("港股通科技") && !name.contains("香港科技") && !name.contains("恒生新经济") && !name.contains("恒生科技指数") && !name.contains("港股通互联网")&& !name.contains("港股互联网")&& !name.contains("港股消费")&& !name.contains("中概互联网")) {
                continue;
            }

            //市值过滤
            BigDecimal marketValue = rankBizDataDiff.getF20().divide(NUM_YI_1, 2, BigDecimal.ROUND_HALF_UP);
            if (marketValue.compareTo(limitMarketValueYi) < 0) {
                continue;
            }

            BizDto bizDto = new BizDto();
            bizDto.setF12(rankBizDataDiff.getF12());
            bizDto.setF14(rankBizDataDiff.getF14());
            bizDto.setF20(rankBizDataDiff.getF20());
            bizDto.setF3(rankBizDataDiff.getF3());

            String code = rankBizDataDiff.getF12();

            int tradeDayLimit20 = 20;//交易日限定数量
            int tradeDayLimit40 = 40;//交易日限定数量
            int tradeDayLimit60 = 60;//交易日限定数量
            String begDate = "";//开始日期
            String endDate = "";//结束日期
            BigDecimal adrArea = null;//区间涨幅

            //计算区间涨幅-最近60
            List<Kline> klines = KlineService.kline(code, tradeDayLimit60, KLT_101, false, date, date, DB_RANK_BIZ_TYPE_ETF);
            if (klines == null || klines.size() == 0) {
                System.out.println("k线为空！");
                continue;
            }
            if (klines.size() >= tradeDayLimit60) {
                Kline klineBegDate = klines.get(0);
                Kline klineEndDate = klines.get(klines.size() - 1);
                begDate = klineBegDate.getKtime();
                endDate = klineEndDate.getKtime();
                adrArea = (klineEndDate.getCloseAmt().subtract(klineBegDate.getCloseAmt())).multiply(new BigDecimal("100")).divide(klineBegDate.getCloseAmt(), 2, RoundingMode.HALF_UP);
                bizDto.setAreaF3(adrArea);
                bizDto.setBegDate(begDate);
                bizDto.setEndDate(endDate);
            }


            //计算区间涨幅-最近20
            if (isShowAreaRisePctLastDay0ToLastDay20 && klines.size() >= tradeDayLimit60 - tradeDayLimit20) {
                Kline klineBegDate = klines.get(tradeDayLimit60 - tradeDayLimit20 - 1);
                Kline klineEndDate = klines.get(klines.size() - 1);
                begDate = klineBegDate.getKtime();
                endDate = klineEndDate.getKtime();
                BigDecimal adrAreaLastDay20 = (klineEndDate.getCloseAmt().subtract(klineBegDate.getCloseAmt())).multiply(new BigDecimal("100")).divide(klineBegDate.getCloseAmt(), 2, RoundingMode.HALF_UP);
                bizDto.setAdrAreaLastDay20(adrAreaLastDay20);
                bizDto.setBegDateLastDay20(begDate);
                bizDto.setEndDateLastDay20(endDate);
            }

            //计算区间涨幅-最近20至40
            if (isShowAreaRisePctLastDay20ToLastDay40 && klines.size() >= tradeDayLimit60 - tradeDayLimit20) {
                Kline klineBegDate = klines.get(tradeDayLimit60 - tradeDayLimit40 - 1);
                Kline klineEndDate = klines.get(tradeDayLimit60 - tradeDayLimit20 - 1);
                begDate = klineBegDate.getKtime();
                endDate = klineEndDate.getKtime();
                BigDecimal adrAreaLastDay = (klineEndDate.getCloseAmt().subtract(klineBegDate.getCloseAmt())).multiply(new BigDecimal("100")).divide(klineBegDate.getCloseAmt(), 2, RoundingMode.HALF_UP);
                bizDto.setAdrAreaLastDay20To40(adrAreaLastDay);
                bizDto.setBegDateLastDay20To40(begDate);
                bizDto.setEndDateLastDay20To40(endDate);
            }

            //计算区间涨幅-最近40至60
            if (isShowAreaRisePctLastDay40ToLastDay60 && klines.size() >= tradeDayLimit60) {
                Kline klineBegDate = klines.get(tradeDayLimit60 - 1);
                Kline klineEndDate = klines.get(tradeDayLimit60 - tradeDayLimit20 - 1);
                begDate = klineBegDate.getKtime();
                endDate = klineEndDate.getKtime();
                BigDecimal adrAreaLastDay = (klineEndDate.getCloseAmt().subtract(klineBegDate.getCloseAmt())).multiply(new BigDecimal("100")).divide(klineBegDate.getCloseAmt(), 2, RoundingMode.HALF_UP);
                bizDto.setAdrAreaLastDay20To40(adrAreaLastDay);
                bizDto.setBegDateLastDay20To40(begDate);
                bizDto.setEndDateLastDay20To40(endDate);
            }

            bizDtoList.add(bizDto);
        }

        //对数据列表进行排序
//        bizList = bizList.stream().filter(e -> e != null).sorted(Comparator.comparing(RankBizDataDiff::getF20, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        bizDtoList = bizDtoList.stream().filter(e -> e != null).sorted(Comparator.comparing(BizDto::getAreaF3, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
//        bizDtoList = bizDtoList.stream().filter(e -> e != null).sorted(Comparator.comparing(BizDto::getF3, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());
        System.out.println("http etf共：" + bizDtoList.size());

        //遍历列表，查询最近n个交易日的数据，计算涨幅
        for (BizDto biz : bizDtoList) {
            StringBuffer sb = new StringBuffer();
            String code = biz.getF12();
            String name = biz.getF14();
            BigDecimal marketValue = biz.getF20().divide(NUM_YI_1, 2, BigDecimal.ROUND_HALF_UP);
            String mvFormat = StockUtil.formatDouble(marketValue, 8);
            BigDecimal adr = biz.getF3();
            BigDecimal adrArea = biz.getAreaF3();
            String begDate = biz.getBegDate();//开始日期
            String endDate = biz.getEndDate();//结束日期

//              特定类型
//            if (mapMyEtf.keySet().contains(code)) {
//                continue;
//            }

            //市值判定
            if (marketValue.compareTo(limitMarketValueYi) > 0) {
//                sb.append("JINRONG_ALL.put(\""+code+"\", \"金融\");//");
                sb.append(StockUtil.formatInt(curNo++, 5));
                sb.append(StockUtil.formatStName(code, 8));
                sb.append(StockUtil.formatStName(name, 22));
//                sb.append(StockUtil.formatStName((adr + "%"), 10));
                sb.append(mvFormat).append(" ");

                if (begDate != null) {
                    sb.append(StockUtil.formatStr(begDate, 14));
                } else {
                    sb.append(StockUtil.formatStr("", 14));
                }
                if (endDate != null) {
                    sb.append(StockUtil.formatStr(endDate, 14));
                } else {
                    sb.append(StockUtil.formatStr("", 14));
                }
                if (adrArea != null) {
                    sb.append(StockUtil.formatStr(adrArea + "%", 10));
                } else {
                    sb.append(StockUtil.formatStr("", 10));
                }


                String begDateLastDay20 = biz.getBegDateLastDay20();//开始日期
                String endDateLastDay20 = biz.getEndDateLastDay20();//结束日期
                BigDecimal adrAreaLastDay20 = biz.getAdrAreaLastDay20();
                if (begDateLastDay20 != null) {
                    sb.append(StockUtil.formatStr(begDateLastDay20, 14));
                } else {
                    sb.append(StockUtil.formatStr("", 14));
                }
                if (endDateLastDay20 != null) {
                    sb.append(StockUtil.formatStr(endDateLastDay20, 14));
                } else {
                    sb.append(StockUtil.formatStr("", 14));
                }
                if (adrAreaLastDay20 != null) {
                    sb.append(StockUtil.formatStr(adrAreaLastDay20 + "%", 10));
                } else {
                    sb.append(StockUtil.formatStr("", 10));
                }


                String begDateLastDay20To40 = biz.getBegDateLastDay20To40();//开始日期
                String endDateLastDay20To40 = biz.getEndDateLastDay20To40();//结束日期
                BigDecimal adrAreaLastDay20To40 = biz.getAdrAreaLastDay20To40();
                if (begDateLastDay20To40 != null) {
                    sb.append(StockUtil.formatStr(begDateLastDay20To40, 14));
                } else {
                    sb.append(StockUtil.formatStr("", 14));
                }
                if (endDateLastDay20To40 != null) {
                    sb.append(StockUtil.formatStr(endDateLastDay20To40, 14));
                } else {
                    sb.append(StockUtil.formatStr("", 14));
                }
                if (adrAreaLastDay20To40 != null) {
                    sb.append(StockUtil.formatStr(adrAreaLastDay20To40 + "%", 10));
                } else {
                    sb.append(StockUtil.formatStr("", 10));
                }


                System.out.println(sb);
//            System.out.println("etf.put(\"" + code + "\", \"" + nameFormat + "\");//" + mvFormat + "\t" + adr + "%");
            }
        }
    }

    /**
     * etf-超过均线:
     * 显示最近3个K线交易日的涨跌
     *
     * @param date
     * @param condMa
     */
    public static void showEtfUpMa(String date, CondMa condMa) {

//        List<String> dateList = StockService.findListDateAfter(date, 2);
//        if (dateList != null && dateList.size() > 1) {
//            spDate = dateList.get(1);//是否显示特定日期涨跌   "2022-05-18"
//        }
        condMa.setDate(date);

        String spDate = null;//
//        String spDate = DateUtil.getAddDays(YYYY_MM_DD, date, 1);//是否显示特定日期涨跌   "2022-05-18"

        long begTime = System.currentTimeMillis();
        System.out.println("etf-检查均线-beg:" + DateUtil.getCurDateStrAddDaysByFormat(DateUtil.YYYY_MM_DD_HH_MM_SS, 0));

        //etf-超过均线:更多检查
        String name = "";
        StopWatch sw = new StopWatch("etf-检查均线");
        checkMaEtfStat("科技:", ContMapEtf.KEJI_MORE, condMa);
        checkMaEtfStat("金融:", ContMapEtf.JINRONG_MORE, condMa);
        checkMaEtfStat("资源:", ContMapEtf.ZIYUAN_MORE, condMa);
        checkMaEtfStat("消费:", ContMapEtf.XIAOFEI_MORE, condMa);
        checkMaEtfStat("医疗:", ContMapEtf.YILIAO_MORE, condMa);
        checkMaEtfStat("指数:", ContMapEtf.INDEX_MORE, condMa);
        System.out.println(name + sw.getTotalTimeSeconds());
        System.out.println(sw.prettyPrint());
        System.out.println(sw.shortSummary());

        System.out.println("etf-检查均线-end:" + DateUtil.getCurDateStrAddDaysByFormat(DateUtil.YYYY_MM_DD_HH_MM_SS, 0) + "，用时：" + (System.currentTimeMillis() - begTime) / 1000);

    }

    /**
     * 检查均线
     *
     * @param name   类别
     * @param etfmap 类别列表
     * @param condMa 条件
     */
    private static void checkMaEtfStat(String name, Map<String, String> etfmap, CondMa condMa) {
        System.out.println(name);
        StopWatch sw = new StopWatch("etf-检查均线-" + name);
        sw.start(name);
        condMa.setMapStock(etfmap);
        KlineService.showStockMa(condMa);
        sw.stop();
        System.out.println(name + sw.getTotalTimeSeconds());
    }


    /**
     * 列表查询-行业etf-排序：涨跌幅
     *
     * @param etfBizSet etf集合
     * @param days
     * @param showUp    是否显示上涨
     * @param showDown  是否显示下跌
     * @return
     */
    private static Map<String, StatEtfUpDown> listEtfBizDb(Set<String> etfBizSet, int days, boolean showUp, boolean showDown) {
        Map<String, StatEtfUpDown> statRs = new HashMap<>();
        List<StatEtfUpDown> statEtfUpDownList = new ArrayList<>();
        //按照日期，倒序查询
        for (int i = 0; i <= days; i++) {
            String date = DateUtil.getCurDateStrAddDaysByFormat(YYYY_MM_DD, -i);
            Map<String, Object> condition = new HashMap<>();
            condition.put("list", etfBizSet);
            condition.put("date", date);
            List<RankBizDataDiff> rankListUp = BizRankDao.listEtfBiz(condition);
            if (rankListUp == null) {
                continue;
            }
            List<RankBizDataDiff> rankListDown = rankListUp.stream().filter(e -> e != null).sorted(Comparator.comparing(RankBizDataDiff::getF3, Comparator.nullsFirst(BigDecimal::compareTo))).collect(Collectors.toList());//倒序
            String curWeekNo = DateUtil.getWeekByYyyyMmDd(date, YYYY_MM_DD);
            if (showUp) {
                if (curWeekNo.equals(DATE_WEEK_5)) {
                }
                System.out.println(date + "上涨:");
                String upListStr = handlerUpOrDownList(rankListUp, 100, true);//处理上涨
                System.out.println(upListStr);//显示
            }
            if (showDown) {
                if (curWeekNo.equals(DATE_WEEK_5)) {
                }
                System.out.println(date + "下跌:");
                String downListStr = handlerUpOrDownList(rankListDown, 100, false);
                System.out.println(downListStr);//显示
            }

//            for (RankBizDataDiff biz : rankListUp) {
//                if (rankListUp == null) {
//                    return null;
//                }
//                String code = biz.getF12();
//                StatEtfUpDown statEtfUpDown = new StatEtfUpDown();
//                if (statRs.containsKey(code)) {
//                    statEtfUpDown = statRs.get(code);
//                }
//                statEtfUpDown.setCode(biz.getF12());
//                statEtfUpDown.setName(handlerEtfName(biz.getF14()));
//                int oldCountCurContinueUp = statEtfUpDown.getCountCurContinueUp();
//                int oldCountCurContinueDown = statEtfUpDown.getCountCurContinueDown();
//                int oldCountTotalUp = statEtfUpDown.getCountTotalUp();
//                int oldCountTotalDown = statEtfUpDown.getCountTotalDown();
//                //  当前连续次数合计-上涨:如果上涨，次数加，否则次数重置为0；下跌次数反之
//                if (biz.getF3().compareTo(new BigDecimal("0")) > 0) {
//                    statEtfUpDown.setCountCurContinueUp(oldCountCurContinueUp + 1);
//                    statEtfUpDown.setCountCurContinueDown(0);
//                    statEtfUpDown.setCountTotalUp(oldCountTotalUp + 1);
//                } else {
//                    statEtfUpDown.setCountCurContinueDown(oldCountCurContinueDown + 1);
//                    statEtfUpDown.setCountCurContinueUp(0);
//                    statEtfUpDown.setCountTotalDown(oldCountTotalDown + 1);
//                }
//                statRs.put(code, statEtfUpDown);
//            }
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
     * 处理上涨列表
     *
     * @param upRankList
     * @return
     */
    private static String handlerUpOrDownList(List<RankBizDataDiff> upRankList, int limit, boolean upDownFlag) {
        StringBuffer sb = new StringBuffer();
        if (upRankList == null) {
            return null;
        }
        int temp = 0;
        for (RankBizDataDiff r : upRankList) {
            temp++;
            if (temp > limit) {
                break;
            }
            String name = StockUtil.formatEtfName(r.getF14(), 4);
            //如果上涨标志，涨幅小于0，中断
            if (upDownFlag && r.getF3().compareTo(new BigDecimal("0")) <= 0) {
                break;
            }
            //如果下跌标志，涨幅小于0，中断
            if (!upDownFlag && r.getF3().compareTo(new BigDecimal("0")) >= 0) {
                break;
            }
            sb.append("," + name);
//            sb.append("," + name + "：" + r.getF3());

        }
        String rs = "";
        if (sb.length() > 0) {
            rs = sb.substring(1);
        }
        return rs;
    }
}
