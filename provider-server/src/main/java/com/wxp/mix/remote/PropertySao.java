package com.wxp.mix.remote;

import com.wxp.mix.common.util.ConsumerPropsUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * todo 只能允许其他微服务调用，需要做访问隔离
 * @description: 暴露给消费端的配置信息
 * @author: wxp
 * @time: 2022/4/9 13:45
 */
@RestController
public class PropertySao {

    @GetMapping("/sao/getConsumerPropsByPropName")
    public Map<String,String> getConsumerPropsByPropName(String consumerPropName){
        return ConsumerPropsUtil.getConsumerPropsByPropName(consumerPropName);
    }
}
