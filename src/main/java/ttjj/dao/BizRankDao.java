package ttjj.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ttjj.dto.BizDto;
import ttjj.dto.RankBizDataDiff;
import ttjj.dto.StatCondStAdrCountBiz;
import ttjj.dto.StatRsStAdrCountBiz;

import java.util.List;
import java.util.Map;

/**
 * @author chenzhilong
 * @date 2021/7/26
 */
public class BizRankDao {
    /**
     * sqlSessionFactory mybatis
     */
    static SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
    /**
     * 业务排行-插入
     *
     * @param rankBizDataDiffListBiz
     */
    public static int insertDbBiz(List<RankBizDataDiff> rankBizDataDiffListBiz) {
        SqlSession session = sqlSessionFactory.openSession();
        int rs = 0;
        long temp = 0;
        try {
            for (RankBizDataDiff rankBizDataDiff : rankBizDataDiffListBiz) {
//                System.out.println(JSON.toJSONString(rankBizDataDiff));
//                rankBizDataDiff.setRs("");
                rs = session.insert("ttjj.dao.mapper.RandBizEtfMapper.insertRandBizEtf", rankBizDataDiff);
                session.commit();
            }
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * @param rankBizDataDiffListBiz
     * @return
     */
    public static int updateEtfNet(RankBizDataDiff rankBizDataDiffListBiz) {
        SqlSession session = sqlSessionFactory.openSession();
        int rs = 0;
        try {
            rs = session.update("ttjj.dao.mapper.RandBizEtfMapper.updateEtfNet", rankBizDataDiffListBiz);
            session.commit();
        } finally {
            session.close();
        }
        return rs;
    }

    public static int updateDbEtfNetMaxMinTimeByDate(RankBizDataDiff rankBizDataDiffListBiz) {
        SqlSession session = sqlSessionFactory.openSession();
        int rs = 0;
        try {
            rs = session.update("ttjj.dao.mapper.RandBizEtfMapper.updateDbEtfNetMaxMinTimeByDate", rankBizDataDiffListBiz);
            session.commit();
        } finally {
            session.close();
        }
        return rs;
    }

    public static int updateDate(RankBizDataDiff entity) {
        SqlSession session = sqlSessionFactory.openSession();
        int rs = 0;
        try {
            rs = session.update("ttjj.dao.mapper.RandBizEtfMapper.updateDate", entity);
            session.commit();
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * 查询etf-从数据库中-最新的一条
     *
     * @param condition
     * @return
     */
    public static RankBizDataDiff findEtfLast(RankBizDataDiff condition) {
        SqlSession session = sqlSessionFactory.openSession();
        RankBizDataDiff rs = null;
        try {
            rs = session.selectOne("ttjj.dao.mapper.RandBizEtfMapper.findEtfLast", condition);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * 查询业务-根据条件：编码、日期、业务类型
     * @param condition 查询条件
     * @return 查询结果
     */
    public static RankBizDataDiff findBiz(RankBizDataDiff condition) {
        SqlSession session = sqlSessionFactory.openSession();
        RankBizDataDiff rs = null;
        try {
            rs = session.selectOne("ttjj.dao.mapper.RandBizEtfMapper.findBiz", condition);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * 列表查询-行业etf-排序：涨跌幅
     * @param condition
     * @return
     */
    public static List<RankBizDataDiff> listEtfBiz(Map<String, Object> condition) {
        SqlSession session = sqlSessionFactory.openSession();
        List<RankBizDataDiff> rs = null;
        try {
            rs = session.selectList("ttjj.dao.mapper.RandBizEtfMapper.listEtfBiz", condition);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * 查询列表-根据板块
     * @param condition
     * @return
     */
    public static List<BizDto> findListDbBiz(BizDto condition) {
        SqlSession session = sqlSessionFactory.openSession();
        List<BizDto> rs = null;
        try {
            rs = session.selectList("ttjj.dao.mapper.RandBizEtfMapper.findListDbBiz", condition);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * 删除-根据日期
     * @param entity
     * @return
     */
    public static int deleteByDate(RankBizDataDiff entity) {
        SqlSession session = sqlSessionFactory.openSession();
        int rs = 0;
        try {
            rs = session.delete("ttjj.dao.mapper.RandBizEtfMapper.deleteByDate", entity);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * 查询-涨跌次数
     * @param condition
     * @return
     */
    public static List<StatRsStAdrCountBiz> findListStatStAdrCount(StatCondStAdrCountBiz condition) {
        SqlSession session = sqlSessionFactory.openSession();
        List<StatRsStAdrCountBiz> rs = null;
        try {
//                System.out.println(JSON.toJSONString(condition));
            rs = session.selectList("ttjj.dao.mapper.RandBizEtfMapper.findListStatStAdrCount", condition);
            session.commit();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return rs;
    }
}
