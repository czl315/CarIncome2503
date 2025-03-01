package utils;

import com.alibaba.fastjson.JSON;
import ttjj.dto.Kline;
import ttjj.service.KlineService;

import java.util.*;
import java.util.stream.Collectors;

import static utils.Content.KLINE_TYPE_STOCK;
import static utils.Content.KLT_101;
import static utils.DateUtil.YYYY_MM_DD;

/**
 * 交易日-缓存常量
 *
 * @author Administrator
 * @date 2022-09-13 11:05
 */
public class ContTradeDay {
    /**
     * mapEtfKeJi etf-科技
     */
    public static Map<Integer, String> mapTradeDay = new HashMap<>();

    static {
        mapTradeDay.put(0,"2025-01-16");
        mapTradeDay.put(1,"2025-01-15");
        mapTradeDay.put(2,"2025-01-14");
        mapTradeDay.put(3,"2025-01-13");
        mapTradeDay.put(4,"2025-01-10");
        mapTradeDay.put(5,"2025-01-09");
        mapTradeDay.put(6,"2025-01-08");
        mapTradeDay.put(7,"2025-01-07");
        mapTradeDay.put(8,"2025-01-06");
        mapTradeDay.put(9,"2025-01-03");
        mapTradeDay.put(10,"2025-01-02");
        mapTradeDay.put(11,"2024-12-31");
        mapTradeDay.put(12,"2024-12-30");
        mapTradeDay.put(13,"2024-12-27");
        mapTradeDay.put(14,"2024-12-26");
        mapTradeDay.put(15,"2024-12-25");
        mapTradeDay.put(16,"2024-12-24");
        mapTradeDay.put(17,"2024-12-23");
        mapTradeDay.put(18,"2024-12-20");
        mapTradeDay.put(19,"2024-12-19");
        mapTradeDay.put(20,"2024-12-18");
        mapTradeDay.put(21,"2024-12-17");
        mapTradeDay.put(22,"2024-12-16");
        mapTradeDay.put(23,"2024-12-13");
        mapTradeDay.put(24,"2024-12-12");
        mapTradeDay.put(25,"2024-12-11");
        mapTradeDay.put(26,"2024-12-10");
        mapTradeDay.put(27,"2024-12-09");
        mapTradeDay.put(28,"2024-12-06");
        mapTradeDay.put(29,"2024-12-05");
        mapTradeDay.put(30,"2024-12-04");
        mapTradeDay.put(31,"2024-12-03");
        mapTradeDay.put(32,"2024-12-02");
        mapTradeDay.put(33,"2024-11-29");
        mapTradeDay.put(34,"2024-11-28");
        mapTradeDay.put(35,"2024-11-27");
        mapTradeDay.put(36,"2024-11-26");
        mapTradeDay.put(37,"2024-11-25");
        mapTradeDay.put(38,"2024-11-22");
        mapTradeDay.put(39,"2024-11-21");
        mapTradeDay.put(40,"2024-11-20");
        mapTradeDay.put(41,"2024-11-19");
        mapTradeDay.put(42,"2024-11-18");
        mapTradeDay.put(43,"2024-11-15");
        mapTradeDay.put(44,"2024-11-14");
        mapTradeDay.put(45,"2024-11-13");
        mapTradeDay.put(46,"2024-11-12");
        mapTradeDay.put(47,"2024-11-11");
        mapTradeDay.put(48,"2024-11-08");
        mapTradeDay.put(49,"2024-11-07");
        mapTradeDay.put(50,"2024-11-06");
        mapTradeDay.put(51,"2024-11-05");
        mapTradeDay.put(52,"2024-11-04");
        mapTradeDay.put(53,"2024-11-01");
        mapTradeDay.put(54,"2024-10-31");
        mapTradeDay.put(55,"2024-10-30");
        mapTradeDay.put(56,"2024-10-29");
        mapTradeDay.put(57,"2024-10-28");
        mapTradeDay.put(58,"2024-10-25");
        mapTradeDay.put(59,"2024-10-24");
        mapTradeDay.put(60,"2024-10-23");
        mapTradeDay.put(61,"2024-10-22");
        mapTradeDay.put(62,"2024-10-21");
        mapTradeDay.put(63,"2024-10-18");
        mapTradeDay.put(64,"2024-10-17");
        mapTradeDay.put(65,"2024-10-16");
        mapTradeDay.put(66,"2024-10-15");
        mapTradeDay.put(67,"2024-10-14");
        mapTradeDay.put(68,"2024-10-11");
        mapTradeDay.put(69,"2024-10-10");
        mapTradeDay.put(70,"2024-10-09");
    }


    public static void main(String[] args) {
        List<String> dateList = new ArrayList<>();

//        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
////        String date = "2022-09-09";
//        dateList = StockService.findListDateBefore(date, -60);//查询n个交易日之前的日期
//        int temp = 0;
//        for (String dateStr : dateList) {
//            System.out.println("mapTradeDay.put(" + (temp++) + ",\"" + dateStr + "\");");
//        }

        //查询K线-查询交易日列表，http查询贵州茅台的日k线
        String begDate = DateUtil.getCurDateStrAddDaysByFormat(YYYY_MM_DD, -100);
        String endDate = DateUtil.getToday(YYYY_MM_DD);
        String stCode = "600519";//贵州茅台 600519
        List<Kline> klines = KlineService.kline(stCode, 0, KLT_101, true, begDate, endDate, KLINE_TYPE_STOCK);
        klines = klines.stream().filter(e -> e != null).sorted(Comparator.comparing(Kline::getKtime, Comparator.nullsFirst(String::compareTo)).reversed()).collect(Collectors.toList());

        System.out.println("k线：" + JSON.toJSONString(klines));
        if (klines != null && klines.size() > 0) {
            for (Kline kline : klines) {
//                System.out.println(kline.getKtime());
                dateList.add(kline.getKtime());
            }
        }
        int temp = 0;
        for (String dateStr : dateList) {
            System.out.println("mapTradeDay.put(" + (temp) + ",\"" + dateStr + "\");");
            mapTradeDay.put(temp, dateStr);
            temp++;
        }

//        temp = 0;
//        for (String dateStr : dateList) {
//            System.out.println("mapTradeDay(" + (temp++) + ",\"" + mapTradeDay.get(temp) + "\");");
//        }

    }
}
