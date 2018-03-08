package com.cm.redis;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 123456 on 2018/3/7.
 * spring-date-redis 集群与 spring 整合
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/config/spring-*.xml"})
public class DateRedisClusterTest {

    @Autowired
    private RedisTemplate clusterRedisTemplate;

    @org.junit.Test
    public void test1(){
        ValueOperations<String,String> valueOperations =  clusterRedisTemplate.opsForValue();
//        valueOperations.set("S9+","6699");
        System.out.println(valueOperations.get("5t"));
        System.out.println(valueOperations.get("S9"));
        System.out.println(valueOperations.get("S9+"));
    }
}
