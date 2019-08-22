package com.springDataRedis.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * springdata-redis的操作hash---》结构类似map
 * @program: springDataredisdemo
 * @author: wzq
 * @create: 2017-08-21 08:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class Redis_HashText {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 保存hash
     */
    @Test
    public void saveHash() {
        redisTemplate.boundHashOps("valueHash").put("001","刘备");
        redisTemplate.boundHashOps("valueHash").put("002","关羽");
        redisTemplate.boundHashOps("valueHash").put("003","张飞");
    }
    /**
     * 查询hash
     */
    @Test
    public void findHash() {
        Set<String> valueHash = redisTemplate.boundHashOps("valueHash").keys();
        for (String key : valueHash) {
            System.out.println("hash的key值："+key+"-----hash的value值："+redisTemplate.boundHashOps("valueHash").get(key));
        }
    }
    /**
     * 更新hash
     */
    @Test
    public void updateHash() {
        redisTemplate.boundHashOps("valueHash").put("001","诸葛亮");
    }
    /**
     * 删除hash
     */
    @Test
    public void deleteHash() {
        redisTemplate.delete("valueHash");
    }
}
