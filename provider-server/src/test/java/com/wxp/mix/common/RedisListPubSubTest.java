package com.wxp.mix.common;

import com.wxp.mix.common.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description: 使用list做消息队列
 * @author: wxp
 * @time: 2022/4/2 19:27
 */
@SpringBootTest
public class RedisListPubSubTest {
    @Autowired
    RedisUtil redisUtil;

    int cursor = 1;
    @Test
    void test_PubSub() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    redisUtil.rightPush("list_test",cursor++);
                    System.out.println("存入数据" + cursor);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    Object value = redisUtil.leftPop("list_test");
                    System.out.println("消费数据" + value);
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(100000);
    }

}
