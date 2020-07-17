package com.qin.myspringboot.shiro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Api("测试使用")
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    @ApiOperation("登陆接口")
    public String login(String username, String password, Model model) {
        System.out.printf("username :" + username);
        //1、获取 Subject
        Subject subject = SecurityUtils.getSubject();
        //2、封装用户数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        //3、执行登录方法
        try {
            subject.login(usernamePasswordToken);
            return "redirect:/testFreemarker";
        } catch (UnknownAccountException e) {//该异常用户名称不存在
            //登录失败，用户名称不存在
            model.addAttribute("msg", "用户名称不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {//该异常密码错误
            //登录失败，密码错误
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }
}
