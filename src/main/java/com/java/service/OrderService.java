package com.java.service;

import com.java.pojo.GoodsType;
import com.java.pojo.OrderBaseTable;
import com.java.util.DataGridViewResult;
import com.java.vo.OrderSearchVo;
import com.java.vo.PageVo;

public interface OrderService {

    DataGridViewResult list(PageVo pageVo);
    int insertOrder(Integer busertable_id, Integer shoppingnum, Integer goodstable_id);
    int updateOrder(OrderBaseTable orderBaseTable);
    int deleteOrder(Integer id);
    DataGridViewResult findById(Integer id);
    DataGridViewResult orderSearch(OrderSearchVo orderSearchVo);
}
