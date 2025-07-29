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

    public static Map<String, String> TOP_ZIYUAN_COMMON = new HashMap<>();
    static {
        TOP_ZIYUAN_COMMON.put("159715", ContEtfTypeName.ZIYUAN_COMMON);//稀土ETF易方达         市值：3.12      累涨：48.87     10.48     17.58     20.81     10日：12.46     5.24      5.13      -1.25     2         累涨修正：76.83     净值区间：85      91      94      95      95      1
    }
    public static Map<String, String> ZIYUAN_COMMON = new HashMap<>();
    static {
        ZIYUAN_COMMON.put("159715", ContEtfTypeName.ZIYUAN_COMMON);//稀土ETF易方达         市值：3.12      累涨：48.87     10.48     17.58     20.81     10日：12.46     5.24      5.13      -1.25     2         累涨修正：76.83     净值区间：85      91      94      95      95      1
        ZIYUAN_COMMON.put("516780", ContEtfTypeName.ZIYUAN_COMMON);//稀土ETF               市值：17.15     累涨：49.90     11.32     18.00     20.58     10日：12.10     5.03      4.65      -1.06     3         累涨修正：76.33     净值区间：85      91      94      95      95      2
        ZIYUAN_COMMON.put("516150", ContEtfTypeName.ZIYUAN_COMMON);//稀土ETF嘉实           市值：39.69     累涨：47.76     10.19     17.67     19.90     10日：11.85     4.66      4.59      -1.09     6         累涨修正：73.45     净值区间：85      91      94      95      95      3
        ZIYUAN_COMMON.put("159713", ContEtfTypeName.ZIYUAN_COMMON);//稀土ETF               市值：6.73      累涨：47.59     10.48     17.37     19.74     10日：11.46     4.35      4.35      -1.05     8         累涨修正：72.1      净值区间：85      92      94      95      95      4
        ZIYUAN_COMMON.put("159608", ContEtfTypeName.ZIYUAN_COMMON);//稀有金属ETF           市值：3.01      累涨：46.19     9.29      15.22     21.68     10日：12.58     6.12      3.53      -0.39     1         累涨修正：71.95     净值区间：88      94      95      96      96      5
        ZIYUAN_COMMON.put("159671", ContEtfTypeName.ZIYUAN_COMMON);//稀有金属ETF基金       市值：5.23      累涨：43.41     8.18      14.75     20.48     10日：12.05     5.34      3.33      -0.22     4         累涨修正：67.46     净值区间：87      93      94      96      96      6
        ZIYUAN_COMMON.put("561800", ContEtfTypeName.ZIYUAN_COMMON);//稀有金属ETF基金       市值：1.14      累涨：42.86     8.43      14.75     19.68     10日：11.68     5.45      3.43      -0.57     5         累涨修正：66.85     净值区间：85      92      93      95      95      7
        ZIYUAN_COMMON.put("159690", ContEtfTypeName.ZIYUAN_COMMON);//矿业ETF               市值：0.17      累涨：39.66     8.07      12.52     19.07     10日：11.31     5.30      3.00      -0.24     7         累涨修正：62.27     净值区间：68      87      89      92      93      8
        ZIYUAN_COMMON.put("560860", ContEtfTypeName.ZIYUAN_COMMON);//工业有色ETF           市值：10.99     累涨：39.62     8.38      12.84     18.40     10日：10.82     4.91      3.19      -0.38     9         累涨修正：61.73     净值区间：75      90      92      95      95      9
        ZIYUAN_COMMON.put("561330", ContEtfTypeName.ZIYUAN_COMMON);//矿业ETF               市值：1.06      累涨：38.95     7.68      12.86     18.41     10日：11.33     5.11      3.00      0.00      10        累涨修正：61.39     净值区间：67      86      89      92      92      10
        ZIYUAN_COMMON.put("512400", ContEtfTypeName.ZIYUAN_COMMON);//有色金属ETF           市值：63.12     累涨：37.97     7.82      11.90     18.25     10日：11.08     5.37      3.00      -0.55     11        累涨修正：60.42     净值区间：64      85      87      91      92      11
        ZIYUAN_COMMON.put("159652", ContEtfTypeName.ZIYUAN_COMMON);//有色50ETF             市值：4.91      累涨：37.34     8.25      12.02     17.07     10日：11.00     5.17      2.89      -0.36     12        累涨修正：59.29     净值区间：64      86      87      91      92      12
        ZIYUAN_COMMON.put("159876", ContEtfTypeName.ZIYUAN_COMMON);//有色龙头ETF           市值：0.77      累涨：37.23     8.07      11.51     17.65     10日：10.77     4.96      3.00      -0.53     13        累涨修正：58.96     净值区间：63      85      87      91      92      13
        ZIYUAN_COMMON.put("159881", ContEtfTypeName.ZIYUAN_COMMON);//有色60ETF             市值：0.56      累涨：37.81     7.97      12.35     17.49     10日：10.57     4.56      2.97      -0.48     16        累涨修正：58.88     净值区间：64      86      88      92      92      14
        ZIYUAN_COMMON.put("159871", ContEtfTypeName.ZIYUAN_COMMON);//有色金属ETF           市值：0.80      累涨：36.36     7.24      11.34     17.78     10日：10.85     5.17      3.00      -0.46     15        累涨修正：58.38     净值区间：74      88      90      93      94      15
        ZIYUAN_COMMON.put("516650", ContEtfTypeName.ZIYUAN_COMMON);//有色金属ETF基金       市值：1.71      累涨：37.38     7.78      11.77     17.83     10日：10.39     4.73      2.72      -0.72     17        累涨修正：57.94     净值区间：59      85      87      91      92      16
        ZIYUAN_COMMON.put("159981", ContEtfTypeName.ZIYUAN_COMMON);//能源化工ETF           市值：5.55      累涨：33.67     10.64     11.19     11.84     10日：8.54      6.08      4.69      0.36      14        累涨修正：57.67     净值区间：21      46      50      64      69      17
        ZIYUAN_COMMON.put("159880", ContEtfTypeName.ZIYUAN_COMMON);//有色ETF基金           市值：1.15      累涨：36.03     7.84      11.40     16.79     10日：10.31     4.48      2.71      -0.47     19        累涨修正：56.24     净值区间：71      87      88      92      92      18
        ZIYUAN_COMMON.put("515210", ContEtfTypeName.ZIYUAN_COMMON);//钢铁ETF               市值：33.81     累涨：33.13     5.44      6.79      20.90     10日：11.30     5.23      2.70      2.07      21        累涨修正：55.06     净值区间：61      83      88      90      90      19
        ZIYUAN_COMMON.put("510410", ContEtfTypeName.ZIYUAN_COMMON);//资源ETF               市值：5.08      累涨：31.42     7.54      7.70      16.18     10日：10.38     6.00      3.00      0.29      18        累涨修正：53.8      净值区间：40      77      78      84      86      20
        ZIYUAN_COMMON.put("588010", ContEtfTypeName.ZIYUAN_COMMON);//科创新材料ETF         市值：2.51      累涨：31.72     8.30      12.49     10.93     10日：7.43      5.06      4.13      0.74      20        累涨修正：52.47     净值区间：97      98      98      99      99      21
        ZIYUAN_COMMON.put("510170", ContEtfTypeName.ZIYUAN_COMMON);//大宗商品ETF           市值：1.85      累涨：30.38     6.95      7.11      16.32     10日：10.65     5.71      2.71      0.50      22        累涨修正：52.16     净值区间：62      85      87      90      91      22
        ZIYUAN_COMMON.put("159944", ContEtfTypeName.ZIYUAN_COMMON);//材料ETF               市值：0.28      累涨：31.19     6.26      8.28      16.65     10日：10.63     4.82      2.06      -0.28     25        累涨修正：50.76     净值区间：52      68      71      78      79      23
        ZIYUAN_COMMON.put("588160", ContEtfTypeName.ZIYUAN_COMMON);//科创材料ETF           市值：2.53      累涨：30.64     7.99      12.35     10.30     10日：7.02      4.68      3.61      0.88      26        累涨修正：49.56     净值区间：97      98      98      99      99      24
        ZIYUAN_COMMON.put("159761", ContEtfTypeName.ZIYUAN_COMMON);//新材料50ETF           市值：1.63      累涨：30.21     7.73      9.39      13.09     10日：8.59      4.78      2.74      0.00      23        累涨修正：49.06     净值区间：100     100     100     100     100     25
        ZIYUAN_COMMON.put("516890", ContEtfTypeName.ZIYUAN_COMMON);//新材料ETF指数基金     市值：0.27      累涨：28.53     6.90      8.54      13.09     10日：8.60      4.59      2.73      -0.18     28        累涨修正：47.18     净值区间：92      98      98      99      99      26
        ZIYUAN_COMMON.put("516480", ContEtfTypeName.ZIYUAN_COMMON);//新材料ETF基金         市值：0.13      累涨：28.37     7.85      8.39      12.13     10日：8.52      4.98      2.63      0.15      24        累涨修正：47.13     净值区间：95      98      98      99      99      27
        ZIYUAN_COMMON.put("159763", ContEtfTypeName.ZIYUAN_COMMON);//新材料ETF基金         市值：0.56      累涨：29.19     7.20      9.39      12.60     10日：8.42      4.33      2.34      0.19      29        累涨修正：46.62     净值区间：88      95      96      97      97      28
        ZIYUAN_COMMON.put("516710", ContEtfTypeName.ZIYUAN_COMMON);//新材料50ETF           市值：0.38      累涨：29.01     7.66      9.22      12.13     10日：8.04      4.25      2.50      0.38      31        累涨修正：46.3      净值区间：100     100     100     100     100     29
        ZIYUAN_COMMON.put("159703", ContEtfTypeName.ZIYUAN_COMMON);//新材料ETF             市值：0.58      累涨：28.92     7.87      8.96      12.09     10日：8.23      4.29      2.37      0.15      27        累涨修正：46.18     净值区间：100     100     100     100     100     30
        ZIYUAN_COMMON.put("516360", ContEtfTypeName.ZIYUAN_COMMON);//新材料ETF             市值：0.57      累涨：28.28     7.66      8.61      12.01     10日：8.18      4.15      2.33      0.00      32        累涨修正：45.27     净值区间：95      98      99      99      99      31
        ZIYUAN_COMMON.put("515220", ContEtfTypeName.ZIYUAN_COMMON);//煤炭ETF               市值：72.69     累涨：27.83     7.66      6.63      13.54     10日：8.57      4.62      1.62      0.83      30        累涨修正：44.26     净值区间：24      58      61      64      66      32
        ZIYUAN_COMMON.put("516120", ContEtfTypeName.ZIYUAN_COMMON);//化工50ETF             市值：2.51      累涨：25.58     6.00      6.16      13.42     10日：9.69      3.79      1.66      -0.30     35        累涨修正：42.38     净值区间：50      84      85      88      89      33
        ZIYUAN_COMMON.put("516020", ContEtfTypeName.ZIYUAN_COMMON);//化工ETF               市值：7.00      累涨：25.30     6.11      6.40      12.79     10日：9.17      3.86      1.53      -0.15     36        累涨修正：41.39     净值区间：31      70      72      77      78      34
        ZIYUAN_COMMON.put("562010", ContEtfTypeName.ZIYUAN_COMMON);//绿色能源ETF           市值：0.14      累涨：29.02     8.91      9.28      10.83     10日：5.33      2.77      1.71      0.13      33        累涨修正：40.54     净值区间：65      87      91      93      93      35
        ZIYUAN_COMMON.put("159870", ContEtfTypeName.ZIYUAN_COMMON);//化工ETF               市值：33.79     累涨：25.76     6.45      6.42      12.89     10日：8.89      3.43      1.13      0.16      34        累涨修正：40.34     净值区间：40      80      82      86      86      36
        ZIYUAN_COMMON.put("159587", ContEtfTypeName.ZIYUAN_COMMON);//粮食ETF广发           市值：0.35      累涨：23.85     8.70      5.33      9.82      10日：6.87      3.86      2.68      -0.83     37        累涨修正：39.94     净值区间：23      52      54      65      80      37
        ZIYUAN_COMMON.put("516220", ContEtfTypeName.ZIYUAN_COMMON);//化工龙头ETF           市值：1.39      累涨：24.51     6.34      5.66      12.51     10日：8.70      3.12      1.18      -0.15     38        累涨修正：38.69     净值区间：62      84      85      88      89      38
        ZIYUAN_COMMON.put("516570", ContEtfTypeName.ZIYUAN_COMMON);//化工行业ETF           市值：0.67      累涨：22.67     5.22      5.44      12.01     10日：8.31      3.75      1.15      -0.25     39        累涨修正：37.03     净值区间：78      78      78      82      83      39
        ZIYUAN_COMMON.put("159616", ContEtfTypeName.ZIYUAN_COMMON);//农牧ETF               市值：0.52      累涨：22.92     6.15      6.66      10.11     10日：6.51      3.08      1.28      -1.01     46        累涨修正：35.07     净值区间：40      76      79      84      87      40
        ZIYUAN_COMMON.put("516810", ContEtfTypeName.ZIYUAN_COMMON);//农业50ETF             市值：1.81      累涨：24.04     6.60      7.33      10.11     10日：6.31      2.85      0.64      -1.28     41        累涨修正：34.48     净值区间：19      63      67      76      80      41
        ZIYUAN_COMMON.put("159930", ContEtfTypeName.ZIYUAN_COMMON);//能源ETF               市值：2.30      累涨：22.46     6.47      5.52      10.47     10日：6.11      3.88      0.88      0.97      42        累涨修正：34.21     净值区间：29      59      64      69      76      42
        ZIYUAN_COMMON.put("159945", ContEtfTypeName.ZIYUAN_COMMON);//能源ETF广发           市值：0.29      累涨：22.38     6.29      5.57      10.52     10日：6.34      3.80      0.80      0.36      43        累涨修正：34.12     净值区间：15      44      49      56      63      43
        ZIYUAN_COMMON.put("159698", ContEtfTypeName.ZIYUAN_COMMON);//粮食ETF               市值：2.32      累涨：20.72     7.66      4.83      8.23      10日：5.78      3.03      2.05      -0.64     51        累涨修正：33.63     净值区间：28      62      64      74      76      44
        ZIYUAN_COMMON.put("159825", ContEtfTypeName.ZIYUAN_COMMON);//农业ETF               市值：21.42     累涨：24.38     6.87      7.75      9.76      10日：6.18      2.51      0.26      -0.91     40        累涨修正：33.59     净值区间：21      60      64      72      78      45
        ZIYUAN_COMMON.put("561790", ContEtfTypeName.ZIYUAN_COMMON);//央企现代能源ETF       市值：0.51      累涨：20.03     4.65      4.59      10.79     10日：7.76      3.66      0.87      0.18      47        累涨修正：33.19     净值区间：14      46      48      58      63      46
        ZIYUAN_COMMON.put("159827", ContEtfTypeName.ZIYUAN_COMMON);//农业50ETF             市值：0.92      累涨：23.69     6.64      7.34      9.71      10日：5.99      2.46      0.24      -1.21     45        累涨修正：32.62     净值区间：17      58      62      72      77      47
        ZIYUAN_COMMON.put("562900", ContEtfTypeName.ZIYUAN_COMMON);//农业ETF易方达         市值：0.65      累涨：22.72     6.68      7.19      8.85      10日：5.82      2.16      0.25      -1.14     49        累涨修正：31.2      净值区间：14      45      48      59      65      48
        ZIYUAN_COMMON.put("159865", ContEtfTypeName.ZIYUAN_COMMON);//养殖ETF               市值：40.39     累涨：23.07     6.97      7.01      9.09      10日：5.64      2.06      0.16      -1.42     48        累涨修正：31.09     净值区间：15      49      57      66      68      49
        ZIYUAN_COMMON.put("159867", ContEtfTypeName.ZIYUAN_COMMON);//畜牧ETF               市值：6.48      累涨：22.37     7.03      6.72      8.62      10日：5.53      2.18      0.31      -1.23     50        累涨修正：30.7      净值区间：17      49      55      64      68      50
        ZIYUAN_COMMON.put("561260", ContEtfTypeName.ZIYUAN_COMMON);//能源ETF               市值：0.40      累涨：19.34     4.95      4.21      10.18     10日：7.05      3.23      0.43      0.09      52        累涨修正：30.48     净值区间：17      48      50      61      66      51
        ZIYUAN_COMMON.put("516670", ContEtfTypeName.ZIYUAN_COMMON);//畜牧养殖ETF           市值：8.64      累涨：22.64     6.80      7.26      8.58      10日：5.27      1.73                -1.14     53        累涨修正：29.64     净值区间：16      47      56      65      68      52
        ZIYUAN_COMMON.put("589180", ContEtfTypeName.ZIYUAN_COMMON);//科创新材料ETF汇添富   市值：0.23      累涨：                              10.15     10日：7.18      4.71      3.68      1.08      44        累涨修正：29.4      净值区间：98      99      99                      53
        ZIYUAN_COMMON.put("516760", ContEtfTypeName.ZIYUAN_COMMON);//养殖ETF               市值：1.27      累涨：21.73     7.20      5.79      8.74      10日：5.31      1.79      0.15      -1.18     54        累涨修正：29.13     净值区间：14      50      59      66      68      54
        ZIYUAN_COMMON.put("562850", ContEtfTypeName.ZIYUAN_COMMON);//央企能源ETF           市值：0.91      累涨：19.36     5.41      4.58      9.37      10日：6.53      2.71      0.09      0.09      55        累涨修正：28.78     净值区间：16      52      55      64      68      55
        ZIYUAN_COMMON.put("516550", ContEtfTypeName.ZIYUAN_COMMON);//农业ETF               市值：1.84      累涨：17.73     4.79      5.54      7.40      10日：4.85      2.18      0.72      -0.43     56        累涨修正：26.2      净值区间：28      67      68      75      80      56
        ZIYUAN_COMMON.put("159980", ContEtfTypeName.ZIYUAN_COMMON);//有色ETF               市值：11.23     累涨：14.83     4.09      5.50      5.24      10日：3.18      0.93      0.70      -0.18     58        累涨修正：20.34     净值区间：14      53      53      63      69      57
        ZIYUAN_COMMON.put("159985", ContEtfTypeName.ZIYUAN_COMMON);//豆粕ETF               市值：26.00     累涨：14.59     3.46      5.96      5.17      10日：3.46      0.80                -0.31     57        累涨修正：18.85     净值区间：10      10      23      28      38      58
        ZIYUAN_COMMON.put("562800", ContEtfTypeName.ZIYUAN_COMMON);//稀有金属ETF           市值：12.17     累涨：                                        10日：                              -0.30     59        累涨修正：0         净值区间：86      93      94      95      96      59
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
        TOP_KEJI_HK.put("159792", ContEtfTypeName.KEJI_HK);//港股通互联网ETF       市值：578.15    累涨：42.86     11.54     16.48     14.84     10日：11.23     5.96      3.33      -1.78     1         累涨修正：66.71     净值区间：51      81      85      87      89      1
    }
    public static Map<String, String> KEJI_HK = new HashMap<>();
    static {
        KEJI_HK.put("159792", ContEtfTypeName.KEJI_HK);//港股通互联网ETF       市值：578.15    累涨：42.86     11.54     16.48     14.84     10日：11.23     5.96      3.33      -1.78     1         累涨修正：66.71     净值区间：51      81      85      87      89      1
        KEJI_HK.put("159202", ContEtfTypeName.KEJI_HK);//恒生互联网科技ETF     市值：4.46      累涨：42.34     9.98      17.51     14.85     10日：11.86     6.09      3.00      -2.32     3         累涨修正：66.29     净值区间：31      68      72      79      79      2
        KEJI_HK.put("513160", ContEtfTypeName.KEJI_HK);//港股科技30ETF         市值：15.90     累涨：43.03     10.03     18.10     14.90     10日：10.39     5.45      3.50      -1.05     7         累涨修正：65.87     净值区间：59      82      86      89      89      3
        KEJI_HK.put("513040", ContEtfTypeName.KEJI_HK);//港股通互联网ETF       市值：8.42      累涨：41.67     10.93     16.26     14.48     10日：10.76     5.66      3.11      -1.81     2         累涨修正：64.31     净值区间：45      79      83      86      88      4
        KEJI_HK.put("513770", ContEtfTypeName.KEJI_HK);//港股互联网ETF         市值：72.30     累涨：42.00     10.95     16.43     14.62     10日：10.72     5.40      2.91      -1.38     5         累涨修正：63.94     净值区间：47      79      83      86      88      5
        KEJI_HK.put("159688", ContEtfTypeName.KEJI_HK);//恒生互联网ETF         市值：8.64      累涨：41.03     10.28     17.30     13.45     10日：10.89     5.79      3.00      -2.11     4         累涨修正：63.71     净值区间：39      75      78      80      81      6
        KEJI_HK.put("513330", ContEtfTypeName.KEJI_HK);//恒生互联网ETF         市值：251.65    累涨：40.96     10.18     17.13     13.65     10日：10.75     5.74      3.00      -2.05     6         累涨修正：63.45     净值区间：40      75      78      80      82      7
        KEJI_HK.put("513980", ContEtfTypeName.KEJI_HK);//港股科技50ETF         市值：173.67    累涨：40.45     11.13     16.01     13.31     10日：10.91     4.83      3.37      -1.52     8         累涨修正：62.93     净值区间：57      81      84      86      87      8
        KEJI_HK.put("159568", ContEtfTypeName.KEJI_HK);//港股互联网ETF         市值：3.43      累涨：40.86     10.55     16.14     14.17     10日：10.48     5.38      2.98      -1.56     9         累涨修正：62.68     净值区间：45      78      83      85      87      9
        KEJI_HK.put("159636", ContEtfTypeName.KEJI_HK);//港股通科技30ETF       市值：272.61    累涨：39.86     10.39     16.05     13.42     10日：10.83     4.75      3.13      -1.34     11        累涨修正：61.7      净值区间：54      80      83      84      85      10
        KEJI_HK.put("513860", ContEtfTypeName.KEJI_HK);//港股通科技ETF         市值：24.98     累涨：40.27     10.57     16.90     12.80     10日：10.68     4.73      2.87      -1.02     10        累涨修正：61.42     净值区间：60      83      86      88      88      11
        KEJI_HK.put("513150", ContEtfTypeName.KEJI_HK);//港股通科技ETF华泰柏瑞 市值：1.10      累涨：38.89     10.68     15.54     12.67     10日：10.70     4.56      3.05      -1.05     13        累涨修正：60.25     净值区间：65      85      88      89      90      12
        KEJI_HK.put("513050", ContEtfTypeName.KEJI_HK);//中概互联网ETF         市值：350.09    累涨：36.80     10.69     13.53     12.58     10日：10.59     5.68      3.48      -1.95     12        累涨修正：60.03     净值区间：49      76      78      78      78      13
        KEJI_HK.put("513020", ContEtfTypeName.KEJI_HK);//港股科技ETF           市值：22.26     累涨：38.63     10.23     15.45     12.95     10日：10.58     4.46      3.10      -0.98     15        累涨修正：59.87     净值区间：63      85      87      89      89      14
        KEJI_HK.put("159607", ContEtfTypeName.KEJI_HK);//中概互联网ETF         市值：10.24     累涨：37.34     10.72     14.38     12.24     10日：9.73      5.61      3.09      -2.04     14        累涨修正：58.86     净值区间：40      73      75      76      78      15
        KEJI_HK.put("513220", ContEtfTypeName.KEJI_HK);//中概互联ETF           市值：2.76      累涨：36.70     10.61     14.02     12.07     10日：9.76      5.59      3.36      -1.82     17        累涨修正：58.77     净值区间：47      75      78      80      81      16
        KEJI_HK.put("513560", ContEtfTypeName.KEJI_HK);//香港科技ETF           市值：5.99      累涨：37.91     10.18     15.19     12.54     10日：10.39     4.33      3.04      -1.10     21        累涨修正：58.71     净值区间：61      83      86      88      89      17
        KEJI_HK.put("159741", ContEtfTypeName.KEJI_HK);//恒生科技ETF嘉实       市值：8.47      累涨：37.08     10.04     14.86     12.18     10日：10.16     5.17      3.11      -1.45     19        累涨修正：58.63     净值区间：53      79      82      84      84      18
        KEJI_HK.put("159605", ContEtfTypeName.KEJI_HK);//中概互联ETF           市值：46.23     累涨：36.82     10.79     14.12     11.91     10日：9.70      5.50      3.18      -2.03     18        累涨修正：58.38     净值区间：41      73      75      76      79      19
        KEJI_HK.put("159747", ContEtfTypeName.KEJI_HK);//香港科技ETF           市值：4.72      累涨：37.79     10.63     15.06     12.10     10日：9.89      4.83      2.81      -1.34     16        累涨修正：58.13     净值区间：53      81      83      85      87      20
        KEJI_HK.put("513320", ContEtfTypeName.KEJI_HK);//恒生新经济ETF         市值：1.58      累涨：38.01     10.63     14.78     12.60     10日：10.40     4.28      2.67      -1.20     20        累涨修正：58.03     净值区间：56      83      85      87      88      21
        KEJI_HK.put("513010", ContEtfTypeName.KEJI_HK);//恒生科技ETF易方达     市值：126.88    累涨：37.24     10.01     15.40     11.83     10日：9.75      5.10      2.86      -1.26     22        累涨修正：57.81     净值区间：53      79      82      84      84      22
        KEJI_HK.put("513380", ContEtfTypeName.KEJI_HK);//恒生科技ETF龙头       市值：58.51     累涨：36.88     10.16     14.72     12.00     10日：9.65      5.32      2.93      -1.57     23        累涨修正：57.71     净值区间：41      75      79      81      81      23
        KEJI_HK.put("159751", ContEtfTypeName.KEJI_HK);//港股科技ETF           市值：6.87      累涨：36.99     9.81      14.82     12.36     10日：10.01     4.45      2.98      -0.97     30        累涨修正：57.41     净值区间：66      85      87      89      90      24
        KEJI_HK.put("513580", ContEtfTypeName.KEJI_HK);//恒生科技ETF指数基金   市值：25.08     累涨：37.07     10.43     15.31     11.33     10日：9.33      5.11      2.93      -1.30     24        累涨修正：57.37     净值区间：55      79      83      84      84      25
        KEJI_HK.put("513180", ContEtfTypeName.KEJI_HK);//恒生科技指数ETF       市值：315.64    累涨：36.68     9.77      15.27     11.64     10日：9.52      5.20      2.91      -1.29     28        累涨修正：57.22     净值区间：53      80      83      84      84      26
        KEJI_HK.put("159750", ContEtfTypeName.KEJI_HK);//港股科技50ETF         市值：6.38      累涨：36.70     9.91      14.80     11.99     10日：9.89      4.87      2.88      -1.36     25        累涨修正：57.22     净值区间：55      81      83      85      87      27
        KEJI_HK.put("159742", ContEtfTypeName.KEJI_HK);//恒生科技指数ETF       市值：23.35     累涨：36.53     9.83      14.84     11.86     10日：9.75      5.04      2.90      -1.15     27        累涨修正：57.12     净值区间：53      80      83      84      84      28
        KEJI_HK.put("513130", ContEtfTypeName.KEJI_HK);//恒生科技ETF           市值：279.82    累涨：36.94     9.86      15.53     11.55     10日：9.54      5.00      2.81      -1.31     26        累涨修正：57.1      净值区间：52      78      81      83      83      29
        KEJI_HK.put("513260", ContEtfTypeName.KEJI_HK);//恒生科技ETF基金       市值：48.93     累涨：36.38     10.02     14.93     11.43     10日：9.36      5.05      2.78      -1.35     29        累涨修正：56.35     净值区间：50      79      82      84      84      30
        KEJI_HK.put("513890", ContEtfTypeName.KEJI_HK);//恒生科技HKETF         市值：5.24      累涨：36.20     9.71      15.02     11.47     10日：9.22      4.97      2.82      -1.29     31        累涨修正：56.03     净值区间：51      79      82      84      84      31
        KEJI_HK.put("159740", ContEtfTypeName.KEJI_HK);//恒生科技ETF           市值：91.42     累涨：35.12     9.46      14.36     11.30     10日：9.29      4.89      2.69      -1.31     37        累涨修正：54.68     净值区间：50      77      80      83      83      32
        KEJI_HK.put("517050", ContEtfTypeName.KEJI_HK);//互联网ETF华泰柏瑞     市值：4.03      累涨：36.64     8.69      16.26     11.69     10日：8.21      3.91      2.83      -0.81     32        累涨修正：54.42     净值区间：76      88      90      93      93      33
        KEJI_HK.put("159856", ContEtfTypeName.KEJI_HK);//互联网龙头ETF         市值：3.00      累涨：36.91     9.41      16.43     11.07     10日：8.41      3.59      2.52      -0.52     34        累涨修正：53.95     净值区间：76      89      91      93      93      34
        KEJI_HK.put("513230", ContEtfTypeName.KEJI_HK);//港股消费ETF           市值：3.53      累涨：33.56     9.92      13.19     10.45     10日：8.50      4.64      2.67      -1.80     41        累涨修正：52.04     净值区间：40      73      76      78      78      35
        KEJI_HK.put("513070", ContEtfTypeName.KEJI_HK);//港股消费ETF易方达     市值：6.71      累涨：33.15     10.12     12.35     10.68     10日：8.51      4.76      2.61      -1.92     39        累涨修正：51.64     净值区间：38      73      76      78      79      36
        KEJI_HK.put("517200", ContEtfTypeName.KEJI_HK);//互联网ETF             市值：1.18      累涨：34.51     8.48      15.10     10.93     10日：8.03      3.41      2.49      -0.51     43        累涨修正：50.93     净值区间：86      92      94      95      96      37
        KEJI_HK.put("159735", ContEtfTypeName.KEJI_HK);//港股消费ETF           市值：6.37      累涨：33.44     10.52     12.78     10.14     10日：8.02      4.54      2.36      -2.09     40        累涨修正：50.72     净值区间：32      69      73      76      77      38
        KEJI_HK.put("159729", ContEtfTypeName.KEJI_HK);//互联网ETF             市值：0.82      累涨：33.71     8.74      14.39     10.58     10日：7.64      3.92      2.45      -0.55     47        累涨修正：50.17     净值区间：73      86      89      91      92      39
        KEJI_HK.put("159793", ContEtfTypeName.KEJI_HK);//线上消费ETF基金       市值：0.33      累涨：33.58     7.37      14.63     11.58     10日：7.97      3.02      2.61      -0.61     48        累涨修正：49.79     净值区间：80      91      93      95      95      40
        KEJI_HK.put("513590", ContEtfTypeName.KEJI_HK);//香港消费ETF           市值：3.45      累涨：32.66     9.80      12.68     10.18     10日：7.66      4.40      2.39      -1.63     46        累涨修正：49.5      净值区间：40      73      76      78      79      41
        KEJI_HK.put("517350", ContEtfTypeName.KEJI_HK);//科技ETF沪港深         市值：0.88      累涨：31.77     8.38      11.86     11.53     10日：8.88      4.09      2.22      -0.73     44        累涨修正：49.18     净值区间：75      91      93      94      95      42
        KEJI_HK.put("517360", ContEtfTypeName.KEJI_HK);//沪港深科技ETF         市值：0.33      累涨：31.73     9.90      11.87     9.96      10日：7.93      3.46      2.08      -1.52     49        累涨修正：47.28     净值区间：55      79      83      85      88      43
        KEJI_HK.put("159822", ContEtfTypeName.KEJI_HK);//新经济ETF             市值：7.27      累涨：26.88     11.16     6.61      9.11      10日：8.20      4.75      2.71      -1.40     38        累涨修正：45.25     净值区间：54      78      82      85      44      44
        KEJI_HK.put("159728", ContEtfTypeName.KEJI_HK);//在线消费ETF           市值：0.64      累涨：35.78     11.85     14.49     9.44      10日：3.38      1.16      0.93      1.50      42        累涨修正：42.18     净值区间：100     100     100     100     100     45
        KEJI_HK.put("159778", ContEtfTypeName.KEJI_HK);//工业互联ETF           市值：0.57      累涨：28.55     7.90      11.10     9.55      10日：5.56      2.57      1.75      0.34      27        累涨修正：40.18     净值区间：95      98      99      99      99      46
        KEJI_HK.put("159725", ContEtfTypeName.KEJI_HK);//线上消费ETF           市值：0.47      累涨：34.26     9.96      15.76     8.54      10日：2.69      1.17      0.94      1.17      45        累涨修正：40        净值区间：95      97      97      99      99      47
        KEJI_HK.put("513970", ContEtfTypeName.KEJI_HK);//恒生消费ETF           市值：15.59     累涨：25.41     7.42      10.08     7.91      10日：4.53      3.49      2.14      -0.90     51        累涨修正：37.71     净值区间：57      75      79      87      87      48
        KEJI_HK.put("159699", ContEtfTypeName.KEJI_HK);//恒生消费ETF           市值：10.12     累涨：25.97     8.25      9.94      7.78      10日：3.88      3.21      1.69      -0.46     53        累涨修正：36.44     净值区间：64      81      85      91      91      49
        KEJI_HK.put("517550", ContEtfTypeName.KEJI_HK);//消费ETF沪港深         市值：0.52      累涨：23.13     8.58      7.24      7.31      10日：5.10      3.16      1.76      -1.49     52        累涨修正：34.91     净值区间：32      67      73      79      63      50
        KEJI_HK.put("520520", ContEtfTypeName.KEJI_HK);//恒生消费ETF华泰柏瑞   市值：0.92      累涨：24.87     7.99      10.28     6.60      10日：3.62      2.72      1.57      -0.60     54        累涨修正：34.35     净值区间：54      75      80      88      88      51
        KEJI_HK.put("159550", ContEtfTypeName.KEJI_HK);//互联网ETF沪港深       市值：1.14      累涨：                              10.91     10日：8.46      4.05      2.50      -0.75     50        累涨修正：28.42     净值区间：72      86      89                      52
        KEJI_HK.put("159269", ContEtfTypeName.KEJI_HK);//港股通科技ETF南方     市值：2.92      累涨：                                        10日：11.36     5.23      3.62      -1.26     35        累涨修正：23.83     净值区间：67      85                              53
        KEJI_HK.put("159262", ContEtfTypeName.KEJI_HK);//港股通科技ETF         市值：20.83     累涨：                                        10日：10.71     5.60      3.71      -0.99     36        累涨修正：23.73     净值区间：60      82                              54
        KEJI_HK.put("520980", ContEtfTypeName.KEJI_HK);//港股通科技30ETF       市值：20.54     累涨：                                        10日：10.98     5.44      3.48      -1.07     33        累涨修正：23.38     净值区间：55      80                              55
        KEJI_HK.put("159265", ContEtfTypeName.KEJI_HK);//港股消费50ETF         市值：1.74      累涨：                                        10日：3.22      2.33      0.87      -0.38     55        累涨修正：7.29      净值区间：43      70                              56
        KEJI_HK.put("159251", ContEtfTypeName.KEJI_HK);//港股科技ETF基金       市值：4.06      累涨：                                        10日：                              -1.07     56        累涨修正：0         净值区间：                                        57
        KEJI_HK.put("520860", ContEtfTypeName.KEJI_HK);//N港股通科技ETF富国    市值：11.26     累涨：                                        10日：                              -1.08               累涨修正：          净值区间：                                        58
    }

    public static Map<String, String> TOP_KEJI_JUNGONG = new HashMap<>();
    static {
        TOP_KEJI_JUNGONG.put("512710", ContEtfTypeName.KEJI_JUNGONG);//军工龙头ETF           市值：136.81    累涨：39.85     13.34     13.59     12.92     10日：7.95      4.20      2.17      0.00      2         累涨修正：56.34     净值区间：64      82      83      91      94      1
    }
    public static Map<String, String> KEJI_JUNGONG = new HashMap<>();
    static {
        KEJI_JUNGONG.put("512710", ContEtfTypeName.KEJI_JUNGONG);//军工龙头ETF           市值：136.81    累涨：39.85     13.34     13.59     12.92     10日：7.95      4.20      2.17      0.00      2         累涨修正：56.34     净值区间：64      82      83      91      94      1
        KEJI_JUNGONG.put("512670", ContEtfTypeName.KEJI_JUNGONG);//国防ETF               市值：68.67     累涨：39.38     13.43     12.82     13.13     10日：8.29      4.25      2.12      0.12      1         累涨修正：56.16     净值区间：78      90      90      95      96      2
        KEJI_JUNGONG.put("159638", ContEtfTypeName.KEJI_JUNGONG);//高端装备ETF           市值：12.37     累涨：39.32     14.14     12.46     12.72     10日：7.55      3.71      2.09      0.23      4         累涨修正：54.76     净值区间：88      95      95      97      98      3
        KEJI_JUNGONG.put("512680", ContEtfTypeName.KEJI_JUNGONG);//军工ETF龙头           市值：58.56     累涨：36.97     12.47     12.00     12.50     10日：7.83      3.72      1.86      0.25      8         累涨修正：52.24     净值区间：91      96      96      98      99      4
        KEJI_JUNGONG.put("562910", ContEtfTypeName.KEJI_JUNGONG);//高端制造ETF           市值：0.93      累涨：29.72     8.16      7.73      13.83     10日：8.27      6.43      3.70      -0.87     3         累涨修正：51.82     净值区间：60      76      83      87      88      5
        KEJI_JUNGONG.put("512660", ContEtfTypeName.KEJI_JUNGONG);//军工ETF               市值：170.28    累涨：36.59     12.35     11.75     12.49     10日：7.59      3.82      1.82      0.00      9         累涨修正：51.64     净值区间：81      91      92      96      97      6
        KEJI_JUNGONG.put("512560", ContEtfTypeName.KEJI_JUNGONG);//军工ETF易方达         市值：6.65      累涨：36.36     11.92     12.04     12.40     10日：7.48      3.97      1.84      0.14      10        累涨修正：51.49     净值区间：84      93      94      97      98      7
        KEJI_JUNGONG.put("159378", ContEtfTypeName.KEJI_JUNGONG);//通用航空ETF           市值：8.96      累涨：38.31     14.19     13.19     10.93     10日：6.36      3.39      1.61      -0.50     11        累涨修正：51.28     净值区间：58      82      82      90      94      8
        KEJI_JUNGONG.put("516320", ContEtfTypeName.KEJI_JUNGONG);//高端装备ETF           市值：0.68      累涨：29.53     8.16      8.38      12.99     10日：7.92      6.19      3.70      -0.88     7         累涨修正：51.04     净值区间：54      73      79      86      86      9
        KEJI_JUNGONG.put("512810", ContEtfTypeName.KEJI_JUNGONG);//国防军工ETF           市值：7.99      累涨：34.22     12.24     9.79      12.19     10日：7.17      3.61      1.65      0.29      13        累涨修正：48.3      净值区间：94      97      98      13      12      10
        KEJI_JUNGONG.put("159206", ContEtfTypeName.KEJI_JUNGONG);//卫星ETF               市值：1.23      累涨：36.36     13.63     13.33     9.40      10日：3.11      1.00      1.00      0.10      14        累涨修正：42.47     净值区间：86      91      58      79      88      11
        KEJI_JUNGONG.put("159227", ContEtfTypeName.KEJI_JUNGONG);//航空航天ETF           市值：6.75      累涨：                    13.72     12.67     10日：7.54      3.90      2.04      0.17      6         累涨修正：41.91     净值区间：61      80      81      90              12
        KEJI_JUNGONG.put("159241", ContEtfTypeName.KEJI_JUNGONG);//航空航天ETF天弘       市值：4.06      累涨：                    11.09     12.76     10日：8.21      4.30      2.37      0.09      5         累涨修正：41.1      净值区间：62      80      82      91              13
        KEJI_JUNGONG.put("159208", ContEtfTypeName.KEJI_JUNGONG);//航天航空ETF           市值：0.59      累涨：                    14.17     12.02     10日：6.93      3.12      1.39      0.17      12        累涨修正：39.02     净值区间：65      79      82      90              14
        KEJI_JUNGONG.put("159231", ContEtfTypeName.KEJI_JUNGONG);//通用航空ETF华宝       市值：0.28      累涨：                    13.06     11.00     10日：5.85      2.71      1.31      -0.09     15        累涨修正：35.24     净值区间：66      85      85      91      94      15
        KEJI_JUNGONG.put("159392", ContEtfTypeName.KEJI_JUNGONG);//航空ETF               市值：0.42      累涨：                    12.27     10.98     10日：6.16      2.89      1.30      -0.46     16        累涨修正：34.9      净值区间：52      80      80      89              16
        KEJI_JUNGONG.put("159218", ContEtfTypeName.KEJI_JUNGONG);//卫星产业ETF           市值：0.31      累涨：                    11.71     10.41     10日：4.50      2.23      1.67      0.27      18        累涨修正：32.19     净值区间：100     100     72      84              17
        KEJI_JUNGONG.put("159230", ContEtfTypeName.KEJI_JUNGONG);//通用航空ETF基金       市值：0.19      累涨：                              10.52     10日：6.02      3.11      1.37      -0.27     17        累涨修正：22.39     净值区间：55      80      80      94              18
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

    public static Map<String, String> TOP_KEJI_RUAN_JIAN = new HashMap<>();
    static {
        TOP_KEJI_RUAN_JIAN.put("159851", ContEtfTypeName.KEJI_RUAN_JIAN);//金融科技ETF           市值：86.13     累涨：49.93     13.07     23.86     13.00     10日：6.21      2.26      2.26      -0.58     10        累涨修正：62.92     净值区间：74      66      2       2       2       1
        TOP_KEJI_RUAN_JIAN.put("159363", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF华宝 市值：18.03     累涨：52.09     15.21     21.81     15.07     10日：6.79      0.34      0.17      1.02      20        累涨修正：59.56     净值区间：74      3       3       3       3       5
    }
    public static Map<String, String> KEJI_RUAN_JIAN = new HashMap<>();
    static {
        KEJI_RUAN_JIAN.put("159851", ContEtfTypeName.KEJI_RUAN_JIAN);//金融科技ETF           市值：86.13     累涨：49.93     13.07     23.86     13.00     10日：6.21      2.26      2.26      -0.58     10        累涨修正：62.92     净值区间：74      66      2       2       2       1
        KEJI_RUAN_JIAN.put("516860", ContEtfTypeName.KEJI_RUAN_JIAN);//金融科技ETF           市值：13.68     累涨：49.20     12.25     23.66     13.29     10日：6.48      2.37      2.37      -0.61     8         累涨修正：62.79     净值区间：76      67      68      85      87      2
        KEJI_RUAN_JIAN.put("516100", ContEtfTypeName.KEJI_RUAN_JIAN);//金融科技ETF华夏       市值：9.93      累涨：49.15     12.58     23.88     12.69     10日：6.27      2.04      2.04      -0.36     11        累涨修正：61.54     净值区间：78      63      71      86      89      3
        KEJI_RUAN_JIAN.put("159388", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF国泰 市值：0.56      累涨：51.49     14.36     21.40     15.73     10日：7.21      0.33      0.33      0.99      15        累涨修正：59.69     净值区间：61      79      85      90      91      4
        KEJI_RUAN_JIAN.put("159363", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF华宝 市值：18.03     累涨：52.09     15.21     21.81     15.07     10日：6.79      0.34      0.17      1.02      20        累涨修正：59.56     净值区间：74      3       3       3       3       5
        KEJI_RUAN_JIAN.put("159381", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF华夏 市值：1.77      累涨：51.25     14.56     20.75     15.94     10日：7.13      0.36      0.27      1.08      12        累涨修正：59.28     净值区间：72      79      85      90      91      6
        KEJI_RUAN_JIAN.put("159738", ContEtfTypeName.KEJI_RUAN_JIAN);//云计算ETF华泰柏瑞     市值：6.09      累涨：42.64     11.29     17.32     14.03     10日：8.67      2.59      1.63      0.81      1         累涨修正：57.16     净值区间：98      89      92      94      94      7
        KEJI_RUAN_JIAN.put("517390", ContEtfTypeName.KEJI_RUAN_JIAN);//云计算ETF沪港深       市值：2.99      累涨：41.58     10.87     17.17     13.54     10日：8.85      2.74      1.80      0.77      2         累涨修正：56.77     净值区间：94      98      98      99      99      8
        KEJI_RUAN_JIAN.put("515230", ContEtfTypeName.KEJI_RUAN_JIAN);//软件ETF               市值：18.89     累涨：40.59     10.41     18.34     11.84     10日：8.22      2.88      2.19      1.02      7         累涨修正：56.07     净值区间：97      98      99      99      99      9
        KEJI_RUAN_JIAN.put("159852", ContEtfTypeName.KEJI_RUAN_JIAN);//软件ETF               市值：50.05     累涨：39.78     10.76     16.73     12.29     10日：9.26      2.53      2.17      1.42      5         累涨修正：55.91     净值区间：100     100     100     100     100     10
        KEJI_RUAN_JIAN.put("159899", ContEtfTypeName.KEJI_RUAN_JIAN);//软件龙头ETF           市值：3.38      累涨：40.78     9.84      18.66     12.28     10日：8.39      2.67      1.86      1.37      6         累涨修正：55.56     净值区间：97      98      99      99      99      11
        KEJI_RUAN_JIAN.put("159586", ContEtfTypeName.KEJI_RUAN_JIAN);//计算机ETF南方         市值：4.58      累涨：42.57     12.32     19.17     11.08     10日：7.12      2.15      1.77      1.37      19        累涨修正：55.38     净值区间：44      56      64      76      76      12
        KEJI_RUAN_JIAN.put("159590", ContEtfTypeName.KEJI_RUAN_JIAN);//软件50ETF             市值：1.98      累涨：40.19     9.57      18.26     12.36     10日：8.39      2.63      2.00      1.25      9         累涨修正：55.21     净值区间：100     100     100     100     100     13
        KEJI_RUAN_JIAN.put("159559", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人50ETF           市值：7.95      累涨：37.87     12.43     10.94     14.50     10日：10.95     3.31      0.99      0.98      3         累涨修正：54.11     净值区间：68      88      91      93      93      14
        KEJI_RUAN_JIAN.put("560660", ContEtfTypeName.KEJI_RUAN_JIAN);//云50ETF               市值：0.73      累涨：44.15     11.12     18.04     14.99     10日：7.67      0.68      0.68      1.43      24        累涨修正：53.86     净值区间：100     86      89      92      93      15
        KEJI_RUAN_JIAN.put("516510", ContEtfTypeName.KEJI_RUAN_JIAN);//云计算ETF             市值：31.21     累涨：42.25     11.51     17.14     13.60     10日：7.75      1.57      0.94      1.88      18        累涨修正：53.45     净值区间：98      98      98      99      99      16
        KEJI_RUAN_JIAN.put("159530", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人ETF易方达       市值：30.02     累涨：37.35     12.03     11.11     14.21     10日：10.86     3.13      1.04      0.81      4         累涨修正：53.42     净值区间：65      87      90      93      93      17
        KEJI_RUAN_JIAN.put("561010", ContEtfTypeName.KEJI_RUAN_JIAN);//软件ETF基金           市值：1.30      累涨：41.59     11.06     19.60     10.93     10日：6.91      1.88      1.52      1.68      30        累涨修正：53.42     净值区间：91      94      96      98      98      18
        KEJI_RUAN_JIAN.put("516630", ContEtfTypeName.KEJI_RUAN_JIAN);//云计算50ETF           市值：5.57      累涨：41.72     11.35     16.71     13.66     10日：7.90      1.70      1.05      1.61      14        累涨修正：53.42     净值区间：96      97      97      98      98      19
        KEJI_RUAN_JIAN.put("159739", ContEtfTypeName.KEJI_RUAN_JIAN);//大数据ETF             市值：4.70      累涨：41.26     10.67     16.61     13.98     10日：8.14      1.72      1.07      1.71      22        累涨修正：53.26     净值区间：100     97      97      98      98      20
        KEJI_RUAN_JIAN.put("560360", ContEtfTypeName.KEJI_RUAN_JIAN);//软件指数ETF           市值：1.50      累涨：38.07     10.30     16.13     11.64     10日：8.50      2.56      1.94      1.70      17        累涨修正：53.01     净值区间：45      55      62      70      70      21
        KEJI_RUAN_JIAN.put("159890", ContEtfTypeName.KEJI_RUAN_JIAN);//云计算ETF             市值：4.69      累涨：41.03     10.96     16.47     13.60     10日：8.00      1.78      1.01      1.77      21        累涨修正：52.83     净值区间：100     98      98      99      99      22
        KEJI_RUAN_JIAN.put("159527", ContEtfTypeName.KEJI_RUAN_JIAN);//云计算50ETF           市值：1.52      累涨：40.72     10.55     16.87     13.30     10日：7.83      1.68      1.00      1.91      27        累涨修正：52.23     净值区间：100     97      98      99      99      23
        KEJI_RUAN_JIAN.put("562930", ContEtfTypeName.KEJI_RUAN_JIAN);//软件ETF易方达         市值：1.55      累涨：37.77     9.75      16.79     11.23     10日：8.37      2.37      1.78      1.99      25        累涨修正：52.07     净值区间：97      98      99      99      99      24
        KEJI_RUAN_JIAN.put("515400", ContEtfTypeName.KEJI_RUAN_JIAN);//大数据ETF             市值：21.72     累涨：37.08     10.59     15.14     11.35     10日：7.57      2.14      1.47      1.68      29        累涨修正：49.73     净值区间：100     100     100     100     100     25
        KEJI_RUAN_JIAN.put("512720", ContEtfTypeName.KEJI_RUAN_JIAN);//计算机ETF             市值：14.97     累涨：36.34     10.44     14.80     11.10     10日：7.41      2.00      1.82      1.08      34        累涨修正：49.39     净值区间：100     100     100     100     100     26
        KEJI_RUAN_JIAN.put("515980", ContEtfTypeName.KEJI_RUAN_JIAN);//人工智能ETF           市值：33.23     累涨：39.25     10.85     14.57     13.83     10日：7.64      1.08      0.45      2.15      33        累涨修正：48.87     净值区间：98      99      99      99      100     27
        KEJI_RUAN_JIAN.put("560850", ContEtfTypeName.KEJI_RUAN_JIAN);//信创50ETF             市值：2.93      累涨：36.41     10.12     16.39     9.90      10日：6.92      1.97      1.37      1.28      41        累涨修正：48.04     净值区间：95      97      98      99      97      28
        KEJI_RUAN_JIAN.put("562360", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人ETF基金         市值：4.40      累涨：33.13     11.68     9.88      11.57     10日：8.58      2.94      1.68      0.93      13        累涨修正：48.01     净值区间：100     100     100     100     92      29
        KEJI_RUAN_JIAN.put("562030", ContEtfTypeName.KEJI_RUAN_JIAN);//信创ETF基金           市值：1.17      累涨：36.79     11.00     16.13     9.66      10日：6.74      1.91      1.21      1.40      40        累涨修正：47.86     净值区间：97      98      99      99      99      30
        KEJI_RUAN_JIAN.put("516700", ContEtfTypeName.KEJI_RUAN_JIAN);//大数据产业ETF         市值：1.20      累涨：36.77     11.02     15.06     10.69     10日：6.99      1.71      1.18      1.81      39        累涨修正：47.83     净值区间：79      86      89      93      93      31
        KEJI_RUAN_JIAN.put("562500", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人ETF             市值：161.41    累涨：33.62     11.62     10.11     11.89     10日：8.40      2.73      1.48      1.01      16        累涨修正：47.71     净值区间：96      98      99      99      92      32
        KEJI_RUAN_JIAN.put("159770", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人ETF             市值：64.18     累涨：33.96     11.92     10.33     11.71     10日：8.22      2.64      1.43      1.08      23        累涨修正：47.68     净值区间：96      98      99      99      93      33
        KEJI_RUAN_JIAN.put("562570", ContEtfTypeName.KEJI_RUAN_JIAN);//信创ETF               市值：6.69      累涨：36.45     10.06     16.68     9.71      10日：6.74      1.85      1.24      1.30      44        累涨修正：47.52     净值区间：98      99      99      99      93      34
        KEJI_RUAN_JIAN.put("159819", ContEtfTypeName.KEJI_RUAN_JIAN);//人工智能ETF           市值：165.92    累涨：36.97     10.32     13.49     13.16     10日：7.43      1.18      0.79      2.25      38        累涨修正：47.16     净值区间：93      97      97      98      98      35
        KEJI_RUAN_JIAN.put("562920", ContEtfTypeName.KEJI_RUAN_JIAN);//信息安全ETF           市值：0.61      累涨：36.75     10.93     16.31     9.51      10日：5.44      1.76      1.45      0.72      48        累涨修正：46.85     净值区间：91      95      97      98      98      36
        KEJI_RUAN_JIAN.put("159998", ContEtfTypeName.KEJI_RUAN_JIAN);//计算机ETF             市值：36.34     累涨：35.72     10.51     14.72     10.49     10日：6.76      1.42      1.42      1.50      50        累涨修正：46.74     净值区间：86      91      93      96      96      37
        KEJI_RUAN_JIAN.put("516000", ContEtfTypeName.KEJI_RUAN_JIAN);//数据ETF               市值：4.05      累涨：35.60     10.35     14.72     10.53     10日：6.70      1.87      1.25      1.87      45        累涨修正：46.67     净值区间：100     100     100     100     90      38
        KEJI_RUAN_JIAN.put("517800", ContEtfTypeName.KEJI_RUAN_JIAN);//人工智能50ETF         市值：2.84      累涨：31.05     8.02      11.79     11.24     10日：8.40      3.33      1.91      2.14      31        累涨修正：46.6      净值区间：97      99      99      99      99      39
        KEJI_RUAN_JIAN.put("588760", ContEtfTypeName.KEJI_RUAN_JIAN);//人工智能ETF科创       市值：14.29     累涨：33.09     8.08      12.96     12.05     10日：7.54      2.34      1.80      3.72      37        累涨修正：46.57     净值区间：89      92      94      95      95      40
        KEJI_RUAN_JIAN.put("159526", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人ETF嘉实         市值：5.93      累涨：32.93     11.51     10.08     11.34     10日：8.30      2.65      1.25      1.23      26        累涨修正：46.38     净值区间：97      99      99      99      90      41
        KEJI_RUAN_JIAN.put("159382", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF南方 市值：0.64      累涨：                    21.99     15.53     10日：7.24      0.48      0.48      1.11      35        累涨修正：46.2      净值区间：76      80      85      90              42
        KEJI_RUAN_JIAN.put("159613", ContEtfTypeName.KEJI_RUAN_JIAN);//信息安全ETF           市值：0.73      累涨：36.99     11.33     16.34     9.32      10日：5.23      1.43      1.21      0.87      51        累涨修正：46.07     净值区间：100     100     100     100     100     43
        KEJI_RUAN_JIAN.put("159551", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人产业ETF         市值：3.83      累涨：32.39     11.27     9.64      11.48     10日：8.13      2.56      1.41      1.13      28        累涨修正：45.9      净值区间：97      99      99      99      91      44
        KEJI_RUAN_JIAN.put("515070", ContEtfTypeName.KEJI_RUAN_JIAN);//人工智能AIETF         市值：53.59     累涨：35.27     9.57      12.78     12.92     10日：7.68      1.16      0.77      2.22      43        累涨修正：45.65     净值区间：96      98      99      99      99      45
        KEJI_RUAN_JIAN.put("512330", ContEtfTypeName.KEJI_RUAN_JIAN);//信息科技ETF           市值：5.80      累涨：36.48     9.81      15.99     10.68     10日：5.18      1.39      1.30      1.47      57        累涨修正：45.65     净值区间：100     100     100     100     100     46
        KEJI_RUAN_JIAN.put("512930", ContEtfTypeName.KEJI_RUAN_JIAN);//AI人工智能ETF         市值：18.04     累涨：35.55     9.60      13.09     12.86     10日：7.36      1.17      0.76      2.26      42        累涨修正：45.6      净值区间：97      99      99      99      99      47
        KEJI_RUAN_JIAN.put("588790", ContEtfTypeName.KEJI_RUAN_JIAN);//科创AIETF             市值：50.25     累涨：34.53     9.69      13.84     11.00     10日：6.94      1.70      1.19      4.70      46        累涨修正：45.55     净值区间：98      98      99      99      99      48
        KEJI_RUAN_JIAN.put("560630", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人产业ETF         市值：4.76      累涨：31.05     10.91     9.06      11.08     10日：8.33      2.61      1.36      1.03      32        累涨修正：44.71     净值区间：92      97      98      98      93      49
        KEJI_RUAN_JIAN.put("589010", ContEtfTypeName.KEJI_RUAN_JIAN);//科创人工智能ETF华夏   市值：0.72      累涨：33.00     8.66      13.41     10.93     10日：6.91      1.93      1.35      4.20      47        累涨修正：44.54     净值区间：89      92      93      94      94      50
        KEJI_RUAN_JIAN.put("159786", ContEtfTypeName.KEJI_RUAN_JIAN);//VRETF                 市值：1.26      累涨：35.83     10.60     13.13     12.10     10日：5.05      1.62      0.76      0.54      49        累涨修正：44.02     净值区间：100     98      98      99      99      51
        KEJI_RUAN_JIAN.put("588730", ContEtfTypeName.KEJI_RUAN_JIAN);//科创人工智能ETF       市值：7.71      累涨：32.55     8.45      13.11     10.99     10日：6.74      1.67      1.20      4.60      52        累涨修正：43.36     净值区间：93      95      96      96      96      52
        KEJI_RUAN_JIAN.put("562560", ContEtfTypeName.KEJI_RUAN_JIAN);//信息技术ETF           市值：0.37      累涨：32.01     8.19      12.58     11.24     10日：5.88      1.88      1.74      1.07      53        累涨修正：43.25     净值区间：88      93      95      97      97      53
        KEJI_RUAN_JIAN.put("588930", ContEtfTypeName.KEJI_RUAN_JIAN);//科创板人工智能ETF     市值：10.13     累涨：33.23     9.20      13.00     11.03     10日：6.45      1.29      1.12      4.19      55        累涨修正：43.21     净值区间：90      93      94      95      87      54
        KEJI_RUAN_JIAN.put("159939", ContEtfTypeName.KEJI_RUAN_JIAN);//信息技术ETF           市值：16.73     累涨：32.37     8.29      12.93     11.15     10日：5.65      1.65      1.65      1.18      58        累涨修正：42.97     净值区间：96      98      98      99      99      55
        KEJI_RUAN_JIAN.put("560800", ContEtfTypeName.KEJI_RUAN_JIAN);//数字经济ETF           市值：7.89      累涨：29.19     7.20      12.73     9.26      10日：5.83      2.56      2.30      1.13      54        累涨修正：42.18     净值区间：91      93      95      97      97      56
        KEJI_RUAN_JIAN.put("589520", ContEtfTypeName.KEJI_RUAN_JIAN);//科创人工智能ETF华宝   市值：3.06      累涨：31.83     8.47      12.80     10.56     10日：6.57      1.69      1.02      4.81      56        累涨修正：42.13     净值区间：97      98      98      98      98      57
        KEJI_RUAN_JIAN.put("159539", ContEtfTypeName.KEJI_RUAN_JIAN);//信创ETF广发           市值：1.13      累涨：30.28     8.23      12.77     9.28      10日：5.87      1.96      1.62      2.18      59        累涨修正：41.35     净值区间：98      99      99      99      94      58
        KEJI_RUAN_JIAN.put("159540", ContEtfTypeName.KEJI_RUAN_JIAN);//信创ETF易方达         市值：2.34      累涨：29.50     8.27      12.11     9.12      10日：5.78      2.04      1.63      1.85      62        累涨修正：40.58     净值区间：94      96      97      98      98      59
        KEJI_RUAN_JIAN.put("159537", ContEtfTypeName.KEJI_RUAN_JIAN);//信创ETF               市值：2.35      累涨：29.22     7.08      12.96     9.18      10日：5.89      1.94      1.69      1.91      61        累涨修正：40.43     净值区间：98      99      99      99      92      60
        KEJI_RUAN_JIAN.put("159658", ContEtfTypeName.KEJI_RUAN_JIAN);//数字经济ETF           市值：2.00      累涨：27.95     6.84      12.02     9.09      10日：5.97      2.37      2.04      1.61      60        累涨修正：40.37     净值区间：96      97      98      99      99      61
        KEJI_RUAN_JIAN.put("159538", ContEtfTypeName.KEJI_RUAN_JIAN);//信创ETF富国           市值：1.53      累涨：28.75     7.67      11.98     9.10      10日：5.84      1.85      1.68      1.65      66        累涨修正：39.8      净值区间：94      95      96      98      78      62
        KEJI_RUAN_JIAN.put("513360", ContEtfTypeName.KEJI_RUAN_JIAN);//教育ETF               市值：4.86      累涨：34.20     10.55     16.59     7.06      10日：3.22      0.95      0.57      0.00      63        累涨修正：39.51     净值区间：40      52      64      79      80      63
        KEJI_RUAN_JIAN.put("588100", ContEtfTypeName.KEJI_RUAN_JIAN);//科创信息技术ETF       市值：2.56      累涨：25.20     5.59      10.49     9.12      10日：5.37      2.46      2.46      2.79      65        累涨修正：37.95     净值区间：94      95      96      96      96      64
        KEJI_RUAN_JIAN.put("588770", ContEtfTypeName.KEJI_RUAN_JIAN);//科创信息技术ETF摩根   市值：2.99      累涨：24.28     5.09      10.44     8.75      10日：5.46      2.59      2.59      2.54      64        累涨修正：37.51     净值区间：90      92      93      94      94      65
        KEJI_RUAN_JIAN.put("588260", ContEtfTypeName.KEJI_RUAN_JIAN);//科创信息ETF           市值：1.28      累涨：24.21     5.22      10.33     8.66      10日：5.12      2.34      2.26      3.11      67        累涨修正：36.19     净值区间：97      48      48      53      57      66
        KEJI_RUAN_JIAN.put("159213", ContEtfTypeName.KEJI_RUAN_JIAN);//机器人ETF基金         市值：0.97      累涨：                    9.28      11.48     10日：8.49      3.21      1.60      0.65      36        累涨修正：35.66     净值区间：65      82      86      90              67
        KEJI_RUAN_JIAN.put("159389", ContEtfTypeName.KEJI_RUAN_JIAN);//数字经济ETF嘉实       市值：2.70      累涨：                              9.18      10日：5.57      2.09      1.90      0.93      68        累涨修正：20.64     净值区间：100     100     100     100             68
        KEJI_RUAN_JIAN.put("159385", ContEtfTypeName.KEJI_RUAN_JIAN);//数字经济ETF富国       市值：2.37      累涨：                              8.50      10日：5.09      2.19      1.80      0.93      70        累涨修正：19.38     净值区间：94      96      97      98              69
        KEJI_RUAN_JIAN.put("561220", ContEtfTypeName.KEJI_RUAN_JIAN);//数字经济ETF工银       市值：3.09      累涨：                              8.82      10日：5.10      1.91      1.72      1.03      73        累涨修正：19.27     净值区间：97      98      98      99              70
        KEJI_RUAN_JIAN.put("589380", ContEtfTypeName.KEJI_RUAN_JIAN);//AIETF富国             市值：0.63      累涨：                                        10日：6.74      1.45      1.06      4.60      71        累涨修正：10.31     净值区间：90      93                              71
        KEJI_RUAN_JIAN.put("159246", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF富国 市值：0.70      累涨：                                        10日：7.32      0.45      0.18      1.25      72        累涨修正：8.13      净值区间：86      41                              72
        KEJI_RUAN_JIAN.put("159311", ContEtfTypeName.KEJI_RUAN_JIAN);//数字经济ETF易方达     市值：1.15      累涨：                                        10日：          2.36      2.26      1.25      69        累涨修正：6.88      净值区间：93                                      73
        KEJI_RUAN_JIAN.put("159248", ContEtfTypeName.KEJI_RUAN_JIAN);//人工智能ETF基金       市值：3.03      累涨：                                        10日：                              2.49      74        累涨修正：0         净值区间：                                        74
        KEJI_RUAN_JIAN.put("159242", ContEtfTypeName.KEJI_RUAN_JIAN);//创业板人工智能ETF大成 市值：3.91      累涨：                                        10日：                              0.80      75        累涨修正：0         净值区间：                                        75
    }

    public static Map<String, String> TOP_KEJI_XIN_PIAN = new HashMap<>();
    static {
        TOP_KEJI_XIN_PIAN.put("159909", ContEtfTypeName.KEJI_XIN_PIAN);//TMT50ETF              市值：5.11      累涨：41.71     11.91     15.05     14.75     10日：9.62      3.22      3.22      1.44      2         累涨修正：60.99     净值区间：100     100     100     100     100     1
    }
    public static Map<String, String> KEJI_XIN_PIAN = new HashMap<>();
    static {
        KEJI_XIN_PIAN.put("159909", ContEtfTypeName.KEJI_XIN_PIAN);//TMT50ETF              市值：5.11      累涨：41.71     11.91     15.05     14.75     10日：9.62      3.22      3.22      1.44      2         累涨修正：60.99     净值区间：100     100     100     100     100     1
        KEJI_XIN_PIAN.put("512220", ContEtfTypeName.KEJI_XIN_PIAN);//TMTETF                市值：4.48      累涨：39.21     10.22     15.41     13.58     10日：8.86      3.43      3.43      1.85      3         累涨修正：58.36     净值区间：100     100     100     100     100     2
        KEJI_XIN_PIAN.put("561100", ContEtfTypeName.KEJI_XIN_PIAN);//消费电子ETF富国       市值：5.78      累涨：37.08     9.27      13.67     14.14     10日：8.08      3.58      3.58      1.27      4         累涨修正：55.9      净值区间：100     100     100     100     100     3
        KEJI_XIN_PIAN.put("561600", ContEtfTypeName.KEJI_XIN_PIAN);//消费电子ETF           市值：2.11      累涨：36.04     9.91      12.71     13.42     10日：7.69      3.60      3.60      1.25      5         累涨修正：54.53     净值区间：98      98      99      99      99      4
        KEJI_XIN_PIAN.put("159732", ContEtfTypeName.KEJI_XIN_PIAN);//消费电子ETF           市值：22.50     累涨：39.49     12.17     14.15     13.17     10日：7.61      2.33      2.33      0.46      6         累涨修正：54.09     净值区间：97      98      99      99      99      5
        KEJI_XIN_PIAN.put("561310", ContEtfTypeName.KEJI_XIN_PIAN);//消电ETF               市值：0.67      累涨：36.25     9.87      13.39     12.99     10日：7.59      3.36      3.36      1.17      8         累涨修正：53.92     净值区间：100     100     100     100     100     6
        KEJI_XIN_PIAN.put("159779", ContEtfTypeName.KEJI_XIN_PIAN);//消费电子50ETF         市值：1.14      累涨：35.90     10.25     13.21     12.44     10日：7.16      3.58      3.58      1.21      9         累涨修正：53.8      净值区间：98      98      99      99      99      7
        KEJI_XIN_PIAN.put("562950", ContEtfTypeName.KEJI_XIN_PIAN);//消费电子ETF易方达     市值：4.32      累涨：35.85     9.37      13.38     13.10     10日：7.34      3.32      3.32      1.57      10        累涨修正：53.15     净值区间：100     100     100     100     100     8
        KEJI_XIN_PIAN.put("588170", ContEtfTypeName.KEJI_XIN_PIAN);//科创半导体ETF         市值：4.06      累涨：33.21     7.94      14.04     11.23     10日：7.60      6.61      2.62      1.76      1         累涨修正：52.66     净值区间：99      99      99      99      99      9
        KEJI_XIN_PIAN.put("159997", ContEtfTypeName.KEJI_XIN_PIAN);//电子ETF               市值：13.17     累涨：34.60     10.45     12.55     11.60     10日：7.30      3.38      3.29      1.07      12        累涨修正：51.86     净值区间：98      99      99      99      99      10
        KEJI_XIN_PIAN.put("515320", ContEtfTypeName.KEJI_XIN_PIAN);//电子50ETF             市值：1.56      累涨：33.45     8.52      11.38     13.55     10日：8.05      3.55      3.32      1.34      11        累涨修正：51.69     净值区间：100     100     100     100     100     11
        KEJI_XIN_PIAN.put("515260", ContEtfTypeName.KEJI_XIN_PIAN);//电子ETF               市值：4.43      累涨：33.07     9.55      11.00     12.52     10日：7.55      3.49      3.49      1.24      17        累涨修正：51.09     净值区间：98      98      99      99      99      12
        KEJI_XIN_PIAN.put("561980", ContEtfTypeName.KEJI_XIN_PIAN);//半导体设备ETF         市值：9.91      累涨：29.57     6.98      11.55     11.04     10日：7.69      6.53      3.40      1.66      7         累涨修正：50.59     净值区间：99      99      99      99      99      13
        KEJI_XIN_PIAN.put("588200", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF           市值：335.22    累涨：28.81     6.87      11.77     10.17     10日：6.63      5.65      4.02      2.23      14        累涨修正：49.13     净值区间：96      97      97      97      97      14
        KEJI_XIN_PIAN.put("159582", ContEtfTypeName.KEJI_XIN_PIAN);//半导体产业ETF         市值：1.92      累涨：27.84     6.25      11.06     10.53     10日：7.57      6.51      3.44      1.52      15        累涨修正：48.8      净值区间：99      99      99      100     100     15
        KEJI_XIN_PIAN.put("588890", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF南方       市值：5.97      累涨：28.11     6.41      12.03     9.67      10日：6.63      5.63      4.05      2.16      22        累涨修正：48.47     净值区间：98      98      98      99      99      16
        KEJI_XIN_PIAN.put("588750", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片50ETF         市值：17.57     累涨：28.47     6.43      12.04     10.00     10日：6.60      5.42      3.96      2.14      20        累涨修正：48.41     净值区间：98      98      98      98      98      17
        KEJI_XIN_PIAN.put("588990", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF博时       市值：2.27      累涨：27.82     6.00      11.98     9.84      10日：6.59      5.71      4.09      2.14      24        累涨修正：48.3      净值区间：97      97      98      98      98      18
        KEJI_XIN_PIAN.put("588810", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF富国       市值：0.87      累涨：27.95     5.91      12.31     9.73      10日：6.79      5.67      3.91      2.11      21        累涨修正：48.23     净值区间：99      99      99      99      100     19
        KEJI_XIN_PIAN.put("588290", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF基金       市值：27.39     累涨：27.62     6.36      11.33     9.93      10日：6.66      5.65      4.05      2.16      23        累涨修正：48.03     净值区间：97      98      98      98      98      20
        KEJI_XIN_PIAN.put("588780", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片设计ETF       市值：2.51      累涨：30.22     8.00      13.42     8.80      10日：5.30      4.05      3.76      2.74      27        累涨修正：47.09     净值区间：96      97      97      98      92      21
        KEJI_XIN_PIAN.put("159327", ContEtfTypeName.KEJI_XIN_PIAN);//半导体设备ETF基金     市值：1.63      累涨：29.17     7.90      11.06     10.21     10日：7.07      5.28      2.64      1.14      16        累涨修正：46.8      净值区间：99      99      99      99      99      22
        KEJI_XIN_PIAN.put("589100", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF国泰       市值：1.02      累涨：27.04     6.03      11.36     9.65      10日：6.44      5.52      3.90      2.12      28        累涨修正：46.8      净值区间：97      98      98      98      98      23
        KEJI_XIN_PIAN.put("560780", ContEtfTypeName.KEJI_XIN_PIAN);//芯片设备ETF           市值：2.14      累涨：29.62     8.35      11.46     9.81      10日：6.77      5.54      2.26      1.23      13        累涨修正：46.45     净值区间：100     100     100     100     100     24
        KEJI_XIN_PIAN.put("562590", ContEtfTypeName.KEJI_XIN_PIAN);//半导体材料ETF         市值：3.92      累涨：28.58     7.32      11.02     10.24     10日：6.79      5.42      2.81      1.29      18        累涨修正：46.41     净值区间：100     100     100     100     100     25
        KEJI_XIN_PIAN.put("159516", ContEtfTypeName.KEJI_XIN_PIAN);//半导体设备ETF         市值：31.21     累涨：29.77     8.57      11.57     9.63      10日：6.48      5.33      2.30      1.36      19        累涨修正：46.18     净值区间：100     100     100     100     100     26
        KEJI_XIN_PIAN.put("562820", ContEtfTypeName.KEJI_XIN_PIAN);//集成电路ETF           市值：0.69      累涨：28.04     7.13      12.03     8.88      10日：5.85      4.29      3.98      1.61      29        累涨修正：46.14     净值区间：99      99      99      99      95      27
        KEJI_XIN_PIAN.put("513310", ContEtfTypeName.KEJI_XIN_PIAN);//中韩半导体ETF         市值：5.95      累涨：34.91     10.73     16.57     7.61      10日：3.45      2.61      2.30      0.48      30        累涨修正：45.57     净值区间：95      95      95      97      98      28
        KEJI_XIN_PIAN.put("512480", ContEtfTypeName.KEJI_XIN_PIAN);//半导体ETF             市值：272.51    累涨：27.77     7.89      11.38     8.50      10日：5.74      4.48      3.61      1.48      31        累涨修正：45.21     净值区间：98      99      99      99      99      29
        KEJI_XIN_PIAN.put("159558", ContEtfTypeName.KEJI_XIN_PIAN);//半导体设备ETF易方达   市值：5.09      累涨：27.26     6.50      10.97     9.79      10日：6.60      5.52      2.36      1.08      26        累涨修正：44.1      净值区间：99      99      99      99      99      30
        KEJI_XIN_PIAN.put("159560", ContEtfTypeName.KEJI_XIN_PIAN);//芯片50ETF             市值：1.34      累涨：26.44     6.99      10.72     8.73      10日：5.79      4.51      3.67      1.55      34        累涨修正：44.08     净值区间：100     100     100     100     98      31
        KEJI_XIN_PIAN.put("159995", ContEtfTypeName.KEJI_XIN_PIAN);//芯片ETF               市值：275.67    累涨：26.19     6.98      9.85      9.36      10日：6.18      4.52      3.54      1.25      33        累涨修正：43.97     净值区间：99      99      99      99      99      32
        KEJI_XIN_PIAN.put("159546", ContEtfTypeName.KEJI_XIN_PIAN);//集成电路ETF           市值：1.34      累涨：27.43     7.35      12.12     7.96      10日：5.16      3.77      3.62      1.54      37        累涨修正：43.6      净值区间：99      99      99      99      93      33
        KEJI_XIN_PIAN.put("516640", ContEtfTypeName.KEJI_XIN_PIAN);//芯片龙头ETF           市值：13.76     累涨：25.89     6.65      10.36     8.88      10日：5.91      4.57      3.51      1.40      36        累涨修正：43.39     净值区间：100     100     100     100     99      34
        KEJI_XIN_PIAN.put("159813", ContEtfTypeName.KEJI_XIN_PIAN);//半导体ETF             市值：58.07     累涨：25.82     6.65      9.97      9.20      10日：6.06      4.64      3.37      1.34      35        累涨修正：43.26     净值区间：98      98      99      99      97      35
        KEJI_XIN_PIAN.put("516350", ContEtfTypeName.KEJI_XIN_PIAN);//芯片ETF易方达         市值：10.62     累涨：25.72     6.92      10.12     8.68      10日：5.78      4.46      3.63      1.48      41        累涨修正：43.22     净值区间：98      98      99      99      99      36
        KEJI_XIN_PIAN.put("159325", ContEtfTypeName.KEJI_XIN_PIAN);//半导体ETF南方         市值：1.78      累涨：26.33     6.77      11.19     8.37      10日：5.59      4.26      3.42      1.54      42        累涨修正：43.02     净值区间：97      97      98      98      88      37
        KEJI_XIN_PIAN.put("512760", ContEtfTypeName.KEJI_XIN_PIAN);//芯片ETF               市值：121.60    累涨：25.95     7.03      10.19     8.73      10日：5.71      4.47      3.43      1.34      39        累涨修正：42.99     净值区间：96      97      97      98      98      38
        KEJI_XIN_PIAN.put("515920", ContEtfTypeName.KEJI_XIN_PIAN);//智能消费ETF           市值：1.82      累涨：29.03     8.20      9.98      10.85     10日：6.00      2.62      2.51      0.75      32        累涨修正：42.67     净值区间：100     100     100     100     100     39
        KEJI_XIN_PIAN.put("516920", ContEtfTypeName.KEJI_XIN_PIAN);//芯片50ETF             市值：5.17      累涨：25.32     6.67      10.20     8.45      10日：5.67      4.43      3.61      1.30      43        累涨修正：42.64     净值区间：98      98      98      99      96      40
        KEJI_XIN_PIAN.put("159665", ContEtfTypeName.KEJI_XIN_PIAN);//半导体龙头ETF         市值：3.78      累涨：24.52     6.39      9.14      8.99      10日：6.06      4.70      3.67      1.44      38        累涨修正：42.62     净值区间：100     100     100     100     100     41
        KEJI_XIN_PIAN.put("159801", ContEtfTypeName.KEJI_XIN_PIAN);//芯片ETF龙头           市值：34.81     累涨：24.31     6.11      9.32      8.88      10日：6.19      4.53      3.71      1.42      40        累涨修正：42.45     净值区间：100     100     100     100     100     42
        KEJI_XIN_PIAN.put("159599", ContEtfTypeName.KEJI_XIN_PIAN);//芯片ETF基金           市值：7.24      累涨：24.75     6.12      10.19     8.44      10日：5.78      4.40      3.71      1.38      44        累涨修正：42.35     净值区间：98      98      98      99      96      43
        KEJI_XIN_PIAN.put("159310", ContEtfTypeName.KEJI_XIN_PIAN);//芯片ETF天弘           市值：11.04     累涨：24.91     6.35      10.20     8.36      10日：5.70      4.32      3.57      1.25      45        累涨修正：42.07     净值区间：98      98      98      99      99      44
        KEJI_XIN_PIAN.put("588710", ContEtfTypeName.KEJI_XIN_PIAN);//科创半导体设备ETF     市值：1.18      累涨：                              12.03     10日：7.45      6.49      2.73      1.70      25        累涨修正：31.43     净值区间：100     100     100     100             45
        KEJI_XIN_PIAN.put("588920", ContEtfTypeName.KEJI_XIN_PIAN);//科创芯片ETF指数       市值：4.83      累涨：                                        10日：                              1.35                累涨修正：          净值区间：                                        46
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

    public static Map<String, String> TOP_KEJI_NEW_ENERGY = new HashMap<>();
    static {
        TOP_KEJI_NEW_ENERGY.put("588830", ContEtfTypeName.KEJI_NEW_ENERGY);//科创新能源ETF         市值：4.81      累涨：40.11     9.39      14.62     16.10     10日：8.84      6.70      5.04      -0.99     2         累涨修正：65.73     净值区间：83      89      91      95      95      1
    }
    public static Map<String, String> KEJI_NEW_ENERGY = new HashMap<>();
    static {
        KEJI_NEW_ENERGY.put("588830", ContEtfTypeName.KEJI_NEW_ENERGY);//科创新能源ETF         市值：4.81      累涨：40.11     9.39      14.62     16.10     10日：8.84      6.70      5.04      -0.99     2         累涨修正：65.73     净值区间：83      89      91      95      95      1
        KEJI_NEW_ENERGY.put("588960", ContEtfTypeName.KEJI_NEW_ENERGY);//科创板新能源ETF       市值：1.08      累涨：38.94     9.42      13.46     16.06     10日：8.62      6.74      5.08      -1.02     1         累涨修正：64.46     净值区间：77      86      88      93      93      2
        KEJI_NEW_ENERGY.put("159864", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏50ETF             市值：6.20      累涨：37.42     10.36     8.18      18.88     10日：7.65      6.79      5.28      -1.23     3         累涨修正：62.42     净值区间：71      77      89      91      91      3
        KEJI_NEW_ENERGY.put("516180", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF基金           市值：0.69      累涨：38.28     9.97      8.85      19.46     10日：7.68      6.32      4.97      -1.13     4         累涨修正：62.22     净值区间：73      78      90      92      92      4
        KEJI_NEW_ENERGY.put("515790", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF               市值：140.87    累涨：37.14     9.13      9.31      18.70     10日：7.42      6.44      4.91      -1.06     9         累涨修正：60.82     净值区间：71      77      88      91      91      5
        KEJI_NEW_ENERGY.put("516090", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源ETF易方达       市值：6.73      累涨：34.68     8.59      9.43      16.66     10日：8.50      7.18      4.83      -0.49     6         累涨修正：60.02     净值区间：90      93      95      97      97      6
        KEJI_NEW_ENERGY.put("159857", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF               市值：24.33     累涨：36.75     9.02      9.55      18.18     10日：7.32      6.16      4.84      -1.10     12        累涨修正：59.91     净值区间：75      80      90      92      92      7
        KEJI_NEW_ENERGY.put("516580", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源主题ETF         市值：0.95      累涨：34.70     8.98      10.39     15.33     10日：8.08      6.99      5.05      -0.61     5         累涨修正：59.87     净值区间：85      89      92      95      95      8
        KEJI_NEW_ENERGY.put("159618", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF指数基金       市值：0.65      累涨：36.98     10.10     8.80      18.08     10日：7.28      6.22      4.64      -1.01     10        累涨修正：59.76     净值区间：75      81      90      93      93      9
        KEJI_NEW_ENERGY.put("159863", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF基金           市值：2.57      累涨：35.83     8.72      7.97      19.14     10日：7.67      6.41      4.73      -1.20     13        累涨修正：59.37     净值区间：74      80      90      93      93      10
        KEJI_NEW_ENERGY.put("159875", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源ETF             市值：9.31      累涨：34.29     8.95      9.64      15.70     10日：8.02      6.94      5.02      -0.81     7         累涨修正：59.29     净值区间：85      89      93      95      95      11
        KEJI_NEW_ENERGY.put("516160", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源ETF             市值：44.31     累涨：34.38     8.68      9.79      15.91     10日：8.00      6.77      4.85      -0.53     8         累涨修正：58.85     净值区间：87      91      94      96      96      12
        KEJI_NEW_ENERGY.put("561380", ContEtfTypeName.KEJI_NEW_ENERGY);//电网ETF               市值：0.73      累涨：37.02     7.25      12.38     17.39     10日：11.27     4.95      2.58      -0.71     14        累涨修正：58.4      净值区间：15      49      56      69      72      13
        KEJI_NEW_ENERGY.put("516850", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源ETF基金         市值：1.18      累涨：33.97     8.56      9.94      15.47     10日：7.84      6.57      4.62      -0.40     11        累涨修正：57.62     净值区间：85      89      93      95      95      14
        KEJI_NEW_ENERGY.put("562970", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF易方达         市值：3.05      累涨：36.45     10.69     7.98      17.78     10日：6.55      5.44      4.34      -0.71     17        累涨修正：57.12     净值区间：73      78      89      91      91      15
        KEJI_NEW_ENERGY.put("516880", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏50ETF             市值：12.58     累涨：36.17     9.42      8.83      17.92     10日：6.84      5.68      4.20      -1.26     15        累涨修正：57.09     净值区间：72      78      89      91      91      16
        KEJI_NEW_ENERGY.put("159320", ContEtfTypeName.KEJI_NEW_ENERGY);//电网ETF               市值：0.27      累涨：36.80     7.58      12.49     16.73     10日：11.09     4.60      2.14      -0.62     16        累涨修正：56.77     净值区间：32      74      80      87      88      17
        KEJI_NEW_ENERGY.put("159609", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏龙头ETF           市值：2.77      累涨：35.79     9.47      8.85      17.47     10日：6.39      5.43      4.47      -1.14     18        累涨修正：56.55     净值区间：77      81      91      93      93      18
        KEJI_NEW_ENERGY.put("560980", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏ETF龙头           市值：1.75      累涨：33.39     8.52      9.65      15.22     10日：6.26      5.42      3.94      -1.01     20        累涨修正：52.95     净值区间：76      81      90      93      93      19
        KEJI_NEW_ENERGY.put("159368", ContEtfTypeName.KEJI_NEW_ENERGY);//创业板新能源ETF华夏   市值：0.71      累涨：36.08     10.73     12.62     12.73     10日：5.30      3.64      2.41      -0.40     19        累涨修正：49.84     净值区间：85      90      94      96      97      20
        KEJI_NEW_ENERGY.put("159861", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和50ETF           市值：1.58      累涨：29.67     8.19      7.95      13.53     10日：6.26      4.94      3.51      -0.80     22        累涨修正：47.89     净值区间：73      79      86      90      91      21
        KEJI_NEW_ENERGY.put("159326", ContEtfTypeName.KEJI_NEW_ENERGY);//电网设备ETF           市值：1.05      累涨：26.37     5.88      8.13      12.36     10日：7.90      5.43      2.43      -0.52     21        累涨修正：44.56     净值区间：29      48      58      67      67      22
        KEJI_NEW_ENERGY.put("562010", ContEtfTypeName.KEJI_NEW_ENERGY);//绿色能源ETF           市值：0.14      累涨：29.02     8.62      8.59      11.81     10日：5.86      4.11      2.77      -0.39     34        累涨修正：44.53     净值区间：83      89      92      94      95      23
        KEJI_NEW_ENERGY.put("159752", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源龙头ETF         市值：2.90      累涨：27.77     8.39      7.75      11.63     10日：5.50      4.85      3.14      -0.82     27        累涨修正：44.4      净值区间：84      88      92      95      95      24
        KEJI_NEW_ENERGY.put("159641", ContEtfTypeName.KEJI_NEW_ENERGY);//双碳ETF               市值：2.70      累涨：23.99     6.63      5.89      11.47     10日：7.47      6.23      3.31      -0.81     23        累涨修正：44.31     净值区间：80      87      90      92      93      25
        KEJI_NEW_ENERGY.put("159640", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和龙头ETF         市值：1.77      累涨：24.00     6.90      5.85      11.25     10日：7.02      6.11      3.14      -0.74     26        累涨修正：43.41     净值区间：78      85      88      91      91      26
        KEJI_NEW_ENERGY.put("561190", ContEtfTypeName.KEJI_NEW_ENERGY);//双碳ETF               市值：6.28      累涨：23.71     6.40      6.18      11.13     10日：7.08      6.04      3.23      -0.49     28        累涨修正：43.29     净值区间：79      85      88      91      92      27
        KEJI_NEW_ENERGY.put("159639", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF南方         市值：6.97      累涨：23.72     6.67      5.92      11.13     10日：6.82      6.17      3.23      -0.61     29        累涨修正：43.17     净值区间：80      87      90      92      93      28
        KEJI_NEW_ENERGY.put("562990", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF易方达       市值：10.53     累涨：24.28     6.81      6.06      11.41     10日：6.84      6.06      2.99      -0.49     24        累涨修正：43.16     净值区间：74      83      87      90      90      29
        KEJI_NEW_ENERGY.put("512580", ContEtfTypeName.KEJI_NEW_ENERGY);//环保ETF               市值：12.06     累涨：27.13     7.82      7.91      11.40     10日：5.48      4.45      3.02      -0.59     34        累涨修正：43.1      净值区间：76      84      90      93      94      30
        KEJI_NEW_ENERGY.put("560550", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF龙头         市值：4.14      累涨：23.42     6.79      6.03      10.60     10日：6.94      6.29      3.10      -0.61     25        累涨修正：42.85     净值区间：83      88      91      93      94      31
        KEJI_NEW_ENERGY.put("159885", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF基金         市值：2.47      累涨：26.00     8.34      5.71      11.95     10日：5.78      4.61      3.11      -0.64     30        累涨修正：42.61     净值区间：73      78      87      90      91      32
        KEJI_NEW_ENERGY.put("159790", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF             市值：20.56     累涨：25.85     8.46      5.71      11.68     10日：5.29      4.60      3.05      -0.50     36        累涨修正：41.84     净值区间：65      76      85      89      90      33
        KEJI_NEW_ENERGY.put("560060", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF             市值：2.20      累涨：23.77     7.20      5.48      11.09     10日：6.57      5.79      2.79      -0.12     31        累涨修正：41.71     净值区间：76      83      86      89      89      34
        KEJI_NEW_ENERGY.put("159642", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和100ETF          市值：0.83      累涨：22.98     6.77      5.63      10.58     10日：6.66      5.89      2.97      -0.49     35        累涨修正：41.47     净值区间：83      89      91      93      93      35
        KEJI_NEW_ENERGY.put("516070", ContEtfTypeName.KEJI_NEW_ENERGY);//低碳ETF易方达         市值：2.61      累涨：25.78     7.65      6.73      11.40     10日：5.15      4.71      2.76      -0.63     33        累涨修正：41.16     净值区间：72      80      88      91      92      36
        KEJI_NEW_ENERGY.put("560560", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF泰康         市值：0.65      累涨：26.95     8.45      6.64      11.86     10日：4.74      4.21      2.26      -0.34     32        累涨修正：40.42     净值区间：56      64      75      82      83      37
        KEJI_NEW_ENERGY.put("159387", ContEtfTypeName.KEJI_NEW_ENERGY);//创业板新能源ETF国泰   市值：0.23      累涨：                              13.18     10日：5.92      4.63      3.44      -0.97     37        累涨修正：30.61     净值区间：78      86      91                      38
        KEJI_NEW_ENERGY.put("159611", ContEtfTypeName.KEJI_NEW_ENERGY);//电力ETF               市值：36.07     累涨：17.55     5.46      3.72      8.37      10日：4.20      3.10      1.69      -0.79     38        累涨修正：28.23     净值区间：27      45      64      68      71      39
        KEJI_NEW_ENERGY.put("561560", ContEtfTypeName.KEJI_NEW_ENERGY);//电力ETF               市值：5.77      累涨：17.25     5.57      3.67      8.01      10日：3.72      2.81      1.23      -0.57     39        累涨修正：26.24     净值区间：28      45      64      69      71      40
        KEJI_NEW_ENERGY.put("159625", ContEtfTypeName.KEJI_NEW_ENERGY);//绿色电力ETF           市值：3.13      累涨：17.81     6.71      3.60      7.50      10日：3.41      2.56      1.10      -0.34     42        累涨修正：25.98     净值区间：25      48      64      69      73      41
        KEJI_NEW_ENERGY.put("561700", ContEtfTypeName.KEJI_NEW_ENERGY);//电力ETF基金           市值：1.47      累涨：17.31     5.69      3.54      8.08      10日：3.61      2.66      1.04      -0.38     43        累涨修正：25.66     净值区间：24      42      55      59      62      42
        KEJI_NEW_ENERGY.put("159669", ContEtfTypeName.KEJI_NEW_ENERGY);//绿电ETF               市值：0.99      累涨：17.40     6.79      3.08      7.53      10日：3.55      2.62      0.93      -0.65     41        累涨修正：25.43     净值区间：9       22      35      41      45      43
        KEJI_NEW_ENERGY.put("562960", ContEtfTypeName.KEJI_NEW_ENERGY);//绿色电力ETF易方达     市值：0.94      累涨：17.62     6.14      3.79      7.69      10日：3.39      2.38      0.91      -0.27     44        累涨修正：25.21     净值区间：28      46      64      70      72      44
        KEJI_NEW_ENERGY.put("562350", ContEtfTypeName.KEJI_NEW_ENERGY);//电力指数ETF           市值：0.39      累涨：16.46     5.57      2.93      7.96      10日：3.71      2.57      1.04      -0.38     45        累涨修正：24.82     净值区间：24      40      60      65      70      45
        KEJI_NEW_ENERGY.put("560580", ContEtfTypeName.KEJI_NEW_ENERGY);//电力ETF南方           市值：0.57      累涨：17.59     6.17      3.93      7.49      10日：3.14      2.19      0.95      -0.38     46        累涨修正：24.82     净值区间：25      46      65      70      73      46
        KEJI_NEW_ENERGY.put("561170", ContEtfTypeName.KEJI_NEW_ENERGY);//绿色电力ETF           市值：1.41      累涨：17.33     5.81      3.57      7.95      10日：3.29      2.20      0.73      -0.45     47        累涨修正：24.28     净值区间：24      40      60      65      69      47
        KEJI_NEW_ENERGY.put("562550", ContEtfTypeName.KEJI_NEW_ENERGY);//绿电ETF               市值：1.45      累涨：17.23     6.32      3.59      7.32      10日：3.02      2.11      0.64      -0.55     48        累涨修正：23.64     净值区间：18      31      53      57      60      48
        KEJI_NEW_ENERGY.put("159261", ContEtfTypeName.KEJI_NEW_ENERGY);//创业板新能源ETF鹏华   市值：1.94      累涨：                                        10日：6.10      4.33      3.07      -0.85     40        累涨修正：16.57     净值区间：72      92                              49
        KEJI_NEW_ENERGY.put("516270", ContEtfTypeName.KEJI_NEW_ENERGY);//新能源50ETF           市值：2.05      累涨：                                        10日：                              -0.21     49        累涨修正：0         净值区间：83      88      92      95      95      50
        KEJI_NEW_ENERGY.put("562300", ContEtfTypeName.KEJI_NEW_ENERGY);//碳中和ETF基金         市值：0.61      累涨：                                        10日：                              -0.34     50        累涨修正：0         净值区间：65      76      84      89      90      51
        KEJI_NEW_ENERGY.put("516290", ContEtfTypeName.KEJI_NEW_ENERGY);//光伏龙头ETF           市值：3.83      累涨：                                        10日：                              -1.28     51        累涨修正：0         净值区间：65      72      85      89      89      52
    }

    public static Map<String, String> TOP_KEJI_NEW_CAR = new HashMap<>();
    static {
        TOP_KEJI_NEW_CAR.put("159755", ContEtfTypeName.KEJI_NEW_CAR);//电池ETF               市值：40.06     累涨：38.14     12.46     12.69     12.99     10日：8.97      6.85      4.49      -0.66     1         累涨修正：62.94     净值区间：82      89      90      93      94      1
    }
    public static Map<String, String> KEJI_NEW_CAR = new HashMap<>();
    static {
        KEJI_NEW_CAR.put("159755", ContEtfTypeName.KEJI_NEW_CAR);//电池ETF               市值：40.06     累涨：38.14     12.46     12.69     12.99     10日：8.97      6.85      4.49      -0.66     1         累涨修正：62.94     净值区间：82      89      90      93      94      1
        KEJI_NEW_CAR.put("159757", ContEtfTypeName.KEJI_NEW_CAR);//电池30ETF             市值：3.10      累涨：36.92     11.83     12.03     13.06     10日：9.24      7.17      4.65      -0.80     2         累涨修正：62.63     净值区间：82      89      89      93      94      2
        KEJI_NEW_CAR.put("159775", ContEtfTypeName.KEJI_NEW_CAR);//新能源车电池ETF       市值：0.59      累涨：36.32     11.69     11.87     12.76     10日：9.17      6.96      4.63      -0.47     3         累涨修正：61.71     净值区间：91      94      95      96      97      3
        KEJI_NEW_CAR.put("520600", ContEtfTypeName.KEJI_NEW_CAR);//港股汽车ETF           市值：6.91      累涨：40.04     15.15     12.98     11.91     10日：9.92      3.65      3.09      -1.24     6         累涨修正：59.79     净值区间：62      84      86      89      90      4
        KEJI_NEW_CAR.put("159767", ContEtfTypeName.KEJI_NEW_CAR);//电池龙头ETF           市值：1.13      累涨：37.58     12.94     11.59     13.05     10日：8.48      6.39      3.66      -0.32     4         累涨修正：59.77     净值区间：84      90      91      94      95      5
        KEJI_NEW_CAR.put("159323", ContEtfTypeName.KEJI_NEW_CAR);//港股通汽车ETF         市值：2.27      累涨：39.87     14.46     13.47     11.94     10日：9.95      3.45      3.14      -1.35     5         累涨修正：59.55     净值区间：58      82      85      88      88      6
        KEJI_NEW_CAR.put("159840", ContEtfTypeName.KEJI_NEW_CAR);//锂电池ETF             市值：9.70      累涨：35.63     11.69     11.75     12.19     10日：8.09      6.50      4.24      -0.49     7         累涨修正：58.7      净值区间：77      85      86      91      92      7
        KEJI_NEW_CAR.put("515700", ContEtfTypeName.KEJI_NEW_CAR);//新能车ETF             市值：23.15     累涨：34.72     11.20     10.85     12.67     10日：8.92      6.29      4.18      -0.22     8         累涨修正：58.29     净值区间：88      93      94      96      96      8
        KEJI_NEW_CAR.put("159637", ContEtfTypeName.KEJI_NEW_CAR);//新能源车龙头ETF       市值：8.29      累涨：34.43     11.09     11.03     12.31     10日：9.08      6.35      4.15      -0.15     9         累涨修正：58.16     净值区间：91      95      95      96      97      9
        KEJI_NEW_CAR.put("516390", ContEtfTypeName.KEJI_NEW_CAR);//新能源汽车ETF         市值：3.22      累涨：34.60     10.91     11.25     12.44     10日：8.58      6.53      4.08      0.00      10        累涨修正：57.87     净值区间：89      93      94      96      96      10
        KEJI_NEW_CAR.put("515030", ContEtfTypeName.KEJI_NEW_CAR);//新能源车ETF           市值：44.35     累涨：34.38     11.31     10.69     12.38     10日：8.85      6.22      4.12      -0.22     11        累涨修正：57.69     净值区间：87      93      93      95      96      11
        KEJI_NEW_CAR.put("516660", ContEtfTypeName.KEJI_NEW_CAR);//新能源车ETF基金       市值：3.14      累涨：34.20     11.17     10.91     12.12     10日：8.73      5.88      3.85      0.00      13        累涨修正：56.51     净值区间：87      93      93      95      95      12
        KEJI_NEW_CAR.put("561910", ContEtfTypeName.KEJI_NEW_CAR);//电池ETF               市值：7.61      累涨：35.74     10.28     12.37     13.09     10日：7.01      5.02      4.05      -0.75     12        累涨修正：55.87     净值区间：75      85      89      93      94      13
        KEJI_NEW_CAR.put("159796", ContEtfTypeName.KEJI_NEW_CAR);//电池50ETF             市值：10.91     累涨：35.23     10.28     12.18     12.77     10日：6.93      5.24      3.92      -0.48     15        累涨修正：55.24     净值区间：82      90      92      95      96      14
        KEJI_NEW_CAR.put("159824", ContEtfTypeName.KEJI_NEW_CAR);//新能车ETF             市值：1.60      累涨：33.12     10.65     10.52     11.95     10日：8.35      5.73      3.64      -0.22     18        累涨修正：54.48     净值区间：88      93      94      96      96      15
        KEJI_NEW_CAR.put("561160", ContEtfTypeName.KEJI_NEW_CAR);//锂电池ETF             市值：6.15      累涨：35.97     10.50     12.99     12.48     10日：6.82      4.44      3.27      -0.75     14        累涨修正：53.77     净值区间：67      79      84      91      91      16
        KEJI_NEW_CAR.put("562880", ContEtfTypeName.KEJI_NEW_CAR);//电池ETF嘉实           市值：3.06      累涨：35.46     10.51     12.55     12.40     10日：6.46      4.72      3.39      -0.55     16        累涨修正：53.42     净值区间：80      88      90      95      95      17
        KEJI_NEW_CAR.put("159566", ContEtfTypeName.KEJI_NEW_CAR);//储能电池ETF           市值：1.23      累涨：36.14     10.60     13.68     11.86     10日：4.76      3.89      2.66      -0.28     19        累涨修正：50.11     净值区间：86      92      95      97      98      18
        KEJI_NEW_CAR.put("159305", ContEtfTypeName.KEJI_NEW_CAR);//储能电池ETF广发       市值：0.40      累涨：35.77     10.44     13.03     12.30     10日：5.10      4.03      2.41      -0.24     17        累涨修正：49.72     净值区间：85      92      95      97      97      19
        KEJI_NEW_CAR.put("516590", ContEtfTypeName.KEJI_NEW_CAR);//智能汽车ETF易方达     市值：0.91      累涨：29.95     10.29     9.96      9.70      10日：6.12      4.03      2.30      -0.10     26        累涨修正：44.7      净值区间：93      97      97      98      98      20
        KEJI_NEW_CAR.put("159720", ContEtfTypeName.KEJI_NEW_CAR);//智能车ETF泰康         市值：0.54      累涨：29.97     10.37     9.66      9.94      10日：6.30      3.96      2.12      0.15      27        累涨修正：44.47     净值区间：95      98      98      98      98      21
        KEJI_NEW_CAR.put("560000", ContEtfTypeName.KEJI_NEW_CAR);//智慧电车ETF           市值：0.09      累涨：29.05     10.15     7.91      10.99     10日：6.70      3.98      1.89      -0.14     30        累涨修正：43.51     净值区间：83      91      93      94      59      22
        KEJI_NEW_CAR.put("562700", ContEtfTypeName.KEJI_NEW_CAR);//汽车零部件ETF         市值：0.65      累涨：31.89     11.66     10.42     9.81      10日：7.03      1.64      0.69      -0.60     20        累涨修正：41.94     净值区间：32      75      79      85      75      23
        KEJI_NEW_CAR.put("516380", ContEtfTypeName.KEJI_NEW_CAR);//智能电动车ETF         市值：0.93      累涨：29.29     9.86      10.20     9.23      10日：5.66      3.44      1.64      0.50      34        累涨修正：41.67     净值区间：92      96      96      97      98      24
        KEJI_NEW_CAR.put("159565", ContEtfTypeName.KEJI_NEW_CAR);//汽车零部件ETF         市值：0.96      累涨：32.24     12.19     10.37     9.68      10日：6.35      1.28      0.88      0.08      23        累涨修正：41.63     净值区间：67      88      90      93      89      25
        KEJI_NEW_CAR.put("515250", ContEtfTypeName.KEJI_NEW_CAR);//智能汽车ETF           市值：7.81      累涨：31.80     10.95     11.94     8.91      10日：4.48      1.44      0.93      0.82      24        累涨修正：39.58     净值区间：96      98      98      99      92      26
        KEJI_NEW_CAR.put("159888", ContEtfTypeName.KEJI_NEW_CAR);//智能车ETF             市值：0.83      累涨：31.28     10.61     12.01     8.66      10日：4.49      1.48      1.02      0.83      25        累涨修正：39.29     净值区间：100     100     100     100     95      27
        KEJI_NEW_CAR.put("159306", ContEtfTypeName.KEJI_NEW_CAR);//汽车零件ETF           市值：0.23      累涨：30.10     11.71     10.17     8.22      10日：6.05      1.39      0.87      -0.43     28        累涨修正：39.28     净值区间：44      85      85      87      87      28
        KEJI_NEW_CAR.put("516520", ContEtfTypeName.KEJI_NEW_CAR);//智能驾驶ETF           市值：3.78      累涨：30.78     10.58     11.67     8.53      10日：4.33      1.58      1.12      0.74      32        累涨修正：38.93     净值区间：96      98      98      99      96      29
        KEJI_NEW_CAR.put("159239", ContEtfTypeName.KEJI_NEW_CAR);//港股通汽车ETF富国     市值：1.12      累涨：                    11.49     11.50     10日：8.40      2.28      2.18      -0.65     22        累涨修正：38.03     净值区间：69      88      90      93              30
        KEJI_NEW_CAR.put("159889", ContEtfTypeName.KEJI_NEW_CAR);//智能汽车ETF           市值：0.49      累涨：31.12     10.88     12.15     8.09      10日：3.91      1.07      0.75      0.96      31        累涨修正：37.6      净值区间：83      91      92      95      88      31
        KEJI_NEW_CAR.put("159872", ContEtfTypeName.KEJI_NEW_CAR);//智能网联汽车ETF       市值：0.46      累涨：29.40     11.63     11.35     6.42      10日：3.61      1.85      0.98      0.76      29        累涨修正：36.82     净值区间：100     100     100     100     100     32
        KEJI_NEW_CAR.put("562260", ContEtfTypeName.KEJI_NEW_CAR);//汽车配件ETF           市值：0.11      累涨：32.00     7.97      18.04     5.99      10日：2.39      0.74      0.74      0.00      37        累涨修正：36.61     净值区间：9       4       3       35      56      33
        KEJI_NEW_CAR.put("159795", ContEtfTypeName.KEJI_NEW_CAR);//智能汽车ETF基金       市值：0.41      累涨：30.05     10.80     11.27     7.98      10日：4.08      0.98      0.65      0.97      36        累涨修正：36.41     净值区间：100     100     100     100     96      34
        KEJI_NEW_CAR.put("159512", ContEtfTypeName.KEJI_NEW_CAR);//汽车ETF               市值：0.63      累涨：26.25     10.97     7.85      7.43      10日：4.55      1.54      1.12      0.21      35        累涨修正：34.58     净值区间：75      88      89      92      69      35
        KEJI_NEW_CAR.put("159210", ContEtfTypeName.KEJI_NEW_CAR);//港股汽车ETF           市值：1.00      累涨：                              12.31     10日：9.82      3.90      3.23      -1.58     21        累涨修正：32.49     净值区间：58      81      84                      36
        KEJI_NEW_CAR.put("516110", ContEtfTypeName.KEJI_NEW_CAR);//汽车ETF               市值：4.64      累涨：24.53     10.87     8.16      5.50      10日：3.40      1.30      0.69      -0.46     38        累涨修正：30.61     净值区间：62      82      82      89      46      37
        KEJI_NEW_CAR.put("159237", ContEtfTypeName.KEJI_NEW_CAR);//港股汽车ETF基金       市值：1.11      累涨：                                        10日：9.86      3.43      2.77      -0.81     33        累涨修正：18.83     净值区间：70      88                              38
        KEJI_NEW_CAR.put("159806", ContEtfTypeName.KEJI_NEW_CAR);//新能源车ETF           市值：10.01     累涨：                                        10日：                              -0.34     39        累涨修正：0         净值区间：89      94      94      96      96      39
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
        TOP_INDEX_CN_NOT.put("513520", ContEtfTypeName.INDEX_CN_NOT);//日经ETF               市值：14.53     累涨：24.89     7.19      8.93      8.77      10日：6.28      4.94      4.74      -1.64     2         累涨修正：45.59     净值区间：62      62      62      74      78      1
//        TOP_INDEX_CN_NOT.put("513730", ContEtfTypeName.INDEX_CN_NOT);//东南亚科技ETF         市值：15.89     累涨：29.67     10.04     8.88      10.75     10日：6.72      2.65      1.28      -0.95     1         累涨修正：41.6      净值区间：11      63      68      77      77      6
        TOP_INDEX_CN_NOT.put("159561", ContEtfTypeName.INDEX_CN_NOT);//德国ETF               市值：15.61     累涨：28.97     11.24     6.84      10.89     10日：4.22      2.61      1.37      -0.93     5         累涨修正：38.54     净值区间：35      54      50      78      82      9
    }
    public static Map<String, String> INDEX_CN_NOT = new HashMap<>();
    static {
        INDEX_CN_NOT.put("513520", ContEtfTypeName.INDEX_CN_NOT);//日经ETF               市值：14.53     累涨：24.89     7.19      8.93      8.77      10日：6.28      4.94      4.74      -1.64     2         累涨修正：45.59     净值区间：62      62      62      74      78      1
        INDEX_CN_NOT.put("513880", ContEtfTypeName.INDEX_CN_NOT);//日经225ETF            市值：15.55     累涨：25.07     7.44      8.84      8.79      10日：6.11      4.59      4.45      -1.43     3         累涨修正：44.67     净值区间：65      67      67      76      80      2
        INDEX_CN_NOT.put("513000", ContEtfTypeName.INDEX_CN_NOT);//日经225ETF易方达      市值：13.25     累涨：24.02     6.92      8.58      8.52      10日：6.02      4.74      4.54      -1.58     6         累涨修正：43.86     净值区间：65      68      68      75      79      3
        INDEX_CN_NOT.put("513800", ContEtfTypeName.INDEX_CN_NOT);//日本东证指数ETF       市值：7.52      累涨：21.00     6.43      6.70      7.87      10日：5.92      5.44      5.37      -1.80     7         累涨修正：43.1      净值区间：72      73      73      76      77      4
        INDEX_CN_NOT.put("159687", ContEtfTypeName.INDEX_CN_NOT);//亚太精选ETF           市值：5.38      累涨：24.74     7.76      7.99      8.99      10日：5.28      4.34      3.69      -0.96     4         累涨修正：41.74     净值区间：65      71      67      66      74      5
        INDEX_CN_NOT.put("513730", ContEtfTypeName.INDEX_CN_NOT);//东南亚科技ETF         市值：15.89     累涨：29.67     10.04     8.88      10.75     10日：6.72      2.65      1.28      -0.95     1         累涨修正：41.6      净值区间：11      63      68      77      77      6
        INDEX_CN_NOT.put("159866", ContEtfTypeName.INDEX_CN_NOT);//日经ETF               市值：6.94      累涨：22.73     6.38      8.98      7.37      10日：5.37      4.04      3.77      -1.60     9         累涨修正：39.68     净值区间：55      58      58      70      73      7
        INDEX_CN_NOT.put("513080", ContEtfTypeName.INDEX_CN_NOT);//法国CAC40ETF          市值：8.68      累涨：24.53     7.21      5.42      11.90     10日：5.22      3.82      2.89      -1.92     10        累涨修正：39.35     净值区间：30      42      43      70      73      8
        INDEX_CN_NOT.put("159561", ContEtfTypeName.INDEX_CN_NOT);//德国ETF               市值：15.61     累涨：28.97     11.24     6.84      10.89     10日：4.22      2.61      1.37      -0.93     5         累涨修正：38.54     净值区间：35      54      50      78      82      9
        INDEX_CN_NOT.put("513030", ContEtfTypeName.INDEX_CN_NOT);//德国ETF               市值：15.04     累涨：28.50     12.91     6.08      9.51      10日：3.61      2.22      1.48      -0.84     8         累涨修正：37.29     净值区间：42      54      47      72      79      10
        INDEX_CN_NOT.put("159329", ContEtfTypeName.INDEX_CN_NOT);//沙特ETF               市值：14.72     累涨：14.00     7.28      5.52      1.20      10日：0.60      0.30      0.30      -0.20     11        累涨修正：15.5      净值区间：17      7       5       10      4       11
        INDEX_CN_NOT.put("520830", ContEtfTypeName.INDEX_CN_NOT);//沙特ETF               市值：11.51     累涨：11.21     5.15      3.97      2.09      10日：0.63      0.53      0.42      -0.32     12        累涨修正：13.21     净值区间：57      22      16      16      5       12
        INDEX_CN_NOT.put("520580", ContEtfTypeName.INDEX_CN_NOT);//新兴亚洲ETF           市值：4.01      累涨：                                        10日：                              -0.68     13        累涨修正：0         净值区间：16      50      50      70      48      13
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
        TOP_INDEX_300.put("159370", ContEtfTypeName.INDEX_300);//创50ETF工银           市值：0.85      累涨：41.82     12.13     14.57     15.12     10日：7.76      3.27      1.93      -0.35     2         累涨修正：56.71     净值区间：82      93      95      97      97      1
    }
    public static Map<String, String> INDEX_300 = new HashMap<>();
    static {
        INDEX_300.put("159370", ContEtfTypeName.INDEX_300);//创50ETF工银           市值：0.85      累涨：41.82     12.13     14.57     15.12     10日：7.76      3.27      1.93      -0.35     2         累涨修正：56.71     净值区间：82      93      95      97      97      1
        INDEX_300.put("159383", ContEtfTypeName.INDEX_300);//创业板50ETF华泰柏瑞   市值：0.87      累涨：40.70     12.05     13.37     15.28     10日：8.15      3.37      2.14      -0.55     1         累涨修正：56.5      净值区间：82      92      95      97      97      2
        INDEX_300.put("159991", ContEtfTypeName.INDEX_300);//创大盘ETF             市值：1.22      累涨：41.07     11.31     14.45     15.31     10日：8.16      2.91      2.13      -0.38     4         累涨修正：56.4      净值区间：83      93      95      97      97      3
        INDEX_300.put("159949", ContEtfTypeName.INDEX_300);//创业板50ETF           市值：250.26    累涨：41.52     12.09     14.18     15.25     10日：7.81      3.09      1.92      -0.28     3         累涨修正：56.26     净值区间：85      93      96      97      98      4
        INDEX_300.put("159367", ContEtfTypeName.INDEX_300);//创业板50ETF华夏       市值：0.51      累涨：41.25     12.59     13.93     14.73     10日：8.28      2.74      1.73      0.00      6         累涨修正：55.73     净值区间：85      94      96      97      98      5
        INDEX_300.put("159681", ContEtfTypeName.INDEX_300);//创50ETF               市值：16.51     累涨：40.38     11.99     13.22     15.17     10日：8.04      3.14      1.95      -0.38     5         累涨修正：55.46     净值区间：82      92      95      97      97      6
        INDEX_300.put("159682", ContEtfTypeName.INDEX_300);//创业50ETF             市值：43.07     累涨：40.57     11.88     14.04     14.65     10日：7.63      3.18      1.88      -0.19     7         累涨修正：55.14     净值区间：88      95      96      98      98      7
        INDEX_300.put("159371", ContEtfTypeName.INDEX_300);//创50ETF富国           市值：0.27      累涨：41.12     14.56     12.18     14.38     10日：7.48      2.77      1.84      0.00      18        累涨修正：55.05     净值区间：90      96      58      70      73      8
        INDEX_300.put("159597", ContEtfTypeName.INDEX_300);//创业板成长ETF易方达   市值：0.97      累涨：42.11     11.21     16.09     14.81     10日：7.86      2.06      1.47      -0.15     11        累涨修正：54.97     净值区间：83      93      95      97      98      9
        INDEX_300.put("159375", ContEtfTypeName.INDEX_300);//创业板50ETF国泰       市值：1.98      累涨：40.02     11.85     13.18     14.99     10日：7.88      3.05      1.82      -0.17     8         累涨修正：54.59     净值区间：88      95      97      98      98      10
        INDEX_300.put("159814", ContEtfTypeName.INDEX_300);//创业大盘ETF           市值：5.62      累涨：40.34     10.89     15.53     13.92     10日：7.93      2.64      1.76      -0.43     13        累涨修正：54.43     净值区间：80      91      94      96      97      11
        INDEX_300.put("159373", ContEtfTypeName.INDEX_300);//创业板50ETF嘉实       市值：3.58      累涨：40.45     12.00     13.62     14.83     10日：7.24      3.18      1.71      -0.18     10        累涨修正：54.29     净值区间：83      92      95      97      97      12
        INDEX_300.put("159971", ContEtfTypeName.INDEX_300);//创业板ETF富国         市值：24.96     累涨：37.23     10.33     12.79     14.11     10日：7.81      3.64      2.56      -0.43     14        累涨修正：53.8      净值区间：88      94      96      97      98      13
        INDEX_300.put("159915", ContEtfTypeName.INDEX_300);//创业板ETF             市值：872.97    累涨：37.95     10.51     13.26     14.18     10日：7.73      3.52      2.28      -0.30     9         累涨修正：53.76     净值区间：89      95      97      98      98      14
        INDEX_300.put("159952", ContEtfTypeName.INDEX_300);//创业板ETF广发         市值：106.32    累涨：37.55     10.31     12.84     14.40     10日：8.04      3.39      2.15      -0.21     12        累涨修正：53.28     净值区间：83      92      94      96      97      15
        INDEX_300.put("159808", ContEtfTypeName.INDEX_300);//创100ETF融通          市值：0.98      累涨：37.30     10.53     12.79     13.98     10日：7.34      3.55      2.51      -0.33     15        累涨修正：53.21     净值区间：81      90      93      96      96      16
        INDEX_300.put("159948", ContEtfTypeName.INDEX_300);//创业板ETF南方         市值：46.37     累涨：36.90     10.36     12.73     13.81     10日：7.54      3.52      2.32      -0.35     16        累涨修正：52.6      净值区间：87      94      96      97      98      17
        INDEX_300.put("159957", ContEtfTypeName.INDEX_300);//创业板ETF华夏         市值：17.73     累涨：37.12     10.32     12.94     13.86     10日：7.48      3.40      2.26      -0.33     17        累涨修正：52.52     净值区间：84      92      95      97      97      18
        INDEX_300.put("159956", ContEtfTypeName.INDEX_300);//创业板ETF建信         市值：1.20      累涨：37.18     10.34     13.35     13.49     10日：7.25      3.38      2.06      -0.14     19        累涨修正：51.93     净值区间：77      89      92      95      96      19
        INDEX_300.put("159964", ContEtfTypeName.INDEX_300);//创业板ETF平安         市值：5.04      累涨：36.45     10.30     12.47     13.68     10日：7.39      3.42      2.20      -0.07     20        累涨修正：51.66     净值区间：90      95      97      98      98      20
        INDEX_300.put("159773", ContEtfTypeName.INDEX_300);//创业板科技ETF         市值：1.93      累涨：37.41     9.04      13.66     14.71     10日：7.27      3.24      1.81      0.25      2         累涨修正：51.54     净值区间：96      98      99      99      99      21
        INDEX_300.put("159908", ContEtfTypeName.INDEX_300);//创业板ETF博时         市值：15.60     累涨：36.03     10.20     12.70     13.13     10日：7.67      3.38      2.10      -0.05     21        累涨修正：51.28     净值区间：92      96      97      98      99      22
        INDEX_300.put("159958", ContEtfTypeName.INDEX_300);//创业板ETF工银         市值：4.51      累涨：36.56     10.41     12.86     13.29     10日：7.07      3.25      2.01      -0.07     22        累涨修正：50.9      净值区间：87      94      96      97      98      23
        INDEX_300.put("159810", ContEtfTypeName.INDEX_300);//创业板ETF浦银         市值：0.81      累涨：36.10     10.48     12.95     12.67     10日：6.85      3.26      2.16      0.11      23        累涨修正：50.53     净值区间：93      97      98      99      99      24
        INDEX_300.put("159967", ContEtfTypeName.INDEX_300);//创业板成长ETF         市值：40.11     累涨：37.67     10.25     15.80     11.62     10日：6.69      2.33      1.90      -0.42     28        累涨修正：50.49     净值区间：79      87      92      96      96      25
        INDEX_300.put("159821", ContEtfTypeName.INDEX_300);//BOCI创业板ETF         市值：0.21      累涨：35.77     9.64      12.26     13.87     10日：7.23      3.13      2.08      0.23      26        累涨修正：50.29     净值区间：90      96      97      98      98      26
        INDEX_300.put("159368", ContEtfTypeName.INDEX_300);//创业板新能源ETF华夏   市值：0.71      累涨：36.08     10.73     12.62     12.73     10日：5.30      3.64      2.41      -0.50     19        累涨修正：49.84     净值区间：79      86      91      95      95      27
        INDEX_300.put("159836", ContEtfTypeName.INDEX_300);//创业板300ETF天弘      市值：1.69      累涨：35.89     10.08     14.16     11.65     10日：6.32      2.77      1.76      0.11      30        累涨修正：48.5      净值区间：92      96      98      99      99      28
        INDEX_300.put("159675", ContEtfTypeName.INDEX_300);//创业板增强ETF         市值：1.33      累涨：34.51     9.60      12.39     12.52     10日：6.55      2.95      2.00      0.21      37        累涨修正：48.01     净值区间：88      93      95      97      98      29
        INDEX_300.put("159676", ContEtfTypeName.INDEX_300);//创业板增强ETF富国     市值：2.18      累涨：34.91     9.52      13.20     12.19     10日：6.26      2.78      1.88      0.00      35        累涨修正：47.71     净值区间：87      94      96      97      98      30
        INDEX_300.put("159572", ContEtfTypeName.INDEX_300);//创业板200ETF易方达    市值：8.18      累涨：38.21     12.53     16.32     9.36      10日：4.98      1.64      1.33      0.39      24        累涨修正：47.49     净值区间：90      95      96      98      99      31
        INDEX_300.put("159573", ContEtfTypeName.INDEX_300);//创业板200ETF华夏      市值：2.03      累涨：37.69     12.33     16.32     9.04      10日：4.90      1.96      1.41      0.54      25        累涨修正：47.37     净值区间：100     100     100     100     100     32
        INDEX_300.put("159563", ContEtfTypeName.INDEX_300);//创业板综ETF华夏       市值：0.43      累涨：34.40     10.91     12.96     10.53     10日：5.22      2.86      1.60      0.48      27        累涨修正：45.68     净值区间：97      99      99      100     100     33
        INDEX_300.put("159541", ContEtfTypeName.INDEX_300);//创业板综ETF万家       市值：2.12      累涨：34.70     10.85     13.57     10.28     10日：5.50      2.50      1.29      0.16      33        累涨修正：45.28     净值区间：100     100     100     100     100     34
        INDEX_300.put("159571", ContEtfTypeName.INDEX_300);//创业板200ETF富国      市值：0.50      累涨：37.13     11.96     16.56     8.61      10日：4.53      1.62      1.00      0.76      29        累涨修正：45.28     净值区间：100     100     100     100     100     35
        INDEX_300.put("159804", ContEtfTypeName.INDEX_300);//创中盘88ETF           市值：1.29      累涨：33.77     10.29     15.32     8.16      10日：5.61      2.33      1.77      0.63      39        累涨修正：45.25     净值区间：100     100     100     100     100     36
        INDEX_300.put("159575", ContEtfTypeName.INDEX_300);//创业板200ETF银华      市值：0.10      累涨：36.30     11.68     15.77     8.85      10日：4.70      1.65      1.26      0.47      32        累涨修正：45.17     净值区间：100     100     100     100     100     37
        INDEX_300.put("588350", ContEtfTypeName.INDEX_300);//双创50ETF基金         市值：15.76     累涨：30.77     7.40      10.18     13.19     10日：7.35      2.82      1.83      1.39      36        累涨修正：44.6      净值区间：100     100     100     100     100     38
        INDEX_300.put("588380", ContEtfTypeName.INDEX_300);//双创50ETF             市值：24.05     累涨：30.43     7.56      9.93      12.94     10日：7.44      2.63      1.80      1.13      42        累涨修正：44.1      净值区间：92      96      97      98      98      39
        INDEX_300.put("588320", ContEtfTypeName.INDEX_300);//双创50ETF增强         市值：0.21      累涨：30.38     7.19      10.05     13.14     10日：7.45      2.59      1.75      1.02      41        累涨修正：43.92     净值区间：94      97      98      99      99      40
        INDEX_300.put("159782", ContEtfTypeName.INDEX_300);//双创50ETF             市值：9.05      累涨：29.34     6.93      9.57      12.84     10日：7.59      2.86      1.84      0.99      38        累涨修正：43.47     净值区间：96      98      98      99      99      41
        INDEX_300.put("159966", ContEtfTypeName.INDEX_300);//创业板价值ETF         市值：4.96      累涨：27.67     8.26      9.72      9.69      10日：5.18      4.13      2.25      -0.20     40        累涨修正：41.48     净值区间：86      89      91      94      95      42
        INDEX_300.put("159716", ContEtfTypeName.INDEX_300);//深创100ETF            市值：0.87      累涨：28.47     8.67      9.32      10.48     10日：5.87      3.31      1.88      -0.35     43        累涨修正：41.41     净值区间：82      91      94      96      96      43
        INDEX_300.put("159918", ContEtfTypeName.INDEX_300);//中创400ETF            市值：0.73      累涨：29.35     8.37      12.57     8.41      10日：4.88      2.77      1.45      1.44      44        累涨修正：39.9      净值区间：100     100     100     100     100     44
        INDEX_300.put("159387", ContEtfTypeName.INDEX_300);//创业板新能源ETF国泰   市值：0.23      累涨：                              13.18     10日：5.92      4.63      3.44      -0.88     37        累涨修正：30.61     净值区间：73      82      89                      45
        INDEX_300.put("159205", ContEtfTypeName.INDEX_300);//创业板ETF东财         市值：4.03      累涨：                              13.73     10日：7.33      3.32      1.97      -0.18     31        累涨修正：28.32     净值区间：73      86      90                      46
        INDEX_300.put("159372", ContEtfTypeName.INDEX_300);//创业板50ETF万家       市值：0.29      累涨：                              14.65     10日：7.16      2.94      1.55      0.00      34        累涨修正：27.85     净值区间：81      92      94                      47
        INDEX_300.put("159261", ContEtfTypeName.INDEX_300);//创业板新能源ETF鹏华   市值：1.94      累涨：                                        10日：6.10      4.33      3.07      -0.66     40        累涨修正：16.57     净值区间：69      91                              48
        INDEX_300.put("159270", ContEtfTypeName.INDEX_300);//创业板200ETF南方      市值：7.39      累涨：                                        10日：                              0.50      45        累涨修正：0         净值区间：                                        49
        INDEX_300.put("159977", ContEtfTypeName.INDEX_300);//创业板ETF天弘         市值：86.51     累涨：                                        10日：                              -0.16     46        累涨修正：0         净值区间：90      95      97      98      98      50
    }

    public static Map<String, String> TOP_INDEX_688 = new HashMap<>();
    static {
        TOP_INDEX_688.put("588240", ContEtfTypeName.INDEX_688);//科创200ETF指数        市值：1.35      累涨：38.93     9.59      15.60     13.74     10日：8.26      2.86      1.60      1.14      2         累涨修正：53.25     净值区间：98      99      99      100     100     3
    }
    public static Map<String, String> INDEX_688 = new HashMap<>();
    static {
        INDEX_688.put("588910", ContEtfTypeName.INDEX_688);//科创价值ETF           市值：3.42      累涨：32.99     6.66      12.26     14.07     10日：9.21      6.02      3.11      -0.37     1         累涨修正：54.44     净值区间：91      95      95      97      97      1
        INDEX_688.put("588850", ContEtfTypeName.INDEX_688);//科创机械ETF           市值：0.19      累涨：33.27     8.23      10.97     14.07     10日：8.91      5.34      3.05      0.09      3         累涨修正：53.62     净值区间：37      56      63      69      69      2
        INDEX_688.put("588240", ContEtfTypeName.INDEX_688);//科创200ETF指数        市值：1.35      累涨：38.93     9.59      15.60     13.74     10日：8.26      2.86      1.60      1.14      2         累涨修正：53.25     净值区间：98      99      99      100     100     3
        INDEX_688.put("588230", ContEtfTypeName.INDEX_688);//科创200ETF            市值：2.80      累涨：38.23     10.01     15.55     12.67     10日：7.58      2.06      1.07      1.71      14        累涨修正：50.01     净值区间：95      97      98      99      99      4
        INDEX_688.put("588820", ContEtfTypeName.INDEX_688);//科创200ETF基金        市值：0.22      累涨：37.44     8.66      14.60     14.18     10日：7.58      2.56      0.92      1.53      6         累涨修正：49.42     净值区间：94      98      98      99      99      5
        INDEX_688.put("588030", ContEtfTypeName.INDEX_688);//科创100指数ETF        市值：64.76     累涨：33.22     6.54      15.17     11.51     10日：7.33      3.12      2.64      0.65      7         累涨修正：48.95     净值区间：96      98      98      99      99      6
        INDEX_688.put("588120", ContEtfTypeName.INDEX_688);//科创板100ETF          市值：9.87      累涨：32.64     6.31      14.55     11.78     10日：7.40      3.20      2.82      0.37      5         累涨修正：48.88     净值区间：93      96      97      98      98      7
        INDEX_688.put("588210", ContEtfTypeName.INDEX_688);//科创100ETF易方达      市值：3.91      累涨：33.41     7.20      14.66     11.55     10日：7.18      3.09      2.60      0.75      4         累涨修正：48.88     净值区间：98      99      99      99      99      8
        INDEX_688.put("588900", ContEtfTypeName.INDEX_688);//科创100ETF南方        市值：4.19      累涨：33.51     6.92      14.83     11.76     10日：7.00      2.81      2.53      0.92      21        累涨修正：48.38     净值区间：98      99      99      99      99      9
        INDEX_688.put("588880", ContEtfTypeName.INDEX_688);//科创100ETF华泰柏瑞    市值：2.09      累涨：32.86     6.64      14.75     11.47     10日：7.05      3.12      2.63      0.57      12        累涨修正：48.29     净值区间：93      96      97      98      98      10
        INDEX_688.put("588220", ContEtfTypeName.INDEX_688);//科创100ETF基金        市值：58.24     累涨：32.81     6.94      14.46     11.41     10日：7.13      3.02      2.54      0.65      16        累涨修正：48.04     净值区间：93      96      97      98      98      11
        INDEX_688.put("588190", ContEtfTypeName.INDEX_688);//科创100ETF            市值：30.89     累涨：32.58     6.66      14.53     11.39     10日：7.18      3.05      2.57      0.56      15        累涨修正：47.95     净值区间：93      96      97      98      98      12
        INDEX_688.put("588800", ContEtfTypeName.INDEX_688);//科创100ETF华夏        市值：28.69     累涨：32.35     6.83      14.37     11.15     10日：7.05      2.92      2.43      0.76      22        累涨修正：47.18     净值区间：91      95      96      97      97      13
        INDEX_688.put("159780", ContEtfTypeName.INDEX_688);//双创ETF               市值：42.09     累涨：31.95     7.70      10.31     13.94     10日：7.77      2.87      2.02      0.82      9         累涨修正：46.63     净值区间：88      94      96      97      97      14
        INDEX_688.put("159781", ContEtfTypeName.INDEX_688);//科创创业ETF           市值：87.42     累涨：31.80     7.57      10.38     13.85     10日：7.83      2.71      2.03      1.00      17        累涨修正：46.4      净值区间：92      96      97      98      98      15
        INDEX_688.put("588360", ContEtfTypeName.INDEX_688);//科创创业ETF           市值：4.53      累涨：31.92     7.30      10.94     13.68     10日：7.65      2.79      2.01      0.91      18        累涨修正：46.38     净值区间：92      96      97      98      98      16
        INDEX_688.put("159783", ContEtfTypeName.INDEX_688);//科创创业50ETF         市值：46.09     累涨：30.90     7.32      9.53      14.05     10日：7.91      3.19      2.17      0.82      3         累涨修正：46.34     净值区间：92      96      97      98      98      17
        INDEX_688.put("588680", ContEtfTypeName.INDEX_688);//科创100ETF增强指数基金市值：0.57      累涨：31.69     6.95      14.49     10.25     10日：7.00      2.89      2.37      0.76      26        累涨修正：46.32     净值区间：93      97      97      98      98      18
        INDEX_688.put("588500", ContEtfTypeName.INDEX_688);//科创100增强ETF易方达  市值：1.26      累涨：33.54     7.04      15.73     10.77     10日：6.43      2.17      1.97      1.20      32        累涨修正：46.08     净值区间：97      98      98      99      99      19
        INDEX_688.put("588010", ContEtfTypeName.INDEX_688);//科创新材料ETF         市值：2.56      累涨：30.83     8.31      12.10     10.42     10日：5.80      3.73      2.79      0.91      33        累涨修正：45.94     净值区间：96      98      98      99      99      20
        INDEX_688.put("159603", ContEtfTypeName.INDEX_688);//双创龙头ETF           市值：22.91     累涨：31.27     7.32      10.10     13.85     10日：7.72      2.95      1.96      0.96      11        累涨修正：45.86     净值区间：92      96      56      63      65      21
        INDEX_688.put("588330", ContEtfTypeName.INDEX_688);//双创龙头ETF           市值：11.25     累涨：31.47     7.41      9.97      14.09     10日：7.65      2.99      1.82      0.65      8         累涨修正：45.75     净值区间：84      92      94      96      96      22
        INDEX_688.put("588660", ContEtfTypeName.INDEX_688);//科创创业50ETF基金     市值：2.14      累涨：31.47     7.45      10.53     13.49     10日：7.35      2.75      1.86      1.06      23        累涨修正：45.29     净值区间：90      95      96      97      98      23
        INDEX_688.put("588390", ContEtfTypeName.INDEX_688);//科创创业50ETF         市值：2.66      累涨：31.40     7.44      10.50     13.46     10日：7.63      2.79      1.70      1.22      20        累涨修正：45.22     净值区间：93      96      97      98      98      24
        INDEX_688.put("588400", ContEtfTypeName.INDEX_688);//科创创业ETF嘉实       市值：18.00     累涨：30.76     7.27      10.04     13.45     10日：7.51      2.83      1.83      0.98      24        累涨修正：44.76     净值区间：88      94      96      97      97      25
        INDEX_688.put("589630", ContEtfTypeName.INDEX_688);//科创综指ETF国泰       市值：8.65      累涨：28.72     5.69      11.46     11.57     10日：8.15      3.40      2.22      1.61      10        累涨修正：44.71     净值区间：89      94      95      96      96      26
        INDEX_688.put("588310", ContEtfTypeName.INDEX_688);//双创ETF基金           市值：0.64      累涨：29.81     6.98      9.90      12.93     10日：7.66      3.21      1.98      0.90      13        累涨修正：44.64     净值区间：78      88      91      93      94      27
        INDEX_688.put("588350", ContEtfTypeName.INDEX_688);//双创50ETF基金         市值：15.76     累涨：30.77     7.40      10.18     13.19     10日：7.35      2.82      1.83      1.39      36        累涨修正：44.6      净值区间：100     100     100     100     100     28
        INDEX_688.put("588380", ContEtfTypeName.INDEX_688);//双创50ETF             市值：24.05     累涨：30.43     7.56      9.93      12.94     10日：7.44      2.63      1.80      1.13      42        累涨修正：44.1      净值区间：92      96      97      98      98      29
        INDEX_688.put("588300", ContEtfTypeName.INDEX_688);//双创ETF               市值：17.21     累涨：29.98     7.12      9.66      13.20     10日：7.56      2.62      1.96      0.80      29        累涨修正：44.08     净值区间：85      92      94      96      96      30
        INDEX_688.put("588320", ContEtfTypeName.INDEX_688);//双创50ETF增强         市值：0.21      累涨：30.38     7.19      10.05     13.14     10日：7.45      2.59      1.75      1.02      41        累涨修正：43.92     净值区间：94      97      98      99      99      31
        INDEX_688.put("159782", ContEtfTypeName.INDEX_688);//双创50ETF             市值：9.05      累涨：29.34     6.93      9.57      12.84     10日：7.59      2.86      1.84      0.99      38        累涨修正：43.47     净值区间：96      98      98      99      99      32
        INDEX_688.put("588160", ContEtfTypeName.INDEX_688);//科创材料ETF           市值：2.48      累涨：29.42     7.66      12.12     9.64      10日：5.72      3.06      2.44      0.90      38        累涨修正：43.08     净值区间：93      95      95      98      98      33
        INDEX_688.put("589990", ContEtfTypeName.INDEX_688);//科创综指ETF华泰柏瑞   市值：3.76      累涨：28.19     6.27      11.89     10.03     10日：6.84      3.21      2.33      1.63      27        累涨修正：42.9      净值区间：98      99      99      99      99      34
        INDEX_688.put("589980", ContEtfTypeName.INDEX_688);//科创100ETF汇添富      市值：2.78      累涨：                    14.23     11.66     10日：7.69      3.49      2.84      0.36      19        累涨修正：42.75     净值区间：100     100     100     100             35
        INDEX_688.put("589770", ContEtfTypeName.INDEX_688);//科创综指ETF招商       市值：5.78      累涨：28.09     5.96      11.41     10.72     10日：6.79      3.04      2.25      1.25      28        累涨修正：42.42     净值区间：93      96      97      98      98      36
        INDEX_688.put("589800", ContEtfTypeName.INDEX_688);//科创综指ETF易方达     市值：20.96     累涨：28.50     5.92      12.04     10.54     10日：6.67      2.88      2.08      1.46      33        累涨修正：42.21     净值区间：95      97      98      98      99      37
        INDEX_688.put("589500", ContEtfTypeName.INDEX_688);//科创综指ETF工银       市值：3.93      累涨：27.81     5.58      11.24     10.99     10日：6.83      2.95      2.25      1.35      31        累涨修正：42.09     净值区间：93      96      97      98      98      38
        INDEX_688.put("589060", ContEtfTypeName.INDEX_688);//科创综指ETF东财       市值：1.23      累涨：27.11     5.43      11.17     10.51     10日：6.93      3.21      2.35      1.20      30        累涨修正：41.95     净值区间：91      99      99      99      99      39
        INDEX_688.put("589660", ContEtfTypeName.INDEX_688);//科创综指ETF南方       市值：6.08      累涨：27.71     5.87      11.63     10.21     10日：6.68      3.04      2.15      1.25      34        累涨修正：41.73     净值区间：91      95      96      97      97      40
        INDEX_688.put("589000", ContEtfTypeName.INDEX_688);//科创综指ETF华夏       市值：15.77     累涨：27.89     5.85      11.35     10.69     10日：6.63      2.86      2.06      1.35      36        累涨修正：41.5      净值区间：93      96      97      98      98      41
        INDEX_688.put("589880", ContEtfTypeName.INDEX_688);//科创综指ETF建信       市值：8.63      累涨：27.37     5.64      11.20     10.53     10日：6.60      3.05      2.06      1.35      35        累涨修正：41.14     净值区间：98      99      99      99      99      42
        INDEX_688.put("589860", ContEtfTypeName.INDEX_688);//科创综指ETF天弘       市值：6.58      累涨：27.77     5.63      11.66     10.48     10日：6.50      2.89      1.99      1.27      39        累涨修正：41.14     净值区间：90      95      96      97      97      43
        INDEX_688.put("589680", ContEtfTypeName.INDEX_688);//科创综指ETF鹏华       市值：18.93     累涨：27.78     5.69      11.79     10.30     10日：6.45      2.77      1.97      1.45      47        累涨修正：40.94     净值区间：93      96      97      98      98      44
        INDEX_688.put("589900", ContEtfTypeName.INDEX_688);//科创综指ETF博时       市值：9.47      累涨：26.96     5.15      11.13     10.68     10日：6.73      2.86      2.16      1.35      43        累涨修正：40.87     净值区间：93      96      97      98      98      45
        INDEX_688.put("588450", ContEtfTypeName.INDEX_688);//科创50ETF增强         市值：1.22      累涨：24.54     4.17      10.09     10.28     10日：6.62      3.22      3.22      1.27      45        累涨修正：40.82     净值区间：94      95      96      97      97      46
        INDEX_688.put("589600", ContEtfTypeName.INDEX_688);//科创综指ETF富国       市值：11.42     累涨：27.44     5.45      11.23     10.76     10日：6.53      2.91      1.90      1.28      38        累涨修正：40.68     净值区间：91      95      96      97      97      47
        INDEX_688.put("589080", ContEtfTypeName.INDEX_688);//科创综指ETF汇添富     市值：5.16      累涨：27.00     5.55      11.01     10.44     10日：6.61      2.95      2.05      1.06      42        累涨修正：40.66     净值区间：86      92      93      96      96      48
        INDEX_688.put("589300", ContEtfTypeName.INDEX_688);//科创综指ETF嘉实       市值：1.20      累涨：27.08     5.72      11.14     10.22     10日：7.26      2.55      1.63      20.04     46        累涨修正：40.15     净值区间：100     100     100     100     100     49
        INDEX_688.put("589890", ContEtfTypeName.INDEX_688);//科创综指ETF景顺       市值：6.79      累涨：26.88     6.21      10.37     10.30     10日：6.35      2.87      1.97      1.46      44        累涨修正：40.04     净值区间：91      95      96      97      97      50
        INDEX_688.put("588070", ContEtfTypeName.INDEX_688);//科创板成长ETF         市值：0.27      累涨：29.90     5.83      13.18     10.89     10日：6.69      0.73      0.64      2.37      41        累涨修正：38.6      净值区间：86      91      93      94      95      51
        INDEX_688.put("588110", ContEtfTypeName.INDEX_688);//科创成长ETF           市值：2.13      累涨：29.73     5.74      13.33     10.66     10日：6.54      0.64      0.64      2.48      49        累涨修正：38.19     净值区间：81      89      91      92      93      52
        INDEX_688.put("588670", ContEtfTypeName.INDEX_688);//科创综指增强ETF       市值：0.85      累涨：                              14.13     10日：11.05     5.95      3.44      1.85      25        累涨修正：38.01     净值区间：72      81      83                      53
        INDEX_688.put("588100", ContEtfTypeName.INDEX_688);//科创信息技术ETF       市值：2.56      累涨：25.20     5.59      10.49     9.12      10日：5.37      2.46      2.46      2.79      65        累涨修正：37.95     净值区间：94      95      96      96      96      54
        INDEX_688.put("588370", ContEtfTypeName.INDEX_688);//科创50增强ETF南方     市值：1.01      累涨：24.11     4.89      9.23      9.99      10日：6.37      3.00      2.15      2.02      50        累涨修正：37.78     净值区间：93      95      96      97      97      55
        INDEX_688.put("159335", ContEtfTypeName.INDEX_688);//央企科创ETF           市值：2.80      累涨：22.25     7.48      6.46      8.31      10日：6.05      4.64      2.33      -0.64     40        累涨修正：37.6      净值区间：32      50      53      64      70      56
        INDEX_688.put("588770", ContEtfTypeName.INDEX_688);//科创信息技术ETF摩根   市值：2.99      累涨：24.28     5.09      10.44     8.75      10日：5.46      2.59      2.59      2.54      64        累涨修正：37.51     净值区间：90      92      93      94      94      57
        INDEX_688.put("588260", ContEtfTypeName.INDEX_688);//科创信息ETF           市值：1.28      累涨：24.21     5.22      10.33     8.66      10日：5.12      2.34      2.26      3.11      67        累涨修正：36.19     净值区间：97      48      48      53      57      58
        INDEX_688.put("588020", ContEtfTypeName.INDEX_688);//科创成长50ETF         市值：3.28      累涨：29.07     6.19      12.93     9.95      10日：6.00      0.40      0.32      2.52      51        累涨修正：36.11     净值区间：85      91      93      94      95      59
        INDEX_688.put("588180", ContEtfTypeName.INDEX_688);//科创50ETF基金         市值：35.30     累涨：22.03     4.45      8.73      8.85      10日：5.56      2.74      2.44      1.95      54        累涨修正：35.21     净值区间：89      92      93      94      94      60
        INDEX_688.put("588090", ContEtfTypeName.INDEX_688);//科创板ETF             市值：54.10     累涨：21.66     4.53      8.56      8.57      10日：5.51      2.86      2.57      2.07      52        累涨修正：35.17     净值区间：91      93      94      95      95      61
        INDEX_688.put("588060", ContEtfTypeName.INDEX_688);//科创50ETF龙头         市值：66.27     累涨：22.07     4.53      9.02      8.52      10日：5.33      2.63      2.47      2.12      56        累涨修正：34.97     净值区间：91      94      94      96      96      62
        INDEX_688.put("588080", ContEtfTypeName.INDEX_688);//科创板50ETF           市值：678.43    累涨：21.67     4.87      8.59      8.21      10日：5.24      2.78      2.49      2.08      58        累涨修正：34.67     净值区间：91      93      94      96      96      63
        INDEX_688.put("588950", ContEtfTypeName.INDEX_688);//科创50ETF景顺         市值：1.89      累涨：21.28     4.25      8.55      8.48      10日：5.62      2.68      2.49      2.16      63        累涨修正：34.56     净值区间：93      39      39      44      44      64
        INDEX_688.put("588000", ContEtfTypeName.INDEX_688);//科创50ETF             市值：915.54    累涨：21.94     4.84      8.98      8.12      10日：5.12      2.71      2.34      2.12      60        累涨修正：34.45     净值区间：90      92      93      95      95      65
        INDEX_688.put("588460", ContEtfTypeName.INDEX_688);//科创50增强ETF         市值：7.13      累涨：23.44     4.42      10.57     8.45      10日：5.31      2.11      1.77      2.33      57        累涨修正：34.4      净值区间：90      93      94      95      96      66
        INDEX_688.put("588050", ContEtfTypeName.INDEX_688);//科创ETF               市值：123.07    累涨：21.85     4.75      8.91      8.19      10日：5.13      2.67      2.29      2.17      64        累涨修正：34.23     净值区间：91      93      94      95      95      67
        INDEX_688.put("588840", ContEtfTypeName.INDEX_688);//科创板50ETF基金       市值：1.88      累涨：21.92     4.45      8.72      8.75      10日：5.22      2.58      2.14      2.63      62        累涨修正：34        净值区间：82      86      87      90      90      68
        INDEX_688.put("588150", ContEtfTypeName.INDEX_688);//科创50ETF南方         市值：2.79      累涨：20.60     4.11      8.62      7.87      10日：5.12      2.96      2.39      2.07      55        累涨修正：33.46     净值区间：87      90      92      94      94      69
        INDEX_688.put("588870", ContEtfTypeName.INDEX_688);//科创50指数ETF         市值：3.24      累涨：21.10     4.07      8.92      8.11      10日：4.94      2.68      2.30      2.08      66        累涨修正：33.32     净值区间：90      92      93      95      86      70
        INDEX_688.put("588720", ContEtfTypeName.INDEX_688);//科创50ETF中银         市值：3.52      累涨：21.21     3.74      9.23      8.24      10日：5.03      2.53      2.04      2.59      65        累涨修正：32.85     净值区间：94      96      96      97      80      71
        INDEX_688.put("588280", ContEtfTypeName.INDEX_688);//科创50ETF指数基金     市值：4.45      累涨：20.29     4.41      8.52      7.36      10日：4.69      2.45      2.17      2.28      67        累涨修正：31.77     净值区间：90      92      93      95      95      72
        INDEX_688.put("588040", ContEtfTypeName.INDEX_688);//科创50ETF指数         市值：0.44      累涨：19.12     4.31      7.38      7.43      10日：4.79      2.37      2.18      2.52      68        累涨修正：30.64     净值区间：51      59      61      66      43      73
        INDEX_688.put("589580", ContEtfTypeName.INDEX_688);//科创综指ETF兴银       市值：0.20      累涨：                              11.43     10日：7.28      3.49      2.44      0.65      37        累涨修正：27.08     净值区间：81      84      86                      74
        INDEX_688.put("588270", ContEtfTypeName.INDEX_688);//科创200ETF易方达      市值：0.29      累涨：                              13.62     10日：7.74      2.60      0.89      1.67      48        累涨修正：25.74     净值区间：100     100     100                     75
        INDEX_688.put("589180", ContEtfTypeName.INDEX_688);//科创新材料ETF汇添富   市值：0.22      累涨：                              9.88      10日：5.75      3.36      2.61      1.19      56        累涨修正：24.21     净值区间：100     100     100                     76
        INDEX_688.put("588940", ContEtfTypeName.INDEX_688);//科创50ETF富国         市值：2.21      累涨：                              8.66      10日：5.77      2.79      2.40      2.18      61        累涨修正：22.02     净值区间：91      93      94                      77
        INDEX_688.put("589700", ContEtfTypeName.INDEX_688);//科创成长ETF南方       市值：0.27      累涨：                              10.51     10日：6.77      0.94      0.66      2.53      53        累涨修正：19.54     净值区间：91      94      95                      78
        INDEX_688.put("588520", ContEtfTypeName.INDEX_688);//科创增强ETF           市值：0.62      累涨：                                        10日：6.33      2.88      2.01      1.69      59        累涨修正：13.23     净值区间：100     100                             79
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

    public static Map<String, String> TOP_JINRONG_FANGDICHAN = new HashMap<>();
    static {
        TOP_JINRONG_FANGDICHAN.put("159745", ContEtfTypeName.JINRONG_FANGDICHAN);//建材ETF               市值：17.69     累涨：26.14     4.38      6.79      14.97     10日：8.21      7.37      4.37      -2.41     2         累涨修正：50.46     净值区间：41      54      62      66      66      1
    }
    public static Map<String, String> JINRONG_FANGDICHAN = new HashMap<>();
    static {
        JINRONG_FANGDICHAN.put("159745", ContEtfTypeName.JINRONG_FANGDICHAN);//建材ETF               市值：17.69     累涨：26.14     4.38      6.79      14.97     10日：8.21      7.37      4.37      -2.41     2         累涨修正：50.46     净值区间：41      54      62      66      66      1
        JINRONG_FANGDICHAN.put("516970", ContEtfTypeName.JINRONG_FANGDICHAN);//基建50ETF             市值：33.42     累涨：23.84     5.44      6.25      12.15     10日：8.81      8.08      4.26      -2.33     1         累涨修正：49.25     净值区间：32      54      60      66      66      2
        JINRONG_FANGDICHAN.put("159787", ContEtfTypeName.JINRONG_FANGDICHAN);//建材ETF易方达         市值：3.37      累涨：25.31     3.70      6.54      15.07     10日：8.38      6.98      3.98      -2.63     3         累涨修正：48.63     净值区间：32      45      55      59      59      3
        JINRONG_FANGDICHAN.put("159619", ContEtfTypeName.JINRONG_FANGDICHAN);//基建ETF               市值：4.30      累涨：23.20     5.04      5.50      12.66     10日：8.56      7.95      4.23      -2.89     5         累涨修正：48.17     净值区间：26      46      53      59      59      4
        JINRONG_FANGDICHAN.put("512200", ContEtfTypeName.JINRONG_FANGDICHAN);//房地产ETF             市值：66.86     累涨：27.33     5.88      8.42      13.03     10日：5.98      5.21      3.65      0.48      4         累涨修正：45.82     净值区间：88      91      94      96      96      5
        JINRONG_FANGDICHAN.put("516950", ContEtfTypeName.JINRONG_FANGDICHAN);//基建ETF               市值：11.14     累涨：22.98     5.05      5.85      12.08     10日：7.98      7.14      3.77      -3.06     7         累涨修正：45.64     净值区间：21      44      51      58      58      6
        JINRONG_FANGDICHAN.put("159635", ContEtfTypeName.JINRONG_FANGDICHAN);//基建50ETF             市值：5.71      累涨：22.31     4.56      6.21      11.54     10日：7.97      7.19      3.80      -2.30     8         累涨修正：45.07     净值区间：31      49      56      62      62      7
        JINRONG_FANGDICHAN.put("516750", ContEtfTypeName.JINRONG_FANGDICHAN);//建材ETF               市值：11.59     累涨：24.25     3.53      6.84      13.88     10日：6.74      6.28      3.28      -2.09     6         累涨修正：43.83     净值区间：34      48      57      62      62      8
        JINRONG_FANGDICHAN.put("159768", ContEtfTypeName.JINRONG_FANGDICHAN);//房地产ETF             市值：6.83      累涨：23.47     3.17      6.98      13.32     10日：6.52      5.42      3.96      1.75      9         累涨修正：43.33     净值区间：90      92      94      95      95      9
        JINRONG_FANGDICHAN.put("159707", ContEtfTypeName.JINRONG_FANGDICHAN);//地产ETF               市值：6.70      累涨：23.24     3.36      6.61      13.27     10日：6.68      5.53      3.88      1.72      11        累涨修正：43.21     净值区间：87      89      92      94      94      10
        JINRONG_FANGDICHAN.put("515060", ContEtfTypeName.JINRONG_FANGDICHAN);//房地产ETF基金         市值：6.76      累涨：25.27     5.58      8.22      11.47     10日：4.43      4.13      2.79      0.87      10        累涨修正：39.41     净值区间：91      93      95      96      96      11
        JINRONG_FANGDICHAN.put("159933", ContEtfTypeName.JINRONG_FANGDICHAN);//国投金融地产ETF       市值：1.52      累涨：27.25     8.25      11.43     7.57      10日：3.03      1.65      1.36      0.35      12        累涨修正：34.65     净值区间：95      59      80      86      90      12
        JINRONG_FANGDICHAN.put("510650", ContEtfTypeName.JINRONG_FANGDICHAN);//金融地产ETF           市值：0.33      累涨：26.10     8.69      11.07     6.34      10日：2.32      2.22      1.47      -1.20     13        累涨修正：33.58     净值区间：32      25      43      71      78      13
        JINRONG_FANGDICHAN.put("159940", ContEtfTypeName.JINRONG_FANGDICHAN);//金融地产ETF           市值：8.12      累涨：26.08     7.46      11.96     6.66      10日：1.86      1.86      1.08      -0.23     14        累涨修正：31.96     净值区间：64      61      66      82      87      14
        JINRONG_FANGDICHAN.put("561320", ContEtfTypeName.JINRONG_FANGDICHAN);//交运ETF               市值：0.59      累涨：18.17     8.56      4.25      5.36      10日：4.12      4.02      2.56      -0.40     17        累涨修正：31.43     净值区间：80      83      83      83      90      15
        JINRONG_FANGDICHAN.put("159666", ContEtfTypeName.JINRONG_FANGDICHAN);//交通运输ETF           市值：0.63      累涨：18.37     9.11      3.34      5.92      10日：4.41      4.11      2.08      -0.49     15        累涨修正：31.05     净值区间：38      48      51      54      67      16
        JINRONG_FANGDICHAN.put("512640", ContEtfTypeName.JINRONG_FANGDICHAN);//金融地产ETF嘉实       市值：0.76      累涨：24.66     7.41      11.17     6.08      10日：1.91      1.91      1.11      -0.08     16        累涨修正：30.7      净值区间：62      57      63      81      84      17
        JINRONG_FANGDICHAN.put("159662", ContEtfTypeName.JINRONG_FANGDICHAN);//交运ETF               市值：0.63      累涨：16.16     7.62      2.96      5.58      10日：4.39      4.19      2.32      -0.19     18        累涨修正：29.38     净值区间：77      82      83      84      90      18
        JINRONG_FANGDICHAN.put("159301", ContEtfTypeName.JINRONG_FANGDICHAN);//公用事业ETF           市值：0.49      累涨：15.48     5.22      3.60      6.66      10日：3.41      2.66      1.16      -0.95     19        累涨修正：23.87     净值区间：19      36      52      55      60      19
        JINRONG_FANGDICHAN.put("560190", ContEtfTypeName.JINRONG_FANGDICHAN);//公用事业ETF           市值：0.28      累涨：16.09     6.24      3.98      5.87      10日：2.82      2.32      0.70      -0.50     20        累涨修正：22.63     净值区间：24      38      53      58      61      20
        JINRONG_FANGDICHAN.put("560620", ContEtfTypeName.JINRONG_FANGDICHAN);//公用事业ETF基金       市值：1.19      累涨：14.99     5.39      3.30      6.30      10日：3.02      2.37      0.85      -0.85     21        累涨修正：22.08     净值区间：26      38      50      60      62      21
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
            String zqdm = vo.getF12();

//        if (zqdm.equals("516100")) {
//            System.out.println("特定代码：" + zqdm);
//        }

            sb.append("        ");
            sb.append(typeEn + ".put(\"").append(StockUtil.formatStName(zqdm, SIZE_6)).append("\"");
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
        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//        String date = "2025-07-25";

        //////        //etf头部数据
//        List<String> zqdmList = new ArrayList<>(ContMapEtfAll.TOP_XIAOFEI.keySet());
//        int count = 0;
//        for (String zqdm : zqdmList) {
//            System.out.println(++count + ":" + zqdm + ":" + ETF_All.get(zqdm));
//        }

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
        findByTypeName(date, ContEtfNameKey.ZIYUAN_COMMON, ContEtfNameKey.ZIYUAN_COMMON_NOLIKE, "ZIYUAN_COMMON", ContEtfTypeName.ZIYUAN_COMMON, ContMapEtfAll.ZIYUAN_COMMON);//资源-通用

//        findByTypeName(date, ContEtfNameKey.YILIAO_COMMON, null, "YILIAO_COMMON", ContEtfTypeName.YILIAO_COMMON, ContMapEtfAll.YILIAO_COMMON);

//        findByTypeName(date, ContEtfNameKey.JINRONG_GOLD, ContEtfNameKey.JINRONG_GOLD_NOLIKE, "JINRONG_GOLD", ContEtfTypeName.JINRONG_GOLD, ContMapEtfAll.JINRONG_GOLD);//金融-黄金
//        findByTypeName(date, ContEtfNameKey.JINRONG_BANK, null, "JINRONG_BANK", ContEtfTypeName.JINRONG_BANK, ContMapEtfAll.JINRONG_BANK);//金融-银行
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
