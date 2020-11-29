package com.java.pojo

import org.hibernate.validator.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * @Description
 * @Author  sc <1501482176@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/10/12
 */
data class Auser(
        var id: Int? = null,
        @NotNull(message = "用户名不能为空")
        var aname: String? = null,
        @NotNull(message = "密码不能为空,密码长度不能小于6，不能大于30")
        @Size(min=6,max=30)
        var apwd: String? = null,
        var name: String? = null
)