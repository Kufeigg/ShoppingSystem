package com.java.dao;

import com.java.pojo.GoodsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsTypeDao {

    List<GoodsType> list();
    int insert(GoodsType goodsType);
    int deleteById(@Param("id") int id);
    int update(GoodsType goodsType);
    List<GoodsType> findById(@Param("id") int id);

}
