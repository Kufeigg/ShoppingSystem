package com.java.service;
import java.util.Date;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.dao.OrderDao;
import com.java.pojo.Goodstable;
import com.java.pojo.OrderBaseTable;
import com.java.pojo.OrderDetail;
import com.java.util.DataGridViewResult;
import com.java.vo.OrderSearchVo;
import com.java.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author VernZTL
 * @ClassName orderServiceImpl.java
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月21日 20:35:00
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Autowired
    private GoodsService goodsService;

    @Override
    public DataGridViewResult list(PageVo pageVo) {
        PageHelper.startPage(pageVo.getPage(), pageVo.getLimit());
        List<Map<String, Object>> list = orderDao.list();
        list.stream().forEach(item-> {
            item.put("orderdate", item.get("orderdate").toString());
            if (item.get("status").equals(0)) {
                item.put("status", "未支付");
            } else {
                item.put("status", "已支付");
            }
        });
        PageInfo pageInfo = new PageInfo(list);
        return new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public int insertOrder(Integer busertable_id, Integer shoppingnum, Integer goodstable_id) {

        int result = 0;
        Goodstable byId = goodsService.findById(goodstable_id);

        OrderBaseTable orderBaseTable = new OrderBaseTable();
        orderBaseTable.setBusertable_id(busertable_id);
        orderBaseTable.setAmount(byId.getGRprice() * shoppingnum);
        orderBaseTable.setStatus(0);
        orderBaseTable.setOrderdate(new Date());

        if (orderDao.insertOrderList(orderBaseTable) > 0) {
            OrderDetail orderDetail =  new OrderDetail();
            orderDetail.setOrderbasetable_id(orderBaseTable.getId());
            orderDetail.setGoodstable_id(goodstable_id);
            orderDetail.setShoppingnum(shoppingnum);
            result = orderDao.insertOrderDetail(orderDetail);
        }

        return result;
    }

    @Override
    public int updateOrder(OrderBaseTable orderBaseTable) {
        return 0;
    }

    @Override
    public int deleteOrder(Integer id) {

        int result = 0;
        OrderBaseTable ordertableById = orderDao.findOrdertableById(id);
        OrderDetail detailByTableId = orderDao.findDetailByTableId(id);
        if (detailByTableId != null) {
            result = orderDao.deleteDetailById(detailByTableId.getId());
            if (result > 0) {
                if (ordertableById != null) {
                    result = orderDao.deleteOrderById(id) ;
                }
            }
        }
        return result;
    }

    @Override
    public DataGridViewResult findById(Integer id) {
        return new DataGridViewResult(orderDao.findDetailByTableId(id));
    }

    @Override
    public DataGridViewResult orderSearch(OrderSearchVo orderSearchVo) {

        PageHelper.startPage(orderSearchVo.getPage(), orderSearchVo.getLimit());
        List<Map<String, Object>> maps = orderDao.orderSearch(orderSearchVo.getName());
        PageInfo pageInfo = new PageInfo(maps);

        return new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
