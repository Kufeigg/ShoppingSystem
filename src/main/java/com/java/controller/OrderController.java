package com.java.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.java.pojo.OrderBaseTable;
import com.java.service.OrderService;
import com.java.util.DataGridViewResult;
import com.java.util.SystemConstant;
import com.java.vo.OrderSearchVo;
import com.java.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author VernZTL
 * @ClassName OrderController.java
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月20日 22:51:00
 */
@RestController
@RequestMapping("admin/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 列表分页
     */
    @RequestMapping("/list")
    public DataGridViewResult list(PageVo pageVo) {

        return orderService.list(pageVo);
    }

    /**
     * 查单条记录
     */
    @RequestMapping("/getById")
    public DataGridViewResult getById(Integer id) {
        return orderService.findById(id);
    }

    /**
     * 查单条记录
     */
    @RequestMapping("/orderSearch")
    public DataGridViewResult orderSearch(@RequestBody OrderSearchVo orderSearchVo) {
        return orderService.orderSearch(orderSearchVo);
    }

//    /**
//     * update
//     */
//    @RequestMapping("/updateOrderDetail")
//    public String update(OrderBaseTable orderBaseTable) {
//        Map<String,Boolean> map=new HashMap<String, Boolean>();
//        if (orderService.updateOrder(orderBaseTable)>0){
//            map.put(SystemConstant.SUCCESS,true);
//        }else{
//            map.put(SystemConstant.SUCCESS,false);
//        }
//        return JSON.toJSONString(map);
//    }

    /**
     * 下单
     * @param form
     * @return
     */
    @RequestMapping("/insert")
    public String insert(@RequestBody JSONObject form) {
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        if (orderService.insertOrder(form.getInteger("busertable_id"), form.getInteger("shoppingNum"), form.getInteger("goodstable_id"))>0){
            map.put(SystemConstant.SUCCESS,true);
        }else{
            map.put(SystemConstant.SUCCESS,false);
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/orderDelete")
    public String insert(Integer id) {
        Map<String,Boolean> map=new HashMap<String, Boolean>();
        if (orderService.deleteOrder(id)>0){
            map.put(SystemConstant.SUCCESS,true);
        }
        return JSON.toJSONString(map);
    }


}
