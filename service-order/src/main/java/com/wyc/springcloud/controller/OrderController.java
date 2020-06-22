package com.wyc.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wyc.pojo.User;
import com.wyc.springcloud.feign.UserFeignClient;
import com.wyc.springcloud.pojo.Order;
import com.wyc.springcloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

@RestController
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("/getById")
    @HystrixCommand(fallbackMethod = "getOrderByIdFallback")
    public Order getById(@RequestParam("id")Integer id){
        Order order = orderService.getById(id);
      //final User user=restTemplate.getForObject("http://service-user/user/getById?id="+order.getUserId,User.class);
       // order.setUsername(user.getUsername());
        //geign调用1
//        String username = userFeignClient.getUsernameById(order.getUserId());
//        order.setUsername(username);
        //geign调用2
        User user = userFeignClient.getById(order.getUserId());
        order.setUsername(user.getUsername());
        //feign对象传参
        User u = new User();
        u.setId(111);
        User userById = userFeignClient.getUserById(u);
        order.setUsername(userById.getUsername());
        return order;
    }
    public Order getOrderByIdFallback(Integer id){
        Order order = new Order();
        order.setId(id);
        return order;
    }
}
