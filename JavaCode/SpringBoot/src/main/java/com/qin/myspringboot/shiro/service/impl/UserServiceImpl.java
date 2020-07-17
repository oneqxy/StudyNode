package com.qin.myspringboot.shiro.service.impl;

import com.qin.myspringboot.shiro.entity.User;
import com.qin.myspringboot.shiro.mapper.UserMapper;
import com.qin.myspringboot.shiro.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qxy
 * @since 2020-07-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
