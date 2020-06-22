package com.wyc.springcloud.feign;

import com.wyc.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//声明是客户端
@FeignClient(name = "service-user"/*,fallback =UserFeignClientFallback.class*/)
@Component
public interface UserFeignClient {
    @GetMapping("/user/getUsernameById")
    public String getUsernameById(@RequestParam("id") Integer id);
    @GetMapping("/user/getById")
    public User getById(@RequestParam("id") Integer id);
    @PostMapping("/user/getUserById")
    public User getUserById(@RequestBody User user);
}
