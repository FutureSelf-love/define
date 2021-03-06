package cn.main.mybatis.utils;

import cn.main.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtil {
    public static Connection getConnection(Configuration cfg){
        try{
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
