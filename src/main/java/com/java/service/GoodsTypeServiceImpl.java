package com.java.service;

import com.java.dao.GoodsDao;
import com.java.dao.GoodsTypeDao;
import com.java.pojo.GoodsType;
import com.java.util.DataGridViewResult;
import com.java.vo.GoodsTypePageVo;
import com.java.vo.GoodsTypeUpdateVo;
import com.java.vo.IdVo;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author VernZTL
 * @ClassName GoodsTypeServiceImpl.java
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月06日 22:16:00
 */
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Resource
    private GoodsTypeDao goodsTypeDao;

    @Override
    public DataGridViewResult list() {

        List<GoodsType> goodsType = goodsTypeDao.list();

        return new DataGridViewResult(goodsType);
    }

    @Override
    public DataGridViewResult listPage(GoodsTypePageVo goodsTypePageVo) {
        return null;
    }

    @Override
    public DataGridViewResult getById(IdVo idVo) {
        return null;
    }

    @Override
    public DataGridViewResult save(GoodsType goodsType) {
        return null;
    }

    @Override
    public DataGridViewResult update(GoodsTypeUpdateVo goodsTypeUpdateVo) {
        return null;
    }

    @Override
    public DataGridViewResult delete(IdVo idVo) {
        return null;
    }
}
