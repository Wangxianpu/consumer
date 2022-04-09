package com.wxp.mix.common.config;

import com.google.common.reflect.TypeToken;
import com.wxp.mix.common.constant.CommonConstants;
import com.wxp.mix.common.util.IOUtil;
import com.wxp.mix.common.vo.PropertyVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.lang.reflect.Type;
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
        String absolutePath = this.getClass().getResource("/").getPath();
        String[] fileUrls = IOUtil.getPropFiles(absolutePath+CommonConstants.INIT_PROP_DIR);
        for(String fileUrl : fileUrls){
            loadPropertyFiles(fileUrl);
        }
    }

    /**
     * 根据给定配置文件路径，加载对应的配置到map中
     * @param fileUrl 配置文件路径
     */
    private void loadPropertyFiles(String fileUrl) {
        StringBuilder jsonStr = new StringBuilder();
        FileReader fr = null;
        BufferedReader br = null;
        File file = null;
        try {
            file = new File(fileUrl);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            //一行一行读取数据
            String str;
            while((str = br.readLine()) != null){
                jsonStr.append(str);
            }
            //将reader流转化为list对象
            Type type = new TypeToken<List<PropertyVO>>(){}.getType();
            List<PropertyVO> list = CommonConstants.GSON.fromJson(jsonStr.toString().trim(), type);
            //处理配置文件,将配置信息缓存到 propertyMaps
            dealWithProperties(list,file.getName());
        } catch (IOException e) {
            //todo log输出
            e.printStackTrace();
        }finally {
            try {
                IOUtil.closeIO(fr,br);
            } catch (IOException e) {
                //todo log输出
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理配置文件
     * @param list 从配置文件中读取出来的列表
     */
    private void dealWithProperties(List<PropertyVO> list,String fileName) {
        Map<String,String> propMaps = new HashMap<>();
        for (PropertyVO propertyVO : list) {
            propMaps.put(propertyVO.getKey(),propertyVO.getValue());
        }
        propertyMaps.put(fileName,propMaps);
    }
}
