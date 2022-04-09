package com.wxp.mix.common;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: 测试基类
 * @author: wxp
 * @time: 2022/4/7 22:15
 */
@SpringBootTest
public class BaseTest {
    public Gson GSON = ConstantsTest.GSON;
    @Test
    void contextLoads() {

    }
}
