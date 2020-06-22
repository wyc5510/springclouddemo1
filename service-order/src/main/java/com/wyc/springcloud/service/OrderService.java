package com.wyc.springcloud.service;

import com.wyc.springcloud.pojo.Order;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class OrderService {
    public Order getById(Integer id){
        Order order = new Order();
        order.setId(id);
        order.setOrderNo("OrderNo"+id);
        order.setCreateTime(new Date());
        Random random = new Random();

        order.setUserId(random.nextInt());
        order.setUsername("");
        return order;
    }
}
