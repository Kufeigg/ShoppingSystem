package com.java.service

import com.java.dao.GoodsDao
import com.java.pojo.Goodstable
import com.java.vo.GoodVo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/10
 */
@Service
@Transactional
open class GoodsServiceImpl : GoodsService {
    @Resource
    private val goodsDao: GoodsDao? = null
    override fun findGoodsByPage(goodVo: GoodVo?): List<Goodstable?>? {
        return goodsDao!!.findGoodsByPage(goodVo)
    }




    override fun findGoodsByName(name: String?): List<Goodstable?>? {
        return goodsDao!!.findGoodsByName(name)
    }

    override fun insertGoods(goods: Goodstable?): Int {
        return goodsDao!!.insertGoods(goods)
    }

    override fun findById(id: Int?): Goodstable {
        return goodsDao!!.findById(id);
    }

    override fun deleteById(id: Int?): Int {
        return goodsDao!!.deleteById(id);
    }


}