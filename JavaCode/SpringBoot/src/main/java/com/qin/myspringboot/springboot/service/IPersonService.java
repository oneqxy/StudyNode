package com.qin.myspringboot.springboot.service;

import com.qin.myspringboot.springboot.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qxy
 * @since 2020-07-07
 */
public interface IPersonService extends IService<Person> {
    /**
     * 异步执行测试方法
     */
    public void executeAsync();
}
