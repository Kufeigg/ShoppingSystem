package com.java.vo

import com.java.pojo.Notice

/**
 * @Description
 * @Author  sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/13
 */
class NoticeVo: Notice() {
    var page: Int? = null
    var limit: Int? = null
}