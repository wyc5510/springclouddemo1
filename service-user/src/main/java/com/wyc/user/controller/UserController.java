package com.wyc.user.controller;

import com.wyc.pojo.User;
import com.wyc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/getUsernameById")
    public String getUsernameById(@RequestParam("id") Integer id){
        System.out.println(serverPort);
        return userService.getById(id).getUsername();
    }
    //根据用户id查询用户信息
    @GetMapping("/getById")
    public User getById(@RequestParam("id") Integer id){
        return userService.getById(id);
    }

    //根据user查询用户
    @PostMapping("getUserById")
    public User getUserById(@RequestBody User user){
        return userService.getById(user.getId());
    }
}
