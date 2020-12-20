package com.java.dao

import com.java.pojo.Goodstable
import com.java.pojo.Notice
import com.java.vo.GoodVo
import com.java.vo.NoticeVo
import org.apache.ibatis.annotations.Param

/**
 * @Description
 * @Author  sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/13
 */
interface NoticeDao {
    fun findNoticeByPage(noticeVo: NoticeVo): List<Notice?>?
    fun findById(@Param("id")id: Int?): Notice
    fun deleteById(@Param("id")id: Int?): Int
    fun noticeUpdate(notice: Notice): Int
    fun insertNotice(notice: Notice):Int
}