package com.java.pojo

import java.sql.Timestamp

/**
 * @Description
 * @Author sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/5
 */
data class SystemMenuEntity(
        var id: Int? = null,
        var pid: Int? = null,
        var title: String? = null,
        var icon: String? = null,
        var href: String? = null,
        var target: String? = null,
        var sort: Int? = null,
        var status: Byte? = null,
        var remark: String? = null,
        var createAt: Timestamp? = null,
        var updateAt: Timestamp? = null,
        var deleteAt: Timestamp? = null

)