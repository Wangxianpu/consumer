package com.wxp.mix.common;

import com.wxp.mix.common.util.RedisUtil;
import com.wxp.mix.common.util.RedisZSetTuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: wxp
 * @time: 2022/4/2 16:51
 */
@SpringBootTest
public class RedisUtilTest {

    @Autowired
    RedisUtil redisUtil;

    @Test
    void test_zSet(){
        Set<ZSetOperations.TypedTuple<Object>> set = new HashSet<ZSetOperations.TypedTuple<Object>>();
        DefaultTypedTuple<Object> typedTuple = new DefaultTypedTuple<>("zSet1",1.0);
        DefaultTypedTuple<Object> typedTuple2 = new DefaultTypedTuple<>("zSet2",2.0);
        set.add(typedTuple);
        set.add(typedTuple2);
        redisUtil.zSetAll("zSetTest",set);

        redisUtil.zSet("zSetTest","zSet3",1.5);
        redisUtil.zSet("zSetTest","zSet4",2.5);

    }

    @Test
    void test_zSet2(){
        Set<ZSetOperations.TypedTuple<Object>> set = new HashSet<ZSetOperations.TypedTuple<Object>>();
        RedisZSetTuple typedTuple = new RedisZSetTuple("zSet1",1.0);
        RedisZSetTuple typedTuple2 = new RedisZSetTuple("zSet2",2.0);
        RedisZSetTuple typedTuple3 = new RedisZSetTuple("zSet3",0.8);
        RedisZSetTuple typedTuple4 = new RedisZSetTuple("zSet4",1.3);
        set.add(typedTuple);
        set.add(typedTuple2);
        set.add(typedTuple3);
        set.add(typedTuple4);
        redisUtil.zSetAll("zSetTest-1",set);

    }


}
