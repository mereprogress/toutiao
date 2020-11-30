package com.example.toutiao.dao;

import com.example.toutiao.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    String FIELDS="id,name,password,salt,headUrl";
    String TABLE="user";

    User get(User user);//通过name id 选择查询
    void insert(User user); //id不用注入，
    void updateUser(User user);//必须传入id,其他可以选择传入，会更改表数据

    @Select(value = {"select ",FIELDS," from ",TABLE," where id=#{id}"})
    User getById(Integer id);
}
