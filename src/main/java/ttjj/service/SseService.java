package ttjj.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import ttjj.db.EtfAdrCount;
import ttjj.db.RankStockCommpanyDb;
import ttjj.dto.BreakMaDto;
import ttjj.dto.CondStock;
import ttjj.dto.Kline;
import ttjj.dto.KlineDto;
import utils.ContExchange;
import utils.Content;
import utils.DateUtil;
import utils.HttpUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

import static utils.ContExchange.*;
import static utils.Content.*;
import static utils.Content.DB_STOCK_ADR_COUNT_ADR_UP_SUM_40_60;
import static utils.DateUtil.YYYYMMDD;
import static utils.DateUtil.YYYY_MM_DD;

/**
 * 上海股票交易所http服务api
 * 参考：http://www.sse.com.cn/market/price/trends/
 */
public class SseService {


    public static void main(String[] args) {

        //查询K线-查询交易日列表，查询贵州茅台的日k线
        int count = 40;
        String endDate = DateUtil.getToday(YYYY_MM_DD);
//        String stCode = "517400";
        String zqdm = "510100";// 159509
//        String klineRs = SseService.daykRsStrHttp(stCode, 2);
//        String klineRs = SseService.daykRsStrHttpSz(stCode, 2, CYCLE_TYPE_WEEK);
//        System.out.println("k线：" + klineRs);
//        List<Kline> klineList = daykline(stCode, 5);
//        List<Kline> klineList = dayklineSz(stCode, 61, CYCLE_TYPE_WEEK);
        List<Kline> klineList = klineExchange(zqdm, count, CYCLE_TYPE_DAY);//CYCLE_TYPE_WEEK
        int i = 1;
        for (Kline kline : klineList) {
            System.out.println((i++) + ":" + kline.getZqdm() + ":" + kline.getKtime() + ",今日收盘：" + kline.getCloseAmt() + ",涨幅：" + kline.getZhangDieFu());
        }
    }

    /**
     * 查询k线：根据证券代码识别交易所，查询个数，周期
     *
     * @param zqdm      证券代码
     * @param count     个数
     * @param cycleType 周期
     * @return k线列表
     */
    public static List<Kline> klineExchange(String zqdm, int count, String cycleType) {
        List<Kline> rs = null;//k线
        if (zqdm.startsWith(ContExchange.SHANGHAI_EXCH_START)) {
            if (cycleType.equals(CYCLE_TYPE_DAY)) {
                rs = SseService.daykline(zqdm, count);
            } else if (cycleType.equals(CYCLE_TYPE_WEEK)) {
                int week60Days = -420;
                String begDate = DateUtil.getCurDateStrAddDaysByFormat(YYYYMMDD, week60Days);
                String endDate = DateUtil.getToday(YYYYMMDD);
                rs = SohuService.findKline(zqdm, ContExchange.KLINE_TYPE_WEEK_SOHU, begDate, endDate, count);
//                System.out.println("上交所周线查询使用接口(SohuService)！");
            } else {
                System.out.println("暂不支持【上交所】特殊k线【" + cycleType + "】查询！");
            }
        } else if (zqdm.startsWith(ContExchange.SHENZHEN_EXCH_START)) {
            if (cycleType.equals(CYCLE_TYPE_DAY) || cycleType.equals(CYCLE_TYPE_WEEK) || cycleType.equals(CYCLE_TYPE_MINU60) || cycleType.equals(CYCLE_TYPE_MINU30) || cycleType.equals(CYCLE_TYPE_MINU15)) {
                rs = SseService.dayklineSz(zqdm, count, cycleType);
            } else {
                System.out.println("暂不支持【深交所】特殊k线【" + cycleType + "】查询！");
            }
        } else {
            System.out.println("根据证券代码识别交易所-异常：" + zqdm);
        }
        return rs;
    }

    /**
     * http查询日K线-上交所
     *
     * @param zqdm
     * @param lmt
     * @return
     */
    public static String daykRsStrHttp(String zqdm, int lmt) {
        boolean isShowLog = false;//是否显示日志
        String methodName = "http查询日K线-上交所-";
        long curTime = System.currentTimeMillis();
        //http://yunhq.sse.com.cn:32041/v1/sh1/dayk/518800?callback=jQuery37107157350927951702_1745252231180&begin=-60&end=-1&period=day&_=1745252231208
        //http://www.szse.cn/api/market/ssjjhq/getHistoryData?random=0.40071861662541997&cycleType=32&marketId=1&code=159361
        StringBuffer url = new StringBuffer();
        url.append("http://yunhq.sse.com.cn:32041/v1/sh1/dayk/");
        url.append(zqdm);
        url.append("?callback=");
        //callback: jQuery37107157350927951702_1745252231180
        url.append(randomHttpHead());
        //begin: 0
        url.append("&begin=-" + (lmt + 1));
        //end: -1
        url.append("&end=-1");
        //period=day
        url.append("&period=day");
        url.append("&_=" + curTime);

        StringBuffer urlParam = new StringBuffer();

//        if (isShowLog && zqdm.equals("512240")) {
//            System.out.println(methodName + "特定代码：" + zqdm);
//        }

        if (isShowLog) {
            System.out.println("请求url:" + url.toString());
        }
        String rs = "";
        try {
            rs = HttpUtil.sendGet(url.toString(), urlParam.toString(), "");
        } catch (Exception e) {
            System.out.println("/** http重试 **/" + e);
            rs = HttpUtil.sendGet(url.toString(), urlParam.toString(), "");
        }
        /**
         * 如果返回异常，n次重试
         */
        for (int i = 0; i < 3; i++) {
            if (StringUtils.isBlank(rs)) {
                rs = HttpUtil.sendGet(url.toString(), urlParam.toString(), "");
            } else {
                break;
            }
        }
        if (rs.contains("({")) {
            rs = rs.substring(rs.indexOf("({"));
            rs = rs.replace("({", "{");
        }
        if (rs.contains("})")) {
            rs = rs.replace("})", "}");
        }
        if (isShowLog) {
            System.out.println("rs:" + rs);
        }

        return rs;
    }

    /**
     * 查询日k线(深交所)
     * http://www.szse.cn/www/market/product/list/etfList/
     * http://www.szse.cn/market/trend/index.html?code=159212
     *
     * @param zqdm
     * @param lmt
     * @param cycleType
     * @return
     */
    public static String daykRsStrHttpSz(String zqdm, int lmt, String cycleType) {
        boolean isShowLog = false;//是否显示日志
        String methodName = "查询日k线(深交所)(daykRsStrHttpSz)：";
        long curTime = System.currentTimeMillis();
        //http://yunhq.sse.com.cn:32041/v1/sh1/dayk/518800?callback=jQuery37107157350927951702_1745252231180&begin=-1000&end=-1&period=day&_=1745252231208
        //http://www.szse.cn/api/market/ssjjhq/getHistoryData?random=0.40071861662541997&cycleType=32&marketId=1&code=159361
        StringBuffer url = new StringBuffer();
        url.append("http://www.szse.cn/api/market/ssjjhq/getHistoryData");
        url.append("?random=" + new Random().nextDouble());
        url.append("&cycleType=" + cycleType);//32代表日线；33=周线
        url.append("&marketId=1");
        url.append("&code=" + zqdm);

        StringBuffer urlParam = new StringBuffer();

        if (isShowLog) {
            System.out.println("请求url:" + url.toString());
        }
        String rs = "";
        try {
            rs = HttpUtil.sendGet(url.toString(), urlParam.toString(), "");
        } catch (Exception e) {
            System.out.println("/** http重试 **/" + e);
            rs = HttpUtil.sendGet(url.toString(), urlParam.toString(), "");
        }
        /**
         * 如果返回异常，n次重试
         */
        for (int i = 0; i < 3; i++) {
            if (StringUtils.isBlank(rs)) {
                rs = HttpUtil.sendGet(url.toString(), urlParam.toString(), "");
            } else {
                break;
            }
        }
        if (rs.contains("({")) {
            rs = rs.substring(rs.indexOf("({"));
            rs = rs.replace("({", "{");
        }
        if (rs.contains("})")) {
            rs = rs.replace("})", "}");
        }
        if (isShowLog) {
            System.out.println(methodName + "rs:" + rs);
        }

        return rs;
    }

    /**
     * 查询日k线，只能以当前交易日反向查询，需要参数：指数代码，限定天数
     *
     * @param zqdm 指数
     * @param lmt  数量
     * @return
     */
    public static List<Kline> daykline(String zqdm, int lmt) {
        String rs = SseService.daykRsStrHttp(zqdm, (lmt + 2));//需要收集前一日的收盘价，所以+2，返回数据时需要去掉第一个数据
        if (rs == null) {
            return null;
        }
//        System.out.println("k线：" + rs);
        //{"code":"517400","total":233,"begin":231,"end":233,"kline":[[20250418,1.1070,1.1130,1.0900,1.0990,13466100,14791707],[20250421,1.1060,1.2090,1.1060,1.2090,30672300,35281915]]}
        JSONObject daykRsJson = JSON.parseObject(rs);
        if (daykRsJson == null) {
            return null;
        }
        if (daykRsJson == null || !daykRsJson.containsKey("kline")) {
            System.out.println("daykRsJson数据异常：" + rs);
            return null;
        }

        JSONArray klines = JSON.parseArray(daykRsJson.getString("kline"));
        List<Kline> klineRs = new ArrayList<>();
        List<Kline> klineRetrunRs = new ArrayList<>();//最终的返回结果，需要去掉第一个数据（第一个数据是计算上一个交易日收盘价的），去掉最后一个数据(最新交易日)
        if (klines != null) {
            BigDecimal lastCloseAmt = null;//上一期收盘价
            for (Object klineObj : klines) {
                Kline kline = new Kline();
                JSONArray klineString = (JSONArray) klineObj;
                kline.setKlt(KLT_101);
                //  日期，开盘，收盘,最高，最低，成交量，成交额，振幅，涨跌幅，涨跌额，换手率
                //"2020-09-30,3389.74,3218.05,3425.63,3202.34,4906229054,6193724911616.00,6.58,-5.23,-177.63,13.40"
                //[20250421,1.1060,1.2090,1.1060,1.2090,30672300,35281915]
                //  日期，开盘，最高，最低，收盘,成交量，成交额，振幅，涨跌幅，涨跌额，换手率
                BigDecimal closeAmt = new BigDecimal(klineString.getString(4));
                kline.setKtime(klineString.getString(0));
                kline.setOpenAmt(new BigDecimal(klineString.getString(1)));
                kline.setMaxAmt(new BigDecimal(klineString.getString(2)));
                kline.setMinAmt(new BigDecimal(klineString.getString(3)));
                kline.setCloseAmt(closeAmt);
                kline.setCjl(new BigDecimal(klineString.getString(5)));
                kline.setCje(new BigDecimal(klineString.getString(6)));
//                kline.setZhenFu(new BigDecimal(klineString.getString7]));
                if (lastCloseAmt != null) {
                    kline.setCloseLastAmt(lastCloseAmt);
                    BigDecimal adr = (kline.getCloseAmt().subtract(kline.getCloseLastAmt())).multiply(new BigDecimal("100")).divide(kline.getCloseLastAmt(), 2, RoundingMode.HALF_UP);
                    kline.setZhangDieFu(adr);//计算涨跌幅
                }
//                kline.setZhangDieE(new BigDecimal(klineString.getString9]));
//                kline.setHuanShouLv(new BigDecimal(klineString.getString10]));
                lastCloseAmt = kline.getCloseAmt();
                kline.setZqdm(zqdm);

                klineRs.add(kline);

            }

            int temp = 0;
            if (klines == null) {
                return null;
            } else {
                //排序
                klineRs = klineRs.stream().filter(e -> e != null).sorted(Comparator.comparing(Kline::getKtime, Comparator.nullsFirst(String::compareTo)).reversed()).collect(Collectors.toList());
            }
            if (klineRs.size() >= (lmt + 1)) {
                for (Kline kline : klineRs) {
//                    if (temp == 0) {
//                        //最终的返回结果，需要去掉第一个数据（第一个数据是计算上一个交易日收盘价的），去掉最后一个数据(最新交易日)
////                    System.out.println("需要收集前一日的收盘价，所以+1，返回数据时需要去掉最后一个交易日的数据");
//                        temp++;
//                        continue;
//                    }
                    klineRetrunRs.add(kline);
                    if (temp == (lmt + 1)) {
//                    System.out.println("，去掉最后一个数据(最新交易日)");
                        break;
                    }
                    temp++;
                }
            } else {
                klineRetrunRs = klineRs;
            }
        }
        return klineRetrunRs;
    }

    /**
     * 查询日k线(深交所)，只能以当前交易日反向查询，需要参数：指数代码，限定天数
     *
     * @param zqdm 指数
     * @param lmt  数量
     * @return
     */
    public static List<Kline> dayklineSz(String zqdm, int lmt, String cycleType) {
        boolean isShowLog = true;//是否显示日志
        String methodName = "查询日k线(深交所)：";
        long curTime = System.currentTimeMillis();

        String rs = SseService.daykRsStrHttpSz(zqdm, (lmt + 1), cycleType);//需要收集前一日的收盘价，所以+1，返回数据时需要去掉第一个数据
        if (StringUtils.isBlank(rs)) {
            System.out.println(methodName + "：返回空：" + rs);
            return null;
        }
        //{"code":"0","data":{"code":"159212","name":"深100ETF南方","picupdata":[["2025-04-09","0.953","0.981","0.951","0.988","0.000","0.00",1616757,156734534.00],["2025-04-10","0.990","1.003","0.990","1.015","0.022","2.24",4186498,421500970.00],["2025-04-11","1.001","1.011","0.990","1.018","0.008","0.80",1119175,113126651.00],["2025-04-14","1.021","1.013","1.011","1.022","0.002","0.20",860112,87389886.00],["2025-04-15","1.011","1.011","1.006","1.012","-0.002","-0.20",321698,32450510.00],["2025-04-16","1.005","1.002","0.993","1.009","-0.009","-0.89",376157,37594915.00],["2025-04-17","1.000","1.004","0.999","1.010","0.002","0.20",351228,35355869.00],["2025-04-18","1.004","1.007","1.000","1.009","0.003","0.30",559163,56116392.00],["2025-04-21","1.004","1.018","1.002","1.018","0.011","1.09",447312,45291108.00],["2025-04-22","1.011","1.016","1.011","1.019","-0.002","-0.20",327955,33340211.00]],"picdowndata":[["2025-04-09",1616757,"plus"],["2025-04-10",4186498,"plus"],["2025-04-11",1119175,"plus"],["2025-04-14",860112,"minus"],["2025-04-15",321698,"minus"],["2025-04-16",376157,"minus"],["2025-04-17",351228,"plus"],["2025-04-18",559163,"plus"],["2025-04-21",447312,"plus"],["2025-04-22",327955,"plus"]]},"message":"成功"}
        JSONObject dayklineSz = JSON.parseObject(rs);
        if (dayklineSz == null) {
            return null;
        }
        JSONObject dayklineSzData = JSON.parseObject(dayklineSz.getString("data"));
        if (dayklineSzData == null || !dayklineSz.containsKey("data")) {
            System.out.println(methodName + "dayklineSz-dayklineSzData：" + rs);
            return null;
        }
        if (dayklineSzData == null || !dayklineSzData.containsKey("picupdata")) {
            System.out.println(methodName + "dayklineSzData-picupdata：" + rs);
            return null;
        }

        JSONArray klines = JSON.parseArray(dayklineSzData.getString("picupdata"));
        List<Kline> klineRs = new ArrayList<>();
        List<Kline> klineRetrunRs = new ArrayList<>();
        if (klines != null) {
            BigDecimal lastCloseAmt = null;//上一期收盘价
            for (Object klineObj : klines) {
                Kline kline = new Kline();
                JSONArray klineString = (JSONArray) klineObj;
                kline.setKlt(KLT_101);
                String ktime = klineString.getString(0);
                if (ktime.contains("-")) {
                    ktime = ktime.replace("-", "");
                }
                //["2025-04-22","1.011","1.016","1.011","1.019","-0.002","-0.20",327955,33340211.00]
                //  日期，开盘，收盘,最低，最高，涨跌额，涨跌幅，成交量，成交额
                BigDecimal closeAmt = new BigDecimal(klineString.getString(2));
                kline.setKtime(ktime);
                kline.setOpenAmt(new BigDecimal(klineString.getString(1)));
                kline.setMaxAmt(new BigDecimal(klineString.getString(4)));
                kline.setMinAmt(new BigDecimal(klineString.getString(3)));
                kline.setCloseAmt(closeAmt);
                kline.setCjl(new BigDecimal(klineString.getString(7)));
                kline.setCje(new BigDecimal(klineString.getString(8)));
                kline.setZhangDieE(new BigDecimal(klineString.getString(5)));
                kline.setZhangDieFu(new BigDecimal(klineString.getString(6)));
                kline.setZqdm(zqdm);
                klineRs.add(kline);
            }
        }

        int temp = 0;
        if (klines == null) {
            return null;
        } else {
            //排序
            klineRs = klineRs.stream().filter(e -> e != null).sorted(Comparator.comparing(Kline::getKtime, Comparator.nullsFirst(String::compareTo)).reversed()).collect(Collectors.toList());
        }
        if (klineRs.size() >= lmt) {
            for (Kline kline : klineRs) {
                klineRetrunRs.add(kline);
//                if (temp == (lmt + 1)) {
                if (temp == lmt) {
                    break;
                }
                temp++;
            }
        } else {
            klineRetrunRs = klineRs;
        }

        return klineRetrunRs;
    }

    /**
     * 获取请求头地址-随机参数
     */
    public static String randomHttpHead() {
        //        url.append("http://96.push2his.eastmoney.com/api/qt/stock/kline/get?cb=jQuery331093188916841208381602168987937");
        //http://yunhq.sse.com.cn:32041/v1/sh1/snap/517400?callback=jQuery37108473383657002773_1745250561855&select=name%2Cprev_close%2Copen%2Chigh%2Clow%2Clast%2Cchange%2Cchg_rate%2Cvolume%2Camount%2Ccpxxlmttype%2Cup_limit%2Cdown_limit%2Ctradephase%2Cbid%2Cask%2Chlt_tag%2Cgdr_ratio%2Cgdr_prevpx%2Cgdr_currency%2Ccpxxprodusta%2Cfp_volume%2Cfp_amount%2Cfp_phase%2Ccpxxextendname&_=1745250561885
        //http://yunhq.sse.com.cn:32041/v1/sh1/snap/517400?callback=jQuery37108473383657002773_1745250561855&select=name,prev_close,open,high,low,last,change,chg_rate,volume,amount,cpxxlmttype,up_limit,down_limit,tradephase,bid,ask,hlt_tag,gdr_ratio,gdr_prevpx,gdr_currency,cpxxprodusta,fp_volume,fp_amount,fp_phase,cpxxextendname&_=1745250561885
        //http://yunhq.sse.com.cn:32041/v1/sh1/snap/000001?callback=jQuery37106218797457537988_1745252079970&select=name%2Cprev_close%2Copen%2Chigh%2Clow%2Clast%2Cchange%2Cchg_rate%2Cvolume%2Camount%2Ccpxxlmttype%2Cup_limit%2Cdown_limit%2Ctradephase%2Cbid%2Cask%2Chlt_tag%2Cgdr_ratio%2Cgdr_prevpx%2Cgdr_currency%2Ccpxxprodusta%2Cfp_volume%2Cfp_amount%2Cfp_phase%2Ccpxxextendname&_=1745252079972
        //http://yunhq.sse.com.cn:32041/v1/sh1/snap/518800?callback=jQuery37107157350927951702_1745252231180&select=name%2Cprev_close%2Copen%2Chigh%2Clow%2Clast%2Cchange%2Cchg_rate%2Cvolume%2Camount%2Ccpxxlmttype%2Cup_limit%2Cdown_limit%2Ctradephase%2Cbid%2Cask%2Chlt_tag%2Cgdr_ratio%2Cgdr_prevpx%2Cgdr_currency%2Ccpxxprodusta%2Cfp_volume%2Cfp_amount%2Cfp_phase%2Ccpxxextendname&_=1745252231198

        int random = RandomUtils.nextInt(1, 99);
        StringBuffer rs = new StringBuffer("jQuery");
        if (random > 10) {
            rs.append("3710").append(random).append("733836570027" + random + "_");
        } else {
            rs.append("3710").append("0").append(random).append("733836570027" + "0" + random + "_");
        }
        rs.append(System.currentTimeMillis());
        return rs.toString();
    }

    /**
     * 计算涨幅累计:只计算正增长
     *
     * @param conditionStock 条件
     * @param dbField
     * @param curTradeDay    当前交易日
     * @return 涨幅累计
     */
    public static BigDecimal httpAdrSumByKline(CondStock conditionStock, String dbField, String curTradeDay) {
        BigDecimal adrSum = null;//涨幅合计
        String begDate = conditionStock.getBegDate();
        String endDate = conditionStock.getEndDate();
        String zqdm = conditionStock.getF12();
        int lmt = 0;
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_1.equals(dbField)) {
            lmt = 1;
        } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_2.equals(dbField)) {
            lmt = 2;
        } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_3.equals(dbField)) {
            lmt = 3;
        } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_5.equals(dbField)) {
            lmt = 5;
        } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_10.equals(dbField)) {
            lmt = 10;
        } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_20.equals(dbField)) {
            lmt = 20;
        } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_40.equals(dbField)) {
            lmt = 40;
        } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_60.equals(dbField)) {
            lmt = 60;
        } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_20_40.equals(dbField)) {
            lmt = 60;
        } else if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_40_60.equals(dbField)) {
            lmt = 60;
        }
        //查询K线-天到今天
        List<Kline> klines = null;
        if (zqdm.startsWith("5")) {
            klines = daykline(zqdm, lmt);
//        }else if (zqdm.startsWith("1")) {
        } else {
            klines = dayklineSz(zqdm, lmt, CYCLE_TYPE_DAY);
        }
        //如果查询k线为null，继续下一个
        if (klines == null) {
            System.out.println("计算涨幅累计-查询k线为null：" + JSON.toJSONString(conditionStock));
            return null;
        } else {
            //排序
            klines = klines.stream().filter(e -> e != null).sorted(Comparator.comparing(Kline::getKtime, Comparator.nullsFirst(String::compareTo)).reversed()).collect(Collectors.toList());
        }
        for (Kline kline : klines) {
            BigDecimal adr = kline.getZhangDieFu();

            //如果是当前交易日，不计算
            curTradeDay = curTradeDay.replace("-", "");
            if (curTradeDay.equals(kline.getKtime())) {
//                System.out.println("如果是当前交易日，不计算:" + curTradeDay);
                continue;
            }

            //只计算正增长的
            if (adr != null && adr.compareTo(new BigDecimal("0")) > 0) {
                if (adrSum == null) {
                    adrSum = new BigDecimal("0");
                }
                adrSum = adrSum.add(adr);
            }
        }
        return adrSum;
    }

    /**
     * 突破均线-向上:是否突破、均线净值、连续突破次数、突破百分比、最低净值跌破均线后突破均线向上
     *
     * @param stock     股票
     * @param count     个数
     * @param cycleType 均线周期类型
     * @param date      日期
     * @return
     */
    public static BreakMaDto breakMaUp(RankStockCommpanyDb stock, String cycleType, Integer count, String date) {
        BreakMaDto rs = new BreakMaDto();
        String zqdm = stock.getF12();

        BigDecimal curAmt = null;
        BigDecimal yesterdayCloseAmt = null;
        List<Kline> klineList = klineExchange(zqdm, count, cycleType);// 查询k线
        if (klineList == null || klineList.size() == 0) {
            return rs;
        }
        if (klineList.size() > 0) {
            curAmt = klineList.get(0).getCloseAmt();
        }
        if (klineList.size() > 1) {
            yesterdayCloseAmt = klineList.get(1).getCloseAmt();
        }

        BigDecimal curMaAmt = new BigDecimal("0");//均值
        BigDecimal rsNetCloseSum = new BigDecimal("0");//和值
        if (klineList == null) {
            System.out.println("klineList为空！");
            return rs;
        }
        for (Kline kline : klineList) {
            BigDecimal dwjzLong = kline.getCloseAmt();
            rsNetCloseSum = rsNetCloseSum.add(dwjzLong);
        }
        //计算均值
        int size = klineList.size();//个数
        if (size > 0) {
            curMaAmt = rsNetCloseSum.divide(new BigDecimal(size), 3, BigDecimal.ROUND_HALF_UP);
        }

        //计算连续突破百分比
        rs.setBreakPctUp(curAmt.subtract(curMaAmt).divide(curMaAmt, 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, RoundingMode.HALF_UP));
        rs.setMaNet(curMaAmt);

//        if (zqdm.equals("159388")) {
//            System.out.println("特定代码：" + zqdm);
//        }

        //涨破均线，买出信号
        if (yesterdayCloseAmt != null && yesterdayCloseAmt.compareTo(curMaAmt) < 0 && curAmt.compareTo(curMaAmt) >= 0) {
            rs.setMaBreakUp(true);
//            计算连续突破次数
//            int breakCountUp = handlerBreakCount(maKline, true);
//            rs.setBreakCountUp(breakCountUp);
        }
//        //最低净值跌破均线后突破均线向上
//        BigDecimal minAmt = todayKline.getMinAmt();
//        if (minAmt.compareTo(curMaAmt) <= 0 && curAmt.compareTo(curMaAmt) > 0) {
//            rs.setMaBreakUpMin(true);
//            //计算连续突破次数
//            int breakCount = handlerBreakCountUpMin(maKline);
//            rs.setBreakCountUpMin(breakCount);
//        }
        return rs;
    }

    /**
     * 计算连续突破次数
     *
     * @param maKline  均线k线
     * @param upOrDown 向上还是向下
     * @return 连续突破次数
     */
    private static int handlerBreakCount(KlineDto maKline, boolean upOrDown) {
        int count = 0;
        BigDecimal netMa = maKline.getNetMa();
        List<Kline> klineList = maKline.getKlineList().stream().filter(e -> e != null).sorted(Comparator.comparing(Kline::getKtime, Comparator.nullsFirst(String::compareTo)).reversed()).collect(Collectors.toList());
        for (Kline kline : klineList) {
            BigDecimal closeAmt = kline.getCloseAmt();
            if (upOrDown) {
                if (closeAmt.compareTo(netMa) >= 0) {
                    count++;
                } else {
                    break;
                }
            } else {
                if (closeAmt.compareTo(netMa) < 0) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 计算价格区间百分比
     */
    public static void handlerPriceAreaRate(String zqdm, EtfAdrCount entity, String date) {
        boolean isShowLog = false;
        long begTime = System.currentTimeMillis();
        String methodName = "计算价格区间百分比-";

//        if (isShowLog && zqdm.equals("512240")) {
//            System.out.println(methodName + "特定代码：" + zqdm);
//        }

        int days = DAYS_INT_61;//DAYS_INT_80
        BigDecimal curPriceArea = null;
        List<Kline> klines = klineExchange(zqdm, days, CYCLE_TYPE_DAY);
        Map<String, BigDecimal> rs = new HashMap<>();
        BigDecimal rsMax = new BigDecimal("0.0");
        BigDecimal rsMin = new BigDecimal("0.0");
        if (klines == null || klines.size() == 0) {
            System.out.println(methodName + "k线为空！" + zqdm);
            return;
        }

        int temp = 1;
        BigDecimal closeAmt = null;//收盘价

        for (Kline kline : klines) {
            //查询的k线日期必须要小于特定日期
            String klineDate = kline.getKtime();
            if (klineDate.length() == 10) {
                klineDate = klineDate.replace("-", "");
            }
            if (date.length() == 10) {
                date = date.replace("-", "");
            }
            if (Integer.valueOf(klineDate) > Integer.valueOf(date)) {
//                System.out.println("查询的k线日期【" + klineDate + "】>【" + date + "】大于特定日期，不做处理，下一个。");
                continue;
            }

            if (closeAmt == null) {
                closeAmt = kline.getCloseAmt();//收盘价
            }

            BigDecimal netMinCur = kline.getMinAmt();
            BigDecimal netMaxCur = kline.getMaxAmt();
            if (netMaxCur.compareTo(rsMax) > 0) {
                rsMax = netMaxCur;
            }
            if (netMinCur.compareTo(rsMin) <= 0 || rsMin.compareTo(new BigDecimal("0.0")) == 0) {
                rsMin = netMinCur;
            }

            if (closeAmt == null || rsMin == null || rsMax == null || rsMax.compareTo(new BigDecimal("0")) == 0) {
                continue;
            }


            if (temp == 5) {
                curPriceArea = closeAmt.subtract(rsMin).divide(rsMax.subtract(rsMin), 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP);
                entity.setNET_AREA_DAY_5(curPriceArea);
            } else if (temp == 10) {
                curPriceArea = closeAmt.subtract(rsMin).divide(rsMax.subtract(rsMin), 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP);
                entity.setNET_AREA_DAY_10(curPriceArea);
            } else if (temp == 20) {
                curPriceArea = closeAmt.subtract(rsMin).divide(rsMax.subtract(rsMin), 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP);
                entity.setNET_AREA_DAY_20(curPriceArea);
            } else if (temp == 40) {
                curPriceArea = closeAmt.subtract(rsMin).divide(rsMax.subtract(rsMin), 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP);
                entity.setNET_AREA_DAY_40(curPriceArea);
            } else if (temp == 60) {
                curPriceArea = closeAmt.subtract(rsMin).divide(rsMax.subtract(rsMin), 4, RoundingMode.HALF_UP).multiply(new BigDecimal("100")).setScale(2, BigDecimal.ROUND_HALF_UP);
                entity.setNET_AREA_DAY_60(curPriceArea);
            }
            temp++;
        }
        return;
    }

}
