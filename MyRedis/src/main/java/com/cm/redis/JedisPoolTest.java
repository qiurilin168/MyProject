package com.cm.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(20);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig,"127.0.0.1",6379,5*1000);
        Jedis jedis = jedisPool.getResource();
        jedis.publish("oneplus","3499");

        jedisPool.close();
    }
}
