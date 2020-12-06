package com.java.vo;

import lombok.Data;

/**
 * @author VernZTL
 * @ClassName PageVo.java
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月06日 21:48:00
 */
@Data
public class PageVo {

    /**
     * 页 默认1
     */
    private Integer page = 1;

    /**
     * 条 默认8
     */
    private Integer limit = 8;

}
