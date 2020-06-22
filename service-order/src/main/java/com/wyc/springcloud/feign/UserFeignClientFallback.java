package com.wyc.springcloud.feign;

import com.wyc.pojo.User;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientFallback implements UserFeignClient{
    @Override
    public String getUsernameById(Integer id) {
        return "查询失败"+id;
    }

    @Override
    public User getById(Integer id) {
        User user = new User();
        user.setUsername("查询失败"+id);
        return null;
    }

    @Override
    public User getUserById(User user) {
        User u = new User();
        u.setUsername("查询失败"+user.getId());
        return u;
    }
}
