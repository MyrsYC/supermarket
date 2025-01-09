package com.example.mapper;

import com.example.entity.Goods;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface GoodsMapper {

    @Insert("insert into goods (name, price,img, count, supplier_id,category_id) values(#{name}, #{price}, #{img}, #{count}, #{supplierId},#{categoryId})")
    void insert(Goods goods);

    List<Goods> selectAll(Goods goods);

    void updateById(Goods goods);
    @Delete("delete from goods where id=#{id}")
    void deleteById(Integer id);
}
