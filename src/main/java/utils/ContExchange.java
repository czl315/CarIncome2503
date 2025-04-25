package utils;

/**
 * 常量-上交所、深交所
 */
public class ContExchange {
    /**
     *上交所证券代码开头
     */
    public static String SHANGHAI_EXCH_START = "5";
    public static String SHENZHEN_EXCH_START = "1";//深交所证券代码开头
    public static String CYCLE_TYPE_MINU15 = "18";//k线类型：18=15分钟；19=30分钟；20=60分钟；21=240分钟(日线？)；32=日线；33=周线；34=月线
    public static String CYCLE_TYPE_MINU30 = "19";//k线类型：18=15分钟；19=30分钟；20=60分钟；21=240分钟(日线？)；32=日线；33=周线；34=月线
    public static String CYCLE_TYPE_MINU60 = "20";//k线类型：18=15分钟；19=30分钟；20=60分钟；21=240分钟(日线？)；32=日线；33=周线；34=月线
    public static String CYCLE_TYPE_DAY = "32";//k线类型：32=日线；33=周线
    public static String CYCLE_TYPE_WEEK = "33";//k线类型：18=15分钟；19=30分钟；20=60分钟；21=240分钟(日线？)；32=日线；33=周线；34=月线
    public static String CYCLE_TYPE_MONTH = "34";//k线类型：18=15分钟；19=30分钟；20=60分钟；21=240分钟(日线？)；32=日线；33=周线；34=月线

    public static String KLINE_TYPE_WEEK_SOHU = "w";//k线类型：w=周线

}
