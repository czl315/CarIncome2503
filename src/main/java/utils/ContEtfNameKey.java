package utils;

import java.util.*;

/**
 * 常量-ETF名称的关键字，方便模糊查询数据库
 * 2025-03-05：1065
 */
public class ContEtfNameKey {


//    public static List INDEX_CN_CITY= Arrays.asList("111");//指数-国内城市

    public static List ZIYUAN = Arrays.asList("新材料", "稀有金属", "钢铁", "稀土", "有色", "豆粕", "矿业", "农", "材料", "化工", "畜牧", "养殖", "大宗", "资源", "石油", "石化", "煤炭", "能源", "油气");//资源
    public static List ZIYUAN_XIYOU = Arrays.asList("稀有金属", "稀土", "有色");//资源

    public static List INDEX_CN_NOT = Arrays.asList("标普", "纳", "道琼斯", "德", "亚", "沙特", "法国", "日经", "日本");//指数-外盘
    public static List INDEX_CN_CITY = Arrays.asList("张江", "湖北", "杭州", "成渝", "大湾区", "长三角", "上海", "浙江", "长江", "浙商", "湾创");//指数-国内城市
    public static List INDEX_CN_1000 = Arrays.asList("2000", "1000", "800", "500", "民企", "中小100", "深成长");//指数-中小盘
    public static List INDEX_CN_BIG = Arrays.asList("沪深300", "深证", "上证50", "央企", "A股", "深F60", "深成", "180", "深红利", "A100", "超大盘", "300", "50ETF", "上证综指",
            "央视", "深价值", "A50", "红利", "深100", "国企", "380", "MSCI", "质量", "上证综合", "上证中盘", "基本面", "价值", "上证指数", "高股息", "一带一路");//指数-大盘
    public static List INDEX_300 = Arrays.asList("创业", "创中盘", "创400", "创300", "创大盘", "创50", "创100", "深创");//指数-创业板
    public static List INDEX_688 = Arrays.asList("科创", "双创");//指数-科创板
    public static List INDEX_HK = Arrays.asList("港股", "恒生", "H股", "沪港深");//指数-港股

    public static List YILIAO = new ArrayList();//医疗
    public static List YILIAO_CN_NOT = Arrays.asList("医药", "创新药", "医疗", "生物", "疫苗");//医疗
    public static List YILIAO_CN_MEDICINE = Arrays.asList("中药");//医疗

    static {
        YILIAO.addAll(YILIAO_CN_NOT);
        YILIAO.addAll(YILIAO_CN_MEDICINE);
    }

    public static List JINRONG_ZHENGQUAN = Arrays.asList("证券", "券商", "黄金", "金融", "银行", "金ETF");//金融-证券
    public static List JINRONG_FANGDICHAN = Arrays.asList("地产", "建材", "基建", "交", "电力", "公用");//金融-地产
    public static List JINRONG_CASH = Arrays.asList("现金", "添利", "国债", "日利", "货币", "添益", "快", "财富");//金融-现金

    public static List KEJI_GONG_YE = Arrays.asList("物联网", "工业母机", "机床", "专精特新", "智能制造", "机械", "新能车", "央企科技", "科技50", "科技ETF", "新经济", "战略", "创新", "科技100", "高端", "核心", "科技", "VR", "漂亮", "国货", "ESG", "可持续", "产业");//科技-工业
    public static List KEJI_NEW_CAR = Arrays.asList("汽车", "智能驾驶", "新能源车", "智慧电车", "电动车", "电池", "智能汽车", "智能车", "电池", "新能源汽车", "新能源车");//科技-汽车
    public static List KEJI_NEW_ENERGY = Arrays.asList("新能源", "光伏", "绿色能源", "电网", "环保", "碳", "碳", "绿电");//科技-新能源
    public static List KEJI_RUAN_JIAN = Arrays.asList("数据", "云", "信创", "金融科技", "人工智能", "AI", "软件", "机器人", "信息", "计算机", "教育", "数字经济");//科技-软件
    public static List KEJI_XIN_PIAN = Arrays.asList("芯片", "5G", "通信", "电信", "集成电路", "半导体", "电子", "TMT", "消电", "智能消费");//科技-芯片
    public static List KEJI_HK = Arrays.asList("香港科技", "港股科技", "港股通科技", "港股互联网", "互联", "恒生科技", "恒生新经济", "中概", "沪港深科技", "科技龙头");//科技-香港
    public static List KEJI_JUNGONG = Arrays.asList("国防", "军工");//科技-军工

    public static List XIAOFEI_HK = Arrays.asList("香港消费", "港股消费", "恒生消费", "消费ETF沪港深", "线上消费", "在线消费", "消费");//消费-香港消费
    public static List XIAOFEI_GAME = Arrays.asList("游戏");//消费-游戏
    public static List XIAOFEI_MEDIA = Arrays.asList("传媒");//消费-游戏
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
        XIAOFEI.addAll(XIAOFEI_MEDIA);
        XIAOFEI.addAll(XIAOFEI_FOOD);
        XIAOFEI.addAll(XIAOFEI_WINE);
        XIAOFEI.addAll(XIAOFEI_HOUSE);
        XIAOFEI.addAll(XIAOFEI_OLD);
        XIAOFEI.addAll(XIAOFEI_EXPRESS);
        XIAOFEI.addAll(XIAOFEI_WINE);
    }

    public static void main(String[] args) {
//        showSqlNameLike(KEJI_HK);
//        showSqlNameLike(XIAOFEI);
//        showSqlNameLike(YILIAO);
        showSqlNameLike(KEJI_JUNGONG);

//        showSqlNameLikeNot(XIAOFEI);
//        showSqlNameLikeNot(KEJI_HK);
//        showSqlNameLikeNot(KEJI_XIN_PIAN);
//        showSqlNameLikeNot(KEJI_RUAN_JIAN);
//        showSqlNameLikeNot(KEJI_GONG_YE);
//        showSqlNameLikeNot(JINRONG_ZHENGQUAN);
//        showSqlNameLikeNot(INDEX_HK);
//        showSqlNameLikeNot(INDEX_688);
//        showSqlNameLikeNot(YILIAO);
//        showSqlNameLikeNot(INDEX_300);
//        showSqlNameLikeNot(INDEX_CN_1000);
//        showSqlNameLikeNot(INDEX_CN_CITY);
//        showSqlNameLikeNot(INDEX_CN_NOT);
//        showSqlNameLikeNot(JINRONG_FANGDICHAN);
//        showSqlNameLikeNot(KEJI_JUNGONG);
//        showSqlNameLikeNot(ZIYUAN);
//        showSqlNameLikeNot(KEJI_NEW_CAR);
//        showSqlNameLikeNot(KEJI_NEW_ENERGY);
//        showSqlNameLikeNot(INDEX_CN_BIG);
//        showSqlNameLikeNot(JINRONG_CASH);
    }

    /**
     * 显示sql表达式:模糊查询
     *
     * @param list list
     */
    private static void showSqlNameLike(List<String> list) {
        int i = 0;
        StringBuffer sql = new StringBuffer();
        sql.append(" AND ");
        sql.append("(");
        for (String str : list) {
            if (i == 0) {
                sql.append("f14 LIKE '%" + str + "%'");
            } else {
                sql.append("OR f14 LIKE '%" + str + "%'");
            }
            i++;
        }
        sql.append(")");
        System.out.println(sql);
    }

    /**
     * 显示sql表达式:非模糊查询
     *
     * @param list list
     */
    private static void showSqlNameLikeNot(List<String> list) {
        int i = 0;
        StringBuffer sql = new StringBuffer();
        sql.append("AND");
        sql.append("(");
        for (String str : list) {
            if (i == 0) {
                sql.append("f14 NOT LIKE '%" + str + "%'");
            } else {
                sql.append("AND f14 NOT LIKE '%" + str + "%'");
            }
            i++;
        }
        sql.append(" ) ");
        System.out.println(sql);
    }

}
