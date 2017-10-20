package com.ht.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name="userServlet" ,urlPatterns = "/user/login")
public class UserControllr extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(new UsernamePasswordToken(name,password));

        }catch (AccountException e){
            System.out.println(e.getMessage());
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
