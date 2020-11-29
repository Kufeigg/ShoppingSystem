package com.java.service

import com.java.dao.AdminDao
import com.java.pojo.Auser
import com.java.util.MD5Utils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/1
 */
@Service
@Transactional
open class AdminServiceImpl : AdminService {
    @Resource
    private val adminDao: AdminDao? = null

    /**
     * 管理员登陆
     *
     * @param aname
     * @param apwd
     * @return
     */
    override fun login(aname: String?, apwd: String?): Auser? {
        val auser = adminDao!!.findUserByLgName(aname)
        return if (auser != null) {
            val pwdMd5 = MD5Utils.string2MD5(apwd)
            if (auser.apwd == pwdMd5)  auser  else  null
        }
        else null
    }
}