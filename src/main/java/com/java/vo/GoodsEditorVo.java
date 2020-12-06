package com.java.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GoodsEditorVo {

    /**
     * 商品Id
     */
    @NotNull(message = "商品Id不为空")
    private Integer goodsId;

}
