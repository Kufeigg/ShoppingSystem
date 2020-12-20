package com.java.service

import com.java.pojo.Notice
import com.java.vo.NoticeVo
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Service

/**
 * @Description
 * @Author  sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/13
 */
interface NoticeService {
    fun findNoticeByPage(noticeVo: NoticeVo): List<Notice?>?
    fun findById(@Param("id")id: Int?): Notice
    fun deleteById(@Param("id")id: Int?): Int
    fun noticeUpdate(notice: Notice): Int
    fun insertNotice(notice: Notice):Int
}