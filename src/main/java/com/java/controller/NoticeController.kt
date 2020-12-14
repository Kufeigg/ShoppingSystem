package com.java.controller

import com.alibaba.fastjson.JSON
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import com.java.pojo.Notice
import com.java.service.NoticeService
import com.java.util.DataGridViewResult
import com.java.util.SystemConstant
import com.java.vo.NoticeVo
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.Date
import java.time.LocalDate
import java.time.LocalDate.now
import java.util.*
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
    private val noticeService: NoticeService? = null

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

    @RequestMapping("/findById")
    fun list(id: Int?): DataGridViewResult {
        val noticeByPage = noticeService!!.findById(id)
        return DataGridViewResult(noticeByPage)
    }


    @RequestMapping("/update")
    fun noticeUpdate(notice: Notice): String {
        val map: MutableMap<String, Boolean> = HashMap()

        map[SystemConstant.SUCCESS] = noticeService!!.noticeUpdate(notice) > 0
        return JSON.toJSONString(map);
    }

}