package com.wxp.mix.service.impl;

import com.wxp.mix.dao.HelloWorldMapper;
import com.wxp.mix.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Autowired
    HelloWorldMapper helloWorldMapper;

    @Override
    public List<String> sayHello(String name) {
        return helloWorldMapper.sayHello(name) ;

    }
}
