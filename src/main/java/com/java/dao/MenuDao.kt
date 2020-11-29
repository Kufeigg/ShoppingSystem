package com.java.dao

import com.java.pojo.SystemMenuEntity

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/5
 */
interface MenuDao {
    /**
     * 查询所有菜单列表
     * @return
     */
    fun findMenuList(): List<SystemMenuEntity?>?
}