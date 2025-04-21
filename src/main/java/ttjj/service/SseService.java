package ttjj.service;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import utils.DateUtil;
import utils.HttpUtil;

import static utils.Content.KLINE_TYPE_STOCK;
import static utils.DateUtil.YYYY_MM_DD;

/**
 * 上海股票交易所http服务api
 */
public class SseService {


    public static void main(String[] args) {

        //查询K线-查询交易日列表，查询贵州茅台的日k线
        String endDate = DateUtil.getToday(YYYY_MM_DD);
        String stCode = "517400";
        String klineRs = SseService.daykRsStrHttp(stCode, 2, endDate, KLINE_TYPE_STOCK);
        System.out.println("k线：" + klineRs);
    }

    /**
     * 日K线
     *
     * @param zqdm
     * @param lmt
     * @param endDate
     * @return
     */
    public static String daykRsStrHttp(String zqdm, int lmt, String endDate, String klineType) {
        boolean isShowLog = true;//是否显示日志
        endDate = endDate != null ? endDate.replace("-", "") : null;
        long curTime = System.currentTimeMillis();
        //http://yunhq.sse.com.cn:32041/v1/sh1/dayk/518800?callback=jQuery37107157350927951702_1745252231180&begin=-1000&end=-1&period=day&_=1745252231208
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


}
