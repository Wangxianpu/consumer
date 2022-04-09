package com.wxp.mix.service;

import com.wxp.mix.common.util.RedisUtil;
import com.wxp.mix.dao.UserMapper;
import com.wxp.mix.dto.PageParam;
import com.wxp.mix.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description: 用户相关服务测试类
 * @author: wxp
 * @time: 2022/4/2 14:52
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisUtil redisUtil;

    @Test
    void test_cacheUserDtoIntoRedis(){
        System.out.println(userService.cacheUserDtoIntoRedis());
    }

    @Test
    void test_hashCache100UserIntoRedis(){
        PageParam pageParam = new PageParam(100,0);
        List<UserDto> userDtoList = userMapper.getUserDtoListLikedByUserId("100",pageParam);
        for (UserDto dto : userDtoList){
            redisUtil.hset("userMap",dto.getUserId(),dto);
        }
    }

    @Test
    void test_ZSetCache100UserIntoRedis(){
        PageParam pageParam = new PageParam(100,0);
        List<UserDto> userDtoList = userMapper.getUserDtoListLikedByUserId("100",pageParam);
        for (UserDto dto : userDtoList){
            Double score = Double.valueOf(dto.getBankAccNo());
            redisUtil.zSet("userZSet",dto,score);
        }
    }

    @Test
    void test_ZRemRangeByRank(){
        redisUtil.zRemRangeByRank("userZSet",80,1000);
    }

    /**
     * 测试set的使用场景
     */
    @Test
    void test_setUseful(){
        redisUtil.sAdd("set_test",new String("1"),new String("2")
                ,new String("1"),new String("2"));
    }
}
