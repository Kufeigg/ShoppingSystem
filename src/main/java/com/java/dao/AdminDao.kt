package com.java.dao

import com.java.pojo.Auser
import org.apache.ibatis.annotations.Param

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/1
 */
interface AdminDao {
    /**
     * 登陆
     * @param aname
     * @param apwd
     * @return
     */
    fun login(@Param("aname") aname: String?,
              @Param("apwd") apwd: String?): Auser?

    /**
     * 根据账号查询
     * @param aname
     * @return
     */
    fun findUserByLgName(@Param("aname") aname: String?): Auser?
}