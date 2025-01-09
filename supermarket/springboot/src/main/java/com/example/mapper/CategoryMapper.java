package com.example.mapper;

import com.example.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("insert into category(name, content) values(#{name}, #{content})")
    void insert(Category category);


    List<Category> selectAll(Category category);

    void updateById(Category category);

    @Delete("delete from category where id=#{id}")
    void deleteById(Integer id);
}
