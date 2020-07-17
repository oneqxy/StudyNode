package com.qin.myspringboot.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    @RequiresRoles("admin")
    public String hello() {
        return "ok";
    }
    @RequestMapping(value = "/testFreemarker")
    public String testThymeleaf(Model model) {
        //把数据存入model
        model.addAttribute("test", "测试freemarker");
        //返回test.html
        return "test";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
        //把数据存入model
        model.addAttribute("test", "添加用户页面");
        //返回test.html
        return "user/add";
    }

    @RequestMapping(value = "/update")
    public String update(Model model) {
        //把数据存入model
        model.addAttribute("test", "修改用户页面");
        //返回test.html
        return "/user/update";
    }

    @RequestMapping(value = "/toLogin")
    public String toLogin(Model model){
        //把数据存入model
        model.addAttribute("msg", "哈，哈，哈，哈");
        return "login";
    }
    @RequestMapping(value = "/toNoAuth")
    public String toNoAuth(Model model){
        //把数据存入model
        model.addAttribute("msg", "哈，哈，哈，哈");
        return "noAuth";
    }

}

