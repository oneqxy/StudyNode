package com.qin.myspringboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qin.myspringboot.config.RabbitConfig;
import com.qin.myspringboot.exception.MyException;
import com.qin.myspringboot.springboot.entity.Person;
import com.qin.myspringboot.springboot.service.IPersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/test")
@Api("测试使用")
public class TestController implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback   {

    @Autowired
    private IPersonService personService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setReturnCallback(this);
        rabbitTemplate.setConfirmCallback(this);
    }

    @GetMapping("/test01/{name}/{age}")
    @ApiOperation(value="方法名称", notes="方法描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "String" , paramType = "path")
    })
    public String test01(@PathVariable("name") String name , @PathVariable("age") String age){
        return "你好啊";
    }


    @GetMapping("/test02")
    @ApiOperation(value="测试多线程")
    public String test02(){
        log.info("start submit");

        //调用service层的任务
        personService.executeAsync();

        log.info("end submit");

        return "success";
    }

    @GetMapping("/test03")
    @ApiOperation(value="日志测试")
    public String test03(){
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");

        return "success";
    }

    @GetMapping("/test04")
    @ApiOperation(value="异常测试")
    public String test04(){

        throw new MyException("异常测试");

    }

    @GetMapping("/test05")
    @ApiOperation("缓存测试")
    @Cacheable("person")
    public Person test05(){
        return personService.getOne(new QueryWrapper<Person>().eq("id" ,1));
    }


    @GetMapping("/test06")
    @ApiOperation("消息队列测试")
    public void test06(){
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE,"QUEUE","陈意涵",new CorrelationData(UUID.randomUUID().toString()));
    }

    @GetMapping("/test07")
    @ApiOperation("安全验证测试")
    public String test07(){
       return "hello world ~";
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b) {
            System.out.println("ack send succeed: " + correlationData);
        } else {
            System.out.println("ack send failed: " + correlationData + "|" + s);
        }
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("ack " + message + " 发送失败");
    }
}
