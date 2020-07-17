package com.qin.myspringboot.shiro.service.impl;

import com.qin.myspringboot.shiro.entity.Role;
import com.qin.myspringboot.shiro.mapper.RoleMapper;
import com.qin.myspringboot.shiro.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
