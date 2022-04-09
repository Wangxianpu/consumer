package com.wxp.customer.common.util;

import com.wxp.customer.common.constants.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description: 缓存相关工具类
 * @author: wxp
 * @time: 2022/4/9 15:55
 */
@Component
public class CacheUtil {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 远程配置
     */
    public static Map<String,String> propertyMaps ;

    /**
     *  根据key返回缓存配置
     * @param key 配置key
     * @return 配置信息
     */
    public  String getPropertyByKey(String key){
        if(Objects.isNull(propertyMaps)){
            propertyCacheInit();
        }
        return propertyMaps.get(key);
    }

    /**
     * 初始化远程配置缓存
     */
     void propertyCacheInit(){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("consumerPropName","properties.json");
        CacheUtil.propertyMaps = restTemplate.getForObject(HttpUtils.getUrl(CommonConstants.CONFIG_CENTER_SERVE_URL + CommonConstants.PROP_REQUEST_BY_PROP_NAME_INVOKE_URL
                ,paramMap), Map.class);
    }

}
