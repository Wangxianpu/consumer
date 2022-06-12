package com.wxp.mix.controller

import com.wxp.mix.dto.UserDto
import com.wxp.mix.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@SpringBootTest
class UserControllerTest extends Specification{

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
        userService.getUserDtoByUserId("test") >> success()
        when:
        def a = userController.getUserDtoByUserId("test")
        then:
        a != null
        a.getUserName() == "testName"
    }

    def "success"(){
        UserDto user = new UserDto()
        user.setUserName("testName")
        return user
    }

}
