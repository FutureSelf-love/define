package cn.main.mybatis.SqlSession;

import cn.main.mybatis.SqlSession.defaults.DefaultSqlSessionFactory;
import cn.main.mybatis.cfg.Configuration;
import cn.main.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory bulid(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
