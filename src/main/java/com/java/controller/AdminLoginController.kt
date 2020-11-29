package com.java.controller

import com.alibaba.fastjson.JSON
import com.java.pojo.Auser
import com.java.service.AdminService
import com.java.util.BeanValidatorUtils
import com.java.util.SystemConstant
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpSession

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/4
 */
@RestController
@RequestMapping(value = ["/admin/local"], method = [RequestMethod.POST])
class AdminLoginController {
    @Resource
    private val adminService: AdminService? = null

    /**
     * 后台管理员登陆
     *
     * @param aname
     * @param apwd
     * @return
     */
    @RequestMapping(value = ["/alogin"], method = [RequestMethod.POST])
    fun login(aname: String?,apwd: String?, session: HttpSession): String {

        var test=Auser()
        test.aname=aname
        test.apwd=apwd
        //调用通用验证方法取得验证后的错误信息列表
        val strList = BeanValidatorUtils.validateListResult<Auser>(test)
        //如果有错误则抛出异常
        if (strList.size > 0) {
            //将错误信息列表转化成字符串
            val error = BeanValidatorUtils.validateListToString(strList)
            println(error)
        }

        val map: MutableMap<String, Boolean> = HashMap()
        val count = adminService!!.login(aname, apwd)
        if (count != null) {
            map[SystemConstant.SUCCESS] = true
            session.setAttribute(SystemConstant.LOGINUSER, count)
        }else map[SystemConstant.SUCCESS] = false
        return JSON.toJSONString(map)
    }
}