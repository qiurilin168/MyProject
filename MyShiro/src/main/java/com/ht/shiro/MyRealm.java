package com.ht.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        roles.add("经理");
        roles.add("老板");
        authorizationInfo.setRoles(roles);
        Set<String> permissions = new HashSet<>();
        permissions.add("user:add");
        permissions.add("system:setting");
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = String.valueOf((char[]) authenticationToken.getCredentials());
        if(username.equals("zhangsan") && password.equals("123456")){
            return new SimpleAuthenticationInfo(username,password,"myRealm");
        }else{
            throw new AccountException("账号或密码有误");
        }
    }
}


