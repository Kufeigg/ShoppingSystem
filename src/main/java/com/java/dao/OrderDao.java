package com.java.dao;

import com.java.pojo.OrderBaseTable;
import com.java.pojo.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    List<Map<String, Object>> list();

    List<Map<String, Object>> orderSearch(String goodsName);

    OrderBaseTable findOrdertableById(@Param("id") Integer id);

    OrderDetail findDetailByTableId(@Param("id") Integer id);

    int deleteOrderById(@Param("id") Integer id);

    int deleteDetailById(@Param("id") Integer id);

    int insertOrderList(OrderBaseTable orderBaseTable);

    int insertOrderDetail(OrderDetail orderDetail);
}
