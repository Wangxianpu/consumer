package com.wxp.mix;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxp.mix.common.util.RedisUtil;
import com.wxp.mix.controller.LoginController;
import com.wxp.mix.dto.UserDto;
import com.wxp.mix.service.UserService;
import com.wxp.mix.vo.ResultVO;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;

@SpringBootTest
class MixApplicationTests {

	@Autowired
	HttpServletRequest httpServletRequest;

	@Autowired
	LoginController loginController;

	@Autowired
	UserService userService;

	@Autowired
	RedisUtil redisUtil;

	ObjectMapper mp = new ObjectMapper();

	@Test
	void contextLoads() {

	}

	@Test
	void test_login(){
		ResultVO resultVO = loginController.login(httpServletRequest,"zhangsan","");
		System.out.println(JSONValue.toJSONString(resultVO));
	}

	@Test
	void test_hash(){
		UserDto userDto = userService.getUserDtoByUserId("id0");
		redisUtil.hset("testMap1","user1",userDto);
		UserDto ret = (UserDto) redisUtil.hget("testMap1","user1");
		System.out.println(JSONValue.toJSONString(ret));
	}


}
