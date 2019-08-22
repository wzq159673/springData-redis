package com.springDataRedis.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * springdata-redis的操作set set类型数据操  特点：无序不可重复
 * @program: springDataredisdemo
 * @author: wzq
 * @create: 2017-08-20 23:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class Redis_SetText {
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 保存set类型
     */
    @Test
    public void saveSet() {
        redisTemplate.boundSetOps("valueSet").add("刘备");
        redisTemplate.boundSetOps("valueSet").add("关羽");
        redisTemplate.boundSetOps("valueSet").add("张飞");
    }

    /**
     * 查询set类型
     * members：成员
     */
    @Test
    public void findSet() {
        Set valueSet = redisTemplate.boundSetOps("valueSet").members();
        System.out.println(valueSet);


    }
    /**
     * 删除set类型
     */
    @Test
    public void deleteSet() {
        redisTemplate.delete("valueSet");

    }
}
