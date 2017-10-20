package com.ht.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Account;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;


public class ShiroMyJDBCIni {

    @Test
    public void test(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-myjdbc.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken("test1","123456"));
        }catch (AccountException e){
            System.out.println(e.getMessage());
        }
        System.out.println(subject.getPrincipal());
        System.out.println(subject.hasRole("customer"));
        System.out.println(subject.hasRole("role2"));
        System.out.println(subject.hasRole("role3"));

        System.out.println(subject.isPermitted("user:add"));
        System.out.println(subject.isPermitted("user:fire"));
        System.out.println(subject.isPermitted("customer:update"));
    }
}
