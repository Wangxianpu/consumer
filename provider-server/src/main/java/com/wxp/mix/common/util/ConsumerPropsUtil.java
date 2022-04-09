package com.wxp.mix.common.util;

import com.wxp.mix.common.config.ConfigCenterInit;

import java.util.Map;

/**
 * @description: 消费端配置工具类
 * @author: wxp
 * @time: 2022/4/9 13:39
 */
public class ConsumerPropsUtil {

    //存放配置信息
    private static Map<String,Map<String,String>> propertyMaps ;

    /**
     * 根据key获取配置信息
     * @param key 传入的key
     * @param consumerPropName 消费配置文件名称
     * @return 配置信息
     */
    public static String getConsumerPropertyByKey(String consumerPropName, String key){
        if(propertyMaps == null){
            propertyMaps = ConfigCenterInit.getConsumerPropMaps();
        }
        Map<String,String> map = propertyMaps.get(consumerPropName);
        if(map != null){
            return map.get(key);
        }
        return null;
    }

    /**
     * 根据key获取配置信息
     * @param consumerPropName 消费配置文件名称
     * @return 该消费端所有配置信息
     */
    public static  Map<String,String> getConsumerPropsByPropName(String consumerPropName){
        if(propertyMaps == null){
            propertyMaps = ConfigCenterInit.getConsumerPropMaps();
        }
        return propertyMaps.get(consumerPropName);
    }
}
