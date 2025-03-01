package ttjj.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import ttjj.db.EtfAdrCount;
import ttjj.dto.CondStockAdrCount;
import ttjj.dto.EtfAdrCountVo;

import java.util.List;

public class EtfAdrCountDao {
    /**
     * sqlSessionFactory mybatis
     */
    static SqlSessionFactory sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();

    /**
     * db-插入
     *
     * @param entity
     */
    public static int insert(EtfAdrCount entity) {
        SqlSession session = sqlSessionFactory.openSession();
        int rs = 0;
        try {
            rs = session.insert("ttjj.dao.mapper.EtfAdrCountMapper.insert", entity);
            session.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * 更新
     * @param entity 更新内容和条件
     * @return 结果
     */
    public static int update(EtfAdrCount entity) {
        SqlSession session = sqlSessionFactory.openSession();
        int rs = 0;
        try {
            rs = session.update("ttjj.dao.mapper.EtfAdrCountMapper.update", entity);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     *
     * @param condition
     * @return
     */
    public static EtfAdrCount findByCondition(EtfAdrCount condition) {
        SqlSession session = sqlSessionFactory.openSession();
        EtfAdrCount rs = null;
        try {
            rs = session.selectOne("ttjj.dao.mapper.EtfAdrCountMapper.findByCondition", condition);
            session.commit();
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * 查询列表-根据条件
     * @param condition
     * @return
     */
    public static List<EtfAdrCountVo> listStAdrCount(CondStockAdrCount condition) {
        SqlSession session = sqlSessionFactory.openSession();
        List<EtfAdrCountVo> rs = null;
        try {
            rs = session.selectList("ttjj.dao.mapper.EtfAdrCountMapper.listStAdrCount", condition);
            session.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     * 删除-根据条件
     * @param condition 条件
     * @return 删除个数
     */
    public static int deleteByCondition(EtfAdrCount condition) {
        SqlSession session = sqlSessionFactory.openSession();
        int rs = 0;
        try {
            rs = session.delete("ttjj.dao.mapper.EtfAdrCountMapper.deleteByCondition", condition);
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
     * @param date
     * @return
     */
    public static int deleteByDate(String date) {
        SqlSession session = sqlSessionFactory.openSession();
        int rs = 0;
        try {
            rs = session.delete("ttjj.dao.mapper.EtfAdrCountMapper.deleteByDate", date);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return rs;
    }
}
