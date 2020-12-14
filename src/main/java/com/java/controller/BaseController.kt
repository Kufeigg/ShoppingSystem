package com.java.controller

import com.java.util.SystemConstant
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import javax.print.attribute.IntegerSyntax
import javax.servlet.http.HttpSession

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/9/30
 */
@Controller
@RequestMapping("/admin")
class BaseController {
    /**
     * 跳转到登陆页面
     *
     * @return
     */
    @RequestMapping("/login")
    fun login(): String {
        return "/admin/login"
    }

    /**
     * 跳转到主页
     */
    @RequestMapping("/index")
    fun index(): String {
        return "/admin/index"
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping("/logout")
    fun logout(session: HttpSession): String {
        session.removeAttribute(SystemConstant.LOGINUSER)
        return "redirect:/admin/login"
    }

    /**
     * 跳转到用户表
     * @return
     */
    @RequestMapping("/togoodstable")
    fun togoodstable(): String {
        return "/admin/goods/goodstable"
    }

    @RequestMapping("/togoodsinsert")
    fun togoodsinsert(id:Int?): String {
//        if (id == null) {
            return "/admin/goods/goodsEditor";
//        } else {
//            return "admin/goods/goodsEditor?id="+id;
//        }
    }

    @RequestMapping("/touserpage")
    fun touserpage(): String {
        return "/admin/user/usertable"
    }

    @RequestMapping("/tonotice")
    fun tonotice(): String{
        return "/admin/notice/noticetable"
    }
}