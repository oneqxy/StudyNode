package com.qin.myspringboot.controller;


import com.qin.myspringboot.springboot.service.IPersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
@Api("测试使用")
public class TestController {

    @Autowired
    private IPersonService personService;

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
}
