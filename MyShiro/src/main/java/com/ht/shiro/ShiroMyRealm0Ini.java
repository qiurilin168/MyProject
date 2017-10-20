package com.ht.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;


public class ShiroMyRealm0Ini {

    @Test
    public void testMyRealm(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-myrealm0.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken("lisi","123456"));
        } catch (AccountException e){
            System.out.println(e.getMessage());
        }

        System.out.println(subject.hasRole("董事长"));
        System.out.println(subject.hasRole("老板"));
        System.out.println(subject.isPermitted("user:add"));
        System.out.println(subject.isPermitted("user:fire"));
        System.out.println(subject.isPermitted("system:setting"));


    }
}
