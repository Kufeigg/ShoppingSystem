package com.java.controller

import com.alibaba.fastjson.JSON
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.java.pojo.Goodstable
import com.java.service.GoodsService
import com.java.util.DataGridViewResult
import com.java.util.SystemConstant
import com.java.vo.GoodVo
import com.sun.xml.internal.fastinfoset.util.StringArray
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.annotation.Resource
import javax.print.attribute.IntegerSyntax

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/10
 */
@RestController
@RequestMapping("/admin/goods")
class GoodsController {
    @Resource
    private val goodsService: GoodsService? = null

    /**
     * 分页查询商品
     *
     * @param goodVo
     * @return
     */
    @RequestMapping("/list")
    fun list(goodVo: GoodVo): DataGridViewResult {
        /*
        设置分页
         */
        PageHelper.startPage<Any>(goodVo.page!!, goodVo.limit!!)
        val goodsByPage = goodsService!!.findGoodsByPage(goodVo)
        val pageInfo = PageInfo(goodsByPage)
        return DataGridViewResult(pageInfo.total, pageInfo.list)
}

    @RequestMapping("/insert")
    fun goodsInsert(goods:Goodstable): String {
        val map: MutableMap<String, Boolean> = HashMap()
        map[SystemConstant.SUCCESS] = goodsService!!.insertGoods(goods)>0
        return JSON.toJSONString(map)
    }

    @RequestMapping("/search")
    fun goodSearch(gName: String?) :String{
        val goodsMessage=goodsService!!.findGoodsByName(gName)
        print(goodsMessage)
        return JSON.toJSONString(goodsMessage)
    }

    @RequestMapping("/update")
    fun goodUpdate(goods:Goodstable) : String{
        val map: MutableMap<String, Boolean> = HashMap()
        map[SystemConstant.SUCCESS] = goodsService!!.goodUpdate(goods)>0

        return JSON.toJSONString(map);
    }

    /**
     * 查询单个商品
     *
     * @param goodVo
     * @return
     */
    @RequestMapping("/findById")
    fun list(id: Int?): DataGridViewResult {

        val goodsByPage = goodsService!!.findById(id)
        return DataGridViewResult(goodsByPage)
    }

    @RequestMapping("/delete")
    fun goodDelete(id: Int?=null) : String{
        val map: MutableMap<String, Boolean> = HashMap()
        map[SystemConstant.SUCCESS] = goodsService!!.deleteById(id)>0

        return JSON.toJSONString(map);
    }

    @RequestMapping("/batchDelete")
    fun batchDelete(str: String?=null) : String{
        val map: MutableMap<String, Boolean> = HashMap()
        if (str!=null) {
           var list= str.split(",")
            list.forEach {
                var id=it.toInt()
                map[SystemConstant.SUCCESS] = goodsService!!.deleteById(id)>0
            }
        }
        return JSON.toJSONString(map);
    }
}