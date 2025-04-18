package utils;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenzhilong
 * @date
 */
public class ContStatic {
    /**
     * ZHISHU_CODE_000001
     */
    public static String SHANG_HAI = "000001";//上证指数
    /**
     * 常用指数
     * 000001	上证指数
     */
    public static Map<String, String> mapIndex = new HashMap<>();

    static {
        mapIndex.put(SHANG_HAI, "上证指数");
        mapIndex.put("000300", "沪深300");
        mapIndex.put("000016", "上证50");
        mapIndex.put("000903", "中证100");
        mapIndex.put("000905", "中证500");
        mapIndex.put("000852", "中证1000");
        mapIndex.put("000688", "科创50");
        mapIndex.put("399001", "深证成指");
        mapIndex.put("399006", "创业板指");
        mapIndex.put("399673", "创业板50");
//        mapIndex.put("931643", "科创创业50");
//        mapIndex.put("399005","中小100");
//        mapIndex.put("000010", "上证180");
//        mapIndex.put("000009","上证380");
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(SHANG_HAI));
        SHANG_HAI = "xxx";
        System.out.println(JSON.toJSONString(SHANG_HAI));
    }


}
