package com.wxp.mix.service

import com.wxp.mix.controller.UserController
import com.wxp.mix.dto.UserDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@SpringBootTest
class UserServiceTestGroovy extends Specification {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    UserController userController;

    def userService = Mock(UserService);

    //@Before
    def setupSpec(){
        println "com.wxp.mix.service.UserServiceTestGroovy.setUpSpec "
    }

    //每个测试执行之前都会执行一遍
    def setup(){
        //赋值挡板
        userController.userService = userService
        println "com.wxp.mix.service.UserServiceTestGroovy.setUp "
    }

    //每个测试方法执行完后，都会执行一遍
    def cleanup(){
        //还原挡板
        userController.userService = applicationContext.getBean(UserService.class)
        println "com.wxp.mix.service.UserServiceTestGroovy.cleanup"
    }

    //@After
    def cleanupSpec(){
        println "com.wxp.mix.service.UserServiceTestGroovy.cleanupSpec"
    }

    def "test invoke service"(){
        given:
            //定义挡板的入参，返参等数据
            userService.getUserDtoByUserId(*_) >> success()
        when:
            def a = userController.getUserDtoByUserId("test")
        then:
            a != null
            a.getUserName() == "testName"
    }

    def "success"(){
        UserDto user = new UserDto()
        user.setUserName("testName")
    }

    def "test a > b"(){
        given :
            def a = new Random().nextInt(10)
            def b = 11
        expect:
            println a
            b > a
    }



    def "test given when then"() {
        given :
           int a = 1
           int b = 2
        when :
            int max = (int) Math.max(b,a)
        then:
            max == 2
    }

    def "test expect where"(){
        expect:
           getData(key)
        where :
          key | value
        "key1"|"value1"
        "key2"|"value2"
        "key3"|"value3"
    }

    String getData(String key){
        Map<String,String> data = new HashMap<>()
        data.put("key1","value1")
        data.put("key2","value2")
        data.put("key3","value3")
        return data.get(key)
    }

    def "test_throwNewException"(){
        throw  new ArrayIndexOutOfBoundsException()
    }

    def "test exception"(){
        when :
        test_throwNewException()
        then:
        def ex = thrown(Exception)
        def name = ex.class.name
        println name
        name == "java.lang.ArrayIndexOutOfBoundsException"
    }

}
