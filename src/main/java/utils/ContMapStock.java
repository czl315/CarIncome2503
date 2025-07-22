package utils;

import ttjj.dto.CondEtfAdrCount;
import ttjj.dto.EtfAdrCountVo;
import ttjj.service.EtfAdrCountService;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static utils.Content.*;

/**
 * 常量-股票：根据数据统计顶尖数据
 *
 */
public class ContMapStock {


    public static Map<String, String> JINRONG_ZHENGQUAN = new HashMap<>();//金融-证券
    public static Map<String, String> TOP_JINRONG_ZHENGQUAN = new HashMap<>();

    static {
        TOP_JINRONG_ZHENGQUAN.put("513090", "金融-证券             ");//香港证券ETF           市值：76.43     累涨：43.00     11.75     16.35     14.90     10日：6.31      5.39      2.89      1.44      1         累涨修正：60.48     净值区间：87      89      91      96      80      1
    }

    static {
        JINRONG_ZHENGQUAN.put("513090", "金融-证券             ");//香港证券ETF           市值：76.43     累涨：43.00     11.75     16.35     14.90     10日：6.31      5.39      2.89      1.44      1         累涨修正：60.48     净值区间：87      89      91      96      80      1
        JINRONG_ZHENGQUAN.put("513140", "金融-证券             ");//港股金融ETF           市值：0.80      累涨：32.70     8.99      13.54     10.17     10日：3.08      2.49      1.75      0.50      6         累涨修正：41.77     净值区间：89      89      95      98      98      2
        JINRONG_ZHENGQUAN.put("516980", "金融-证券             ");//证券ETF先锋           市值：0.34      累涨：27.60     8.02      8.94      10.64     10日：3.31      3.21      2.23      1.14      5         累涨修正：38.58     净值区间：98      98      59      75      56      3
        JINRONG_ZHENGQUAN.put("159848", "金融-证券             ");//证券ETF基金           市值：1.09      累涨：27.36     7.57      9.17      10.62     10日：3.36      3.24      2.03      0.82      3         累涨修正：38.02     净值区间：91      91      48      71      54      4
        JINRONG_ZHENGQUAN.put("512880", "金融-证券             ");//证券ETF               市值：294.52    累涨：26.91     7.47      9.18      10.26     10日：3.35      3.35      2.10      0.94      2         累涨修正：37.81     净值区间：87      87      48      70      53      5
        JINRONG_ZHENGQUAN.put("512000", "金融-证券             ");//券商ETF               市值：230.52    累涨：26.81     7.34      9.32      10.15     10日：3.30      3.30      2.09      0.98      4         累涨修正：37.59     净值区间：88      89      48      70      54      6
        JINRONG_ZHENGQUAN.put("513190", "金融-证券             ");//港股通金融ETF         市值：9.89      累涨：28.57     8.59      10.39     9.59      10日：2.77      2.24      1.91      0.71      16        累涨修正：37.4      净值区间：90      90      95      98      95      7
        JINRONG_ZHENGQUAN.put("515850", "金融-证券             ");//券商指数ETF           市值：2.49      累涨：27.04     7.65      9.29      10.10     10日：3.13      3.13      1.95      0.92      10        累涨修正：37.2      净值区间：91      91      49      71      55      8
        JINRONG_ZHENGQUAN.put("512070", "金融-证券             ");//证券保险ETF           市值：69.27     累涨：28.08     8.56      8.12      11.40     10日：2.90      2.77      1.71      0.91      15        累涨修正：37.17     净值区间：93      93      57      78      72      9
        JINRONG_ZHENGQUAN.put("515010", "金融-证券             ");//券商ETF基金           市值：9.99      累涨：26.59     7.25      9.19      10.15     10日：3.19      3.19      2.09      0.90      12        累涨修正：37.15     净值区间：88      88      48      70      54      10
        JINRONG_ZHENGQUAN.put("512900", "金融-证券             ");//证券ETF南方           市值：66.15     累涨：26.58     7.28      9.10      10.20     10日：3.20      3.20      2.03      0.85      9         累涨修正：37.04     净值区间：86      87      47      70      53      11
        JINRONG_ZHENGQUAN.put("159692", "金融-证券             ");//证券ETF东财           市值：3.65      累涨：26.40     7.53      9.33      9.54      10日：3.23      3.23      2.09      0.94      7         累涨修正：37.04     净值区间：88      88      50      72      56      12
        JINRONG_ZHENGQUAN.put("159993", "金融-证券             ");//证券ETF龙头           市值：15.01     累涨：26.30     6.70      9.59      10.01     10日：3.24      3.24      2.06      0.88      8         累涨修正：36.9      净值区间：91      91      48      71      58      13
        JINRONG_ZHENGQUAN.put("159842", "金融-证券             ");//券商ETF               市值：17.68     累涨：26.36     7.14      9.18      10.04     10日：3.24      3.24      2.02      0.89      11        累涨修正：36.88     净值区间：90      90      47      71      54      14
        JINRONG_ZHENGQUAN.put("159841", "金融-证券             ");//证券ETF               市值：61.89     累涨：26.29     6.94      9.38      9.97      10日：3.17      3.17      2.00      1.04      14        累涨修正：36.63     净值区间：90      90      49      71      54      15
        JINRONG_ZHENGQUAN.put("512570", "金融-证券             ");//证券ETF易方达         市值：7.75      累涨：25.94     6.94      9.11      9.89      10日：3.26      3.26      2.00      1.03      13        累涨修正：36.46     净值区间：91      91      48      71      55      16
        JINRONG_ZHENGQUAN.put("560090", "金融-证券             ");//证券ETF龙头           市值：18.84     累涨：26.18     6.95      9.21      10.02     10日：3.03      3.03      1.86      1.14      18        累涨修正：35.96     净值区间：93      94      46      69      54      17
        JINRONG_ZHENGQUAN.put("516730", "金融-证券             ");//证券公司ETF           市值：0.75      累涨：25.87     6.91      9.04      9.92      10日：3.08      3.08      1.90      1.15      22        累涨修正：35.83     净值区间：95      95      52      73      56      18
        JINRONG_ZHENGQUAN.put("516200", "金融-证券             ");//证券ETF指数基金       市值：3.84      累涨：25.70     6.85      9.31      9.54      10日：3.00      3.00      1.99      0.78      24        累涨修正：35.68     净值区间：90      90      49      71      53      19
        JINRONG_ZHENGQUAN.put("510200", "金融-证券             ");//上证券商ETF           市值：1.46      累涨：24.96     6.73      9.53      8.70      10日：3.12      3.12      2.13      1.22      20        累涨修正：35.46     净值区间：94      94      60      79      59      20
        JINRONG_ZHENGQUAN.put("515560", "金融-证券             ");//证券ETF建信           市值：2.25      累涨：25.44     6.60      8.54      10.30     10日：3.04      3.04      1.88      0.92      21        累涨修正：35.28     净值区间：92      92      49      72      55      21
        JINRONG_ZHENGQUAN.put("515630", "金融-证券             ");//保险证券ETF           市值：2.71      累涨：25.93     7.72      7.51      10.70     10日：2.80      2.80      1.72      0.89      17        累涨修正：34.97     净值区间：92      92      52      75      65      22
        JINRONG_ZHENGQUAN.put("159940", "金融-证券             ");//金融地产ETF           市值：10.11     累涨：25.51     6.09      9.75      9.67      10日：3.34      2.57      1.62      -0.08     3         累涨修正：34.66     净值区间：85      86      79      91      91      23
        JINRONG_ZHENGQUAN.put("159933", "金融-证券             ");//国投金融地产ETF       市值：1.44      累涨：24.97     6.83      8.54      9.60      10日：3.38      2.31      1.84      0.21      1         累涨修正：34.34     净值区间：67      67      73      88      88      24
        JINRONG_ZHENGQUAN.put("159931", "金融-证券             ");//金融ETF               市值：0.58      累涨：24.42     6.78      7.47      10.17     10日：3.89      2.03      1.64      0.11      19        累涨修正：33.62     净值区间：88      89      69      85      84      25
        JINRONG_ZHENGQUAN.put("510650", "金融-证券             ");//金融地产ETF           市值：0.41      累涨：23.87     6.05      8.07      9.75      10日：3.24      1.92      1.92      0.11      8         累涨修正：32.87     净值区间：93      94      90      96      96      26
        JINRONG_ZHENGQUAN.put("515190", "金融-证券             ");//中银证券500ETF        市值：0.85      累涨：23.44     5.47      10.50     7.47      10日：3.19      2.68      1.29      0.59      23        累涨修正：31.89     净值区间：100     100     83      95      61      27
        JINRONG_ZHENGQUAN.put("512640", "金融-证券             ");//金融地产ETF基金       市值：0.71      累涨：22.48     6.09      7.35      9.04      10日：2.82      2.08      1.69      0.17      9         累涨修正：30.76     净值区间：90      90      77      92      92      28
        JINRONG_ZHENGQUAN.put("510230", "金融-证券             ");//金融ETF               市值：48.14     累涨：21.92     5.74      6.74      9.44      10日：3.03      1.85      1.78      0.29      25        累涨修正：30.36     净值区间：90      90      88      95      95      29
    }


    public static Map<String, String> JINRONG = new HashMap<>();
    static {
        JINRONG.putAll(JINRONG_ZHENGQUAN);
    }
    public static Map<String, String> TOP_JINRONG = new HashMap<>();

    static {
        TOP_JINRONG.putAll(TOP_JINRONG_ZHENGQUAN);
    }

    /**
     *
     */
    public static Map<String, String> STOCK_All = new HashMap<>();

    static {
        STOCK_All.putAll(JINRONG);
//        STOCK_All.putAll(XIAOFEI);
//        STOCK_All.putAll(KEJI);
//        STOCK_All.putAll(YILIAO);
//        STOCK_All.putAll(ZIYUAN);
    }

    /**
     * TOP_BIZ
     */
    public static Map<String, String> TOP_STOCK_All = new HashMap<>();

    static {
        TOP_STOCK_All.putAll(TOP_JINRONG);
//        TOP_STOCK_All.putAll(TOP_XIAOFEI);
//        TOP_STOCK_All.putAll(TOP_KEJI);
//        TOP_STOCK_All.putAll(TOP_YILIAO);
//        TOP_STOCK_All.putAll(TOP_ZIYUAN);
    }

    /**
     * ETF涨幅数据：查询数据根据名称列表模糊查询
     */
    private static void findByTypeName(String date, String typeEn, String typeCn, Map<String, String> typeMap) {
        String channel = CHANNEL_STOCK ;
        long banKuai = DB_RANK_BIZ_F139_BK_MAIN;//股票-交易所板块
        System.out.println("    public static Map<String, String> TOP_" + typeEn + " = new HashMap<>();//" + typeCn);
        System.out.println("    static {");
        System.out.println("    }");
        System.out.println("    public static Map<String, String> " + typeEn + " = new HashMap<>();//" + typeCn);
//        String typeEn = "";
//        String typeCn = "";
        CondEtfAdrCount condition = new CondEtfAdrCount();
        condition.setDate(date);
        condition.setOrderBy(ADR_UP_SUM_TOTAL_DESC);//ADR_UP_SUM_TOTAL_DESC  ADR_UP_SUM_1_60_DESC
        condition.setChannel(channel);
        condition.setF139(banKuai);
        condition.setType_name(typeCn);//股票-交易所板块

//
        List<EtfAdrCountVo> etfListLikeName = EtfAdrCountService.listEtfAdrCountLikeName(condition);//查询列表，模糊查询：名称列表
//        EtfControl.saveOrUpdateListNetLastDay(condition, date, true);//保存或更新ETF涨幅次数-批量更新基础信息
//        CondEtfAdrCount conditionStock = new CondEtfAdrCount();//过滤条件
//                conditionStock.setF3Min(new BigDecimal("9"));//当日涨幅最低
//        conditionStock.setF139(DB_RANK_BIZ_F139_BK_MAIN);//股票-交易所板块
//                conditionStock.setMaxAdrUpSumTotalRank(new BigDecimal("1"));
//                conditionStock.setType_name("证券");//证券
//        etfListLikeName = EtfAdrCountService.findByDateOrderByField(date, ADR_UP_SUM_TOTAL_DESC, null, null, null,  conditionStock,channel);//涨幅倒序

        if (etfListLikeName == null) {
            System.out.println("数据为null");
        }
        int num = 0;//序号
        etfListLikeName = etfListLikeName.stream().filter(e -> e != null).sorted(Comparator.comparing(EtfAdrCountVo::getADR_UP_SUM_TOTAL, Comparator.nullsFirst(BigDecimal::compareTo)).reversed()).collect(Collectors.toList());

        System.out.println("    static {");
        for (EtfAdrCountVo vo : etfListLikeName) {
            StringBuffer sb = new StringBuffer();

            sb.append("        ");
            sb.append(typeEn + ".put(\"").append(StockUtil.formatStName(vo.getF12(), SIZE_6)).append("\"");
            sb.append(", \"" + StockUtil.formatStName(typeCn, SIZE_22) + "\");");
//            sb.append(", \"" + StockUtil.formatStName(vo.getF14(), SIZE_22) + "\");");
            sb.append("//");
            sb.append(StockUtil.formatStName(vo.getF14(), SIZE_22));
            sb.append(StockUtil.formatStName("市值：", SIZE_6));
            BigDecimal marketValue = null;
            if (vo.getF20() != null) {
                marketValue = vo.getF20().divide(NUM_YI_1, 2, BigDecimal.ROUND_HALF_UP);
            }
            sb.append(StockUtil.formatDouble(marketValue, SIZE_10));
            sb.append(StockUtil.formatStName("累涨：", SIZE_6));
            if (vo.getADR_UP_SUM_1_60() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_60().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_10));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_10));
            }
            if (vo.getADR_UP_SUM_40_60() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_40_60().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_10));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_10));
            }
            if (vo.getADR_UP_SUM_20_40() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_20_40().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_10));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_10));
            }
            if (vo.getADR_UP_SUM_1_20() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_20().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_10));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_10));
            }
            sb.append(StockUtil.formatStName("10日：", SIZE_6));
            if (vo.getADR_UP_SUM_1_10() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_10().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_10));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_10));
            }
            if (vo.getADR_UP_SUM_1_5() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_5().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_10));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_10));
            }
            if (vo.getADR_UP_SUM_1_3() != null) {
                sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_1_3().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_10));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_10));
            }
            if (vo.getF3() != null) {
                sb.append(StockUtil.formatDouble(vo.getF3().setScale(2, BigDecimal.ROUND_HALF_UP), SIZE_10));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_10));
            }
            sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_ORDER_STAT(), SIZE_10));
            sb.append(StockUtil.formatStName("累涨修正：", SIZE_10));
//            sb.append(StockUtil.formatDouble(vo.getAdrUpSum_60_and_10c6(), SIZE_10));
            sb.append(StockUtil.formatDouble(vo.getADR_UP_SUM_TOTAL(), SIZE_10));

            sb.append(StockUtil.formatStName("净值区间：", SIZE_10));
            BigDecimal curArea = vo.getNET_AREA_DAY_5();
            if (curArea != null) {
                sb.append(StockUtil.formatDouble(curArea.setScale(0, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            curArea = vo.getNET_AREA_DAY_10();
            if (curArea != null) {
                sb.append(StockUtil.formatDouble(curArea.setScale(0, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            curArea = vo.getNET_AREA_DAY_20();
            if (curArea != null) {
                sb.append(StockUtil.formatDouble(curArea.setScale(0, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            curArea = vo.getNET_AREA_DAY_40();
            if (curArea != null) {
                sb.append(StockUtil.formatDouble(curArea.setScale(0, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }
            curArea = vo.getNET_AREA_DAY_60();
            if (curArea != null) {
                sb.append(StockUtil.formatDouble(curArea.setScale(0, BigDecimal.ROUND_HALF_UP), SIZE_8));
            } else {
                sb.append(StockUtil.formatStName("", SIZE_8));
            }

            sb.append(StockUtil.formatInt(++num, SIZE_6));


            System.out.println(sb);
        }
        System.out.println("    }");


    }

    public static void main(String[] args) {
//        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
        String date = "2025-07-22";

        String name = "";
//        findByTypeName(date, ContEtfNameKey.INDEX_CN_NOT, null, "INDEX_CN_NOT", ContEtfTypeName.INDEX_CN_NOT, ContMapEtfAll.INDEX_CN_NOT);//指数-外盘
//        findByTypeName(date, ContEtfNameKey.INDEX_CN_NOT_USA,  ContEtfNameKey.INDEX_CN_NOT_USA_NOLIKE, "INDEX_CN_NOT_USA", ContEtfTypeName.INDEX_CN_NOT_USA, ContMapEtfAll.INDEX_CN_NOT_USA);//指数-外盘-美股
//        name = "INDEX_CN_1000";
//        System.out.println("    public static Map<String, String> " + name + " = new HashMap<>();//指数-中小盘");
//        System.out.println("    public static Map<String, String> TOP_" + name + " = new HashMap<>();");
//        System.out.println("    static {");
//        System.out.println("    }");
//        findByTypeName(date, ContEtfNameKey.INDEX_CN_1000, ContEtfNameKey.INDEX_CN_1000_NOLIKE, name, ContEtfTypeName.INDEX_CN_1000, ContMapEtfAll.INDEX_CN_1000);
//        findByTypeName(date, ContEtfNameKey.INDEX_300, ContEtfNameKey.INDEX_300_NOLIKE, "INDEX_300", ContEtfTypeName.INDEX_300, ContMapEtfAll.INDEX_300);//指数-创业板
//        findByTypeName(date, ContEtfNameKey.INDEX_688, ContEtfNameKey.INDEX_688_NOLIKE, "INDEX_688", ContEtfTypeName.INDEX_688, ContMapEtfAll.INDEX_688);//指数-科创板
//        name = "INDEX_CN_BIG";
//        System.out.println("    public static Map<String, String> " + name + " = new HashMap<>();//指数-大盘");
//        System.out.println("    public static Map<String, String> TOP_" + name + " = new HashMap<>();");
//        System.out.println("    static {");
//        System.out.println("    }");
//        findByTypeName(date, ContEtfNameKey.INDEX_CN_BIG, ContEtfNameKey.INDEX_CN_BIG_NOLIKE, name, ContEtfTypeName.INDEX_CN_BIG, ContMapEtfAll.INDEX_CN_BIG);


//        name = "ZIYUAN_OIL";
//        System.out.println("    public static Map<String, String> TOP_" + name + " = new HashMap<>();//资源-石油");
//        System.out.println("    static {");
//        System.out.println("    }");
//        System.out.println("    public static Map<String, String> " + name + " = new HashMap<>();//资源-石油");
//        findByTypeName(date, ContEtfNameKey.ZIYUAN_OIL, null, name, ContEtfTypeName.ZIYUAN_OIL, ContMapEtfAll.ZIYUAN_OIL);//资源-石油

//        name = "ZIYUAN_XIYOU";
//        System.out.println("    public static Map<String, String> " + name + " = new HashMap<>();");
//        System.out.println("    public static Map<String, String> TOP_" + name + " = new HashMap<>();");
//        System.out.println("    static {");
//        System.out.println("    }");
//        findByTypeName(date, ContEtfNameKey.ZIYUAN_XIYOU, null, name, ContEtfTypeName.ZIYUAN_XIYOU, ContMapEtfAll.ZIYUAN_XIYOU);
//        name = "ZIYUAN_COMMON";
//        findByTypeName(date, ContEtfNameKey.ZIYUAN_COMMON, ContEtfNameKey.ZIYUAN_COMMON_NOLIKE, name, ContEtfTypeName.ZIYUAN_COMMON, ContMapEtfAll.ZIYUAN_COMMON);
        //        name = "ZIYUAN_NONGYE";
//        System.out.println("    public static Map<String, String> " + name + " = new HashMap<>();");
//        System.out.println("    public static Map<String, String> TOP_" + name + " = new HashMap<>();");
//        System.out.println("    static {");
//        System.out.println("    }");
//        findByTypeName(date, ContEtfNameKey.ZIYUAN_NONGYE, null, name, ContEtfTypeName.ZIYUAN_NONGYE, ContMapEtfAll.ZIYUAN_NONGYE);
//        findByTypeName(date, ContEtfNameKey.ZIYUAN, ContEtfNameKey.ZIYUAN_NOLIKE, "ZIYUAN", ContEtfTypeName.ZIYUAN_STR, ContMapEtfAll.ZIYUAN);


//        String name = "YILIAO_COMMON";
//        System.out.println("    public static Map<String, String> " + name + " = new HashMap<>();//医疗");
//        System.out.println("    public static Map<String, String> TOP_" + name + " = new HashMap<>();");
//        System.out.println("    static {");
//        System.out.println("    }");
//        findByTypeName(date, ContEtfNameKey.YILIAO_COMMON, null, name, ContEtfTypeName.YILIAO_COMMON, ContMapEtfAll.YILIAO_COMMON);

        findByTypeName(date, "JINRONG_ZHENGQUAN", "证券", ContMapStock.JINRONG_ZHENGQUAN);//金融-证券
//        findByTypeName(date, ContEtfNameKey.JINRONG_GOLD, ContEtfNameKey.JINRONG_GOLD_NOLIKE, "JINRONG_GOLD", ContEtfTypeName.JINRONG_GOLD, ContMapEtfAll.JINRONG_GOLD);
//        findByTypeName(date, ContEtfNameKey.JINRONG_BANK, null, "JINRONG_BANK", ContEtfTypeName.JINRONG_BANK, ContMapEtfAll.JINRONG_BANK);//金融-银行
//        name = "JINRONG_FANGDICHAN";
//        System.out.println("    public static Map<String, String> TOP_JINRONG_FANGDICHAN = new HashMap<>();//金融-地产");
//        System.out.println("    static {");
//        System.out.println("    }");
//        System.out.println("    public static Map<String, String> JINRONG_FANGDICHAN = new HashMap<>();//金融-地产");
//        findByTypeName(date, ContEtfNameKey.JINRONG_FANGDICHAN, null, name, ContEtfTypeName.JINRONG_FANGDICHAN, ContMapEtfAll.JINRONG_FANGDICHAN);
//        System.out.println("    public static Map<String, String> JINRONG_CASH = new HashMap<>();//金融-现金");
//        System.out.println("    public static Map<String, String> TOP_JINRONG_CASH = new HashMap<>();");
//        System.out.println("    static {");
//        System.out.println("    }");
//        findByTypeName(date, ContEtfNameKey.JINRONG_CASH,  null, "JINRONG_CASH", ContEtfTypeName.JINRONG_CASH, ContMapEtfAll.JINRONG_CASH);

//        System.out.println("    public static Map<String, String> XIAOFEI_COMMON = new HashMap<>();//消费-通用");
//        findByTypeName(date, ContEtfNameKey.XIAOFEI_COMMON, ContEtfNameKey.XIAOFEI_COMMON_NOLIKE, "XIAOFEI_COMMON", ContEtfTypeName.XIAOFEI_COMMON, ContMapEtfAll.XIAOFEI_COMMON);
//        findByTypeName(date, ContEtfNameKey.XIAOFEI_MEDIA, null, "XIAOFEI_MEDIA", ContEtfTypeName.XIAOFEI_MEDIA, ContMapStock.XIAOFEI_MEDIA);//消费-文娱传媒
//        name = "XIAOFEI_WINE";
//        System.out.println("    public static Map<String, String> TOP_" + name + " = new HashMap<>();//消费-吃喝玩乐");
//        System.out.println("    static {");
//        System.out.println("    }");
//        System.out.println("    public static Map<String, String> " + name + " = new HashMap<>();//消费-吃喝玩乐");
//        findByTypeName(date, ContEtfNameKey.XIAOFEI_WINE, null, name, ContEtfTypeName.XIAOFEI_WINE, ContMapEtfAll.XIAOFEI_WINE);



//        findByTypeName(date, ContEtfNameKey.KEJI_HK, null, "KEJI_HK", ContEtfTypeName.KEJI_HK, ContMapEtfAll.KEJI_HK);//科技-香港
//        findByTypeName(date, ContEtfNameKey.KEJI_JUNGONG, null, "KEJI_JUNGONG", ContEtfTypeName.KEJI_JUNGONG, ContMapEtfAll.KEJI_JUNGONG);//科技-军工
//        findByTypeName(date, ContEtfNameKey.KEJI_GONG_YE, ContEtfNameKey.KEJI_GONG_YE_NOLIKE, "KEJI_GONG_YE", ContEtfTypeName.KEJI_GONG_YE, ContMapEtfAll.KEJI_GONG_YE);
//        findByTypeName(date, ContEtfNameKey.KEJI_RUAN_JIAN, null, "KEJI_RUAN_JIAN", ContEtfTypeName.KEJI_RUAN_JIAN, ContMapEtfAll.KEJI_RUAN_JIAN);
//        findByTypeName(date, ContEtfNameKey.KEJI_XIN_PIAN, null, "KEJI_XIN_PIAN", ContEtfTypeName.KEJI_XIN_PIAN, ContMapEtfAll.KEJI_XIN_PIAN);//科技-芯片
//        findByTypeName(date, ContEtfNameKey.KEJI_TONG_XIN, null, "KEJI_TONG_XIN", ContEtfTypeName.KEJI_TONG_XIN, ContMapEtfAll.KEJI_TONG_XIN);
//        findByTypeName(date, ContEtfNameKey.KEJI_NEW_ENERGY, null, "KEJI_NEW_ENERGY", ContEtfTypeName.KEJI_NEW_ENERGY, ContMapEtfAll.KEJI_NEW_ENERGY);
//        findByTypeName(date, ContEtfNameKey.KEJI_NEW_CAR, null, "KEJI_NEW_CAR", ContEtfTypeName.KEJI_NEW_CAR, ContMapEtfAll.KEJI_NEW_CAR);//科技-汽车
    }
}
