package com.java.pojo

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.util.*

open class Notice {
    var id: Long = 0
    var ntitle: String? = null
    var ncontent: String? = null
    @JsonFormat(pattern = "yyyy-MM-dd")
    var ntime: Date? = null
}