package com.java.controller

import com.alibaba.fastjson.JSON
import com.java.service.UserService
import com.java.util.SystemConstant
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.HashMap
import javax.annotation.Resource
import javax.servlet.http.HttpSession

/**
 * @Description
 * @Author  sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/21
 */
@RestController
@RequestMapping("/shop")
class UserLogin {
    @Resource
    val userService:UserService?=null

    @RequestMapping("/login",method =[RequestMethod.POST] )
    fun login(bemail: String,bpwd:String,session: HttpSession):String{


        val map: MutableMap<String, Boolean> = HashMap()
        val count=userService!!.login(bemail,bpwd)
        if(count!=null){
            map[SystemConstant.SUCCESS] = true
            session.setAttribute(SystemConstant.LOGINUSER, count)
        }else map[SystemConstant.SUCCESS] = false
        return JSON.toJSONString(map)
    }
}