package com.ht.controller;

import com.ht.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserControllr1 {

    @PostMapping(value = "login", produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String login(User user){
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken(user.getName(),user.getPassword()));
        }catch (AuthenticationException e){
            return "用户名或密码有误";
        }

        return "home";
    }

}
