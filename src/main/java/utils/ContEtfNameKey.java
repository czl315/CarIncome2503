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

    public static List XIAOFEI_HK = Arrays.asList("香港消费", "港股消费", "恒生消费", "消费ETF沪港深", "线上消费", "在线消费");//消费-香港消费
    public static List XIAOFEI_GAME = Arrays.asList("游戏");//消费-游戏
    public static List XIAOFEI_TRAVEL = Arrays.asList("航空", "旅游");//消费-旅游
    public static List XIAOFEI_FILM = Arrays.asList("影视");//消费-影视
    public static List XIAOFEI_FOOD = Arrays.asList("食品", "饮食", "粮食");//消费-食品
    public static List XIAOFEI_WINE = Arrays.asList("酒");//消费-酒
    public static List XIAOFEI_HOUSE = Arrays.asList("家电");//消费-家电
    public static List XIAOFEI_OLD = Arrays.asList("养老");//消费-养老
    public static List XIAOFEI_EXPRESS = Arrays.asList("物流");//消费-物流
    public static List XIAOFEI = new ArrayList();//消费-

    static {
        XIAOFEI.addAll(XIAOFEI_HK);
        XIAOFEI.addAll(XIAOFEI_GAME);
        XIAOFEI.addAll(XIAOFEI_TRAVEL);
        XIAOFEI.addAll(XIAOFEI_FILM);
        XIAOFEI.addAll(XIAOFEI_FOOD);
        XIAOFEI.addAll(XIAOFEI_WINE);
        XIAOFEI.addAll(XIAOFEI_HOUSE);
        XIAOFEI.addAll(XIAOFEI_OLD);
        XIAOFEI.addAll(XIAOFEI_EXPRESS);
        XIAOFEI.addAll(XIAOFEI_WINE);
    }

    public static void main(String[] args) {
        showSqlNameLike(XIAOFEI );
        showSqlNameLikeNot(XIAOFEI_HK );
        showSqlNameLikeNot(XIAOFEI_GAME );
    }

    /**
     * 显示sql表达式:模糊查询
     *
     * @param list list
     */
    private static void showSqlNameLike(List<String> list ) {
        int i = 0;
        StringBuffer sql = new StringBuffer();
        sql.append(" AND ");
        sql.append(" ( ");
            for (String str : list) {
                if (i == 0) {
                    sql.append(" f14 LIKE '%" + str + "%'");
                } else {
                    sql.append(" OR f14 LIKE '%" + str + "%'");
                }
                i++;
            }
            for (String str : list) {
                if (i == 0) {
                    sql.append(" f14 NOT LIKE '%" + str + "%'");
                } else {
                    sql.append(" AND f14 NOT LIKE '%" + str + "%'");
                }
                i++;
        }
        sql.append(" ) ");
        System.out.println(sql);
    }
    /**
     * 显示sql表达式:非模糊查询
     *
     * @param list list
     */
    private static void showSqlNameLikeNot(List<String> list ) {
        int i = 0;
        StringBuffer sql = new StringBuffer();
        sql.append(" AND ");
        sql.append(" ( ");
        for (String str : list) {
            if (i == 0) {
                sql.append(" f14 NOT LIKE '%" + str + "%'");
            } else {
                sql.append(" AND f14 NOT LIKE '%" + str + "%'");
            }
            i++;
        }
        sql.append(" ) ");
        System.out.println(sql);
    }

}
