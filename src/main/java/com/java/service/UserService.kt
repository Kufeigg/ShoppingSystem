package com.java.service

import com.java.pojo.User
import com.java.vo.UserVo

/**
 * @Description
 * @Author  sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/10
 */
interface UserService {
    fun findUserList(userVo: UserVo): List<User?>?
    fun deleteUser(bemail:String): Int
}