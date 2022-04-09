package com.wxp.mix.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxp.mix.common.util.RedisUtil;
import com.wxp.mix.dao.UserMapper;
import com.wxp.mix.dto.PageParam;
import com.wxp.mix.dto.UserDto;
import net.minidev.json.JSONValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description: 用户相关mapper测试类
 * @author: wxp
 * @time: 2022/4/2 14:29
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    UserMapper userMapper;

    @Test
    void test_getUserDtoListLikedByUserId(){
        PageParam pageParam = new PageParam(100,0);
        List<UserDto> userDtoList = userMapper.getUserDtoListLikedByUserId("",pageParam);
        System.out.println(JSONValue.toJSONString(userDtoList));
    }

}
