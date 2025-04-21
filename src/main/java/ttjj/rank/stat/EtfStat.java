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
//        String date = "2025-04-18";
        EtfControl.findByDateOrderByDescAdr(date, ORDER_FIELD_F3);//查询数据根据日期，按照涨幅倒序    ORDER_FIELD_F3;//ORDER_FIELD_F3   ORDER_FIELD_ADR_UP_SUM_1_60
    }

}
