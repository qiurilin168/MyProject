package com.ht.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShiroRoleIni {

    @Test
    public void a(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-role.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken("test1","123456"));
        }catch (AccountException e){
            System.out.println("账号有误");
        }

        String name = (String) subject.getPrincipal();
        System.out.println("role1:"+subject.hasRole("role1"));
        System.out.println("role2:"+subject.hasRole("role2"));
        System.out.println("role3:"+subject.hasRole("role3"));

        List<String> roles = new ArrayList<>();
        roles.add("role1");
        roles.add("role2");
        roles.add("role3");

        boolean[] has = subject.hasRoles(roles);
        for(boolean b : has){
            System.out.println(b);
        }

        System.out.println(subject.hasAllRoles(roles));

        System.out.println("user:add  "+subject.isPermitted("user:add"));
        System.out.println("user:remove  "+subject.isPermitted("user:remove"));
        System.out.println("user:update  "+subject.isPermitted("user:update"));

        boolean[] isPermitted  = subject.isPermitted("user:add","user:remove","user:update");

        for (boolean b : isPermitted){
            System.out.println(b);
        }

        System.out.println(subject.isPermittedAll("user:add","user:remove","user:update"));
        System.out.println(subject.isPermitted(new WildcardPermission("user:123")));
    }
}
