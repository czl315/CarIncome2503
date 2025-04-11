package ttjj.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomUtils;
import ttjj.dto.RankBizDataDiff;
import utils.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import static utils.Content.NUM_MAX_99;

/**
 * ETF
 */
public class EtfService {

    /**
     * 列表查询ETF
     * //2021-04-16:425;2021-12-06:584;
     *
     * @param pageNo   页码
     * @param pageSize 每页大小
     * @return 结果
     */
    public static List<RankBizDataDiff> listEtfFromHttp(int pageNo, int pageSize) {
        boolean isShowLog = false;//是否显示日志
        //http://87.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112407216560422201541_1652863152766&pn=1&pz=20&po=0&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&wbp2u=6342375825382124|0|1|0|web&fid=f3&fs=m:90+t:2+f:!50&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1652863152768
//        String url = "http://32.push2.eastmoney.com/api/qt/clist/get";
        String url = "https://push2.eastmoney.com/api/qt/clist/get";
        StringBuffer urlParam = new StringBuffer();
        long curTime = System.currentTimeMillis();
//        urlParam.append("cb=jQuery11240323187262602" + RandomUtils.nextInt(1000, 9999) + "_");
        urlParam.append("cb=jQuery37103882040215172" + RandomUtils.nextInt(100, 999) + "_");
        urlParam.append(curTime);
        urlParam.append("&pn=" + pageNo +//页数
                "&pz=" + pageSize +//每页数量
                "&po=1" +//pageorder:页面排序：0-正序；1-倒序
                "&np=1" +
//                "&ut=bd1d9ddb04089700cf9c27f6f7426281" +
                "&ut=fa5fd1943c7b386f172d6893dbfba10b" +
                "&fltt=2" +//浮点数精度
                "&invt=3" +//显示格式：-；0.0
                "&fid=f3");//排序字段
//        urlParam.append("&fs=b:MK0021,b:MK0022,b:MK0023,b:MK0024");
        urlParam.append("&fs=b:MK0021,b:MK0022,b:MK0023,b:MK0024,b:MK0827");
//        urlParam.append("&fields=" +
//        "f12,f13,f14,f1,f2,f4,f3,f152,f5,f6,f17,f18,f15,f16" +
        urlParam.append("&fields=" +
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
                "f230,f231,f232,f233,f234,f235,f236,f237,f238,f239" +
                "f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222" +
                "&_=" + curTime);
        if (isShowLog) {
            System.out.println(url + "?" + urlParam.toString());
        }
        String rs = "";
        JSONObject rsJsonObj = null;
        for (int i = 0; i < 10; i++) {
            rs = HttpUtil.sendGet(url, urlParam.toString(), "");
//        System.out.println(rs);//返回结果
            if (rs.startsWith("jQuery")) {
                rs = rs.substring(rs.indexOf("{"));
            }
            if (rs.endsWith(");")) {
                rs = rs.substring(0, rs.length() - 2);
            }
            rsJsonObj = JSONObject.parseObject(rs);
            if (rs == null || rsJsonObj == null || !rsJsonObj.containsKey("data")) {
                System.out.println("查询数据异常，重新查询：" + rs);
                continue;
            } else {
                break;
            }
        }

        if (isShowLog) {
            System.out.println(rs);//返回结果
        }

        JSONObject rsJsonData = rsJsonObj.getJSONObject("data");
        try {
            List<RankBizDataDiff> rankBizDataDiffList = new ArrayList<>();
            if (rsJsonData != null && rsJsonData.containsKey("diff")) {
                JSONArray rsJsonDataDiff = rsJsonData.getJSONArray("diff");
                rankBizDataDiffList = JSON.parseArray(JSON.toJSONString(rsJsonDataDiff), RankBizDataDiff.class);
                for (RankBizDataDiff row : rankBizDataDiffList) {
//            row.setRs(rs);
//            System.out.println(JSON.toJSON(row));//每个行业一行数据
                }
            }
            return rankBizDataDiffList;
        } catch (Exception e) {
            System.out.println("Exception:" + rs);
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 查询基金LOF
     *
     * @param pageNo   页码
     * @param pageSize 每页大小
     * @return 结果
     */
    public static List<RankBizDataDiff> listLofFromHttp(int pageNo, int pageSize) {
        boolean isShowLog = false;//是否显示日志
        //https://push2.eastmoney.com/api/qt/clist/get?np=1&fltt=1&invt=2&cb=jQuery37106697464802401858_1744387579915&fs=b%3AMK0404%2Cb%3AMK0405%2Cb%3AMK0406%2Cb%3AMK0407&fields=f12%2Cf13%2Cf14%2Cf1%2Cf2%2Cf4%2Cf3%2Cf152%2Cf5%2Cf6%2Cf17%2Cf18%2Cf15%2Cf16&fid=f3&pn=2&pz=20&po=1&dect=1&ut=fa5fd1943c7b386f172d6893dbfba10b&wbp2u=6342375825382124%7C0%7C1%7C0%7Cweb&_=1744387579928
        //https://push2.eastmoney.com/api/qt/clist/get?np=1&fltt=1&invt=2&cb=jQuery37101921927613009975_1744388452462&fs=b%3AMK0404%2Cb%3AMK0405%2Cb%3AMK0406%2Cb%3AMK0407&fields=f12%2Cf13%2Cf14%2Cf1%2Cf2%2Cf4%2Cf3%2Cf152%2Cf5%2Cf6%2Cf17%2Cf18%2Cf15%2Cf16&fid=f3&pn=1&pz=20&po=1&dect=1&ut=fa5fd1943c7b386f172d6893dbfba10b&wbp2u=6342375825382124%7C0%7C1%7C0%7Cweb&_=1744388452470
        String url = "https://push2.eastmoney.com/api/qt/clist/get";
        StringBuffer urlParam = new StringBuffer();
        urlParam.append("np=1");
        urlParam.append("&fltt=1");
        urlParam.append("&invt=3");//显示格式：-；0.0
        urlParam.append("&cb=jQuery3710192192761300" + RandomUtils.nextInt(100, 999) + "_" + System.currentTimeMillis());
//        urlParam.append("&fs=b:MK0021,b:MK0022,b:MK0023,b:MK0024,b:MK0827");
        urlParam.append("&fs=b:MK0404,b:MK0405,b:MK0406,b:MK0407");
        urlParam.append("&fields=f12,f13,f14,f1,f2,f4,f3,f152,f5,f6,f17,f18,f15,f16");
        urlParam.append("&fid=f3");
        urlParam.append("&pn=" + pageNo);//页数
        urlParam.append("&pz=" + pageSize);//每页数量
        urlParam.append("&po=1");//pageorder:页面排序：0-正序；1-倒序
        urlParam.append("&dect=1");
        urlParam.append("&ut=fa5fd1943c7b386f172d6893dbfba10b");
        urlParam.append("&wbp2u=6342375825382124|0|1|0|web");
        urlParam.append("&_=" + System.currentTimeMillis());
        if (isShowLog) {
            System.out.println(url + "?" + urlParam.toString());
        }
        String rs = "";
        JSONObject rsJsonObj = null;
        for (int i = 0; i < 10; i++) {
            rs = HttpUtil.sendGet(url, urlParam.toString(), "");
//        System.out.println(rs);//返回结果
            if (rs.startsWith("jQuery")) {
                rs = rs.substring(rs.indexOf("{"));
            }
            if (rs.endsWith(");")) {
                rs = rs.substring(0, rs.length() - 2);
            }
            rsJsonObj = JSONObject.parseObject(rs);
            if (rs == null || rsJsonObj == null || !rsJsonObj.containsKey("data")) {
                System.out.println("查询数据异常，重新查询：" + rs);
                continue;
            } else {
                break;
            }
        }

        if (isShowLog) {
            System.out.println(rs);//返回结果
        }
        JSONObject rsJsonData = rsJsonObj.getJSONObject("data");
        try {
            int num = 0;
            List<RankBizDataDiff> rankBizDataDiffList = new ArrayList<>();
            if (rsJsonData != null && rsJsonData.containsKey("diff")) {
                JSONArray rsJsonDataDiff = rsJsonData.getJSONArray("diff");
                rankBizDataDiffList = JSON.parseArray(JSON.toJSONString(rsJsonDataDiff), RankBizDataDiff.class);
//                for (RankBizDataDiff row : rankBizDataDiffList) {
//                    System.out.println(++num + ":" + JSON.toJSON(row));//每个行业一行数据
//                }
            }
            return rankBizDataDiffList;
        } catch (Exception e) {
            System.out.println("Exception:" + rs);
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        List<RankBizDataDiff> etfList = new ArrayList<>();
        int maxCount = 100;//最多查询次数
        for (int i = 1; i <= maxCount; i++) {
//            List<RankBizDataDiff> curPageEtfList = EtfService.listEtfFromHttp(i, NUM_MAX_99);//查询列表
            List<RankBizDataDiff> curPageEtfList = EtfService.listLofFromHttp(i, NUM_MAX_99);//查询列表
            if (curPageEtfList.size() > 0) {
//                System.out.println("当前页查询个数：" + curPageEtfList.size());
                etfList.addAll(curPageEtfList);
            } else {
                break;
            }
        }
        int temp = 0;
        for (RankBizDataDiff etf : etfList) {
            System.out.println(++temp + ":" + etf.getF14());
        }
    }

}
