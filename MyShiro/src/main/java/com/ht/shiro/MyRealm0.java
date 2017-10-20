package com.ht.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.junit.Test;

public class MyRealm0 extends AuthenticatingRealm{

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = String.valueOf((char[]) authenticationToken.getCredentials());
        if(username.equals("lisi") && password.equals("123456")){
            return new SimpleAuthenticationInfo(username,password,"myRealm");
        }else{
            throw new AccountException("账号或密码有误");
        }
    }
}
