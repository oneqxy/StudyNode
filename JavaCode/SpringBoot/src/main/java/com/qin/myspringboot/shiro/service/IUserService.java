package com.qin.myspringboot.shiro.service;

import com.qin.myspringboot.shiro.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qxy
 * @since 2020-07-17
 */
public interface IUserService extends IService<User> {

    /**
     * 根据用户名查看用户权限
     * @param username
     * @return
     */
    User selectUserRolePermission(@Param("username") String username);
}
