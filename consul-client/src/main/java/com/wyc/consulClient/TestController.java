package com.wyc.consulClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//动态刷新配置
@RefreshScope
@RestController
public class TestController {

    @Autowired
    private ConsulConfigInfo consulConfigInfo;



    @RequestMapping("getConfig")
    public Object getConfig(){
        return consulConfigInfo;
    }
}
