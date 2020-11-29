package com.java.service

import com.java.pojo.Auser

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/1
 */
interface AdminService {
    fun login(aname: String?, apwd: String?): Auser?
}