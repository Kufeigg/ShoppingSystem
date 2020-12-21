package com.java.service;

import com.java.dao.GoodsDao;
import com.java.dao.GoodsTypeDao;
import com.java.pojo.GoodsType;
import com.java.util.DataGridViewResult;
import com.java.vo.GoodsTypePageVo;
import com.java.vo.GoodsTypeUpdateVo;
import com.java.vo.IdVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author VernZTL
 * @ClassName GoodsTypeServiceImpl.java
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月06日 22:16:00
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Resource
    private GoodsTypeDao goodsTypeDao;

    @Override
    public DataGridViewResult list() {

        List<GoodsType> goodsType = goodsTypeDao.list();

        return new DataGridViewResult(goodsType);
    }

    @Override
    public int insert(GoodsType goodsType) {
        return goodsTypeDao.insert(goodsType);
    }

    @Override
    public int deleteById(int id) {
        return goodsTypeDao.deleteById(id);
    }

    @Override
    public int update(GoodsType goodsType) {
        return goodsTypeDao.update(goodsType);
    }


    @Override
    public DataGridViewResult findById(int id) {

        List<GoodsType> goodsType = goodsTypeDao.findById(id);
        return new DataGridViewResult(goodsType);
    }

}
