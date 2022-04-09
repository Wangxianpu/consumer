package com.wxp.mix.common.util;

import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.ZSetOperations;

/**
 * @description: 自定义zSet排序
 * @author: wxp
 * @time: 2022/4/2 17:05
 */
public class RedisZSetTuple extends DefaultTypedTuple {
    /**
     * Constructs a new <code>DefaultTypedTuple</code> instance.
     *
     * @param value can be {@literal null}.
     * @param score can be {@literal null}.
     */
    public RedisZSetTuple(Object value, Double score) {
        super(value, score);
    }

    public int compareTo(ZSetOperations.TypedTuple o) {
        return 1;
    }
}
