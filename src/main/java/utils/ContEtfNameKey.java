package utils;

import java.util.*;

/**
 * 常量-ETF名称的关键字，方便模糊查询数据库
 * 2025-03-05：1065
 */
public class ContEtfNameKey {

    /**
     * 资源
     */
    public static List ZIYUAN_COMMON = Arrays.asList("钢铁", "豆粕", "矿业", "化工", "大宗", "资源", "煤炭", "能源","新材料", "材料");
    public static List ZIYUAN_COMMON_NOLIKE = Arrays.asList("油气", "新能源","半导体");
    public static List ZIYUAN_OIL = Arrays.asList("石油", "石化", "油气");//资源-石油
    public static List ZIYUAN_XIYOU = Arrays.asList("稀有金属", "稀土", "有色");
    public static List ZIYUAN_NONGYE = Arrays.asList("农", "畜牧", "养殖", "粮食");
    public static List ZIYUAN_NOLIKE = Arrays.asList("新能源","半导体");
    public static List ZIYUAN = new ArrayList();

    static {
        ZIYUAN.addAll(ZIYUAN_XIYOU);
        ZIYUAN.addAll(ZIYUAN_NONGYE);
        ZIYUAN.addAll(ZIYUAN_OIL);
        ZIYUAN.addAll(ZIYUAN_COMMON);
    }

    public static List INDEX_CN_NOT = Arrays.asList("德", "亚", "沙特", "法国", "日经", "日本");//指数-外盘
    public static List INDEX_CN_NOT_USA = Arrays.asList("标普", "纳", "道琼斯", "美国");//指数-外盘-美股

    public static List INDEX_CN_CITY = Arrays.asList("张江", "湖北", "杭州", "成渝", "大湾区", "长三角", "上海", "浙江", "长江", "浙商", "湾创");//指数-国内城市
    public static List INDEX_CN_1000 = Arrays.asList("2000", "1000", "800", "500", "民企", "中小100", "深成长");//指数-中小盘
    public static List INDEX_CN_BIG = Arrays.asList("沪深300", "深证", "上证50", "央企", "A股", "深F60", "深成", "180", "深红利", "A100", "超大盘", "300", "上证综指",
            "央视", "深价值", "A50", "红利", "深100", "国企", "380", "MSCI", "质量", "上证综合", "上证中盘", "基本面", "价值", "上证指数", "高股息", "一带一路", "50ETF基金");//指数-大盘
    public static List INDEX_CN_BIG_NOLIKE = Arrays.asList("恒生", "港股", "双创", "科创");
    public static List INDEX_300 = Arrays.asList("创业", "创中盘", "创400", "创300", "创大盘", "创50", "创100", "深创");//指数-创业板
    public static List INDEX_300_NOLIKE = Arrays.asList("信创", "人工智能", "科创");//指数-创业板（不匹配）
    public static List INDEX_688 = Arrays.asList("科创", "双创");//指数-科创板
    public static List INDEX_688_NOLIKE = Arrays.asList("芯片", "医药", "人工智能");//指数-创业板（不匹配）
    public static List INDEX_HK = Arrays.asList("港股", "恒生", "H股", "沪港深");//指数-港股
    public static List INDEX_HK_NOLIKE = Arrays.asList("创新药", "医", "生物", "汽车");
    public static List INDEX = new ArrayList();

    static {
        INDEX.addAll(INDEX_CN_NOT);
        INDEX.addAll(INDEX_CN_NOT_USA);
        INDEX.addAll(INDEX_CN_1000);
        INDEX.addAll(INDEX_CN_BIG);
        INDEX.addAll(INDEX_300);
        INDEX.addAll(INDEX_688);
        INDEX.addAll(INDEX_HK);
    }

    public static List YILIAO = new ArrayList();//医疗
    public static List YILIAO_COMMON = Arrays.asList("医药", "创新药", "医疗", "生物", "疫苗", "中药");//医疗-通用
//    public static List YILIAO_CN_MEDICINE = Arrays.asList("中药");//医疗-中药，涨幅累计太少

    static {
        YILIAO.addAll(YILIAO_COMMON);
//        YILIAO.addAll(YILIAO_CN_MEDICINE);
    }

    /**
     * 金融
     */
    public static List JINRONG_GOLD = Arrays.asList("黄金", "金ETF");//金融-黄金
    public static List JINRONG_GOLD_NOLIKE = Arrays.asList("天天金", "货币基金ETF");//金融-黄金（过滤）
    public static List JINRONG_BANK = Arrays.asList("银行");//金融-银行
    public static List JINRONG_ZHENGQUAN = Arrays.asList("证券", "券商", "金融");//金融-证券
    public static List JINRONG_ZHENGQUAN_NOLIKE = Arrays.asList("金融科技");
    public static List JINRONG_FANGDICHAN = Arrays.asList("地产", "建材", "基建", "交运", "交通", "公用");//金融-地产
    public static List JINRONG_CASH = Arrays.asList("现金", "添利", "国债", "日利", "货币", "添益", "快线", "快钱", "财富", "天天金");//金融-现金
    public static List JINRONG = new ArrayList();//金融

    static {
        JINRONG.addAll(JINRONG_BANK);
        JINRONG.addAll(JINRONG_ZHENGQUAN);
        JINRONG.addAll(JINRONG_FANGDICHAN);
        JINRONG.addAll(JINRONG_CASH);
        JINRONG.addAll(JINRONG_GOLD);
    }

    public static List KEJI_GONG_YE = Arrays.asList("物联网", "机床",  "工业母机", "工业互联","专精特新", "智能制造", "机械", "央企科技", "科技50", "科技ETF", "战略", "科技100", "核心",
            "科技", "VR", "漂亮", "国货", "ESG", "可持续", "卫星", "产业升级", "创新100", "G60创新","科技龙头");//科技-工业
    public static List KEJI_GONG_YE_NOLIKE = Arrays.asList("纳指", "标普", "港股", "香港", "恒生", "中概", "东南亚", "生物", "金融", "货币", "沪港深科技", "科技ETF沪港深");//科技-工业
    public static List KEJI_NEW_CAR = Arrays.asList("汽车", "智能驾驶", "新能源车", "智慧电车", "电动车", "电池", "智能汽车", "智能车", "电池", "新能源汽车", "新能源车", "新能车");//科技-汽车
    public static List KEJI_NEW_ENERGY = Arrays.asList("新能源50", "新能源ETF", "新能源主题", "新能源龙头", "光伏", "绿色能源", "电网", "环保", "碳", "绿电", "电力");//科技-新能源
    public static List KEJI_RUAN_JIAN = Arrays.asList("数据", "云", "信创", "金融科技", "人工智能", "AI", "软件", "机器人", "信息", "计算机", "教育", "数字经济");//科技-软件
    public static List KEJI_XIN_PIAN = Arrays.asList("芯片", "集成电路", "半导体", "电子", "TMT", "消电", "智能消费");//科技-芯片
    public static List KEJI_TONG_XIN = Arrays.asList("5G", "通信", "电信");//科技-芯片
    public static List KEJI_HK = Arrays.asList("香港科技", "港股科技", "港股通科技", "港股互联网", "互联", "恒生科技", "恒生新经济", "中概", "沪港深科技","科技ETF沪港深", "新经济","香港消费", "港股消费", "恒生消费", "消费ETF沪港深", "线上消费", "在线消费");//科技-香港
    public static List KEJI_JUNGONG = Arrays.asList("国防", "军工","航空","高端");//科技-军工
    public static List KEJI = new ArrayList();//科技

    static {
        KEJI.addAll(KEJI_GONG_YE);
        KEJI.addAll(KEJI_RUAN_JIAN);
    }

    /**
     * 消费
     */
    public static List XIAOFEI_COMMON = Arrays.asList("线上消费", "在线消费", "品牌消费", "消费30", "消费龙头", "消费50", "消费ETF", "主要消费", "必选消费", "消费服务", "物流", "养老","家电");//消费-通用
    public static List XIAOFEI_COMMON_NOLIKE = Arrays.asList("标普", "香港消费", "港股消费", "恒生消费", "消费ETF沪港深", "线上消费", "在线消费");//消费-通用
    public static List XIAOFEI_MEDIA = Arrays.asList("游戏", "影视", "传媒");//消费-文娱传媒
    public static List XIAOFEI_WINE = Arrays.asList("酒", "食品", "饮食", "旅游");//消费-酒
//    public static List XIAOFEI_HOUSE = Arrays.asList("家电");//消费-家电
    public static List XIAOFEI = new ArrayList();//消费-

    static {
        XIAOFEI.addAll(XIAOFEI_COMMON);
        XIAOFEI.addAll(XIAOFEI_MEDIA);
        XIAOFEI.addAll(XIAOFEI_WINE);
        XIAOFEI.addAll(XIAOFEI_WINE);
//        XIAOFEI.addAll(XIAOFEI_HK);
//        XIAOFEI.addAll(XIAOFEI_HOUSE);
//        XIAOFEI.addAll(XIAOFEI_TRAVEL);
    }

    public static void main(String[] args) {
//        showSqlNameLike(KEJI_HK);
//        showSqlNameLike(XIAOFEI);
//        showSqlNameLike(YILIAO);
//        showSqlNameLike(KEJI_JUNGONG);
//        showSqlNameLike(ZIYUAN_XIYOU);

        //消费-
//        showSqlNameLike(XIAOFEI);
//        showSqlNameLike(XIAOFEI_HK);
//        showSqlNameLike(XIAOFEI_FOOD);
//        showSqlNameLikeNot(XIAOFEI);

        showSqlNameLikeNot(YILIAO);


        //创业板
//        showSqlNameLike(INDEX_300);
//        showSqlNameLikeNot(INDEX_300_NOLIKE);
//        showSqlNameLikeNot(INDEX_300);

        //科创板
//        showSqlNameLikeNot(INDEX_688);

//        showSqlNameLikeNot(KEJI_XIN_PIAN);
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
        sql.append(" AND");
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
