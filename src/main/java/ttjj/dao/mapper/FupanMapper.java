package ttjj.dao.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ttjj.db.Fupan;

import java.util.List;

/**
 * @author chenzhilong
 * @date 2021/4/7
 */
public interface FupanMapper {
    @Select("select * from fupan")
    List<Fupan> getAllRupan();

    @Select("select * from fupan where id= #{id}")
    public Fupan getUserByID(int id);

    /**
     *
     * @param fupan
     * @return
     */
    @Select("select * from fupan where CODE=#{code} AND fupan.period=#{period}")
    public Fupan findDbByDate(Fupan fupan);

    @Update({"<script>",
            "update fupan",
            "  <set>",
            "    <if test='rt_hs300 != null'>rt_hs300=#{rt_hs300},</if>",
            "    <if test='rt_cyb50 != null'>rt_cyb50=#{rt_cyb50},</if>",
            "    <if test='rt_sh50 != null'>rt_sh50=#{rt_sh50},</if>",
            "    <if test='rt_sz != null'>rt_sz=#{rt_sz},</if>",
            "    <if test='rt_cyb != null'>rt_cyb=#{rt_cyb},</if>",
            "    <if test='rt_sh != null'>rt_sh=#{rt_sh},</if>",
            "    <if test='rt_zz500 != null'>rt_zz500=#{rt_zz500},</if>",
            "    <if test='rt_biz_qs != null'>rt_biz_qs=#{rt_biz_qs},</if>",
            "    <if test='rt_kcb50 != null'>rt_kcb50=#{rt_kcb50},</if>",

            "    <if test='cje_hs300 != null'>cje_hs300=#{cje_hs300},</if>",
            "    <if test='cje_sh != null'>cje_sh=#{cje_sh},</if>",
            "    <if test='cje_sz != null'>cje_sz=#{cje_sz},</if>",
            "    <if test='cje_cyb != null'>cje_cyb=#{cje_cyb},</if>",
            "    <if test='cje_cyb50 != null'>cje_cyb50=#{cje_cyb50},</if>",
            "    <if test='cje_sh50 != null'>cje_sh50=#{cje_sh50},</if>",
            "    <if test='cje_zz500 != null'>cje_zz500=#{cje_zz500},</if>",
            "    <if test='cje_biz_qs != null'>cje_biz_qs=#{cje_biz_qs},</if>",
            "    <if test='cje_kcb50 != null'>cje_kcb50=#{cje_kcb50},</if>",

            "    <if test='pt_hs300 != null'>pt_hs300=#{pt_hs300},</if>",
            "    <if test='pt_cyb50 != null'>pt_cyb50=#{pt_cyb50},</if>",
            "    <if test='pt_cyb != null'>pt_cyb=#{pt_cyb},</if>",
            "    <if test='pt_sh50 != null'>pt_sh50=#{pt_sh50},</if>",
            "    <if test='pt_sh != null'>pt_sh=#{pt_sh},</if>",
            "    <if test='pt_sz != null'>pt_sz=#{pt_sz},</if>",
            "    <if test='pt_zz500 != null'>pt_zz500=#{pt_zz500},</if>",
            "    <if test='pt_kcb50 != null'>pt_kcb50=#{pt_kcb50},</if>",
            "    <if test='pt_biz_qs != null'>pt_biz_qs=#{pt_biz_qs},</if>",

            "    <if test='pt_hs300_last != null'>pt_hs300_last=#{pt_hs300_last},</if>",
            "    <if test='pt_cyb50_last != null'>pt_cyb50_last=#{pt_cyb50_last},</if>",
            "    <if test='pt_cyb_last != null'>pt_cyb_last=#{pt_cyb_last},</if>",
            "    <if test='pt_sh50_last != null'>pt_sh50_last=#{pt_sh50_last},</if>",
            "    <if test='pt_sh_last != null'>pt_sh_last=#{pt_sh_last},</if>",
            "    <if test='pt_sz_last != null'>pt_sz_last=#{pt_sz_last},</if>",
            "    <if test='pt_zz500_last != null'>pt_zz500_last=#{pt_zz500_last},</if>",
            "    <if test='pt_biz_qs_last != null'>pt_biz_qs_last=#{pt_biz_qs_last},</if>",
            "    <if test='pt_kcb50_last != null'>pt_kcb50_last=#{pt_kcb50_last},</if>",

            "    <if test='pt_sh_min != null'>pt_sh_min=#{pt_sh_min},</if>",
            "    <if test='pt_sh_max != null'>pt_sh_max=#{pt_sh_max},</if>",
            "    <if test='pt_sh50_min != null'>pt_sh50_min=#{pt_sh50_min},</if>",
            "    <if test='pt_sh50_max != null'>pt_sh50_max=#{pt_sh50_max},</if>",
            "    <if test='pt_hs300_min != null'>pt_hs300_min=#{pt_hs300_min},</if>",
            "    <if test='pt_hs300_max != null'>pt_hs300_max=#{pt_hs300_max},</if>",
            "    <if test='pt_zz500_min != null'>pt_zz500_min=#{pt_zz500_min},</if>",
            "    <if test='pt_zz500_max != null'>pt_zz500_max=#{pt_zz500_max},</if>",
            "    <if test='pt_sz_min != null'>pt_sz_min=#{pt_sz_min},</if>",
            "    <if test='pt_sz_max != null'>pt_sz_max=#{pt_sz_max},</if>",
            "    <if test='pt_cyb_min != null'>pt_cyb_min=#{pt_cyb_min},</if>",
            "    <if test='pt_cyb_max != null'>pt_cyb_max=#{pt_cyb_max},</if>",
            "    <if test='pt_cyb50_min != null'>pt_cyb50_min=#{pt_cyb50_min},</if>",
            "    <if test='pt_cyb50_max != null'>pt_cyb50_max=#{pt_cyb50_max},</if>",
            "    <if test='pt_kcb50_min != null'>pt_kcb50_min=#{pt_kcb50_min},</if>",
            "    <if test='pt_kcb50_max != null'>pt_kcb50_max=#{pt_kcb50_max},</if>",

            "    <if test='amt_dfcf != null'>amt_dfcf=#{amt_dfcf},</if>",
            "    <if test='hold_st != null'>hold_st=#{hold_st},</if>",
            "    <if test='earn_st != null'>earn_st=#{earn_st},</if>",
            "    <if test='rt_st != null'>rt_st=#{rt_st},</if>",
            "    <if test='amt != null'>amt=#{amt},</if>",
            "    <if test='amt_fund != null'>amt_fund=#{amt_fund},</if>",
            "    <if test='amt_fund_last != null'>amt_fund_last=#{amt_fund_last},</if>",
            "    <if test='earn_fund != null'>earn_fund=#{earn_fund},</if>",
            "    <if test='rt_zh != null'>rt_zh=#{rt_zh},</if>",

            "    <if test='COUNT_ST_ALL != null'>COUNT_ST_ALL=#{COUNT_ST_ALL},</if>",
            "    <if test='COUNT_ST_ALL_UP != null'>COUNT_ST_ALL_UP=#{COUNT_ST_ALL_UP},</if>",
            "    <if test='COUNT_ST_ALL_DOWN != null'>COUNT_ST_ALL_DOWN=#{COUNT_ST_ALL_DOWN},</if>",
            "    <if test='COUNT_ST_ALL_FLAT != null'>COUNT_ST_ALL_FLAT=#{COUNT_ST_ALL_FLAT},</if>",
            "    <if test='COUNT_ST_ZB_UP != null'>COUNT_ST_ZB_UP=#{COUNT_ST_ZB_UP},</if>",
            "    <if test='COUNT_ST_ZB_DOWN != null'>COUNT_ST_ZB_DOWN=#{COUNT_ST_ZB_DOWN},</if>",
            "    <if test='COUNT_ST_ZB_FLAT != null'>COUNT_ST_ZB_FLAT=#{COUNT_ST_ZB_FLAT},</if>",

            "  </set>",
            "where CODE=#{code} AND fupan.period=#{period} ",
            "    <if test='type != null'> AND fupan.TYPE=#{type}</if>",
            "</script>"})
    void updateFupan(Fupan fupan);

    /**
     * 新-我的股票-资产持仓-只有为空时才更新
     * @param fupan
     */
    @Update({"<script>",
            "update fupan",
            "  <set>",
            "    <if test='assetPosition != null'>assetPosition=#{assetPosition},</if>",
            "  </set>",
//            "where CODE=#{code} AND fupan.period=#{period} AND fupan.TYPE=#{type} AND (fupan.assetPosition=''OR fupan.assetPosition IS NULL)",
            "where CODE=#{code} AND fupan.period=#{period} AND fupan.TYPE=#{type}",
            "</script>"})
    void updateMyStockAssetPosition(Fupan fupan);

}
