package ttjj.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ttjj.db.Fupan;
import ttjj.dto.BizDto;
import ttjj.dto.RankBizDataDiff;
import ttjj.dto.StatCondStAdrCountBiz;

import java.util.List;
import java.util.Map;

/**
 * @author chenzhilong
 * @date 2021/4/7
 */
public interface RandBizEtfMapper {
    @Select("select * from fupan where id= #{id}")
    public Fupan getUserByID(int id);

    /**
     * @param condition
     * @return
     */
    @Select({"<script>",
            "   SELECT ",
            "       * ",
            "   FROM rank_st_biz ",
            "   WHERE 1=1  ",
            "       AND rank_st_biz.f12=#{f12} ",
            "   ORDER BY rank_st_biz.date DESC ",
            "   LIMIT 1 ",
            "</script>"})
    RankBizDataDiff findEtfLast(RankBizDataDiff condition);

    /**
     * 查询业务-根据条件：编码、日期、业务类型
     *
     * @param condition 查询条件
     * @return 查询结果
     */
    @Select({"<script>",
            "   SELECT ",
            "       * ",
            "   FROM rank_st_biz ",
            "   WHERE 1=1  ",
            "       <if test='date != null'> AND date = #{date}</if> ",
            "       <if test='f12 != null'> AND f12 = #{f12}</if> ",
//            "   ORDER BY rank_st_biz.date DESC ",
//            "   LIMIT 1 ",
            "</script>"})
    RankBizDataDiff findBiz(RankBizDataDiff condition);

    /**
     * 列表查询-行业etf-排序：涨跌幅
     *
     * @param condition
     * @return
     */
    @Select({"<script>",
            "   SELECT ",
            "       * ",
            "   FROM rank_st_biz ",
            "   WHERE 1=1  ",
            "       AND rank_st_biz.type = 'etf'  ",
//            "       AND rank_st_biz.date = '2021-11-05'  ",
            "       AND rank_st_biz.date = #{date}  ",
            "       AND rank_st_biz.f12 IN  ",
            "       <foreach collection='list' item='item' open='(' separator=',' close=')'>  ",
            "           #{item} ",
            "       </foreach> ",
            "   ORDER BY rank_st_biz.f3 DESC ",
            "   LIMIT 100 ",
            "</script>"})
    List<RankBizDataDiff> listEtfBiz(Map<String, Object> condition);

    @Select({"<script>",
            "   SELECT ",
            "       * ",
            "   FROM rank_st_biz ",
            "   WHERE 1=1  ",
            "       <if test='date != null'> ",
            "       AND rank_st_biz.date = #{date}  ",
            "       </if> ",
            "       <if test='type != null'> ",
            "       AND rank_st_biz.type = #{type}  ",
            "       </if> ",
            "       <if test='begDate != null'> ",
            "       <![CDATA[ AND rank_st_biz.date >= #{begDate} ]]> ",
            "       </if> ",
            "       <if test='endDate != null'> ",
            "       <![CDATA[ AND rank_st_biz.date <= #{endDate} ]]> ",
            "       </if> ",
            "       <if test='f12 != null'> ",
            "       AND rank_st_biz.f12 = #{f12} ",
            "       </if> ",
            "       <if test='f139 != null'> ",
            "       AND rank_st_biz.f139=#{f139} ",
            "       </if> ",
            "       <if test='stCodeList != null'> ",
            "           AND rank_st_biz.f12 IN  ",
            "               <foreach collection='stCodeList' item='item' open='(' separator=',' close=')'>  ",
            "                   #{item} ",
            "               </foreach> ",
            "       </if> ",
//            "       AND rank_st_biz.conception LIKE CONCAT('%',#{conception},'%')",
            "       <if test='f20 != null'> ",
            "       AND rank_st_biz.f20 >= #{f20} ",
            "       </if> ",
            "       <if test='mvMin != null'> ",
            "           AND ",
            "           ( ",
            "               rank_st_biz.f20 >= #{mvMin} ",
            "               <if test='mvMinStCodeOrList != null'> ",
            "               OR rank_st_biz.f12 IN  ",
            "               <foreach collection='mvMinStCodeOrList' item='item' open='(' separator=',' close=')'>  ",
            "                   #{item} ",
            "               </foreach> ",
            "               </if> ",
            "           ) ",
            "       </if> ",
            "       <if test='mvMax != null'> ",
            "       <![CDATA[ AND rank_st_biz.f20 <= #{mvMax} ]]> ",
            "       </if> ",

            "       <if test='orderBy != null '> ",
            "        ORDER BY  ${orderBy} ",
            "       </if> ",
//            "   ORDER BY rank_st_biz.f3 DESC ",
            "</script>"})
    List<BizDto> findListDbBiz(BizDto condition);

    @Insert({"<script>",
            "INSERT INTO `bank19`.`rank_st_biz`(",
            "`date`,`type`,`order_num`",//`rs`,
            ",`month`,`weekYear`,`week`",
            ",`f1`,`f2`,`f3`,`f4`",
            ",`f5`,`f6`,`f7`,`f8`,`f9`",
            ",`f10`,`f11`,`f12`,`f13`,`f14`",
            ",`f15`,`f16`,`f17`,`f18`,`f19`",
            ",`f20`,`f21`,`f22`,`f23`,`f24`",
            ",`f25`,`f26`,`f27`,`f28`,`f29`",
            ",`f30`,`f31`,`f32`,`f33`,`f34`,`f35`,`f36`,`f37`,`f38`,`f39`",
            ",`f40`,`f41`,`f42`,`f43`,`f44`,`f45`,`f46`,`f47`,`f48`,`f49`",
            ",`f50`,`f51`,`f52`,`f53`,`f54`,`f55`,`f56`,`f57`,`f58`,`f59`",
            ",`f60`,`f61`,`f62`,`f63`,`f64`",
            ",`f65`,`f66`,`f67`,`f68`,`f69`",
            ",`f70`,`f71`,`f72`,`f73`,`f74`",
            ",`f75`,`f76`,`f77`,`f78`,`f79`",
            ",`f80`,`f81`,`f82`,`f83`,`f84`",
            ",`f85`,`f86`,`f87`,`f88`,`f89`",
            ",`f90`,`f91`,`f92`,`f93`,`f94`",
            ",`f95`,`f96`,`f97`,`f98`,`f99`",
            ",`f104`",
            ",`f105`,`f107`,`f109`",
            ",`f110`,`f111`",
            ",`f115`",
            ",`f124`",
            ",`f127`,`f128`",
            ",`f136`,`f139`",
            ",`f140`,`f141`,`f142`,`f143`,`f144`",
            ",`f145`,`f148`,`f149`",
            ",`f152`",
            ",`f207`",
            ",`f208`",
            ",`f209`",
            ",`f222`,`f223`",
            ") VALUES (",
            "#{date},#{type},#{orderNum}",//#{rs}
            ",#{month},#{weekYear},#{week}",
            ",#{f1},#{f2},#{f3},#{f4}",
            ",#{f5},#{f6},#{f7},#{f8},#{f9}",
            ",#{f10},#{f11},#{f12},#{f13},#{f14}",
            ",#{f15},#{f16},#{f17},#{f18},#{f19}",
            ",#{f20},#{f21},#{f22},#{f23},#{f24}",
            ",#{f25},#{f26},#{f27},#{f28},#{f29}",
            ",#{f30},#{f31},#{f32},#{f33},#{f34},#{f35},#{f36},#{f37},#{f38},#{f39}",
            ",#{f40},#{f41},#{f42},#{f43},#{f44},#{f45},#{f46},#{f47},#{f48},#{f49}",
            ",#{f50},#{f51},#{f52},#{f53},#{f54},#{f55},#{f56},#{f57},#{f58},#{f59}",
            ",#{f60},#{f61},#{f62},#{f63},#{f64}",
            ",#{f65},#{f66},#{f67},#{f68},#{f69}",
            ",#{f70},#{f71},#{f72},#{f73},#{f74}",
            ",#{f75},#{f76},#{f77},#{f78},#{f79}",
            ",#{f80},#{f81},#{f82},#{f83},#{f84}",
            ",#{f85},#{f86},#{f87},#{f88},#{f89}",
            ",#{f90},#{f91},#{f92},#{f93},#{f94}",
            ",#{f95},#{f96},#{f97},#{f98},#{f99}",
            ",#{f104}",
            ",#{f105},#{f107},#{f109}",
            ",#{f110},#{f111}",
            ",#{f115}",
            ",#{f124}",
            ",#{f127},#{f128}",
            ",#{f136},#{f139}",
            ",#{f140},#{f141},#{f142},#{f143},#{f144}",
            ",#{f145},#{f148},#{f149}",
            ",#{f152}",
            ",#{f207}",
            ",#{f208}",
            ",#{f209}",
            ",#{f222},#{f223}",
            ");",
            "</script>"})
    void insertRandBizEtf(RankBizDataDiff entity);

    @Update({"<script>",
            "update rank_st_biz",
            "  <set>",
            "    <if test='f2 != null'>f2=#{f2},</if>",
            "    <if test='f15 != null'>f15=#{f15},</if>",
            "    <if test='f16 != null'>f16=#{f16},</if>",
            "    <if test='f17 != null'>f17=#{f17},</if>",
            "    <if test='f18 != null'>f18=#{f18},</if>",
            "    <if test='LAST_NET != null'>LAST_NET=#{LAST_NET},</if>",
            "    <if test='NET_MIN_1 != null'>NET_MIN_1=#{NET_MIN_1},</if>",
            "    <if test='NET_MIN_CLOS_1 != null'>NET_MIN_CLOS_1=#{NET_MIN_CLOS_1},</if>",
            "    <if test='NET_MAX_1 != null'>NET_MAX_1=#{NET_MAX_1},</if>",
            "    <if test='NET_MAX_CLOS_1 != null'>NET_MAX_CLOS_1=#{NET_MAX_CLOS_1},</if>",
            "    <if test='NET_MIN_7 != null'>NET_MIN_7=#{NET_MIN_7},</if>",
            "    <if test='NET_MIN_CLOS_7 != null'>NET_MIN_CLOS_7=#{NET_MIN_CLOS_7},</if>",
            "    <if test='NET_MAX_7 != null'>NET_MAX_7=#{NET_MAX_7},</if>",
            "    <if test='NET_MAX_CLOS_7 != null'>NET_MAX_CLOS_7=#{NET_MAX_CLOS_7},</if>",
            "    <if test='NET_MIN_14 != null'>NET_MIN_14=#{NET_MIN_14},</if>",
            "    <if test='NET_MIN_CLOS_14 != null'>NET_MIN_CLOS_14=#{NET_MIN_CLOS_14},</if>",
            "    <if test='NET_MAX_14 != null'>NET_MAX_14=#{NET_MAX_14},</if>",
            "    <if test='NET_MAX_CLOS_14 != null'>NET_MAX_CLOS_14=#{NET_MAX_CLOS_14},</if>",
            "    <if test='NET_MIN_30 != null'>NET_MIN_30=#{NET_MIN_30},</if>",
            "    <if test='NET_MIN_CLOS_30 != null'>NET_MIN_CLOS_30=#{NET_MIN_CLOS_30},</if>",
            "    <if test='NET_MAX_30 != null'>NET_MAX_30=#{NET_MAX_30},</if>",
            "    <if test='NET_MAX_CLOS_30 != null'>NET_MAX_CLOS_30=#{NET_MAX_CLOS_30},</if>",
            "    <if test='NET_MIN_60 != null'>NET_MIN_60=#{NET_MIN_60},</if>",
            "    <if test='NET_MIN_CLOS_60 != null'>NET_MIN_CLOS_60=#{NET_MIN_CLOS_60},</if>",
            "    <if test='NET_MAX_60 != null'>NET_MAX_60=#{NET_MAX_60},</if>",
            "    <if test='NET_MAX_CLOS_60 != null'>NET_MAX_CLOS_60=#{NET_MAX_CLOS_60},</if>",
            "    <if test='NET_MIN_90 != null'>NET_MIN_90=#{NET_MIN_90},</if>",
            "    <if test='NET_MIN_CLOS_90 != null'>NET_MIN_CLOS_90=#{NET_MIN_CLOS_90},</if>",
            "    <if test='NET_MAX_90 != null'>NET_MAX_90=#{NET_MAX_90},</if>",
            "    <if test='NET_MAX_CLOS_90 != null'>NET_MAX_CLOS_90=#{NET_MAX_CLOS_90},</if>",
            "    <if test='NET_MIN_180 != null'>NET_MIN_180=#{NET_MIN_180},</if>",
            "    <if test='NET_MIN_CLOS_180 != null'>NET_MIN_CLOS_180=#{NET_MIN_CLOS_180},</if>",
            "    <if test='NET_MAX_180 != null'>NET_MAX_180=#{NET_MAX_180},</if>",
            "    <if test='NET_MAX_CLOS_180 != null'>NET_MAX_CLOS_180=#{NET_MAX_CLOS_180},</if>",
            "    <if test='NET_MIN_360 != null'>NET_MIN_360=#{NET_MIN_360},</if>",
            "    <if test='NET_MIN_CLOS_360 != null'>NET_MIN_CLOS_360=#{NET_MIN_CLOS_360},</if>",
            "    <if test='NET_MAX_360 != null'>NET_MAX_360=#{NET_MAX_360},</if>",
            "    <if test='NET_MAX_CLOS_360 != null'>NET_MAX_CLOS_360=#{NET_MAX_CLOS_360},</if>",
            "    <if test='NET_MA_5 != null'>NET_MA_5=#{NET_MA_5},</if>",
            "    <if test='NET_MA_10 != null'>NET_MA_10=#{NET_MA_10},</if>",
            "    <if test='NET_MA_20 != null'>NET_MA_20=#{NET_MA_20},</if>",
            "    <if test='NET_MA_30 != null'>NET_MA_30=#{NET_MA_30},</if>",
            "    <if test='NET_MA_60 != null'>NET_MA_60=#{NET_MA_60},</if>",
            "    <if test='NET_MA_120 != null'>NET_MA_120=#{NET_MA_120},</if>",
            "    <if test='NET_MA_250 != null'>NET_MA_250=#{NET_MA_250},</if>",
            "    <if test='fundFlow != null'>fundFlow=#{fundFlow},</if>",
            "    <if test='NET_TODAY_0945 != null'>NET_TODAY_0945=#{NET_TODAY_0945},</if>",
            "    <if test='NET_TODAY_1000 != null'>NET_TODAY_1000=#{NET_TODAY_1000},</if>",
            "    <if test='NET_TODAY_1015 != null'>NET_TODAY_1015=#{NET_TODAY_1015},</if>",
            "    <if test='NET_TODAY_1030 != null'>NET_TODAY_1030=#{NET_TODAY_1030},</if>",
            "    <if test='NET_TODAY_1045 != null'>NET_TODAY_1045=#{NET_TODAY_1045},</if>",
            "    <if test='NET_TODAY_1100 != null'>NET_TODAY_1100=#{NET_TODAY_1100},</if>",
            "    <if test='NET_TODAY_1115 != null'>NET_TODAY_1115=#{NET_TODAY_1115},</if>",
            "    <if test='NET_TODAY_1130 != null'>NET_TODAY_1130=#{NET_TODAY_1130},</if>",
            "    <if test='NET_TODAY_1315 != null'>NET_TODAY_1315=#{NET_TODAY_1315},</if>",
            "    <if test='NET_TODAY_1330 != null'>NET_TODAY_1330=#{NET_TODAY_1330},</if>",
            "    <if test='NET_TODAY_1345 != null'>NET_TODAY_1345=#{NET_TODAY_1345},</if>",
            "    <if test='NET_TODAY_1400 != null'>NET_TODAY_1400=#{NET_TODAY_1400},</if>",
            "    <if test='NET_TODAY_1415 != null'>NET_TODAY_1415=#{NET_TODAY_1415},</if>",
            "    <if test='NET_TODAY_1430 != null'>NET_TODAY_1430=#{NET_TODAY_1430},</if>",
            "    <if test='NET_TODAY_1445 != null'>NET_TODAY_1445=#{NET_TODAY_1445},</if>",
            "    <if test='NET_TODAY_1500 != null'>NET_TODAY_1500=#{NET_TODAY_1500},</if>",
            "  </set>",
            "where date=#{date} AND f12=#{f12}",
            "</script>"})
    void updateEtfNet(RankBizDataDiff entity);

    @Update({"<script>",
            "update rank_st_biz",
            "  <set>",
            "    <if test='pt_time_min != null'>pt_time_min=#{pt_time_min},</if>",
            "    <if test='pt_time_max != null'>pt_time_max=#{pt_time_max},</if>",
            "  </set>",
            "where date=#{date} AND f12=#{f12}",
            "</script>"})
    void updateDbEtfNetMaxMinTimeByDate(RankBizDataDiff entity);

    @Update({"<script>",
            "update rank_st_biz",
            "  <set>",
            "    <if test='month != null'>month=#{month},</if>",
            "    <if test='weekYear != null'>weekYear=#{weekYear},</if>",
            "    <if test='week != null'>week=#{week},</if>",
            "  </set>",
            "where date=#{date} ",
            "</script>"})
    void updateDate(RankBizDataDiff entity);

    @Delete({"<script>",
            "DELETE FROM `rank_st_biz` WHERE 1=1 ",
            "   AND `date` = #{date} ",
            "   <if test='type != null'> AND rank_st_biz.type = #{type} </if> ",
            "LIMIT 9999 ",
            "</script>"})
    int deleteByDate(RankBizDataDiff entity);

    /**
     * 查询-涨跌次数
     *
     * @param condition
     * @return
     */
    @Select({"<script>",
            " SELECT",
            "   rank_st_biz.f12 code ",
            "   ,rank_st_biz.f14 name ",
            "   ,SUBSTR(rank_st_biz.date FROM 9 FOR 2) rsDate ",
            "   ,COUNT(1) count ",
            "   ,ROUND(SUM(rank_st_biz.f3),2) adrSum",
            " FROM ",
            "   `rank_st_biz` rank_st_biz ",
            " WHERE 1=1 ",
            "   <if test='type != null'> ",
            "   AND rank_st_biz.type = #{type}  ",
            "   </if> ",
            "   <if test='adrMin != null'> ",
            "   AND rank_st_biz.f3 > #{adrMin} ",
            "   </if> ",
            "       <if test='begDate != null'> ",
            "       <![CDATA[ AND rank_st_biz.date >= #{begDate} ]]> ",
            "       </if> ",
            "       <if test='endDate != null'> ",
            "       <![CDATA[ AND rank_st_biz.date <= #{endDate} ]]> ",
            "       </if> ",
            "   AND rank_st_biz.f12 IN  ",
            "   <foreach collection='stCodeList' item='item' open='(' separator=',' close=')'>  ",
            "       #{item} ",
            "   </foreach> ",
            " GROUP BY SUBSTR(rank_st_biz.date FROM 9 FOR 2) ",
            " ORDER BY ",
            "   SUBSTR(rank_st_biz.date FROM 9 FOR 2) ",
            "</script>"})
    List<BizDto> findListStatStAdrCount(StatCondStAdrCountBiz condition);

}
