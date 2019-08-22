package com.springDataRedis.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * springdata-redis的操作基本数据类型
 *
 * @program: springDataredisdemo
 * @author: wzq
 * @create: 2017-08-20 21:3
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class RedisText {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 简单K-V操作:保存基本数据类型
     */
    @Test
    public void save() {
        redisTemplate.boundValueOps("valueKey").set("张飞");
    }

    /**
     * 简单K-V操作:查询基本数据类型
     */
    @Test
    public void find() {
        String valueKey = (String) redisTemplate.boundValueOps("valueKey").get();
        System.out.println(valueKey);
    }

    /**
     * 简单K-V操作:更新基本数据类型
     */
    @Test
    public void update() {
        redisTemplate.boundValueOps("valueKey").set("刘备");
    }

    /**
     * 简单K-V操作:更新基本数据类型
     */
    @Test
    public void delete() {
        redisTemplate.delete("valueKey");
    }


}