package com.wxp.mix.dao;

import com.wxp.mix.dto.PageParam;
import com.wxp.mix.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 用户相关mapper
 * @author: wxp
 * @time: 2022/3/17 12:34
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户id获取用户信息
     */
    UserDto getUserDtoByUserId(@Param("userId") String userId);

    /**
     * 根据用户id模糊查询用户信息
     * @param userId 用户id
     * @return 匹配的用户数据
     */
    List<UserDto> getUserDtoListLikedByUserId(@Param("userId") String userId, @Param("pageParam") PageParam pageParam);
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
