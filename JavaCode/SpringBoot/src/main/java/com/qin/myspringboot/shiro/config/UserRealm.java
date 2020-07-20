package com.qin.myspringboot.shiro.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qin.myspringboot.shiro.entity.Permission;
import com.qin.myspringboot.shiro.entity.Role;
import com.qin.myspringboot.shiro.entity.User;
import com.qin.myspringboot.shiro.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    /**
     * 执行授权逻辑
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("用户权限配置。。。。。。。。。。");
        //访问@RequirePermission注解的url时触发
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user  = (User)principalCollection.getPrimaryPrincipal();
        //获得用户的角色，及权限进行绑定
        for(Role role:user.getRoles()){
            authorizationInfo.addRole(role.getRole());
            for(Permission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 执行认证逻辑
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("用户认证开始");

        //1.获取用户账号
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = (String) usernamePasswordToken.getPrincipal();

        //2.根据用户账号，查用户信息
        User user = userService.selectUserRolePermission(username);

        //3、判断用户名称是否存在
        if (user == null){
            return null;
        }

        //4、判断密码是否正确
        return new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getSalt()) , getName());

        //4、判断密码是否正确（明文）
        //return new SimpleAuthenticationInfo(user,user.getPassword(), getName());
    }

    /**
     * 设置认证加密方式
     */
//    @Override
//    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
//        HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
//        md5CredentialsMatcher.setHashAlgorithmName(ShiroKit.HASH_ALGORITHM_NAME);
//        md5CredentialsMatcher.setHashIterations(ShiroKit.HASH_ITERATIONS);
//        super.setCredentialsMatcher(md5CredentialsMatcher);
//    }

    public void clearCache(){
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
