package com.itheima.ssm.dao;

import  com.itheima.ssm.domain.Items;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ItemsDao {
    @Select("select * from items")
    List<Items> findAllItems();

    @Select("select * from items where id = #{id}")
    Items findAllItemById(Integer id);

    @Update("update items set name = #{name},price = #{price},pic = #{pic},createtime = #{createtime},detail = #{detail} where id = #{id}")
    void updateItems(Items items);
}
