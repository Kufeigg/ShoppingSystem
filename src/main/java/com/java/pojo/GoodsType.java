package com.java.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author VernZTL
 * @ClassName GoodsType.java
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月06日 21:52:00
 */
@Data
public class GoodsType {

    @NotNull(message = "id不能为空")
    private Integer id;

    private String typename;
}
