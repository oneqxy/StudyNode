package com.qin.myspringboot.shiro.service.impl;

import com.qin.myspringboot.shiro.entity.Permission;
import com.qin.myspringboot.shiro.mapper.PermissionMapper;
import com.qin.myspringboot.shiro.service.IPermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
