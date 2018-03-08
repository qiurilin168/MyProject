package com.cm.controller;

import com.cm.bean.User;
import com.cm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate clusterRedisTemplate;

    @RequestMapping("get/{id}")
    @ResponseBody
    public Object getUser(@PathVariable("id") Long id){
        return userService.getById(id);
    }

    @RequestMapping("test")
    @ResponseBody
    public String test (){
        return "test";
    }

    @PostMapping("update")
    @ResponseBody
    public String update(User user){
        userService.update(user);
//        try {
//            userService.update(user);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            return "更新失败";
//        }
        return "更新成功";
    }

    /**
     * redis集群测试
     * @return
     */
    @RequestMapping("jedisCluster")
    @ResponseBody
    public String  testJedisCluster(){
        ValueOperations<String,String> valueOperations =  clusterRedisTemplate.opsForValue();
//        valueOperations.set("S9+","6699");
        System.out.println(valueOperations.get("5t"));
        System.out.println(valueOperations.get("S9"));
        System.out.println(valueOperations.get("S9+"));
        return "测试";
    }

    @PostMapping("test1")
    @ResponseBody
    public String test1 (){
        return "测试";
    }
}
