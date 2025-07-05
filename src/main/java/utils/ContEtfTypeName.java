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
    public static String YILIAO_COMMON = "医疗-通用";
//    public static String YILIAO_CN_MEDICINE = "医疗-中药";
    public static List YILIAO = new ArrayList();//医疗
    static {
        YILIAO.add(YILIAO_COMMON);
//        YILIAO.add(YILIAO_CN_MEDICINE);
    }

    /**
     * 科技
     */
    public static String KEJI_GONG_YE = "科技-通用";
    public static String KEJI_NEW_CAR = "科技-汽车";
    public static String KEJI_NEW_ENERGY = "科技-新能源";
//    public static String KEJI_ELECTRICITY = "科技-电力";
    public static String KEJI_RUAN_JIAN = "科技-软件";
    public static String KEJI_XIN_PIAN = "科技-芯片";
    public static String KEJI_TONG_XIN = "科技-通信";
    public static String KEJI_HK = "科技-香港";
    public static String KEJI_JUNGONG = "科技-军工";
    public static List KEJI = new ArrayList();//
    static {
        KEJI.add(KEJI_GONG_YE);
        KEJI.add(KEJI_NEW_CAR);
        KEJI.add(KEJI_NEW_ENERGY);
        KEJI.add(KEJI_RUAN_JIAN);
        KEJI.add(KEJI_XIN_PIAN);
        KEJI.add(KEJI_TONG_XIN);
        KEJI.add(KEJI_HK);
        KEJI.add(KEJI_JUNGONG);
//        KEJI.add(KEJI_ELECTRICITY);
    }

    /**
     * 消费
     */
    public static String XIAOFEI_COMMON = "消费-通用";
    public static String XIAOFEI_MEDIA = "消费-文娱传媒";
    public static String XIAOFEI_WINE = "消费-吃喝玩乐";
//    public static String XIAOFEI_HK = "消费-香港消费";
//    public static String XIAOFEI_HOUSE = "消费-家电";
//    public static String XIAOFEI_FILM = "消费-影视";
//    public static String XIAOFEI_GAME = "消费-游戏";
//    public static String XIAOFEI_OLD = "消费-养老";
//    public static String XIAOFEI_EXPRESS = "消费-物流";
//    public static String XIAOFEI_TRAVEL = "消费-旅游";
    public static List XIAOFEI = new ArrayList();//消费
    static {
        XIAOFEI.add(XIAOFEI_COMMON);
        XIAOFEI.add(XIAOFEI_MEDIA);
        XIAOFEI.add(XIAOFEI_WINE);
//        XIAOFEI.add(XIAOFEI_HK);
//        XIAOFEI.add(XIAOFEI_HOUSE);
//        XIAOFEI.add(XIAOFEI_TRAVEL);
//        XIAOFEI.add(XIAOFEI_FILM);
//        XIAOFEI.add(XIAOFEI_GAME);
    }

    /**
     * 指数
     */
    public static String INDEX_CN_NOT= "指数-外盘";
    public static String INDEX_CN_NOT_USA= "指数-外盘-美股";
    public static String INDEX_CN_1000 = "指数-中小盘";
    public static String INDEX_CN_BIG = "指数-大盘";
    public static String INDEX_300 = "指数-创业板";
    public static String INDEX_688 = "指数-科创板";
    public static String INDEX_CN_CITY = "指数-国内城市";
//    public static String INDEX_HK = "指数-港股";
    public static List INDEX = new ArrayList();
    static {
        INDEX.add(INDEX_CN_1000);
        INDEX.add(INDEX_300);
        INDEX.add(INDEX_688);
        INDEX.add(INDEX_CN_BIG);
        INDEX.add(INDEX_CN_NOT);
        INDEX.add(INDEX_CN_NOT_USA);
//        INDEX.add(INDEX_HK);
//        INDEX.add(INDEX_CN_CITY);
    }

    /**
     * 资源
     */
    public static String ZIYUAN_OIL  = "资源-石油";
    public static String ZIYUAN_NONGYE  = "资源-农业";
//    public static String ZIYUAN_CAILIAO = "资源-材料";
    public static String ZIYUAN_XIYOU = "资源-稀有";
    public static String ZIYUAN_COMMON = "资源-通用";
    public static String ZIYUAN_STR = "资源";
    public static List ZIYUAN = new ArrayList();
    static {
        ZIYUAN.add(ZIYUAN_OIL);
        ZIYUAN.add(ZIYUAN_NONGYE);
        ZIYUAN.add(ZIYUAN_XIYOU);
        ZIYUAN.add(ZIYUAN_COMMON);
//        ZIYUAN.add(ZIYUAN_CAILIAO);
    }

    /**
     * 金融
     */
    public static String JINRONG_ZHENGQUAN = "金融-证券";
    public static String JINRONG_GOLD = "金融-黄金";
    public static String JINRONG_BANK = "金融-银行";
    public static String JINRONG_FANGDICHAN = "金融-地产";
    public static String JINRONG_CASH  = "金融-现金";
    public static List JINRONG = new ArrayList();
    static {
        JINRONG.add(JINRONG_ZHENGQUAN);
        JINRONG.add(JINRONG_GOLD);
        JINRONG.add(JINRONG_BANK);
        JINRONG.add(JINRONG_FANGDICHAN);
//        JINRONG.add(JINRONG_CASH);
    }

    public static List ALL = new ArrayList();
    static {
        ALL.addAll(JINRONG);
        ALL.addAll(ZIYUAN);
        ALL.addAll(XIAOFEI);
        ALL.addAll(KEJI);
        ALL.addAll(INDEX);
        ALL.addAll(YILIAO);
    }
}
