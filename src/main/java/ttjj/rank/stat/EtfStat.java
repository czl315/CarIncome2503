package ttjj.rank.stat;

import ttjj.dto.CondEtfAdrCount;
import ttjj.dto.EtfAdrCountVo;
import ttjj.rank.EtfControl;
import ttjj.service.StockService;
import utils.ContMapEtfSimple;
import utils.Content;
import utils.DateUtil;

import java.math.BigDecimal;
import java.util.*;

import static utils.ContMapEtfSimple.ETF_All;
import static utils.ContMapEtfSimple.ZIYUAN_OIL;
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
        Integer maxAdrUpSumOrderStat = null;
        int days = 1;
        Set<String> zqdmSet = new HashSet<>();
//        zqdmList = new ArrayList<>(ContMapEtfSimple.BIZ_ALL.keySet());
        List<String> dateList = StockService.findListDateBefore(date, days, API_TYPE_SSE);//查询n个交易日之前的日期
        for (String day : dateList) {
            List<EtfAdrCountVo> rs = EtfControl.findByDateOrder(day, zqdmList, null, F3_DESC, maxAdrUpSumOrderStat, null, 2);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                findByDateOrder(day, zqdmList, 10, ADR_UP_SUM_1_3_DESC, maxAdrUpSumOrderStat, null, 1);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                findByDateOrder(day, zqdmList, 10, ADR_UP_SUM_1_5_DESC, maxAdrUpSumOrderStat, null, 1);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                findByDateOrder(day, zqdmList, 10, ADR_UP_SUM_1_10_DESC, maxAdrUpSumOrderStat, null, 1);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                findByDateOrder(day, zqdmList, 10, ADR_UP_SUM_1_20_DESC, maxAdrUpSumOrderStat, null, 1);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                findByDateOrder(day, zqdmList, 10, ADR_UP_SUM_1_60_DESC, maxAdrUpSumOrderStat, null, 1);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
            EtfControl.findByDateOrder(day, zqdmList, null, NET_AREA_DAY_20, maxAdrUpSumOrderStat, null, 1);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                List<EtfAdrCountVo> rs = findBreakUpMa(day, Arrays.asList(KLT_102,KLT_101,KLT_60,KLT_30,KLT_15), new BigDecimal("1"), maxAdrUpSumOrderStat);//  KLT_102,KLT_101,KLT_60
            CondEtfAdrCount condFiter = new CondEtfAdrCount();//过滤条件
            condFiter.setMaxAdrUpSumOrderStat(new BigDecimal("5"));//涨序排序前n的数据
            condFiter.setShowCountTypeGroup(new BigDecimal("2").intValue());//每个类型限定n个
            if (rs == null) break;
            //证券代码集合
            for (EtfAdrCountVo etf : rs) {
                zqdmSet.add(etf.getF12());
            }
        }
//            zqdmList.addAll(zqdmSet);
//            findByDateOrder(dateList.get(0), zqdmList, 10, ADR_UP_SUM_1_20_DESC, maxAdrUpSumOrderStat,null,null);//查询数据根据日期，按照涨幅倒序    ORDER_FIELD_F3;//ORDER_FIELD_F3   ORDER_FIELD_ADR_UP_SUM_1_20 ORDER_FIELD_NET_AREA_DAY_5


    }
}
