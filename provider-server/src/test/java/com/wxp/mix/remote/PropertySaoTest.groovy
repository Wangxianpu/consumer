package com.wxp.mix.remote

import com.google.gson.Gson
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class PropertySaoTest extends Specification {

    @Autowired
    PropertySao propertySao;

    def  "test_getProps"(){
        when:
        def  propMap = propertySao.getConsumerPropsByPropName("properties.json")
        then:
        System.out.println(new Gson().toJson( propMap ))
    }
}
