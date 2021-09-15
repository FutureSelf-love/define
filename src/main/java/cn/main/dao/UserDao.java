package cn.main.dao;

import cn.main.domain.User;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
//    @Select("select * from user")
    public List<User> findAll();
}
