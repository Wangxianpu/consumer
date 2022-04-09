package com.wxp.customer.job;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: 用户信息更新job 测试
 * @author: wxp
 * @time: 2022/4/7 22:26
 */
@SpringBootTest
public class UserInfoRefreshJobTest {

    @Autowired
    UserInfoRefreshJob userInfoRefreshJob;

    @Test
    public void testJob(){
        userInfoRefreshJob.userInfoRefreshJob();
    }
}
