package com.java.dao;


import com.java.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeDao {


    List<GoodsType> list();

    GoodsType getById(Integer id);

    int save(GoodsType goodsType);

    int update(GoodsType goodsType);

    int delete(Integer id);
}
