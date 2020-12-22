package com.java.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * @Description
 * @Author  sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/17
 */
@Controller
@RequestMapping("/shop")
class ShopBaseController {
    @RequestMapping("/index")
    fun index(): String {
        return "/shop/html/index"
    }
    @RequestMapping("/login")
    fun login():String{
        return "/shop/html/login"
    }
    @RequestMapping("/about")
    fun about():String{
        return "/shop/html/about"
    }
    @RequestMapping("/regist")
    fun regist():String{
        return "/shop/html/regist"
    }
}