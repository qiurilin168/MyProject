package com.ht.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;



public class ShiroIni {

    @Test
    public void aa(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken("test1", "123456"));
        } catch (UnknownAccountException e){
            System.out.println("用户不存在");
        } catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }
        String username = (String) subject.getPrincipal();
        System.out.println(username);
        Session session = subject.getSession();
        session.setAttribute("user",username);

        subject.logout();

        System.out.println(subject.getPrincipal());
    }
}
