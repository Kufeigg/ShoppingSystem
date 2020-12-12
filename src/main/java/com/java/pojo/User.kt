package com.java.pojo

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * @Description
 * @Author  sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/12/10
 */
open class User(
        var id: Int? = null,
        var bemail: String? = null,
        var bpwd: String? = null
)