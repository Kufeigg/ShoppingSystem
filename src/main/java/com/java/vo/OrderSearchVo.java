package com.java.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author VernZTL
 * @ClassName OrderSearchVo.java
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月24日 02:31:00
 */
@Data
public class OrderSearchVo extends PageVo {

    @NotNull(message = "商品名不能为空")
    private String name;
}
