package com.wxp.mix.remote;

import com.wxp.mix.dto.UserDto;
import com.wxp.mix.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo 只能允许其他微服务调用，需要做访问隔离
 * @description: 用户信息的远程调用接口
 * @author: wxp
 * @time: 2022/4/7 21:46
 */
@RestController
public class UserSao {

    @Autowired
    UserService userService;

    @GetMapping("/sao/getUserInfoById")
    public UserDto getUserInfoById(@Param("userId") String userId ){
        return userService.getUserDtoByUserId(userId);
    }

    @GetMapping("/sao/getUserDtoByUserIdAndAccNo")
    public UserDto getUserDtoByUserIdAndAccNo(String userId ,String bankAccNo ){
        return userService.getUserDtoByUserIdAndAccNo(userId,bankAccNo);
    }
}
