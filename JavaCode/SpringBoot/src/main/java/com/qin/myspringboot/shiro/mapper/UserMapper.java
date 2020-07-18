package com.qin.myspringboot.shiro.mapper;

import com.qin.myspringboot.shiro.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qxy
 * @since 2020-07-17
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查看用户权限
     * @param username
     * @return
     */
    User selectUserRolePermission(@Param("username") String username);

}
