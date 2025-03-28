package ttjj.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ttjj.db.StockAdrCount;
import ttjj.dto.CondStockAdrCount;
import ttjj.dto.StockAdrCountVo;

import java.util.List;

/**
 * StockAdrCountMapper简介
 *
 * @author Administrator
 * @date 2022-05-10 22:11
 */
public interface StockAdrCountMapper {

    @Insert({"<script>",
            "INSERT INTO `stock_adr_count` (",
            "`date`, `type_name`, `f2`, `f3`, `f4`",
            ",`f5`, `f6`, `f7`, `f8`, `f9` ",
            ",`f10`, `f12`, `f14`, `f15`, `f16` ",
            ",`f17`, `f18`, `f20`, `f21`, `order_num` ",
            ",`conception`, `ADR_UP_COUNT_5`, `ADR_UP_COUNT_10`, `ADR_UP_COUNT_20`, `ADR_UP_COUNT_40` ",
            ",`ADR_UP_COUNT_1`, `ADR_UP_COUNT_2`, `ADR_UP_COUNT_3` ",
            ",`ADR_UP_COUNT_60`, `ADR_UP_COUNT_SUM_60`,`NET_AREA_DAY_5`, `NET_AREA_DAY_10`, `NET_AREA_DAY_20`",
            ", `NET_AREA_DAY_40`, `NET_AREA_DAY_60`, `NET_AREA_DAY_120`, `NET_AREA_DAY_250`,`UP_MA_5`",
            ", `UP_MA_15`, `UP_MA_30`, `UP_MA_60`, `UP_MA_101`,`UP_MA_102`",
            ", `MA_NET_60_5`,`MA_NET_60_15`, `MA_NET_60_30`, `MA_NET_60_60`, `MA_NET_60_101`,`MA_NET_60_102`",
            ", `f139`, `f62`",
            ", `ADR_UP_SUM_1_1`, `ADR_UP_SUM_1_2`, `ADR_UP_SUM_1_3` ",
            ", `ADR_UP_SUM_1_5`, `ADR_UP_SUM_1_10`, `ADR_UP_SUM_1_20`, `ADR_UP_SUM_20_40`, `ADR_UP_SUM_40_60`, `ADR_UP_SUM_1_60`",
            ", `ADR_UP_SUM_1_40`",
            ", `ADR_UP_SUM_ORDER_1_5`, `ADR_UP_SUM_ORDER_1_10`, `ADR_UP_SUM_ORDER_1_20`, `ADR_UP_SUM_ORDER_20_40`, `ADR_UP_SUM_ORDER_40_60`, `ADR_UP_SUM_ORDER_1_60`",
            ") VALUES (",
            "#{date},#{type_name},#{f2},#{f3},#{f4}",
            ",#{f5},#{f6},#{f7},#{f8},#{f9}",
            ",#{f10},#{f12},#{f14},#{f15},#{f16}",
            ",#{f17},#{f18},#{f20},#{f21},#{order_num}",
            ",#{conception},#{ADR_UP_COUNT_5},#{ADR_UP_COUNT_10},#{ADR_UP_COUNT_20},#{ADR_UP_COUNT_40}",
            ",#{ADR_UP_COUNT_1}, #{ADR_UP_COUNT_2}, #{ADR_UP_COUNT_3} ",
            ",#{ADR_UP_COUNT_60}, #{ADR_UP_COUNT_SUM_60},#{NET_AREA_DAY_5}, #{NET_AREA_DAY_10}, #{NET_AREA_DAY_20}",
            ",#{NET_AREA_DAY_40}, #{NET_AREA_DAY_60}, #{NET_AREA_DAY_120}, #{NET_AREA_DAY_250},#{UP_MA_5}",
            ",#{UP_MA_15}, #{UP_MA_30}, #{UP_MA_60}, #{UP_MA_101},#{UP_MA_102}",
            ",#{MA_NET_60_5}, #{MA_NET_60_15}, #{MA_NET_60_30}, #{MA_NET_60_60}, #{MA_NET_60_101},#{MA_NET_60_102}",
            ",#{f139},#{f62}",
            ",#{ADR_UP_SUM_1_1},#{ADR_UP_SUM_1_2},#{ADR_UP_SUM_1_3} ",
            ", #{ADR_UP_SUM_1_5}, #{ADR_UP_SUM_1_10}, #{ADR_UP_SUM_1_20}, #{ADR_UP_SUM_20_40}, #{ADR_UP_SUM_40_60}, #{ADR_UP_SUM_1_60}",
            ", #{ADR_UP_SUM_1_40}",
            ", #{ADR_UP_SUM_ORDER_1_5}, #{ADR_UP_SUM_ORDER_1_10}, #{ADR_UP_SUM_ORDER_1_20}, #{ADR_UP_SUM_ORDER_20_40}, #{ADR_UP_SUM_ORDER_40_60}, #{ADR_UP_SUM_ORDER_1_60}",
            ");",
            "</script>"})
    int insert(StockAdrCount entity);

    @Update({"<script>",
            "update stock_adr_count",
            "  <set>",
            "    <if test='f2 != null'>f2=#{f2},</if>",
            "    <if test='f3 != null'>f3=#{f3},</if>",
            "    <if test='f4 != null'>f4=#{f4},</if>",
            "    <if test='f5 != null'>f5=#{f5},</if>",
            "    <if test='f6 != null'>f6=#{f6},</if>",
            "    <if test='f7 != null'>f7=#{f7},</if>",
            "    <if test='f8 != null'>f8=#{f8},</if>",
            "    <if test='f9 != null'>f9=#{f9},</if>",
            "    <if test='f10 != null'>f10=#{f10},</if>",
            "    <if test='f15 != null'>f15=#{f15},</if>",
            "    <if test='f16 != null'>f16=#{f16},</if>",
            "    <if test='f17 != null'>f17=#{f17},</if>",
            "    <if test='f18 != null'>f18=#{f18},</if>",
            "    <if test='f20 != null'>f20=#{f20},</if>",
            "    <if test='f21 != null'>f21=#{f21},</if>",
            "    <if test='f62 != null'>f62=#{f62},</if>",
            "    <if test='f139 != null'>f139=#{f139},</if>",
            "    <if test='type_name != null'>type_name=#{type_name},</if>",
            "    <if test='order_num != null'>order_num=#{order_num},</if>",
            "    <if test='conception != null'>conception=#{conception},</if>",
            "    <if test='ADR_UP_COUNT_1 != null'>ADR_UP_COUNT_1=#{ADR_UP_COUNT_1},</if>",
            "    <if test='ADR_UP_COUNT_2 != null'>ADR_UP_COUNT_2=#{ADR_UP_COUNT_2},</if>",
            "    <if test='ADR_UP_COUNT_3 != null'>ADR_UP_COUNT_3=#{ADR_UP_COUNT_3},</if>",
            "    <if test='ADR_UP_COUNT_5 != null'>ADR_UP_COUNT_5=#{ADR_UP_COUNT_5},</if>",
            "    <if test='ADR_UP_COUNT_10 != null'>ADR_UP_COUNT_10=#{ADR_UP_COUNT_10},</if>",
            "    <if test='ADR_UP_COUNT_20 != null'>ADR_UP_COUNT_20=#{ADR_UP_COUNT_20},</if>",
            "    <if test='ADR_UP_COUNT_40 != null'>ADR_UP_COUNT_40=#{ADR_UP_COUNT_40},</if>",
            "    <if test='ADR_UP_COUNT_60 != null'>ADR_UP_COUNT_60=#{ADR_UP_COUNT_60},</if>",
            "    <if test='ADR_UP_COUNT_SUM_60 != null'>ADR_UP_COUNT_SUM_60=#{ADR_UP_COUNT_SUM_60},</if>",
            "    <if test='UP_MA_5 != null'>UP_MA_5=#{UP_MA_5},</if>",
            "    <if test='UP_MA_15 != null'>UP_MA_15=#{UP_MA_15},</if>",
            "    <if test='UP_MA_30 != null'>UP_MA_30=#{UP_MA_30},</if>",
            "    <if test='UP_MA_60 != null'>UP_MA_60=#{UP_MA_60},</if>",
            "    <if test='UP_MA_101 != null'>UP_MA_101=#{UP_MA_101},</if>",
            "    <if test='UP_MA_102 != null'>UP_MA_102=#{UP_MA_102},</if>",
            "    <if test='MA_NET_60_5 != null'>MA_NET_60_5=#{MA_NET_60_5},</if>",
            "    <if test='MA_NET_60_15 != null'>MA_NET_60_15=#{MA_NET_60_15},</if>",
            "    <if test='MA_NET_60_30 != null'>MA_NET_60_30=#{MA_NET_60_30},</if>",
            "    <if test='MA_NET_60_60 != null'>MA_NET_60_60=#{MA_NET_60_60},</if>",
            "    <if test='MA_NET_60_101 != null'>MA_NET_60_101=#{MA_NET_60_101},</if>",
            "    <if test='MA_NET_60_102 != null'>MA_NET_60_102=#{MA_NET_60_102},</if>",
            "    <if test='NET_AREA_DAY_5 != null'>NET_AREA_DAY_5=#{NET_AREA_DAY_5},</if>",
            "    <if test='NET_AREA_DAY_10 != null'>NET_AREA_DAY_10=#{NET_AREA_DAY_10},</if>",
            "    <if test='NET_AREA_DAY_20 != null'>NET_AREA_DAY_20=#{NET_AREA_DAY_20},</if>",
            "    <if test='NET_AREA_DAY_40 != null'>NET_AREA_DAY_40=#{NET_AREA_DAY_40},</if>",
            "    <if test='NET_AREA_DAY_60 != null'>NET_AREA_DAY_60=#{NET_AREA_DAY_60},</if>",
            "    <if test='NET_AREA_DAY_120 != null'>NET_AREA_DAY_120=#{NET_AREA_DAY_120},</if>",
            "    <if test='NET_AREA_DAY_250 != null'>NET_AREA_DAY_250=#{NET_AREA_DAY_250},</if>",
            "    <if test='UPDATE_TIME != null'>UPDATE_TIME=#{UPDATE_TIME},</if>",
            "    <if test='ADR_UP_SUM_1_1 != null'>ADR_UP_SUM_1_1=#{ADR_UP_SUM_1_1},</if>",
            "    <if test='ADR_UP_SUM_1_2 != null'>ADR_UP_SUM_1_2=#{ADR_UP_SUM_1_2},</if>",
            "    <if test='ADR_UP_SUM_1_3 != null'>ADR_UP_SUM_1_3=#{ADR_UP_SUM_1_3},</if>",
            "    <if test='ADR_UP_SUM_1_5 != null'>ADR_UP_SUM_1_5=#{ADR_UP_SUM_1_5},</if>",
            "    <if test='ADR_UP_SUM_1_10 != null'>ADR_UP_SUM_1_10=#{ADR_UP_SUM_1_10},</if>",
            "    <if test='ADR_UP_SUM_1_20 != null'>ADR_UP_SUM_1_20=#{ADR_UP_SUM_1_20},</if>",
            "    <if test='ADR_UP_SUM_1_40 != null'>ADR_UP_SUM_1_40=#{ADR_UP_SUM_1_40},</if>",
            "    <if test='ADR_UP_SUM_20_40 != null'>ADR_UP_SUM_20_40=#{ADR_UP_SUM_20_40},</if>",
            "    <if test='ADR_UP_SUM_40_60 != null'>ADR_UP_SUM_40_60=#{ADR_UP_SUM_40_60},</if>",
            "    <if test='ADR_UP_SUM_1_60 != null'>ADR_UP_SUM_1_60=#{ADR_UP_SUM_1_60},</if>",
            "    <if test='ADR_UP_SUM_ORDER_1_5 != null'>ADR_UP_SUM_ORDER_1_5=#{ADR_UP_SUM_ORDER_1_5},</if>",
            "    <if test='ADR_UP_SUM_ORDER_1_10 != null'>ADR_UP_SUM_ORDER_1_10=#{ADR_UP_SUM_ORDER_1_10},</if>",
            "    <if test='ADR_UP_SUM_ORDER_1_20 != null'>ADR_UP_SUM_ORDER_1_20=#{ADR_UP_SUM_ORDER_1_20},</if>",
            "    <if test='ADR_UP_SUM_ORDER_20_40 != null'>ADR_UP_SUM_ORDER_20_40=#{ADR_UP_SUM_ORDER_20_40},</if>",
            "    <if test='ADR_UP_SUM_ORDER_40_60 != null'>ADR_UP_SUM_ORDER_40_60=#{ADR_UP_SUM_ORDER_40_60},</if>",
            "    <if test='ADR_UP_SUM_ORDER_1_60 != null'>ADR_UP_SUM_ORDER_1_60=#{ADR_UP_SUM_ORDER_1_60},</if>",
            "    <if test='ADR_UP_COUNT_SUM_1_60 != null'>ADR_UP_COUNT_SUM_1_60=#{ADR_UP_COUNT_SUM_1_60},</if>",
            "  </set>",
            "where date=#{date} AND f12=#{f12}",
            "</script>"})
    void update(StockAdrCount entity);

    @Select({"<script>",
            "   SELECT ",
            "       * ",
            "   FROM stock_adr_count ",
            "   WHERE 1=1  ",
            "       AND date = #{date}  ",
//            "       AND conception LIKE CONCAT('%',#{conception},'%')",
            "       <if test='f20 != null'> ",
            "       AND f20 >= #{f20} ",
            "       </if> ",
            "       <if test='type_name != null'> ",
            "       AND type_name = #{type_name} ",
            "       </if> ",
            "       <if test='order_num != null'> ",
            "       AND order_num = #{order_num} ",
            "       </if> ",
            "       <if test='orderNumList != null'> ",
            "           AND stock_adr_count.order_num IN  ",
            "           <foreach collection='orderNumList' item='item' open='(' separator=',' close=')'>  ",
            "               #{item} ",
            "           </foreach> ",
            "       </if> ",
            "       <if test='bizList != null'> ",
            "           AND stock_adr_count.type_name IN  ",
            "           <foreach collection='bizList' item='item' open='(' separator=',' close=')'>  ",
            "               #{item} ",
            "           </foreach> ",
            "       </if> ",
            "       <if test='stCodeList != null'> ",
            "           AND stock_adr_count.f12 IN  ",
            "           <foreach collection='stCodeList' item='item' open='(' separator=',' close=')'>  ",
            "               #{item} ",
            "           </foreach> ",
            "       </if> ",
            "       <if test='ADR_UP_SUM_1_60 != null'> ",
            "       <![CDATA[ AND ADR_UP_SUM_1_60 >= #{ADR_UP_SUM_1_60} ]]> ",
            "       </if> ",
            "       <if test='ADR_UP_SUM_1_40 != null'> ",
            "       <![CDATA[ AND ADR_UP_SUM_1_40 >= #{ADR_UP_SUM_1_40} ]]> ",
            "       </if> ",
            "       <if test='ADR_UP_SUM_40_60 != null'> ",
            "       <![CDATA[ AND ADR_UP_SUM_40_60 >= #{ADR_UP_SUM_40_60} ]]> ",
            "       </if> ",
            "       <if test='ADR_UP_SUM_20_40 != null'> ",
            "       <![CDATA[ AND ADR_UP_SUM_20_40 >= #{ADR_UP_SUM_20_40} ]]> ",
            "       </if> ",

            "       <if test='ADR_UP_COUNT_SUM_60 != null'> ",
            "       <![CDATA[ AND ADR_UP_COUNT_SUM_60 >= #{ADR_UP_COUNT_SUM_60} ]]> ",
            "       </if> ",
            "       <if test='adrUpSumOrder1to60Min != null'> ",
            "       <![CDATA[ AND ADR_UP_SUM_ORDER_1_60 >= #{adrUpSumOrder1to60Min} ]]> ",
            "       </if> ",
            "       <if test='adrUpSumOrder1to60Max != null'> ",
            "       <![CDATA[ AND ADR_UP_SUM_ORDER_1_60 <= #{adrUpSumOrder1to60Max} ]]> ",
            "       </if> ",
            "       <if test='adrUpSumOrder1to60NotNull != null and adrUpSumOrder1to60NotNull==true '> ",
            "       AND ADR_UP_SUM_ORDER_1_60 IS NOT NULL",
            "       </if> ",
            "       <if test='UP_MA_5 != null'> ",
            "       <![CDATA[ AND MA_NET_60_5 = #{UP_MA_5} ]]> ",
            "       </if> ",
            "       <if test='UP_MA_15 != null'> ",
            "       <![CDATA[ AND UP_MA_15 = #{UP_MA_15} ]]> ",
            "       </if> ",
            "       <if test='UP_MA_30 != null'> ",
            "       <![CDATA[ AND UP_MA_30 = #{UP_MA_30} ]]> ",
            "       </if> ",
            "       <if test='UP_MA_60 != null'> ",
            "       <![CDATA[ AND UP_MA_60 = #{UP_MA_60} ]]> ",
            "       </if> ",
            "       <if test='UP_MA_101 != null'> ",
            "       <![CDATA[ AND UP_MA_101 = #{UP_MA_101} ]]> ",
            "       </if> ",
            "       <if test='UP_MA_102 != null'> ",
            "       <![CDATA[ AND UP_MA_102 = #{UP_MA_102} ]]> ",
            "       </if> ",
            "       <if test='upMaKltOrList != null'> ",
            "           <foreach collection='upMaKltOrList' index='index' item='item' open='AND (' separator='OR' close=')'>  ",
            "               <if test='upMaKltOrList[index] != null and upMaKltOrList[index]==\"102(60)\" '> ",
            "               UP_MA_102 = '102(60)' ",
            "               </if> ",
            "               <if test='upMaKltOrList[index] != null and upMaKltOrList[index]==\"101(60)\" '> ",
            "               UP_MA_101 = '101(60)' ",
            "               </if> ",
            "               <if test='upMaKltOrList[index] != null and upMaKltOrList[index]==\"60(60)\" '> ",
            "               UP_MA_60 = '60(60)' ",
            "               </if> ",
            "               <if test='upMaKltOrList[index] != null and upMaKltOrList[index]==\"30(60)\" '> ",
            "               UP_MA_60 = '30(60)' ",
            "               </if> ",
            "               <if test='upMaKltOrList[index] != null and upMaKltOrList[index]==\"15(60)\" '> ",
            "               UP_MA_60 = '15(60)' ",
            "               </if> ",
            "           </foreach> ",
            "       </if> ",

            "       <if test='mvMin != null'> ",
            "       <![CDATA[ AND f20 >= #{mvMin} ]]> ",
            "       </if> ",
            "       <if test='mvMax != null'> ",
            "       <![CDATA[ AND f20 <= #{mvMax} ]]> ",
            "       </if> ",
            "       <if test='minMa60Up102 != null'> ",
            "       <![CDATA[ AND f2 >= MA_NET_60_102 ]]> ",
            "       </if> ",
            "       <if test='maxMa60Up102 != null'> ",
            "       <![CDATA[ AND f2 <= MA_NET_60_102 ]]> ",
            "       </if> ",
            "       <if test='maxNetAreaDay5 != null'> ",
            "       <![CDATA[ AND NET_AREA_DAY_5 <= #{maxNetAreaDay5} ]]> ",
            "       </if> ",
            "       <if test='maxNetAreaDay10 != null'> ",
            "       <![CDATA[ AND NET_AREA_DAY_10 <= #{maxNetAreaDay10} ]]> ",
            "       </if> ",
            "       <if test='maxNetAreaDay20 != null'> ",
            "       <![CDATA[ AND NET_AREA_DAY_20 <= #{maxNetAreaDay20} ]]> ",
            "       </if> ",
            "       <if test='maxNetAreaDay40 != null'> ",
            "       <![CDATA[ AND NET_AREA_DAY_40 <= #{maxNetAreaDay40} ]]> ",
            "       </if> ",
            "       <if test='maxNetAreaDay60 != null'> ",
            "       <![CDATA[ AND NET_AREA_DAY_60 <= #{maxNetAreaDay60} ]]> ",
            "       </if> ",

            "       <if test='f10Min != null'> ",
            "       <![CDATA[ AND f10 >= #{f10Min} ]]> ",
            "       </if> ",
            "       <if test='f10Max != null'> ",
            "       <![CDATA[ AND f10 <= #{f10Max} ]]> ",
            "       </if> ",

            "       <if test='orderBy != null '> ",
            "        ORDER BY  ${orderBy} ",
            "       </if> ",
            "       <if test='limitCount != null '> ",
            "        LIMIT #{limitCount} ",
            "       </if> ",
            "</script>"})
    List<StockAdrCountVo> listStAdrCount(CondStockAdrCount condition);

    /**
     * @param condition
     * @return
     */
    @Select("select * from stock_adr_count where f12=#{f12} AND date = #{date}")
    StockAdrCount findByCondition(StockAdrCount condition);

    @Delete({"<script>",
            "DELETE FROM `stock_adr_count` WHERE 1=1 ",
            "   AND date = #{date}  ",
            "   <if test='f12 != null'> ",
            "   AND f12=#{f12} ",
            "   </if> ",
            "   <if test='type_name != null'> ",
            "   AND type_name = #{type_name} ",
            "   </if> ",
            "</script>"})
    int deleteByCondition(StockAdrCount condition);

    @Delete({"<script>",
            "DELETE FROM `stock_adr_count` WHERE `date` = #{date} LIMIT 9999 ",
            "</script>"})
    int deleteByDate(String date);

}
