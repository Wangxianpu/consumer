package com.wxp.mix.service;

import com.wxp.mix.dto.UserDto;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: wxp
 * @time: 2022/3/17 12:44
 */
public interface UserService {
    /**
     * 根据用户id获取用户信息
     */
    UserDto getUserDtoByUserId(String userId);

    /**
     * 缓存用户数据到redis
     * @return true 成功  false 失败
     */
    boolean cacheUserDtoIntoRedis();

    /**
     * 根据银行账户获取用户信息
     * @param bankAccNo 银行账户
     */
    UserDto getUserDtoByAccountNo(String bankAccNo);

    /**
     * 根据userId和 bankAccNo获取用户信息
     * @param userId 用户信息
     * @param bankAccNo 银行账户信息
     * @return 用户信息
     */
    UserDto getUserDtoByUserIdAndAccNo(String userId, String bankAccNo);
}
