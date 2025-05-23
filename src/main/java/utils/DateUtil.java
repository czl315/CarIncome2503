package utils;

import ttjj.service.StockService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static utils.Content.*;

/**
 * @author
 * @date 2021/7/1
 */
public class DateUtil {
    public static String YYYY_MM_DD = "yyyy-MM-dd";
    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static String HH_MM_SS = "HH:mm:ss";
    public static String YYYYMMDD = "yyyyMMdd";

    public static void main(String[] args) {

//        //获取年月日
//        System.out.println(getCurYear());
//        System.out.println(getCurMonth());
//        System.out.println(getCurDay());
//        System.out.println(getCurYearMonth());
//        System.out.println(getCurYearWeek());
//        System.out.println(getWeek(new Date()));
//        System.out.println(getWeekByYyyyMmDd("2021-08-29",DateUtil.YYYY_MM_DD));
//        System.out.println(getYearWeek("2021-08-29", DateUtil.YYYY_MM_DD));
        System.out.println(getAddDays(YYYY_MM_DD, "2022-05-01", -1));

        //检查是否是今天
//        isTodayBySpDate("20250501", YYYYMMDD);

//        //获取格式化日期
//        String date = getDateStrAddDaysByFormat(YYYY_MM_DD, 2021, 2, 28, -1);
//        System.out.println(date);

//        //  取得一年的第几周    27
//        int weekOfYear = getWeekOfYear(new Date());
//        System.out.println(weekOfYear);
//
//        //时间戳   1625069737271
//        long timeInMillis = getTimeInMillis(new Date());
//        System.out.println(timeInMillis);

        //  根据日期取得星期几
//        String dateStr ="2021-07-23";
//        String week = getWeekByYyyyMmDd(dateStr);
//        System.out.println(week);

//        //  获取当前日期增加或减少天数的日期格式
//        String dayStr = getCurDateStrAddDaysByFormat(YYYY_MM_DD, -10);
//        System.out.println(dayStr);


    }

    /**
     * @return
     */
    public static String getToday(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     * 获取年
     *
     * @return
     */
    public static int getCurYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * @return
     */
    public static int getCurMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    /**
     * @return
     */
    public static String getCurYearMonth() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        String yearMonth = year + "" + month;
        if (month < 10) {
            yearMonth = year + "0" + month;
        }
        return yearMonth;
    }

    /**
     * 返回时间戳
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static long getTimeInMillisByDateStr(String format, String dateStr) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getTimeInMillis();
    }

    /**
     * @return
     */
    public static String getYearWeek(String dateStr, String format) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        String yearMonth = year + "" + week;
        if (week < 10) {
            yearMonth = year + "0" + week;
        }
        return yearMonth;
    }

    /**
     * @param dateStr
     * @param format
     * @return
     */
    public static String getYearMonth(String dateStr, String format) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        String yearMonth = year + "" + month;
        if (month < 10) {
            yearMonth = year + "0" + month;
        }
        return yearMonth;
    }

    /**
     * @return
     */
    public static int getCurDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @return
     */
    public static String getCurDateTime() {
        return DateUtil.getCurDateStrAddDaysByFormat(DateUtil.getCurDateStrAddDaysByFormat(DateUtil.YYYY_MM_DD_HH_MM_SS, 0), 0);
    }

    /**
     * @param format
     * @return
     */
    public static String getCurDateTime(String format) {
        return DateUtil.getCurDateStrAddDaysByFormat(format, 0);
    }

    /**
     * 获取当前日期增加或减少天数的日期格式
     *
     * @param format
     * @param days
     * @return
     */
    public static String getCurDateStrAddDaysByFormat(String format, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return new SimpleDateFormat(format).format(calendar.getTime());
    }

    /**
     * 获取格式化日期
     *
     * @param format
     * @param year
     * @param month
     * @param day
     * @param days
     * @return
     */
    public static String getDateStrAddDaysByFormat(String format, int year, int month, int day, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, (month - 1));
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return new SimpleDateFormat(format).format(calendar.getTime());
    }

    /**
     * 取得一年的第几周
     *
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 取得指定日期的时间戳
     *
     * @param date
     * @return
     */
    public static long getTimeInMillis(Date date) {
        Calendar c = Calendar.getInstance();
        return c.getTimeInMillis();
    }

    /**
     * 根据日期取得星期几
     *
     * @param date
     * @return
     */
    public static String getWeek(Date date) {
        String[] weeks = {"日", "一", "二", "三", "四", "五", "六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * 根据日期取得星期几
     *
     * @return
     */
    public static String getWeekByYyyyMmDd(String dateStr, String format) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String[] weeks = {"日", "一", "二", "三", "四", "五", "六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week_index < 0) {
            week_index = 0;
        }
        return weeks[week_index];
    }

    /**
     * 指定日期增加n天的日期
     *
     * @param format
     * @param dateStr
     * @param addDays
     * @return
     */
    public static String getAddDays(String format, String dateStr, int addDays) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat(format).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, addDays);//加一天
        return new SimpleDateFormat(format).format(cal.getTime());
    }

    /**
     * 获得格式化时间
     *
     * @param format
     * @param dateStr
     * @return
     */
    public static String getForMatTime(String format, String dateStr) {
        StringBuffer rs = new StringBuffer();
        if (HH_MM_SS.equals(format) && dateStr.length() > 11) {
            rs.append(dateStr.substring(11));
            if (rs.length() == 5) {
                rs.append(":00");
            }
        } else {
            return dateStr;
        }
        return rs.toString();
    }

    /**
     * 获取指定时间对应的毫秒数
     *
     * @param time "HH:mm:ss"
     * @return
     */

    public static long getTimeMillis(String time) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
            DateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
            Date curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
            return curDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 计算开始日期-根据字段
     *
     * @param date     基础日期
     * @param dbField  字段
     * @param dateList
     * @return 结束日期
     */
    public static String handlerBegDateByDbField(String date, String dbField, List<String> dateList) {
        int days = 1;
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_1.equals(dbField)) {
            days = 1;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_2.equals(dbField)) {
            days = 2;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_3.equals(dbField)) {
            days = 3;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_5.equals(dbField)) {
            days = 5;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_10.equals(dbField)) {
            days = 10;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_20.equals(dbField)) {
            days = 20;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_40.equals(dbField)) {
            days = 40;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_20_40.equals(dbField)) {
            days = 40;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_40_60.equals(dbField)) {
            days = 60;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_60.equals(dbField)) {
            days = 60;
        }
        if (dateList != null && dateList.size() >= days) {
            return dateList.get(days);
        }
        return StockService.findBegDate(date, days);
    }

    /**
     * 计算结束日期-根据字段
     *
     * @param date     基础日期
     * @param dbField  字段
     * @param dateList
     * @return 结束日期
     */
    public static String handlerEndDateByDbField(String date, String dbField, List<String> dateList) {
        int days = 1;
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_1.equals(dbField)) {
            days = 1;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_2.equals(dbField)) {
            days = 1;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_3.equals(dbField)) {
            days = 1;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_5.equals(dbField)) {
            days = 1;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_10.equals(dbField)) {
            days = 1;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_20.equals(dbField)) {
            days = 1;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_40.equals(dbField)) {
            days = 1;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_1_60.equals(dbField)) {
            days = 1;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_20_40.equals(dbField)) {
            days = 20;
        }
        if (DB_STOCK_ADR_COUNT_ADR_UP_SUM_40_60.equals(dbField)) {
            days = 40;
        }
        if (dateList != null && dateList.size() >= days) {
            return dateList.get(days);
        }
        return StockService.findBegDate(date, days);
    }

    /**
     * 检查是否是今天
     *
     * @param spDate
     * @return
     */
    public static boolean isTodayBySpDate(String spDate, String format) {
        boolean rs = false;
        if (spDate.contains("-")) {
            spDate = spDate.replace("-", "");
        }
        //如果非今天，退出比较
        String today = DateUtil.getToday(format);
        if (spDate.equals(today)) {
//            System.out.println("特定日期等于今日：【" + spDate + "】：【" + today + "】");
            rs = true;
        } else {
            System.out.println("特定日期不不不不不等于今日：【" + spDate + "】：【" + today + "】");
        }
        return rs;
    }


}
