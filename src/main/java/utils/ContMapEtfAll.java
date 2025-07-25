package utils;

import ttjj.dto.CondEtfAdrCount;
import ttjj.dto.CondStockAdrCount;
import ttjj.dto.EtfAdrCountVo;
import ttjj.dto.Kline;
import ttjj.rank.EtfControl;
import ttjj.service.EtfAdrCountService;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static utils.Content.*;

/**
 * 常量-ETF全部数据，来源东方财富
 * 2025-03-05：1065
 */
public class ContMapEtfAll {
    /**
     * 资源
     */
    public static Map<String, String> TOP_ZIYUAN_OIL = new HashMap<>();//资源-石油

    static {
        TOP_ZIYUAN_OIL.put("159518", "资源-石油             ");//标普油气ETF           市值：8.02      累涨：59.76     26.60     14.85     18.31     10日：4.58      2.57      1.45      -0.44     1         累涨修正：69.81     净值区间：38      55      17      39      66      1
    }

    public static Map<String, String> ZIYUAN_OIL = new HashMap<>();//资源-石油

    static {
        ZIYUAN_OIL.put("159518", "资源-石油             ");//标普油气ETF           市值：8.02      累涨：59.76     26.60     14.85     18.31     10日：4.58      2.57      1.45      -0.44     1         累涨修正：69.81     净值区间：38      55      17      39      66      1
        ZIYUAN_OIL.put("513350", "资源-石油             ");//标普油气ETF           市值：6.63      累涨：59.44     26.29     15.01     18.14     10日：4.27      2.35      1.49      -0.32     2         累涨修正：69.04     净值区间：48      62      19      39      66      2
        ZIYUAN_OIL.put("159309", "资源-石油             ");//油气资源ETF           市值：1.13      累涨：27.47     7.05      8.68      11.74     10日：2.17      1.03                0.41      3         累涨修正：30.67     净值区间：48      52      18      43      72      3
        ZIYUAN_OIL.put("563150", "资源-石油             ");//油气资源ETF           市值：0.26      累涨：27.22     9.02      7.43      10.77     10日：1.82      0.75                0.65      4         累涨修正：29.79     净值区间：42      54      20      32      48      4
        ZIYUAN_OIL.put("561760", "资源-石油             ");//油气ETF博时           市值：0.38      累涨：23.80     7.25      7.08      9.47      10日：1.49      0.53                0.21      6         累涨修正：25.82     净值区间：47      55      29      29      40      5
        ZIYUAN_OIL.put("561570", "资源-石油             ");//油气ETF华泰柏瑞       市值：0.23      累涨：21.89     7.39      7.24      7.26      10日：1.88      1.04                0.52      5         累涨修正：24.81     净值区间：43      59      24      26      42      6
        ZIYUAN_OIL.put("159588", "资源-石油             ");//石油天然气ETF         市值：1.40      累涨：21.21     5.80      7.04      8.37      10日：1.71      0.96                0.21      8         累涨修正：23.88     净值区间：69      69      17      31      60      7
        ZIYUAN_OIL.put("561360", "资源-石油             ");//石油ETF               市值：1.83      累涨：20.63     6.95      6.30      7.38      10日：1.85      0.88                0.49      7         累涨修正：23.36     净值区间：73      80      20      27      46      8
        ZIYUAN_OIL.put("159697", "资源-石油             ");//油气ETF               市值：1.63      累涨：21.22     6.63      6.95      7.64      10日：1.30      0.70                0.30      10        累涨修正：23.22     净值区间：44      47      21      46      61      9
        ZIYUAN_OIL.put("159731", "资源-石油             ");//石化ETF               市值：0.35      累涨：15.61     5.94      6.07      3.60      10日：1.80      0.90      0.15      0.89      9         累涨修正：18.61     净值区间：73      82      74      80      87      10
    }

    public static Map<String, String> TOP_ZIYUAN_COMMON = new HashMap<>();//
    static {
        TOP_ZIYUAN_COMMON.put("159608", ContEtfTypeName.ZIYUAN_COMMON);//稀有金属ETF           市值：2.61      累涨：42.66     8.05      13.68     20.93     10日：14.29     9.05      4.65      7.49      1         累涨修正：75.3      净值区间：99      99      99      100     100     1
    }
    public static Map<String, String> ZIYUAN_COMMON = new HashMap<>();//
    static {
        ZIYUAN_COMMON.put("159608", ContEtfTypeName.ZIYUAN_COMMON);//稀有金属ETF           市值：2.61      累涨：42.66     8.05      13.68     20.93     10日：14.29     9.05      4.65      7.49      1         累涨修正：75.3      净值区间：99      99      99      100     100     1
        ZIYUAN_COMMON.put("516780", ContEtfTypeName.ZIYUAN_COMMON);//稀土ETF               市值：15.98     累涨：45.45     9.77      16.35     19.33     10日：13.45     7.45      3.38      5.61      4         累涨修正：73.11     净值区间：95      96      97      98      98      2
        ZIYUAN_COMMON.put("562800", ContEtfTypeName.ZIYUAN_COMMON);//稀有金属ETF           市值：10.98     累涨：40.76     7.99      13.07     19.70     10日：13.57     8.92      4.50      6.79      2         累涨修正：72.25     净值区间：97      97      98      98      98      3
        ZIYUAN_COMMON.put("159671", ContEtfTypeName.ZIYUAN_COMMON);//稀有金属ETF基金       市值：5.33      累涨：40.38     7.60      13.07     19.71     10日：13.70     8.72      4.44      6.87      3         累涨修正：71.68     净值区间：97      97      98      98      98      4
        ZIYUAN_COMMON.put("159715", ContEtfTypeName.ZIYUAN_COMMON);//稀土ETF易方达         市值：2.82      累涨：44.18     9.63      15.56     18.99     10日：13.33     7.33      3.11      5.72      5         累涨修正：71.06     净值区间：90      92      94      95      96      5
        ZIYUAN_COMMON.put("516150", ContEtfTypeName.ZIYUAN_COMMON);//稀土ETF嘉实           市值：35.57     累涨：43.36     8.79      15.98     18.59     10日：13.26     7.26      3.07      5.71      6         累涨修正：70.02     净值区间：94      95      96      97      97      6
        ZIYUAN_COMMON.put("159713", ContEtfTypeName.ZIYUAN_COMMON);//稀土ETF               市值：5.69      累涨：43.51     9.18      15.57     18.76     10日：13.11     7.11      3.00      5.93      7         累涨修正：69.73     净值区间：92      93      95      96      96      7
        ZIYUAN_COMMON.put("561800", ContEtfTypeName.ZIYUAN_COMMON);//稀有金属ETF基金       市值：1.02      累涨：39.43     7.48      13.06     18.89     10日：12.96     8.25      4.08      7.32      8         累涨修正：68.8      净值区间：96      96      97      98      98      8
        ZIYUAN_COMMON.put("159690", ContEtfTypeName.ZIYUAN_COMMON);//矿业ETF               市值：0.17      累涨：36.66     7.78      10.37     18.51     10日：12.54     8.31      5.26      3.38      9         累涨修正：68.03     净值区间：96      96      97      98      98      9
        ZIYUAN_COMMON.put("560860", ContEtfTypeName.ZIYUAN_COMMON);//工业有色ETF           市值：8.70      累涨：37.31     8.27      10.26     18.78     10日：12.76     7.63      4.72      3.49      10        累涨修正：67.14     净值区间：93      93      95      97      97      10
        ZIYUAN_COMMON.put("561330", ContEtfTypeName.ZIYUAN_COMMON);//矿业ETF               市值：1.08      累涨：35.95     7.48      10.45     18.02     10日：12.14     8.33      5.11      3.32      11        累涨修正：66.64     净值区间：93      94      94      96      96      11
        ZIYUAN_COMMON.put("512400", ContEtfTypeName.ZIYUAN_COMMON);//有色金属ETF           市值：61.70     累涨：35.16     7.53      9.87      17.76     10日：11.85     8.08      5.23      3.29      12        累涨修正：65.55     净值区间：93      93      94      96      96      12
        ZIYUAN_COMMON.put("516650", ContEtfTypeName.ZIYUAN_COMMON);//有色金属ETF基金       市值：1.60      累涨：34.86     7.49      9.60      17.77     10日：11.44     7.67      5.01      2.64      15        累涨修正：63.99     净值区间：94      94      95      97      97      13
        ZIYUAN_COMMON.put("159652", ContEtfTypeName.ZIYUAN_COMMON);//有色50ETF             市值：5.03      累涨：34.45     7.92      9.54      16.99     10日：11.15     8.11      5.11      2.89      13        累涨修正：63.93     净值区间：97      97      98      99      99      14
        ZIYUAN_COMMON.put("515210", ContEtfTypeName.ZIYUAN_COMMON);//钢铁ETF               市值：32.90     累涨：32.43     6.94      6.03      19.46     10日：11.84     8.60      5.53      2.70      18        累涨修正：63.93     净值区间：89      91      94      94      94      15
        ZIYUAN_COMMON.put("159876", ContEtfTypeName.ZIYUAN_COMMON);//有色龙头ETF           市值：0.75      累涨：34.50     7.98      9.64      16.88     10日：11.30     7.77      4.96      3.17      14        累涨修正：63.49     净值区间：95      95      96      97      97      16
        ZIYUAN_COMMON.put("159881", ContEtfTypeName.ZIYUAN_COMMON);//有色60ETF             市值：0.59      累涨：35.04     7.78      10.54     16.72     10日：11.20     7.60      4.59      2.97      16        累涨修正：63.02     净值区间：97      97      98      98      98      17
        ZIYUAN_COMMON.put("159871", ContEtfTypeName.ZIYUAN_COMMON);//有色金属ETF           市值：0.83      累涨：33.36     7.05      9.25      17.06     10日：11.28     7.85      5.06      3.24      17        累涨修正：62.61     净值区间：98      99      99      99      99      18
        ZIYUAN_COMMON.put("159880", ContEtfTypeName.ZIYUAN_COMMON);//有色ETF基金           市值：1.10      累涨：33.32     7.46      8.93      16.93     10日：10.72     7.60      4.77      2.55      19        累涨修正：61.18     净值区间：89      90      92      94      95      19
        ZIYUAN_COMMON.put("159944", ContEtfTypeName.ZIYUAN_COMMON);//材料ETF               市值：0.28      累涨：29.46     6.16      6.93      16.37     10日：11.11     8.57      5.76      2.06      20        累涨修正：60.66     净值区间：74      77      81      85      85      20
        ZIYUAN_COMMON.put("510170", ContEtfTypeName.ZIYUAN_COMMON);//大宗商品ETF           市值：1.91      累涨：27.67     6.37      6.46      14.84     10日：10.76     7.94      6.00      2.71      21        累涨修正：58.37     净值区间：92      93      94      95      96      21
        ZIYUAN_COMMON.put("510410", ContEtfTypeName.ZIYUAN_COMMON);//资源ETF               市值：5.25      累涨：28.84     7.12      7.34      14.38     10日：10.12     7.38      5.05      3.12      22        累涨修正：56.44     净值区间：97      97      97      98      98      22
        ZIYUAN_COMMON.put("515220", ContEtfTypeName.ZIYUAN_COMMON);//煤炭ETF               市值：73.38     累涨：26.21     6.44      6.73      13.04     10日：8.91      6.95      5.66      1.62      25        累涨修正：53.39     净值区间：83      84      85      86      87      23
        ZIYUAN_COMMON.put("159870", ContEtfTypeName.ZIYUAN_COMMON);//化工ETF               市值：25.67     累涨：25.72     6.64      6.27      12.81     10日：9.32      7.76      4.83      1.13      23        累涨修正：52.46     净值区间：78      80      82      86      86      24
        ZIYUAN_COMMON.put("516120", ContEtfTypeName.ZIYUAN_COMMON);//化工50ETF             市值：2.22      累涨：24.94     6.18      6.02      12.74     10日：9.16      8.03      5.13      1.21      24        累涨修正：52.39     净值区间：82      84      86      89      89      25
        ZIYUAN_COMMON.put("516020", ContEtfTypeName.ZIYUAN_COMMON);//化工ETF               市值：6.58      累涨：24.97     6.28      6.26      12.43     10日：8.79      7.64      5.04      1.53      26        累涨修正：51.48     净值区间：69      72      75      79      80      26
        ZIYUAN_COMMON.put("516220", ContEtfTypeName.ZIYUAN_COMMON);//化工龙头ETF           市值：1.43      累涨：24.16     6.35      5.52      12.29     10日：8.79      7.36      4.70      1.18      32        累涨修正：49.71     净值区间：92      93      94      95      95      27
        ZIYUAN_COMMON.put("516570", ContEtfTypeName.ZIYUAN_COMMON);//化工行业ETF           市值：0.66      累涨：21.95     5.23      5.31      11.41     10日：8.80      7.16      4.59      0.26      38        累涨修正：47.09     净值区间：76      79      82      85      86      28
        ZIYUAN_COMMON.put("516480", ContEtfTypeName.ZIYUAN_COMMON);//新材料ETF基金         市值：0.13      累涨：26.43     7.85      7.06      11.52     10日：6.54      5.89      4.11      2.17      27        累涨修正：47.08     净值区间：100     100     100     100     100     29
        ZIYUAN_COMMON.put("159763", ContEtfTypeName.ZIYUAN_COMMON);//新材料ETF基金         市值：0.56      累涨：27.07     6.76      7.90      12.41     10日：6.69      6.08      3.61      1.57      28        累涨修正：47.06     净值区间：97      98      98      99      99      30
        ZIYUAN_COMMON.put("159761", ContEtfTypeName.ZIYUAN_COMMON);//新材料50ETF           市值：1.63      累涨：27.68     7.32      8.21      12.15     10日：6.43      5.85      3.36      2.20      29        累涨修正：46.68     净值区间：100     100     100     100     100     31
        ZIYUAN_COMMON.put("159981", ContEtfTypeName.ZIYUAN_COMMON);//能源化工ETF           市值：5.28      累涨：30.24     10.34     12.60     7.30      10日：5.88      3.85      3.33      2.70      30        累涨修正：46.63     净值区间：79      80      81      87      89      32
        ZIYUAN_COMMON.put("561790", ContEtfTypeName.ZIYUAN_COMMON);//央企现代能源ETF       市值：0.58      累涨：19.64     5.13      3.94      10.57     10日：8.17      6.89      5.79      0.87      43        累涨修正：46.28     净值区间：68      68      73      75      78      33
        ZIYUAN_COMMON.put("159703", ContEtfTypeName.ZIYUAN_COMMON);//新材料ETF             市值：0.58      累涨：26.90     7.33      7.96      11.61     10日：6.52      5.86      3.38      1.90      31        累涨修正：46.04     净值区间：97      98      98      99      99      34
        ZIYUAN_COMMON.put("561260", ContEtfTypeName.ZIYUAN_COMMON);//能源ETF               市值：0.39      累涨：19.49     5.25      3.93      10.31     10日：7.90      6.62      5.80      0.43      44        累涨修正：45.61     净值区间：64      65      71      74      77      35
        ZIYUAN_COMMON.put("562850", ContEtfTypeName.ZIYUAN_COMMON);//央企能源ETF           市值：0.95      累涨：19.94     5.80      4.20      9.94      10日：7.62      6.44      5.62      0.09      45        累涨修正：45.24     净值区间：72      74      77      80      82      36
        ZIYUAN_COMMON.put("516360", ContEtfTypeName.ZIYUAN_COMMON);//新材料ETF             市值：0.58      累涨：26.26     6.88      8.05      11.33     10日：6.14      5.85      3.38      1.24      36        累涨修正：45.01     净值区间：88      91      93      95      95      37
        ZIYUAN_COMMON.put("516890", ContEtfTypeName.ZIYUAN_COMMON);//新材料ETF指数基金     市值：0.27      累涨：26.21     6.69      7.37      12.15     10日：6.25      5.87      3.18      2.01      33        累涨修正：44.69     净值区间：100     100     100     100     100     38
        ZIYUAN_COMMON.put("159825", ContEtfTypeName.ZIYUAN_COMMON);//农业ETF               市值：20.34     累涨：24.41     4.83      9.24      10.34     10日：6.88      5.23      4.00      0.26      39        累涨修正：44.52     净值区间：71      75      81      86      87      39
        ZIYUAN_COMMON.put("516710", ContEtfTypeName.ZIYUAN_COMMON);//新材料50ETF           市值：0.38      累涨：26.73     7.02      8.19      11.52     10日：5.94      5.54      3.13      2.12      34        累涨修正：44.47     净值区间：100     100     100     100     100     40
        ZIYUAN_COMMON.put("159827", ContEtfTypeName.ZIYUAN_COMMON);//农业50ETF             市值：0.94      累涨：23.72     4.75      8.85      10.12     10日：6.64      5.37      4.23      0.12      42        累涨修正：44.19     净值区间：73      77      82      87      88      41
        ZIYUAN_COMMON.put("516810", ContEtfTypeName.ZIYUAN_COMMON);//农业50ETF             市值：1.81      累涨：23.69     4.76      8.91      10.02     10日：6.61      5.40      4.20      0.51      41        累涨修正：44.1      净值区间：74      79      87      88      88      42
        ZIYUAN_COMMON.put("159945", ContEtfTypeName.ZIYUAN_COMMON);//能源ETF广发           市值：0.30      累涨：21.58     5.22      6.35      10.01     10日：7.34      5.54      4.69      0.71      46        累涨修正：43.84     净值区间：67      68      72      75      79      43
        ZIYUAN_COMMON.put("159930", ContEtfTypeName.ZIYUAN_COMMON);//能源ETF               市值：2.49      累涨：21.58     5.35      6.40      9.83      10日：7.09      5.23      4.30      0.88      47        累涨修正：42.5      净值区间：83      84      86      88      91      44
        ZIYUAN_COMMON.put("159865", ContEtfTypeName.ZIYUAN_COMMON);//养殖ETF               市值：41.10     累涨：23.42     5.61      8.37      9.44      10日：6.29      4.49      3.84      0.16      48        累涨修正：41.88     净值区间：63      69      77      79      81      45
        ZIYUAN_COMMON.put("562900", ContEtfTypeName.ZIYUAN_COMMON);//农业ETF易方达         市值：0.66      累涨：22.75     4.78      9.10      8.87      10日：6.09      4.91      3.86      0.25      49        累涨修正：41.47     净值区间：65      71      76      80      82      46
        ZIYUAN_COMMON.put("516670", ContEtfTypeName.ZIYUAN_COMMON);//畜牧养殖ETF           市值：7.62      累涨：22.95     5.10      8.66      9.19      10日：6.17      4.38      3.64      0.00      52        累涨修正：40.78     净值区间：59      67      75      78      80      47
        ZIYUAN_COMMON.put("159867", ContEtfTypeName.ZIYUAN_COMMON);//畜牧ETF               市值：6.49      累涨：22.40     5.36      8.40      8.64      10日：5.86      4.58      3.94      0.31      51        累涨修正：40.72     净值区间：60      67      75      78      79      48
        ZIYUAN_COMMON.put("562010", ContEtfTypeName.ZIYUAN_COMMON);//绿色能源ETF           市值：0.14      累涨：27.74     9.05      8.59      10.10     10日：4.69      3.62      2.13      1.71      35        累涨修正：40.31     净值区间：94      96      97      98      98      49
        ZIYUAN_COMMON.put("159616", ContEtfTypeName.ZIYUAN_COMMON);//农牧ETF               市值：0.52      累涨：21.92     6.01      6.13      9.78      10日：6.69      4.56      3.50      0.64      50        累涨修正：40.17     净值区间：79      84      88      90      91      50
        ZIYUAN_COMMON.put("588010", ContEtfTypeName.ZIYUAN_COMMON);//科创新材料ETF         市值：2.57      累涨：28.97     8.31      12.10     8.56      10日：3.94      3.14      1.56      1.86      37        累涨修正：39.17     净值区间：100     100     100     100     100     51
        ZIYUAN_COMMON.put("588160", ContEtfTypeName.ZIYUAN_COMMON);//科创材料ETF           市值：2.44      累涨：28.05     7.66      12.12     8.27      10日：4.35      3.41      1.38      1.37      40        累涨修正：38.57     净值区间：90      94      94      98      98      52
        ZIYUAN_COMMON.put("516760", ContEtfTypeName.ZIYUAN_COMMON);//养殖ETF               市值：1.29      累涨：21.90     5.29      7.86      8.75      10日：6.24      3.77      3.31      0.15      53        累涨修正：38.53     净值区间：70      75      81      83      85      53
        ZIYUAN_COMMON.put("159587", ContEtfTypeName.ZIYUAN_COMMON);//粮食ETF广发           市值：0.36      累涨：21.17     7.47      6.13      7.57      10日：5.22      3.67      2.63      2.35      54        累涨修正：35.32     净值区间：95      96      96      97      98      54
        ZIYUAN_COMMON.put("516550", ContEtfTypeName.ZIYUAN_COMMON);//农业ETF               市值：1.86      累涨：17.32     4.35      5.99      6.98      10日：4.88      4.13      2.64      0.72      56        累涨修正：31.61     净值区间：87      89      90      92      94      55
        ZIYUAN_COMMON.put("159698", ContEtfTypeName.ZIYUAN_COMMON);//粮食ETF               市值：2.48      累涨：19.02     7.67      4.83      6.52      10日：4.28      3.40      2.41      2.05      55        累涨修正：31.52     净值区间：98      98      98      99      99      56
        ZIYUAN_COMMON.put("159985", ContEtfTypeName.ZIYUAN_COMMON);//豆粕ETF               市值：26.32     累涨：14.59     3.25      5.49      5.85      10日：4.34      3.46      1.20      -2.04     57        累涨修正：24.79     净值区间：17      38      51      52      58      57
        ZIYUAN_COMMON.put("159980", ContEtfTypeName.ZIYUAN_COMMON);//有色ETF               市值：10.92     累涨：14.49     4.15      4.32      6.02      10日：3.31      2.48      1.77      0.70      59        累涨修正：23.82     净值区间：100     100     100     100     100     58
        ZIYUAN_COMMON.put("589180", ContEtfTypeName.ZIYUAN_COMMON);//科创新材料ETF汇添富   市值：0.22      累涨：                              8.30      10日：4.17      3.31      1.50      1.58      58        累涨修正：18.78     净值区间：97      98      98                      59
    }

    public static Map<String, String> ZIYUAN = new HashMap<>();

    static {
        ZIYUAN.putAll(ZIYUAN_OIL);
        ZIYUAN.putAll(ZIYUAN_COMMON);
//        ZIYUAN.putAll(ZIYUAN_XIYOU);
//        ZIYUAN.putAll(ZIYUAN_NONGYE);
    }

    public static Map<String, String> TOP_ZIYUAN = new HashMap<>();

    static {
        TOP_ZIYUAN.putAll(TOP_ZIYUAN_OIL);
        TOP_ZIYUAN.putAll(TOP_ZIYUAN_COMMON);
//        TOP_ZIYUAN.putAll(TOP_ZIYUAN_XIYOU);
//        TOP_ZIYUAN.putAll(TOP_ZIYUAN_NONGYE);
    }

    /**
     * 消费
     */
    public static Map<String, String> XIAOFEI_COMMON = new HashMap<>();//消费-通用
    public static Map<String, String> TOP_XIAOFEI_COMMON = new HashMap<>();//消费-通用

    static {

    }

    static {
        XIAOFEI_COMMON.put("516560", "消费-通用             ");//养老ETF               市值：1.06      累涨：25.62     7.73      9.69      8.20      10日：4.29      4.05      2.84      -1.04     3         累涨修正：39.64     净值区间：69      76      84      92      93      1
        XIAOFEI_COMMON.put("517880", "消费-通用             ");//品牌消费ETF           市值：0.35      累涨：28.58     11.04     11.84     5.70      10日：2.70      2.48      0.91      -0.11     1         累涨修正：35.58     净值区间：33      33      20      63      43      2
        XIAOFEI_COMMON.put("515920", "消费-通用             ");//智能消费ETF           市值：1.81      累涨：25.66     6.32      13.28     6.06      10日：2.53      2.53      0.96      1.67      42        累涨修正：32.64     净值区间：92      79      47      63      52      3
        XIAOFEI_COMMON.put("159996", "消费-通用             ");//家电ETF               市值：13.57     累涨：26.84     8.44      11.32     7.08      10日：1.51      1.51      0.99      0.15      1         累涨修正：31.84     净值区间：40      26      24      75      55      4
        XIAOFEI_COMMON.put("516910", "消费-通用             ");//物流ETF               市值：0.54      累涨：25.35     4.34      11.23     9.78      10日：2.87      1.82      0.19      -0.48     2         累涨修正：30.42     净值区间：14      42      54      80      80      5
        XIAOFEI_COMMON.put("516530", "消费-通用             ");//物流快递ETF           市值：0.71      累涨：24.00     4.32      10.15     9.53      10日：3.44      2.22      0.22      -0.44     4         累涨修正：30.1      净值区间：18      46      68      86      86      6
        XIAOFEI_COMMON.put("561120", "消费-通用             ");//家电ETF               市值：1.01      累涨：25.55     8.14      10.82     6.59      10日：1.26      1.26      0.76      0.17      8         累涨修正：29.59     净值区间：38      24      21      73      58      7
        XIAOFEI_COMMON.put("510630", "消费-通用             ");//消费30ETF             市值：4.37      累涨：25.55     10.95     10.36     4.24      10日：1.56      1.35      0.42      -0.41     5         累涨修正：29.3      净值区间：45      37      28      68      52      8
        XIAOFEI_COMMON.put("562580", "消费-通用             ");//可选消费ETF           市值：0.33      累涨：27.62     8.51      12.78     6.33      10日：1.08      0.59                0.00      9         累涨修正：29.29     净值区间：14      6       6       70      61      9
        XIAOFEI_COMMON.put("560880", "消费-通用             ");//家电ETF龙头           市值：4.12      累涨：25.34     7.99      10.70     6.65      10日：1.30      1.30      0.66      0.65      6         累涨修正：29.26     净值区间：50      32      29      75      60      10
        XIAOFEI_COMMON.put("159936", "消费-通用             ");//可选消费ETF           市值：3.14      累涨：24.98     8.03      10.53     6.42      10日：1.81      1.09      0.50      0.15      7         累涨修正：28.88     净值区间：26      12      12      66      61      11
        XIAOFEI_COMMON.put("516600", "消费-通用             ");//消费服务ETF           市值：0.82      累涨：20.58     7.95      6.83      5.80      10日：2.14      1.98      0.82      0.00      10        累涨修正：26.34     净值区间：91      77      75      94      74      12
        XIAOFEI_COMMON.put("159730", "消费-通用             ");//龙头家电ETF           市值：0.38      累涨：23.76     8.85      8.00      6.91      10日：0.81      0.81      0.41      0.10      18        累涨修正：26.2      净值区间：24      13      13      67      52      13
        XIAOFEI_COMMON.put("512600", "消费-通用             ");//必选消费ETF           市值：4.90      累涨：22.00     10.63     7.35      4.02      10日：1.59      1.01      0.72      -0.57     11        累涨修正：26.04     净值区间：55      54      32      65      54      14
        XIAOFEI_COMMON.put("159928", "消费-通用             ");//消费ETF               市值：134.70    累涨：22.53     10.52     8.36      3.65      10日：1.22      0.98      0.49      -0.49     14        累涨修正：25.71     净值区间：46      47      31      65      55      15
        XIAOFEI_COMMON.put("159672", "消费-通用             ");//主要消费ETF           市值：0.76      累涨：22.36     10.45     8.17      3.74      10日：1.04      1.04      0.52      -0.51     15        累涨修正：25.48     净值区间：45      43      25      63      50      16
        XIAOFEI_COMMON.put("159689", "消费-通用             ");//消费ETF南方           市值：0.76      累涨：22.15     10.68     7.60      3.87      10日：1.17      1.04      0.52      -0.64     13        累涨修正：25.4      净值区间：40      43      26      63      54      17
        XIAOFEI_COMMON.put("159328", "消费-通用             ");//家电ETF易方达         市值：1.17      累涨：22.80     8.19      8.49      6.12      10日：0.93      0.73      0.42      0.41      20        累涨修正：25.3      净值区间：9       9       9       55      52      18
        XIAOFEI_COMMON.put("560680", "消费-通用             ");//消费ETF龙头           市值：1.24      累涨：21.90     10.21     8.11      3.58      10日：1.01      1.01      0.67      -0.78     19        累涨修正：25.26     净值区间：47      39      26      58      52      19
        XIAOFEI_COMMON.put("515650", "消费-通用             ");//消费50ETF             市值：22.63     累涨：22.72     8.69      8.92      5.11      10日：1.02      0.94      0.26      -0.34     12        累涨修正：25.2      净值区间：7       5       12      72      68      20
        XIAOFEI_COMMON.put("159798", "消费-通用             ");//消费ETF易方达         市值：0.77      累涨：21.60     9.02      7.75      4.83      10日：1.05      0.84      0.21      -0.42     17        累涨修正：23.91     净值区间：0       0       3       69      60      21
        XIAOFEI_COMMON.put("510150", "消费-通用             ");//消费ETF               市值：16.34     累涨：20.52     8.58      7.43      4.51      10日：1.87      0.94      0.19      -0.37     16        累涨修正：23.71     净值区间：44      25      45      81      71      22
        XIAOFEI_COMMON.put("159520", "消费-通用             ");//消费龙头ETF           市值：1.32      累涨：20.81     7.94      8.16      4.71      10日：0.86      0.77                -0.19     22        累涨修正：22.44     净值区间：9       6       6       71      60      23
        XIAOFEI_COMMON.put("159670", "消费-通用             ");//消费ETF基金           市值：0.59      累涨：20.36     8.22      7.38      4.76      10日：0.83      0.83      0.21      -0.31     21        累涨修正：22.44     净值区间：5       3       9       71      64      24
        XIAOFEI_COMMON.put("516130", "消费-通用             ");//消费龙头ETF           市值：1.00      累涨：19.13     8.47      6.66      4.00      10日：0.65      0.65      0.13      -0.39     23        累涨修正：20.69     净值区间：13      8       8       72      51      25
    }

    public static Map<String, String> TOP_XIAOFEI_MEDIA = new HashMap<>();
    static {
        TOP_XIAOFEI_MEDIA.put("159869", ContEtfTypeName.XIAOFEI_MEDIA);//游戏ETF               市值：81.38     累涨：45.67     15.19     19.18     11.30     10日：2.52      1.89      1.42      0.47      1         累涨修正：52.92     净值区间：50      28      57      76      79      1
    }
    public static Map<String, String> XIAOFEI_MEDIA = new HashMap<>();
    static {
        XIAOFEI_MEDIA.put("159869", ContEtfTypeName.XIAOFEI_MEDIA);//游戏ETF               市值：81.38     累涨：45.67     15.19     19.18     11.30     10日：2.52      1.89      1.42      0.47      1         累涨修正：52.92     净值区间：50      28      57      76      79      1
        XIAOFEI_MEDIA.put("516770", ContEtfTypeName.XIAOFEI_MEDIA);//游戏ETF华泰柏瑞       市值：1.63      累涨：45.20     15.66     18.87     10.67     10日：2.06      1.83      1.45      0.30      3         累涨修正：51.99     净值区间：48      25      57      76      82      2
        XIAOFEI_MEDIA.put("516010", ContEtfTypeName.XIAOFEI_MEDIA);//游戏ETF               市值：24.23     累涨：45.84     15.75     18.73     11.36     10日：2.05      1.42      1.19      0.48      4         累涨修正：51.69     净值区间：47      26      57      76      79      3
        XIAOFEI_MEDIA.put("517770", ContEtfTypeName.XIAOFEI_MEDIA);//游戏传媒ETF           市值：0.34      累涨：36.42     9.33      15.40     11.69     10日：4.65      2.35      2.17      0.36      2         累涨修正：47.76     净值区间：84      92      95      97      97      4
        XIAOFEI_MEDIA.put("516190", ContEtfTypeName.XIAOFEI_MEDIA);//文娱传媒ETF           市值：0.23      累涨：34.94     12.09     14.31     8.54      10日：2.08      1.51      0.75      2.26      5         累涨修正：40.03     净值区间：100     100     100     100     100     5
        XIAOFEI_MEDIA.put("512980", ContEtfTypeName.XIAOFEI_MEDIA);//传媒ETF               市值：25.46     累涨：34.77     11.86     14.10     8.81      10日：1.96      1.61      0.69      1.16      7         累涨修正：39.72     净值区间：88      74      84      90      92      6
        XIAOFEI_MEDIA.put("516620", ContEtfTypeName.XIAOFEI_MEDIA);//影视ETF               市值：0.66      累涨：33.28     9.70      15.60     7.98      10日：3.02      1.40      0.70      1.79      6         累涨修正：39.1      净值区间：92      96      97      98      98      7
        XIAOFEI_MEDIA.put("159805", ContEtfTypeName.XIAOFEI_MEDIA);//传媒ETF               市值：1.94      累涨：34.12     10.89     14.51     8.72      10日：1.56      0.99      0.58      1.07      9         累涨修正：37.83     净值区间：74      58      78      87      89      8
        XIAOFEI_MEDIA.put("159855", ContEtfTypeName.XIAOFEI_MEDIA);//影视ETF               市值：0.71      累涨：31.71     8.93      15.34     7.44      10日：2.79      1.44      0.44      1.89      8         累涨修正：36.82     净值区间：100     100     100     95      96      9
    }

    public static Map<String, String> TOP_XIAOFEI_WINE = new HashMap<>();//消费-吃喝玩乐

    static {
//        TOP_XIAOFEI_WINE.put("562510", "消费-吃喝玩乐         ");//旅游ETF               市值：7.02      累涨：24.21     12.52     7.22      4.47      10日：3.59      0.30      0.30      0.44      2         累涨修正：28.7      净值区间：88      56      63      63      32      1
        TOP_XIAOFEI_WINE.put("512690", "消费-吃喝玩乐         ");//酒ETF                 市值：127.65    累涨：13.41     4.61      3.52      5.28      10日：1.99      0.54      0.18      0.90      3         累涨修正：16.3      净值区间：100     100     61      27      25      3
    }

    public static Map<String, String> XIAOFEI_WINE = new HashMap<>();//消费-吃喝玩乐

    static {
        XIAOFEI_WINE.put("562510", "消费-吃喝玩乐         ");//旅游ETF               市值：7.02      累涨：24.21     12.52     7.22      4.47      10日：3.59      0.30      0.30      0.44      2         累涨修正：28.7      净值区间：88      56      63      63      32      1
        XIAOFEI_WINE.put("159766", "消费-吃喝玩乐         ");//旅游ETF               市值：30.66     累涨：23.85     12.94     6.57      4.34      10日：3.61      0.30      0.30      0.45      1         累涨修正：28.36     净值区间：75      53      62      62      31      2
        XIAOFEI_WINE.put("512690", "消费-吃喝玩乐         ");//酒ETF                 市值：127.65    累涨：13.41     4.61      3.52      5.28      10日：1.99      0.54      0.18      0.90      3         累涨修正：16.3      净值区间：100     100     61      27      25      3
        XIAOFEI_WINE.put("159736", "消费-吃喝玩乐         ");//食品饮料ETF天弘       市值：47.25     累涨：13.58     5.94      4.44      3.20      10日：1.89                          0.58      6         累涨修正：15.47     净值区间：71      78      34      23      20      4
        XIAOFEI_WINE.put("515710", "消费-吃喝玩乐         ");//食品ETF               市值：9.09      累涨：12.30     5.24      3.35      3.71      10日：2.02      0.34      0.17      0.34      4         累涨修正：15        净值区间：57      56      29      16      16      5
        XIAOFEI_WINE.put("159843", "消费-吃喝玩乐         ");//食品饮料ETF           市值：2.96      累涨：12.10     4.74      3.58      3.78      10日：1.89      0.16      0.16      0.63      5         累涨修正：14.47     净值区间：83      78      34      19      19      6
        XIAOFEI_WINE.put("515170", "消费-吃喝玩乐         ");//食品饮料ETF           市值：31.99     累涨：11.85     5.07      3.55      3.23      10日：1.62      0.18      0.18      0.54      7         累涨修正：14.01     净值区间：71      63      32      18      18      7
        XIAOFEI_WINE.put("516900", "消费-吃喝玩乐         ");//食品饮料ETF基金       市值：0.81      累涨：12.02     5.42      3.37      3.23      10日：1.19                          0.68      9         累涨修正：13.21     净值区间：100     67      33      17      16      8
        XIAOFEI_WINE.put("159862", "消费-吃喝玩乐         ");//食品ETF               市值：0.42      累涨：11.10     3.86      3.75      3.49      10日：1.67      0.15                0.61      8         累涨修正：12.92     净值区间：57      45      32      17      17      9
    }

    public static Map<String, String> XIAOFEI = new HashMap<>();

    static {
        XIAOFEI.putAll(XIAOFEI_COMMON);
        XIAOFEI.putAll(XIAOFEI_MEDIA);
        XIAOFEI.putAll(XIAOFEI_WINE);
//        XIAOFEI.putAll(XIAOFEI_HK);
//        XIAOFEI.putAll(XIAOFEI_HOUSE);
//        XIAOFEI.putAll(XIAOFEI_TRAVEL);
    }

    public static Map<String, String> TOP_XIAOFEI = new HashMap<>();

    static {
        TOP_XIAOFEI.putAll(TOP_XIAOFEI_COMMON);
        TOP_XIAOFEI.putAll(TOP_XIAOFEI_MEDIA);
        TOP_XIAOFEI.putAll(TOP_XIAOFEI_WINE);
    }


    /**
     * 医疗
     */
    public static Map<String, String> TOP_YILIAO_COMMON = new HashMap<>();
    static {
        TOP_YILIAO_COMMON.put("513780", ContEtfTypeName.YILIAO_COMMON);//港股创新药50ETF       市值：12.15     累涨：63.97     16.45     25.40     22.12     10日：11.70     3.81                1.96      1         累涨修正：79.48     净值区间：73      91      94      96      97      1
    }
    public static Map<String, String> YILIAO_COMMON = new HashMap<>();
    static {
        YILIAO_COMMON.put("513780", ContEtfTypeName.YILIAO_COMMON);//港股创新药50ETF       市值：12.15     累涨：63.97     16.45     25.40     22.12     10日：11.70     3.81                1.96      1         累涨修正：79.48     净值区间：73      91      94      96      97      1
        YILIAO_COMMON.put("159570", ContEtfTypeName.YILIAO_COMMON);//港股通创新药ETF       市值：102.43    累涨：64.44     16.38     26.31     21.75     10日：11.34     3.61                1.99      4         累涨修正：79.39     净值区间：72      91      94      96      96      2
        YILIAO_COMMON.put("159217", ContEtfTypeName.YILIAO_COMMON);//港股通创新药ETF工银   市值：54.78     累涨：63.78     16.89     25.52     21.37     10日：11.41     3.41                1.63      10        累涨修正：78.6      净值区间：67      89      92      95      96      3
        YILIAO_COMMON.put("520500", ContEtfTypeName.YILIAO_COMMON);//恒生创新药ETF         市值：9.59      累涨：60.82     15.61     23.95     21.26     10日：12.20     3.97      0.70      1.29      2         累涨修正：78.39     净值区间：62      88      91      94      95      4
        YILIAO_COMMON.put("513120", ContEtfTypeName.YILIAO_COMMON);//港股创新药ETF         市值：145.13    累涨：62.90     16.56     24.78     21.56     10日：11.66     3.66                1.63      5         累涨修正：78.22     净值区间：65      89      92      95      96      5
        YILIAO_COMMON.put("159567", ContEtfTypeName.YILIAO_COMMON);//港股创新药ETF         市值：39.56     累涨：63.17     16.13     25.71     21.33     10日：11.12     3.56                1.95      8         累涨修正：77.85     净值区间：66      88      91      94      95      6
        YILIAO_COMMON.put("520700", ContEtfTypeName.YILIAO_COMMON);//港股创新药ETF基金     市值：6.06      累涨：61.99     15.46     24.87     21.66     10日：11.95     3.72                1.20      3         累涨修正：77.66     净值区间：49      84      89      92      94      7
        YILIAO_COMMON.put("159506", ContEtfTypeName.YILIAO_COMMON);//港股通医疗ETF富国     市值：28.04     累涨：60.51     15.01     24.80     20.70     10日：11.97     3.68      0.27      1.15      6         累涨修正：76.7      净值区间：64      89      92      95      96      8
        YILIAO_COMMON.put("159316", ContEtfTypeName.YILIAO_COMMON);//恒生创新药ETF         市值：7.42      累涨：61.20     15.54     24.85     20.81     10日：11.72     3.61                1.01      7         累涨修正：76.53     净值区间：52      85      90      93      94      9
        YILIAO_COMMON.put("159615", ContEtfTypeName.YILIAO_COMMON);//恒生生物科技ETF       市值：2.97      累涨：56.94     13.96     23.83     19.15     10日：11.38     3.65      0.08      1.56      11        累涨修正：72.13     净值区间：67      90      93      95      96      10
        YILIAO_COMMON.put("159776", ContEtfTypeName.YILIAO_COMMON);//港股通医药ETF         市值：1.31      累涨：55.25     13.68     22.95     18.62     10日：11.41     4.26      0.47      1.57      9         累涨修正：71.86     净值区间：75      92      94      96      97      11
        YILIAO_COMMON.put("513280", ContEtfTypeName.YILIAO_COMMON);//恒生生物科技ETF       市值：4.24      累涨：56.22     13.52     23.81     18.89     10日：11.02     3.50                1.51      15        累涨修正：70.74     净值区间：65      89      92      94      96      12
        YILIAO_COMMON.put("159892", ContEtfTypeName.YILIAO_COMMON);//恒生医药ETF           市值：44.71     累涨：55.97     14.78     23.15     18.04     10日：10.64     3.36                1.78      22        累涨修正：69.97     净值区间：72      91      94      96      96      13
        YILIAO_COMMON.put("159718", ContEtfTypeName.YILIAO_COMMON);//港股医药ETF           市值：2.46      累涨：54.58     13.86     22.96     17.76     10日：10.69     3.52      0.31      1.35      21        累涨修正：69.41     净值区间：76      93      95      96      97      14
        YILIAO_COMMON.put("513200", ContEtfTypeName.YILIAO_COMMON);//港股通医药ETF         市值：22.55     累涨：54.92     13.78     23.07     18.07     10日：10.34     3.53      0.09      1.85      18        累涨修正：68.97     净值区间：80      94      95      97      98      15
        YILIAO_COMMON.put("513700", ContEtfTypeName.YILIAO_COMMON);//香港医药ETF           市值：10.35     累涨：53.91     12.72     23.14     18.05     10日：10.65     3.59      0.15      1.47      20        累涨修正：68.45     净值区间：73      92      94      96      97      16
        YILIAO_COMMON.put("513060", ContEtfTypeName.YILIAO_COMMON);//恒生医疗ETF           市值：80.29     累涨：54.40     14.67     22.57     17.16     10日：10.23     3.47      0.16      1.71      25        累涨修正：68.42     净值区间：73      92      94      96      96      17
        YILIAO_COMMON.put("159557", ContEtfTypeName.YILIAO_COMMON);//恒生医疗ETF嘉实       市值：3.08      累涨：53.27     12.70     22.51     18.06     10日：10.82     3.68                1.60      17        累涨修正：67.77     净值区间：71      91      93      95      96      18
        YILIAO_COMMON.put("159303", ContEtfTypeName.YILIAO_COMMON);//恒生医疗ETF基金       市值：0.76      累涨：53.09     13.24     22.52     17.33     10日：10.37     3.56      0.11      1.45      24        累涨修正：67.24     净值区间：75      93      94      96      97      19
        YILIAO_COMMON.put("159366", ContEtfTypeName.YILIAO_COMMON);//港股医疗ETF           市值：0.89      累涨：45.90     10.49     19.32     16.09     10日：11.24     5.14      1.67      2.78      14        累涨修正：65.62     净值区间：60      78      81      87      89      20
        YILIAO_COMMON.put("159622", ContEtfTypeName.YILIAO_COMMON);//创新药ETF沪港深       市值：2.84      累涨：50.29     12.09     19.33     18.87     10日：10.34     4.18      0.36      1.45      12        累涨修正：65.53     净值区间：82      94      96      96      97      21
        YILIAO_COMMON.put("517110", ContEtfTypeName.YILIAO_COMMON);//创新药ETF国泰         市值：2.86      累涨：50.59     13.02     17.97     19.60     10日：9.49      4.22      0.27      1.49      13        累涨修正：64.84     净值区间：81      94      96      97      97      22
        YILIAO_COMMON.put("517120", ContEtfTypeName.YILIAO_COMMON);//创新药ETF华泰柏瑞     市值：2.98      累涨：49.25     13.08     18.81     17.36     10日：9.94      3.72      0.43      1.73      23        累涨修正：63.77     净值区间：83      94      96      97      97      23
        YILIAO_COMMON.put("517380", ContEtfTypeName.YILIAO_COMMON);//创新药ETF天弘         市值：5.91      累涨：49.40     11.51     19.79     18.10     10日：9.88      3.80      0.13      1.75      19        累涨修正：63.34     净值区间：83      94      96      97      98      24
        YILIAO_COMMON.put("159748", ContEtfTypeName.YILIAO_COMMON);//创新药ETF富国         市值：4.41      累涨：49.65     12.44     18.16     19.05     10日：9.62      3.90                1.42      16        累涨修正：63.17     净值区间：76      91      94      95      96      25
        YILIAO_COMMON.put("560900", ContEtfTypeName.YILIAO_COMMON);//创新药企ETF           市值：0.56      累涨：41.84     9.54      14.78     17.52     10日：9.48      4.42      0.21      2.55      26        累涨修正：56.16     净值区间：88      95      96      97      98      26
        YILIAO_COMMON.put("588250", ContEtfTypeName.YILIAO_COMMON);//科创生物医药ETF       市值：0.85      累涨：39.78     8.87      14.81     16.10     10日：9.62      4.91      0.41      1.49      27        累涨修正：55.13     净值区间：92      97      98      98      98      27
        YILIAO_COMMON.put("588700", ContEtfTypeName.YILIAO_COMMON);//科创医药ETF嘉实       市值：2.02      累涨：39.88     8.63      14.87     16.38     10日：9.33      4.76      0.53      1.74      28        累涨修正：55.03     净值区间：94      97      98      99      99      28
        YILIAO_COMMON.put("588860", ContEtfTypeName.YILIAO_COMMON);//科创医药ETF           市值：2.02      累涨：39.72     8.80      14.61     16.31     10日：9.53      4.86      0.27      1.64      29        累涨修正：54.65     净值区间：94      97      98      99      99      29
        YILIAO_COMMON.put("159858", ContEtfTypeName.YILIAO_COMMON);//创新药ETF南方         市值：2.12      累涨：41.24     10.51     14.76     15.97     10日：8.62      3.85      0.29      2.47      30        累涨修正：54.29     净值区间：90      95      97      97      98      30
        YILIAO_COMMON.put("515120", ContEtfTypeName.YILIAO_COMMON);//创新药ETF             市值：36.98     累涨：40.37     9.97      14.58     15.82     10日：8.92      3.90      0.31      2.76      31        累涨修正：53.81     净值区间：100     100     100     100     100     31
        YILIAO_COMMON.put("159992", ContEtfTypeName.YILIAO_COMMON);//创新药ETF             市值：99.26     累涨：40.99     10.43     14.67     15.89     10日：8.58      3.61      0.23      2.76      34        累涨修正：53.64     净值区间：100     100     100     100     100     32
        YILIAO_COMMON.put("516060", ContEtfTypeName.YILIAO_COMMON);//创新药产业ETF         市值：1.00      累涨：40.23     9.46      14.85     15.92     10日：8.81      3.72      0.33      2.16      33        累涨修正：53.42     净值区间：95      96      98      98      98      33
        YILIAO_COMMON.put("516080", ContEtfTypeName.YILIAO_COMMON);//创新药ETF易方达       市值：4.88      累涨：40.42     10.63     14.45     15.34     10日：8.41      3.59      0.15      2.50      35        累涨修正：52.72     净值区间：96      98      99      99      99      34
        YILIAO_COMMON.put("159502", ContEtfTypeName.YILIAO_COMMON);//标普生物科技ETF       市值：14.35     累涨：38.28     13.73     11.09     13.46     10日：9.07      3.26      0.87      0.65      37        累涨修正：52.35     净值区间：59      57      80      86      90      35
        YILIAO_COMMON.put("159835", ContEtfTypeName.YILIAO_COMMON);//创新药50ETF           市值：1.16      累涨：38.62     9.40      14.32     14.90     10日：8.28      3.45      0.29      2.36      39        累涨修正：50.93     净值区间：96      98      99      99      99      36
        YILIAO_COMMON.put("517990", ContEtfTypeName.YILIAO_COMMON);//医药ETF沪港深         市值：0.37      累涨：37.84     9.18      14.86     13.80     10日：8.45      4.31                1.73      32        累涨修正：50.6      净值区间：80      91      94      95      96      37
        YILIAO_COMMON.put("513290", ContEtfTypeName.YILIAO_COMMON);//纳指生物科技ETF       市值：12.55     累涨：33.33     12.63     7.90      12.80     10日：8.75      3.74      1.47      1.45      38        累涨修正：48.76     净值区间：90      92      96      96      97      38
        YILIAO_COMMON.put("562860", ContEtfTypeName.YILIAO_COMMON);//生物疫苗ETF           市值：2.75      累涨：37.27     9.57      14.57     13.13     10日：7.09      2.85      0.14      5.43      42        累涨修正：47.49     净值区间：98      99      99      99      99      39
        YILIAO_COMMON.put("561920", ContEtfTypeName.YILIAO_COMMON);//疫苗龙头ETF           市值：0.21      累涨：36.21     7.72      14.52     13.97     10日：7.33      3.13      0.40      5.47      45        累涨修正：47.47     净值区间：84      89      92      93      95      40
        YILIAO_COMMON.put("159377", ContEtfTypeName.YILIAO_COMMON);//创业板医药ETF国泰     市值：0.26      累涨：34.65     10.09     12.90     11.66     10日：6.64      2.79      0.94      3.85      50        累涨修正：45.96     净值区间：96      97      98      98      99      41
        YILIAO_COMMON.put("588130", ContEtfTypeName.YILIAO_COMMON);//科创医药ETF基金       市值：0.38      累涨：                    14.23     16.19     10日：9.47      5.03      0.50      1.26      36        累涨修正：45.92     净值区间：91      97      98      98              42
        YILIAO_COMMON.put("159837", ContEtfTypeName.YILIAO_COMMON);//生物科技ETF           市值：13.06     累涨：33.69     8.75      12.39     12.55     10日：6.85      3.57      0.59      2.92      41        累涨修正：45.29     净值区间：88      93      96      96      97      43
        YILIAO_COMMON.put("159849", ContEtfTypeName.YILIAO_COMMON);//生物科技指数ETF       市值：0.76      累涨：34.40     9.22      12.30     12.88     10日：6.81      3.06      0.19      3.38      47        累涨修正：44.65     净值区间：92      96      97      97      98      44
        YILIAO_COMMON.put("516500", ContEtfTypeName.YILIAO_COMMON);//生物科技ETF           市值：1.07      累涨：32.90     8.38      11.99     12.53     10日：6.77      3.41      0.61      3.03      49        累涨修正：44.3      净值区间：91      95      97      97      98      45
        YILIAO_COMMON.put("159859", ContEtfTypeName.YILIAO_COMMON);//生物医药ETF           市值：32.50     累涨：34.04     8.40      13.21     12.43     10日：5.94      2.79      0.50      4.76      53        累涨修正：43.77     净值区间：100     100     100     100     100     46
        YILIAO_COMMON.put("512290", ContEtfTypeName.YILIAO_COMMON);//生物医药ETF           市值：36.46     累涨：32.27     8.92      10.85     12.50     10日：7.03      3.51      0.39      2.96      43        累涨修正：43.59     净值区间：92      96      97      97      98      47
        YILIAO_COMMON.put("159839", ContEtfTypeName.YILIAO_COMMON);//生物药ETF             市值：5.86      累涨：33.37     7.73      12.62     13.02     10日：6.37      2.72      0.54      4.56      54        累涨修正：43.54     净值区间：100     100     100     100     100     48
        YILIAO_COMMON.put("159508", ContEtfTypeName.YILIAO_COMMON);//生物医药ETF基金       市值：0.39      累涨：33.92     8.32      13.18     12.42     10日：5.81      2.80      0.48      4.45      55        累涨修正：43.49     净值区间：100     100     100     100     100     49
        YILIAO_COMMON.put("516930", ContEtfTypeName.YILIAO_COMMON);//生物科技ETF基金       市值：0.36      累涨：33.04     8.23      12.41     12.40     10日：6.88      3.09      0.19      3.22      52        累涨修正：43.39     净值区间：88      94      96      96      97      50
        YILIAO_COMMON.put("159847", ContEtfTypeName.YILIAO_COMMON);//医疗ETF易方达         市值：10.97     累涨：28.32     8.62      8.96      10.74     10日：6.55      4.24      1.72      2.91      44        累涨修正：42.55     净值区间：96      97      98      98      98      51
        YILIAO_COMMON.put("560260", ContEtfTypeName.YILIAO_COMMON);//医疗ETF龙头           市值：17.16     累涨：29.09     9.05      9.07      10.97     10日：6.70      3.82      1.37      3.51      40        累涨修正：42.35     净值区间：100     100     100     100     100     52
        YILIAO_COMMON.put("512170", ContEtfTypeName.YILIAO_COMMON);//医疗ETF               市值：274.34    累涨：28.38     8.80      8.90      10.68     10日：6.73      3.75      1.71      2.82      46        累涨修正：42.28     净值区间：95      97      98      98      98      53
        YILIAO_COMMON.put("159828", ContEtfTypeName.YILIAO_COMMON);//医疗ETF               市值：23.27     累涨：27.95     8.63      8.46      10.86     10日：6.67      3.76      1.63      3.21      48        累涨修正：41.64     净值区间：96      97      98      98      99      54
        YILIAO_COMMON.put("159643", ContEtfTypeName.YILIAO_COMMON);//疫苗ETF               市值：0.53      累涨：30.80     9.00      11.27     10.53     10日：5.34      2.47      0.81      6.33      61        累涨修正：40.23     净值区间：98      98      99      99      99      55
        YILIAO_COMMON.put("159645", ContEtfTypeName.YILIAO_COMMON);//疫苗ETF富国           市值：0.22      累涨：29.80     8.29      11.03     10.48     10日：5.90      2.33      0.87      5.60      62        累涨修正：39.77     净值区间：100     100     100     100     100     56
        YILIAO_COMMON.put("510660", ContEtfTypeName.YILIAO_COMMON);//医药卫生ETF           市值：0.91      累涨：28.09     6.79      9.23      12.07     10日：7.07      3.25      0.61      1.69      56        累涨修正：39.63     净值区间：92      96      98      98      98      57
        YILIAO_COMMON.put("515960", ContEtfTypeName.YILIAO_COMMON);//医药ETF嘉实           市值：2.36      累涨：29.96     8.17      10.26     11.53     10日：6.22      2.94      0.24      1.93      60        累涨修正：39.6      净值区间：97      98      99      99      99      58
        YILIAO_COMMON.put("159657", ContEtfTypeName.YILIAO_COMMON);//生物疫苗ETF           市值：1.21      累涨：30.42     8.60      11.42     10.40     10日：5.34      2.26      0.75      5.95      63        累涨修正：39.52     净值区间：91      93      95      95      96      59
        YILIAO_COMMON.put("512120", ContEtfTypeName.YILIAO_COMMON);//医药50ETF             市值：3.70      累涨：29.65     8.39      10.18     11.08     10日：6.21      3.07      0.22      2.16      57        累涨修正：39.37     净值区间：100     100     100     100     100     60
        YILIAO_COMMON.put("515950", ContEtfTypeName.YILIAO_COMMON);//医药龙头ETF           市值：5.65      累涨：26.51     6.57      9.04      10.90     10日：6.63      3.97      0.73      1.99      51        累涨修正：38.57     净值区间：97      99      99      99      99      61
        YILIAO_COMMON.put("159898", ContEtfTypeName.YILIAO_COMMON);//医疗器械指数ETF       市值：2.02      累涨：24.53     8.29      7.55      8.69      10日：5.62      3.72      1.47      2.54      59        累涨修正：36.81     净值区间：100     100     100     100     100     62
        YILIAO_COMMON.put("159938", ContEtfTypeName.YILIAO_COMMON);//医药卫生ETF           市值：55.65     累涨：26.28     7.65      8.95      9.68      10日：5.91      2.99      0.44      2.06      64        累涨修正：36.06     净值区间：89      94      96      96      97      63
        YILIAO_COMMON.put("159883", ContEtfTypeName.YILIAO_COMMON);//医疗器械ETF           市值：24.47     累涨：23.87     7.50      7.54      8.83      10日：5.49      3.43      1.60      2.37      68        累涨修正：35.99     净值区间：97      97      98      98      99      64
        YILIAO_COMMON.put("512010", ContEtfTypeName.YILIAO_COMMON);//医药ETF               市值：208.08    累涨：25.18     7.25      8.36      9.57      10日：5.50      3.37      0.77      2.04      65        累涨修正：35.59     净值区间：82      89      93      93      95      65
        YILIAO_COMMON.put("159929", ContEtfTypeName.YILIAO_COMMON);//医药ETF               市值：20.17     累涨：25.44     7.35      8.71      9.38      10日：5.70      3.08      0.58      2.31      66        累涨修正：35.38     净值区间：93      96      97      97      98      66
        YILIAO_COMMON.put("159838", ContEtfTypeName.YILIAO_COMMON);//医药50ETF             市值：1.91      累涨：24.03     6.05      7.99      9.99      10日：6.41      3.77      0.51      1.84      58        累涨修正：35.23     净值区间：91      95      96      97      98      67
        YILIAO_COMMON.put("562600", ContEtfTypeName.YILIAO_COMMON);//医疗器械ETF           市值：0.74      累涨：23.38     6.91      7.71      8.76      10日：5.15      3.37      1.61      2.62      71        累涨修正：35.12     净值区间：96      97      98      98      98      68
        YILIAO_COMMON.put("159760", ContEtfTypeName.YILIAO_COMMON);//医疗健康ETF泰康       市值：0.85      累涨：25.51     7.20      8.96      9.35      10日：5.62      3.10      0.32      1.44      67        累涨修正：34.87     净值区间：84      93      95      96      96      69
        YILIAO_COMMON.put("516820", ContEtfTypeName.YILIAO_COMMON);//医疗创新ETF           市值：15.70     累涨：25.46     7.95      8.80      8.71      10日：5.58      3.03      0.27      2.43      69        累涨修正：34.61     净值区间：94      96      97      97      98      70
        YILIAO_COMMON.put("159873", ContEtfTypeName.YILIAO_COMMON);//医疗设备ETF           市值：0.87      累涨：22.93     7.24      7.83      7.86      10日：5.19      3.26      1.53      2.69      72        累涨修正：34.44     净值区间：94      96      96      97      97      71
        YILIAO_COMMON.put("159891", ContEtfTypeName.YILIAO_COMMON);//医疗ETF基金           市值：1.20      累涨：22.51     7.48      7.37      7.66      10日：5.07      3.43      1.58      2.47      70        累涨修正：34.17     净值区间：92      94      95      96      96      72
        YILIAO_COMMON.put("516790", ContEtfTypeName.YILIAO_COMMON);//医疗ETF华泰柏瑞       市值：1.16      累涨：22.81     6.88      8.06      7.87      10日：4.50      3.10      1.54      2.87      75        累涨修正：33.49     净值区间：97      98      98      98      99      73
        YILIAO_COMMON.put("159797", ContEtfTypeName.YILIAO_COMMON);//医疗器械ETF基金       市值：1.00      累涨：23.17     8.23      7.63      7.31      10日：4.48      3.15      1.30      2.32      73        累涨修正：33.4      净值区间：80      85      86      89      91      74
        YILIAO_COMMON.put("159877", ContEtfTypeName.YILIAO_COMMON);//医疗ETF南方           市值：0.89      累涨：23.04     8.17      7.70      7.17      10日：4.33      3.10      1.36      2.54      74        累涨修正：33.19     净值区间：91      93      94      95      96      75
        YILIAO_COMMON.put("516610", ContEtfTypeName.YILIAO_COMMON);//医疗服务ETF           市值：0.82      累涨：22.77     7.36      8.32      7.09      10日：4.76      2.87      1.22      2.83      76        累涨修正：32.84     净值区间：93      95      95      96      97      76
        YILIAO_COMMON.put("159647", ContEtfTypeName.YILIAO_COMMON);//中药ETF               市值：7.15      累涨：18.72     5.83      6.10      6.79      10日：4.63      2.19      1.19      1.28      77        累涨修正：27.92     净值区间：97      98      98      99      99      77
        YILIAO_COMMON.put("562390", ContEtfTypeName.YILIAO_COMMON);//中药50ETF             市值：0.53      累涨：18.52     5.90      6.08      6.54      10日：4.37      2.01      1.20      1.10      79        累涨修正：27.3      净值区间：97      98      98      99      99      78
        YILIAO_COMMON.put("561510", ContEtfTypeName.YILIAO_COMMON);//中药ETF华泰柏瑞       市值：0.79      累涨：18.66     6.01      6.21      6.44      10日：4.20      2.08      1.13      1.22      78        累涨修正：27.2      净值区间：100     100     100     100     100     79
        YILIAO_COMMON.put("560080", ContEtfTypeName.YILIAO_COMMON);//中药ETF               市值：18.96     累涨：18.57     5.68      6.42      6.47      10日：4.28      2.02      1.10      1.46      80        累涨修正：27.07     净值区间：97      98      98      99      99      80
        YILIAO_COMMON.put("520880", ContEtfTypeName.YILIAO_COMMON);//港股通创新药ETF       市值：3.28      累涨：                                        10日：11.51     3.78      0.17      0.70                累涨修正：          净值区间：53      85                              81
    }

    public static Map<String, String> YILIAO = new HashMap<>();//医疗

    static {
        YILIAO.putAll(YILIAO_COMMON);
    }

    public static Map<String, String> TOP_YILIAO = new HashMap<>();//医疗

    static {
        TOP_YILIAO.putAll(TOP_YILIAO_COMMON);
    }

    /**
     * 科技
     */
    public static Map<String, String> TOP_KEJI_HK = new HashMap<>();
    static {
        TOP_KEJI_HK.put("159202", ContEtfTypeName.KEJI_HK);//恒生互联网科技ETF     市值：4.19      累涨：43.98     11.62     17.51     14.85     10日：11.86     6.09      4.26      -0.51     2         累涨修正：70.45     净值区间：75      87      88      91      91      1
    }
    public static Map<String, String> KEJI_HK = new HashMap<>();
    static {
        KEJI_HK.put("159202", ContEtfTypeName.KEJI_HK);//恒生互联网科技ETF     市值：4.19      累涨：43.98     11.62     17.51     14.85     10日：11.86     6.09      4.26      -0.51     2         累涨修正：70.45     净值区间：75      87      88      91      91      1
        KEJI_HK.put("159688", ContEtfTypeName.KEJI_HK);//恒生互联网ETF         市值：8.82      累涨：42.87     12.12     17.30     13.45     10日：10.89     5.79      4.24      -0.27     1         累涨修正：68.03     净值区间：86      94      94      95      95      2
        KEJI_HK.put("513770", ContEtfTypeName.KEJI_HK);//港股互联网ETF         市值：73.26     累涨：42.76     11.97     16.43     14.36     10日：10.65     5.23      3.53      0.26      4         累涨修正：65.7      净值区间：84      94      95      96      96      3
        KEJI_HK.put("159792", ContEtfTypeName.KEJI_HK);//港股通互联网ETF       市值：580.67    累涨：43.02     12.54     16.48     14.00     10日：10.51     5.23      3.14      0.84      3         累涨修正：65.04     净值区间：100     100     100     100     100     4
        KEJI_HK.put("513040", ContEtfTypeName.KEJI_HK);//港股通互联网ETF       市值：8.35      累涨：42.35     12.39     16.26     13.70     10日：10.12     5.02      3.26      0.78      6         累涨修正：64.01     净值区间：97      99      99      99      99      5
        KEJI_HK.put("513160", ContEtfTypeName.KEJI_HK);//港股科技30ETF         市值：16.04     累涨：43.23     11.38     18.10     13.75     10日：9.60      4.56      3.28      1.15      13        累涨修正：63.95     净值区间：86      93      94      96      96      6
        KEJI_HK.put("159636", ContEtfTypeName.KEJI_HK);//港股通科技30ETF       市值：275.11    累涨：40.82     11.85     16.05     12.92     10日：10.57     5.45      3.14      0.50      5         累涨修正：63.12     净值区间：86      93      94      95      95      7
        KEJI_HK.put("159607", ContEtfTypeName.KEJI_HK);//中概互联网ETF         市值：10.68     累涨：39.06     12.53     14.38     12.15     10日：9.64      5.52      4.30      0.09      10        累涨修正：62.82     净值区间：91      95      96      96      96      8
        KEJI_HK.put("513050", ContEtfTypeName.KEJI_HK);//中概互联网ETF         市值：358.14    累涨：38.51     12.74     13.53     12.24     10日：10.25     5.34      4.27      0.34      9         累涨修正：62.64     净值区间：93      96      96      96      96      9
        KEJI_HK.put("513860", ContEtfTypeName.KEJI_HK);//港股通科技ETF         市值：24.79     累涨：40.79     11.60     16.90     12.29     10日：10.17     5.30      3.15      0.51      7         累涨修正：62.56     净值区间：85      93      94      95      95      10
        KEJI_HK.put("159568", ContEtfTypeName.KEJI_HK);//港股互联网ETF         市值：3.49      累涨：41.62     11.96     16.14     13.52     10日：9.95      4.73      3.10      0.65      11        累涨修正：62.5      净值区间：88      95      96      97      97      11
        KEJI_HK.put("513980", ContEtfTypeName.KEJI_HK);//港股科技50ETF         市值：176.08    累涨：40.61     12.31     16.01     12.29     10日：10.03     5.16      2.88      1.02      8         累涨修正：61.56     净值区间：92      96      97      97      98      12
        KEJI_HK.put("159605", ContEtfTypeName.KEJI_HK);//中概互联ETF           市值：47.90     累涨：38.25     12.40     14.12     11.73     10日：9.52      5.32      4.20      0.18      17        累涨修正：61.49     净值区间：93      96      96      96      97      13
        KEJI_HK.put("159741", ContEtfTypeName.KEJI_HK);//恒生科技ETF嘉实       市值：8.60      累涨：38.01     11.23     14.86     11.92     10日：9.90      5.33      4.08      0.26      16        累涨修正：61.4      净值区间：90      95      95      96      96      14
        KEJI_HK.put("513220", ContEtfTypeName.KEJI_HK);//中概互联ETF           市值：2.81      累涨：38.29     12.58     14.02     11.69     10日：9.38      5.21      4.25      0.38      19        累涨修正：61.38     净值区间：94      96      97      97      97      15
        KEJI_HK.put("513010", ContEtfTypeName.KEJI_HK);//恒生科技ETF易方达     市值：128.50    累涨：38.25     11.15     15.40     11.70     10日：9.62      5.37      4.04      0.13      18        累涨修正：61.32     净值区间：86      92      93      94      94      16
        KEJI_HK.put("513380", ContEtfTypeName.KEJI_HK);//恒生科技ETF龙头       市值：59.38     累涨：38.03     11.45     14.72     11.86     10日：9.51      5.33      4.13      0.14      20        累涨修正：61.13     净值区间：84      91      93      93      93      17
        KEJI_HK.put("159747", ContEtfTypeName.KEJI_HK);//香港科技ETF           市值：4.78      累涨：39.06     12.17     15.06     11.83     10日：9.62      5.05      3.44      0.27      15        累涨修正：60.61     净值区间：90      95      96      96      97      18
        KEJI_HK.put("513580", ContEtfTypeName.KEJI_HK);//恒生科技ETF指数基金   市值：25.41     累涨：38.14     11.76     15.31     11.07     10日：9.07      5.12      4.03      0.26      24        累涨修正：60.39     净值区间：88      93      94      95      95      19
        KEJI_HK.put("159742", ContEtfTypeName.KEJI_HK);//恒生科技指数ETF       市值：23.62     累涨：37.55     10.98     14.84     11.73     10日：9.62      5.18      3.97      0.13      25        累涨修正：60.29     净值区间：85      92      93      94      94      20
        KEJI_HK.put("513320", ContEtfTypeName.KEJI_HK);//恒生新经济ETF         市值：1.60      累涨：39.05     12.02     14.78     12.25     10日：10.29     4.82      3.05      0.35      14        累涨修正：60.26     净值区间：89      95      96      96      96      21
        KEJI_HK.put("513180", ContEtfTypeName.KEJI_HK);//恒生科技指数ETF       市值：319.76    累涨：37.59     10.94     15.27     11.38     10日：9.26      5.35      3.99      0.26      23        累涨修正：60.18     净值区间：88      93      94      95      95      22
        KEJI_HK.put("513150", ContEtfTypeName.KEJI_HK);//港股通科技ETF华泰柏瑞 市值：1.11      累涨：39.02     11.62     15.54     11.86     10日：9.89      5.03      2.91      0.81      12        累涨修正：59.76     净值区间：92      96      97      97      97      23
        KEJI_HK.put("513130", ContEtfTypeName.KEJI_HK);//恒生科技ETF           市值：285.06    累涨：37.86     11.04     15.53     11.29     10日：9.28      5.02      3.78      0.26      28        累涨修正：59.72     净值区间：85      92      93      94      94      24
        KEJI_HK.put("513260", ContEtfTypeName.KEJI_HK);//恒生科技ETF基金       市值：49.75     累涨：37.46     11.24     14.93     11.29     10日：9.22      5.20      3.91      0.14      27        累涨修正：59.7      净值区间：87      93      94      95      95      25
        KEJI_HK.put("159750", ContEtfTypeName.KEJI_HK);//港股科技50ETF         市值：6.45      累涨：37.80     11.28     14.80     11.72     10日：9.62      5.08      3.55      0.27      22        累涨修正：59.6      净值区间：90      95      96      96      97      26
        KEJI_HK.put("513020", ContEtfTypeName.KEJI_HK);//港股科技ETF           市值：22.44     累涨：38.86     11.37     15.45     12.04     10日：9.67      4.67      2.87      0.91      21        累涨修正：58.94     净值区间：88      95      95      96      96      27
        KEJI_HK.put("513890", ContEtfTypeName.KEJI_HK);//恒生科技HKETF         市值：5.31      累涨：37.20     10.88     15.02     11.30     10日：9.05      5.07      3.72      0.17      29        累涨修正：58.76     净值区间：87      93      94      94      95      28
        KEJI_HK.put("513560", ContEtfTypeName.KEJI_HK);//香港科技ETF           市值：6.06      累涨：38.29     11.47     15.19     11.63     10日：9.56      4.66      2.77      0.91      26        累涨修正：58.05     净值区间：88      95      95      96      96      29
        KEJI_HK.put("159740", ContEtfTypeName.KEJI_HK);//恒生科技ETF           市值：92.78     累涨：36.18     10.65     14.36     11.17     10日：9.16      4.90      3.79      0.13      32        累涨修正：57.82     净值区间：85      92      93      93      94      30
        KEJI_HK.put("159751", ContEtfTypeName.KEJI_HK);//港股科技ETF           市值：6.94      累涨：37.02     10.73     14.82     11.47     10日：9.22      4.78      2.73      0.89      30        累涨修正：56.48     净值区间：90      96      96      97      97      31
        KEJI_HK.put("513070", ContEtfTypeName.KEJI_HK);//港股消费ETF易方达     市值：6.84      累涨：34.21     11.39     12.35     10.47     10日：8.30      4.55      3.58      0.21      34        累涨修正：54.22     净值区间：92      96      96      97      97      32
        KEJI_HK.put("513230", ContEtfTypeName.KEJI_HK);//港股消费ETF           市值：3.60      累涨：34.31     11.12     13.19     10.00     10日：8.05      4.19      3.53      0.45      38        累涨修正：53.61     净值区间：92      96      96      96      96      33
        KEJI_HK.put("159856", ContEtfTypeName.KEJI_HK);//互联网龙头ETF         市值：3.06      累涨：37.61     11.03     16.43     10.15     10日：7.49      3.48      1.87      0.92      31        累涨修正：52.32     净值区间：96      98      98      99      99      34
        KEJI_HK.put("159735", ContEtfTypeName.KEJI_HK);//港股消费ETF           市值：6.53      累涨：34.15     11.81     12.78     9.56      10日：7.44      4.20      3.23      0.58      35        累涨修正：52.25     净值区间：92      96      96      97      97      35
        KEJI_HK.put("513590", ContEtfTypeName.KEJI_HK);//香港消费ETF           市值：3.59      累涨：33.93     11.38     12.68     9.87      10日：7.35      4.09      3.24      0.31      41        累涨修正：51.85     净值区间：89      94      94      95      95      36
        KEJI_HK.put("517050", ContEtfTypeName.KEJI_HK);//互联网ETF华泰柏瑞     市值：4.08      累涨：36.64     9.74      16.26     10.64     10日：7.53      3.46      2.02      1.05      33        累涨修正：51.67     净值区间：100     100     100     100     100     37
        KEJI_HK.put("517200", ContEtfTypeName.KEJI_HK);//互联网ETF             市值：1.18      累涨：35.35     10.23     15.10     10.02     10日：7.26      3.16      1.71      0.91      42        累涨修正：49.19     净值区间：100     100     100     100     100     38
        KEJI_HK.put("159793", ContEtfTypeName.KEJI_HK);//线上消费ETF基金       市值：0.33      累涨：34.24     8.65      14.63     10.96     10日：7.35      2.71      2.30      0.62      45        累涨修正：48.9      净值区间：100     100     100     100     100     39
        KEJI_HK.put("159729", ContEtfTypeName.KEJI_HK);//互联网ETF             市值：0.82      累涨：34.06     9.86      14.39     9.81      10日：7.22      3.26      2.13      0.77      47        累涨修正：48.8      净值区间：91      95      96      97      97      40
        KEJI_HK.put("517360", ContEtfTypeName.KEJI_HK);//沪港深科技ETF         市值：0.33      累涨：32.04     11.02     11.87     9.15      10日：7.31      3.68      2.19      0.81      46        累涨修正：47.41     净值区间：100     100     100     100     100     41
        KEJI_HK.put("517350", ContEtfTypeName.KEJI_HK);//科技ETF沪港深         市值：0.89      累涨：31.51     9.35      11.86     10.30     10日：7.65      4.01      2.11      1.23      44        累涨修正：47.39     净值区间：100     100     100     100     100     42
        KEJI_HK.put("159822", ContEtfTypeName.KEJI_HK);//新经济ETF             市值：7.52      累涨：27.13     12.11     6.61      8.41      10日：7.50      4.20      2.73      0.70      36        累涨修正：44.29     净值区间：97      98      98      99      50      43
        KEJI_HK.put("159728", ContEtfTypeName.KEJI_HK);//在线消费ETF           市值：0.62      累涨：34.85     11.85     14.25     8.75      10日：2.45      1.16      0.23      0.93      43        累涨修正：38.92     净值区间：62      71      83      91      92      44
        KEJI_HK.put("159699", ContEtfTypeName.KEJI_HK);//恒生消费ETF           市值：10.27     累涨：25.97     7.76      10.43     7.78      10日：4.27      3.40      2.16      0.00      50        累涨修正：37.96     净值区间：94      96      97      98      98      45
        KEJI_HK.put("159725", ContEtfTypeName.KEJI_HK);//线上消费ETF           市值：0.47      累涨：33.96     10.60     15.52     7.84      10日：1.75      1.05      0.23      0.94      48        累涨修正：37.22     净值区间：58      69      80      90      91      46
        KEJI_HK.put("513970", ContEtfTypeName.KEJI_HK);//恒生消费ETF           市值：15.83     累涨：25.24     7.54      10.40     7.30      10日：4.13      3.09      2.15      0.61      52        累涨修正：36.76     净值区间：97      98      98      99      99      47
        KEJI_HK.put("159778", ContEtfTypeName.KEJI_HK);//工业互联ETF           市值：0.57      累涨：27.65     8.52      11.10     8.03      10日：4.04      2.48      0.70      1.52      36        累涨修正：35.57     净值区间：100     100     100     100     100     48
        KEJI_HK.put("517550", ContEtfTypeName.KEJI_HK);//消费ETF沪港深         市值：0.53      累涨：23.15     8.84      7.37      6.94      10日：4.86      2.79      2.02      0.37      51        累涨修正：34.84     净值区间：96      98      98      98      78      49
        KEJI_HK.put("520520", ContEtfTypeName.KEJI_HK);//恒生消费ETF华泰柏瑞   市值：0.92      累涨：24.90     7.92      10.64     6.34      10日：3.63      2.64      1.66      0.26      53        累涨修正：34.49     净值区间：84      88      91      95      95      50
        KEJI_HK.put("159262", ContEtfTypeName.KEJI_HK);//港股通科技ETF         市值：19.54     累涨：                                        10日：9.92      4.99      3.75      1.09      39        累涨修正：22.41     净值区间：84      92                              51
        KEJI_HK.put("520980", ContEtfTypeName.KEJI_HK);//港股通科技30ETF       市值：19.90     累涨：                                        10日：10.39     4.92      3.51      0.99      37        累涨修正：22.33     净值区间：80      90                              52
        KEJI_HK.put("159269", ContEtfTypeName.KEJI_HK);//港股通科技ETF南方     市值：3.03      累涨：                                        10日：9.89      5.01      2.90      1.47      40        累涨修正：20.7      净值区间：95      98                              53
        KEJI_HK.put("159550", ContEtfTypeName.KEJI_HK);//互联网ETF沪港深       市值：1.15      累涨：                                        10日：7.51      3.59      2.03      0.95      49        累涨修正：15.16     净值区间：95      98      98                      54
        KEJI_HK.put("159265", ContEtfTypeName.KEJI_HK);//港股消费50ETF         市值：1.80      累涨：                                        10日：3.23      2.73      1.46      0.19      54        累涨修正：8.88      净值区间：70      80                              55
        KEJI_HK.put("513330", ContEtfTypeName.KEJI_HK);//恒生互联网ETF         市值：257.23    累涨：                                        10日：                              -0.19     55        累涨修正：0         净值区间：86      93      94      95      95      56
        KEJI_HK.put("159251", ContEtfTypeName.KEJI_HK);//港股科技ETF基金       市值：5.11      累涨：                                        10日：                              0.39                累涨修正：          净值区间：                                        57
    }

    public static Map<String, String> TOP_KEJI_JUNGONG = new HashMap<>();//科技-军工

    static {
        TOP_KEJI_JUNGONG.put("512670", ContEtfTypeName.KEJI_JUNGONG);//国防ETF               市值：68.45     累涨：37.53     13.58     12.82     11.13     10日：6.29      5.25      0.99      1.75      2         累涨修正：51.05     净值区间：72      85      88      93      94      1
    }

    public static Map<String, String> KEJI_JUNGONG = new HashMap<>();//科技-军工

    static {
        KEJI_JUNGONG.put("512670", ContEtfTypeName.KEJI_JUNGONG);//国防ETF               市值：68.45     累涨：37.53     13.58     12.82     11.13     10日：6.29      5.25      0.99      1.75      2         累涨修正：51.05     净值区间：72      85      88      93      94      1
        KEJI_JUNGONG.put("516320", ContEtfTypeName.KEJI_JUNGONG);//高端装备ETF           市值：0.69      累涨：28.53     8.30      8.38      11.85     10日：7.18      6.25      4.39      0.76      4         累涨修正：50.74     净值区间：75      81      87      90      90      2
        KEJI_JUNGONG.put("562910", ContEtfTypeName.KEJI_JUNGONG);//高端制造ETF           市值：0.93      累涨：28.58     8.49      7.73      12.36     10日：7.27      6.19      4.20      1.03      3         累涨修正：50.44     净值区间：77      82      88      91      91      3
        KEJI_JUNGONG.put("512710", ContEtfTypeName.KEJI_JUNGONG);//军工龙头ETF           市值：133.40    累涨：38.16     13.68     13.28     11.20     10日：5.92      5.17      0.57      1.74      1         累涨修正：50.39     净值区间：58      78      81      90      92      4
        KEJI_JUNGONG.put("159638", ContEtfTypeName.KEJI_JUNGONG);//高端装备ETF           市值：12.35     累涨：37.23     14.14     12.09     11.00     10日：5.46      4.62      0.46      2.09      8         累涨修正：48.23     净值区间：82      90      91      95      96      5
        KEJI_JUNGONG.put("512680", ContEtfTypeName.KEJI_JUNGONG);//军工ETF龙头           市值：58.47     累涨：35.40     12.76     11.73     10.91     10日：5.97      4.48      1.01      1.61      9         累涨修正：47.87     净值区间：77      87      90      94      96      6
        KEJI_JUNGONG.put("159378", ContEtfTypeName.KEJI_JUNGONG);//通用航空ETF           市值：8.97      累涨：36.80     14.29     12.92     9.59      10日：4.75      4.31      0.93      1.27      11        累涨修正：47.72     净值区间：70      85      86      92      95      7
        KEJI_JUNGONG.put("512660", ContEtfTypeName.KEJI_JUNGONG);//军工ETF               市值：171.95    累涨：35.07     12.65     11.75     10.67     10日：5.77      4.42      1.13      1.39      10        累涨修正：47.52     净值区间：74      86      89      94      95      8
        KEJI_JUNGONG.put("512560", ContEtfTypeName.KEJI_JUNGONG);//军工ETF易方达         市值：6.54      累涨：34.85     12.25     11.59     11.01     10日：5.64      4.47      0.99      1.56      12        累涨修正：46.94     净值区间：75      86      89      94      95      9
        KEJI_JUNGONG.put("512810", ContEtfTypeName.KEJI_JUNGONG);//国防军工ETF           市值：7.93      累涨：32.92     12.59     9.63      10.70     10日：5.52      4.28      0.90      1.35      13        累涨修正：44.52     净值区间：76      87      90      12      11      10
        KEJI_JUNGONG.put("159206", ContEtfTypeName.KEJI_JUNGONG);//卫星ETF               市值：1.20      累涨：35.70     13.86     13.44     8.40      10日：2.11      1.71                0.90      14        累涨修正：39.52     净值区间：83      90      52      78      86      11
        KEJI_JUNGONG.put("159208", ContEtfTypeName.KEJI_JUNGONG);//航天航空ETF           市值：0.57      累涨：                    13.71     11.09     10日：5.54      4.73      0.60      1.39      7         累涨修正：36.27     净值区间：60      77      81      90              12
        KEJI_JUNGONG.put("159227", ContEtfTypeName.KEJI_JUNGONG);//航空航天ETF           市值：6.31      累涨：                    12.96     11.56     10日：5.67      5.03      0.52      1.69      5         累涨修正：36.26     净值区间：54      75      79      89              13
        KEJI_JUNGONG.put("159231", ContEtfTypeName.KEJI_JUNGONG);//通用航空ETF华宝       市值：0.28      累涨：                    12.97     9.87      10日：4.63      4.09      1.14      1.13      15        累涨修正：33.84     净值区间：69      85      86      91              14
        KEJI_JUNGONG.put("159392", ContEtfTypeName.KEJI_JUNGONG);//航空ETF               市值：0.42      累涨：                    11.69     10.26     10日：4.86      4.28      1.12      1.21      16        累涨修正：33.33     净值区间：74      86      87      93              15
        KEJI_JUNGONG.put("159218", ContEtfTypeName.KEJI_JUNGONG);//卫星产业ETF           市值：0.31      累涨：                    10.95     9.50      10日：2.83      2.17      0.09      1.49      18        累涨修正：25.63     净值区间：96      98      65      81              16
        KEJI_JUNGONG.put("159241", ContEtfTypeName.KEJI_JUNGONG);//航空航天ETF天弘       市值：3.63      累涨：                              11.75     10日：6.36      5.45      0.69      1.76      6         累涨修正：24.94     净值区间：59      78      82      90              17
        KEJI_JUNGONG.put("159230", ContEtfTypeName.KEJI_JUNGONG);//通用航空ETF基金       市值：0.18      累涨：                              9.53      10日：4.65      4.18      0.82      1.37      17        累涨修正：20        净值区间：74      85      85                      18
    }

    public static Map<String, String> TOP_KEJI_GONG_YE = new HashMap<>();//科技-通用

    static {
//        TOP_KEJI_GONG_YE.put("159777", "科技-通用             ");//创科技ETF             市值：0.87      累涨：33.62     12.94     7.75      12.93     10日：7.68      3.33      3.33      0.99      1         累涨修正：51.29     净值区间：84      84      91      92      94      1
    }

    public static Map<String, String> KEJI_GONG_YE = new HashMap<>();//科技-通用

    static {
        KEJI_GONG_YE.put("159777", "科技-通用             ");//创科技ETF             市值：0.87      累涨：33.62     12.94     7.75      12.93     10日：7.68      3.33      3.33      0.99      1         累涨修正：51.29     净值区间：84      84      91      92      94      1
        KEJI_GONG_YE.put("515860", "科技-通用             ");//科技ETF嘉实           市值：1.87      累涨：33.52     10.91     8.79      13.82     10日：8.87      3.00      2.92      -0.16     3         累涨修正：51.23     净值区间：68      78      89      93      94      2
        KEJI_GONG_YE.put("159773", "科技-通用             ");//创业板科技ETF         市值：1.97      累涨：33.36     11.54     7.75      14.07     10日：7.44      3.41      3.41      1.08      2         累涨修正：51.03     净值区间：84      84      91      93      95      3
        KEJI_GONG_YE.put("159542", "科技-通用             ");//工程机械ETF           市值：0.08      累涨：27.72     10.36     7.34      10.02     10日：6.19      3.56      3.39      -0.09     5         累涨修正：44.25     净值区间：95      95      98      98      39      4
        KEJI_GONG_YE.put("159667", "科技-通用             ");//工业母机ETF           市值：3.96      累涨：34.43     17.50     7.48      9.45      10日：3.84      1.98      1.98      1.16      15        累涨修正：44.21     净值区间：85      81      86      73      82      5
        KEJI_GONG_YE.put("516330", "科技-通用             ");//物联网ETF             市值：0.13      累涨：30.79     12.41     7.05      11.33     10日：6.11      2.15      2.15      0.61      7         累涨修正：43.35     净值区间：81      66      80      83      87      6
        KEJI_GONG_YE.put("515580", "科技-通用             ");//科技100ETF            市值：4.20      累涨：27.72     9.30      6.76      11.66     10日：6.92      2.80      2.80      0.68      10        累涨修正：43.04     净值区间：84      86      93      94      96      7
        KEJI_GONG_YE.put("515750", "科技-通用             ");//科技50ETF             市值：6.53      累涨：30.60     10.96     7.12      12.52     10日：5.38      2.25      2.25      1.00      9         累涨修正：42.73     净值区间：88      90      95      96      97      8
        KEJI_GONG_YE.put("512770", "科技-通用             ");//战略新兴ETF           市值：2.15      累涨：29.40     10.54     6.80      12.06     10日：6.02      2.53      2.39      1.20      11        累涨修正：42.73     净值区间：77      80      91      93      94      9
        KEJI_GONG_YE.put("159663", "科技-通用             ");//机床ETF               市值：0.88      累涨：33.60     17.61     6.81      9.18      10日：3.62      1.82      1.82      1.35      26        累涨修正：42.68     净值区间：85      84      85      68      77      10
        KEJI_GONG_YE.put("159896", "科技-通用             ");//物联网ETF南方         市值：1.06      累涨：30.81     12.39     7.56      10.86     10日：5.68      2.03      2.03      0.63      8         累涨修正：42.58     净值区间：83      69      80      83      87      11
        KEJI_GONG_YE.put("516050", "科技-通用             ");//科技龙头ETF           市值：4.26      累涨：29.22     9.24      8.29      11.69     10日：6.11      2.41      2.41      1.11      4         累涨修正：42.56     净值区间：86      87      93      95      96      12
        KEJI_GONG_YE.put("515000", "科技-通用             ");//科技ETF               市值：31.24     累涨：28.06     9.49      7.05      11.52     10日：6.12      2.90      2.60      1.09      6         累涨修正：42.28     净值区间：85      86      93      95      96      13
        KEJI_GONG_YE.put("562380", "科技-通用             ");//央企科技引领ETF       市值：1.87      累涨：30.58     11.86     7.16      11.56     10日：5.45      1.55      1.55      0.77      13        累涨修正：40.68     净值区间：71      64      87      90      91      14
        KEJI_GONG_YE.put("563050", "科技-通用             ");//央企科技50ETF         市值：2.31      累涨：29.66     11.58     6.63      11.45     10日：5.74      1.43      1.43      0.98      21        累涨修正：39.69     净值区间：71      86      86      89      91      15
        KEJI_GONG_YE.put("560170", "科技-通用             ");//央企科技ETF           市值：14.15     累涨：29.94     11.82     6.71      11.41     10日：5.54      1.38      1.38      0.80      22        累涨修正：39.62     净值区间：74      64      87      89      91      16
        KEJI_GONG_YE.put("159709", "科技-通用             ");//物联网ETF工银         市值：0.76      累涨：29.67     11.79     7.47      10.41     10日：4.90      1.64      1.64      0.86      16        累涨修正：39.49     净值区间：87      87      95      96      97      17
        KEJI_GONG_YE.put("516260", "科技-通用             ");//物联网50ETF           市值：0.99      累涨：28.82     11.59     7.08      10.15     10日：5.31      1.78      1.78      0.59      17        累涨修正：39.47     净值区间：81      68      84      86      89      18
        KEJI_GONG_YE.put("159723", "科技-通用             ");//科技龙头ETF           市值：0.70      累涨：28.60     12.39     8.04      8.17      10日：3.90      2.31      2.31      1.25      14        累涨修正：39.43     净值区间：87      87      91      92      92      19
        KEJI_GONG_YE.put("159886", "科技-通用             ");//机械ETF               市值：0.53      累涨：24.05     8.64      5.04      10.37     10日：6.25      3.03      3.03      0.52      12        累涨修正：39.39     净值区间：84      89      93      93      94      20
        KEJI_GONG_YE.put("159701", "科技-通用             ");//物联网ETF招商         市值：0.18      累涨：29.33     12.51     6.76      10.06     10日：5.04      1.64      1.64      0.50      20        累涨修正：39.29     净值区间：81      59      80      83      83      21
        KEJI_GONG_YE.put("159895", "科技-通用             ");//物联网ETF易方达       市值：0.67      累涨：29.19     12.26     7.42      9.51      10日：4.47      1.65      1.65      0.93      19        累涨修正：38.61     净值区间：80      70      87      87      89      22
        KEJI_GONG_YE.put("560280", "科技-通用             ");//工程机械ETF           市值：1.45      累涨：23.73     9.56      5.13      9.04      10日：4.82      2.94      2.78      0.23      24        累涨修正：37.05     净值区间：77      80      89      89      67      23
        KEJI_GONG_YE.put("563210", "科技-通用             ");//专精特新ETF           市值：0.34      累涨：25.28     6.95      6.77      11.56     10日：5.23      2.14      2.14      0.86      18        累涨修正：36.93     净值区间：69      69      87      88      88      24
        KEJI_GONG_YE.put("516960", "科技-通用             ");//机械ETF               市值：0.14      累涨：23.57     8.92      4.64      10.01     10日：5.47      2.57      2.57      0.40      23        累涨修正：36.75     净值区间：83      89      92      92      94      25
        KEJI_GONG_YE.put("517660", "科技-通用             ");//物联网ETF沪港深       市值：0.47      累涨：27.89     12.61     6.98      8.30      10日：3.33      1.57      1.57      0.93      29        累涨修正：35.93     净值区间：81      64      68      52      74      26
        KEJI_GONG_YE.put("515200", "科技-通用             ");//创新100ETF            市值：1.60      累涨：25.14     10.60     5.89      8.65      10日：4.60      2.83      1.64      0.81      25        累涨修正：35.85     净值区间：85      85      83      69      72      27
        KEJI_GONG_YE.put("159778", "科技-通用             ");//工业互联ETF           市值：0.54      累涨：26.49     10.56     5.89      10.04     10日：3.99      1.70      1.70      0.96      28        累涨修正：35.58     净值区间：73      85      88      88      76      28
        KEJI_GONG_YE.put("560990", "科技-通用             ");//中金科技先锋ETF       市值：0.29      累涨：22.13     7.31      5.92      8.90      10日：5.06      2.64      2.40      1.18      27        累涨修正：34.63     净值区间：88      90      94      62      65      29
        KEJI_GONG_YE.put("516800", "科技-通用             ");//智能制造ETF           市值：1.65      累涨：24.75     9.30      5.81      9.64      10日：4.31      1.80      1.80      1.16      30        累涨修正：34.46     净值区间：80      84      92      92      58      30
        KEJI_GONG_YE.put("510770", "科技-通用             ");//G60创新ETF            市值：0.17      累涨：26.82     8.71      9.52      8.59      10日：2.74      1.54      1.54      1.19      38        累涨修正：34.18     净值区间：86      88      95      96      97      31
        KEJI_GONG_YE.put("159807", "科技-通用             ");//科技ETF               市值：9.33      累涨：21.23     7.60      4.92      8.71      10日：4.62      2.01      2.01      0.59      31        累涨修正：31.88     净值区间：88      88      93      94      95      32
        KEJI_GONG_YE.put("516720", "科技-通用             ");//ESGETF                市值：0.24      累涨：22.93     8.59      7.01      7.33      10日：3.63      1.97      1.42      0.43      32        累涨修正：31.37     净值区间：60      71      87      88      92      33
        KEJI_GONG_YE.put("560650", "科技-通用             ");//核心50ETF             市值：0.11      累涨：18.61     6.34      3.37      8.90      10日：4.40      2.61      2.61      0.93      35        累涨修正：30.84     净值区间：67      67      84      84      84      34
        KEJI_GONG_YE.put("159791", "科技-通用             ");//300ESGETF             市值：0.32      累涨：17.35     6.46      3.02      7.87      10日：4.53      3.15      2.73      0.31      34        累涨修正：30.49     净值区间：74      83      90      90      91      35
        KEJI_GONG_YE.put("159621", "科技-通用             ");//MSCIESGETF            市值：0.30      累涨：21.31     7.81      6.05      7.45      10日：3.47      2.17      1.77      0.39      37        累涨修正：30.49     净值区间：61      73      83      84      89      36
        KEJI_GONG_YE.put("561500", "科技-通用             ");//漂亮50ETF             市值：0.57      累涨：18.46     5.74      3.67      9.05      10日：4.40      2.42      2.42      0.59      36        累涨修正：30.12     净值区间：79      79      88      88      88      37
        KEJI_GONG_YE.put("159653", "科技-通用             ");//ESG300ETF             市值：0.57      累涨：20.08     8.31      4.85      6.92      10日：3.31      2.31      1.81      0.69      39        累涨修正：29.32     净值区间：66      77      85      85      76      38
        KEJI_GONG_YE.put("588850", "科技-通用             ");//科创机械ETF           市值：0.11      累涨：                    5.82      11.28     10日：5.16      1.62      1.62      0.76      33        累涨修正：27.12     净值区间：61      61      77      77              39
        KEJI_GONG_YE.put("561130", "科技-通用             ");//国货ETF               市值：1.63      累涨：16.28     6.35      3.09      6.84      10日：3.71      1.91      1.91      1.13      42        累涨修正：25.72     净值区间：82      82      89      89      90      40
        KEJI_GONG_YE.put("515090", "科技-通用             ");//可持续发展ETF         市值：0.07      累涨：16.09     6.98      3.19      5.92      10日：3.22      2.22      1.81      0.08      41        累涨修正：25.15     净值区间：70      54      68      49      64      41
        KEJI_GONG_YE.put("510160", "科技-通用             ");//产业升级ETF           市值：2.34      累涨：17.14     6.95      3.60      6.59      10日：3.72      1.95      0.91      0.34      40        累涨修正：24.63     净值区间：50      71      79      80      85      42
        KEJI_GONG_YE.put("159717", "科技-通用             ");//ESGETF                市值：0.46      累涨：16.79     6.81      3.13      6.85      10日：3.15      1.79      1.34      0.67      44        累涨修正：24.41     净值区间：86      90      93      93      67      43
        KEJI_GONG_YE.put("516830", "科技-通用             ");//300ESGETF             市值：2.17      累涨：15.55     5.63      3.34      6.58      10日：3.25      2.08      1.50      0.34      43        累涨修正：23.88     净值区间：61      69      82      82      86      44
        KEJI_GONG_YE.put("560180", "科技-通用             ");//沪深300ESGETF南方     市值：0.24      累涨：14.93     5.68      2.91      6.34      10日：3.44      1.95      1.56      0.39      45        累涨修正：23.44     净值区间：59      71      90      90      90      45
        KEJI_GONG_YE.put("510990", "科技-通用             ");//180ESGETF             市值：0.49      累涨：15.67     6.52      2.75      6.40      10日：3.00      1.60      1.17      0.53      47        累涨修正：22.61     净值区间：54      73      83      85      88      46
        KEJI_GONG_YE.put("561900", "科技-通用             ");//沪深300ESGETF         市值：0.41      累涨：14.35     5.86      2.77      5.72      10日：2.83      1.52      1.40      0.35      49        累涨修正：21.5      净值区间：78      85      88      88      91      47
        KEJI_GONG_YE.put("560810", "科技-通用             ");//央企ESGETF            市值：4.99      累涨：14.13     4.69      3.90      5.54      10日：3.43      1.64      1.12      0.00      46        累涨修正：21.44     净值区间：80      87      93      93      94      48
        KEJI_GONG_YE.put("510090", "科技-通用             ");//ESGETF基金            市值：0.82      累涨：15.91     6.48      3.55      5.88      10日：2.48      1.51      0.66      0.57      48        累涨修正：21.22     净值区间：40      73      33      38      49      49
    }

    public static Map<String, String> TOP_KEJI_RUAN_JIAN = new HashMap<>();//科技-软件

    static {
        TOP_KEJI_RUAN_JIAN.put("159388", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF国泰 市值：0.57      累涨：53.28     15.61     21.18     16.49     10日：7.48      3.33      0.33      -0.50     1         累涨修正：64.75     净值区间：28      70      77      85      86      1
        TOP_KEJI_RUAN_JIAN.put("516100", ContEtfTypeName.KEJI_RUAN_JIAN);//金融科技ETF华夏       市值：10.30     累涨：47.48     12.58     23.88     11.02     10日：4.60      1.60      0.37      0.87      24        累涨修正：54.42     净值区间：71      40      67      86      87      9
    }

    public static Map<String, String> KEJI_RUAN_JIAN = new HashMap<>();//科技-软件

    static {
        KEJI_RUAN_JIAN.put("159388", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF国泰 市值：0.57      累涨：53.28     15.61     21.18     16.49     10日：7.48      3.33      0.33      -0.50     1         累涨修正：64.75     净值区间：28      70      77      85      86      1
        KEJI_RUAN_JIAN.put("159381", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF华夏 市值：1.48      累涨：52.78     15.80     20.28     16.70     10日：7.35      3.18      0.09      -0.18     2         累涨修正：63.49     净值区间：30      70      77      85      86      2
        KEJI_RUAN_JIAN.put("159363", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF华宝 市值：16.61     累涨：53.30     16.15     21.37     15.78     10日：6.90      3.17                -0.34     5         累涨修正：63.37     净值区间：2       2       2       2       2       3
        KEJI_RUAN_JIAN.put("159738", ContEtfTypeName.KEJI_RUAN_JIAN);//云计算ETF华泰柏瑞     市值：6.05      累涨：44.11     13.20     16.49     14.42     10日：8.31      3.88      1.19      0.15      3         累涨修正：58.68     净值区间：50      81      84      88      89      4
        KEJI_RUAN_JIAN.put("516510", ContEtfTypeName.KEJI_RUAN_JIAN);//云计算ETF             市值：30.11     累涨：43.52     13.09     16.62     13.81     10日：7.44      3.34      0.63      -0.08     4         累涨修正：55.56     净值区间：41      77      79      85      86      5
        KEJI_RUAN_JIAN.put("159559", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人50ETF           市值：7.75      累涨：37.06     12.61     10.94     13.51     10日：9.96      3.75      2.32      0.66      9         累涨修正：55.41     净值区间：43      78      79      84      84      6
        KEJI_RUAN_JIAN.put("560660", ContEtfTypeName.KEJI_RUAN_JIAN);//云50ETF               市值：0.72      累涨：45.18     12.75     16.40     16.03     10日：7.07      2.91      0.08      0.30      7         累涨修正：55.32     净值区间：38      74      78      85      86      7
        KEJI_RUAN_JIAN.put("517390", ContEtfTypeName.KEJI_RUAN_JIAN);//云计算ETF沪港深       市值：2.96      累涨：41.97     12.12     16.12     13.73     10日：7.99      3.47      0.94      0.23      6         累涨修正：55.31     净值区间：60      86      88      92      92      8
        KEJI_RUAN_JIAN.put("516860", ContEtfTypeName.KEJI_RUAN_JIAN);//金融科技ETF           市值：14.02     累涨：47.27     12.34     23.66     11.27     10日：4.46      1.46      0.35      1.11      28        累涨修正：53.89     净值区间：72      39      64      85      86      10
        KEJI_RUAN_JIAN.put("159851", ContEtfTypeName.KEJI_RUAN_JIAN);//金融科技ETF           市值：86.29     累涨：47.91     13.07     23.86     10.98     10日：4.19      1.19      0.24      1.07      30        累涨修正：53.77     净值区间：71      2       2       2       2       11
        KEJI_RUAN_JIAN.put("159530", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人ETF易方达       市值：25.10     累涨：36.31     12.03     11.11     13.17     10日：9.82      3.45      2.09      0.59      14        累涨修正：53.76     净值区间：43      79      80      85      85      12
        KEJI_RUAN_JIAN.put("159739", ContEtfTypeName.KEJI_RUAN_JIAN);//大数据ETF             市值：4.51      累涨：42.15     12.22     16.07     13.86     10日：7.48      3.15      0.41      0.16      8         累涨修正：53.6      净值区间：40      77      80      86      86      13
        KEJI_RUAN_JIAN.put("159890", ContEtfTypeName.KEJI_RUAN_JIAN);//云计算ETF             市值：4.57      累涨：41.70     12.33     15.88     13.49     10日：7.30      3.05      0.31      0.15      10        累涨修正：52.67     净值区间：39      77      79      86      86      14
        KEJI_RUAN_JIAN.put("516630", ContEtfTypeName.KEJI_RUAN_JIAN);//云计算50ETF           市值：5.49      累涨：42.17     12.69     16.18     13.30     10日：7.01      2.70      0.16      0.41      11        累涨修正：52.2      净值区间：41      78      80      86      87      15
        KEJI_RUAN_JIAN.put("159527", ContEtfTypeName.KEJI_RUAN_JIAN);//云计算50ETF           市值：1.49      累涨：41.58     12.16     16.19     13.23     10日：7.08      2.94      0.25      0.50      12        累涨修正：52.1      净值区间：41      78      80      86      86      16
        KEJI_RUAN_JIAN.put("561010", ContEtfTypeName.KEJI_RUAN_JIAN);//软件ETF基金           市值：1.27      累涨：41.43     11.97     19.14     10.32     10日：5.84      2.44      0.45      0.71      20        累涨修正：50.61     净值区间：61      82      86      92      93      17
        KEJI_RUAN_JIAN.put("159590", ContEtfTypeName.KEJI_RUAN_JIAN);//软件50ETF             市值：2.12      累涨：39.64     10.47     18.26     10.91     10日：6.94      2.74      0.55      0.90      17        累涨修正：50.42     净值区间：72      87      89      94      94      18
        KEJI_RUAN_JIAN.put("159586", ContEtfTypeName.KEJI_RUAN_JIAN);//计算机ETF南方         市值：4.91      累涨：41.26     12.32     18.85     10.09     10日：5.81      2.40      0.46      0.54      22        累涨修正：50.39     净值区间：56      78      83      90      90      19
        KEJI_RUAN_JIAN.put("159899", ContEtfTypeName.KEJI_RUAN_JIAN);//软件龙头ETF           市值：3.28      累涨：40.18     10.75     18.42     11.01     10日：6.88      2.45      0.35      0.81      19        累涨修正：50.21     净值区间：75      88      91      95      95      20
        KEJI_RUAN_JIAN.put("515980", ContEtfTypeName.KEJI_RUAN_JIAN);//人工智能ETF           市值：32.01     累涨：39.98     11.82     14.39     13.77     10日：7.19      2.56      0.18      0.09      16        累涨修正：50.09     净值区间：33      77      79      86      87      21
        KEJI_RUAN_JIAN.put("515230", ContEtfTypeName.KEJI_RUAN_JIAN);//软件ETF               市值：18.50     累涨：40.02     11.57     18.10     10.35     10日：6.49      2.44      0.46      1.04      21        累涨修正：49.87     净值区间：72      87      90      94      94      22
        KEJI_RUAN_JIAN.put("159382", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF南方 市值：0.62      累涨：                    21.41     16.63     10日：7.33      3.48      0.48      -0.55     13        累涨修正：49.81     净值区间：32      70      76      85              23
        KEJI_RUAN_JIAN.put("159852", ContEtfTypeName.KEJI_RUAN_JIAN);//软件ETF               市值：49.15     累涨：38.90     11.81     16.73     10.36     10日：7.33      2.69      0.24      1.09      15        累涨修正：49.4      净值区间：74      90      90      95      93      24
        KEJI_RUAN_JIAN.put("560360", ContEtfTypeName.KEJI_RUAN_JIAN);//软件指数ETF           市值：1.48      累涨：37.76     11.51     16.13     10.12     10日：6.98      2.87      0.42      0.90      18        累涨修正：48.45     净值区间：23      43      47      59      59      25
        KEJI_RUAN_JIAN.put("562930", ContEtfTypeName.KEJI_RUAN_JIAN);//软件ETF易方达         市值：1.75      累涨：37.27     10.91     16.79     9.57      10日：6.71      2.64      0.12      1.31      27        累涨修正：46.86     净值区间：77      92      92      95      95      26
        KEJI_RUAN_JIAN.put("159819", ContEtfTypeName.KEJI_RUAN_JIAN);//人工智能ETF           市值：163.00    累涨：37.07     11.11     13.49     12.47     10日：6.74      2.39      0.10      0.39      25        累涨修正：46.4      净值区间：35      78      80      85      87      27
        KEJI_RUAN_JIAN.put("517800", ContEtfTypeName.KEJI_RUAN_JIAN);//人工智能50ETF         市值：2.85      累涨：30.99     8.72      11.79     10.48     10日：7.64      3.74      1.92      0.38      23        累涨修正：46.21     净值区间：84      95      96      96      96      28
        KEJI_RUAN_JIAN.put("515400", ContEtfTypeName.KEJI_RUAN_JIAN);//大数据ETF             市值：22.18     累涨：37.05     11.80     15.02     10.23     10日：6.33      1.92      0.23      0.68      35        累涨修正：45.76     净值区间：44      77      79      87      83      29
        KEJI_RUAN_JIAN.put("159786", ContEtfTypeName.KEJI_RUAN_JIAN);//VRETF                 市值：1.25      累涨：36.05     11.58     13.13     11.34     10日：4.51      3.29      0.86      0.32      26        累涨修正：45.57     净值区间：47      79      86      91      92      30
        KEJI_RUAN_JIAN.put("512330", ContEtfTypeName.KEJI_RUAN_JIAN);//信息科技ETF           市值：5.77      累涨：36.88     10.95     15.99     9.94      10日：4.44      2.63      0.65      0.56      36        累涨修正：45.25     净值区间：81      91      92      96      96      31
        KEJI_RUAN_JIAN.put("515070", ContEtfTypeName.KEJI_RUAN_JIAN);//人工智能AIETF         市值：52.26     累涨：35.39     10.46     12.70     12.23     10日：6.91      2.36                0.31      32        累涨修正：44.66     净值区间：35      78      80      85      86      32
        KEJI_RUAN_JIAN.put("159526", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人ETF嘉实         市值：5.80      累涨：32.09     11.92     10.08     10.09     10日：7.05      2.66      1.40      0.94      29        累涨修正：44.6      净值区间：58      87      88      91      79      33
        KEJI_RUAN_JIAN.put("562030", ContEtfTypeName.KEJI_RUAN_JIAN);//信创ETF基金           市值：1.16      累涨：36.53     11.85     15.51     9.17      10日：5.63      2.01      0.10      0.71      40        累涨修正：44.37     净值区间：45      71      76      85      85      34
        KEJI_RUAN_JIAN.put("512930", ContEtfTypeName.KEJI_RUAN_JIAN);//AI人工智能ETF         市值：17.80     累涨：35.66     10.47     13.09     12.10     10日：6.60      2.09                0.48      34        累涨修正：44.35     净值区间：40      79      82      87      88      35
        KEJI_RUAN_JIAN.put("516700", ContEtfTypeName.KEJI_RUAN_JIAN);//大数据产业ETF         市值：1.18      累涨：36.97     12.40     14.73     9.84      10日：5.81      1.50                0.75      37        累涨修正：44.28     净值区间：29      62      64      77      77      36
        KEJI_RUAN_JIAN.put("159770", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人ETF             市值：62.80     累涨：32.65     12.04     10.33     10.28     10日：6.79      2.55      1.10      0.88      31        累涨修正：44.19     净值区间：60      87      87      91      82      37
        KEJI_RUAN_JIAN.put("562360", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人ETF基金         市值：4.35      累涨：31.67     11.90     9.88      9.89      10日：6.90      2.64      1.26      0.95      33        累涨修正：43.73     净值区间：58      86      86      90      79      38
        KEJI_RUAN_JIAN.put("562570", ContEtfTypeName.KEJI_RUAN_JIAN);//信创ETF               市值：6.58      累涨：36.19     11.04     16.12     9.03      10日：5.50      1.85                0.62      46        累涨修正：43.54     净值区间：39      68      74      84      78      39
        KEJI_RUAN_JIAN.put("560850", ContEtfTypeName.KEJI_RUAN_JIAN);//信创50ETF             市值：2.93      累涨：36.00     11.08     15.77     9.15      10日：5.55      1.82                0.76      48        累涨修正：43.37     净值区间：37      65      72      83      81      40
        KEJI_RUAN_JIAN.put("516000", ContEtfTypeName.KEJI_RUAN_JIAN);//数据ETF               市值：3.95      累涨：35.57     11.47     14.39     9.71      10日：5.55      1.56      0.10      0.63      49        累涨修正：42.88     净值区间：48      78      80      88      74      41
        KEJI_RUAN_JIAN.put("588760", ContEtfTypeName.KEJI_RUAN_JIAN);//人工智能ETF科创       市值：13.79     累涨：32.01     8.08      12.96     10.97     10日：6.46      2.17      1.08      0.18      39        累涨修正：42.8      净值区间：50      83      83      86      63      42
        KEJI_RUAN_JIAN.put("589010", ContEtfTypeName.KEJI_RUAN_JIAN);//科创人工智能ETF华夏   市值：0.71      累涨：32.42     8.46      13.61     10.35     10日：6.33      2.13      0.96      0.00      41        累涨修正：42.8      净值区间：52      84      85      88      64      43
        KEJI_RUAN_JIAN.put("588790", ContEtfTypeName.KEJI_RUAN_JIAN);//科创AIETF             市值：47.80     累涨：33.86     9.69      14.02     10.15     10日：6.09      1.70      0.51      0.17      44        累涨修正：42.67     净值区间：53      83      84      86      64      44
        KEJI_RUAN_JIAN.put("159551", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人产业ETF         市值：3.79      累涨：31.26     11.55     9.64      10.07     10日：6.72      2.31      1.15      1.06      38        累涨修正：42.59     净值区间：59      87      88      91      80      45
        KEJI_RUAN_JIAN.put("588730", ContEtfTypeName.KEJI_RUAN_JIAN);//科创人工智能ETF       市值：7.23      累涨：32.19     8.36      13.30     10.53     10日：6.28      2.05      1.02      0.09      42        累涨修正：42.56     净值区间：54      84      84      87      63      46
        KEJI_RUAN_JIAN.put("159998", ContEtfTypeName.KEJI_RUAN_JIAN);//计算机ETF             市值：35.62     累涨：35.35     11.45     14.72     9.18      10日：5.45      1.53      0.11      0.87      51        累涨修正：42.55     净值区间：57      82      84      91      91      47
        KEJI_RUAN_JIAN.put("159613", ContEtfTypeName.KEJI_RUAN_JIAN);//信息安全ETF           市值：0.73      累涨：36.38     11.93     16.34     8.11      10日：4.02      1.44                0.77      52        累涨修正：41.84     净值区间：47      78      81      90      91      48
        KEJI_RUAN_JIAN.put("560630", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人产业ETF         市值：4.72      累涨：29.69     10.91     9.06      9.72      10日：6.97      2.30      1.25      0.94      43        累涨修正：41.46     净值区间：60      87      88      91      81      49
        KEJI_RUAN_JIAN.put("562920", ContEtfTypeName.KEJI_RUAN_JIAN);//信息安全ETF           市值：0.60      累涨：35.76     11.39     16.20     8.17      10日：3.99      1.45                0.83      55        累涨修正：41.2      净值区间：40      74      80      89      90      50
        KEJI_RUAN_JIAN.put("588930", ContEtfTypeName.KEJI_RUAN_JIAN);//科创板人工智能ETF     市值：9.58      累涨：32.72     9.11      13.27     10.34     10日：5.76      1.47      0.43      0.09      50        累涨修正：40.81     净值区间：54      84      84      87      53      51
        KEJI_RUAN_JIAN.put("589520", ContEtfTypeName.KEJI_RUAN_JIAN);//科创人工智能ETF华宝   市值：2.88      累涨：31.39     8.59      12.92     9.88      10日：5.89      1.69      0.56      0.23      54        累涨修正：40.09     净值区间：50      84      84      86      63      52
        KEJI_RUAN_JIAN.put("562560", ContEtfTypeName.KEJI_RUAN_JIAN);//信息技术ETF           市值：0.36      累涨：31.28     8.98      12.58     9.72      10日：4.36      2.35      0.36      1.01      53        累涨修正：38.71     净值区间：72      90      91      96      96      53
        KEJI_RUAN_JIAN.put("513360", ContEtfTypeName.KEJI_RUAN_JIAN);//教育ETF               市值：4.82      累涨：33.63     10.55     16.59     6.49      10日：3.41      1.13      0.19      0.57      61        累涨修正：38.55     净值区间：33      52      64      79      80      54
        KEJI_RUAN_JIAN.put("159939", ContEtfTypeName.KEJI_RUAN_JIAN);//信息技术ETF           市值：16.46     累涨：31.37     8.79      12.93     9.65      10日：4.15      2.14      0.15      0.90      57        累涨修正：37.96     净值区间：85      94      96      97      98      55
        KEJI_RUAN_JIAN.put("159539", ContEtfTypeName.KEJI_RUAN_JIAN);//信创ETF广发           市值：1.12      累涨：29.61     8.75      12.77     8.09      10日：4.68      1.97      0.43      0.76      59        累涨修正：37.12     净值区间：72      88      89      93      71      56
        KEJI_RUAN_JIAN.put("159540", ContEtfTypeName.KEJI_RUAN_JIAN);//信创ETF易方达         市值：2.35      累涨：28.78     8.61      12.11     8.06      10日：4.72      2.38      0.57      0.81      56        累涨修正：37.02     净值区间：78      90      91      96      84      57
        KEJI_RUAN_JIAN.put("159537", ContEtfTypeName.KEJI_RUAN_JIAN);//信创ETF               市值：2.58      累涨：28.21     7.25      12.96     8.00      10日：4.71      2.12      0.51      0.76      58        累涨修正：36.06     净值区间：73      88      89      76      71      58
        KEJI_RUAN_JIAN.put("560800", ContEtfTypeName.KEJI_RUAN_JIAN);//数字经济ETF           市值：7.80      累涨：27.79     7.33      12.73     7.73      10日：4.30      1.81      0.90      0.77      65        累涨修正：35.7      净值区间：80      90      90      95      85      59
        KEJI_RUAN_JIAN.put("159658", ContEtfTypeName.KEJI_RUAN_JIAN);//数字经济ETF           市值：2.00      累涨：26.99     7.18      12.02     7.79      10日：4.67      2.15      0.74      0.90      60        累涨修正：35.29     净值区间：86      94      94      96      84      60
        KEJI_RUAN_JIAN.put("159538", ContEtfTypeName.KEJI_RUAN_JIAN);//信创ETF富国           市值：1.60      累涨：27.84     8.10      11.98     7.76      10日：4.50      1.77      0.34      0.92      63        累涨修正：34.79     净值区间：68      85      86      92      63      61
        KEJI_RUAN_JIAN.put("588100", ContEtfTypeName.KEJI_RUAN_JIAN);//科创信息技术ETF       市值：2.48      累涨：24.17     5.82      10.49     7.86      10日：4.11      2.03      1.20      0.89      66        累涨修正：32.71     净值区间：85      92      92      94      72      62
        KEJI_RUAN_JIAN.put("588770", ContEtfTypeName.KEJI_RUAN_JIAN);//科创信息技术ETF摩根   市值：3.05      累涨：23.25     5.19      10.44     7.62      10日：4.33      2.20      1.46      0.72      64        累涨修正：32.7      净值区间：83      90      90      93      72      63
        KEJI_RUAN_JIAN.put("588260", ContEtfTypeName.KEJI_RUAN_JIAN);//科创信息ETF           市值：1.32      累涨：23.16     5.22      10.33     7.61      10日：4.07      1.98      1.21      0.75      68        累涨修正：31.63     净值区间：87      29      29      36      41      64
        KEJI_RUAN_JIAN.put("159213", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人ETF基金         市值：0.91      累涨：                    9.28      9.88      10日：6.89      2.66      1.42      0.85      45        累涨修正：31.55     净值区间：33      70      70      78              65
        KEJI_RUAN_JIAN.put("159389", ContEtfTypeName.KEJI_RUAN_JIAN);//数字经济ETF嘉实       市值：2.67      累涨：                              8.05      10日：4.34      2.01      0.86      0.85      67        累涨修正：16.12     净值区间：87      93      94                      66
        KEJI_RUAN_JIAN.put("159385", ContEtfTypeName.KEJI_RUAN_JIAN);//数字经济ETF富国       市值：2.34      累涨：                              7.37      10日：3.86      2.02      0.86      1.04      69        累涨修正：14.97     净值区间：92      95      96                      67
        KEJI_RUAN_JIAN.put("561220", ContEtfTypeName.KEJI_RUAN_JIAN);//数字经济ETF工银       市值：3.07      累涨：                              7.68      10日：3.96      1.93      0.58      1.04      70        累涨修正：14.73     净值区间：96      97      98                      68
        KEJI_RUAN_JIAN.put("159246", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF富国 市值：0.69      累涨：                                        10日：7.23      3.36      0.09      0.00      47        累涨修正：10.77     净值区间：38      38                              69
        KEJI_RUAN_JIAN.put("589380", ContEtfTypeName.KEJI_RUAN_JIAN);//AIETF富国             市值：0.64      累涨：                                        10日：6.36      1.95      0.68      -0.29     62        累涨修正：9.67      净值区间：40      79                              70
        KEJI_RUAN_JIAN.put("512720", ContEtfTypeName.KEJI_RUAN_JIAN);//计算机ETF             市值：13.87     累涨：                                        10日：                              0.73      72        累涨修正：0         净值区间：56      82      84      91      91      71
        KEJI_RUAN_JIAN.put("562500", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人ETF             市值：158.65    累涨：                                        10日：                              0.91      71        累涨修正：0         净值区间：57      86      87      90      80      72
        KEJI_RUAN_JIAN.put("159248", ContEtfTypeName.KEJI_RUAN_JIAN);//人工智能ETF基金       市值：3.21      累涨：                                        10日：                              0.30                累涨修正：          净值区间：                                        73
        KEJI_RUAN_JIAN.put("159311", ContEtfTypeName.KEJI_RUAN_JIAN);//数字经济ETF易方达     市值：1.46      累涨：                                        10日：          1.68      0.79      0.88                累涨修正：          净值区间：84                                      74
        KEJI_RUAN_JIAN.put("159242", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF大成 市值：4.01      累涨：                                        10日：                              -0.20               累涨修正：          净值区间：                                        75
    }

    public static Map<String, String> TOP_KEJI_XIN_PIAN = new HashMap<>();//科技-芯片

    static {
        TOP_KEJI_XIN_PIAN.put("588170", ContEtfTypeName.KEJI_XIN_PIAN);//科创半导体ETF         市值：2.61      累涨：32.11     7.46      13.56     11.09     10日：5.86      4.98      3.99      1.23      4         累涨修正：50.93     净值区间：92      94      94      96      96      1
        TOP_KEJI_XIN_PIAN.put("588780", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片设计ETF       市值：2.57      累涨：27.87     7.23      13.41     7.23      10日：3.29      0.96      0.39      0.48      27        累涨修正：32.9      净值区间：68      80      67      78      42      29
    }

    public static Map<String, String> KEJI_XIN_PIAN = new HashMap<>();//科技-芯片

    static {
        KEJI_XIN_PIAN.put("588170", ContEtfTypeName.KEJI_XIN_PIAN);//科创半导体ETF         市值：2.61      累涨：32.11     7.46      13.56     11.09     10日：5.86      4.98      3.99      1.23      4         累涨修正：50.93     净值区间：92      94      94      96      96      1
        KEJI_XIN_PIAN.put("159909", ContEtfTypeName.KEJI_XIN_PIAN);//TMT50ETF              市值：4.87      累涨：39.15     10.45     14.19     14.51     10日：6.83      3.40      0.40      0.54      1         累涨修正：50.18     净值区间：36      75      84      89      90      2
        KEJI_XIN_PIAN.put("159732", ContEtfTypeName.KEJI_XIN_PIAN);//消费电子ETF           市值：22.11     累涨：38.36     11.11     13.92     13.33     10日：5.64      3.82      0.82      0.35      2         累涨修正：49.46     净值区间：52      81      86      92      92      3
        KEJI_XIN_PIAN.put("512220", ContEtfTypeName.KEJI_XIN_PIAN);//TMTETF                市值：4.27      累涨：36.58     9.10      14.25     13.23     10日：5.88      2.76      0.27      1.12      3         累涨修正：45.76     净值区间：63      87      90      94      94      4
        KEJI_XIN_PIAN.put("561100", ContEtfTypeName.KEJI_XIN_PIAN);//消费电子ETF富国       市值：5.58      累涨：34.72     8.64      13.07     13.01     10日：5.41      3.36      0.66      0.99      5         累涨修正：44.81     净值区间：85      95      96      97      97      5
        KEJI_XIN_PIAN.put("560780", ContEtfTypeName.KEJI_XIN_PIAN);//芯片设备ETF           市值：2.06      累涨：28.07     6.75      11.66     9.66      10日：5.12      4.51      3.28      1.01      11        累涨修正：44.26     净值区间：92      94      94      96      96      6
        KEJI_XIN_PIAN.put("159516", ContEtfTypeName.KEJI_XIN_PIAN);//半导体设备ETF         市值：30.00     累涨：28.05     6.72      11.78     9.55      10日：4.94      4.18      3.03      1.11      12        累涨修正：43.23     净值区间：93      95      95      97      97      7
        KEJI_XIN_PIAN.put("562950", ContEtfTypeName.KEJI_XIN_PIAN);//消费电子ETF易方达     市值：3.97      累涨：34.20     8.96      13.25     11.99     10日：4.86      3.06      0.46      1.16      6         累涨修正：43.04     净值区间：84      94      96      97      97      8
        KEJI_XIN_PIAN.put("561980", ContEtfTypeName.KEJI_XIN_PIAN);//半导体设备ETF         市值：9.24      累涨：26.71     5.57      11.64     9.50      10日：5.69      4.29      3.13      1.19      14        累涨修正：42.95     净值区间：91      93      94      96      96      9
        KEJI_XIN_PIAN.put("561310", ContEtfTypeName.KEJI_XIN_PIAN);//消电ETF               市值：0.65      累涨：33.83     8.76      13.25     11.82     10日：5.24      2.97      0.36      0.97      8         累涨修正：42.76     净值区间：78      92      94      96      96      10
        KEJI_XIN_PIAN.put("561600", ContEtfTypeName.KEJI_XIN_PIAN);//消费电子ETF           市值：2.65      累涨：33.61     8.96      12.71     11.94     10日：5.07      3.12      0.47      1.18      7         累涨修正：42.74     净值区间：74      91      93      95      95      11
        KEJI_XIN_PIAN.put("159327", ContEtfTypeName.KEJI_XIN_PIAN);//半导体设备ETF基金     市值：1.80      累涨：26.69     6.09      11.07     9.53      10日：5.08      4.43      2.80      1.41      15        累涨修正：41.8      净值区间：96      97      97      98      98      12
        KEJI_XIN_PIAN.put("159558", ContEtfTypeName.KEJI_XIN_PIAN);//半导体设备ETF易方达   市值：4.96      累涨：25.73     5.34      10.81     9.58      10日：4.90      4.24      3.16      1.19      19        累涨修正：41.19     净值区间：95      96      96      98      98      13
        KEJI_XIN_PIAN.put("515320", ContEtfTypeName.KEJI_XIN_PIAN);//电子50ETF             市值：1.52      累涨：31.41     7.97      11.37     12.07     10日：5.45      3.06      0.58      0.81      10        累涨修正：41.08     净值区间：76      91      94      96      96      14
        KEJI_XIN_PIAN.put("159779", ContEtfTypeName.KEJI_XIN_PIAN);//消费电子50ETF         市值：1.12      累涨：33.15     8.83      13.21     11.11     10日：4.75      2.81      0.12      1.13      9         累涨修正：40.95     净值区间：82      94      95      97      97      15
        KEJI_XIN_PIAN.put("159582", ContEtfTypeName.KEJI_XIN_PIAN);//半导体产业ETF         市值：2.01      累涨：24.89     5.05      10.84     9.00      10日：5.33      4.06      3.07      1.16      21        累涨修正：40.42     净值区间：91      93      93      95      93      16
        KEJI_XIN_PIAN.put("159997", ContEtfTypeName.KEJI_XIN_PIAN);//电子ETF               市值：12.69     累涨：32.06     8.63      12.97     10.46     10日：4.45      2.78      0.52      0.94      13        累涨修正：40.33     净值区间：83      93      95      97      97      17
        KEJI_XIN_PIAN.put("562590", ContEtfTypeName.KEJI_XIN_PIAN);//半导体材料ETF         市值：3.93      累涨：26.23     5.47      11.40     9.36      10日：4.80      3.98      2.61      1.59      18        累涨修正：40.23     净值区间：90      92      92      95      95      18
        KEJI_XIN_PIAN.put("513310", ContEtfTypeName.KEJI_XIN_PIAN);//中韩半导体ETF         市值：6.32      累涨：33.97     9.95      17.69     6.33      10日：2.86      0.61      0.37      0.67      26        累涨修正：38.18     净值区间：64      45      40      80      83      19
        KEJI_XIN_PIAN.put("515260", ContEtfTypeName.KEJI_XIN_PIAN);//电子ETF               市值：4.72      累涨：30.65     8.69      11.23     10.73     10日：4.61      2.40      0.11      0.96      16        累涨修正：37.88     净值区间：70      88      92      95      95      20
        KEJI_XIN_PIAN.put("588750", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片50ETF         市值：16.94     累涨：25.78     5.86      11.81     8.11      10日：4.64      2.05      1.66      0.87      23        累涨修正：35.79     净值区间：83      89      89      93      69      21
        KEJI_XIN_PIAN.put("588200", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF           市值：313.18    累涨：25.57     5.67      11.52     8.38      10日：4.68      2.22      1.63      0.77      22        累涨修正：35.73     净值区间：85      90      90      93      68      22
        KEJI_XIN_PIAN.put("515920", ContEtfTypeName.KEJI_XIN_PIAN);//智能消费ETF           市值：1.80      累涨：27.24     7.35      10.16     9.73      10日：4.63      2.35      0.33      0.99      20        累涨修正：34.88     净值区间：81      94      95      97      97      23
        KEJI_XIN_PIAN.put("588810", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF富国       市值：0.83      累涨：24.69     4.71      12.01     7.97      10日：4.49      2.13      1.76      0.64      24        累涨修正：34.83     净值区间：84      89      89      93      86      24
        KEJI_XIN_PIAN.put("588890", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF南方       市值：5.78      累涨：24.75     5.28      11.79     7.68      10日：4.37      2.23      1.64      0.81      25        累涨修正：34.63     净值区间：83      89      89      93      66      25
        KEJI_XIN_PIAN.put("588290", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF基金       市值：26.20     累涨：24.37     5.20      11.27     7.90      10日：4.45      2.20      1.73      0.79      28        累涨修正：34.48     净值区间：81      88      88      92      69      26
        KEJI_XIN_PIAN.put("588990", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF博时       市值：2.32      累涨：24.47     4.84      11.87     7.76      10日：4.16      2.06      1.62      0.80      31        累涨修正：33.93     净值区间：84      89      89      93      70      27
        KEJI_XIN_PIAN.put("589100", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF国泰       市值：1.09      累涨：23.84     4.93      11.12     7.79      10日：4.51      2.13      1.72      0.80      33        累涨修正：33.92     净值区间：84      90      90      94      72      28
        KEJI_XIN_PIAN.put("588780", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片设计ETF       市值：2.57      累涨：27.87     7.23      13.41     7.23      10日：3.29      0.96      0.39      0.48      27        累涨修正：32.9      净值区间：68      80      67      78      42      29
        KEJI_XIN_PIAN.put("159813", ContEtfTypeName.KEJI_XIN_PIAN);//半导体ETF             市值：57.77     累涨：23.59     5.79      10.43     7.37      10日：4.26      2.30      1.27      0.88      30        累涨修正：32.69     净值区间：87      92      93      95      64      30
        KEJI_XIN_PIAN.put("512480", ContEtfTypeName.KEJI_XIN_PIAN);//半导体ETF             市值：268.66    累涨：25.22     6.83      11.46     6.93      10日：3.61      1.84      0.97      1.25      32        累涨修正：32.61     净值区间：82      88      88      92      63      31
        KEJI_XIN_PIAN.put("159995", ContEtfTypeName.KEJI_XIN_PIAN);//芯片ETF               市值：268.17    累涨：23.95     6.40      10.08     7.47      10日：4.15      2.14      0.98      1.05      29        累涨修正：32.2      净值区间：83      90      91      94      63      32
        KEJI_XIN_PIAN.put("516640", ContEtfTypeName.KEJI_XIN_PIAN);//芯片龙头ETF           市值：13.74     累涨：23.70     6.03      10.43     7.24      10日：3.75      2.13      1.06      0.92      35        累涨修正：31.7      净值区间：82      89      89      93      61      33
        KEJI_XIN_PIAN.put("512760", ContEtfTypeName.KEJI_XIN_PIAN);//芯片ETF               市值：120.24    累涨：23.56     6.07      10.35     7.14      10日：3.70      2.10      1.04      0.95      37        累涨修正：31.44     净值区间：83      89      89      93      64      34
        KEJI_XIN_PIAN.put("562820", ContEtfTypeName.KEJI_XIN_PIAN);//集成电路ETF           市值：0.69      累涨：25.54     6.74      11.93     6.87      10日：3.45      1.37      0.50      0.86      34        累涨修正：31.36     净值区间：75      86      81      86      54      35
        KEJI_XIN_PIAN.put("159325", ContEtfTypeName.KEJI_XIN_PIAN);//半导体ETF南方         市值：1.80      累涨：23.93     5.83      11.54     6.56      10日：3.51      1.88      0.84      0.84      40        累涨修正：31        净值区间：81      87      88      92      57      36
        KEJI_XIN_PIAN.put("159560", ContEtfTypeName.KEJI_XIN_PIAN);//芯片50ETF             市值：1.30      累涨：23.78     6.14      10.88     6.76      10日：3.59      1.95      0.84      1.18      39        累涨修正：31        净值区间：84      91      78      85      62      37
        KEJI_XIN_PIAN.put("588710", ContEtfTypeName.KEJI_XIN_PIAN);//科创半导体设备ETF     市值：1.02      累涨：                              11.90     10日：6.34      4.72      3.76      1.46      17        累涨修正：30.48     净值区间：90      91      92                      38
        KEJI_XIN_PIAN.put("159665", ContEtfTypeName.KEJI_XIN_PIAN);//半导体龙头ETF         市值：3.74      累涨：22.20     6.09      9.27      6.84      10日：3.86      2.23      1.03      1.02      36        累涨修正：30.35     净值区间：86      92      92      95      67      39
        KEJI_XIN_PIAN.put("516350", ContEtfTypeName.KEJI_XIN_PIAN);//芯片ETF易方达         市值：10.49     累涨：23.27     6.24      10.07     6.96      10日：3.60      1.67      0.83      1.06      41        累涨修正：30.2      净值区间：84      90      90      94      64      40
        KEJI_XIN_PIAN.put("159546", ContEtfTypeName.KEJI_XIN_PIAN);//集成电路ETF           市值：1.37      累涨：25.34     6.81      12.36     6.17      10日：3.02      1.31      0.23      0.76      38        累涨修正：30.13     净值区间：72      86      79      86      55      41
        KEJI_XIN_PIAN.put("516920", ContEtfTypeName.KEJI_XIN_PIAN);//芯片50ETF             市值：5.12      累涨：22.79     6.19      9.85      6.75      10日：3.59      2.06      0.82      1.08      42        累涨修正：30.08     净值区间：81      88      89      92      60      42
        KEJI_XIN_PIAN.put("159310", ContEtfTypeName.KEJI_XIN_PIAN);//芯片ETF天弘           市值：10.63     累涨：22.56     6.15      9.89      6.52      10日：3.39      1.85      0.82      0.95      43        累涨修正：29.44     净值区间：80      89      89      92      62      43
        KEJI_XIN_PIAN.put("159801", ContEtfTypeName.KEJI_XIN_PIAN);//芯片ETF龙头           市值：34.39     累涨：21.57     5.19      9.71      6.67      10日：3.82      1.98      0.82      0.98      44        累涨修正：29.01     净值区间：78      87      88      91      62      44
        KEJI_XIN_PIAN.put("159599", ContEtfTypeName.KEJI_XIN_PIAN);//芯片ETF基金           市值：7.15      累涨：22.13     5.35      10.19     6.59      10日：3.40      1.72      0.76      1.09      45        累涨修正：28.77     净值区间：83      90      90      93      60      45
    }

    public static Map<String, String> KEJI_TONG_XIN = new HashMap<>();
    public static Map<String, String> TOP_KEJI_TONG_XIN = new HashMap<>();

    static {
        TOP_KEJI_TONG_XIN.put("515880", "科技-通信             ");//通信ETF               市值：27.23     累涨：44.92     8.29      21.45     15.18     10日：6.91      6.08      2.11      3.18      1         累涨修正：62.13     净值区间：95      96      96      99      79      1
    }

    static {
        KEJI_TONG_XIN.put("515880", "科技-通信             ");//通信ETF               市值：27.23     累涨：44.92     8.29      21.45     15.18     10日：6.91      6.08      2.11      3.18      1         累涨修正：62.13     净值区间：95      96      96      99      79      1
        KEJI_TONG_XIN.put("515050", "科技-通信             ");//5G通信ETF             市值：64.83     累涨：41.88     7.74      20.53     13.61     10日：6.44      5.85      2.26      3.08      3         累涨修正：58.69     净值区间：96      96      85      94      62      2
        KEJI_TONG_XIN.put("159994", "科技-通信             ");//5GETF                 市值：15.29     累涨：42.21     8.19      21.15     12.87     10日：6.03      5.55      2.16      3.40      2         累涨修正：58.11     净值区间：98      98      86      95      62      3
        KEJI_TONG_XIN.put("159583", "科技-通信             ");//通信设备ETF           市值：0.65      累涨：39.69     8.09      17.66     13.94     10日：5.94      5.19      2.30      2.34      4         累涨修正：55.42     净值区间：100     100     80      92      73      4
        KEJI_TONG_XIN.put("159811", "科技-通信             ");//5G50ETF               市值：1.09      累涨：38.09     9.44      17.82     10.83     10日：5.01      4.58      1.98      3.13      5         累涨修正：51.64     净值区间：97      97      85      94      62      5
        KEJI_TONG_XIN.put("159695", "科技-通信             ");//通信ETF               市值：1.04      累涨：34.63     7.64      15.37     11.62     10日：4.81      3.93      1.56      2.05      6         累涨修正：46.49     净值区间：94      96      96      99      77      6
        KEJI_TONG_XIN.put("159507", "科技-通信             ");//电信ETF               市值：0.45      累涨：34.45     8.02      15.25     11.18     10日：4.60      3.73      1.71      2.15      7         累涨修正：46.2      净值区间：96      97      97      99      75      7
        KEJI_TONG_XIN.put("159511", "科技-通信             ");//通信ETF南方           市值：0.83      累涨：29.27     8.70      12.77     7.80      10日：3.82      2.93      1.36      1.72      8         累涨修正：38.74     净值区间：96      96      96      99      69      8
        KEJI_TONG_XIN.put("560300", "科技-通信             ");//电信50ETF             市值：0.73      累涨：23.94     5.34      10.41     8.19      10日：3.74      2.76      0.89      1.84      9         累涨修正：32.22     净值区间：98      98      98      99      62      9
        KEJI_TONG_XIN.put("560690", "科技-通信             ");//电信ETF基金           市值：0.26      累涨：24.10     6.74      9.42      7.94      10日：3.52      2.73      0.93      1.61      10        累涨修正：32.21     净值区间：96      97      97      99      63      10
        KEJI_TONG_XIN.put("563010", "科技-通信             ");//电信ETF               市值：1.48      累涨：24.63     7.02      10.01     7.60      10日：2.57      2.01      0.64      1.74      11        累涨修正：30.49     净值区间：96      96      94      98      63      11
    }

    public static Map<String, String> TOP_KEJI_NEW_ENERGY = new HashMap<>();//
    static {
        TOP_KEJI_NEW_ENERGY.put("561380", ContEtfTypeName.KEJI_NEW_ENERGY);//电网ETF               市值：0.64      累涨：37.79     7.59      12.20     18.00     10日：11.27     7.17      4.95      -0.88     3         累涨修正：66.13     净值区间：29      55      64      72      74      1
    }
    public static Map<String, String> KEJI_NEW_ENERGY = new HashMap<>();//
    static {
        KEJI_NEW_ENERGY.put("561380", ContEtfTypeName.KEJI_NEW_ENERGY);//电网ETF               市值：0.64      累涨：37.79     7.59      12.20     18.00     10日：11.27     7.17      4.95      -0.88     3         累涨修正：66.13     净值区间：29      55      64      72      74      1
        KEJI_NEW_ENERGY.put("159320", ContEtfTypeName.KEJI_NEW_ENERGY);//电网ETF               市值：0.27      累涨：37.39     7.81      12.42     17.16     10日：10.91     6.46      4.42      0.18      2         累涨修正：63.6      净值区间：66      82      87      91      91      2
        KEJI_NEW_ENERGY.put("516180", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF基金           市值：0.70      累涨：37.09     10.92     8.85      17.32     10日：7.74      5.20      4.18      2.14      1         累涨修正：58.39     净值区间：97      97      99      99      99      3
        KEJI_NEW_ENERGY.put("588830", ContEtfTypeName.KEJI_NEW_ENERGY);//科创新能源ETF         市值：4.90      累涨：37.91     9.39      14.62     13.90     10日：6.73      5.74      3.80      2.20      5         累涨修正：57.98     净值区间：100     100     100     100     100     4
        KEJI_NEW_ENERGY.put("159864", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏50ETF             市值：4.84      累涨：35.60     10.85     8.18      16.57     10日：7.28      5.34      4.48      2.31      6         累涨修正：57.18     净值区间：96      97      99      99      99      5
        KEJI_NEW_ENERGY.put("159618", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF指数基金       市值：0.66      累涨：35.69     10.69     8.80      16.20     10日：7.33      5.22      4.34      1.88      7         累涨修正：56.92     净值区间：93      94      98      98      98      6
        KEJI_NEW_ENERGY.put("588960", ContEtfTypeName.KEJI_NEW_ENERGY);//科创板新能源ETF       市值：1.09      累涨：36.86     9.42      13.46     13.98     10日：6.54      5.95      3.68      2.08      4         累涨修正：56.71     净值区间：97      98      98      99      99      7
        KEJI_NEW_ENERGY.put("515790", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF               市值：143.62    累涨：35.46     9.76      9.31      16.39     10日：7.07      4.97      4.13      2.31      8         累涨修正：55.76     净值区间：95      96      98      98      98      8
        KEJI_NEW_ENERGY.put("516880", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏50ETF             市值：12.43     累涨：35.15     10.16     8.83      16.16     10日：6.90      4.75      3.92      1.76      9         累涨修正：54.64     净值区间：91      93      97      97      97      9
        KEJI_NEW_ENERGY.put("159863", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF基金           市值：2.59      累涨：33.84     9.19      7.97      16.68     10日：7.32      5.00      3.95      2.46      10        累涨修正：54.06     净值区间：100     100     100     100     100     10
        KEJI_NEW_ENERGY.put("562970", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF易方达         市值：2.62      累涨：35.48     11.39     7.98      16.11     10日：7.10      3.89      3.77      1.67      15        累涨修正：54.01     净值区间：91      93      97      97      97      11
        KEJI_NEW_ENERGY.put("516290", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏龙头ETF           市值：3.88      累涨：33.84     9.59      8.01      16.24     10日：6.81      4.79      4.12      1.96      12        累涨修正：53.68     净值区间：89      91      96      96      96      12
        KEJI_NEW_ENERGY.put("159609", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏龙头ETF           市值：2.81      累涨：34.50     10.28     8.85      15.37     10日：6.22      4.29      3.33      2.10      16        累涨修正：51.67     净值区间：96      96      98      99      99      13
        KEJI_NEW_ENERGY.put("159326", ContEtfTypeName.KEJI_NEW_ENERGY);//电网设备ETF           市值：1.08      累涨：26.66     6.17      8.13      12.36     10日：7.90      6.07      5.43      -0.17     19        累涨修正：51.49     净值区间：48      55      64      70      70      14
        KEJI_NEW_ENERGY.put("516090", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源ETF易方达       市值：6.88      累涨：32.19     8.88      9.43      13.88     10日：6.77      5.46      3.35      2.78      11        累涨修正：51.12     净值区间：100     100     100     100     100     15
        KEJI_NEW_ENERGY.put("516580", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源主题ETF         市值：0.95      累涨：32.46     9.46      10.39     12.61     10日：6.23      5.14      3.62      2.72      14        累涨修正：51.07     净值区间：100     100     100     100     100     16
        KEJI_NEW_ENERGY.put("516850", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源ETF基金         市值：1.18      累涨：32.17     9.19      9.94      13.04     10日：6.25      5.27      3.58      2.43      13        累涨修正：50.85     净值区间：98      98      99      99      99      17
        KEJI_NEW_ENERGY.put("516160", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源ETF             市值：44.77     累涨：32.29     9.20      9.79      13.30     10日：6.21      5.19      3.55      2.61      18        累涨修正：50.79     净值区间：98      99      99      99      99      18
        KEJI_NEW_ENERGY.put("159875", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源ETF             市值：9.29      累涨：32.07     9.43      9.64      13.00     10日：6.18      5.32      3.60      2.70      17        累涨修正：50.77     净值区间：97      97      98      99      99      19
        KEJI_NEW_ENERGY.put("560980", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF龙头           市值：1.76      累涨：32.20     8.98      9.65      13.57     10日：6.10      4.40      3.77      1.65      20        累涨修正：50.24     净值区间：96      96      98      99      99      20
        KEJI_NEW_ENERGY.put("159368", ContEtfTypeName.KEJI_NEW_ENERGY);//创业板新能源ETF华夏   市值：0.85      累涨：35.48     11.43     12.62     11.43     10日：5.04      3.17      2.03      1.30      21        累涨修正：47.75     净值区间：95      96      98      99      99      21
        KEJI_NEW_ENERGY.put("562990", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF易方达       市值：10.59     累涨：24.22     7.49      6.06      10.67     10日：6.49      5.84      4.16      0.74      22        累涨修正：44.87     净值区间：87      89      91      93      94      22
        KEJI_NEW_ENERGY.put("159861", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和50ETF           市值：1.60      累涨：28.43     8.58      7.95      11.90     10日：5.35      4.15      3.07      1.63      23        累涨修正：44.07     净值区间：88      89      93      95      95      23
        KEJI_NEW_ENERGY.put("561190", ContEtfTypeName.KEJI_NEW_ENERGY);//双碳ETF               市值：6.34      累涨：23.13     6.81      6.18      10.14     10日：6.22      5.83      4.15      0.99      26        累涨修正：43.48     净值区间：89      91      93      94      95      24
        KEJI_NEW_ENERGY.put("560060", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF             市值：2.20      累涨：23.58     7.76      5.48      10.34     10日：6.22      5.43      4.12      0.75      27        累涨修正：43.47     净值区间：83      86      89      91      91      25
        KEJI_NEW_ENERGY.put("560560", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF泰康         市值：0.66      累涨：26.62     8.64      6.64      11.34     10日：5.29      4.22      3.51      0.52      25        累涨修正：43.15     净值区间：64      69      80      84      86      26
        KEJI_NEW_ENERGY.put("159640", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和龙头ETF         市值：1.81      累涨：23.57     7.59      5.85      10.13     10日：6.16      5.51      3.95      1.12      28        累涨修正：43.14     净值区间：90      92      94      96      96      27
        KEJI_NEW_ENERGY.put("159641", ContEtfTypeName.KEJI_NEW_ENERGY);//双碳ETF               市值：2.76      累涨：23.09     7.02      5.89      10.18     10日：6.30      5.56      3.96      1.29      24        累涨修正：42.87     净值区间：98      98      99      99      99      28
        KEJI_NEW_ENERGY.put("560550", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF龙头         市值：4.18      累涨：22.72     7.20      6.03      9.49      10日：6.22      5.57      4.02      1.11      29        累涨修正：42.55     净值区间：93      94      96      97      97      29
        KEJI_NEW_ENERGY.put("159639", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF南方         市值：7.03      累涨：23.16     7.22      5.92      10.02     10日：5.97      5.58      3.90      1.11      31        累涨修正：42.51     净值区间：91      92      94      96      96      30
        KEJI_NEW_ENERGY.put("159642", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和100ETF          市值：0.83      累涨：22.66     7.31      5.63      9.72      10日：6.06      5.54      4.01      0.86      34        累涨修正：42.28     净值区间：88      91      93      94      94      31
        KEJI_NEW_ENERGY.put("512580", ContEtfTypeName.KEJI_NEW_ENERGY);//环保ETF               市值：12.14     累涨：26.38     8.27      7.91      10.20     10日：4.90      4.08      3.05      1.20      33        累涨修正：41.46     净值区间：93      94      96      97      98      32
        KEJI_NEW_ENERGY.put("159885", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF基金         市值：2.49      累涨：24.86     8.34      5.71      10.81     10日：5.47      4.31      3.30      1.14      32        累涨修正：41.24     净值区间：86      88      93      94      95      33
        KEJI_NEW_ENERGY.put("516270", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源50ETF           市值：2.11      累涨：27.31     9.60      7.69      10.02     10日：4.60      3.50      2.84      1.94      30        累涨修正：41.09     净值区间：95      96      97      98      98      34
        KEJI_NEW_ENERGY.put("159790", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF             市值：20.66     累涨：25.24     9.03      5.71      10.50     10日：4.80      3.94      3.25      1.18      35        累涨修正：40.48     净值区间：86      88      93      95      95      35
        KEJI_NEW_ENERGY.put("562010", ContEtfTypeName.KEJI_NEW_ENERGY);//绿色能源ETF           市值：0.14      累涨：27.74     9.05      8.59      10.10     10日：4.69      3.62      2.13      1.71      35        累涨修正：40.31     净值区间：94      96      97      98      98      36
        KEJI_NEW_ENERGY.put("516070", ContEtfTypeName.KEJI_NEW_ENERGY);//低碳ETF易方达         市值：2.62      累涨：25.21     8.13      6.73      10.35     10日：4.53      4.10      3.01      1.05      36        累涨修正：39.86     净值区间：90      92      95      96      97      37
        KEJI_NEW_ENERGY.put("562300", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF基金         市值：0.61      累涨：24.26     8.42      6.02      9.82      10日：4.73      4.02      3.14      1.38      38        累涨修正：39.29     净值区间：90      90      94      96      96      38
        KEJI_NEW_ENERGY.put("159752", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源龙头ETF         市值：2.96      累涨：26.59     9.09      7.75      9.75      10日：4.26      3.62      2.11      1.88      37        累涨修正：38.69     净值区间：100     100     100     100     100     39
        KEJI_NEW_ENERGY.put("159625", ContEtfTypeName.KEJI_NEW_ENERGY);//绿色电力ETF           市值：3.14      累涨：18.89     7.87      3.60      7.42      10日：3.33      2.65      2.05      0.08      40        累涨修正：28.97     净值区间：52      54      70      73      76      40
        KEJI_NEW_ENERGY.put("159611", ContEtfTypeName.KEJI_NEW_ENERGY);//电力ETF               市值：36.38     累涨：18.30     6.81      3.62      7.87      10日：3.60      2.50      2.10      0.60      42        累涨修正：28.6      净值区间：65      65      77      80      81      41
        KEJI_NEW_ENERGY.put("561560", ContEtfTypeName.KEJI_NEW_ENERGY);//电力ETF               市值：5.81      累涨：18.21     6.86      3.67      7.68      10日：3.39      2.48      2.06      0.33      45        累涨修正：28.2      净值区间：54      55      72      75      77      42
        KEJI_NEW_ENERGY.put("159669", ContEtfTypeName.KEJI_NEW_ENERGY);//绿电ETF               市值：1.01      累涨：18.37     7.95      3.08      7.34      10日：3.36      2.43      1.96      0.19      41        累涨修正：28.08     净值区间：25      27      41      45      48      43
        KEJI_NEW_ENERGY.put("562960", ContEtfTypeName.KEJI_NEW_ENERGY);//绿色电力ETF易方达     市值：0.92      累涨：18.67     7.28      3.70      7.69      10日：3.30      2.29      1.83      0.09      43        累涨修正：27.92     净值区间：51      51      70      73      75      44
        KEJI_NEW_ENERGY.put("561170", ContEtfTypeName.KEJI_NEW_ENERGY);//绿色电力ETF           市值：1.51      累涨：18.47     6.95      3.48      8.04      10日：3.29      2.20      1.74      0.00      49        累涨修正：27.44     净值区间：48      49      67      71      74      45
        KEJI_NEW_ENERGY.put("562350", ContEtfTypeName.KEJI_NEW_ENERGY);//电力指数ETF           市值：0.40      累涨：17.65     6.95      2.93      7.77      10日：3.52      2.38      1.90      0.19      47        累涨修正：27.35     净值区间：45      48      66      69      73      46
        KEJI_NEW_ENERGY.put("560580", ContEtfTypeName.KEJI_NEW_ENERGY);//电力ETF南方           市值：0.59      累涨：18.89     7.66      3.83      7.40      10日：2.95      2.00      1.71      0.19      46        累涨修正：27.26     净值区间：55      56      73      76      78      47
        KEJI_NEW_ENERGY.put("561700", ContEtfTypeName.KEJI_NEW_ENERGY);//电力ETF基金           市值：1.54      累涨：18.22     6.98      3.54      7.70      10日：3.23      2.28      1.61      0.38      48        累涨修正：26.95     净值区间：50      51      61      64      67      48
        KEJI_NEW_ENERGY.put("562550", ContEtfTypeName.KEJI_NEW_ENERGY);//绿电ETF               市值：1.46      累涨：18.37     7.46      3.59      7.32      10日：3.02      2.11      1.65      -0.09     50        累涨修正：26.8      净值区间：38      41      60      63      66      49
        KEJI_NEW_ENERGY.put("159387", ContEtfTypeName.KEJI_NEW_ENERGY);//创业板新能源ETF国泰   市值：0.23      累涨：                              10.83     10日：4.31      2.83      1.82      2.35      39        累涨修正：21.61     净值区间：100     100     100                     50
        KEJI_NEW_ENERGY.put("159261", ContEtfTypeName.KEJI_NEW_ENERGY);//创业板新能源ETF鹏华   市值：2.06      累涨：                                        10日：4.88      3.50      1.83      2.01      44        累涨修正：12.04     净值区间：98      99                              51
        KEJI_NEW_ENERGY.put("159857", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF               市值：24.50     累涨：                                        10日：                              2.08      51        累涨修正：0         净值区间：91      93      97      97      97      52
    }

    public static Map<String, String> TOP_KEJI_NEW_CAR = new HashMap<>();//科技-汽车

    static {
        TOP_KEJI_NEW_CAR.put("520600", "科技-汽车             ");//港股汽车ETF           市值：7.41      累涨：40.33     19.12     9.78      11.43     10日：5.69      4.14      3.28      2.39      1         累涨修正：56.72     净值区间：97      98      98      75      81      1
    }

    public static Map<String, String> KEJI_NEW_CAR = new HashMap<>();//科技-汽车

    static {
        KEJI_NEW_CAR.put("520600", "科技-汽车             ");//港股汽车ETF           市值：7.41      累涨：40.33     19.12     9.78      11.43     10日：5.69      4.14      3.28      2.39      1         累涨修正：56.72     净值区间：97      98      98      75      81      1
        KEJI_NEW_CAR.put("159323", "科技-汽车             ");//港股通汽车ETF         市值：2.32      累涨：39.62     18.31     10.10     11.21     10日：5.32      3.91      2.92      3.27      2         累涨修正：54.69     净值区间：100     100     100     78      83      2
        KEJI_NEW_CAR.put("159565", "科技-汽车             ");//汽车零部件ETF         市值：0.94      累涨：36.54     18.49     6.03      12.02     10日：5.96      3.95      3.12      1.12      5         累涨修正：52.69     净值区间：99      99      99      96      90      3
        KEJI_NEW_CAR.put("562700", "科技-汽车             ");//汽车零部件ETF         市值：0.62      累涨：35.79     18.41     5.90      11.48     10日：5.71      4.18      3.37      1.21      7         累涨修正：52.42     净值区间：86      87      90      90      84      4
        KEJI_NEW_CAR.put("159306", "科技-汽车             ");//汽车零件ETF           市值：0.24      累涨：34.26     18.04     6.26      9.96      10日：4.43      3.43      2.70      1.23      12        累涨修正：47.52     净值区间：100     100     100     87      91      5
        KEJI_NEW_CAR.put("159305", "科技-汽车             ");//储能电池ETF广发       市值：0.40      累涨：36.84     14.83     7.39      14.62     10日：5.98      1.82      0.74      0.33      3         累涨修正：46.12     净值区间：66      85      92      92      95      6
        KEJI_NEW_CAR.put("159566", "科技-汽车             ");//储能电池ETF           市值：1.25      累涨：37.42     15.05     7.61      14.76     10日：5.87      1.25      0.44      0.36      4         累涨修正：45.42     净值区间：62      86      93      93      95      7
        KEJI_NEW_CAR.put("561160", "科技-汽车             ");//锂电池ETF             市值：6.02      累涨：35.74     14.02     8.32      13.40     10日：5.84      1.79      0.60      1.19      6         累涨修正：44.57     净值区间：100     100     100     100     100     8
        KEJI_NEW_CAR.put("515250", "科技-汽车             ");//智能汽车ETF           市值：7.51      累涨：34.14     15.87     7.46      10.81     10日：4.02      1.90      1.37      1.14      8         累涨修正：42.8      净值区间：100     100     100     97      77      9
        KEJI_NEW_CAR.put("159796", "科技-汽车             ");//电池50ETF             市值：10.36     累涨：33.92     13.28     7.59      13.05     10日：5.66      1.36      0.51      0.84      10        累涨修正：41.96     净值区间：88      93      97      97      98      10
        KEJI_NEW_CAR.put("159889", "科技-汽车             ");//智能汽车ETF           市值：0.48      累涨：34.57     16.70     7.44      10.43     10日：3.53      1.65      1.10      1.30      14        累涨修正：41.95     净值区间：97      97      98      92      73      11
        KEJI_NEW_CAR.put("561910", "科技-汽车             ");//电池ETF               市值：7.15      累涨：34.06     12.93     8.09      13.04     10日：5.67      1.40      0.40      1.39      9         累涨修正：41.93     净值区间：93      96      98      98      99      12
        KEJI_NEW_CAR.put("159888", "科技-汽车             ");//智能车ETF             市值：0.84      累涨：33.51     15.63     7.39      10.49     10日：3.70      1.70      1.32      1.31      15        累涨修正：41.55     净值区间：97      98      99      94      78      13
        KEJI_NEW_CAR.put("562880", "科技-汽车             ");//电池ETF嘉实           市值：3.03      累涨：34.84     14.15     7.69      13.00     10日：5.34      0.97      0.19      1.16      11        累涨修正：41.53     净值区间：100     100     100     100     100     14
        KEJI_NEW_CAR.put("516520", "科技-汽车             ");//智能驾驶ETF           市值：3.70      累涨：33.22     15.63     7.05      10.54     10日：3.73      1.62      1.33      1.13      21        累涨修正：41.23     净值区间：97      97      99      97      79      15
        KEJI_NEW_CAR.put("560000", "科技-汽车             ");//智慧电车ETF           市值：0.10      累涨：30.02     13.78     5.01      11.23     10日：5.64      2.42      1.51      0.30      20        累涨修正：41.1      净值区间：72      76      88      59      39      16
        KEJI_NEW_CAR.put("159795", "科技-汽车             ");//智能汽车ETF基金       市值：0.42      累涨：32.72     15.65     7.50      9.57      10日：3.46      1.67      1.22      1.43      19        累涨修正：40.29     净值区间：100     100     100     97      80      17
        KEJI_NEW_CAR.put("159767", "科技-汽车             ");//电池龙头ETF           市值：1.16      累涨：35.37     16.39     7.10      11.88     10日：3.87      0.70                1.39      17        累涨修正：39.94     净值区间：93      94      90      87      91      18
        KEJI_NEW_CAR.put("159755", "科技-汽车             ");//电池ETF               市值：37.51     累涨：34.75     15.46     7.87      11.42     10日：3.87      0.42      0.14      1.70      16        累涨修正：39.32     净值区间：95      96      98      98      99      19
        KEJI_NEW_CAR.put("516660", "科技-汽车             ");//新能源车ETF基金       市值：3.10      累涨：31.66     14.51     6.54      10.61     10日：4.04      1.17      0.65      1.68      22        累涨修正：38.17     净值区间：100     100     100     97      95      20
        KEJI_NEW_CAR.put("515700", "科技-汽车             ");//新能车ETF             市值：22.70     累涨：31.58     14.15     6.70      10.73     10日：4.35      0.96      0.48      1.67      23        累涨修正：37.85     净值区间：100     100     100     100     98      21
        KEJI_NEW_CAR.put("159757", "科技-汽车             ");//电池30ETF             市值：2.98      累涨：33.50     15.04     7.37      11.09     10日：3.82      0.52                1.55      25        累涨修正：37.84     净值区间：94      95      98      98      99      22
        KEJI_NEW_CAR.put("516390", "科技-汽车             ");//新能源汽车ETF         市值：3.17      累涨：31.85     14.09     6.99      10.77     10日：4.00      0.88      0.44      1.32      26        累涨修正：37.61     净值区间：94      95      98      98      95      23
        KEJI_NEW_CAR.put("515030", "科技-汽车             ");//新能源车ETF           市值：43.14     累涨：31.41     14.39     6.75      10.27     10日：4.01      0.96      0.56      1.67      27        累涨修正：37.5      净值区间：100     100     100     100     96      24
        KEJI_NEW_CAR.put("159775", "科技-汽车             ");//新能源车电池ETF       市值：0.55      累涨：32.50     13.95     7.25      11.30     10日：4.10      0.68                1.53      24        累涨修正：37.28     净值区间：100     100     98      98      99      25
        KEJI_NEW_CAR.put("159806", "科技-汽车             ");//新能源车ETF           市值：9.73      累涨：31.07     14.41     6.42      10.24     10日：3.85      1.09      0.54      1.65      28        累涨修正：37.09     净值区间：100     100     98      98      95      26
        KEJI_NEW_CAR.put("159637", "科技-汽车             ");//新能源车龙头ETF       市值：8.08      累涨：31.18     14.02     6.49      10.67     10日：3.71      0.96      0.48      1.77      31        累涨修正：36.81     净值区间：100     100     100     100     96      27
        KEJI_NEW_CAR.put("159872", "科技-汽车             ");//智能网联汽车ETF       市值：0.46      累涨：31.07     15.60     6.62      8.85      10日：3.02      1.10      0.77      0.88      32        累涨修正：36.73     净值区间：100     100     100     88      90      28
        KEJI_NEW_CAR.put("159824", "科技-汽车             ");//新能车ETF             市值：1.62      累涨：30.49     13.74     6.38      10.37     10日：4.20      0.96      0.48      1.66      33        累涨修正：36.61     净值区间：100     100     100     98      96      29
        KEJI_NEW_CAR.put("562260", "科技-汽车             ");//汽车配件ETF           市值：0.11      累涨：32.00     7.97      18.04     5.99      10日：2.39      0.74      0.74      0.00      37        累涨修正：36.61     净值区间：9       4       3       35      56      30
        KEJI_NEW_CAR.put("159840", "科技-汽车             ");//锂电池ETF             市值：9.15      累涨：32.43     14.61     7.23      10.59     10日：3.57      0.35                1.59      29        累涨修正：36.35     净值区间：100     100     100     100     100     31
        KEJI_NEW_CAR.put("159720", "科技-汽车             ");//智能车ETF泰康         市值：0.54      累涨：29.37     13.61     6.50      9.26      10日：3.94      1.09      0.62      1.25      35        累涨修正：35.64     净值区间：94      95      98      66      70      32
        KEJI_NEW_CAR.put("516380", "科技-汽车             ");//智能电动车ETF         市值：0.90      累涨：29.50     13.79     6.38      9.33      10日：3.70      1.05      0.66      1.17      36        累涨修正：35.57     净值区间：90      92      96      67      79      33
        KEJI_NEW_CAR.put("516110", "科技-汽车             ");//汽车ETF               市值：3.90      累涨：27.54     13.03     7.76      6.75      10日：2.96      1.33      1.33      0.77      34        累涨修正：34.49     净值区间：97      97      98      44      52      34
        KEJI_NEW_CAR.put("516590", "科技-汽车             ");//智能汽车ETF易方达     市值：0.90      累涨：29.41     14.22     6.03      9.16      10日：3.37      0.63      0.42      1.46      39        累涨修正：34.25     净值区间：87      88      95      71      74      35
        KEJI_NEW_CAR.put("159512", "科技-汽车             ");//汽车ETF               市值：0.56      累涨：26.33     10.60     8.48      7.25      10日：3.46      1.30      1.30      1.71      30        累涨修正：33.69     净值区间：98      98      99      53      55      36
        KEJI_NEW_CAR.put("159210", "科技-汽车             ");//港股汽车ETF           市值：1.29      累涨：                              11.58     10日：5.52      3.76      2.83      2.68      18        累涨修正：26.52     净值区间：98      99      99                      37
        KEJI_NEW_CAR.put("159239", "科技-汽车             ");//港股通汽车ETF富国     市值：1.16      累涨：                              12.09     10日：5.80      3.53      2.31      3.06      13        累涨修正：26.04     净值区间：97      98      98                      38
        KEJI_NEW_CAR.put("159237", "科技-汽车             ");//港股汽车ETF基金       市值：1.24      累涨：                                        10日：          4.14      3.34      2.79      38        累涨修正：10.82     净值区间：100                                     39
    }

    /**
     * 科技
     */
    public static Map<String, String> KEJI = new HashMap<>();

    static {
        KEJI.putAll(KEJI_HK);
        KEJI.putAll(KEJI_XIN_PIAN);
        KEJI.putAll(KEJI_TONG_XIN);
        KEJI.putAll(KEJI_RUAN_JIAN);
        KEJI.putAll(KEJI_GONG_YE);
        KEJI.putAll(KEJI_JUNGONG);
        KEJI.putAll(KEJI_NEW_ENERGY);
        KEJI.putAll(KEJI_NEW_CAR);
    }

    public static Map<String, String> TOP_KEJI = new HashMap<>();

    static {
        TOP_KEJI.putAll(TOP_KEJI_HK);
        TOP_KEJI.putAll(TOP_KEJI_XIN_PIAN);
        TOP_KEJI.putAll(TOP_KEJI_TONG_XIN);
        TOP_KEJI.putAll(TOP_KEJI_RUAN_JIAN);
        TOP_KEJI.putAll(TOP_KEJI_GONG_YE);
        TOP_KEJI.putAll(TOP_KEJI_JUNGONG);
        TOP_KEJI.putAll(TOP_KEJI_NEW_ENERGY);
        TOP_KEJI.putAll(TOP_KEJI_NEW_CAR);
    }

    /**
     * 指数
     */
    public static Map<String, String> TOP_INDEX_CN_NOT = new HashMap<>();
    static {
        TOP_INDEX_CN_NOT.put("513730", ContEtfTypeName.INDEX_CN_NOT);//东南亚科技ETF         市值：15.98     累涨：32.37     12.74     8.28      11.35     10日：7.14      5.13      1.28      -0.32     1         累涨修正：47.2      净值区间：42      77      80      85      85      1
        TOP_INDEX_CN_NOT.put("513880", ContEtfTypeName.INDEX_CN_NOT);//日经225ETF            市值：15.76     累涨：25.18     9.00      6.66      9.52      10日：4.66      3.79      3.14      1.45      3         累涨修正：39.91     净值区间：88      89      89      92      94      2
    }
    public static Map<String, String> INDEX_CN_NOT = new HashMap<>();
    static {
        INDEX_CN_NOT.put("513730", ContEtfTypeName.INDEX_CN_NOT);//东南亚科技ETF         市值：15.98     累涨：32.37     12.74     8.28      11.35     10日：7.14      5.13      1.28      -0.32     1         累涨修正：47.2      净值区间：42      77      80      85      85      1
        INDEX_CN_NOT.put("513880", ContEtfTypeName.INDEX_CN_NOT);//日经225ETF            市值：15.76     累涨：25.18     9.00      6.66      9.52      10日：4.66      3.79      3.14      1.45      3         累涨修正：39.91     净值区间：88      89      89      92      94      2
        INDEX_CN_NOT.put("513520", ContEtfTypeName.INDEX_CN_NOT);//日经ETF               市值：14.72     累涨：24.44     8.48      6.64      9.32      10日：4.67      3.80      3.20      1.74      4         累涨修正：39.31     净值区间：88      88      88      92      93      3
        INDEX_CN_NOT.put("159687", ContEtfTypeName.INDEX_CN_NOT);//亚太精选ETF           市值：5.44      累涨：25.43     9.42      7.19      8.82      10日：4.60      3.59      2.79      0.97      5         累涨修正：39.2      净值区间：88      90      66      76      82      4
        INDEX_CN_NOT.put("513000", ContEtfTypeName.INDEX_CN_NOT);//日经225ETF易方达      市值：13.46     累涨：24.14     8.58      6.43      9.13      10日：4.55      3.94      3.20      1.54      7         累涨修正：39.03     净值区间：89      90      90      92      94      5
        INDEX_CN_NOT.put("159561", ContEtfTypeName.INDEX_CN_NOT);//德国ETF               市值：15.75     累涨：29.54     12.08     7.07      10.39     10日：5.38      2.55      0.65      0.72      2         累涨修正：38.77     净值区间：74      81      78      89      92      6
        INDEX_CN_NOT.put("159866", ContEtfTypeName.INDEX_CN_NOT);//日经ETF               市值：7.04      累涨：23.29     7.71      6.47      9.11      10日：4.60      3.89      3.27      0.77      9         累涨修正：38.32     净值区间：79      81      81      86      88      7
        INDEX_CN_NOT.put("513030", ContEtfTypeName.INDEX_CN_NOT);//德国ETF               市值：15.07     累涨：28.85     13.95     6.08      8.82      10日：4.66      2.23      0.74      0.74      8         累涨修正：37.22     净值区间：78      82      71      85      89      8
        INDEX_CN_NOT.put("513080", ContEtfTypeName.INDEX_CN_NOT);//法国CAC40ETF          市值：8.83      累涨：24.61     8.90      5.42      10.29     10日：5.22      2.62      1.28      1.61      6         累涨修正：35.01     净值区间：89      91      94      95      96      9
        INDEX_CN_NOT.put("513800", ContEtfTypeName.INDEX_CN_NOT);//日本东证指数ETF       市值：7.66      累涨：19.98     7.71      5.40      6.87      10日：3.62      3.62      3.14      2.30      10        累涨修正：33.5      净值区间：99      99      99      99      99      10
        INDEX_CN_NOT.put("520580", ContEtfTypeName.INDEX_CN_NOT);//新兴亚洲ETF           市值：4.04      累涨：17.88     9.25      3.86      4.77      10日：3.07      2.37      1.08      -0.19     11        累涨修正：25.48     净值区间：44      67      67      80      55      11
        INDEX_CN_NOT.put("159329", ContEtfTypeName.INDEX_CN_NOT);//沙特ETF               市值：14.55     累涨：14.60     8.08      5.52      1.00      10日：0.40      0.10      0.10      0.20      12        累涨修正：15.3      净值区间：50      21      14      13      5       12
        INDEX_CN_NOT.put("520830", ContEtfTypeName.INDEX_CN_NOT);//沙特ETF               市值：11.36     累涨：11.90     6.26      3.97      1.67      10日：0.21      0.11                0.42      13        累涨修正：12.22     净值区间：88      37      28      23      8       13
    }

    public static Map<String, String> TOP_INDEX_CN_NOT_USA = new HashMap<>();
    static {
        TOP_INDEX_CN_NOT_USA.put("159509", ContEtfTypeName.INDEX_CN_NOT_USA);//纳指科技ETF           市值：113.84    累涨：40.62     16.36     9.11      15.15     10日：7.23      3.30      1.49      0.00      1         累涨修正：54.13     净值区间：62      83      90      93      95      1
    }
    public static Map<String, String> INDEX_CN_NOT_USA = new HashMap<>();
    static {
        INDEX_CN_NOT_USA.put("159509", ContEtfTypeName.INDEX_CN_NOT_USA);//纳指科技ETF           市值：113.84    累涨：40.62     16.36     9.11      15.15     10日：7.23      3.30      1.49      0.00      1         累涨修正：54.13     净值区间：62      83      90      93      95      1
        INDEX_CN_NOT_USA.put("513390", ContEtfTypeName.INDEX_CN_NOT_USA);//纳指100ETF            市值：32.87     累涨：29.67     13.80     9.10      6.77      10日：3.60      1.57      0.22      0.16      2         累涨修正：35.28     净值区间：66      84      88      94      97      2
        INDEX_CN_NOT_USA.put("159501", ContEtfTypeName.INDEX_CN_NOT_USA);//纳指ETF嘉实           市值：68.91     累涨：29.27     13.66     9.24      6.37      10日：3.52      1.49      0.19      0.19      3         累涨修正：34.66     净值区间：62      88      91      96      98      3
        INDEX_CN_NOT_USA.put("513110", ContEtfTypeName.INDEX_CN_NOT_USA);//纳斯达克100ETF        市值：34.08     累涨：28.94     13.42     9.20      6.32      10日：3.46      1.59      0.16      0.05      7         累涨修正：34.31     净值区间：50      86      89      95      98      4
        INDEX_CN_NOT_USA.put("159659", ContEtfTypeName.INDEX_CN_NOT_USA);//纳斯达克100ETF        市值：51.63     累涨：28.84     13.16     9.26      6.42      10日：3.41      1.58      0.22      0.17      4         累涨修正：34.27     净值区间：53      85      89      95      97      5
        INDEX_CN_NOT_USA.put("159941", ContEtfTypeName.INDEX_CN_NOT_USA);//纳指ETF               市值：271.29    累涨：28.71     13.54     8.62      6.55      10日：3.66      1.53      0.08      0.08      6         累涨修正：34.06     净值区间：50      85      88      94      97      6
        INDEX_CN_NOT_USA.put("159696", ContEtfTypeName.INDEX_CN_NOT_USA);//纳指ETF易方达         市值：28.29     累涨：29.21     13.71     9.26      6.24      10日：3.29      1.43      0.06      0.13      10        累涨修正：34.05     净值区间：46      84      88      95      97      7
        INDEX_CN_NOT_USA.put("513100", ContEtfTypeName.INDEX_CN_NOT_USA);//纳指ETF               市值：157.44    累涨：28.33     13.60     8.08      6.65      10日：3.61      1.52      0.06      0.18      5         累涨修正：33.58     净值区间：57      87      90      95      97      8
        INDEX_CN_NOT_USA.put("159632", ContEtfTypeName.INDEX_CN_NOT_USA);//纳斯达克ETF           市值：93.07     累涨：28.77     13.60     8.98      6.19      10日：3.28      1.33      0.05      0.11      17        累涨修正：33.48     净值区间：54      87      90      96      98      9
        INDEX_CN_NOT_USA.put("513870", ContEtfTypeName.INDEX_CN_NOT_USA);//纳指ETF富国           市值：14.46     累涨：28.56     13.36     8.84      6.36      10日：3.35      1.40      0.06      0.13      14        累涨修正：33.43     净值区间：58      88      91      96      98      10
        INDEX_CN_NOT_USA.put("513300", ContEtfTypeName.INDEX_CN_NOT_USA);//纳斯达克ETF           市值：95.38     累涨：28.10     12.56     8.93      6.61      10日：3.53      1.46      0.10      0.14      9         累涨修正：33.29     净值区间：56      87      90      96      98      11
        INDEX_CN_NOT_USA.put("159660", ContEtfTypeName.INDEX_CN_NOT_USA);//纳指100ETF            市值：27.87     累涨：27.88     12.25     9.30      6.33      10日：3.37      1.45      0.22      0.11      11        累涨修正：33.14     净值区间：54      88      90      96      98      12
        INDEX_CN_NOT_USA.put("159513", ContEtfTypeName.INDEX_CN_NOT_USA);//纳斯达克100指数ETF    市值：59.70     累涨：28.37     13.05     9.15      6.17      10日：3.28      1.30                0.29      18        累涨修正：32.95     净值区间：70      91      93      97      99      13
        INDEX_CN_NOT_USA.put("159577", ContEtfTypeName.INDEX_CN_NOT_USA);//美国50ETF             市值：7.36      累涨：27.42     12.39     8.44      6.59      10日：3.31      1.38      0.23      0.46      16        累涨修正：32.57     净值区间：75      91      94      97      98      14
        INDEX_CN_NOT_USA.put("513850", ContEtfTypeName.INDEX_CN_NOT_USA);//美国50ETF             市值：15.39     累涨：26.95     11.68     8.70      6.57      10日：3.33      1.45      0.14      0.48      13        累涨修正：32.01     净值区间：85      95      96      98      99      15
        INDEX_CN_NOT_USA.put("513400", ContEtfTypeName.INDEX_CN_NOT_USA);//道琼斯ETF             市值：14.82     累涨：22.42     8.85      5.47      8.10      10日：3.94      2.37      0.79      0.26      8         累涨修正：30.31     净值区间：76      84      90      95      97      16
        INDEX_CN_NOT_USA.put("513500", ContEtfTypeName.INDEX_CN_NOT_USA);//标普500ETF            市值：210.49    累涨：24.49     11.09     6.88      6.52      10日：3.35      1.69      0.37      0.42      12        累涨修正：30.27     净值区间：86      94      96      98      99      17
        INDEX_CN_NOT_USA.put("159655", ContEtfTypeName.INDEX_CN_NOT_USA);//标普ETF               市值：31.22     累涨：24.28     10.85     7.36      6.07      10日：3.33      1.72      0.37      0.36      19        累涨修正：30.07     净值区间：81      92      95      97      99      18
        INDEX_CN_NOT_USA.put("513650", ContEtfTypeName.INDEX_CN_NOT_USA);//标普500ETF南方        市值：33.73     累涨：24.09     11.04     7.49      5.56      10日：2.98      1.49      0.31      0.43      21        累涨修正：29.18     净值区间：81      92      95      97      99      19
        INDEX_CN_NOT_USA.put("159529", ContEtfTypeName.INDEX_CN_NOT_USA);//标普消费ETF           市值：8.89      累涨：26.07     13.56     6.69      5.82      10日：2.16      0.26      0.26      0.00      22        累涨修正：29.01     净值区间：26      18      13      36      50      20
        INDEX_CN_NOT_USA.put("159612", ContEtfTypeName.INDEX_CN_NOT_USA);//标普500ETF            市值：7.86      累涨：26.04     13.88     8.36      3.80      10日：0.82      0.71      0.55      -0.11     20        累涨修正：28.67     净值区间：38      24      13      22      52      21
        INDEX_CN_NOT_USA.put("562060", ContEtfTypeName.INDEX_CN_NOT_USA);//标普红利ETF           市值：16.69     累涨：19.71     6.25      6.55      6.91      10日：3.13      2.20      1.69      0.00      15        累涨修正：28.42     净值区间：71      74      86      90      93      22
    }

    public static Map<String, String> TOP_INDEX_CN_1000 = new HashMap<>();

    static {
        TOP_INDEX_CN_1000.put("159552", "指数-中小盘           ");//中证2000增强ETF       市值：1.38      累涨：55.44     24.20     17.55     13.69     10日：9.92      3.15      2.14      2.12      1         累涨修正：72.79     净值区间：98      99      99      100     100     1
    }

    public static Map<String, String> INDEX_CN_1000 = new HashMap<>();//指数-中小盘

    static {
        INDEX_CN_1000.put("159552", "指数-中小盘           ");//中证2000增强ETF       市值：1.38      累涨：55.44     24.20     17.55     13.69     10日：9.92      3.15      2.14      2.12      1         累涨修正：72.79     净值区间：98      99      99      100     100     1
        INDEX_CN_1000.put("159553", "指数-中小盘           ");//2000ETF增强           市值：0.14      累涨：44.59     19.96     12.45     12.18     10日：7.83      2.39      2.05      1.56      2         累涨修正：58.91     净值区间：66      77      85      89      94      2
        INDEX_CN_1000.put("562660", "指数-中小盘           ");//中证2000ETF华夏       市值：2.10      累涨：44.75     21.03     12.41     11.31     10日：7.19      1.71      1.50      1.93      4         累涨修正：56.65     净值区间：100     100     100     100     100     3
        INDEX_CN_1000.put("560220", "指数-中小盘           ");//中证2000ETF基金       市值：0.58      累涨：40.96     17.35     12.47     11.14     10日：7.51      2.32      1.76      1.51      3         累涨修正：54.31     净值区间：97      98      99      99      100     4
        INDEX_CN_1000.put("159543", "指数-中小盘           ");//国证2000ETF基金       市值：0.46      累涨：44.04     22.04     10.20     11.80     10日：6.67      1.21      1.12      1.67      9         累涨修正：54.16     净值区间：100     100     100     100     100     5
        INDEX_CN_1000.put("159531", "指数-中小盘           ");//中证2000ETF           市值：5.40      累涨：43.62     21.06     12.36     10.20     10日：6.69      1.29      1.03      1.46      7         累涨修正：53.66     净值区间：97      98      99      99      100     6
        INDEX_CN_1000.put("159555", "指数-中小盘           ");//2000增强ETF           市值：0.47      累涨：43.41     21.75     11.27     10.39     10日：7.14      1.12      0.97      1.42      10        累涨修正：53.61     净值区间：93      95      98      98      99      7
        INDEX_CN_1000.put("563200", "指数-中小盘           ");//中证2000ETF富国       市值：0.19      累涨：43.92     22.31     11.55     10.06     10日：6.70      1.23      0.74      1.39      8         累涨修正：53.33     净值区间：64      77      88      88      94      8
        INDEX_CN_1000.put("563300", "指数-中小盘           ");//中证2000ETF           市值：19.32     累涨：42.35     20.34     11.61     10.40     10日：6.57      1.48      1.13      1.65      6         累涨修正：52.66     净值区间：100     100     100     100     100     9
        INDEX_CN_1000.put("159533", "指数-中小盘           ");//中证2000ETF基金       市值：0.20      累涨：44.69     22.19     11.89     10.61     10日：6.23      0.55      0.55      1.03      24        累涨修正：52.57     净值区间：100     100     100     100     100     10
        INDEX_CN_1000.put("159532", "指数-中小盘           ");//中证2000ETF易方达     市值：0.56      累涨：40.51     17.93     11.44     11.14     10日：7.53      1.43      1.35      1.73      5         累涨修正：52.17     净值区间：97      98      99      99      100     11
        INDEX_CN_1000.put("561370", "指数-中小盘           ");//2000ETF               市值：0.10      累涨：42.32     22.00     9.65      10.67     10日：7.32      0.86      0.34      0.95      14        累涨修正：51.18     净值区间：59      75      85      87      93      12
        INDEX_CN_1000.put("159536", "指数-中小盘           ");//中证2000指数ETF       市值：0.53      累涨：39.33     19.99     10.32     9.02      10日：5.96      1.25      1.08      1.33      15        累涨修正：48.7      净值区间：100     100     100     70      82      13
        INDEX_CN_1000.put("159535", "指数-中小盘           ");//中证2000ETF嘉实       市值：0.17      累涨：39.13     20.07     10.23     8.83      10日：5.60      1.08      0.83      1.49      17        累涨修正：47.47     净值区间：97      98      99      99      100     14
        INDEX_CN_1000.put("159906", "指数-中小盘           ");//深成长龙头ETF         市值：1.14      累涨：37.15     17.35     10.77     9.03      10日：5.80      1.45      1.14      1.66      16        累涨修正：46.68     净值区间：95      98      98      99      99      15
        INDEX_CN_1000.put("159680", "指数-中小盘           ");//1000ETF增强           市值：4.55      累涨：36.81     18.30     8.63      9.88      10日：6.75      1.10      0.94      1.33      13        累涨修正：46.54     净值区间：92      96      98      98      99      16
        INDEX_CN_1000.put("561280", "指数-中小盘           ");//中证1000ETF增强       市值：0.42      累涨：35.75     16.68     8.50      10.57     10日：7.26      1.15      0.74      1.39      11        累涨修正：45.64     净值区间：94      97      98      99      99      17
        INDEX_CN_1000.put("159907", "指数-中小盘           ");//2000ETF               市值：1.86      累涨：36.30     17.39     9.77      9.14      10日：6.42      0.83      0.83      1.65      20        累涨修正：45.21     净值区间：20      31      48      51      62      18
        INDEX_CN_1000.put("159505", "指数-中小盘           ");//国证2000指数ETF       市值：0.12      累涨：35.55     17.43     8.64      9.48      10日：6.25      1.38      0.95      1.21      12        累涨修正：45.08     净值区间：97      98      99      99      99      19
        INDEX_CN_1000.put("159628", "指数-中小盘           ");//国证2000ETF           市值：8.06      累涨：35.11     16.50     9.71      8.90      10日：6.41      0.91      0.82      1.54      19        累涨修正：44.07     净值区间：100     100     100     100     100     20
        INDEX_CN_1000.put("561590", "指数-中小盘           ");//中证1000增强ETF       市值：0.33      累涨：33.11     16.20     7.80      9.11      10日：6.09      0.99      0.81      1.36      21        累涨修正：41.81     净值区间：96      98      99      99      99      21
        INDEX_CN_1000.put("561780", "指数-中小盘           ");//1000增强ETF           市值：0.08      累涨：33.54     16.16     8.01      9.37      10日：6.03      0.76      0.59      1.68      30        累涨修正：41.51     净值区间：100     100     100     100     100     22
        INDEX_CN_1000.put("562520", "指数-中小盘           ");//中证1000成长ETF       市值：0.44      累涨：31.92     16.38     8.09      7.45      10日：6.38      1.13      0.94      1.50      22        累涨修正：41.31     净值区间：96      97      98      99      99      23
        INDEX_CN_1000.put("159973", "指数-中小盘           ");//民企ETF               市值：2.83      累涨：28.40     12.36     6.96      9.08      10日：6.89      2.00      2.00      1.55      18        累涨修正：41.29     净值区间：81      89      92      46      62      24
        INDEX_CN_1000.put("159556", "指数-中小盘           ");//中证2000ETF增强       市值：0.29      累涨：33.78     19.16     6.95      7.67      10日：5.23      0.77      0.48      1.84      35        累涨修正：40.74     净值区间：96      97      99      99      99      25
        INDEX_CN_1000.put("159685", "指数-中小盘           ");//1000增强ETF天弘       市值：0.17      累涨：32.28     15.34     7.81      9.13      10日：5.91      0.99      0.63      1.08      23        累涨修正：40.44     净值区间：96      98      99      99      99      26
        INDEX_CN_1000.put("159629", "指数-中小盘           ");//1000ETF               市值：117.02    累涨：31.55     14.84     8.63      8.08      10日：5.98      0.86      0.74      1.35      27        累涨修正：39.87     净值区间：98      99      99      99      100     27
        INDEX_CN_1000.put("159521", "指数-中小盘           ");//国证2000ETF指数基金   市值：0.16      累涨：32.72     16.46     8.36      7.90      10日：5.10      0.77      0.58      0.96      37        累涨修正：39.75     净值区间：93      97      99      99      99      28
        INDEX_CN_1000.put("560010", "指数-中小盘           ");//中证1000ETF指数       市值：307.26    累涨：31.70     14.60     8.77      8.33      10日：5.95      0.85      0.58      1.39      26        累涨修正：39.66     净值区间：96      98      99      99      99      29
        INDEX_CN_1000.put("512100", "指数-中小盘           ");//中证1000ETF           市值：648.60    累涨：31.52     14.53     8.70      8.29      10日：5.84      0.82      0.55      1.41      29        累涨修正：39.28     净值区间：98      99      99      99      100     30
        INDEX_CN_1000.put("560110", "指数-中小盘           ");//中证1000ETF基金       市值：2.23      累涨：31.88     14.47     9.22      8.19      10日：5.40      0.54      0.33      1.40      40        累涨修正：38.48     净值区间：96      97      98      99      99      31
        INDEX_CN_1000.put("159633", "指数-中小盘           ");//中证1000ETF易方达     市值：17.38     累涨：31.00     14.58     8.54      7.88      10日：5.52      0.69      0.50      1.30      38        累涨修正：38.21     净值区间：94      97      98      98      99      32
        INDEX_CN_1000.put("159679", "指数-中小盘           ");//中证1000增强ETF       市值：0.94      累涨：30.28     14.54     7.90      7.84      10日：5.36      0.77      0.67      1.34      36        累涨修正：37.75     净值区间：95      97      98      99      99      33
        INDEX_CN_1000.put("560590", "指数-中小盘           ");//1000ETF增强           市值：0.09      累涨：31.59     14.62     9.81      7.16      10日：4.57      0.35      0.35      1.38      54        累涨修正：37.21     净值区间：92      95      98      98      99      34
        INDEX_CN_1000.put("516300", "指数-中小盘           ");//中证1000ETF华泰柏瑞   市值：0.77      累涨：29.86     13.30     8.57      7.99      10日：5.54      0.70      0.43      1.46      34        累涨修正：36.96     净值区间：98      99      99      99      100     35
        INDEX_CN_1000.put("560950", "指数-中小盘           ");//500ETF增强            市值：0.37      累涨：29.93     16.29     7.27      6.37      10日：4.57      1.01      0.64      1.10      45        累涨修正：36.79     净值区间：94      96      97      97      98      36
        INDEX_CN_1000.put("159902", "指数-中小盘           ");//中小100ETF            市值：3.99      累涨：26.79     11.25     6.74      8.80      10日：5.49      1.89      1.31      1.40      25        累涨修正：36.79     净值区间：86      92      95      95      97      37
        INDEX_CN_1000.put("159677", "指数-中小盘           ");//1000增强ETF           市值：0.41      累涨：28.50     14.14     6.58      7.78      10日：4.95      0.88      0.70      1.05      44        累涨修正：35.73     净值区间：100     100     100     100     100     38
        INDEX_CN_1000.put("159678", "指数-中小盘           ");//中证500增强ETF        市值：0.52      累涨：26.03     11.49     6.67      7.87      10日：5.68      1.46      0.73      1.28      28        累涨修正：34.63     净值区间：100     100     100     100     100     39
        INDEX_CN_1000.put("159620", "指数-中小盘           ");//500成长ETF            市值：0.33      累涨：27.63     11.47     6.48      9.68      10日：5.04      1.03      0.41      0.93      32        累涨修正：34.52     净值区间：71      88      81      61      71      40
        INDEX_CN_1000.put("515550", "指数-中小盘           ");//国联中证500ETF        市值：0.68      累涨：24.83     10.99     6.81      7.03      10日：5.37      1.38      1.30      0.61      33        累涨修正：34.18     净值区间：96      98      99      99      99      41
        INDEX_CN_1000.put("159610", "指数-中小盘           ");//500ETF增强            市值：4.25      累涨：24.54     10.71     6.00      7.83      10日：6.17      1.82      0.79      1.47      31        累涨修正：34.11     净值区间：96      98      98      99      99      42
        INDEX_CN_1000.put("159935", "指数-中小盘           ");//中证500ETF景顺        市值：0.59      累涨：26.37     11.54     7.31      7.52      10日：5.12      0.86      0.54      1.30      39        累涨修正：33.43     净值区间：91      97      97      98      98      43
        INDEX_CN_1000.put("510560", "指数-中小盘           ");//国寿500ETF            市值：1.81      累涨：24.69     10.25     6.74      7.70      10日：5.27      1.07      0.86      1.20      41        累涨修正：32.75     净值区间：89      95      97      61      69      44
        INDEX_CN_1000.put("510570", "指数-中小盘           ");//兴业中证500ETF        市值：0.22      累涨：25.61     12.35     6.75      6.51      10日：4.72      1.30      0.43      0.75      42        累涨修正：32.49     净值区间：88      90      93      76      78      45
        INDEX_CN_1000.put("560500", "指数-中小盘           ");//500质量成长ETF        市值：5.20      累涨：24.84     11.38     7.15      6.31      10日：4.75      1.22      0.71      1.22      46        累涨修正：32.23     净值区间：100     100     100     100     100     46
        INDEX_CN_1000.put("510580", "指数-中小盘           ");//中证500ETF易方达      市值：28.35     累涨：24.51     10.93     6.31      7.27      10日：5.57      0.91      0.54      1.37      43        累涨修正：32.07     净值区间：93      97      98      98      99      47
        INDEX_CN_1000.put("159606", "指数-中小盘           ");//中证500成长ETF        市值：4.09      累涨：24.14     10.97     6.58      6.59      10日：5.17      1.27      0.74      1.17      48        累涨修正：32.06     净值区间：83      91      94      96      97      48
        INDEX_CN_1000.put("159820", "指数-中小盘           ");//中证500ETF天弘        市值：20.78     累涨：24.60     11.29     6.08      7.23      10日：5.35      0.80      0.60      1.31      50        累涨修正：31.95     净值区间：94      97      98      99      99      49
        INDEX_CN_1000.put("561550", "指数-中小盘           ");//500增强ETF            市值：7.20      累涨：24.81     10.23     6.77      7.81      10日：5.35      0.82      0.41      1.54      49        累涨修正：31.8      净值区间：89      95      97      98      98      50
        INDEX_CN_1000.put("510550", "指数-中小盘           ");//方正中证500ETF        市值：0.27      累涨：24.98     11.67     6.58      6.73      10日：4.72      0.87      0.60      1.28      52        累涨修正：31.77     净值区间：88      96      97      88      92      51
        INDEX_CN_1000.put("159379", "指数-中小盘           ");//A500ETF融通           市值：3.30      累涨：21.32     8.09      5.84      7.39      10日：5.42      1.81      1.52      -0.09     47        累涨修正：31.59     净值区间：89      94      96      96      98      52
        INDEX_CN_1000.put("159922", "指数-中小盘           ");//中证500ETF            市值：104.73    累涨：24.74     10.53     6.87      7.34      10日：5.29      0.67      0.42      1.35      59        累涨修正：31.54     净值区间：94      97      98      98      99      53
        INDEX_CN_1000.put("561350", "指数-中小盘           ");//国泰中证500ETF        市值：0.95      累涨：24.13     10.64     6.37      7.12      10日：5.24      0.85      0.64      1.39      53        累涨修正：31.5      净值区间：95      97      98      98      99      54
        INDEX_CN_1000.put("517010", "指数-中小盘           ");//沪港深500ETF易方达    市值：0.75      累涨：25.79     11.86     6.75      7.18      10日：3.98      1.11      0.30      0.30      51        累涨修正：31.48     净值区间：64      68      88      88      93      55
        INDEX_CN_1000.put("512510", "指数-中小盘           ");//中证500ETF华泰柏瑞    市值：9.83      累涨：24.72     11.02     6.66      7.04      10日：5.14      0.77      0.36      1.36      55        累涨修正：31.35     净值区间：94      97      98      98      99      56
        INDEX_CN_1000.put("510500", "指数-中小盘           ");//中证500ETF            市值：1139.10   累涨：24.23     10.71     6.27      7.25      10日：5.48      0.72      0.40      1.34      56        累涨修正：31.23     净值区间：93      97      98      98      99      57
        INDEX_CN_1000.put("510590", "指数-中小盘           ");//中证500ETF平安        市值：5.56      累涨：24.08     11.19     5.99      6.90      10日：5.11      0.68      0.65      1.76      64        累涨修正：31.17     净值区间：96      98      99      99      99      58
        INDEX_CN_1000.put("510510", "指数-中小盘           ");//中证500ETF基金        市值：18.91     累涨：24.07     10.76     6.09      7.22      10日：5.33      0.76      0.38      1.50      58        累涨修正：30.92     净值区间：94      97      98      98      99      59
        INDEX_CN_1000.put("515190", "指数-中小盘           ");//中银证券500ETF        市值：0.88      累涨：25.38     12.13     7.53      5.72      10日：4.44      0.33      0.33      1.40      25        累涨修正：30.81     净值区间：100     100     100     100     100     60
        INDEX_CN_1000.put("159337", "指数-中小盘           ");//中证500ETF基金        市值：15.08     累涨：23.92     10.83     5.97      7.12      10日：5.22      0.69      0.46      1.29      63        累涨修正：30.75     净值区间：96      98      99      99      99      61
        INDEX_CN_1000.put("512500", "指数-中小盘           ");//中证500ETF华夏        市值：139.63    累涨：24.00     10.64     6.19      7.17      10日：5.46      0.62      0.31      1.44      61        累涨修正：30.7      净值区间：95      98      99      99      99      62
        INDEX_CN_1000.put("562340", "指数-中小盘           ");//中证500成长ETF        市值：0.12      累涨：22.56     10.86     6.07      5.63      10日：4.28      1.79      0.94      1.13      62        累涨修正：30.51     净值区间：89      95      96      89      93      63
        INDEX_CN_1000.put("159968", "指数-中小盘           ");//中证500ETF博时        市值：6.72      累涨：23.80     10.71     6.04      7.05      10日：5.17      0.63      0.32      1.36      65        累涨修正：30.24     净值区间：92      96      97      97      98      64
        INDEX_CN_1000.put("159982", "指数-中小盘           ");//中证500ETF鹏华        市值：2.87      累涨：22.93     9.62      6.23      7.08      10日：5.17      0.86      0.53      1.25      57        累涨修正：30.02     净值区间：93      97      98      98      99      65
        INDEX_CN_1000.put("561950", "指数-中小盘           ");//500指数增强ETF        市值：0.83      累涨：24.09     10.97     6.11      7.01      10日：4.78      0.54      0.27      1.26      67        累涨修正：29.95     净值区间：89      98      98      98      99      66
        INDEX_CN_1000.put("515530", "指数-中小盘           ");//中证500ETF泰康        市值：0.81      累涨：23.40     10.62     5.96      6.82      10日：4.97      0.69      0.41      1.23      70        累涨修正：29.88     净值区间：90      96      97      97      98      67
        INDEX_CN_1000.put("510530", "指数-中小盘           ");//中证500ETF工银        市值：3.50      累涨：22.13     9.07      6.30      6.76      10日：4.90      0.59      0.48      1.43      72        累涨修正：28.58     净值区间：95      98      98      99      99      68
        INDEX_CN_1000.put("517100", "指数-中小盘           ");//AH500ETF              市值：2.95      累涨：24.15     10.87     7.15      6.13      10日：3.16      0.44      0.22      0.67      81        累涨修正：28.19     净值区间：91      93      98      98      99      69
        INDEX_CN_1000.put("562530", "指数-中小盘           ");//中证1000价值ETF       市值：0.52      累涨：20.00     7.91      6.16      5.93      10日：4.63      2.03      0.76      0.25      60        累涨修正：28.18     净值区间：86      94      96      96      97      70
        INDEX_CN_1000.put("159800", "指数-中小盘           ");//中证800ETF            市值：0.46      累涨：19.44     7.33      3.94      8.17      10日：6.41      0.77      0.68      0.59      68        累涨修正：27.98     净值区间：84      67      78      84      88      71
        INDEX_CN_1000.put("515590", "指数-中小盘           ");//500等权ETF            市值：0.51      累涨：22.22     11.17     4.84      6.21      10日：4.75      0.40      0.27      1.42      84        累涨修正：27.91     净值区间：100     89      91      58      72      72
        INDEX_CN_1000.put("560030", "指数-中小盘           ");//800价值ETF            市值：0.31      累涨：18.83     6.73      4.71      7.39      10日：4.55      2.18      1.04      0.24      66        累涨修正：27.64     净值区间：89      95      95      75      80      73
        INDEX_CN_1000.put("560100", "指数-中小盘           ");//中证500增强ETF        市值：0.77      累涨：21.13     9.47      5.63      6.03      10日：4.90      0.80      0.40      1.20      69        累涨修正：27.63     净值区间：90      96      97      97      98      74
        INDEX_CN_1000.put("517000", "指数-中小盘           ");//沪港深500ETF          市值：3.60      累涨：23.73     10.98     7.27      5.48      10日：3.07      0.45                0.79      88        累涨修正：27.25     净值区间：94      94      97      98      99      75
        INDEX_CN_1000.put("159351", "指数-中小盘           ");//A500ETF嘉实           市值：147.26    累涨：19.87     7.99      5.49      6.39      10日：4.62      0.81      0.81      0.91      71        累涨修正：26.92     净值区间：71      82      88      89      93      76
        INDEX_CN_1000.put("562330", "指数-中小盘           ");//中证500价值ETF        市值：0.14      累涨：18.88     7.53      5.57      5.78      10日：4.15      2.21      0.80      0.79      75        累涨修正：26.84     净值区间：100     67      70      70      77      77
        INDEX_CN_1000.put("159358", "指数-中小盘           ");//中证A500ETF基金       市值：24.35     累涨：19.18     7.86      5.09      6.23      10日：4.53      0.97      0.87      1.26      73        累涨修正：26.42     净值区间：90      94      96      96      98      78
        INDEX_CN_1000.put("512050", "指数-中小盘           ");//A500ETF基金           市值：152.34    累涨：19.03     7.67      5.12      6.24      10日：4.63      0.93      0.83      1.03      74        累涨修正：26.25     净值区间：85      90      94      94      96      79
        INDEX_CN_1000.put("563800", "指数-中小盘           ");//中证A500ETF龙头       市值：173.71    累涨：18.64     7.74      4.89      6.01      10日：4.72      1.03      0.93      1.14      76        累涨修正：26.25     净值区间：84      90      94      94      97      80
        INDEX_CN_1000.put("159376", "指数-中小盘           ");//A500ETF指数基金       市值：3.28      累涨：18.71     7.89      4.65      6.17      10日：4.51      0.95      0.95      0.85      79        累涨修正：26.07     净值区间：81      92      93      93      96      81
        INDEX_CN_1000.put("159386", "指数-中小盘           ");//A500ETF永赢           市值：2.73      累涨：19.28     8.02      4.85      6.41      10日：4.29      0.89      0.79      0.88      77        累涨修正：26.04     净值区间：80      94      94      94      96      82
        INDEX_CN_1000.put("515800", "指数-中小盘           ");//800ETF                市值：49.70     累涨：18.98     7.57      5.19      6.22      10日：4.32      0.97      0.87      0.96      78        累涨修正：26.01     净值区间：90      95      96      97      98      83
        INDEX_CN_1000.put("563360", "指数-中小盘           ");//A500ETF华泰柏瑞       市值：199.07    累涨：19.12     7.95      5.22      5.95      10日：4.45      0.78      0.78      1.17      82        累涨修正：25.91     净值区间：85      90      94      94      97      84
        INDEX_CN_1000.put("563880", "指数-中小盘           ");//中证A500指数ETF       市值：52.02     累涨：18.95     7.71      5.14      6.10      10日：4.46      0.80      0.80      1.10      85        累涨修正：25.81     净值区间：85      90      94      94      97      85
        INDEX_CN_1000.put("517080", "指数-中小盘           ");//沪港深500ETF基金      市值：3.84      累涨：22.66     11.20     6.07      5.39      10日：2.98      0.11                0.80      101       累涨修正：25.75     净值区间：82      77      91      93      97      86
        INDEX_CN_1000.put("159215", "指数-中小盘           ");//中证A500ETF指数基金   市值：18.63     累涨：18.54     7.84      4.63      6.07      10日：4.47      0.98      0.88      0.98      80        累涨修正：25.75     净值区间：84      91      94      94      97      87
        INDEX_CN_1000.put("515810", "指数-中小盘           ");//中证800ETF            市值：2.63      累涨：18.72     7.52      5.29      5.91      10日：4.36      0.90      0.75      0.82      83        累涨修正：25.48     净值区间：78      79      86      87      92      88
        INDEX_CN_1000.put("560610", "指数-中小盘           ");//A500指数ETF           市值：83.52     累涨：18.97     7.75      5.21      6.01      10日：4.19      0.82      0.72      1.03      86        累涨修正：25.42     净值区间：80      87      92      92      95      89
        INDEX_CN_1000.put("159352", "指数-中小盘           ");//中证A500ETF南方       市值：164.46    累涨：18.59     7.87      5.04      5.68      10日：4.38      0.78      0.78      0.88      90        累涨修正：25.31     净值区间：80      88      92      93      95      90
        INDEX_CN_1000.put("512080", "指数-中小盘           ");//A500ETF中金           市值：13.24     累涨：18.54     8.12      4.63      5.79      10日：4.30      0.87      0.77      1.05      87        累涨修正：25.25     净值区间：85      94      83      77      81      91
        INDEX_CN_1000.put("560750", "指数-中小盘           ");//A500ETF申万菱信       市值：0.99      累涨：19.14     8.20      4.90      6.04      10日：4.07      0.67      0.67      0.86      99        累涨修正：25.22     净值区间：83      91      93      93      96      92
        INDEX_CN_1000.put("159380", "指数-中小盘           ");//A500ETF东财           市值：9.26      累涨：18.99     7.97      5.05      5.97      10日：4.12      0.66      0.66      1.13      100       累涨修正：25.09     净值区间：87      92      93      93      95      93
        INDEX_CN_1000.put("159361", "指数-中小盘           ");//A500ETF易方达         市值：140.10    累涨：18.73     7.83      4.89      6.01      10日：4.22      0.71      0.71      1.11      95        累涨修正：25.08     净值区间：85      91      94      94      97      94
        INDEX_CN_1000.put("563650", "指数-中小盘           ");//中证A500龙头ETF       市值：2.06      累涨：18.74     8.19      4.65      5.90      10日：3.98      0.78      0.78      0.88      94        累涨修正：25.06     净值区间：75      85      90      90      94      95
        INDEX_CN_1000.put("563220", "指数-中小盘           ");//中证A500ETF富国       市值：130.28    累涨：18.53     7.66      5.20      5.67      10日：4.34      0.70      0.70      1.09      102       累涨修正：24.97     净值区间：85      91      94      94      97      96
        INDEX_CN_1000.put("159360", "指数-中小盘           ");//中证A500ETF天弘       市值：28.57     累涨：18.44     7.79      5.11      5.54      10日：4.34      0.78      0.68      0.97      92        累涨修正：24.92     净值区间：84      91      94      94      97      97
        INDEX_CN_1000.put("159355", "指数-中小盘           ");//800红利低波ETF        市值：2.03      累涨：16.43     6.11      4.59      5.73      10日：3.61      2.37      1.22      0.00      91        累涨修正：24.85     净值区间：95      97      97      98      99      98
        INDEX_CN_1000.put("159357", "指数-中小盘           ");//中证A500指数ETF       市值：34.66     累涨：18.35     7.33      5.12      5.90      10日：4.39      0.69      0.69      0.98      105       累涨修正：24.81     净值区间：79      88      92      92      96      99
        INDEX_CN_1000.put("159359", "指数-中小盘           ");//中证A500ETF华安       市值：23.01     累涨：18.40     7.96      4.94      5.50      10日：3.99      0.79      0.79      0.98      103       累涨修正：24.76     净值区间：80      88      92      92      96      100
        INDEX_CN_1000.put("159356", "指数-中小盘           ");//A500ETF基金           市值：43.26     累涨：18.81     8.15      5.30      5.36      10日：3.83      0.70      0.70      0.99      107       累涨修正：24.74     净值区间：84      89      93      93      96      101
        INDEX_CN_1000.put("159353", "指数-中小盘           ");//中证A500ETF景顺       市值：112.99    累涨：18.47     7.79      5.19      5.49      10日：4.14      0.71      0.71      1.02      106       累涨修正：24.74     净值区间：75      84      90      90      94      102
        INDEX_CN_1000.put("512020", "指数-中小盘           ");//A500ETF指数           市值：34.52     累涨：18.32     7.73      4.82      5.77      10日：4.07      0.78      0.78      0.97      108       累涨修正：24.73     净值区间：80      88      93      93      96      103
        INDEX_CN_1000.put("159362", "指数-中小盘           ");//A500ETF工银           市值：22.00     累涨：18.31     7.82      4.97      5.52      10日：4.00      0.79      0.79      0.88      104       累涨修正：24.68     净值区间：80      87      92      93      96      104
        INDEX_CN_1000.put("560530", "指数-中小盘           ");//XD中证A500ETF摩根     市值：71.96     累涨：17.89     7.42      4.95      5.52      10日：4.18      0.90      0.80      0.91      93        累涨修正：24.57     净值区间：45      64      77      77      86      105
        INDEX_CN_1000.put("563660", "指数-中小盘           ");//A500ETF银河           市值：2.55      累涨：18.67     7.72      4.99      5.96      10日：3.92      0.79      0.59      1.09      97        累涨修正：24.56     净值区间：89      94      96      96      98      106
        INDEX_CN_1000.put("159339", "指数-中小盘           ");//A500ETF               市值：57.61     累涨：18.55     7.78      5.04      5.73      10日：4.05      0.71      0.61      1.02      109       累涨修正：24.53     净值区间：84      90      94      94      96      107
        INDEX_CN_1000.put("563500", "指数-中小盘           ");//中证A500ETF华宝       市值：12.96     累涨：18.46     7.80      4.80      5.86      10日：4.16      0.78      0.49      0.97      98        累涨修正：24.38     净值区间：80      89      93      93      96      108
        INDEX_CN_1000.put("560510", "指数-中小盘           ");//中证A500ETF           市值：61.81     累涨：17.91     7.42      4.99      5.50      10日：4.00      0.73      0.73      0.93      112       累涨修正：24.1      净值区间：79      87      92      92      95      109
        INDEX_CN_1000.put("563860", "指数-中小盘           ");//A500ETF海富通         市值：8.95      累涨：17.80     7.25      4.74      5.81      10日：4.19      0.69      0.69      1.08      113       累涨修正：24.06     净值区间：89      94      96      96      98      110
        INDEX_CN_1000.put("159338", "指数-中小盘           ");//中证A500ETF           市值：181.02    累涨：18.03     7.04      5.32      5.67      10日：4.08      0.62      0.62      1.13      111       累涨修正：23.97     净值区间：85      91      94      94      96      111
        INDEX_CN_1000.put("512260", "指数-中小盘           ");//中证500低波动ETF      市值：0.59      累涨：18.04     7.39      5.17      5.48      10日：3.57      0.71      0.52      0.83      114       累涨修正：23.36     净值区间：96      99      99      99      99      112
        INDEX_CN_1000.put("159617", "指数-中小盘           ");//500价值ETF            市值：0.36      累涨：16.55     6.19      5.46      4.90      10日：3.59      1.56      0.69      0.69      89        累涨修正：23.08     净值区间：92      95      98      82      82      113
        INDEX_CN_1000.put("159517", "指数-中小盘           ");//800增强ETF            市值：0.16      累涨：16.24     6.47      4.96      4.81      10日：3.61      0.73      0.55      0.73      115       累涨修正：21.68     净值区间：28      41      56      56      69      114
        INDEX_CN_1000.put("159226", "指数-中小盘           ");//中证A500增强ETF       市值：0.99      累涨：                              5.98      10日：4.28      0.89      0.79      0.98      96        累涨修正：12.73     净值区间：83      89      93                      115
        INDEX_CN_1000.put("563550", "指数-中小盘           ");//A500增强ETF摩根       市值：2.45      累涨：                              4.81      10日：3.71      1.09      0.69      0.49      110       累涨修正：10.99     净值区间：84      91      94                      116
        INDEX_CN_1000.put("159845", "指数-中小盘           ");//中证1000ETF           市值：383.61    累涨：                                        10日：                              1.39      116       累涨修正：0         净值区间：98      99      99      99      100     117
        INDEX_CN_1000.put("563030", "指数-中小盘           ");//中证500增强ETF易方达  市值：1.27      累涨：                                        10日：                              1.30      117       累涨修正：0         净值区间：100     100     100     100     100     118
        INDEX_CN_1000.put("159249", "指数-中小盘           ");//A500增强ETF工银       市值：1.22      累涨：                                        10日：                    0.70      0.70                累涨修正：          净值区间：71                                      119
        INDEX_CN_1000.put("563680", "指数-中小盘           ");//800自由现金流ETF      市值：0.28      累涨：                                        10日：                              0.29                累涨修正：          净值区间：                                        120
        INDEX_CN_1000.put("563630", "指数-中小盘           ");//A500增强ETF           市值：1.05      累涨：                                        10日：          0.60      0.60      0.90                累涨修正：          净值区间：75                                      121
        INDEX_CN_1000.put("159240", "指数-中小盘           ");//中证A500增强ETF天弘   市值：0.31      累涨：                                        10日：3.76      0.98      0.98      1.08                累涨修正：          净值区间：88      93                              122
        INDEX_CN_1000.put("563990", "指数-中小盘           ");//800现金流ETF          市值：0.60      累涨：                                        10日：                              0.57                累涨修正：          净值区间：                                        123
        INDEX_CN_1000.put("516460", "指数-中小盘           ");//现金流ETF800          市值：0.14      累涨：                                        10日：                              0.19                累涨修正：          净值区间：                                        124
        INDEX_CN_1000.put("561090", "指数-中小盘           ");//中证A500增强ETF       市值：1.31      累涨：                                        10日：                    0.50      0.70                累涨修正：          净值区间：87                                      125
    }

    public static Map<String, String> TOP_INDEX_300 = new HashMap<>();
    static {
        TOP_INDEX_300.put("159367", ContEtfTypeName.INDEX_300);//创业板50ETF华夏       市值：0.51      累涨：41.33     13.49     13.93     13.91     10日：7.46      4.09      1.46      0.82      1         累涨修正：55.8      净值区间：94      97      98      99      99      1
    }
    public static Map<String, String> INDEX_300 = new HashMap<>();
    static {
        INDEX_300.put("159367", ContEtfTypeName.INDEX_300);//创业板50ETF华夏       市值：0.51      累涨：41.33     13.49     13.93     13.91     10日：7.46      4.09      1.46      0.82      1         累涨修正：55.8      净值区间：94      97      98      99      99      1
        INDEX_300.put("159370", ContEtfTypeName.INDEX_300);//创50ETF工银           市值：0.87      累涨：41.22     12.67     14.57     13.98     10日：7.08      3.85      1.68      1.14      2         累涨修正：55.51     净值区间：100     100     100     100     100     2
        INDEX_300.put("159373", ContEtfTypeName.INDEX_300);//创业板50ETF嘉实       市值：3.58      累涨：40.46     13.00     13.62     13.84     10日：7.02      3.78      1.36      0.99      3         累涨修正：53.98     净值区间：97      99      99      99      100     3
        INDEX_300.put("159949", ContEtfTypeName.INDEX_300);//创业板50ETF           市值：252.61    累涨：41.03     13.04     14.18     13.81     10日：6.78      3.64      1.26      1.44      5         累涨修正：53.97     净值区间：100     100     100     100     100     4
        INDEX_300.put("159383", ContEtfTypeName.INDEX_300);//创业板50ETF华泰柏瑞   市值：0.87      累涨：40.47     13.31     13.37     13.79     10日：6.86      3.71      1.31      1.49      4         累涨修正：53.66     净值区间：100     100     100     100     100     5
        INDEX_300.put("159375", ContEtfTypeName.INDEX_300);//创业板50ETF国泰       市值：2.04      累涨：39.85     12.81     13.18     13.86     10日：7.03      3.72      1.48      1.13      6         累涨修正：53.56     净值区间：100     100     100     100     100     6
        INDEX_300.put("159371", ContEtfTypeName.INDEX_300);//创50ETF富国           市值：0.27      累涨：40.58     15.12     12.18     13.28     10日：6.77      3.57      1.20      1.10      11        累涨修正：53.32     净值区间：100     100     61      70      73      7
        INDEX_300.put("159682", ContEtfTypeName.INDEX_300);//创业50ETF             市值：43.43     累涨：40.29     12.98     14.04     13.27     10日：6.67      3.64      1.30      1.38      7         累涨修正：53.2      净值区间：100     100     100     100     100     8
        INDEX_300.put("159597", ContEtfTypeName.INDEX_300);//创业板成长ETF易方达   市值：0.96      累涨：42.11     12.43     16.27     13.41     10日：6.54      3.17      0.44      1.40      9         累涨修正：52.7      净值区间：100     100     100     100     100     9
        INDEX_300.put("159991", ContEtfTypeName.INDEX_300);//创大盘ETF             市值：1.22      累涨：40.05     11.80     14.68     13.57     10日：7.04      3.57      0.97      1.74      8         累涨修正：52.6      净值区间：100     100     100     100     100     10
        INDEX_300.put("159814", ContEtfTypeName.INDEX_300);//创业大盘ETF           市值：5.74      累涨：39.62     11.71     15.53     12.38     10日：6.62      3.14      0.66      1.54      13        累涨修正：50.7      净值区间：100     100     100     100     100     11
        INDEX_300.put("159915", ContEtfTypeName.INDEX_300);//创业板ETF             市值：880.56    累涨：36.97     11.19     13.26     12.52     10日：6.35      3.72      1.64      1.66      10        累涨修正：50.32     净值区间：100     100     100     100     100     12
        INDEX_300.put("159952", ContEtfTypeName.INDEX_300);//创业板ETF广发         市值：106.52    累涨：36.74     11.00     12.84     12.90     10日：6.69      3.67      1.45      1.50      12        累涨修正：50        净值区间：91      95      97      98      98      13
        INDEX_300.put("159956", ContEtfTypeName.INDEX_300);//创业板ETF建信         市值：1.20      累涨：36.55     11.08     13.35     12.12     10日：6.24      3.57      1.59      1.37      16        累涨修正：49.54     净值区间：100     100     100     100     100     14
        INDEX_300.put("159773", ContEtfTypeName.INDEX_300);//创业板科技ETF         市值：1.94      累涨：36.73     9.65      13.66     13.42     10日：6.39      3.28      1.56      1.29      2         累涨修正：49.52     净值区间：96      98      99      99      99      15
        INDEX_300.put("159957", ContEtfTypeName.INDEX_300);//创业板ETF华夏         市值：17.90     累涨：36.30     10.96     12.94     12.40     10日：6.30      3.65      1.54      1.46      14        累涨修正：49.33     净值区间：100     100     100     100     100     16
        INDEX_300.put("159977", ContEtfTypeName.INDEX_300);//创业板ETF天弘         市值：87.67     累涨：36.20     10.92     12.90     12.38     10日：6.27      3.68      1.48      1.50      15        累涨修正：49.11     净值区间：100     100     100     100     100     17
        INDEX_300.put("159808", ContEtfTypeName.INDEX_300);//创100ETF融通          市值：1.00      累涨：35.89     10.94     12.79     12.16     10日：6.12      3.49      1.61      1.82      24        累涨修正：48.72     净值区间：100     100     100     100     100     18
        INDEX_300.put("159971", ContEtfTypeName.INDEX_300);//创业板ETF富国         市值：25.03     累涨：36.02     10.93     12.79     12.30     10日：6.20      3.57      1.45      1.81      18        累涨修正：48.69     净值区间：100     100     100     100     100     19
        INDEX_300.put("159958", ContEtfTypeName.INDEX_300);//创业板ETF工银         市值：4.58      累涨：35.87     11.01     12.86     12.00     10日：6.08      3.67      1.52      1.29      17        累涨修正：48.66     净值区间：96      98      99      99      99      20
        INDEX_300.put("159948", ContEtfTypeName.INDEX_300);//创业板ETF南方         市值：47.90     累涨：35.82     10.93     12.73     12.16     10日：6.06      3.62      1.55      1.65      21        累涨修正：48.6      净值区间：100     100     100     100     100     21
        INDEX_300.put("159964", ContEtfTypeName.INDEX_300);//创业板ETF平安         市值：5.04      累涨：35.69     10.94     12.47     12.28     10日：6.13      3.61      1.54      1.40      19        累涨修正：48.51     净值区间：96      98      99      99      99      22
        INDEX_300.put("159908", ContEtfTypeName.INDEX_300);//创业板ETF博时         市值：15.72     累涨：35.15     10.81     12.70     11.64     10日：6.38      3.63      1.56      1.49      20        累涨修正：48.28     净值区间：100     100     100     100     100     23
        INDEX_300.put("159810", ContEtfTypeName.INDEX_300);//创业板ETF浦银         市值：0.81      累涨：35.58     11.25     12.95     11.38     10日：5.79      3.53      1.53      1.29      23        累涨修正：47.96     净值区间：97      99      99      99      99      24
        INDEX_300.put("159368", ContEtfTypeName.INDEX_300);//创业板新能源ETF华夏   市值：0.85      累涨：35.48     11.43     12.62     11.43     10日：5.04      3.17      2.03      1.30      21        累涨修正：47.75     净值区间：95      96      98      99      99      25
        INDEX_300.put("159821", ContEtfTypeName.INDEX_300);//BOCI创业板ETF         市值：0.21      累涨：34.64     9.78      12.26     12.60     10日：6.33      3.29      1.39      1.27      25        累涨修正：47.04     净值区间：100     100     100     100     100     26
        INDEX_300.put("159967", ContEtfTypeName.INDEX_300);//创业板成长ETF         市值：40.51     累涨：36.93     10.74     16.05     10.14     10日：5.21      2.58      0.85      1.48      30        累涨修正：46.42     净值区间：100     100     100     100     100     27
        INDEX_300.put("159377", ContEtfTypeName.INDEX_300);//创业板医药ETF国泰     市值：0.26      累涨：34.65     10.09     12.90     11.66     10日：6.64      2.79      0.94      3.85      50        累涨修正：45.96     净值区间：96      97      98      98      99      28
        INDEX_300.put("159836", ContEtfTypeName.INDEX_300);//创业板300ETF天弘      市值：1.72      累涨：34.96     10.47     14.16     10.33     10日：5.12      3.16      1.11      1.32      31        累涨修正：45.46     净值区间：100     100     100     100     100     29
        INDEX_300.put("159676", ContEtfTypeName.INDEX_300);//创业板增强ETF富国     市值：2.20      累涨：34.46     10.35     13.20     10.91     10日：5.40      2.61      1.20      1.28      37        累涨修正：44.87     净值区间：100     100     100     100     100     30
        INDEX_300.put("159675", ContEtfTypeName.INDEX_300);//创业板增强ETF         市值：1.35      累涨：33.90     10.46     12.39     11.05     10日：5.08      3.22      1.27      1.47      39        累涨修正：44.74     净值区间：100     100     100     100     100     31
        INDEX_300.put("159563", ContEtfTypeName.INDEX_300);//创业板综ETF华夏       市值：0.43      累涨：33.94     11.49     12.96     9.49      10日：4.40      3.03      1.47      1.04      32        累涨修正：44.31     净值区间：100     100     100     100     100     32
        INDEX_300.put("159572", ContEtfTypeName.INDEX_300);//创业板200ETF易方达    市值：8.15      累涨：37.23     12.80     16.24     8.19      10日：3.81      1.97      0.39      1.25      27        累涨修正：43.79     净值区间：100     100     100     100     100     33
        INDEX_300.put("159571", ContEtfTypeName.INDEX_300);//创业板200ETF富国      市值：0.52      累涨：36.39     12.14     16.32     7.93      10日：3.61      1.95      0.70      0.92      28        累涨修正：43.35     净值区间：100     100     100     100     100     34
        INDEX_300.put("588350", ContEtfTypeName.INDEX_300);//双创50ETF基金         市值：15.50     累涨：30.42     7.90      10.30     12.22     10日：6.84      3.41      1.30      0.97      26        累涨修正：43.27     净值区间：100     100     100     100     100     35
        INDEX_300.put("159573", ContEtfTypeName.INDEX_300);//创业板200ETF华夏      市值：2.02      累涨：36.55     12.60     16.32     7.63      10日：3.49      1.73      0.55      1.41      29        累涨修正：42.87     净值区间：100     100     100     100     100     36
        INDEX_300.put("159541", ContEtfTypeName.INDEX_300);//创业板综ETF万家       市值：2.13      累涨：33.41     10.85     13.57     8.99      10日：4.21      2.45      0.97      1.29      38        累涨修正：42.01     净值区间：94      97      98      99      99      37
        INDEX_300.put("588380", ContEtfTypeName.INDEX_300);//双创50ETF             市值：23.88     累涨：29.66     7.75      10.12     11.79     10日：6.29      3.51      1.15      1.15      35        累涨修正：41.76     净值区间：94      98      98      99      99      38
        INDEX_300.put("159575", ContEtfTypeName.INDEX_300);//创业板200ETF银华      市值：0.10      累涨：35.49     12.13     15.77     7.59      10日：3.44      1.91      0.39      1.26      33        累涨修正：41.62     净值区间：96      90      94      97      98      39
        INDEX_300.put("159782", ContEtfTypeName.INDEX_300);//双创50ETF             市值：9.04      累涨：28.94     7.70      9.57      11.67     10日：6.60      3.42      1.18      1.17      34        累涨修正：41.32     净值区间：94      98      98      99      99      40
        INDEX_300.put("588320", ContEtfTypeName.INDEX_300);//双创50ETF增强         市值：0.20      累涨：29.50     7.55      10.05     11.90     10日：6.32      3.05      0.93      1.24      40        累涨修正：40.73     净值区间：100     100     100     100     100     41
        INDEX_300.put("159804", ContEtfTypeName.INDEX_300);//创中盘88ETF           市值：1.28      累涨：32.53     10.74     15.32     6.47      10日：3.92      1.70      0.56      1.69      41        累涨修正：39.27     净值区间：100     100     100     100     100     42
        INDEX_300.put("159716", ContEtfTypeName.INDEX_300);//深创100ETF            市值：0.91      累涨：27.82     9.19      9.32      9.31      10日：5.07      3.23      1.42      1.17      42        累涨修正：38.96     净值区间：97      98      99      99      99      43
        INDEX_300.put("159918", ContEtfTypeName.INDEX_300);//中创400ETF            市值：0.72      累涨：30.05     10.42     12.52     7.11      10日：3.53      2.24      1.32      1.35      44        累涨修正：38.46     净值区间：86      89      92      95      96      44
        INDEX_300.put("159966", ContEtfTypeName.INDEX_300);//创业板价值ETF         市值：4.99      累涨：26.47     8.04      10.17     8.26      10日：4.17      3.12      2.07      1.43      43        累涨修正：37.9      净值区间：100     100     100     100     100     45
        INDEX_300.put("159372", ContEtfTypeName.INDEX_300);//创业板50ETF万家       市值：0.29      累涨：                              13.62     10日：6.59      3.60      1.39      1.03      22        累涨修正：26.59     净值区间：100     100     100                     46
        INDEX_300.put("159205", ContEtfTypeName.INDEX_300);//创业板ETF东财         市值：4.06      累涨：                              12.30     10日：5.90      3.55      1.44      1.43      36        累涨修正：24.63     净值区间：98      99      99                      47
        INDEX_300.put("159387", ContEtfTypeName.INDEX_300);//创业板新能源ETF国泰   市值：0.23      累涨：                              10.83     10日：4.31      2.83      1.82      2.35      39        累涨修正：21.61     净值区间：100     100     100                     48
        INDEX_300.put("159261", ContEtfTypeName.INDEX_300);//创业板新能源ETF鹏华   市值：2.06      累涨：                                        10日：4.88      3.50      1.83      2.01      44        累涨修正：12.04     净值区间：98      99                              49
        INDEX_300.put("159681", ContEtfTypeName.INDEX_300);//创50ETF               市值：16.64     累涨：                                        10日：                              1.46      45        累涨修正：0         净值区间：100     100     100     100     100     50
        INDEX_300.put("159270", ContEtfTypeName.INDEX_300);//创业板200ETF南方      市值：8.04      累涨：                                        10日：                              1.21                累涨修正：          净值区间：                                        51
    }

    public static Map<String, String> TOP_INDEX_688 = new HashMap<>();
    static {
        TOP_INDEX_688.put("588240", ContEtfTypeName.INDEX_688);//科创200ETF指数        市值：1.37      累涨：37.83     9.91      15.60     12.32     10日：6.84      4.02      0.90      1.42      2         累涨修正：50.49     净值区间：93      97      98      98      99      4
    }
    public static Map<String, String> INDEX_688 = new HashMap<>();
    static {
        INDEX_688.put("588910", ContEtfTypeName.INDEX_688);//科创价值ETF           市值：3.27      累涨：31.68     6.66      12.26     12.76     10日：7.90      6.40      4.03      1.31      4         累涨修正：54.04     净值区间：98      99      99      99      99      1
        INDEX_688.put("588850", ContEtfTypeName.INDEX_688);//科创机械ETF           市值：0.21      累涨：32.41     8.62      10.97     12.82     10日：7.66      5.30      3.91      1.25      4         累涨修正：53.19     净值区间：45      57      62      68      68      2
        INDEX_688.put("588170", ContEtfTypeName.INDEX_688);//科创半导体ETF         市值：2.68      累涨：32.11     7.46      13.56     11.09     10日：5.86      4.98      3.99      1.51      4         累涨修正：50.93     净值区间：97      97      98      99      99      3
        INDEX_688.put("588240", ContEtfTypeName.INDEX_688);//科创200ETF指数        市值：1.37      累涨：37.83     9.91      15.60     12.32     10日：6.84      4.02      0.90      1.42      2         累涨修正：50.49     净值区间：93      97      98      98      99      4
        INDEX_688.put("588820", ContEtfTypeName.INDEX_688);//科创200ETF基金        市值：0.21      累涨：36.94     8.85      14.60     13.49     10日：7.30      3.87      0.93      0.69      1         累涨修正：49.97     净值区间：88      95      96      98      98      5
        INDEX_688.put("588230", ContEtfTypeName.INDEX_688);//科创200ETF            市值：2.76      累涨：37.51     10.11     15.55     11.85     10日：6.76      3.80      0.91      0.82      3         累涨修正：49.89     净值区间：92      97      98      99      99      6
        INDEX_688.put("588030", ContEtfTypeName.INDEX_688);//科创100指数ETF        市值：64.57     累涨：31.81     6.54      15.17     10.10     10日：5.92      3.55      1.71      1.41      7         累涨修正：44.7      净值区间：98      99      99      99      99      7
        INDEX_688.put("588360", ContEtfTypeName.INDEX_688);//科创创业ETF           市值：4.49      累涨：31.20     7.48      11.12     12.60     10日：6.57      3.63      1.24      1.08      5         累涨修正：43.88     净值区间：95      98      98      99      99      8
        INDEX_688.put("588350", ContEtfTypeName.INDEX_688);//双创50ETF基金         市值：15.50     累涨：30.42     7.90      10.30     12.22     10日：6.84      3.41      1.30      0.97      26        累涨修正：43.27     净值区间：100     100     100     100     100     9
        INDEX_688.put("588390", ContEtfTypeName.INDEX_688);//科创创业50ETF         市值：2.64      累涨：30.67     7.44      10.85     12.38     10日：6.55      3.46      1.24      1.08      11        累涨修正：43.16     净值区间：90      96      97      98      98      10
        INDEX_688.put("588220", ContEtfTypeName.INDEX_688);//科创100ETF基金        市值：57.19     累涨：31.31     6.94      14.46     9.91      10日：5.63      3.36      1.42      1.50      13        累涨修正：43.14     净值区间：95      98      98      99      99      11
        INDEX_688.put("588900", ContEtfTypeName.INDEX_688);//科创100ETF南方        市值：4.09      累涨：31.92     6.92      14.83     10.17     10日：5.41      3.25      1.22      1.59      18        累涨修正：43.02     净值区间：95      98      98      99      99      12
        INDEX_688.put("588210", ContEtfTypeName.INDEX_688);//科创100ETF易方达      市值：3.88      累涨：31.68     7.20      14.66     9.82      10日：5.45      3.24      1.26      1.73      20        累涨修正：42.89     净值区间：97      99      99      99      99      13
        INDEX_688.put("159781", ContEtfTypeName.INDEX_688);//科创创业ETF           市值：86.79     累涨：31.03     7.96      10.57     12.50     10日：6.66      3.45      0.85      1.35      6         累涨修正：42.84     净值区间：94      98      98      99      99      14
        INDEX_688.put("588660", ContEtfTypeName.INDEX_688);//科创创业50ETF基金     市值：2.27      累涨：31.09     8.24      10.53     12.32     10日：6.28      3.09      1.18      1.17      19        累涨修正：42.82     净值区间：94      97      98      99      99      15
        INDEX_688.put("589630", ContEtfTypeName.INDEX_688);//科创综指ETF国泰       市值：8.54      累涨：27.76     5.69      11.46     10.61     10日：7.19      4.14      1.85      0.96      12        累涨修正：42.79     净值区间：97      99      99      99      99      16
        INDEX_688.put("159603", ContEtfTypeName.INDEX_688);//双创龙头ETF           市值：22.89     累涨：30.58     7.82      10.10     12.66     10日：6.53      3.21      1.21      1.19      15        累涨修正：42.74     净值区间：100     100     51      59      61      17
        INDEX_688.put("588190", ContEtfTypeName.INDEX_688);//科创100ETF            市值：30.88     累涨：30.97     6.66      14.53     9.78      10日：5.57      3.19      1.44      1.61      23        累涨修正：42.61     净值区间：97      99      99      99      99      18
        INDEX_688.put("588330", ContEtfTypeName.INDEX_688);//双创龙头ETF           市值：11.24     累涨：30.72     7.98      9.97      12.77     10日：6.51      3.37      1.00      1.32      9         累涨修正：42.6      净值区间：94      98      98      99      99      19
        INDEX_688.put("588120", ContEtfTypeName.INDEX_688);//科创板100ETF          市值：9.86      累涨：30.86     6.31      14.55     10.00     10日：5.62      3.26      1.42      1.78      17        累涨修正：42.58     净值区间：98      99      99      99      99      20
        INDEX_688.put("588400", ContEtfTypeName.INDEX_688);//科创创业ETF嘉实       市值：17.99     累涨：29.96     7.46      10.04     12.46     10日：6.70      3.55      1.17      0.99      8         累涨修正：42.55     净值区间：94      98      98      99      99      21
        INDEX_688.put("588880", ContEtfTypeName.INDEX_688);//科创100ETF华泰柏瑞    市值：2.14      累涨：31.11     6.64      14.75     9.72      10日：5.30      3.17      1.37      1.75      28        累涨修正：42.32     净值区间：97      99      99      99      99      22
        INDEX_688.put("159780", ContEtfTypeName.INDEX_688);//双创ETF               市值：41.98     累涨：30.63     7.51      10.69     12.43     10日：6.26      3.26      1.02      1.51      14        累涨修正：42.19     净值区间：100     100     100     100     100     23
        INDEX_688.put("588800", ContEtfTypeName.INDEX_688);//科创100ETF华夏        市值：28.61     累涨：30.70     6.83      14.37     9.50      10日：5.40      3.17      1.27      1.65      30        累涨修正：41.81     净值区间：92      96      96      98      98      24
        INDEX_688.put("159783", ContEtfTypeName.INDEX_688);//科创创业50ETF         市值：45.60     累涨：29.78     7.70      9.53      12.55     10日：6.59      3.41      1.01      1.50      10        累涨修正：41.8      净值区间：100     100     100     100     100     25
        INDEX_688.put("588380", ContEtfTypeName.INDEX_688);//双创50ETF             市值：23.88     累涨：29.66     7.75      10.12     11.79     10日：6.29      3.51      1.15      1.15      35        累涨修正：41.76     净值区间：94      98      98      99      99      26
        INDEX_688.put("588300", ContEtfTypeName.INDEX_688);//双创ETF               市值：17.22     累涨：29.40     7.49      9.85      12.06     10日：6.59      3.33      1.15      1.14      16        累涨修正：41.62     净值区间：94      98      98      99      99      27
        INDEX_688.put("588680", ContEtfTypeName.INDEX_688);//科创100ETF增强指数基金市值：0.56      累涨：30.15     6.95      14.49     8.71      10日：5.46      3.19      1.35      1.54      31        累涨修正：41.5      净值区间：98      99      99      100     100     28
        INDEX_688.put("159782", ContEtfTypeName.INDEX_688);//双创50ETF             市值：9.04      累涨：28.94     7.70      9.57      11.67     10日：6.60      3.42      1.18      1.17      34        累涨修正：41.32     净值区间：94      98      98      99      99      29
        INDEX_688.put("588320", ContEtfTypeName.INDEX_688);//双创50ETF增强         市值：0.20      累涨：29.50     7.55      10.05     11.90     10日：6.32      3.05      0.93      1.24      40        累涨修正：40.73     净值区间：100     100     100     100     100     30
        INDEX_688.put("588070", ContEtfTypeName.INDEX_688);//科创板成长ETF         市值：0.27      累涨：29.90     5.83      13.18     10.89     10日：6.69      2.77      0.64      -0.09     21        累涨修正：40.64     净值区间：50      81      83      88      88      31
        INDEX_688.put("588310", ContEtfTypeName.INDEX_688);//双创ETF基金           市值：0.64      累涨：28.79     7.33      9.90      11.56     10日：6.29      3.25      1.07      1.37      22        累涨修正：40.47     净值区间：100     100     100     100     100     32
        INDEX_688.put("589300", ContEtfTypeName.INDEX_688);//科创综指ETF嘉实       市值：1.05      累涨：26.63     5.72      11.04     9.87      10日：6.81      2.56      2.10      0.45      32        累涨修正：40.2      净值区间：79      88      90      96      96      33
        INDEX_688.put("588010", ContEtfTypeName.INDEX_688);//科创新材料ETF         市值：2.57      累涨：28.97     8.31      12.10     8.56      10日：3.94      3.14      1.56      1.86      37        累涨修正：39.17     净值区间：100     100     100     100     100     34
        INDEX_688.put("588500", ContEtfTypeName.INDEX_688);//科创100增强ETF易方达  市值：1.26      累涨：31.64     7.04      15.73     8.87      10日：4.53      2.28      0.27      1.90      43        累涨修正：38.99     净值区间：100     100     100     100     100     35
        INDEX_688.put("588110", ContEtfTypeName.INDEX_688);//科创成长ETF           市值：2.12      累涨：29.49     5.74      13.33     10.42     10日：6.30      2.36      0.40      0.24      27        累涨修正：38.95     净值区间：63      88      88      92      92      36
        INDEX_688.put("589990", ContEtfTypeName.INDEX_688);//科创综指ETF华泰柏瑞   市值：3.83      累涨：26.83     6.27      11.89     8.67      10日：5.48      3.35      1.46      1.36      33        累涨修正：38.58     净值区间：97      99      99      99      99      37
        INDEX_688.put("589770", ContEtfTypeName.INDEX_688);//科创综指ETF招商       市值：5.97      累涨：26.92     5.96      11.41     9.55      10日：5.62      3.48      1.28      1.17      24        累涨修正：38.58     净值区间：100     100     100     100     100     38
        INDEX_688.put("588160", ContEtfTypeName.INDEX_688);//科创材料ETF           市值：2.44      累涨：28.05     7.66      12.12     8.27      10日：4.35      3.41      1.38      1.37      40        累涨修正：38.57     净值区间：95      97      97      99      99      39
        INDEX_688.put("589500", ContEtfTypeName.INDEX_688);//科创综指ETF工银       市值：4.04      累涨：26.54     5.58      11.24     9.72      10日：5.56      3.20      1.28      1.27      38        累涨修正：37.86     净值区间：97      99      99      99      99      40
        INDEX_688.put("589080", ContEtfTypeName.INDEX_688);//科创综指ETF汇添富     市值：5.32      累涨：25.93     5.55      11.01     9.37      10日：5.54      3.39      1.48      1.07      37        累涨修正：37.82     净值区间：97      99      99      99      99      41
        INDEX_688.put("589000", ContEtfTypeName.INDEX_688);//科创综指ETF华夏       市值：15.89     累涨：26.73     5.96      11.35     9.42      10日：5.36      3.31      1.19      1.27      34        累涨修正：37.78     净值区间：97      99      99      99      99      42
        INDEX_688.put("589660", ContEtfTypeName.INDEX_688);//科创综指ETF南方       市值：6.17      累涨：26.44     5.87      11.63     8.94      10日：5.41      3.38      1.27      1.27      35        累涨修正：37.77     净值区间：97      99      99      99      99      43
        INDEX_688.put("589860", ContEtfTypeName.INDEX_688);//科创综指ETF天弘       市值：6.78      累涨：26.58     5.63      11.66     9.29      10日：5.31      3.23      1.30      1.19      41        累涨修正：37.72     净值区间：94      97      97      98      98      44
        INDEX_688.put("159335", ContEtfTypeName.INDEX_688);//央企科创ETF           市值：3.13      累涨：21.47     7.66      6.46      7.35      10日：5.09      4.68      3.18      0.96      42        累涨修正：37.6      净值区间：52      58      62      71      74      45
        INDEX_688.put("588020", ContEtfTypeName.INDEX_688);//科创成长50ETF         市值：3.15      累涨：28.99     6.19      12.93     9.87      10日：5.92      2.16      0.24      0.08      36        累涨修正：37.55     净值区间：52      83      84      89      89      46
        INDEX_688.put("589800", ContEtfTypeName.INDEX_688);//科创综指ETF易方达     市值：21.36     累涨：27.12     5.92      12.04     9.16      10日：5.29      2.92      1.10      1.38      45        累涨修正：37.53     净值区间：97      99      99      99      99      47
        INDEX_688.put("589680", ContEtfTypeName.INDEX_688);//科创综指ETF鹏华       市值：18.97     累涨：26.60     5.69      11.79     9.12      10日：5.27      3.21      1.19      1.18      44        累涨修正：37.46     净值区间：94      97      97      98      98      48
        INDEX_688.put("589060", ContEtfTypeName.INDEX_688);//科创综指ETF东财       市值：1.32      累涨：25.71     5.43      11.17     9.11      10日：5.53      3.36      1.33      1.40      40        累涨修正：37.26     净值区间：100     100     100     100     100     49
        INDEX_688.put("589600", ContEtfTypeName.INDEX_688);//科创综指ETF富国       市值：12.13     累涨：26.46     5.67      11.23     9.56      10日：5.33      3.25      1.10      1.20      39        累涨修正：37.24     净值区间：97      99      99      99      99      50
        INDEX_688.put("589900", ContEtfTypeName.INDEX_688);//科创综指ETF博时       市值：9.76      累涨：25.79     5.15      11.13     9.51      10日：5.56      3.10      1.39      1.17      46        累涨修正：37.23     净值区间：97      99      99      99      99      51
        INDEX_688.put("589890", ContEtfTypeName.INDEX_688);//科创综指ETF景顺       市值：6.90      累涨：25.80     6.21      10.37     9.22      10日：5.27      3.21      1.19      1.08      47        累涨修正：36.66     净值区间：92      96      96      97      97      52
        INDEX_688.put("589980", ContEtfTypeName.INDEX_688);//科创100ETF汇添富      市值：2.77      累涨：                    14.23     9.83      10日：5.86      3.36      1.66      1.83      29        累涨修正：36.6      净值区间：100     100     100     100             53
        INDEX_688.put("588450", ContEtfTypeName.INDEX_688);//科创50ETF增强         市值：1.21      累涨：23.40     4.17      10.09     9.14      10日：5.48      3.10      2.08      1.14      51        累涨修正：36.14     净值区间：98      99      99      99      99      54
        INDEX_688.put("589880", ContEtfTypeName.INDEX_688);//科创综指ETF建信       市值：8.87      累涨：25.80     5.64      11.20     8.96      10日：5.03      2.99      0.98      1.57      49        累涨修正：35.78     净值区间：97      99      99      99      99      55
        INDEX_688.put("588460", ContEtfTypeName.INDEX_688);//科创50增强ETF         市值：6.88      累涨：23.11     4.42      10.57     8.12      10日：5.07      2.64      1.44      0.33      53        累涨修正：33.7      净值区间：90      95      96      97      95      56
        INDEX_688.put("588370", ContEtfTypeName.INDEX_688);//科创50增强ETF南方     市值：0.99      累涨：23.09     4.99      9.23      8.87      10日：5.25      2.74      1.03      1.12      52        累涨修正：33.14     净值区间：100     100     100     100     100     57
        INDEX_688.put("588100", ContEtfTypeName.INDEX_688);//科创信息技术ETF       市值：2.49      累涨：24.17     5.82      10.49     7.86      10日：4.11      2.03      1.20      1.26      66        累涨修正：32.71     净值区间：98      99      99      99      76      58
        INDEX_688.put("588770", ContEtfTypeName.INDEX_688);//科创信息技术ETF摩根   市值：3.00      累涨：23.25     5.19      10.44     7.62      10日：4.33      2.20      1.46      1.13      64        累涨修正：32.7      净值区间：97      98      98      99      76      59
        INDEX_688.put("588670", ContEtfTypeName.INDEX_688);//科创综指增强ETF       市值：0.86      累涨：                              12.15     10日：9.17      5.58      2.85      1.98      26        累涨修正：32.6      净值区间：98      99      99                      60
        INDEX_688.put("588260", ContEtfTypeName.INDEX_688);//科创信息ETF           市值：1.28      累涨：23.16     5.22      10.33     7.61      10日：4.07      1.98      1.21      1.05      68        累涨修正：31.63     净值区间：97      31      31      38      42      61
        INDEX_688.put("588950", ContEtfTypeName.INDEX_688);//科创50ETF景顺         市值：1.85      累涨：20.33     4.25      8.55      7.53      10日：4.67      2.41      1.54      0.95      55        累涨修正：30.49     净值区间：100     29      29      34      34      62
        INDEX_688.put("588710", ContEtfTypeName.INDEX_688);//科创半导体设备ETF     市值：1.03      累涨：                              11.90     10日：6.34      4.72      3.76      1.92      17        累涨修正：30.48     净值区间：97      98      98                      63
        INDEX_688.put("588840", ContEtfTypeName.INDEX_688);//科创板50ETF基金       市值：1.84      累涨：20.96     4.45      8.72      7.79      10日：4.26      2.38      1.40      0.96      54        累涨修正：30.4      净值区间：93      96      96      97      85      64
        INDEX_688.put("588720", ContEtfTypeName.INDEX_688);//科创50ETF中银         市值：3.48      累涨：20.84     4.14      9.23      7.47      10日：4.26      2.35      1.27      0.77      56        累涨修正：29.99     净值区间：83      89      91      94      64      65
        INDEX_688.put("588000", ContEtfTypeName.INDEX_688);//科创50ETF             市值：900.07    累涨：21.01     5.03      8.98      7.00      10日：4.00      2.35      1.31      1.12      59        累涨修正：29.98     净值区间：97      98      98      99      88      66
        INDEX_688.put("588870", ContEtfTypeName.INDEX_688);//科创50指数ETF         市值：3.14      累涨：20.25     4.17      8.92      7.16      10日：4.09      2.41      1.54      0.95      62        累涨修正：29.83     净值区间：97      98      98      99      68      67
        INDEX_688.put("588060", ContEtfTypeName.INDEX_688);//科创50ETF龙头         市值：65.41     累涨：21.00     4.69      9.02      7.29      10日：4.10      2.18      1.24      1.23      61        累涨修正：29.76     净值区间：100     100     100     100     88      68
        INDEX_688.put("588050", ContEtfTypeName.INDEX_688);//科创ETF               市值：120.85    累涨：20.81     4.85      8.91      7.05      10日：3.99      2.21      1.34      1.14      63        累涨修正：29.69     净值区间：100     100     100     100     87      69
        INDEX_688.put("588180", ContEtfTypeName.INDEX_688);//科创50ETF基金         市值：34.77     累涨：20.66     4.45      8.73      7.48      10日：4.19      2.30      1.22      1.37      58        累涨修正：29.59     净值区间：100     100     100     100     88      70
        INDEX_688.put("588080", ContEtfTypeName.INDEX_688);//科创板50ETF           市值：665.59    累涨：20.53     4.97      8.59      6.97      10日：4.00      2.22      1.35      1.24      64        累涨修正：29.45     净值区间：100     100     100     100     90      71
        INDEX_688.put("588280", ContEtfTypeName.INDEX_688);//科创50ETF指数基金     市值：4.35      累涨：19.48     4.41      8.52      6.55      10日：3.88      2.33      1.36      0.81      65        累涨修正：28.41     净值区间：95      97      97      98      85      72
        INDEX_688.put("588150", ContEtfTypeName.INDEX_688);//科创50ETF南方         市值：2.76      累涨：19.34     4.11      8.62      6.61      10日：3.86      2.27      1.13      1.26      66        累涨修正：27.73     净值区间：100     100     100     100     83      73
        INDEX_688.put("588270", ContEtfTypeName.INDEX_688);//科创200ETF易方达      市值：0.29      累涨：                              12.91     10日：7.13      4.39      0.81      0.71      25        累涨修正：26.05     净值区间：85      94      96                      74
        INDEX_688.put("588040", ContEtfTypeName.INDEX_688);//科创50ETF指数         市值：0.43      累涨：18.18     4.41      7.38      6.39      10日：3.75      1.81      1.14      1.04      67        累涨修正：26.02     净值区间：96      98      98      99      31      75
        INDEX_688.put("589580", ContEtfTypeName.INDEX_688);//科创综指ETF兴银       市值：0.20      累涨：                              9.93      10日：5.78      2.66      1.32      1.50      50        累涨修正：21.01     净值区间：64      78      80                      76
        INDEX_688.put("589700", ContEtfTypeName.INDEX_688);//科创成长ETF南方       市值：0.26      累涨：                              10.32     10日：6.58      2.56      0.47      0.19      48        累涨修正：20.4      净值区间：59      87      88                      77
        INDEX_688.put("589180", ContEtfTypeName.INDEX_688);//科创新材料ETF汇添富   市值：0.22      累涨：                              8.30      10日：4.17      3.31      1.50      1.58      58        累涨修正：18.78     净值区间：97      98      98                      78
        INDEX_688.put("588940", ContEtfTypeName.INDEX_688);//科创50ETF富国         市值：2.20      累涨：                              7.51      10日：4.62      2.43      1.25      1.15      60        累涨修正：17.06     净值区间：100     100     100                     79
        INDEX_688.put("588520", ContEtfTypeName.INDEX_688);//科创增强ETF           市值：0.65      累涨：                                        10日：5.09      3.01      1.64      1.24      57        累涨修正：11.38     净值区间：95      97                              80
        INDEX_688.put("588090", ContEtfTypeName.INDEX_688);//科创板ETF             市值：53.01     累涨：                                        10日：                              1.04      68        累涨修正：0         净值区间：100     100     100     100     87      81
    }

    public static Map<String, String> TOP_INDEX_CN_BIG = new HashMap<>();

    static {
        TOP_INDEX_CN_BIG.put("562310", "指数-大盘             ");//沪深300成长ETF        市值：8.66      累涨：20.72     8.58      6.26      5.88      10日：4.44      1.16      1.16      1.03      40        累涨修正：28.64     净值区间：61      76      83      83      90      37
    }

    public static Map<String, String> INDEX_CN_BIG = new HashMap<>();//指数-大盘

    static {
        INDEX_CN_BIG.put("159906", "指数-大盘             ");//深成长龙头ETF         市值：1.14      累涨：37.15     17.35     10.77     9.03      10日：5.80      1.45      1.14      1.66      16        累涨修正：46.68     净值区间：95      98      98      99      99      1
        INDEX_CN_BIG.put("560170", "指数-大盘             ");//央企科技ETF           市值：14.23     累涨：35.17     15.30     9.47      10.40     10日：7.39      0.46      0.46      1.38      18        累涨修正：43.94     净值区间：88      82      87      89      91      2
        INDEX_CN_BIG.put("563050", "指数-大盘             ");//央企科技50ETF         市值：2.34      累涨：35.27     15.40     9.51      10.36     10日：7.27      0.44      0.44      1.43      17        累涨修正：43.86     净值区间：94      88      88      90      92      3
        INDEX_CN_BIG.put("562380", "指数-大盘             ");//央企科技引领ETF       市值：1.89      累涨：35.90     15.60     9.83      10.47     10日：6.76      0.33      0.33      1.55      20        累涨修正：43.65     净值区间：100     86      88      91      92      4
        INDEX_CN_BIG.put("159721", "指数-大盘             ");//深证100ETF永赢        市值：0.84      累涨：26.56     11.46     7.78      7.32      10日：5.34      1.67      1.67      1.28      3         累涨修正：36.91     净值区间：76      83      89      89      96      5
        INDEX_CN_BIG.put("510030", "指数-大盘             ");//价值ETF               市值：1.76      累涨：23.68     8.08      5.80      9.80      10日：5.86      2.77      1.56      0.00      1         累涨修正：35.43     净值区间：76      84      90      92      95      6
        INDEX_CN_BIG.put("159706", "指数-大盘             ");//深证100ETF华安        市值：0.53      累涨：23.40     8.72      6.93      7.75      10日：5.83      2.02      2.02      0.14      2         累涨修正：35.29     净值区间：84      89      93      70      79      7
        INDEX_CN_BIG.put("159970", "指数-大盘             ");//深100ETF工银          市值：0.11      累涨：23.96     9.93      6.60      7.43      10日：5.37      1.60      1.60      1.29      5         累涨修正：34.13     净值区间：25      34      46      46      65      8
        INDEX_CN_BIG.put("159350", "指数-大盘             ");//深证50ETF富国         市值：2.67      累涨：23.22     9.59      6.25      7.38      10日：5.88      1.65      1.65      1.29      8         累涨修正：34.05     净值区间：75      83      88      88      93      9
        INDEX_CN_BIG.put("159212", "指数-大盘             ");//深100ETF南方          市值：5.61      累涨：23.07     9.34      6.32      7.41      10日：5.68      1.68      1.68      1.21      7         累涨修正：33.79     净值区间：76      86      89      89      93      10
        INDEX_CN_BIG.put("159901", "指数-大盘             ");//深证100ETF            市值：64.96     累涨：23.09     9.00      6.75      7.34      10日：5.72      1.65      1.65      1.39      4         累涨修正：33.76     净值区间：82      87      91      91      95      11
        INDEX_CN_BIG.put("159576", "指数-大盘             ");//深证100ETF广发        市值：0.74      累涨：23.24     9.53      6.55      7.16      10日：5.46      1.74      1.65      1.30      6         累涨修正：33.74     净值区间：80      87      91      91      95      12
        INDEX_CN_BIG.put("159943", "指数-大盘             ");//深证成指ETF           市值：2.02      累涨：24.58     10.10     6.79      7.69      10日：5.68      1.15      1.06      1.50      15        累涨修正：33.53     净值区间：88      93      96      96      97      13
        INDEX_CN_BIG.put("159150", "指数-大盘             ");//深证50ETF易方达       市值：1.89      累涨：22.88     9.08      6.26      7.54      10日：5.61      1.62      1.62      1.28      9         累涨修正：33.35     净值区间：74      83      88      88      93      14
        INDEX_CN_BIG.put("159961", "指数-大盘             ");//深100ETF方正富邦      市值：4.41      累涨：22.97     9.41      6.32      7.24      10日：5.41      1.60      1.60      1.28      10        累涨修正：33.18     净值区间：77      88      89      89      94      15
        INDEX_CN_BIG.put("159578", "指数-大盘             ");//深证主板50ETF南方     市值：0.91      累涨：22.76     9.47      4.87      8.42      10日：6.41      1.31      1.31      0.65      21        累涨修正：33.1      净值区间：50      54      55      29      44      16
        INDEX_CN_BIG.put("159547", "指数-大盘             ");//红利低波ETF基金       市值：2.97      累涨：23.36     10.09     6.33      6.94      10日：4.13      2.67      1.45      -0.16     11        累涨修正：33.06     净值区间：84      90      93      96      97      17
        INDEX_CN_BIG.put("159903", "指数-大盘             ");//深成ETF               市值：4.66      累涨：24.64     10.42     7.00      7.22      10日：5.41      1.03      0.95      1.27      18        累涨修正：32.98     净值区间：93      96      98      98      99      18
        INDEX_CN_BIG.put("159975", "指数-大盘             ");//深100ETF招商          市值：0.50      累涨：22.37     8.85      6.14      7.38      10日：5.39      1.60      1.60      1.06      12        累涨修正：32.56     净值区间：75      83      88      88      92      19
        INDEX_CN_BIG.put("159912", "指数-大盘             ");//深300ETF              市值：1.38      累涨：23.62     9.49      6.70      7.43      10日：5.47      1.13      1.06      1.34      17        累涨修正：32.34     净值区间：72      74      82      82      88      20
        INDEX_CN_BIG.put("159913", "指数-大盘             ");//深价值ETF             市值：0.65      累涨：24.94     13.23     5.46      6.25      10日：4.03      1.62      0.83      0.41      30        累涨修正：32.25     净值区间：100     100     100     57      78      21
        INDEX_CN_BIG.put("512750", "指数-大盘             ");//基本面50ETF           市值：0.97      累涨：20.85     7.83      5.07      7.95      10日：5.02      3.03      1.67      -0.13     13        累涨修正：32.24     净值区间：90      93      95      96      98      22
        INDEX_CN_BIG.put("159969", "指数-大盘             ");//深100ETF银华          市值：0.16      累涨：22.47     9.00      6.43      7.04      10日：5.18      1.47      1.47      1.29      14        累涨修正：32.06     净值区间：92      96      98      54      60      23
        INDEX_CN_BIG.put("560150", "指数-大盘             ");//红利低波ETF泰康       市值：8.46      累涨：20.51     7.39      6.01      7.11      10日：4.20      2.77      1.50      -0.16     16        累涨修正：30.48     净值区间：72      81      86      91      94      24
        INDEX_CN_BIG.put("560890", "指数-大盘             ");//红利低波ETF新华       市值：0.72      累涨：21.02     7.38      5.94      7.70      10日：3.86      2.57      1.44      -0.24     23        累涨修正：30.33     净值区间：78      88      93      94      96      25
        INDEX_CN_BIG.put("512890", "指数-大盘             ");//红利低波ETF           市值：198.11    累涨：20.60     7.49      6.29      6.82      10日：4.01      2.67      1.49      -0.25     19        累涨修正：30.26     净值区间：77      85      89      93      96      26
        INDEX_CN_BIG.put("510010", "指数-大盘             ");//180治理ETF            市值：2.38      累涨：22.21     9.98      6.46      5.77      10日：3.42      2.32      1.15      0.12      39        累涨修正：30.25     净值区间：77      83      89      29      49      27
        INDEX_CN_BIG.put("560330", "指数-大盘             ");//沪深300价值ETF申万菱信市值：0.57      累涨：20.53     7.08      5.10      8.35      10日：4.71      2.38      1.14      0.16      20        累涨修正：29.9      净值区间：81      88      93      94      97      28
        INDEX_CN_BIG.put("159621", "指数-大盘             ");//MSCIESGETF            市值：0.33      累涨：21.75     7.95      7.09      6.71      10日：4.96      1.30      0.90      0.89      39        累涨修正：29.81     净值区间：96      98      98      98      99      29
        INDEX_CN_BIG.put("159525", "指数-大盘             ");//红利低波ETF           市值：3.08      累涨：20.58     8.31      5.77      6.50      10日：3.85      2.50      1.42      -0.09     27        累涨修正：29.77     净值区间：79      88      91      94      96      30
        INDEX_CN_BIG.put("563020", "指数-大盘             ");//红利低波动ETF         市值：21.80     累涨：20.06     7.73      5.82      6.51      10日：3.95      2.66      1.53      -0.24     24        累涨修正：29.73     净值区间：78      86      90      93      96      31
        INDEX_CN_BIG.put("512530", "指数-大盘             ");//沪深300红利ETF        市值：2.01      累涨：20.56     7.82      5.48      7.26      10日：3.78      2.75      1.27      0.19      25        累涨修正：29.63     净值区间：91      93      95      96      98      32
        INDEX_CN_BIG.put("159656", "指数-大盘             ");//300成长ETF            市值：1.53      累涨：21.00     8.77      6.18      6.05      10日：4.73      1.29      1.17      1.05      29        累涨修正：29.36     净值区间：72      84      89      89      94      33
        INDEX_CN_BIG.put("562320", "指数-大盘             ");//沪深300价值ETF        市值：1.49      累涨：19.75     7.42      4.58      7.75      10日：4.73      2.39      1.23      0.23      26        累涨修正：29.33     净值区间：87      91      95      96      98      34
        INDEX_CN_BIG.put("512360", "指数-大盘             ");//MSCI中国A股ETF基金    市值：0.65      累涨：22.13     10.57     6.39      5.17      10日：3.74      1.18      1.05      0.33      72        累涨修正：29.15     净值区间：85      94      95      91      95      35
        INDEX_CN_BIG.put("159630", "指数-大盘             ");//A100ETF基金           市值：0.15      累涨：18.31     6.09      5.16      7.06      10日：5.33      1.97      1.61      0.27      34        累涨修正：28.83     净值区间：40      40      46      46      63      36
        INDEX_CN_BIG.put("562310", "指数-大盘             ");//沪深300成长ETF        市值：8.66      累涨：20.72     8.58      6.26      5.88      10日：4.44      1.16      1.16      1.03      40        累涨修正：28.64     净值区间：61      76      83      83      90      37
        INDEX_CN_BIG.put("561580", "指数-大盘             ");//央企红利ETF           市值：5.13      累涨：18.00     6.21      4.94      6.85      10日：4.59      3.10      1.45      0.40      33        累涨修正：28.59     净值区间：97      98      98      99      99      38
        INDEX_CN_BIG.put("159602", "指数-大盘             ");//中国A50ETF            市值：10.15     累涨：19.70     8.89      4.80      6.01      10日：4.40      1.57      1.45      0.60      42        累涨修正：28.57     净值区间：77      81      88      88      94      39
        INDEX_CN_BIG.put("563330", "指数-大盘             ");//A股ETF                市值：0.62      累涨：22.42     10.00     6.04      6.38      10日：4.27      0.70      0.55      0.98      41        累涨修正：28.49     净值区间：94      96      98      98      99      40
        INDEX_CN_BIG.put("563280", "指数-大盘             ");//A50增强ETF            市值：0.09      累涨：20.41     8.40      5.97      6.04      10日：3.73      1.53      1.35      0.63      43        累涨修正：28.37     净值区间：79      90      90      90      96      41
        INDEX_CN_BIG.put("510130", "指数-大盘             ");//上证中盘ETF易方达     市值：2.45      累涨：19.18     6.86      5.24      7.08      10日：4.40      1.96      1.26      0.38      31        累涨修正：28.06     净值区间：98      96      96      97      98      42
        INDEX_CN_BIG.put("159758", "指数-大盘             ");//红利质量ETF           市值：5.25      累涨：19.62     6.98      6.27      6.37      10日：5.73      1.38      0.64      0.53      22        累涨修正：28.01     净值区间：69      88      93      93      96      43
        INDEX_CN_BIG.put("560050", "指数-大盘             ");//MSCI中国A50ETF        市值：44.30     累涨：18.67     8.12      4.85      5.70      10日：4.35      1.56      1.56      0.83      55        累涨修正：27.7      净值区间：77      81      88      88      94      44
        INDEX_CN_BIG.put("563000", "指数-大盘             ");//中国A50ETF            市值：39.40     累涨：18.74     7.80      5.17      5.77      10日：4.31      1.54      1.54      0.59      45        累涨修正：27.67     净值区间：77      81      88      88      94      45
        INDEX_CN_BIG.put("560030", "指数-大盘             ");//800价值ETF            市值：0.31      累涨：18.83     6.73      4.71      7.39      10日：4.55      2.18      1.04      0.24      66        累涨修正：27.64     净值区间：89      95      95      75      80      46
        INDEX_CN_BIG.put("560520", "指数-大盘             ");//红利低波100ETF基金    市值：0.04      累涨：19.93     8.15      7.16      4.62      10日：3.23      2.40      1.01      0.27      63        累涨修正：27.58     净值区间：80      85      86      75      45      47
        INDEX_CN_BIG.put("159653", "指数-大盘             ");//ESG300ETF             市值：0.56      累涨：20.39     9.08      5.38      5.93      10日：3.76      1.40      1.00      1.01      41        累涨修正：27.55     净值区间：86      92      94      94      75      48
        INDEX_CN_BIG.put("561200", "指数-大盘             ");//中证A100ETF工银       市值：0.33      累涨：19.29     7.24      6.16      5.89      10日：4.42      1.60      1.01      0.75      35        累涨修正：27.33     净值区间：80      93      50      50      67      49
        INDEX_CN_BIG.put("517030", "指数-大盘             ");//沪港深300ETF易方达    市值：0.68      累涨：21.38     9.74      5.74      5.90      10日：4.34      0.71      0.41      1.02      60        累涨修正：27.25     净值区间：88      90      96      70      71      50
        INDEX_CN_BIG.put("510210", "指数-大盘             ");//上证指数ETF           市值：33.01     累涨：19.64     7.23      6.04      6.37      10日：4.22      1.40      0.93      0.57      32        累涨修正：27.12     净值区间：94      96      98      98      99      51
        INDEX_CN_BIG.put("512180", "指数-大盘             ");//MSCIA股ETF基金        市值：0.92      累涨：19.48     8.81      4.96      5.71      10日：4.05      1.40      1.05      0.49      61        累涨修正：27.03     净值区间：100     100     100     89      94      52
        INDEX_CN_BIG.put("515910", "指数-大盘             ");//质量ETF               市值：2.22      累涨：19.81     7.35      6.13      6.33      10日：4.07      1.01      1.01      1.61      50        累涨修正：26.91     净值区间：100     100     100     100     100     53
        INDEX_CN_BIG.put("159523", "指数-大盘             ");//沪深300成长ETF        市值：0.56      累涨：19.74     8.27      5.27      6.20      10日：3.96      1.05      0.95      0.57      64        累涨修正：26.65     净值区间：71      82      88      89      95      54
        INDEX_CN_BIG.put("159332", "指数-大盘             ");//央企红利ETF           市值：0.78      累涨：15.95     4.94      4.35      6.66      10日：4.32      2.99      1.66      0.43      80        累涨修正：26.58     净值区间：97      98      98      99      99      55
        INDEX_CN_BIG.put("561990", "指数-大盘             ");//沪深300增强ETF        市值：6.85      累涨：19.03     7.11      5.54      6.38      10日：4.08      1.35      1.01      0.67      38        累涨修正：26.48     净值区间：75      81      89      90      94      56
        INDEX_CN_BIG.put("159209", "指数-大盘             ");//中证红利质量ETF       市值：2.21      累涨：18.33     7.32      5.42      5.59      10日：4.31      1.99      0.89      0.39      44        累涨修正：26.41     净值区间：61      80      85      85      92      57
        INDEX_CN_BIG.put("510760", "指数-大盘             ");//上证综指ETF           市值：19.77     累涨：19.61     7.69      5.52      6.40      10日：4.00      1.17      0.72      0.71      47        累涨修正：26.22     净值区间：100     100     100     100     100     58
        INDEX_CN_BIG.put("512550", "指数-大盘             ");//富时A50ETF嘉实        市值：3.24      累涨：17.87     6.73      4.41      6.73      10日：4.18      1.60      1.28      0.51      66        累涨修正：26.21     净值区间：77      82      88      89      94      59
        INDEX_CN_BIG.put("515130", "指数-大盘             ");//沪深300ETF博时        市值：1.33      累涨：17.94     6.50      4.87      6.57      10日：4.71      1.34      1.10      0.78      48        累涨修正：26.19     净值区间：84      91      94      96      97      60
        INDEX_CN_BIG.put("561180", "指数-大盘             ");//A100ETF               市值：1.09      累涨：19.75     9.60      4.52      5.63      10日：3.65      1.11      0.83      0.74      119       累涨修正：26.17     净值区间：82      88      92      71      81      61
        INDEX_CN_BIG.put("562890", "指数-大盘             ");//A50ETF嘉实            市值：4.26      累涨：17.73     6.83      4.74      6.16      10日：4.56      1.38      1.21      0.52      54        累涨修正：26.09     净值区间：62      74      82      82      89      62
        INDEX_CN_BIG.put("563090", "指数-大盘             ");//上证50增强ETF易方达   市值：0.52      累涨：17.89     5.16      5.79      6.94      10日：4.24      2.06      0.93      1.02      46        累涨修正：26.05     净值区间：93      93      95      78      82      63
        INDEX_CN_BIG.put("510290", "指数-大盘             ");//上证380ETF            市值：1.62      累涨：20.13     9.01      5.07      6.05      10日：4.09      0.74      0.54      1.02      83        累涨修正：26.04     净值区间：94      97      98      98      99      64
        INDEX_CN_BIG.put("561000", "指数-大盘             ");//沪深300ETF增强基金    市值：1.23      累涨：18.30     6.85      4.99      6.46      10日：4.11      1.33      1.06      0.35      52        累涨修正：25.86     净值区间：67      81      85      86      93      65
        INDEX_CN_BIG.put("159216", "指数-大盘             ");//深证100ETF大成        市值：0.19      累涨：                    6.63      7.98      10日：6.02      1.74      1.74      1.37      28        累涨修正：25.85     净值区间：75      83      59      59              66
        INDEX_CN_BIG.put("159601", "指数-大盘             ");//A50ETF                市值：31.06     累涨：17.94     7.69      4.59      5.66      10日：3.96      1.31      1.31      0.59      105       累涨修正：25.83     净值区间：73      77      86      86      92      67
        INDEX_CN_BIG.put("512380", "指数-大盘             ");//MSCI中国ETF           市值：1.24      累涨：18.36     7.03      5.35      5.98      10日：4.30      1.35      0.90      0.96      49        累涨修正：25.81     净值区间：88      94      96      96      98      68
        INDEX_CN_BIG.put("561930", "指数-大盘             ");//沪深300ETF招商        市值：3.83      累涨：17.52     6.06      4.87      6.59      10日：4.72      1.34      1.10      0.86      57        累涨修正：25.78     净值区间：82      89      92      93      96      69
        INDEX_CN_BIG.put("159591", "指数-大盘             ");//中证A50ETF            市值：9.62      累涨：17.94     7.02      5.00      5.92      10日：4.23      1.22      1.13      0.61      75        累涨修正：25.65     净值区间：65      74      84      84      90      70
        INDEX_CN_BIG.put("510390", "指数-大盘             ");//沪深300ETF平安        市值：5.76      累涨：17.79     6.51      5.11      6.17      10日：4.34      1.34      1.09      0.78      51        累涨修正：25.65     净值区间：78      86      94      94      95      71
        INDEX_CN_BIG.put("159916", "指数-大盘             ");//深F60ETF              市值：3.52      累涨：19.63     9.89      4.22      5.52      10日：2.64      1.86      0.73      0.70      117       累涨修正：25.59     净值区间：81      88      93      93      95      72
        INDEX_CN_BIG.put("159925", "指数-大盘             ");//沪深300ETF南方        市值：36.00     累涨：17.72     6.48      5.07      6.17      10日：4.50      1.27      1.05      0.82      53        累涨修正：25.59     净值区间：79      85      91      92      95      73
        INDEX_CN_BIG.put("560350", "指数-大盘             ");//XD中证A50ETF指数基金  市值：25.53     累涨：17.32     6.44      4.75      6.13      10日：4.59      1.33      1.15      0.54      70        累涨修正：25.54     净值区间：22      38      61      61      75      74
        INDEX_CN_BIG.put("159910", "指数-大盘             ");//基本面120ETF          市值：2.87      累涨：18.13     7.38      4.64      6.11      10日：3.67      1.89      0.92      0.96      79        累涨修正：25.53     净值区间：100     100     100     100     100     75
        INDEX_CN_BIG.put("563520", "指数-大盘             ");//沪深300ETF永赢        市值：9.77      累涨：17.75     6.03      5.28      6.44      10日：4.58      1.20      1.00      0.70      58        累涨修正：25.53     净值区间：77      84      90      91      95      76
        INDEX_CN_BIG.put("512090", "指数-大盘             ");//MSCIA股ETF易方达      市值：4.00      累涨：17.91     6.99      4.65      6.27      10日：4.29      1.31      1.00      0.99      65        累涨修正：25.51     净值区间：94      96      98      98      99      77
        INDEX_CN_BIG.put("159919", "指数-大盘             ");//沪深300ETF            市值：1717.03   累涨：17.83     6.31      5.20      6.32      10日：4.45      1.19      1.02      0.80      59        累涨修正：25.51     净值区间：80      86      91      92      95      78
        INDEX_CN_BIG.put("515350", "指数-大盘             ");//民生加银300ETF        市值：1.23      累涨：18.01     7.28      4.76      5.97      10日：4.32      1.14      0.96      0.75      88        累涨修正：25.39     净值区间：83      87      92      93      96      79
        INDEX_CN_BIG.put("510370", "指数-大盘             ");//300指数ETF            市值：1.01      累涨：18.01     6.44      5.51      6.06      10日：3.94      1.14      1.14      0.79      100       累涨修正：25.37     净值区间：89      93      97      97      98      80
        INDEX_CN_BIG.put("159593", "指数-大盘             ");//中证A50指数ETF        市值：67.00     累涨：17.09     6.16      4.88      6.05      10日：4.63      1.21      1.21      0.60      90        累涨修正：25.35     净值区间：64      71      82      82      89      81
        INDEX_CN_BIG.put("510360", "指数-大盘             ");//沪深300ETF基金        市值：64.16     累涨：17.76     6.56      5.07      6.13      10日：4.25      1.29      1.01      0.81      62        累涨修正：25.32     净值区间：81      87      92      93      95      82
        INDEX_CN_BIG.put("515390", "指数-大盘             ");//沪深300ETF指数基金    市值：5.44      累涨：17.53     6.32      4.90      6.31      10日：4.40      1.24      1.06      0.88      68        累涨修正：25.29     净值区间：81      86      92      92      95      83
        INDEX_CN_BIG.put("515660", "指数-大盘             ");//沪深300ETF国联安      市值：43.26     累涨：18.40     7.32      5.09      5.99      10日：3.96      1.04      0.92      0.62      95        累涨修正：25.24     净值区间：79      89      92      84      89      84
        INDEX_CN_BIG.put("159592", "指数-大盘             ");//A50ETF基金            市值：24.27     累涨：17.38     6.91      4.51      5.96      10日：4.35      1.23      1.14      0.70      99        累涨修正：25.24     净值区间：65      74      83      83      90      85
        INDEX_CN_BIG.put("561230", "指数-大盘             ");//中证A50ETF基金        市值：15.21     累涨：17.48     6.91      4.73      5.84      10日：4.12      1.33      1.15      0.53      96        累涨修正：25.23     净值区间：62      72      80      80      88      86
        INDEX_CN_BIG.put("515360", "指数-大盘             ");//方正沪深300ETF        市值：2.04      累涨：17.74     6.14      5.66      5.94      10日：4.18      1.30      1.00      0.77      81        累涨修正：25.22     净值区间：85      93      94      94      98      87
        INDEX_CN_BIG.put("515330", "指数-大盘             ");//沪深300ETF天弘        市值：92.10     累涨：17.34     6.29      4.87      6.18      10日：4.44      1.26      1.08      0.71      74        累涨修正：25.2      净值区间：76      83      90      90      94      88
        INDEX_CN_BIG.put("515380", "指数-大盘             ");//沪深300ETF泰康        市值：34.86     累涨：17.55     6.34      5.15      6.06      10日：4.32      1.23      1.03      0.84      71        累涨修正：25.16     净值区间：81      87      92      92      95      89
        INDEX_CN_BIG.put("512160", "指数-大盘             ");//MSCI中国A股ETF        市值：2.88      累涨：18.14     7.13      4.78      6.23      10日：3.97      1.23      0.90      1.14      77        累涨修正：25.14     净值区间：96      98      98      98      99      90
        INDEX_CN_BIG.put("159673", "指数-大盘             ");//沪深300ETF鹏华        市值：28.58     累涨：17.81     6.51      5.21      6.09      10日：4.06      1.21      1.03      0.84      78        累涨修正：25.14     净值区间：84      88      93      93      78      91
        INDEX_CN_BIG.put("530880", "指数-大盘             ");//红利ETF国企           市值：0.90      累涨：17.96     6.80      5.93      5.23      10日：3.34      2.45      0.68      0.19      89        累涨修正：25.11     净值区间：65      79      83      88      92      92
        INDEX_CN_BIG.put("510330", "指数-大盘             ");//沪深300ETF华夏        市值：1995.06   累涨：17.60     6.34      5.05      6.21      10日：4.44      1.17      0.95      0.87      69        累涨修正：25.11     净值区间：82      88      92      93      96      93
        INDEX_CN_BIG.put("510310", "指数-大盘             ");//沪深300ETF易方达      市值：2695.22   累涨：17.45     6.34      4.94      6.17      10日：4.51      1.23      0.95      0.84      67        累涨修正：25.09     净值区间：80      87      91      92      95      94
        INDEX_CN_BIG.put("510300", "指数-大盘             ");//沪深300ETF            市值：3767.02   累涨：17.29     6.18      4.99      6.12      10日：4.54      1.25      1.00      0.85      73        累涨修正：25.08     净值区间：81      87      92      91      93      95
        INDEX_CN_BIG.put("159596", "指数-大盘             ");//A50ETF华宝            市值：9.68      累涨：17.09     6.54      4.67      5.88      10日：4.42      1.25      1.16      0.53      98        累涨修正：25.08     净值区间：62      70      81      81      89      96
        INDEX_CN_BIG.put("510350", "指数-大盘             ");//沪深300ETF工银        市值：36.05     累涨：17.27     6.21      4.91      6.15      10日：4.47      1.20      1.06      0.79      82        累涨修正：25.06     净值区间：82      88      92      93      96      97
        INDEX_CN_BIG.put("515890", "指数-大盘             ");//红利ETF博时           市值：6.03      累涨：16.09     5.49      4.76      5.84      10日：4.05      2.54      1.19      0.00      106       累涨修正：25.06     净值区间：94      96      97      97      98      98
        INDEX_CN_BIG.put("159595", "指数-大盘             ");//中证A50ETF基金        市值：41.24     累涨：17.30     6.53      4.71      6.06      10日：4.46      1.21      1.04      0.43      86        累涨修正：25.05     净值区间：57      67      79      79      86      99
        INDEX_CN_BIG.put("159330", "指数-大盘             ");//沪深300ETF基金        市值：14.25     累涨：17.72     6.08      5.35      6.29      10日：4.14      1.16      1.00      0.83      85        累涨修正：25.02     净值区间：81      87      92      93      95      100
        INDEX_CN_BIG.put("510380", "指数-大盘             ");//国寿300ETF            市值：15.82     累涨：18.06     7.08      4.57      6.41      10日：3.98      0.96      0.96      0.69      108       累涨修正：24.92     净值区间：83      91      93      94      96      101
        INDEX_CN_BIG.put("159631", "指数-大盘             ");//中证A100ETF           市值：0.96      累涨：16.83     6.60      4.28      5.95      10日：4.45      1.47      1.08      0.58      94        累涨修正：24.91     净值区间：75      83      89      89      94      102
        INDEX_CN_BIG.put("515310", "指数-大盘             ");//沪深300指数ETF        市值：2.80      累涨：17.41     6.24      4.96      6.21      10日：4.45      1.12      0.94      0.77      84        累涨修正：24.86     净值区间：78      84      90      91      94      103
        INDEX_CN_BIG.put("561960", "指数-大盘             ");//央企回报ETF           市值：0.84      累涨：17.18     5.64      5.81      5.73      10日：3.86      2.37      0.72      0.54      93        累涨修正：24.85     净值区间：96      98      98      99      99      104
        INDEX_CN_BIG.put("563350", "指数-大盘             ");//中证A50ETF            市值：5.85      累涨：16.75     6.29      4.31      6.15      10日：4.41      1.29      1.20      0.68      103       累涨修正：24.85     净值区间：69      77      85      85      91      105
        INDEX_CN_BIG.put("159355", "指数-大盘             ");//800红利低波ETF        市值：2.03      累涨：16.43     6.11      4.59      5.73      10日：3.61      2.37      1.22      0.00      91        累涨修正：24.85     净值区间：95      97      97      98      99      106
        INDEX_CN_BIG.put("159515", "指数-大盘             ");//国企红利ETF           市值：0.49      累涨：17.27     7.09      4.94      5.24      10日：2.95      2.41      1.06      0.00      109       累涨修正：24.75     净值区间：90      94      96      96      98      107
        INDEX_CN_BIG.put("561300", "指数-大盘             ");//300增强ETF            市值：14.13     累涨：17.36     6.22      4.88      6.26      10日：4.32      1.18      0.94      0.71      87        累涨修正：24.74     净值区间：72      81      88      89      94      108
        INDEX_CN_BIG.put("159300", "指数-大盘             ");//300ETF                市值：16.27     累涨：17.44     6.48      5.04      5.92      10日：4.22      1.17      0.95      0.90      97        累涨修正：24.73     净值区间：82      88      92      93      96      109
        INDEX_CN_BIG.put("560700", "指数-大盘             ");//央企红利50ETF         市值：7.48      累涨：16.77     5.73      5.46      5.58      10日：4.02      2.38      0.76      0.56      92        累涨修正：24.69     净值区间：92      96      97      97      98      110
        INDEX_CN_BIG.put("512150", "指数-大盘             ");//A50ETF                市值：1.15      累涨：16.78     6.79      4.17      5.82      10日：3.86      1.50      1.26      0.53      120       累涨修正：24.66     净值区间：80      84      90      90      96      111
        INDEX_CN_BIG.put("560070", "指数-大盘             ");//央企红利ETF基金       市值：3.19      累涨：16.69     5.68      5.60      5.41      10日：4.04      2.39      0.76      0.47      91        累涨修正：24.64     净值区间：96      98      98      98      99      112
        INDEX_CN_BIG.put("563080", "指数-大盘             ");//中证A50ETF易方达      市值：30.82     累涨：16.87     6.54      4.27      6.06      10日：4.46      1.21      1.04      0.60      102       累涨修正：24.62     净值区间：67      73      83      83      90      113
        INDEX_CN_BIG.put("512990", "指数-大盘             ");//MSCIA股ETF            市值：2.47      累涨：17.80     7.01      5.01      5.78      10日：3.96      1.10      0.79      0.91      107       累涨修正：24.44     净值区间：97      99      99      99      99      114
        INDEX_CN_BIG.put("159528", "指数-大盘             ");//国企改革ETF           市值：0.31      累涨：17.82     6.45      5.03      6.34      10日：3.52      1.03      1.03      0.19      114       累涨修正：24.43     净值区间：69      79      86      87      89      115
        INDEX_CN_BIG.put("515770", "指数-大盘             ");//摩根MSCIAETF          市值：0.80      累涨：17.70     7.14      4.87      5.69      10日：3.86      1.27      0.76      0.93      104       累涨修正：24.35     净值区间：91      56      56      56      64      116
        INDEX_CN_BIG.put("159390", "指数-大盘             ");//A50指数ETF            市值：3.16      累涨：16.82     6.13      4.60      6.09      10日：4.07      1.21      1.12      0.75      115       累涨修正：24.34     净值区间：70      76      86      74      81      117
        INDEX_CN_BIG.put("515160", "指数-大盘             ");//MSCI中国ETF招商       市值：4.91      累涨：17.74     7.04      4.59      6.11      10日：3.93      0.98      0.83      0.83      116       累涨修正：24.31     净值区间：89      94      97      97      97      118
        INDEX_CN_BIG.put("516830", "指数-大盘             ");//300ESGETF             市值：2.15      累涨：16.80     6.13      4.75      5.92      10日：4.00      1.40      1.05      0.81      46        累涨修正：24.3      净值区间：88      92      96      96      97      119
        INDEX_CN_BIG.put("512520", "指数-大盘             ");//MSCIETF               市值：0.73      累涨：17.73     7.33      4.84      5.56      10日：3.86      1.00      0.83      0.74      123       累涨修正：24.25     净值区间：95      98      99      99      99      120
        INDEX_CN_BIG.put("159510", "指数-大盘             ");//沪深300价值ETF        市值：1.16      累涨：15.21     5.19      4.50      5.52      10日：4.17      2.20      1.31      0.35      124       累涨修正：24.2      净值区间：81      86      90      90      95      121
        INDEX_CN_BIG.put("510880", "指数-大盘             ");//红利ETF               市值：186.56    累涨：15.74     5.34      5.11      5.29      10日：3.50      2.64      1.15      -0.19     118       累涨修正：24.18     净值区间：81      87      90      92      94      122
        INDEX_CN_BIG.put("517300", "指数-大盘             ");//沪港深300ETF          市值：27.95     累涨：19.39     8.34      5.55      5.50      10日：3.74      0.50      0.25      0.98      113       累涨修正：24.13     净值区间：93      94      97      98      99      123
        INDEX_CN_BIG.put("159791", "指数-大盘             ");//300ESGETF             市值：0.32      累涨：16.78     6.36      4.74      5.68      10日：4.27      1.37      0.84      2.00      45        累涨修正：24.1      净值区间：75      80      89      89      91      124
        INDEX_CN_BIG.put("159391", "指数-大盘             ");//大盘价值ETF           市值：0.18      累涨：                    5.13      8.31      10日：5.02      2.64      1.45      -0.36     36        累涨修正：24        净值区间：78      88      96      96              125
        INDEX_CN_BIG.put("515300", "指数-大盘             ");//300红利低波ETF        市值：56.00     累涨：15.26     6.05      4.16      5.05      10日：3.67      2.52      1.21      -0.43     139       累涨修正：23.87     净值区间：68      81      83      76      86      126
        INDEX_CN_BIG.put("560180", "指数-大盘             ");//沪深300ESGETF南方     市值：0.24      累涨：16.43     6.44      4.61      5.38      10日：4.08      1.38      0.98      0.88      48        累涨修正：23.85     净值区间：85      97      97      97      97      127
        INDEX_CN_BIG.put("562000", "指数-大盘             ");//中证A100ETF基金       市值：17.12     累涨：16.93     6.47      4.86      5.60      10日：3.99      1.04      0.83      0.72      126       累涨修正：23.62     净值区间：75      83      90      90      94      128
        INDEX_CN_BIG.put("560380", "指数-大盘             ");//A100ETF南方           市值：1.90      累涨：16.88     6.70      4.53      5.65      10日：3.92      1.00      0.90      0.69      137       累涨修正：23.6      净值区间：74      86      90      90      94      129
        INDEX_CN_BIG.put("510720", "指数-大盘             ");//红利国企ETF           市值：15.58     累涨：16.65     5.99      5.11      5.55      10日：2.96      2.35      0.81      -0.20     121       累涨修正：23.58     净值区间：71      82      85      89      92      130
        INDEX_CN_BIG.put("159393", "指数-大盘             ");//沪深300指数ETF        市值：1.34      累涨：16.51     6.05      4.99      5.47      10日：3.92      1.19      0.98      0.72      129       累涨修正：23.58     净值区间：79      85      90      92      95      131
        INDEX_CN_BIG.put("515450", "指数-大盘             ");//红利低波50ETF         市值：106.68    累涨：15.73     6.19      4.46      5.08      10日：3.35      2.46      1.02      -0.27     135       累涨修正：23.58     净值区间：75      83      86      89      93      132
        INDEX_CN_BIG.put("515100", "指数-大盘             ");//红利低波100ETF        市值：55.53     累涨：15.35     6.40      4.32      4.63      10日：3.62      2.47      1.06      0.07      130       累涨修正：23.56     净值区间：90      93      95      95      97      133
        INDEX_CN_BIG.put("159686", "指数-大盘             ");//A100ETF易方达         市值：0.71      累涨：17.56     7.72      5.05      4.79      10日：3.40      0.87      0.77      0.67      134       累涨修正：23.37     净值区间：73      90      71      71      77      134
        INDEX_CN_BIG.put("159211", "指数-大盘             ");//深证100ETF富国        市值：3.61      累涨：                    7.00      6.89      10日：4.87      1.51      1.51      1.41      37        累涨修正：23.29     净值区间：94      94      97      97              135
        INDEX_CN_BIG.put("512240", "指数-大盘             ");//A50ETF龙头            市值：0.39      累涨：16.76     6.23      4.90      5.63      10日：3.71      1.00      0.90      0.89      140       累涨修正：23.27     净值区间：68      87      87      87      91      136
        INDEX_CN_BIG.put("510990", "指数-大盘             ");//180ESGETF             市值：0.48      累涨：16.36     6.05      4.42      5.89      10日：3.69      1.50      0.86      0.64      49        累涨修正：23.27     净值区间：85      94      94      95      96      137
        INDEX_CN_BIG.put("159589", "指数-大盘             ");//红利ETF广发           市值：0.71      累涨：14.94     5.24      4.54      5.16      10日：3.42      2.46      1.22      0.00      143       累涨修正：23.26     净值区间：90      94      95      97      97      138
        INDEX_CN_BIG.put("159965", "指数-大盘             ");//央视50ETF             市值：0.61      累涨：16.98     6.98      4.68      5.32      10日：3.55      1.20      0.73      0.53      131       累涨修正：23.19     净值区间：81      86      91      91      95      139
        INDEX_CN_BIG.put("562810", "指数-大盘             ");//上证指数增强ETF       市值：0.49      累涨：17.37     6.98      4.76      5.63      10日：3.37      1.06      0.67      0.95      133       累涨修正：23.14     净值区间：40      50      68      68      80      140
        INDEX_CN_BIG.put("560020", "指数-大盘             ");//红利ETF汇添富         市值：0.74      累涨：14.74     5.29      4.20      5.25      10日：3.58      2.56      1.09      -0.18     144       累涨修正：23.06     净值区间：82      91      94      76      81      141
        INDEX_CN_BIG.put("159923", "指数-大盘             ");//中证A100ETF基金       市值：0.26      累涨：16.39     6.94      3.83      5.62      10日：3.70      1.07      0.90      0.73      146       累涨修正：22.96     净值区间：71      85      90      90      93      142
        INDEX_CN_BIG.put("510710", "指数-大盘             ");//上证50ETF博时         市值：5.81      累涨：16.45     6.62      4.26      5.57      10日：4.16      1.01      0.66      0.58      136       累涨修正：22.94     净值区间：71      80      89      89      93      143
        INDEX_CN_BIG.put("515180", "指数-大盘             ");//红利ETF易方达         市值：83.32     累涨：14.83     5.53      4.29      5.01      10日：3.32      2.51      1.14      0.00      152       累涨修正：22.94     净值区间：90      94      95      96      97      144
        INDEX_CN_BIG.put("512040", "指数-大盘             ");//价值100ETF            市值：13.63     累涨：16.38     6.49      5.30      4.59      10日：3.65      1.66      0.62      0.51      110       累涨修正：22.93     净值区间：94      96      98      98      99      145
        INDEX_CN_BIG.put("530280", "指数-大盘             ");//上证180ETF指数基金    市值：1.62      累涨：16.74     6.24      4.98      5.52      10日：3.87      1.15      0.57      0.66      128       累涨修正：22.9      净值区间：100     100     100     100     100     146
        INDEX_CN_BIG.put("510040", "指数-大盘             ");//上证180ETF指数        市值：0.62      累涨：16.37     6.34      4.84      5.19      10日：3.59      1.09      0.89      0.88      145       累涨修正：22.83     净值区间：29      42      44      50      53      147
        INDEX_CN_BIG.put("159661", "指数-大盘             ");//A100ETF嘉实           市值：0.30      累涨：16.42     6.30      4.48      5.64      10日：3.94      1.05      0.70      0.86      141       累涨修正：22.81     净值区间：76      87      91      91      95      148
        INDEX_CN_BIG.put("159627", "指数-大盘             ");//A100ETF               市值：0.40      累涨：16.45     6.69      4.28      5.48      10日：3.77      1.03      0.75      0.93      148       累涨修正：22.75     净值区间：73      87      90      52      60      149
        INDEX_CN_BIG.put("561060", "指数-大盘             ");//国企红利ETF           市值：0.48      累涨：16.07     5.75      5.53      4.79      10日：2.83      2.19      0.81      0.18      127       累涨修正：22.71     净值区间：16      25      31      35      49      150
        INDEX_CN_BIG.put("512910", "指数-大盘             ");//中证A100ETF           市值：2.98      累涨：16.09     6.16      4.56      5.37      10日：3.89      0.96      0.86      0.76      162       累涨修正：22.66     净值区间：77      84      90      90      94      151
        INDEX_CN_BIG.put("510100", "指数-大盘             ");//上证50ETF易方达       市值：44.11     累涨：16.04     6.02      4.04      5.98      10日：3.92      1.09      0.80      0.58      150       累涨修正：22.65     净值区间：75      83      90      90      94      152
        INDEX_CN_BIG.put("159336", "指数-大盘             ");//央企红利50ETF         市值：2.54      累涨：17.40     7.13      5.37      4.90      10日：3.41      1.06      0.29      0.10      125       累涨修正：22.45     净值区间：92      97      98      98      99      153
        INDEX_CN_BIG.put("510050", "指数-大盘             ");//上证50ETF             市值：1661.81   累涨：16.02     5.81      4.19      6.02      10日：3.98      1.03      0.71      0.60      147       累涨修正：22.45     净值区间：76      82      90      90      94      154
        INDEX_CN_BIG.put("510980", "指数-大盘             ");//上证综合ETF           市值：2.46      累涨：17.14     7.46      4.19      5.49      10日：3.41      0.84      0.50      0.75      158       累涨修正：22.39     净值区间：95      97      98      99      99      155
        INDEX_CN_BIG.put("510850", "指数-大盘             ");//上证50ETF工银         市值：2.00      累涨：16.06     6.22      3.60      6.24      10日：4.04      0.97      0.66      0.56      138       累涨修正：22.39     净值区间：78      84      92      92      95      156
        INDEX_CN_BIG.put("515080", "指数-大盘             ");//中证红利ETF           市值：66.99     累涨：14.36     5.24      4.27      4.85      10日：3.39      2.47      1.03      0.19      154       累涨修正：22.28     净值区间：97      98      98      98      99      157
        INDEX_CN_BIG.put("530000", "指数-大盘             ");//上证50ETF天弘         市值：17.89     累涨：16.40     5.98      4.29      6.13      10日：3.73      0.96      0.56      0.40      153       累涨修正：22.21     净值区间：73      77      89      89      93      158
        INDEX_CN_BIG.put("561880", "指数-大盘             ");//A100ETF基金           市值：3.01      累涨：15.64     6.47      4.39      4.78      10日：3.79      1.05      0.86      0.48      161       累涨修正：22.2      净值区间：67      81      85      85      92      159
        INDEX_CN_BIG.put("159549", "指数-大盘             ");//红利低波ETF天弘       市值：39.85     累涨：13.91     5.62      4.17      4.12      10日：3.34      2.39      1.27      0.17      166       累涨修正：22.18     净值区间：96      98      98      98      99      160
        INDEX_CN_BIG.put("530680", "指数-大盘             ");//上证180指数ETF基金    市值：4.29      累涨：15.85     5.94      4.99      4.92      10日：3.52      1.16      0.77      0.77      151       累涨修正：22.07     净值区间：95      97      98      98      99      161
        INDEX_CN_BIG.put("530080", "指数-大盘             ");//上证180ETF天弘        市值：0.39      累涨：16.05     5.81      4.75      5.49      10日：3.64      0.85      0.76      0.66      169       累涨修正：22.06     净值区间：89      95      96      96      98      162
        INDEX_CN_BIG.put("510800", "指数-大盘             ");//50ETF基金             市值：4.81      累涨：15.69     5.73      3.93      6.03      10日：3.99      0.95      0.71      0.63      160       累涨修正：22.05     净值区间：75      82      90      90      94      163
        INDEX_CN_BIG.put("510950", "指数-大盘             ");//上证50ETF广发         市值：0.79      累涨：15.76     5.87      3.75      6.14      10日：3.89      0.97      0.70      0.61      156       累涨修正：22.02     净值区间：79      87      90      94      97      164
        INDEX_CN_BIG.put("530800", "指数-大盘             ");//上证180ETF基金        市值：0.41      累涨：15.96     6.76      3.89      5.31      10日：3.37      1.15      0.76      0.38      163       累涨修正：22        净值区间：89      94      98      98      77      165
        INDEX_CN_BIG.put("510060", "指数-大盘             ");//央企ETF               市值：1.27      累涨：16.53     6.07      4.49      5.97      10日：3.22      1.00      0.58      0.08      165       累涨修正：21.91     净值区间：79      76      89      91      94      166
        INDEX_CN_BIG.put("510180", "指数-大盘             ");//上证180ETF            市值：210.32    累涨：16.25     6.56      4.26      5.43      10日：3.70      0.67      0.61      0.74      170       累涨修正：21.84     净值区间：89      94      96      96      97      167
        INDEX_CN_BIG.put("530580", "指数-大盘             ");//上证180ETF南方        市值：1.70      累涨：16.55     6.95      4.36      5.24      10日：3.42      0.80      0.50      0.59      164       累涨修正：21.77     净值区间：88      94      95      96      98      168
        INDEX_CN_BIG.put("510270", "指数-大盘             ");//国企ETF               市值：0.22      累涨：16.06     5.55      4.67      5.84      10日：3.45      1.09      0.58      0.07      159       累涨修正：21.76     净值区间：72      84      92      92      96      169
        INDEX_CN_BIG.put("510190", "指数-大盘             ");//上证50ETF指数基金     市值：1.72      累涨：16.03     6.08      4.13      5.82      10日：3.60      0.87      0.51      0.66      173       累涨修正：21.52     净值区间：82      92      94      94      95      170
        INDEX_CN_BIG.put("159307", "指数-大盘             ");//红利低波100ETF        市值：10.23     累涨：13.53     5.59      4.23      3.71      10日：3.24      2.28      1.23      0.09      172       累涨修正：21.51     净值区间：95      97      98      98      98      171
        INDEX_CN_BIG.put("530180", "指数-大盘             ");//上证180ETF易方达      市值：1.19      累涨：15.83     6.17      4.65      5.01      10日：3.50      0.89      0.59      0.79      177       累涨修正：21.4      净值区间：83      93      93      94      96      172
        INDEX_CN_BIG.put("561900", "指数-大盘             ");//沪深300ESGETF         市值：0.41      累涨：15.35     5.73      4.57      5.05      10日：3.48      1.07      0.71      0.82      53        累涨修正：21.32     净值区间：50      69      72      72      81      173
        INDEX_CN_BIG.put("510600", "指数-大盘             ");//申万上证50ETF         市值：0.53      累涨：15.13     5.65      3.72      5.76      10日：3.76      1.03      0.68      0.59      175       累涨修正：21.28     净值区间：73      89      92      92      94      174
        INDEX_CN_BIG.put("512390", "指数-大盘             ");//平安MSCI低波ETF       市值：1.87      累涨：16.29     8.26      3.89      4.14      10日：2.70      1.35      0.45      0.00      149       累涨修正：21.24     净值区间：88      95      43      43      61      175
        INDEX_CN_BIG.put("530050", "指数-大盘             ");//上证50ETF东财         市值：2.11      累涨：16.10     5.91      4.48      5.71      10日：3.37      0.77      0.48      0.47      180       累涨修正：21.2      净值区间：22      31      53      53      62      176
        INDEX_CN_BIG.put("510680", "指数-大盘             ");//上证50ETF基金         市值：0.82      累涨：15.44     5.58      3.94      5.92      10日：3.55      0.90      0.48      0.42      179       累涨修正：20.85     净值区间：74      79      89      89      93      177
        INDEX_CN_BIG.put("159207", "指数-大盘             ");//高股息ETF             市值：3.68      累涨：16.07     7.03      5.60      3.44      10日：2.58      1.42      0.38      0.19      122       累涨修正：20.83     净值区间：86      93      98      98      98      178
        INDEX_CN_BIG.put("530300", "指数-大盘             ");//上证180ETF华泰柏瑞    市值：1.25      累涨：15.59     6.46      4.09      5.04      10日：3.38      0.77      0.48      0.76      182       累涨修正：20.7      净值区间：95      51      51      51      51      179
        INDEX_CN_BIG.put("510020", "指数-大盘             ");//超大盘ETF             市值：1.45      累涨：16.00     5.31      4.90      5.79      10日：3.27      0.55      0.37      0.67      176       累涨修正：20.56     净值区间：69      80      88      88      74      180
        INDEX_CN_BIG.put("563700", "指数-大盘             ");//红利价值ETF           市值：0.54      累涨：                    6.10      6.10      10日：3.31      2.36      1.32      0.09      101       累涨修正：20.51     净值区间：88      92      94      96              181
        INDEX_CN_BIG.put("561790", "指数-大盘             ");//央企现代能源ETF       市值：0.46      累涨：15.05     5.59      4.72      4.74      10日：2.87      1.66      0.46      0.09      26        累涨修正：20.5      净值区间：83      93      94      96      97      182
        INDEX_CN_BIG.put("159581", "指数-大盘             ");//红利ETF基金           市值：23.82     累涨：13.30     4.73      4.11      4.46      10日：3.08      2.01      1.05      0.19      178       累涨修正：20.49     净值区间：95      97      98      98      99      183
        INDEX_CN_BIG.put("515990", "指数-大盘             ");//国企一带一路ETF       市值：0.97      累涨：16.81     7.83      4.56      4.42      10日：2.37      0.79      0.24      0.54      171       累涨修正：20.45     净值区间：93      94      94      95      96      184
        INDEX_CN_BIG.put("515110", "指数-大盘             ");//一带一路ETF易方达     市值：2.89      累涨：15.96     6.67      4.82      4.47      10日：2.46      1.19      0.37      0.66      155       累涨修正：20.35     净值区间：100     100     72      80      83      185
        INDEX_CN_BIG.put("560810", "指数-大盘             ");//央企ESGETF            市值：4.98      累涨：13.33     3.31      4.97      5.05      10日：4.00      1.36      0.73      0.51      51        累涨修正：20.15     净值区间：94      97      98      98      98      186
        INDEX_CN_BIG.put("562850", "指数-大盘             ");//央企能源ETF           市值：0.96      累涨：14.73     4.81      4.90      5.02      10日：2.88      1.57      0.46      0.09      27        累涨修正：20.1      净值区间：77      90      91      93      96      187
        INDEX_CN_BIG.put("515150", "指数-大盘             ");//一带一路ETF           市值：7.09      累涨：16.03     6.66      4.65      4.72      10日：2.27      1.01      0.31      0.47      174       累涨修正：19.93     净值区间：86      92      93      94      96      188
        INDEX_CN_BIG.put("159219", "指数-大盘             ");//深证100ETF融通        市值：0.25      累涨：                              8.03      10日：6.13      1.85      1.85      1.46      76        累涨修正：19.71     净值区间：84      90      93      93              189
        INDEX_CN_BIG.put("159974", "指数-大盘             ");//央企创新ETF           市值：1.35      累涨：14.65     5.58      4.66      4.41      10日：2.93      0.82      0.44      0.25      185       累涨修正：19.28     净值区间：89      95      97      97      98      190
        INDEX_CN_BIG.put("560820", "指数-大盘             ");//中证A50ETF新华        市值：0.13      累涨：                    4.81      6.02      10日：4.26      1.44      1.34      0.48      111       累涨修正：19.21     净值区间：62      80      80      80              191
        INDEX_CN_BIG.put("515900", "指数-大盘             ");//央企创新驱动ETF       市值：33.72     累涨：14.72     5.78      4.56      4.38      10日：3.12      0.82      0.27      0.34      184       累涨修正：19.2      净值区间：90      95      97      97      97      192
        INDEX_CN_BIG.put("563180", "指数-大盘             ");//高股息ETF             市值：3.91      累涨：14.45     4.96      5.61      3.88      10日：2.64      1.70      0.19      0.09      142       累涨修正：19.17     净值区间：72      82      85      85      92      193
        INDEX_CN_BIG.put("515680", "指数-大盘             ");//央企创新ETF嘉实       市值：18.42     累涨：14.88     6.04      4.40      4.44      10日：3.11      0.75      0.21      0.48      187       累涨修正：19.16     净值区间：95      98      98      98      99      194
        INDEX_CN_BIG.put("159719", "指数-大盘             ");//国企共赢ETF           市值：0.92      累涨：14.13     4.90      4.93      4.30      10日：2.21      1.50      0.58      -0.06     167       累涨修正：19        净值区间：83      84      69      83      90      195
        INDEX_CN_BIG.put("512280", "指数-大盘             ");//MSCIA股ETF景顺        市值：0.32      累涨：16.00     6.85      6.01      3.14      10日：1.74      0.63      0.28      0.00      157       累涨修正：18.93     净值区间：25      4       14      19      38      196
        INDEX_CN_BIG.put("159905", "指数-大盘             ");//深红利ETF             市值：23.45     累涨：13.63     5.10      4.53      4.00      10日：2.90      1.17      0.55      0.43      183       累涨修正：18.8      净值区间：56      72      81      61      61      197
        INDEX_CN_BIG.put("515600", "指数-大盘             ");//央企创新ETF           市值：17.92     累涨：14.16     5.42      4.22      4.52      10日：3.19      0.75      0.27      0.41      189       累涨修正：18.64     净值区间：89      95      97      97      97      198
        INDEX_CN_BIG.put("510320", "指数-大盘             ");//沪深300ETF中金        市值：4.84      累涨：                    4.76      6.19      10日：4.04      1.34      1.05      0.76      112       累涨修正：18.43     净值区间：82      29      39      45              199
        INDEX_CN_BIG.put("159708", "指数-大盘             ");//红利ETF               市值：2.26      累涨：13.86     5.37      4.61      3.88      10日：2.72      1.03      0.39      0.51      186       累涨修正：18.39     净值区间：64      79      86      68      68      200
        INDEX_CN_BIG.put("517090", "指数-大盘             ");//央企共赢ETF           市值：2.60      累涨：14.71     5.20      5.50      4.01      10日：2.00      1.00      0.33      0.13      181       累涨修正：18.37     净值区间：86      93      80      89      94      201
        INDEX_CN_BIG.put("512950", "指数-大盘             ");//央企改革ETF           市值：55.53     累涨：14.25     5.86      4.24      4.15      10日：2.85      0.47      0.39      0.53      190       累涨修正：18.35     净值区间：94      97      98      98      98      202
        INDEX_CN_BIG.put("512250", "指数-大盘             ");//中证A50ETF招商        市值：0.12      累涨：                    4.71      5.88      10日：3.97      1.31      1.22      0.28      132       累涨修正：18.31     净值区间：39      55      66      31              203
        INDEX_CN_BIG.put("517180", "指数-大盘             ");//中国国企ETF           市值：5.94      累涨：13.80     4.30      5.28      4.22      10日：1.87      1.24      0.34      0.48      168       累涨修正：17.59     净值区间：100     100     77      86      91      204
        INDEX_CN_BIG.put("512960", "指数-大盘             ");//央企结构调整ETF       市值：51.91     累涨：13.04     5.56      3.75      3.73      10日：2.69      0.39      0.39      0.55      192       累涨修正：16.9      净值区间：83      91      93      93      95      205
        INDEX_CN_BIG.put("159959", "指数-大盘             ");//央企ETF               市值：28.19     累涨：12.32     3.94      4.21      4.17      10日：2.75      0.49      0.42      0.70      191       累涨修正：16.4      净值区间：94      97      98      98      98      206
        INDEX_CN_BIG.put("561750", "指数-大盘             ");//中证A50ETF博时        市值：1.77      累涨：                              5.25      10日：3.52      1.00      1.00      0.40      188       累涨修正：11.77     净值区间：59      69      81                      207
        INDEX_CN_BIG.put("563060", "指数-大盘             ");//央企50ETF             市值：0.21      累涨：                              3.29      10日：1.39      0.20      0.10      0.00      193       累涨修正：5.08      净值区间：50      77      81                      208
        INDEX_CN_BIG.put("159228", "指数-大盘             ");//红利低波ETF长城       市值：2.76      累涨：                                        10日：3.08      2.18      1.08      -0.10               累涨修正：          净值区间：83      87                              209
        INDEX_CN_BIG.put("510810", "指数-大盘             ");//上海国企ETF           市值：80.41     累涨：                                        10日：                              0.23                累涨修正：          净值区间：                                        210
        INDEX_CN_BIG.put("159263", "指数-大盘             ");//价值ETF               市值：4.68      累涨：                                        10日：                              0.20                累涨修正：          净值区间：                                        211
        INDEX_CN_BIG.put("563900", "指数-大盘             ");//XD沪深300自由现金流ETF摩根市值：2.19      累涨：                                        10日：                              0.19                累涨修正：          净值区间：                                        212
        INDEX_CN_BIG.put("561770", "指数-大盘             ");//中证A100指数ETF       市值：1.83      累涨：                                        10日：2.56      0.88      0.78      0.58                累涨修正：          净值区间：76      83                              213
        INDEX_CN_BIG.put("159238", "指数-大盘             ");//300ETF增强            市值：0.88      累涨：                              6.59      10日：4.39      1.64      1.06      0.67                累涨修正：          净值区间：95      97      98                      214
        INDEX_CN_BIG.put("562080", "指数-大盘             ");//300现金流ETF          市值：1.80      累涨：                                        10日：                              -0.09               累涨修正：          净值区间：                                        215
    }

    public static Map<String, String> INDEX_CN_CITY = new HashMap<>();//指数-国内城市

    static {
        INDEX_CN_CITY.put("159976", "指数-国内城市         ");//湾创ETF               市值：1.19      累涨：33.24     7.08      16.06     13.43     8.12      4.73      1
        INDEX_CN_CITY.put("512970", "指数-国内城市         ");//大湾区ETF             市值：0.75      累涨：29.62     9.03      14.23     9.72      6.35      4.34      2
        INDEX_CN_CITY.put("159623", "指数-国内城市         ");//成渝经济圈ETF         市值：32.83     累涨：29.66     7.39      17.26     8.94      5.74      3.04      3
        INDEX_CN_CITY.put("159743", "指数-国内城市         ");//湖北ETF               市值：1.57      累涨：40.34     12.22     20.84     14.69     5.67      2.86      4
        INDEX_CN_CITY.put("517160", "指数-国内城市         ");//长江保护主题ETF       市值：13.73     累涨：22.55     4.70      11.26     9.63      5.63      4.10      5
        INDEX_CN_CITY.put("512870", "指数-国内城市         ");//杭州湾区ETF           市值：0.41      累涨：33.69     11.23     17.08     12.09     5.51      3.32      6
        INDEX_CN_CITY.put("517330", "指数-国内城市         ");//长江保护ETF           市值：13.72     累涨：22.51     4.98      11.97     8.90      5.47      3.81      7
        INDEX_CN_CITY.put("515760", "指数-国内城市         ");//浙江国资ETF           市值：1.78      累涨：22.05     6.08      11.51     7.53      5.15      2.60      8
        INDEX_CN_CITY.put("517850", "指数-国内城市         ");//张江ETF               市值：0.63      累涨：47.34     14.21     25.01     15.55     5.06      2.61      9
        INDEX_CN_CITY.put("512650", "指数-国内城市         ");//长三角ETF             市值：3.94      累涨：25.38     7.56      13.08     9.40      5.01      3.10      10
        INDEX_CN_CITY.put("512190", "指数-国内城市         ");//浙商之江凤凰ETF       市值：0.61      累涨：19.24     6.80      9.42      7.09      3.58      2.79      15
        INDEX_CN_CITY.put("510810", "指数-国内城市         ");//上海国企ETF           市值：76.95     累涨：20.42     7.35      10.53     5.90      3.39      2.18      16
    }

    public static Map<String, String> INDEX = new HashMap<>();//指数-全部-etf

    static {
        INDEX.putAll(INDEX_CN_NOT);
        INDEX.putAll(INDEX_CN_NOT_USA);
        INDEX.putAll(INDEX_CN_BIG);
        INDEX.putAll(INDEX_CN_1000);
        INDEX.putAll(INDEX_688);
        INDEX.putAll(INDEX_300);
        INDEX.putAll(INDEX_CN_CITY);
//        INDEX.putAll(INDEX_HK);
    }

    public static Map<String, String> TOP_INDEX = new HashMap<>();//指数-全部-etf

    static {
        TOP_INDEX.putAll(TOP_INDEX_CN_NOT);
        TOP_INDEX.putAll(TOP_INDEX_CN_NOT_USA);
        TOP_INDEX.putAll(TOP_INDEX_CN_BIG);
        TOP_INDEX.putAll(TOP_INDEX_CN_1000);
        TOP_INDEX.putAll(TOP_INDEX_688);
        TOP_INDEX.putAll(TOP_INDEX_300);
//        TOP_INDEX.putAll(TOP_INDEX_CN_CITY);
//        TOP_INDEX.putAll(INDEX_HK);
    }

    /**
     * 金融
     */
    public static Map<String, String> TOP_JINRONG_GOLD = new HashMap<>();
    static {
        TOP_JINRONG_GOLD.put("517400", ContEtfTypeName.JINRONG_GOLD);//黄金股票ETF           市值：1.05      累涨：36.21     10.78     13.43     12.00     10日：6.95      4.62      3.75      -0.92     2         累涨修正：55.28     净值区间：57      59      59      57      65      1
    }
    public static Map<String, String> JINRONG_GOLD = new HashMap<>();
    static {
        JINRONG_GOLD.put("517400", ContEtfTypeName.JINRONG_GOLD);//黄金股票ETF           市值：1.05      累涨：36.21     10.78     13.43     12.00     10日：6.95      4.62      3.75      -0.92     2         累涨修正：55.28     净值区间：57      59      59      57      65      1
        JINRONG_GOLD.put("517520", ContEtfTypeName.JINRONG_GOLD);//黄金股ETF             市值：44.70     累涨：36.72     10.90     13.85     11.97     10日：7.08      4.40      3.44      -1.12     1         累涨修正：55.08     净值区间：48      54      55      72      80      2
        JINRONG_GOLD.put("159322", ContEtfTypeName.JINRONG_GOLD);//黄金股票ETF基金       市值：0.32      累涨：36.62     10.21     14.93     11.48     10日：6.48      4.39      3.21      -1.13     3         累涨修正：53.91     净值区间：48      51      51      47      64      3
        JINRONG_GOLD.put("159321", ContEtfTypeName.JINRONG_GOLD);//黄金股票ETF           市值：1.07      累涨：36.23     10.47     14.42     11.34     10日：6.23      4.02      3.40      -0.51     5         累涨修正：53.28     净值区间：57      59      61      69      76      4
        JINRONG_GOLD.put("159562", ContEtfTypeName.JINRONG_GOLD);//黄金股ETF             市值：6.11      累涨：35.20     10.28     13.53     11.39     10日：6.60      4.21      3.33      -0.91     4         累涨修正：52.67     净值区间：52      56      72      77      82      5
        JINRONG_GOLD.put("159315", ContEtfTypeName.JINRONG_GOLD);//黄金股ETF基金         市值：0.46      累涨：36.10     10.94     14.25     10.91     10日：5.78      3.70      3.20      -0.81     6         累涨修正：51.98     净值区间：52      53      61      60      69      6
        JINRONG_GOLD.put("518600", ContEtfTypeName.JINRONG_GOLD);//上海金ETF             市值：21.11     累涨：22.50     8.74      7.38      6.38      10日：3.81      2.08      2.00      -1.71     9         累涨修正：32.39     净值区间：22      29      53      71      78      7
        JINRONG_GOLD.put("518860", ContEtfTypeName.JINRONG_GOLD);//黄金ETFAU             市值：20.93     累涨：21.42     8.89      6.09      6.44      10日：3.94      2.11      2.03      -1.73     7         累涨修正：31.53     净值区间：19      29      53      42      58      8
        JINRONG_GOLD.put("518680", ContEtfTypeName.JINRONG_GOLD);//金ETF                 市值：28.12     累涨：21.25     8.86      5.95      6.44      10日：3.78      2.06      1.98      -1.70     8         累涨修正：31.05     净值区间：21      29      54      43      59      9
        JINRONG_GOLD.put("518890", ContEtfTypeName.JINRONG_GOLD);//中银上海金ETF         市值：19.59     累涨：21.24     8.71      6.15      6.38      10日：3.83      2.01      1.91      -1.64     10        累涨修正：30.9      净值区间：19      27      57      43      54      10
        JINRONG_GOLD.put("159830", ContEtfTypeName.JINRONG_GOLD);//上海金ETF             市值：15.06     累涨：20.94     8.66      5.80      6.48      10日：3.82      2.06      2.01      -1.69     11        累涨修正：30.84     净值区间：20      28      53      42      58      11
        JINRONG_GOLD.put("159812", ContEtfTypeName.JINRONG_GOLD);//黄金基金ETF           市值：10.85     累涨：21.08     8.80      5.87      6.41      10日：3.75      1.98      1.97      -1.69     15        累涨修正：30.75     净值区间：20      29      53      38      60      12
        JINRONG_GOLD.put("518880", ContEtfTypeName.JINRONG_GOLD);//黄金ETF               市值：581.37    累涨：21.05     8.83      5.89      6.33      10日：3.75      2.03      1.95      -1.64     13        累涨修正：30.73     净值区间：21      29      55      42      57      13
        JINRONG_GOLD.put("518800", ContEtfTypeName.JINRONG_GOLD);//黄金基金ETF           市值：178.71    累涨：21.06     8.78      5.89      6.39      10日：3.74      2.04      1.94      -1.62     12        累涨修正：30.72     净值区间：21      28      53      42      58      14
        JINRONG_GOLD.put("518660", ContEtfTypeName.JINRONG_GOLD);//黄金ETF基金           市值：34.93     累涨：20.96     8.76      5.96      6.24      10日：3.71      2.01      1.92      -1.66     16        累涨修正：30.52     净值区间：20      29      54      43      58      15
        JINRONG_GOLD.put("518850", ContEtfTypeName.JINRONG_GOLD);//黄金ETF华夏           市值：45.27     累涨：20.98     8.76      5.88      6.34      10日：3.71      2.00      1.91      -1.62     18        累涨修正：30.51     净值区间：21      30      54      43      59      16
        JINRONG_GOLD.put("159937", ContEtfTypeName.JINRONG_GOLD);//黄金ETF基金           市值：287.48    累涨：20.85     8.64      5.89      6.32      10日：3.74      2.00      1.96      -1.65     19        累涨修正：30.51     净值区间：20      28      53      42      58      17
        JINRONG_GOLD.put("159831", ContEtfTypeName.JINRONG_GOLD);//上海金ETF嘉实         市值：6.82      累涨：20.74     8.64      5.70      6.40      10日：3.82      2.02      1.95      -1.64     14        累涨修正：30.48     净值区间：20      30      54      43      65      18
        JINRONG_GOLD.put("159834", ContEtfTypeName.JINRONG_GOLD);//金ETF                 市值：9.36      累涨：20.66     8.42      5.86      6.38      10日：3.80      2.05      1.97      -1.68     17        累涨修正：30.45     净值区间：20      28      53      37      58      19
        JINRONG_GOLD.put("159934", ContEtfTypeName.JINRONG_GOLD);//黄金ETF               市值：257.17    累涨：20.83     8.69      5.87      6.27      10日：3.70      1.99      1.91      -1.61     20        累涨修正：30.34     净值区间：21      29      54      42      58      20
    }

    public static Map<String, String> TOP_JINRONG_BANK = new HashMap<>();
    static {
        TOP_JINRONG_BANK.put("512700", ContEtfTypeName.JINRONG_BANK);//银行ETF南方           市值：15.79     累涨：29.33     9.62      10.37     9.34      10日：3.25      1.25      0.57      -1.42     1         累涨修正：34.97     净值区间：4       2       19      54      67      1
    }
    public static Map<String, String> JINRONG_BANK = new HashMap<>();
    static {
        JINRONG_BANK.put("512700", ContEtfTypeName.JINRONG_BANK);//银行ETF南方           市值：15.79     累涨：29.33     9.62      10.37     9.34      10日：3.25      1.25      0.57      -1.42     1         累涨修正：34.97     净值区间：4       2       19      54      67      1
        JINRONG_BANK.put("517900", ContEtfTypeName.JINRONG_BANK);//银行AH优选ETF         市值：9.12      累涨：29.54     10.59     11.39     7.56      10日：2.74      0.99      0.75      -0.74     2         累涨修正：34.77     净值区间：17      9       24      60      72      2
        JINRONG_BANK.put("512730", ContEtfTypeName.JINRONG_BANK);//银行ETF指数           市值：1.11      累涨：28.77     9.34      10.25     9.18      10日：2.71      1.24      0.68      -1.12     6         累涨修正：34.08     净值区间：22      12      27      58      70      3
        JINRONG_BANK.put("512800", ContEtfTypeName.JINRONG_BANK);//银行ETF               市值：141.00    累涨：28.34     9.68      10.30     8.36      10日：3.06      1.04      0.58      -1.49     5         累涨修正：33.6      净值区间：3       2       0       0       0       4
        JINRONG_BANK.put("515290", ContEtfTypeName.JINRONG_BANK);//银行ETF天弘           市值：58.42     累涨：28.88     9.91      10.37     8.60      10日：2.58      1.08      0.51      -1.22     3         累涨修正：33.56     净值区间：10      5       23      57      69      5
        JINRONG_BANK.put("515020", ContEtfTypeName.JINRONG_BANK);//银行ETF基金           市值：6.27      累涨：28.92     9.71      10.37     8.84      10日：2.61      0.92      0.38      -1.08     4         累涨修正：33.21     净值区间：12      6       23      56      68      6
        JINRONG_BANK.put("512820", ContEtfTypeName.JINRONG_BANK);//银行ETF龙头           市值：10.22     累涨：28.54     9.45      10.42     8.67      10日：2.25      1.05      0.53      -1.44     7         累涨修正：32.9      净值区间：4       2       19      54      67      7
        JINRONG_BANK.put("516310", ContEtfTypeName.JINRONG_BANK);//银行ETF易方达         市值：20.93     累涨：28.69     10.02     10.97     7.70      10日：2.53      0.90      0.28      -1.39     8         累涨修正：32.68     净值区间：4       2       20      54      67      8
        JINRONG_BANK.put("159887", ContEtfTypeName.JINRONG_BANK);//银行ETF               市值：9.95      累涨：27.77     9.45      9.91      8.41      10日：2.56      0.98      0.35      -1.48     9         累涨修正：32.01     净值区间：2       1       19      54      67      9
        JINRONG_BANK.put("516210", ContEtfTypeName.JINRONG_BANK);//银行ETF指数基金       市值：1.80      累涨：27.96     9.60      10.22     8.14      10日：2.19      0.94      0.34      -1.42     10        累涨修正：31.77     净值区间：2       1       20      43      57      10
    }

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

    public static Map<String, String> TOP_JINRONG_FANGDICHAN = new HashMap<>();//金融-地产

    static {
        TOP_JINRONG_FANGDICHAN.put("159787", ContEtfTypeName.JINRONG_FANGDICHAN);//建材ETF易方达         市值：3.24      累涨：24.33     3.70      6.38      14.25     10日：9.12      6.94      6.00      0.00      2         累涨修正：52.39     净值区间：51      52      61      65      65      1
    }

    public static Map<String, String> JINRONG_FANGDICHAN = new HashMap<>();//金融-地产

    static {
        JINRONG_FANGDICHAN.put("159787", ContEtfTypeName.JINRONG_FANGDICHAN);//建材ETF易方达         市值：3.24      累涨：24.33     3.70      6.38      14.25     10日：9.12      6.94      6.00      0.00      2         累涨修正：52.39     净值区间：51      52      61      65      65      1
        JINRONG_FANGDICHAN.put("159745", ContEtfTypeName.JINRONG_FANGDICHAN);//建材ETF               市值：20.37     累涨：24.77     4.38      6.79      13.60     10日：8.54      6.34      6.00      0.76      3         累涨修正：51.65     净值区间：63      63      70      73      73      2
        JINRONG_FANGDICHAN.put("516970", ContEtfTypeName.JINRONG_FANGDICHAN);//基建50ETF             市值：34.53     累涨：23.16     6.02      6.25      10.89     10日：8.66      7.00      6.00      1.18      1         累涨修正：50.82     净值区间：67      68      73      77      77      3
        JINRONG_FANGDICHAN.put("516750", ContEtfTypeName.JINRONG_FANGDICHAN);//建材ETF               市值：11.06     累涨：23.97     3.53      6.84      13.60     10日：8.17      6.31      6.00      -0.42     5         累涨修正：50.45     净值区间：55      55      63      67      67      4
        JINRONG_FANGDICHAN.put("159619", ContEtfTypeName.JINRONG_FANGDICHAN);//基建ETF               市值：4.46      累涨：22.18     5.14      5.61      11.43     10日：8.26      6.82      6.00      0.66      4         累涨修正：49.26     净值区间：61      62      67      71      71      5
        JINRONG_FANGDICHAN.put("516950", ContEtfTypeName.JINRONG_FANGDICHAN);//基建ETF               市值：10.41     累涨：22.69     5.33      6.05      11.31     10日：7.96      6.56      6.00      0.26      7         累涨修正：49.21     净值区间：61      63      68      72      72      6
        JINRONG_FANGDICHAN.put("159635", ContEtfTypeName.JINRONG_FANGDICHAN);//基建50ETF             市值：3.86      累涨：21.81     4.76      6.31      10.74     10日：7.95      6.68      6.00      0.18      8         累涨修正：48.44     净值区间：59      61      66      70      70      7
        JINRONG_FANGDICHAN.put("512200", ContEtfTypeName.JINRONG_FANGDICHAN);//房地产ETF             市值：66.78     累涨：25.09     5.88      8.42      10.79     10日：6.74      2.97      2.33      1.96      6         累涨修正：39.46     净值区间：86      88      92      94      94      8
        JINRONG_FANGDICHAN.put("159933", ContEtfTypeName.JINRONG_FANGDICHAN);//国投金融地产ETF       市值：1.50      累涨：27.22     8.25      11.43     7.54      10日：4.00      1.98      1.33      -1.09     9         累涨修正：35.86     净值区间：57      32      67      77      84      9
        JINRONG_FANGDICHAN.put("515060", ContEtfTypeName.JINRONG_FANGDICHAN);//房地产ETF基金         市值：6.71      累涨：23.51     5.58      8.22      9.71      10日：5.67      2.52      2.07      1.62      11        累涨修正：35.84     净值区间：84      87      91      94      94      10
        JINRONG_FANGDICHAN.put("159707", ContEtfTypeName.JINRONG_FANGDICHAN);//地产ETF               市值：5.23      累涨：20.50     3.36      6.61      10.53     10日：6.94      3.29      1.63      2.42      10        累涨修正：33.99     净值区间：86      88      92      94      94      11
        JINRONG_FANGDICHAN.put("159768", ContEtfTypeName.JINRONG_FANGDICHAN);//房地产ETF             市值：6.56      累涨：20.60     3.17      6.98      10.45     10日：6.65      3.29      1.45      2.33      12        累涨修正：33.44     净值区间：91      92      94      96      96      12
        JINRONG_FANGDICHAN.put("159940", ContEtfTypeName.JINRONG_FANGDICHAN);//金融地产ETF           市值：8.12      累涨：25.93     7.46      11.88     6.59      10日：3.66      1.71      0.93      -0.08     13        累涨修正：33.16     净值区间：58      38      63      81      86      13
        JINRONG_FANGDICHAN.put("510650", ContEtfTypeName.JINRONG_FANGDICHAN);//金融地产ETF           市值：0.35      累涨：25.74     8.69      10.87     6.18      10日：2.84      1.86      1.11      -0.65     14        累涨修正：32.66     净值区间：47      26      49      74      80      14
        JINRONG_FANGDICHAN.put("512640", ContEtfTypeName.JINRONG_FANGDICHAN);//金融地产ETF嘉实       市值：0.76      累涨：24.55     7.50      11.09     5.96      10日：2.98      1.71      0.91      0.12      17        累涨修正：31.06     净值区间：58      37      62      80      84      15
        JINRONG_FANGDICHAN.put("561320", ContEtfTypeName.JINRONG_FANGDICHAN);//交运ETF               市值：0.59      累涨：17.15     7.63      4.56      4.96      10日：3.62      3.00      2.27      0.81      16        累涨修正：28.31     净值区间：90      91      91      91      95      16
        JINRONG_FANGDICHAN.put("159666", ContEtfTypeName.JINRONG_FANGDICHAN);//交通运输ETF           市值：0.63      累涨：17.19     8.80      3.65      4.74      10日：4.14      2.93      1.91      0.99      15        累涨修正：28.08     净值区间：49      51      54      56      69      17
        JINRONG_FANGDICHAN.put("159662", ContEtfTypeName.JINRONG_FANGDICHAN);//交运ETF               市值：0.63      累涨：14.91     6.93      3.65      4.33      10日：3.93      2.94      1.95      1.15      18        累涨修正：25.68     净值区间：95      95      96      96      98      18
        JINRONG_FANGDICHAN.put("560620", ContEtfTypeName.JINRONG_FANGDICHAN);//公用事业ETF基金       市值：1.43      累涨：15.65     6.05      2.97      6.63      10日：3.13      2.37      2.15      -0.64     19        累涨修正：25.45     净值区间：46      46      58      65      67      19
        JINRONG_FANGDICHAN.put("560190", ContEtfTypeName.JINRONG_FANGDICHAN);//公用事业ETF           市值：0.31      累涨：16.30     6.65      3.57      6.08      10日：2.62      2.12      2.12      0.30      21        累涨修正：25.28     净值区间：51      53      64      68      70      20
        JINRONG_FANGDICHAN.put("159301", ContEtfTypeName.JINRONG_FANGDICHAN);//公用事业ETF           市值：0.50      累涨：15.72     5.77      3.49      6.46      10日：2.99      2.24      2.13      -0.21     20        累涨修正：25.21     净值区间：46      49      62      64      68      21
    }

    public static Map<String, String> JINRONG_CASH = new HashMap<>();//金融-现金
    public static Map<String, String> TOP_JINRONG_CASH = new HashMap<>();

    static {
    }

    static {
        JINRONG_CASH.put("511620", "金融-现金             ");//货币基金ETF           市值：2.51      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        1
        JINRONG_CASH.put("563900", "金融-现金             ");//沪深300自由现金流ETF摩根市值：1.86      累涨：                                        10日：1.46      0.49      0.29      -0.10               累涨修正：          净值区间：33      11      46                      2
        JINRONG_CASH.put("563780", "金融-现金             ");//现金流全指ETF         市值：1.23      累涨：                                        10日：2.46      1.18                0.00                累涨修正：          净值区间：36      32                              3
        JINRONG_CASH.put("159221", "金融-现金             ");//现金流100ETF          市值：1.50      累涨：                                        10日：2.18      1.19      0.30      0.00                累涨修正：          净值区间：58      43                              4
        JINRONG_CASH.put("159233", "金融-现金             ");//自由现金流ETF基金     市值：6.52      累涨：                                        10日：                              -0.20               累涨修正：          净值区间：                                        5
        JINRONG_CASH.put("159232", "金融-现金             ");//现金流ETF南方         市值：6.00      累涨：                                        10日：                              -0.10               累涨修正：          净值区间：                                        6
        JINRONG_CASH.put("159229", "金融-现金             ");//自由现金流ETF广发     市值：0.68      累涨：                                        10日：3.46      1.09      0.10      -0.10               累涨修正：          净值区间：14      13                              7
        JINRONG_CASH.put("159001", "金融-现金             ");//货币ETF               市值：15.25     累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        8
        JINRONG_CASH.put("511690", "金融-现金             ");//交易货币ETF           市值：8.71      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        9
        JINRONG_CASH.put("511650", "金融-现金             ");//华夏快线ETF           市值：0.98      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        10
        JINRONG_CASH.put("511830", "金融-现金             ");//华泰货币ETF           市值：0.24      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        11
        JINRONG_CASH.put("511600", "金融-现金             ");//货币ETF               市值：0.31      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        12
        JINRONG_CASH.put("159005", "金融-现金             ");//汇添富快钱ETF         市值：0.90      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        13
        JINRONG_CASH.put("511810", "金融-现金             ");//理财金货币ETF         市值：5.45      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        14
        JINRONG_CASH.put("561080", "金融-现金             ");//全指现金流ETF华安     市值：0.55      累涨：                                        10日：                              -0.10               累涨修正：          净值区间：                                        15
        JINRONG_CASH.put("511930", "金融-现金             ");//国联日盈货币ETF       市值：0.20      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        16
        JINRONG_CASH.put("159225", "金融-现金             ");//现金流ETF基金         市值：0.58      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        17
        JINRONG_CASH.put("159201", "金融-现金             ");//自由现金流ETF         市值：35.85     累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        18
        JINRONG_CASH.put("511980", "金融-现金             ");//现金添富ETF           市值：0.24      累涨：                                        10日：                              -0.04               累涨修正：          净值区间：                                        19
        JINRONG_CASH.put("511160", "金融-现金             ");//国债ETF东财           市值：37.63     累涨：                                        10日：                              0.03                累涨修正：          净值区间：                                        20
        JINRONG_CASH.put("511880", "金融-现金             ");//银华日利ETF           市值：783.69    累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        21
        JINRONG_CASH.put("511960", "金融-现金             ");//嘉实快线ETF           市值：0.34      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        22
        JINRONG_CASH.put("511920", "金融-现金             ");//广发货币ETF           市值：0.40      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        23
        JINRONG_CASH.put("159003", "金融-现金             ");//招商快线ETF           市值：2.37      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        24
        JINRONG_CASH.put("511900", "金融-现金             ");//富国货币ETF           市值：1.66      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        25
        JINRONG_CASH.put("511850", "金融-现金             ");//财富宝ETF             市值：13.64     累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        26
        JINRONG_CASH.put("159222", "金融-现金             ");//自由现金流ETF易方达   市值：5.58      累涨：                                        10日：                              -0.19               累涨修正：          净值区间：                                        27
        JINRONG_CASH.put("159235", "金融-现金             ");//中证现金流ETF         市值：4.37      累涨：                                        10日：                              -0.29               累涨修正：          净值区间：                                        28
        JINRONG_CASH.put("561870", "金融-现金             ");//自由现金流ETF全指     市值：1.83      累涨：                                        10日：3.03      1.37      0.20      -0.10               累涨修正：          净值区间：20      17                              29
        JINRONG_CASH.put("516460", "金融-现金             ");//现金流ETF800          市值：0.34      累涨：                                        10日：                              -0.39               累涨修正：          净值区间：                                        30
        JINRONG_CASH.put("159236", "金融-现金             ");//自由现金流ETF工银     市值：1.63      累涨：                                        10日：2.57      1.28      0.10      -0.30               累涨修正：          净值区间：15      13                              31
        JINRONG_CASH.put("563990", "金融-现金             ");//800现金流ETF          市值：1.18      累涨：                                        10日：                              -0.19               累涨修正：          净值区间：                                        32
        JINRONG_CASH.put("159399", "金融-现金             ");//现金流ETF             市值：36.24     累涨：                                        10日：                              -0.10               累涨修正：          净值区间：                                        33
        JINRONG_CASH.put("563770", "金融-现金             ");//全指现金流ETF         市值：0.47      累涨：                                        10日：2.68      1.29                -0.10               累涨修正：          净值区间：21      17                              34
        JINRONG_CASH.put("563680", "金融-现金             ");//800自由现金流ETF      市值：0.46      累涨：                                        10日：2.36      1.08      0.10      -0.10               累涨修正：          净值区间：25      36                              35
        JINRONG_CASH.put("563830", "金融-现金             ");//全指现金流ETF基金     市值：0.95      累涨：                                        10日：          1.40      0.40      -0.30               累涨修正：          净值区间：15      17                              36
        JINRONG_CASH.put("563390", "金融-现金             ");//现金流ETF全指         市值：2.99      累涨：                                        10日：                              -0.29               累涨修正：          净值区间：                                        37
        JINRONG_CASH.put("562080", "金融-现金             ");//300现金流ETF          市值：1.73      累涨：                                        10日：                              -0.19               累涨修正：          净值区间：                                        38
        JINRONG_CASH.put("511990", "金融-现金             ");//华宝添益ETF           市值：803.99    累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        39
        JINRONG_CASH.put("511970", "金融-现金             ");//国寿货币ETF           市值：0.31      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        40
        JINRONG_CASH.put("511950", "金融-现金             ");//添利货币ETF           市值：0.29      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        41
        JINRONG_CASH.put("511910", "金融-现金             ");//融通货币ETF           市值：0.16      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        42
        JINRONG_CASH.put("511860", "金融-现金             ");//保证金货币ETF         市值：0.35      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        43
        JINRONG_CASH.put("511820", "金融-现金             ");//鹏华添利ETF           市值：0.99      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        44
        JINRONG_CASH.put("511800", "金融-现金             ");//易方达货币ETF         市值：1.52      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        45
        JINRONG_CASH.put("511770", "金融-现金             ");//金鹰增益货币ETF       市值：0.13      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        46
        JINRONG_CASH.put("511700", "金融-现金             ");//场内货币ETF           市值：11.17     累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        47
        JINRONG_CASH.put("511670", "金融-现金             ");//华泰天天金ETF         市值：0.16      累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        48
        JINRONG_CASH.put("511660", "金融-现金             ");//货币ETF建信添益       市值：109.89    累涨：                                        10日：                              0.00                累涨修正：          净值区间：                                        49
    }

    /**
     * 金融
     */
    public static Map<String, String> JINRONG = new HashMap<>();

    static {
        JINRONG.putAll(JINRONG_ZHENGQUAN);
        JINRONG.putAll(JINRONG_GOLD);
        JINRONG.putAll(JINRONG_BANK);
        JINRONG.putAll(JINRONG_FANGDICHAN);
        JINRONG.putAll(JINRONG_CASH);
    }

    public static Map<String, String> TOP_JINRONG = new HashMap<>();

    static {
        TOP_JINRONG.putAll(TOP_JINRONG_ZHENGQUAN);
        TOP_JINRONG.putAll(TOP_JINRONG_GOLD);
        TOP_JINRONG.putAll(TOP_JINRONG_BANK);
        TOP_JINRONG.putAll(TOP_JINRONG_FANGDICHAN);
        TOP_JINRONG.putAll(TOP_JINRONG_CASH);
    }

    /**
     * etf-行业-all
     */
    public static Map<String, String> BIZ_ALL = new HashMap<>();

    static {
        BIZ_ALL.putAll(XIAOFEI);
        BIZ_ALL.putAll(KEJI);
        BIZ_ALL.putAll(YILIAO);
        BIZ_ALL.putAll(JINRONG);
        BIZ_ALL.putAll(ZIYUAN);
    }

    /**
     * TOP_BIZ
     */
    public static Map<String, String> TOP_BIZ = new HashMap<>();

    static {
        TOP_BIZ.putAll(TOP_XIAOFEI);
        TOP_BIZ.putAll(TOP_KEJI);
        TOP_BIZ.putAll(TOP_YILIAO);
        TOP_BIZ.putAll(TOP_JINRONG);
        TOP_BIZ.putAll(TOP_ZIYUAN);
    }

    /**
     * ETF_All 全部：指数、板块
     * 2022-10-31 etf共收录：670
     * 2025-06-06 etf共收录：1068
     */
    public static Map<String, String> ETF_All = new HashMap<>();

    static {
        ETF_All.putAll(INDEX);
        ETF_All.putAll(BIZ_ALL);
    }

    /**
     *
     */
    public static Map<String, String> ETF_TOP_All = new HashMap<>();

    static {
        ETF_TOP_All.putAll(TOP_INDEX);
        ETF_TOP_All.putAll(TOP_BIZ);
    }


    /**
     * ETF涨幅数据：查询数据根据名称列表模糊查询
     */
    private static void findByTypeName(String date, List nameLikeList, List nameNoLikeList, String typeEn, String typeCn, Map<String, String> typeMap) {
        String channel = CHANNEL_ETF;
        System.out.println("    public static Map<String, String> TOP_" + typeEn + " = new HashMap<>();");//+ typeCn
        System.out.println("    static {");
        System.out.println("    }");
        System.out.println("    public static Map<String, String> " + typeEn + " = new HashMap<>();");
//        String typeEn = "";
//        String typeCn = "";
        CondEtfAdrCount condition = new CondEtfAdrCount();
        condition.setDate(date);
        condition.setOrderBy(ADR_UP_SUM_TOTAL_DESC);//ADR_UP_SUM_TOTAL_DESC  ADR_UP_SUM_1_60_DESC
        condition.setLikeNameList(nameLikeList);
        condition.setNotLikeNameList(nameNoLikeList);
        condition.setChannel(channel);

//
        List<EtfAdrCountVo> etfListLikeName = EtfAdrCountService.listEtfAdrCountLikeName(condition);//查询列表，模糊查询：名称列表
//        EtfControl.saveOrUpdateListNetLastDay(condition, date, true);//保存或更新ETF涨幅次数-批量更新基础信息

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
            sb.append(", " + "ContEtfTypeName." + typeEn + ");");
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
        String date = "2025-07-24";

        //////        //etf头部数据
//        List<String> zqdmList = new ArrayList<>(ContMapEtfAll.TOP_XIAOFEI.keySet());
//        int count = 0;
//        for (String zqdm : zqdmList) {
//            System.out.println(++count + ":" + zqdm + ":" + ETF_All.get(zqdm));
//        }

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


//        findByTypeName(date, ContEtfNameKey.ZIYUAN_OIL, null, "ZIYUAN_OIL", ContEtfTypeName.ZIYUAN_OIL, ContMapEtfAll.ZIYUAN_OIL);//资源-石油
//        findByTypeName(date, ContEtfNameKey.ZIYUAN_COMMON, ContEtfNameKey.ZIYUAN_COMMON_NOLIKE, "ZIYUAN_COMMON", ContEtfTypeName.ZIYUAN_COMMON, ContMapEtfAll.ZIYUAN_COMMON);//资源-通用

//        findByTypeName(date, ContEtfNameKey.YILIAO_COMMON, null, "YILIAO_COMMON", ContEtfTypeName.YILIAO_COMMON, ContMapEtfAll.YILIAO_COMMON);

//        findByTypeName(date, ContEtfNameKey.JINRONG_GOLD, ContEtfNameKey.JINRONG_GOLD_NOLIKE, "JINRONG_GOLD", ContEtfTypeName.JINRONG_GOLD, ContMapEtfAll.JINRONG_GOLD);//金融-黄金
        findByTypeName(date, ContEtfNameKey.JINRONG_BANK, null, "JINRONG_BANK", ContEtfTypeName.JINRONG_BANK, ContMapEtfAll.JINRONG_BANK);//金融-银行
//        findByTypeName(date, ContEtfNameKey.JINRONG_ZHENGQUAN,  ContEtfNameKey.JINRONG_ZHENGQUAN_NOLIKE, "JINRONG_ZHENGQUAN", ContEtfTypeName.JINRONG_ZHENGQUAN, ContMapEtfAll.JINRONG_ZHENGQUAN);
//        findByTypeName(date, ContEtfNameKey.JINRONG_FANGDICHAN, null, "JINRONG_FANGDICHAN", ContEtfTypeName.JINRONG_FANGDICHAN, ContMapEtfAll.JINRONG_FANGDICHAN);//金融-地产
//        findByTypeName(date, ContEtfNameKey.JINRONG_CASH,  null, "JINRONG_CASH", ContEtfTypeName.JINRONG_CASH, ContMapEtfAll.JINRONG_CASH);

//        System.out.println("    public static Map<String, String> XIAOFEI_COMMON = new HashMap<>();//消费-通用");
//        findByTypeName(date, ContEtfNameKey.XIAOFEI_COMMON, ContEtfNameKey.XIAOFEI_COMMON_NOLIKE, "XIAOFEI_COMMON", ContEtfTypeName.XIAOFEI_COMMON, ContMapEtfAll.XIAOFEI_COMMON);
//        findByTypeName(date, ContEtfNameKey.XIAOFEI_MEDIA, null, "XIAOFEI_MEDIA", ContEtfTypeName.XIAOFEI_MEDIA, ContMapEtfAll.XIAOFEI_MEDIA);//消费-文娱传媒
//        name = "XIAOFEI_WINE";
//        System.out.println("    public static Map<String, String> TOP_" + name + " = new HashMap<>();//消费-吃喝玩乐");
//        System.out.println("    static {");
//        System.out.println("    }");
//        System.out.println("    public static Map<String, String> " + name + " = new HashMap<>();//消费-吃喝玩乐");
//        findByTypeName(date, ContEtfNameKey.XIAOFEI_WINE, null, name, ContEtfTypeName.XIAOFEI_WINE, ContMapEtfAll.XIAOFEI_WINE);


//        findByTypeName(date, ContEtfNameKey.KEJI_HK, null, "KEJI_HK", ContEtfTypeName.KEJI_HK, ContMapEtfAll.KEJI_HK);//科技-香港
//        findByTypeName(date, ContEtfNameKey.KEJI_JUNGONG, null, "KEJI_JUNGONG", ContEtfTypeName.KEJI_JUNGONG, ContMapEtfAll.KEJI_JUNGONG);//科技-军工
//        findByTypeName(date, ContEtfNameKey.KEJI_GONG_YE, ContEtfNameKey.KEJI_GONG_YE_NOLIKE, "KEJI_GONG_YE", ContEtfTypeName.KEJI_GONG_YE, ContMapEtfAll.KEJI_GONG_YE);
//        findByTypeName(date, ContEtfNameKey.KEJI_RUAN_JIAN, null, "KEJI_RUAN_JIAN", ContEtfTypeName.KEJI_RUAN_JIAN, ContMapEtfAll.KEJI_RUAN_JIAN);//科技-软件
//        findByTypeName(date, ContEtfNameKey.KEJI_XIN_PIAN, null, "KEJI_XIN_PIAN", ContEtfTypeName.KEJI_XIN_PIAN, ContMapEtfAll.KEJI_XIN_PIAN);//科技-芯片
//        findByTypeName(date, ContEtfNameKey.KEJI_TONG_XIN, null, "KEJI_TONG_XIN", ContEtfTypeName.KEJI_TONG_XIN, ContMapEtfAll.KEJI_TONG_XIN);//科技-通信
//        findByTypeName(date, ContEtfNameKey.KEJI_NEW_ENERGY, null, "KEJI_NEW_ENERGY", ContEtfTypeName.KEJI_NEW_ENERGY, ContMapEtfAll.KEJI_NEW_ENERGY);//科技-新能源
//        findByTypeName(date, ContEtfNameKey.KEJI_NEW_CAR, null, "KEJI_NEW_CAR", ContEtfTypeName.KEJI_NEW_CAR, ContMapEtfAll.KEJI_NEW_CAR);//科技-汽车
    }
}
