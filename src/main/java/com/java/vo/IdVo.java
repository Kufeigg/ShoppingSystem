package com.java.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author VernZTL
 * @ClassName GoodsType.java
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月06日 21:44:00
 */
@Data
public class IdVo {

    @NotNull(message = "分类Id不能为空")
    private Integer id;

}
