package com.java.dao

import com.java.pojo.Goodstable
import com.java.vo.GoodVo
import org.apache.ibatis.annotations.Param


interface GoodsDao {
    fun findGoodsByPage(goodVo: GoodVo?): List<Goodstable?>?
    fun findGoodsByName(@Param("gName") gcName: String?):List<Goodstable?>?
    fun insertGoods(goods: Goodstable?):Int
    fun findById(@Param("id")id: Int?): Goodstable
    fun deleteById(@Param("id")id: Int?): Int
    fun goodUpdate(goods: Goodstable?): Int
}