package com.java.dao

import com.java.pojo.Auser
import org.apache.ibatis.annotations.Param

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