package com.java.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.dao.GoodsDao;
import com.java.dao.GoodsTypeDao;
import com.java.pojo.GoodsType;
import com.java.util.DataGridViewResult;
import com.java.vo.GoodsTypePageVo;
import com.java.vo.GoodsTypeUpdateVo;
import com.java.vo.IdVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author VernZTL
 * @ClassName GoodsTypeServiceImpl.java
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月06日 22:16:00
 */
@Service
@Transactional
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Resource
    private GoodsTypeDao goodsTypeDao;

    /**
     * 列表
     */
    @Override
    public DataGridViewResult list() {

        List<GoodsType> goodsType = goodsTypeDao.list();

        return new DataGridViewResult(goodsType);
    }

    /**
     * 分页列表
     * @param goodsTypePageVo
     */
    @Override
    public DataGridViewResult listPage(GoodsTypePageVo goodsTypePageVo) {

        PageHelper.startPage(goodsTypePageVo.getPage(), goodsTypePageVo.getLimit());
        List<GoodsType> goodsType = goodsTypeDao.list();

        PageInfo<GoodsType> pageInfo = new PageInfo<>(goodsType);

        return new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 查单条
     * @param idVo
     * @return
     */
    @Override
    public DataGridViewResult getById(IdVo idVo) {

        GoodsType goodsType = goodsTypeDao.getById(idVo.getId());

        DataGridViewResult dataGridViewResult = new DataGridViewResult(goodsType);
        dataGridViewResult.setMsg("查询成功");

        return dataGridViewResult;
    }

    /**
     * 添加
     * @param goodsType
     * @return
     */
    @Override
    public DataGridViewResult save(GoodsType goodsType) {

        DataGridViewResult dataGridViewResult = new DataGridViewResult(goodsType);

        int result = goodsTypeDao.save(goodsType);
        dataGridViewResult.setMsg("添加成功");

        return dataGridViewResult;
    }

    /**
     * 修改 
     * @param goodsType
     * @return
     */
    @Override
    public DataGridViewResult update(GoodsType goodsType) {

        DataGridViewResult dataGridViewResult = new DataGridViewResult(goodsType);

        int result = goodsTypeDao.update(goodsType);

        dataGridViewResult.setMsg("修改成功");

        return dataGridViewResult;
    }

    @Override
    public DataGridViewResult delete(Integer[] idVos) {

        DataGridViewResult dataGridViewResult = new DataGridViewResult(null);

        Arrays.stream(idVos).forEach(id->{
            int result = goodsTypeDao.delete(id);
        });

        dataGridViewResult.setMsg("删除成功");

        return dataGridViewResult;
    }
}
