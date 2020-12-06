package com.java.controller;


import com.java.pojo.GoodsType;
import com.java.service.GoodsTypeService;
import com.java.util.DataGridViewResult;
import com.java.vo.GoodsTypePageVo;
import com.java.vo.GoodsTypeUpdateVo;
import com.java.vo.IdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author VernZTL
 * @ClassName GoodsTypeController.java
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月06日 21:08:00
 */
@RestController
@RequestMapping("/admin/goodstype")
public class GoodsTypeController {

    @Resource
    private GoodsTypeService goodsTypeService;

    /**
     * 列表分页
     */
    @RequestMapping("/list")
    public DataGridViewResult list() {

        return goodsTypeService.list();
    }

    /**
     * 列表分页
     */
    @RequestMapping("/listPage")
    public DataGridViewResult listPage(@RequestBody GoodsTypePageVo goodsTypePageVo) {

        return goodsTypeService.listPage(goodsTypePageVo);
    }

    /**
     * 查单条记录
     */
    @RequestMapping("/getById")
    public DataGridViewResult getById(@RequestBody IdVo idVo) {

        return goodsTypeService.getById(idVo);
    }

    /**
     * 新增
     */
    @RequestMapping("/save")
    public DataGridViewResult save(@RequestBody GoodsType goodsType) {


        return goodsTypeService.save(goodsType);
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public DataGridViewResult update(@RequestBody GoodsType goodsType) {


        return goodsTypeService.update(goodsType);
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public DataGridViewResult delete(@RequestBody Integer[] idVos) {


        return goodsTypeService.delete(idVos);
    }

}
