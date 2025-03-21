package ttjj.dto;

import ttjj.db.RankStockCommpanyDb;

import java.math.BigDecimal;
import java.util.List;


/**
 * 查询条件-模糊匹配概念
 *
 * @author Administrator
 * @date 2022-02-07 14:10
 */
public class CondStock extends RankStockCommpanyDb {
    /**
     * mvMin 最低市值
     */
    private BigDecimal mvMin;
    /**
     * mvMax
     */
    private BigDecimal mvMax;
    /**
     * 涨跌率-最低
     */
    private BigDecimal adrMin;
    /**
     * begDate 开始日期
     */
    private String begDate;
    /**
     * endDate 结束日期
     */
    private String endDate;
    /**
     * 净值-开始日期
     */
    private BigDecimal begDateF18;
    /**
     * 净值-结束日期
     */
    private BigDecimal endDateF2;
    /**
     * 区间涨幅
     */
    private BigDecimal areaF3;
    /**
     * stCodeList 限定股票代码列表
     */
    private List<String> stCodeList;
    /**
     * 编码过滤列表
     */
    private List<String> stCodeListNotIn;
    /**
     * orderBy 排序
     */
    private String orderBy;

    /**
     * conpetionList 概念列表
     */
    List<String> conpetionList;
    /**
     * 概念非空
     */
    private Boolean conceptionNotNull;
    /**
     * 概念为空
     */
    private Boolean conceptionIsNull;

    /**
     * 最低-涨幅
     */
    private BigDecimal minF3;
    /**
     * 最高-涨幅
     */
    private BigDecimal maxF3;
    /**
     * 不查询市场板
     */
    private Long f139not;
    /**
     * 不查询多个市场板
     */
    private List<Long> f139notList;
    /**
     * 最低上市日期
     */
    private String minF26;
    /**
     * 上市日期-最高：可以过滤新股
     */
    private String maxF26;

    public CondStock() {
    }

    /**
     * 构造方法
     * @param date
     * @param f139
     * @param f3
     * @param minF3
     * @param maxF3
     */
    public CondStock(String date, Long f139, BigDecimal f3, BigDecimal minF3, BigDecimal maxF3) {
        setDate(date);
        setF139(f139);
        setF3(f3);
        this.minF3 = minF3;
        this.maxF3 = maxF3;
    }

    /**
     * 构造方法
     * @param date 日期
     * @param f13 市场
     * @param f139 市场板
     * @param f3 涨幅
     * @param minF3 最低涨幅
     * @param maxF3 最高涨幅
     */
    public CondStock(String date, Long f13, Long f139, BigDecimal f3, BigDecimal minF3, BigDecimal maxF3) {
        setDate(date);
        setF13(f13);
        setF139(f139);
        setF3(f3);
        this.minF3 = minF3;
        this.maxF3 = maxF3;
    }

    /**
     * 构造方法
     * @param date 日期
     * @param f13 市场
     * @param f139 市场板
     * @param f139not 不查询市场板
     * @param f3 涨幅
     * @param minF3 最低涨幅
     * @param maxF3 最高涨幅
     */
//    public CondStock(String date, Long f13, Long f139, Long f139not, BigDecimal f3, BigDecimal minF3, BigDecimal maxF3) {
//        setDate(date);
//        setF13(f13);
//        setF139(f139);
//        setF139not(f139not);
//        setF3(f3);
//        this.minF3 = minF3;
//        this.maxF3 = maxF3;
//    }

    /**
     * 构造方法
     * @param date 日期
     * @param f13 市场
     * @param f139 市场板
     * @param f139notList 不查询市场板多个
     * @param f3 涨幅
     * @param minF3 最低涨幅
     * @param maxF3 最高涨幅
     */
    public CondStock(String date, Long f13, Long f139, List<Long> f139notList, BigDecimal f3, BigDecimal minF3, BigDecimal maxF3) {
        setDate(date);
        setF13(f13);
        setF139(f139);
        setF139notList(f139notList);
        setF3(f3);
        this.minF3 = minF3;
        this.maxF3 = maxF3;
    }

    public String getBegDate() {
        return begDate;
    }

    public void setBegDate(String begDate) {
        this.begDate = begDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<String> getStCodeList() {
        return stCodeList;
    }

    public void setStCodeList(List<String> stCodeList) {
        this.stCodeList = stCodeList;
    }

    public BigDecimal getAdrMin() {
        return adrMin;
    }

    public void setAdrMin(BigDecimal adrMin) {
        this.adrMin = adrMin;
    }

    public List<String> getConpetionList() {
        return conpetionList;
    }

    public void setConpetionList(List<String> conpetionList) {
        this.conpetionList = conpetionList;
    }

    public BigDecimal getMvMin() {
        return mvMin;
    }

    public void setMvMin(BigDecimal mvMin) {
        this.mvMin = mvMin;
    }

    public BigDecimal getMvMax() {
        return mvMax;
    }

    public void setMvMax(BigDecimal mvMax) {
        this.mvMax = mvMax;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public BigDecimal getMinF3() {
        return minF3;
    }

    public void setMinF3(BigDecimal minF3) {
        this.minF3 = minF3;
    }

    public BigDecimal getMaxF3() {
        return maxF3;
    }

    public void setMaxF3(BigDecimal maxF3) {
        this.maxF3 = maxF3;
    }

    public BigDecimal getEndDateF2() {
        return endDateF2;
    }

    public void setEndDateF2(BigDecimal endDateF2) {
        this.endDateF2 = endDateF2;
    }

    public BigDecimal getAreaF3() {
        return areaF3;
    }

    public void setAreaF3(BigDecimal areaF3) {
        this.areaF3 = areaF3;
    }

    public BigDecimal getBegDateF18() {
        return begDateF18;
    }

    public void setBegDateF18(BigDecimal begDateF18) {
        this.begDateF18 = begDateF18;
    }

    public Long getF139not() {
        return f139not;
    }

    public void setF139not(Long f139not) {
        this.f139not = f139not;
    }

    public List<Long> getF139notList() {
        return f139notList;
    }

    public void setF139notList(List<Long> f139notList) {
        this.f139notList = f139notList;
    }

    public List<String> getStCodeListNotIn() {
        return stCodeListNotIn;
    }

    public void setStCodeListNotIn(List<String> stCodeListNotIn) {
        this.stCodeListNotIn = stCodeListNotIn;
    }

    public String getMinF26() {
        return minF26;
    }

    public void setMinF26(String minF26) {
        this.minF26 = minF26;
    }

    public String getMaxF26() {
        return maxF26;
    }

    public void setMaxF26(String maxF26) {
        this.maxF26 = maxF26;
    }

    public Boolean getConceptionNotNull() {
        return conceptionNotNull;
    }

    public void setConceptionNotNull(Boolean conceptionNotNull) {
        this.conceptionNotNull = conceptionNotNull;
    }

    public Boolean getConceptionIsNull() {
        return conceptionIsNull;
    }

    public void setConceptionIsNull(Boolean conceptionIsNull) {
        this.conceptionIsNull = conceptionIsNull;
    }
}
