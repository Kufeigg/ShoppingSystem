package com.java.pojo;

import lombok.Data;

/**
 * @author VernZTL
 * @ClassName OrderDetail.java
 * @HostName Administrator
 * @Description TODO
 * @createTime 2020年12月20日 21:33:00
 */
@Data
public class OrderDetail {

    private Integer id;

    private Integer orderbasetable_id;

    private Integer goodstable_id;

    private Integer shoppingnum;
}
