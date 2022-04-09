package com.wxp.customer.config;

import com.google.common.reflect.TypeToken;
import com.wxp.customer.common.constants.CommonConstants;
import com.wxp.customer.common.vo.PropertyVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 配置自动加载类
 * @author: wxp
 * @time: 2022/4/8 21:52
 */
@Configuration
public class PropertyConfig {
    //存放配置信息
    private final static Map<String,String> propertyMaps = new HashMap<>();

    @Bean
    public void initPropertyConfig(){
        loadPropertyFiles();
    }

    public static String getPropertyFromProps(String key){
        return propertyMaps.get(key);
    }

    private void loadPropertyFiles() {
        StringBuilder jsonStr = new StringBuilder();
        Reader fr = null;
        try {
            fr = new InputStreamReader(new FileInputStream("E:/workspace/moxi/mix-project/customer/src/main/resources/properties.json"));
//            fr = new FileReader("properties.json");

            char[] buffer = new char[50];
            while (fr.read(buffer,0,buffer.length) != -1){
                jsonStr.append(String.copyValueOf(buffer));
                buffer = new char[50];
            }
            //将reader流转化为list对象
            Type type = new TypeToken<List<PropertyVO>>(){}.getType();
//            List list = Constants.GSON.fromJson(fr,type);//todo 为什么不生效
            List<PropertyVO> list = CommonConstants.GSON.fromJson(jsonStr.toString().trim(), type);

            dealWithProperties(list);
        } catch (IOException e) {
            //todo log输出
            e.printStackTrace();
        }finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 处理配置文件
     * @param list 从配置文件中读取出来的列表
     */
    private void dealWithProperties(List<PropertyVO> list) {
        for (PropertyVO propertyVO : list) {
            propertyMaps.put(propertyVO.getKey(),propertyVO.getValue());
        }
    }
}
