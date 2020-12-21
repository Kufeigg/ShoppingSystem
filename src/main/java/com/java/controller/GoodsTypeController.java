package com.java.controller;


import com.alibaba.fastjson.JSON;
import com.java.pojo.GoodsType;
import com.java.service.GoodsTypeService;
import com.java.util.DataGridViewResult;
import com.java.util.SystemConstant;
import com.java.vo.GoodsTypePageVo;
import com.java.vo.GoodsTypeUpdateVo;
import com.java.vo.IdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
     * 查单条记录
     */
    @RequestMapping("/getById")
    public DataGridViewResult getById( Integer id) {
        return goodsTypeService.findById(id);
    }

    /**
     * update
     */
    @RequestMapping("/update")
    public String update( GoodsType goodsType) {
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        if (goodsTypeService.update(goodsType)>0){
            map.put(SystemConstant.SUCCESS,true);
        }else{
            map.put(SystemConstant.SUCCESS,false);
        }
       return JSON.toJSONString(map);
    }




}
