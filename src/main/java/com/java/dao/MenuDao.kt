package com.java.dao

import com.java.pojo.SystemMenuEntity


interface MenuDao {
    /**
     * 查询所有菜单列表
     * @return
     */
    fun findMenuList(): List<SystemMenuEntity?>?
}