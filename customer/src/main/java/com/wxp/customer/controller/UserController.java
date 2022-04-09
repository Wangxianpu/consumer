package com.wxp.customer.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @description: 消费方controller
 * @author: wxp
 * @time: 2022/3/17 14:02
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getByUserId")
    public String buyTicket() {
        //此参数为注册在Eureka中的服务
        Object object = restTemplate.getForObject("http://PROVIDER-ACCOUNT-2/user/userId?userId=zhangsan", String.class);
        return String.valueOf(object);
    }

    @RequestMapping("/getInfoByServeId")
    public String getInfoByServeId(String serveId) {
        String serveUrl = "http://" + serveId + "/user/userId?userId=" + serveId;
        //此参数为注册在Eureka中的服务
        Object object = restTemplate.getForObject(serveUrl, String.class);
        return String.valueOf(object);
    }
}
