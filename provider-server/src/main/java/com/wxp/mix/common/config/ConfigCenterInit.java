package com.wxp.mix.common.config;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.wxp.mix.common.vo.PropertyVO;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 配置中心
 * @author: wxp
 * @time: 2022/4/9 12:56
 */
@Configuration
public class ConfigCenterInit {

    public static final String PROPERTIES_JSON = "properties.json";

    @Value("classpath:config/properties.json")
    private Resource jsonProps;


    //存放配置信息
    private final static Map<String,Map<String,String>> propertyMaps = new HashMap<>();

    /**
     * 对外提供消费端配置信息 key：消费端  value:对应的配置
     */
    public static Map<String,Map<String,String>> getConsumerPropMaps(){
        return propertyMaps;
    }

    @Bean
    void initConfigCenter(){
        InputStream in = null ;
        try{
            in = jsonProps.getInputStream();
            String jsonStr = IOUtils.toString(in, StandardCharsets.UTF_8);
            loadPropertyFiles(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != in){
                try {
                    IOUtils.close(in);
                } catch (IOException e) {
                    //todo error log
                }
            }
        }
    }

    /**
     * 根据给定配置文件路径，加载对应的配置到map中
     * @param jsonStr 配置文件json字符串
     *
     */
    private void loadPropertyFiles(String jsonStr) {
        //将reader流转化为list对象
        Type type = new TypeToken<List<PropertyVO>>(){}.getType();
        List<PropertyVO> list = new Gson().fromJson(jsonStr,type);
        //处理配置文件,将配置信息缓存到 propertyMaps
        dealWithProperties(list);
    }

    /**
     * 处理配置文件
     * @param list 从配置文件中读取出来的列表
     */
    private void dealWithProperties(List<PropertyVO> list) {
        Map<String,String> propMaps = new HashMap<>();
        for (PropertyVO propertyVO : list) {
            propMaps.put(propertyVO.getKey(),propertyVO.getValue());
        }
        propertyMaps.put(ConfigCenterInit.PROPERTIES_JSON,propMaps);
    }
}
