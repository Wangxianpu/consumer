package com.wxp.mix.controller;

import com.wxp.mix.dto.UserDto;
import com.wxp.mix.service.UserService;
import com.wxp.mix.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.wxp.mix.common.constant.LoginConstants.USER_INFO;

/**
 * @description: 登录相关控制
 * @author: wxp
 * @time: 2022/4/1 21:03
 */
@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    /**
     *  登录功能
     * @param request 请求
     * @param userId 用户id
     * @param password 密码（非真实）
     */
    @RequestMapping("/login")
    public ResultVO<String> login(HttpServletRequest request, String userId, String password){
        //校验密码准确性，密码相关功能后续完善
        if(!verifyPassword(userId,password)){
            return new ResultVO<>("校验不通过",false,"失败");
        }
        //获取session信息
        HttpSession session = request.getSession();
        //获取用户信息，后续优化成中间件获取
        UserDto userDto = userService.getUserDtoByUserId(userId);
        //设置用户信息，后续优化失效，缓存保存等
        session.setAttribute(USER_INFO,userDto);

        return new ResultVO<>("登录成功",true,"成功");
    }

    private boolean verifyPassword(String userId, String password) {
        return true;
    }

}
