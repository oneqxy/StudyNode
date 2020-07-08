package com.qin.myspringboot.springboot.mapper;

import com.qin.myspringboot.springboot.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qxy
 * @since 2020-07-07
 */
public interface PersonMapper extends BaseMapper<Person> {

}
