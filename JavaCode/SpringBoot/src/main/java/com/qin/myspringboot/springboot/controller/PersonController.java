package com.qin.myspringboot.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qin.myspringboot.springboot.entity.Person;
import com.qin.myspringboot.springboot.service.IPersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qxy
 * @since 2020-07-07
 */
@Api("Person管理")
@RestController
@RequestMapping("/springboot/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping("/selectPersonById/{id}")
    @ApiOperation("根据personId查询Person")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "personId", required = true,paramType = "path"),
    })
    @Cacheable("person")
    public Person selectPerson(@PathVariable("id") String id) throws InterruptedException {
        Thread.sleep(2000);
        return personService.getOne(new QueryWrapper<Person>().eq("id" , id));
    }

    @PostMapping("/savePerson")
    @ApiOperation("添加Person")
    public Boolean savePerson(@RequestBody Person person){
        return personService.save(person);
    }

}
