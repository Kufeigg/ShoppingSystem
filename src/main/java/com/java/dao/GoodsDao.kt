package com.java.dao

import com.java.pojo.Goodstable
import com.java.vo.GoodVo
import org.apache.ibatis.annotations.Param


interface GoodsDao {
    fun findGoodsByPage(goodVo: GoodVo?): List<Goodstable?>?
    fun findGoodsByName(@Param("gName") gcName: String?):List<Goodstable?>?
    fun insertGoods(goods: Goodstable?):Int
    fun findById(id: Int?=null): Goodstable
    fun deleteById(id: Int?=null): Int
}