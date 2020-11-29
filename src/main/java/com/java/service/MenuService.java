package com.java.service;

import com.java.pojo.SystemMenuEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/5
 */
public interface MenuService {
    List<SystemMenuEntity> findMenuList();
}
