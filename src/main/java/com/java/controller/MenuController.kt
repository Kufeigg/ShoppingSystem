package com.java.controller

import com.alibaba.fastjson.JSON
import com.java.service.MenuService
import com.java.util.MenuNode
import com.java.util.TreeUtil
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.annotation.Resource

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/5
 */
@RestController
@RequestMapping("/admin/menu")
class MenuController {
    @Resource
    private val menuService: MenuService? = null

    /**
     * 加载左侧菜单导航
     *
     * @return
     */
    @RequestMapping(value = ["/loadMenuList"], produces = ["text/html;charset=UTF-8"])
    fun loadMenuList(): String {
        val map: MutableMap<String, Any> = LinkedHashMap()
        val homeInfo: MutableMap<String, Any> = LinkedHashMap()
        val logoInfo: MutableMap<String, Any> = LinkedHashMap()
        val menuEntityList = menuService!!.findMenuList()
        val menuNodeList: MutableList<MenuNode> = ArrayList()
        for ((id, pid, title, icon, href, target) in menuEntityList) {
            val menuNode = MenuNode()
            menuNode.href = href
            menuNode.icon = icon
            menuNode.id = id!!
            menuNode.pid = pid!!
            menuNode.target = target
            menuNode.title = title
            menuNodeList.add(menuNode)
        }
        map["menuInfo"] = TreeUtil.toTree(menuNodeList, 0)
        homeInfo["title"] = "首页"
        homeInfo["href"] = ""
        logoInfo["title"] = "商城后台"
        logoInfo["image"] = "/ShoppingSystem_war/statics/layui/images/logo.png"
        logoInfo["href"] = "/ShoppingSystem_war/admin/index"
        map["homeInfo"] = homeInfo
        map["logoInfo"] = logoInfo
        println(JSON.toJSONString(map))
        return JSON.toJSONString(map)
    }
}