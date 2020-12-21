package com.java.controller

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.java.pojo.User
import com.java.service.UserService
import com.java.util.DataGridViewResult
import com.java.util.SystemConstant
import com.java.vo.UserVo
import org.apache.ibatis.annotations.Param
import org.springframework.web.bind.annotation.*
import java.util.HashMap
import javax.annotation.Resource
import javax.servlet.http.HttpSession

/**
 * @Description
 * @Author  sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/10
 */
@RestController
@RequestMapping("/admin/user")
class UserController {
    @Resource
    private val userService: UserService? = null

    @RequestMapping("/userpage")
    fun userpage(userVo: UserVo): DataGridViewResult {
        /*
        设置分页
         */
        PageHelper.startPage<Any>(userVo.page!!, userVo.limit!!)
        val userByPage = userService!!.findUserList(userVo)
        val pageInfo = PageInfo(userByPage)
        return DataGridViewResult(pageInfo.total, pageInfo.list)
    }

    @RequestMapping("/delete",method = [RequestMethod.POST])
    fun deleteuser(@RequestBody bemail:String):String{
        val p=bemail.indexOf("%")
        val a=bemail.subSequence((p+3),bemail.length-1)
        val b=bemail.subSequence(0,p)
        val data="$b@$a"

        val map: MutableMap<String, Boolean> = HashMap()
        map[SystemConstant.SUCCESS] = userService!!.deleteUser(data)>0
        return JSON.toJSONString(map)
    }



}