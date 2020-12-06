package com.java.dao

import com.java.pojo.Goodstable
import com.java.vo.GoodVo
import org.apache.ibatis.annotations.Param
//import sun.jvm.hotspot.gc_interface.GCName


interface GoodsDao {
    fun findGoodsByPage(goodVo: GoodVo?): List<Goodstable?>?
    fun findGoodsByName(@Param("gName") gcName: String?):List<Goodstable?>?
    fun insertGoods(goods: Goodstable?):Int
    fun findById(id: Integer?): Goodstable
}