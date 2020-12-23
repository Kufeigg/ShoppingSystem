package com.java.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author VernZTL
 * @ClassName OrderBaseTable.java
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月20日 21:33:00
 */
@Data
public class OrderBaseTable {

    private Integer id;
    private Integer busertable_id;
    private Double amount;
    private Integer status;
    private Date orderdate;
}
