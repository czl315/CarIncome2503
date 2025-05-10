package ttjj.rank.stat;

import ttjj.rank.EtfControl;
import ttjj.service.StockService;
import utils.Content;
import utils.DateUtil;

import java.util.Arrays;
import java.util.List;

import static utils.Content.*;

/**
 * etf
 */
public class EtfStat {
    public static void main(String[] args) {
        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//        String date = "2025-04-25";
        List<String> zqdmList = null;//代码列表515030

        //查询多日数据
        List<String> dateList = StockService.findListDateBefore(date, 1,  Content.API_TYPE_SSE);//查询n个交易日之前的日期
        for (String day : dateList) {
//            EtfControl.findByDateOrder(day, zqdmList, 2,ORDER_FIELD_F3);//查询数据根据日期，按照涨幅倒序    ORDER_FIELD_F3;//ORDER_FIELD_F3   ORDER_FIELD_ADR_UP_SUM_1_20 ORDER_FIELD_NET_AREA_DAY_5
            EtfControl.findBreakUpMa(day, Arrays.asList(KLT_102,KLT_101,KLT_60,KLT_30,KLT_15), null,5);
        }
    }
}
