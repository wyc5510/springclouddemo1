package com.wyc.springcloud.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private Integer id;
    private String orderNo;
    private Date createTime;
    private Integer UserId;
    private String username;
}
