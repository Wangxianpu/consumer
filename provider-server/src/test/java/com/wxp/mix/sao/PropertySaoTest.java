package com.wxp.mix.sao;

import com.google.gson.Gson;
import com.wxp.mix.remote.PropertySao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * @description:
 * @author: wxp
 * @time: 2022/6/12 18:34
 */
@SpringBootTest
public class PropertySaoTest {
    @Autowired
    PropertySao propertySao;

    @Test()
    public void test_getProps(){
        Map<String,String> propMap = propertySao.getConsumerPropsByPropName("properties.json");
        System.out.println(new Gson().toJson( propMap ));
    }
}
