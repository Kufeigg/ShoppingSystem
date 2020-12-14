package com.java.controller

import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.java.service.NoticeService
import com.java.util.DataGridViewResult
import com.java.vo.GoodVo
import com.java.vo.NoticeVo
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

/**
 * @Description
 * @Author  sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/13
 */
@RestController
@RequestMapping("/admin/notice")
class NoticeController {
    @Resource
    private val noticeService: NoticeService?=null

    @RequestMapping("/list")
    fun list(noticeVo: NoticeVo): DataGridViewResult {
        /*
        设置分页
         */
        PageHelper.startPage<Any>(noticeVo.page!!, noticeVo.limit!!)
        val noticeByPage = noticeService!!.findNoticeByPage(noticeVo)
        val pageInfo = PageInfo(noticeByPage)
        return DataGridViewResult(pageInfo.total, pageInfo.list)
    }

}