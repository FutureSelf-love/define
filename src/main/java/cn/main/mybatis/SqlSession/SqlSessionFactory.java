package cn.main.mybatis.SqlSession;

public interface SqlSessionFactory {
    /**
     * 打开一个新的sqlSession对象
     *
     *
     */
    SqlSession openSession();
}
