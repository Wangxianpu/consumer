package com.wxp.mix.controller;

import com.wxp.mix.dto.UserDto;
import com.wxp.mix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 用户控制类
 * @author: wxp
 * @time: 2022/3/17 12:47
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/userId")
    public UserDto getUserDtoByUserId(String userId){
       return userService.getUserDtoByUserId(userId);
    }

    @RequestMapping("/bankAccNo")
    public UserDto getUserDtoByAccountNo(String bankAccNo){
        return userService.getUserDtoByAccountNo(bankAccNo);
    }
}
