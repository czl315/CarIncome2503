package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 常量-ETF类型名称
 * 2025-03-05：1065
 */
public class ContEtfTypeName {

    /**
     * 医疗
     */
    public static String TYPE_YILIAO_COMMON = "医疗-通用";
    public static String TYPE_YILIAO_CN_MEDICINE = "医疗-中药";
    public static List TYPE_YILIAO = new ArrayList();//医疗
    static {
        TYPE_YILIAO.add(TYPE_YILIAO_COMMON);
        TYPE_YILIAO.add(TYPE_YILIAO_CN_MEDICINE);
    }

    /**
     * 科技
     */
    public static List TYPE_KEJI_GONG_YE = Arrays.asList("科技-工业");
    public static List TYPE_KEJI_NEW_CAR = Arrays.asList("科技-汽车");
    public static List TYPE_KEJI_NEW_ENERGY = Arrays.asList("科技-新能源");
    public static String TYPE_KEJI_ELECTRICITY = "科技-电力";
    public static List TYPE_KEJI_RUAN_JIAN = Arrays.asList("科技-软件");
    public static List TYPE_KEJI_XIN_PIAN = Arrays.asList("科技-芯片");
    public static List TYPE_KEJI_HK = Arrays.asList("科技-香港");
    public static List TYPE_KEJI_JUNGONG = Arrays.asList("科技-军工");
    public static List TYPE_KEJI = new ArrayList();//
    static {
        TYPE_KEJI.addAll(TYPE_KEJI_GONG_YE);
        TYPE_KEJI.addAll(TYPE_KEJI_NEW_CAR);
        TYPE_KEJI.addAll(TYPE_KEJI_NEW_ENERGY);
        TYPE_KEJI.addAll(TYPE_KEJI_RUAN_JIAN);
        TYPE_KEJI.addAll(TYPE_KEJI_XIN_PIAN);
        TYPE_KEJI.addAll(TYPE_KEJI_HK);
        TYPE_KEJI.addAll(TYPE_KEJI_JUNGONG);
        TYPE_KEJI.add(TYPE_KEJI_ELECTRICITY);
    }

    /**
     * 消费
     */
    public static List TYPE_XIAOFEI_COMMON = Arrays.asList("消费-通用");
    public static List TYPE_XIAOFEI_HK = Arrays.asList("消费-香港消费");
    public static List TYPE_XIAOFEI_GAME = Arrays.asList("消费-游戏");
    public static List TYPE_XIAOFEI_MEDIA = Arrays.asList("消费-传媒");
    public static List TYPE_XIAOFEI_TRAVEL = Arrays.asList("消费-旅游");
    public static List TYPE_XIAOFEI_FILM = Arrays.asList("消费-影视");
    public static List TYPE_XIAOFEI_FOOD = Arrays.asList("消费-食品");
    public static List TYPE_XIAOFEI_WINE = Arrays.asList("消费-酒");
    public static List TYPE_XIAOFEI_HOUSE = Arrays.asList("消费-家电");
    public static List TYPE_XIAOFEI_OLD = Arrays.asList("消费-养老");
    public static List TYPE_XIAOFEI_EXPRESS = Arrays.asList("消费-物流");
    public static List TYPE_XIAOFEI = new ArrayList();//消费
    static {
        TYPE_XIAOFEI.addAll(TYPE_XIAOFEI_COMMON);
        TYPE_XIAOFEI.addAll(TYPE_XIAOFEI_HK);
        TYPE_XIAOFEI.addAll(TYPE_XIAOFEI_GAME);
        TYPE_XIAOFEI.addAll(TYPE_XIAOFEI_TRAVEL);
        TYPE_XIAOFEI.addAll(TYPE_XIAOFEI_FILM);
        TYPE_XIAOFEI.addAll(TYPE_XIAOFEI_MEDIA);
        TYPE_XIAOFEI.addAll(TYPE_XIAOFEI_FOOD);
        TYPE_XIAOFEI.addAll(TYPE_XIAOFEI_WINE);
        TYPE_XIAOFEI.addAll(TYPE_XIAOFEI_HOUSE);
        TYPE_XIAOFEI.addAll(TYPE_XIAOFEI_OLD);
        TYPE_XIAOFEI.addAll(TYPE_XIAOFEI_EXPRESS);
        TYPE_XIAOFEI.addAll(TYPE_XIAOFEI_WINE);
    }

    /**
     * 指数
     */
    public static String TYPE_INDEX_CN_NOT= "指数-外盘";
    public static List TYPE_INDEX_CN_1000 = Arrays.asList("指数-中小盘");
    public static String TYPE_INDEX_CN_BIG = "指数-大盘";
    public static List TYPE_INDEX_300 = Arrays.asList("指数-创业板");
    public static List TYPE_INDEX_688 = Arrays.asList("指数-科创板");
    public static List TYPE_INDEX_HK = Arrays.asList("指数-港股");
    public static List TYPE_INDEX = new ArrayList();
    static {
        TYPE_INDEX.addAll(TYPE_INDEX_CN_1000);
        TYPE_INDEX.addAll(TYPE_INDEX_300);
        TYPE_INDEX.addAll(TYPE_INDEX_688);
        TYPE_INDEX.addAll(TYPE_INDEX_HK);
        TYPE_INDEX.add(TYPE_INDEX_CN_BIG);
        TYPE_INDEX.add(TYPE_INDEX_CN_NOT);
    }

    public static List TYPE_ZIYUAN_OIL  = Arrays.asList("资源-石油");
    public static List TYPE_ZIYUAN_NONGYE  = Arrays.asList("资源-农业");
    public static List TYPE_ZIYUAN = new ArrayList();
    static {
        TYPE_ZIYUAN.addAll(TYPE_ZIYUAN_OIL);
        TYPE_ZIYUAN.addAll(TYPE_ZIYUAN_NONGYE);
    }

    /**
     * 金融
     */
    public static List TYPE_JINRONG_ZHENGQUAN = Arrays.asList("金融-证券");
    public static List TYPE_JINRONG_GOLD = Arrays.asList("金融-黄金");
    public static List TYPE_JINRONG_BANK = Arrays.asList("金融-银行");
    public static List TYPE_JINRONG_COMMON = Arrays.asList("金融-通用");
    public static List TYPE_JINRONG_FANGDICHAN = Arrays.asList("金融-地产");
    public static List TYPE_JINRONG_CASH  = Arrays.asList("金融-现金");
    public static List TYPE_JINRONG = new ArrayList();
    static {
        TYPE_JINRONG.addAll(TYPE_JINRONG_ZHENGQUAN);
        TYPE_JINRONG.addAll(TYPE_JINRONG_GOLD);
        TYPE_JINRONG.addAll(TYPE_JINRONG_BANK);
        TYPE_JINRONG.addAll(TYPE_JINRONG_COMMON);
        TYPE_JINRONG.addAll(TYPE_JINRONG_FANGDICHAN);
        TYPE_JINRONG.addAll(TYPE_JINRONG_CASH);
    }

    public static List TYPE_ALL = new ArrayList();
    static {
        TYPE_ALL.addAll(TYPE_JINRONG);
        TYPE_ALL.addAll(TYPE_ZIYUAN);
        TYPE_ALL.addAll(TYPE_XIAOFEI);
        TYPE_ALL.addAll(TYPE_KEJI);
        TYPE_ALL.addAll(TYPE_INDEX);
        TYPE_ALL.addAll(TYPE_YILIAO);
    }
}
