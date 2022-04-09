package com.wxp.mix.controller;

import com.wxp.mix.dao.HelloWorldMapper;
import com.wxp.mix.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    HelloWorldService helloWorldService;

    @Autowired
    HelloWorldMapper helloWorldMapper;

    @RequestMapping("/hello")
    public List<String> sayHelloWorld(@RequestParam("name") String name){
        return helloWorldService.sayHello(name);
    }

}
