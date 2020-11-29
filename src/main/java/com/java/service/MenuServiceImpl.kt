package com.java.service

import com.java.dao.MenuDao
import com.java.pojo.SystemMenuEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/5
 */
@Service
@Transactional
open class MenuServiceImpl : MenuService {
    @Resource
    private val menuDao: MenuDao? = null
    override fun findMenuList(): List<SystemMenuEntity> {
        return menuDao!!.findMenuList() as List<SystemMenuEntity>
    }
}