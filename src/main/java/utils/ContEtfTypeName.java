package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 常量-ETF类型名称
 * 2025-03-05：1065
 */
public class ContEtfTypeName {
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
    }
}
