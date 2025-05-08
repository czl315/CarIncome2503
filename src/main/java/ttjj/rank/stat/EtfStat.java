package ttjj.rank.stat;

import ttjj.rank.EtfControl;
import utils.DateUtil;

/**
 * etf
 */
public class EtfStat {
    public static void main(String[] args) {
        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//        String date = "2025-04-25";
        EtfControl.findByDateOrder(date, null,null);//查询数据根据日期，按照涨幅倒序
//        EtfControl.findTypeTop(date);//查询每个类型涨幅排序头部的前n个
    }

}
