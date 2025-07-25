package ttjj.rank.stat;

import ttjj.dto.CondEtfAdrCount;
import ttjj.dto.EtfAdrCountVo;
import ttjj.rank.EtfControl;
import ttjj.service.EtfAdrCountService;
import ttjj.service.StockService;
import utils.ContMapEtfAll;
import utils.Content;
import utils.ContentCookie;
import utils.DateUtil;

import java.math.BigDecimal;
import java.util.*;

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
        String date = DateUtil.getToday(DateUtil.YYYY_MM_DD);
//        String date = "2025-07-22";

        //查询多日数据
        Integer maxAdrUpSumOrderStat = null;
        int days = 1;
        Set<String> zqdmSet = new HashSet<>();
        List<String> zqdmList = null;
        zqdmList = new ArrayList<>(ContMapEtfAll.ETF_TOP_All.keySet());
        List<String> dateList = StockService.findListDateBefore(date, days, API_TYPE_SSE);//查询n个交易日之前的日期
        List<EtfAdrCountVo> rs = null;
        String orderField = F3_DESC;//F3_DESC  ADR_UP_SUM_TOTAL_DESC   ADR_UP_SUM_1_60_DESC   NET_AREA_DAY_20
        CondEtfAdrCount condition = new CondEtfAdrCount();//过滤条件
//        condition.setF3Min(new BigDecimal("5"));//当日涨幅最低
//        condition.setF139(DB_RANK_BIZ_F139_BK_MAIN);//股票-交易所板块
//        condition.setMaxAdrUpSumTotalRank(new BigDecimal("1"));
//        condition.setBizList(Arrays.asList("科技-软件"));// "资源-通用", "资源-石油", "资源-稀有","资源-农业","金融-黄金","资源-农业"  科技-软件  金融-银行
//        condition.setTypeNameListNotIn(Arrays.asList("医疗-通用"));//战争受益："资源-通用", "资源-石油","金融-黄金","科技-军工"
        for (String day : dateList) {
//            EtfAdrCountService.findMyPosition(date, null, ADR_UP_SUM_TOTAL_DESC, null, ContentCookie.COOKIE_DFCF,condition);//查询我的ETF持仓
            rs = EtfAdrCountService.findByDateOrderByField(day, orderField, null, zqdmList, maxAdrUpSumOrderStat,  condition,CHANNEL_ETF);//涨幅倒序
//            rs = EtfAdrCountService.findByDateOrderByField(day, ADR_UP_SUM_TOTAL_DESC, null, zqdmList, maxAdrUpSumOrderStat,  condition,CHANNEL_ETF);//近60日涨幅
//            rs = EtfAdrCountService.findByDateOrderByField(day, ADR_UP_SUM_1_3_DESC, null, zqdmList, maxAdrUpSumOrderStat,  condition,CHANNEL_ETF);//近3日涨幅
//            rs = EtfAdrCountService.findByDateOrderByField(day, ADR_UP_SUM_1_5_DESC, null, zqdmList, maxAdrUpSumOrderStat,  condition,CHANNEL_ETF);//近5日涨幅
//            rs = EtfAdrCountService.findByDateOrderByField(day, ADR_UP_SUM_1_10_DESC, null, zqdmList, maxAdrUpSumOrderStat,  condition,CHANNEL_ETF);//近60日涨幅
//            rs = EtfAdrCountService.findByDateOrderByField(day, ADR_UP_SUM_1_20_DESC, null, zqdmList, maxAdrUpSumOrderStat,  condition,CHANNEL_ETF);//近60日涨幅
//            rs = EtfAdrCountService.findByDateOrderByField(day, ADR_UP_SUM_20_40_DESC, null, zqdmList, maxAdrUpSumOrderStat,  condition,CHANNEL_ETF);//近60日涨幅
//            rs = EtfAdrCountService.findByDateOrderByField(day, ADR_UP_SUM_40_60_DESC, null, zqdmList, maxAdrUpSumOrderStat,  condition,CHANNEL_ETF);//近60日涨幅
//            rs = EtfAdrCountService.findByDateOrderByField(day, NET_AREA_DAY_20, null, zqdmList, maxAdrUpSumOrderStat,  condition,CHANNEL_ETF);//最近20日价格区间
//            rs = EtfAdrCountService.findByDateOrderByField(day, ADR_DOWN_SUM_1_60_DESC, null, zqdmList, maxAdrUpSumOrderStat,  condition,CHANNEL_ETF);//排序字段：下跌累计-正序
//            rs = EtfControl.findByDateOrder(day, zqdmList, null, F3_DESC, maxAdrUpSumOrderStat, null, 2);//涨幅合计分类型排名前n个
//            rs = EtfControl.findByDateOrder(day, new ArrayList<>(ContMapEtfTop.ETF_All.keySet()), null, F3_DESC, maxAdrUpSumOrderStat, null, maxAdrUpSumTotalRank);//常用etf
//            EtfControl.findByDateOrder(day, zqdmList, null, ADR_UP_SUM_1_5_DESC, maxAdrUpSumOrderStat, null, null);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                EtfControl.findByDateOrder(day, zqdmList, 10, ADR_UP_SUM_1_10_DESC, maxAdrUpSumOrderStat, null, 1);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//            rs = EtfAdrCountService.findByDateOrderByField(day, orderField, null, zqdmList, maxAdrUpSumOrderStat,  condition);//涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                EtfControl.findByDateOrder(day, zqdmList, 10, ADR_UP_SUM_1_20_DESC, maxAdrUpSumOrderStat, null, 1);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                EtfControl.findByDateOrder(day, zqdmList, null, ADR_UP_SUM_1_60_DESC, maxAdrUpSumOrderStat, null, null);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//            EtfControl.findByDateOrder(day, zqdmList, null, NET_AREA_DAY_20, maxAdrUpSumOrderStat, null, null);//查询数据根据日期，按照涨幅倒序  F3_DESC;//ORDER_FIELD_F3   ADR_UP_SUM_1_60_DESC
//                EtfControl.findBreakUpMa(day, Arrays.asList(KLT_102,KLT_101,KLT_60), new BigDecimal("1"), maxAdrUpSumOrderStat);//  KLT_102,KLT_101,KLT_60,KLT_30,KLT_15
//            rs = EtfControl.findByDateOrder(day, new ArrayList<>(ContMapEtfTop.ETF_All.keySet()), null, F3_DESC, maxAdrUpSumOrderStat, typeName, maxAdrUpSumTotalRank);//已废弃

            {
                CondEtfAdrCount conditionStock = new CondEtfAdrCount();//过滤条件
                conditionStock.setF3Min(new BigDecimal("9"));//当日涨幅最低
                conditionStock.setF139(DB_RANK_BIZ_F139_BK_MAIN);//股票-交易所板块
//                conditionStock.setMaxAdrUpSumTotalRank(new BigDecimal("1"));
//                conditionStock.setType_name("证券");//证券
//                rs = EtfAdrCountService.findByDateOrderByField(date, ADR_UP_SUM_TOTAL_DESC, null, null, maxAdrUpSumOrderStat,  conditionStock,CHANNEL_STOCK);//涨幅倒序
            }

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
