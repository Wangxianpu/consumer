package com.wxp.mix.sao;

import com.wxp.mix.common.BaseTest;
import com.wxp.mix.remote.UserSao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: 用户远程调用测试
 * @author: wxp
 * @time: 2022/4/7 22:14
 */
@SpringBootTest
public class UserSaoTest extends BaseTest {

    @Autowired
    UserSao userSao;

    @Test
    public void testUserInfoGet(){
        System.out.println(GSON.toJson(userSao.getUserInfoById("id1000")));
    }

    @Test
    public void testGetUserDtoByUserIdAndAccNo(){

        System.out.println(GSON.toJson(userSao.getUserDtoByUserIdAndAccNo("id1000","1000")));
    }
}
