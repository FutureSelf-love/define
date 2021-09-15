package cn.main.mybatis.SqlSession.defaults;

import cn.main.mybatis.SqlSession.SqlSession;
import cn.main.mybatis.SqlSession.proxy.MapperProxy;
import cn.main.mybatis.cfg.Configuration;
import cn.main.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;

public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;
    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection));
        return null;
    }
    @Override
    public void close() {
        if(connection!=null){
            try {
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
