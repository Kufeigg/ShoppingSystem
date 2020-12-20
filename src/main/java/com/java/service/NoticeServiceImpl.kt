package com.java.service

import com.java.dao.NoticeDao
import com.java.pojo.Notice
import com.java.vo.NoticeVo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource

@Service
@Transactional
open  class NoticeServiceImpl : NoticeService {
    @Resource
    private val noticedao: NoticeDao? = null
    override fun findNoticeByPage(noticeVo: NoticeVo): List<Notice?>? {
        return noticedao!!.findNoticeByPage(noticeVo)
    }

    override fun findById(id: Int?): Notice {
        return noticedao!!.findById(id)
    }

    override fun deleteById(id: Int?): Int {
        return noticedao!!.deleteById(id)
    }

    override fun noticeUpdate(notice: Notice): Int {
        return noticedao!!.noticeUpdate(notice)
    }

    override fun insertNotice(notice: Notice): Int {
        return noticedao!!.insertNotice(notice)
    }
}