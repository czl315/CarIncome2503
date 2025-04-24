package ttjj.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import ttjj.dto.Kline;
import utils.DateUtil;
import utils.HttpUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static utils.ContExchange.KLINE_TYPE_WEEK_SOHU;
import static utils.DateUtil.YYYYMMDD;

/**
 * K线http查询(sohu)
 * 参考：
 * https://q.stock.sohu.com/hisHq?code=cn_159915&start=20240301&end=20250424&stat=1&order=D&period=w&callback=historySearchHandler&rt=jsonp
 * https://hq.stock.sohu.com/mkline/cn/050/cn_510050-11_2.html?_=1745468377604
 */
public class SohuService {

    public static void main(String[] args) {

        //查询K线-查询交易日列表，查询贵州茅台的日k线
        int count = -420;
        int limit = 60;
        String begDate = DateUtil.getCurDateStrAddDaysByFormat(YYYYMMDD, count);
        String endDate = DateUtil.getToday(YYYYMMDD);
//        String stCode = "517400";
        String zqdm = "159509";
//        String klineRs = SohuService.httpKlineRsStr(zqdm, KLINE_TYPE_WEEK, begDate, endDate);
//        System.out.println("k线：" + klineRs);
        List<Kline> klineList = findKline(zqdm, KLINE_TYPE_WEEK_SOHU, begDate, endDate, limit);
        int i = 1;
        for (Kline kline : klineList) {
            System.out.println((i++) + ":" + kline.getZqdm() + ":" + kline.getKtime() + ",收盘：" + kline.getCloseAmt() + ",涨幅：" + kline.getZhangDieFu());
        }
    }

    /**
     * 查询k线
     *
     * @param zqdm      证券代码
     * @param cycleType 周期
     * @param limit
     * @return k线列表
     */
    public static List<Kline> findKline(String zqdm, String cycleType, String startDay, String endDay, int limit) {
        boolean isShowLog = true;
        String methodName = "查询k线(sohu)：";
        String rs = SohuService.httpKlineRsStr(zqdm, cycleType, startDay, endDay);//需要收集前一日的收盘价，所以+1，返回数据时需要去掉第一个数据
        if (rs == null) {
            System.out.println(methodName + "：返回null");
            return null;
        }
        //{"status":0,"hq":[["2025-04-23","1.320","1.371","0.045","3.39%","1.307","1.374","16229213","216742.266","25.83%"],["2025-04-18","1.384","1.326","-0.034","-2.50%","1.321","1.399","32071756","435055.094","51.26%"],["2025-04-11","1.230","1.360","-0.007","-0.51%","1.201","1.375","44190044","573620.188","70.63%"],["2025-04-03","1.372","1.367","-0.048","-3.39%","1.350","1.417","32476838","448263.438","51.91%"],["2025-03-28","1.448","1.415","-0.012","-0.84%","1.411","1.496","35369528","514838.938","56.53%"],["2025-03-21","1.412","1.427","0.028","2.00%","1.392","1.443","35472288","502951.531","56.70%"],["2025-03-14","1.443","1.399","-0.050","-3.45%","1.343","1.454","62238476","860687.688","99.48%"],["2025-03-07","1.496","1.449","-0.027","-1.83%","1.437","1.505","36383312","531934.562","58.15%"],["2025-02-28","1.560","1.476","-0.117","-7.34%","1.465","1.569","30768458","469881.812","8.73%"],["2025-02-21","1.606","1.593","-0.012","-0.75%","1.589","1.645","26901096","434832.531","7.45%"],["2025-02-14","1.583","1.605","0.009","0.56%","1.575","1.610","14411171","229664.516","5.83%"],["2025-02-07","1.596","1.596","-0.042","-2.56%","1.589","1.609","10549374","168608.766","6.41%"],["2025-01-27","1.610","1.638","-0.033","-0.02%","1.600","1.617","4777138","76664.055","7.64%"],["2025-01-24","1.636","1.638","0.014","0.86%","1.630","1.655","18003568","295529.312","6.88%"],["2025-01-17","1.603","1.624","-0.002","-0.12%","1.580","1.639","23833388","383205.344","8.60%"]],"code":"cn_159509","stat":["�ۼ�:","2025-01-17��2025-04-23","-0.25","-15.38%",1.201,1.655,423675648,6142480.041,"522.03%"]}
        JSONObject klineRsObj = JSON.parseObject(rs);
        if (klineRsObj == null) {
            return null;
        }
        JSONArray klines = JSON.parseArray(klineRsObj.getString("hq"));
        List<Kline> klineRs = new ArrayList<>();
        if (klines == null) {
            return null;
        }
        for (Object klineObj : klines) {
            if (limit-- <= 0) {
//                System.out.println("限定个数已完成：" + limit);
                break;
            }
            Kline kline = new Kline();
            JSONArray klineString = (JSONArray) klineObj;
            String ktime = klineString.getString(0);
            if (ktime.contains("-")) {
                ktime = ktime.replace("-", "");
            }
            kline.setKtime(ktime);
            //["2025-04-23","1.320","1.371","0.045","3.39%","1.307","1.374","16229213","216742.266","25.83%"]
            //  日期，开盘，收盘,涨跌额，涨跌幅，最低，最高，成交量，成交额，振幅
            kline.setOpenAmt(new BigDecimal(klineString.getString(1)));
            BigDecimal closeAmt = new BigDecimal(klineString.getString(2));
            kline.setCloseAmt(closeAmt);
            kline.setZhangDieE(new BigDecimal(klineString.getString(3)));
            String zhangDieFu = klineString.getString(4);
            if (zhangDieFu.contains("%")) {
                zhangDieFu = zhangDieFu.replace("%", "");
                kline.setZhangDieFu(new BigDecimal(zhangDieFu));
            }
            kline.setMinAmt(new BigDecimal(klineString.getString(5)));
            kline.setMaxAmt(new BigDecimal(klineString.getString(6)));
            kline.setCjl(new BigDecimal(klineString.getString(7)));
            kline.setCje(new BigDecimal(klineString.getString(8)));
            kline.setZqdm(zqdm);
            klineRs.add(kline);
        }
        return klineRs;
    }

    /**
     * http查询k线，不含今日数据
     * https://hq.stock.sohu.com/mkline/cn/050/cn_510050-11_2.html?_=1745468377604
     * https://q.stock.sohu.com/hisHq?code=cn_159915&start=20240301&end=20250424&stat=1&order=D&period=w&callback=historySearchHandler&rt=jsonp
     *
     * @param zqdm
     * @param cycleType
     * @param start
     * @param end
     * @return
     */
    public static String httpKlineRsStr(String zqdm, String cycleType, String start, String end) {
        boolean isShowLog = false;//是否显示日志
        long curTime = System.currentTimeMillis();
        //https://hq.stock.sohu.com/mkline/cn/050/cn_510050-11_2.html?_=1745468377604
        //https://q.stock.sohu.com/hisHq?code=cn_159915&start=20240301&end=20250424&stat=1&order=D&period=w&callback=historySearchHandler&rt=jsonp
        //https://q.stock.sohu.com/hisHq?code=cn_159509&start=20250114&end=20250424&stat=1&order=D&period=w&callback=historySearchHandler&rt=jsonp
        StringBuffer url = new StringBuffer();
        url.append("https://q.stock.sohu.com/hisHq");//前缀
        StringBuffer urlParam = new StringBuffer();
        urlParam.append("code=cn_" + zqdm);//证券代码
        urlParam.append("&start=" + start);
        urlParam.append("&end=" + end);
        urlParam.append("&stat=1");
        urlParam.append("&order=D");
        urlParam.append("&period=" + cycleType);
        urlParam.append("&callback=historySearchHandler");
        urlParam.append("&rt=jsonp");


        if (isShowLog) {
//            System.out.println("请求url:" + url.toString());
//            System.out.println("请求url:" + url + "?" + urlParam.toString());
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

        //过滤返回字符串
        if (rs.startsWith("historySearchHandler([{")) {
//            rs = rs.substring(rs.indexOf("quote_w_dividend({"));
            rs = rs.replace("historySearchHandler([{", "{");
        }
        if (rs.endsWith("}])")) {
            rs = rs.replace("}])", "}");
        }
        if (isShowLog) {
            System.out.println("rs:" + rs);
        }
        return rs;
    }

}
