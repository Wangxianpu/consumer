package com.wxp.customer.service;

/**
 * @description: 配置服务
 * @author : wxp
 * @time: 2022/4/9 13:50
 */
public interface PropertyService {
    /**
     * 根据key获取配置信息
     * @param key key
     * @return 配置信息
     */
    public String getPropertyByKey(String key);

}
