package com.wyc.user.service;

import com.wyc.pojo.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //通过用户查询
    public User getById(Integer id){
        User user=new User();
        user.setId(id);
        user.setUsername("username"+id);
        return user;
    }
}
