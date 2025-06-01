package ttjj.rank.stat;

import ttjj.dto.CondEtfAdrCount;
import ttjj.dto.EtfAdrCountVo;
import ttjj.rank.EtfControl;
import ttjj.service.StockService;
import utils.ContMapEtfTop;
import utils.Content;
import utils.DateUtil;

import java.math.BigDecimal;
import java.util.*;

import static utils.ContMapEtfTop.ETF_All;
import static utils.ContMapEtfTop.ZIYUAN_OIL;
import static utils.Content.*;

/**
 * etf数据统计
 * 1、涨幅倒序
 * 2、涨幅合计排名
 * 3、头部etf
 * 4、最近20日价格区间
 * 5、最近3个交易日涨幅累计
 * 6、最近5个交易日涨幅累计
 * 7、最近10个交易日涨幅累计
 * 8、最近20个交易日涨幅累计
 * 9、最近60个交易日涨幅累计
 * 10、突破均线
 */
public class EtfStat {
    public static void main(String[] args) {
//        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
        String date = "2025-05-30";

        //查询多日数据
        Integer maxAdrUpSumOrderStat = null;
        Integer maxAdrUpSumTotalRank = null;
        int days = 1;
        Set<String> zqdmSet = new HashSet<>();
        List<String> zqdmList = null;
        zqdmList = new ArrayList<>(ContMapEtfTop.ETF_All.keySet());
        List<String> dateList = StockService.findListDateBefore(date, days, API_TYPE_SSE);//查询n个交易日之前的日期
        List<EtfAdrCountVo> rs = null;
        for (String day : dateList) {
            rs = EtfControl.findByDateOrder(day, zqdmList, null, F3_DESC, maxAdrUpSumOrderStat, null, maxAdrUpSumTotalRank);//涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//            rs = EtfControl.findByDateOrder(day, zqdmList, null, F3_DESC, maxAdrUpSumOrderStat, null, 2);//涨幅合计分类型排名前n个
//            rs = EtfControl.findByDateOrder(day, new ArrayList<>(ContMapEtfTop.ETF_All.keySet()), null, F3_DESC, maxAdrUpSumOrderStat, null, maxAdrUpSumTotalRank);//常用etf
//            rs = EtfControl.findByDateOrder(day, zqdmList, null, NET_AREA_DAY_20, maxAdrUpSumOrderStat, null, null);//最近20日价格区间
//            EtfControl.findByDateOrder(day, zqdmList, null, ADR_UP_SUM_1_3_DESC, maxAdrUpSumOrderStat, null, null);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//            EtfControl.findByDateOrder(day, zqdmList, null, ADR_UP_SUM_1_5_DESC, maxAdrUpSumOrderStat, null, null);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                EtfControl.findByDateOrder(day, zqdmList, 10, ADR_UP_SUM_1_10_DESC, maxAdrUpSumOrderStat, null, 1);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                EtfControl.findByDateOrder(day, zqdmList, 10, ADR_UP_SUM_1_20_DESC, maxAdrUpSumOrderStat, null, 1);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                EtfControl.findByDateOrder(day, zqdmList, 10, ADR_UP_SUM_1_60_DESC, maxAdrUpSumOrderStat, null, 1);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//            EtfControl.findByDateOrder(day, zqdmList, null, NET_AREA_DAY_20, maxAdrUpSumOrderStat, null, null);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                EtfControl.findBreakUpMa(day, Arrays.asList(KLT_102,KLT_101,KLT_60), new BigDecimal("1"), maxAdrUpSumOrderStat);//  KLT_102,KLT_101,KLT_60,KLT_30,KLT_15
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
