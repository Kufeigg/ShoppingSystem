package com.java.service

import com.java.dao.UserDao
import com.java.pojo.User
import com.java.vo.UserVo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

@Service
@Transactional
open class UserServiceImpl : UserService {
    @Resource
    private val userDao: UserDao? = null

    override fun findUserList(userVo: UserVo): List<User?>? {
        return userDao!!.findUserList(userVo)
    }

    override fun deleteUser(bemail: String): Int {
        return userDao!!.deleteUser(bemail)
    }

    override fun login(bemail: String?, bpwd: String?): User? {
        val user = userDao!!.login(bemail, bpwd)
        return if (user != null)  user else null
    }

}