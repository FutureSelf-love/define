package cn.main.mybatis.SqlSession.proxy;
import cn.main.mybatis.cfg.Mapper;
import cn.main.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers,Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodname = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className+"."+methodname;
        Mapper mapper = mappers.get(key);
        if(mapper == null){
            throw new IllegalArgumentException("传入的参数有误！");
        }
        return new Executor().selectList(mapper,conn);
    }
}
