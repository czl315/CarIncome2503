package ttjj.rank.stat;

import ttjj.rank.EtfControl;
import utils.DateUtil;

import static utils.Content.ORDER_FIELD_F3;

/**
 * etf
 */
public class EtfStat {
    public static void main(String[] args) {
        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//        String date = "2025-04-25";
        EtfControl.findByDateOrderByDescAdr(date);//查询数据根据日期，按照涨幅倒序
//        EtfControl.findTypeTop(date);//查询每个类型涨幅排序头部的前n个
    }

}
