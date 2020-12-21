package com.java.service;

import com.java.pojo.GoodsType;
import com.java.util.DataGridViewResult;
import com.java.vo.GoodsTypePageVo;
import com.java.vo.GoodsTypeUpdateVo;
import com.java.vo.IdVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author VernZTL
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月06日 21:08:00
 */
public interface GoodsTypeService {

    DataGridViewResult list();

    int insert(GoodsType goodsType);
    int deleteById(@Param("id") int id);
    int update(GoodsType goodsType);
    DataGridViewResult findById(@Param("id") int id);

}
