package com.ht.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;



public class ShiroJdbcIni {

    @Test
    public void test(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken("user2","123456"));
        }catch (AccountException e){
            System.out.println(e.getMessage());
        }

        System.out.println(subject.hasRole("role1"));
        System.out.println(subject.hasRole("role2"));
        System.out.println(subject.isPermitted("user:add"));
        System.out.println(subject.isPermitted("system:setting"));
    }
}
