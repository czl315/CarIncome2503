package utils;

import java.util.*;

/**
 * 常量-ETF名称的关键字，方便模糊查询数据库
 * 2025-03-05：1065
 */
public class ContEtfNameKey {
    public static List ETF_NAME_NAME_LIST_LIKE_CN_HK = Arrays.asList("港", "恒生");//港股
    public static List ETF_NAME_NAME_LIST_LIKE_KEJI_XIN_PIAN = Arrays.asList("芯片", "5G", "通信", "集成电路", "半导体", "电子", "TMT", "消电", "智能消费");//科技-芯片
    public static List ETF_NAME_NAME_LIST_LIKE_KEJI_RUAN_JIAN = Arrays.asList("数据", "云", "信创", "金融科技", "人工智能", "软件", "机器人", "信息");//科技-软件
    public static List ETF_NAME_NAME_LIST_LIKE_XIAO_FEI = Arrays.asList("消费", "家电", "酒", "旅游", "食", "养老", "航空", "物流", "游戏", "影视");//消费-

}
