package com.example.mapper;

import com.example.entity.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminMapper {

    @Insert("insert into admin(username, password, name, phone, email) values(#{username}, #{password}, #{name}, #{phone}, #{email})")
    void insert(Admin admin);

    List<Admin> selectAll(Admin admin);

    @Update("update admin set username=#{username}, password=#{password}, name=#{name}, phone=#{phone}, email=#{email} where id=#{id}")
    void updateById(Admin admin);
    @Delete("delete from admin where id=#{id}")
    void deleteById(Integer id);
    @Select("select * from admin where username=#{username} and password=#{password}")
    Admin selectByUsernameAndPassword(Admin admin);
}
