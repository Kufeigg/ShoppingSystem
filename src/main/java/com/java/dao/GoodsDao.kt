package com.java.dao

import com.java.pojo.Goodstable
import com.java.vo.GoodVo
import org.apache.ibatis.annotations.Param
import sun.jvm.hotspot.gc_interface.GCName

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/10
 */
interface GoodsDao {
    fun findGoodsByPage(goodVo: GoodVo?): List<Goodstable?>?
    fun findGoodsByName(@Param("gName") gcName: String?):List<Goodstable?>?
    fun insertGoods(goods: Goodstable?):Int
}