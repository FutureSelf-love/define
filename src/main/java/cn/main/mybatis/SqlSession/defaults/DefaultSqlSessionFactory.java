package cn.main.mybatis.SqlSession.defaults;

import cn.main.mybatis.SqlSession.SqlSession;
import cn.main.mybatis.SqlSession.SqlSessionFactory;
import cn.main.mybatis.SqlSession.SqlSessionFactoryBuilder;
import cn.main.mybatis.cfg.Configuration;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
