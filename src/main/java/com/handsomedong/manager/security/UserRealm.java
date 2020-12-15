package com.handsomedong.manager.security;

import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.handsomedong.manager.entity.Permission;
import com.handsomedong.manager.entity.Role;
import com.handsomedong.manager.entity.User;
import com.handsomedong.manager.service.PermissionService;
import com.handsomedong.manager.service.RoleService;
import com.handsomedong.manager.service.UserService;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 设置用于匹配密码的CredentialsMatcher
     *
     * @param credentialsMatcher
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
        // 散列算法:这里使用使用sha256
        hashMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        hashMatcher.setStoredCredentialsHexEncoded(false);
        // 散列的次数，直接1024次不解释
        hashMatcher.setHashIterations(1024);
        super.setCredentialsMatcher(hashMatcher);
    }

    /**
     * 给shiro做权限校验
     * 是校验权限而不是登录
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (principalCollection == null) {
            throw new AuthenticationException("PrincipalCollection param cannot be null.");
        }
        User user = (User) getAvailablePrincipal(principalCollection);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(user.getRoles().stream().map(Role::getCode).collect(Collectors.toSet()));
        info.setStringPermissions(user.getPermissions().stream().map(Permission::getVal).collect(Collectors.toSet()));

        return info;
    }

    /**
     * 登录校验
     *
     * @param authenticationToken
     * @return
     *
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        if (username == null) {
            throw new AccountException("Cannot get the username.");
        }

        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        if (user == null) {
            throw new UnknownAccountException("Cannot find the user: " + username);
        }

        //存储user的权限 后面校验权限的时候会从这里取出权限进行校验
        user.getRoles().addAll(roleService.getRolesByUserId(user.getId()));
        user.getPermissions().addAll(permissionService.getPermissionsByUserId(user.getId()));

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPwd(), username);
        if (user.getSalt() != null) {
            simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
        }

        return simpleAuthenticationInfo;
    }
}
