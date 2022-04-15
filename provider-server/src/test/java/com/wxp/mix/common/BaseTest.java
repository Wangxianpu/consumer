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

    static float func1(){
        return 3L;
    }

    static float func2(){
        return 3;
    }

    public static void main(String[] args) {
        System.out.println(func1());
    }
}
