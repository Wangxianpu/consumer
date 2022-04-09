package com.wxp.mix.service.impl;

import com.wxp.mix.common.util.RedisUtil;
import com.wxp.mix.dao.UserMapper;
import com.wxp.mix.dto.PageParam;
import com.wxp.mix.dto.UserDto;
import com.wxp.mix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @description: 用户服务实现类
 * @author: wxp
 * @time: 2022/3/17 12:44
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public UserDto getUserDtoByUserId(String userId) {
        return userMapper.getUserDtoByUserId(userId);
    }

    @Override
    public boolean cacheUserDtoIntoRedis() {
        //设置分页参数
        PageParam pageParam = new PageParam(1000,0);
        //游标，记录执行的次数，避免死循环
        int cursor = 0;
        //批量查询数据
        List<UserDto> userDtoList = userMapper.getUserDtoListLikedByUserId("",pageParam);
        while(userDtoList != null && userDtoList.size() > 0 && cursor < 100){
            //将userDtoList中的数据存入到redis中
            for(UserDto dto : userDtoList){
                String userId = dto.getUserId();
                if(!redisUtil.set(userId,dto)){
                    return false;
                }
            }
            cursor++;
            pageParam.setPageNum(pageParam.getPageNum()+1);
            //重新查询,再存入到redis
            userDtoList = userMapper.getUserDtoListLikedByUserId("",pageParam);
        }
        return true;
    }

    @Override
    public UserDto getUserDtoByAccountNo(String bankAccNo) {
        return userMapper.getUserDtoByAccountNo(bankAccNo);
    }

    @Override
    public UserDto getUserDtoByUserIdAndAccNo(String userId, String bankAccNo) {
        return userMapper.getUserDtoByUserIdAndAccNo(userId,bankAccNo);
    }
}
