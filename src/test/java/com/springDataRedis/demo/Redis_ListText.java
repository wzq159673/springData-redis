package com.springDataRedis.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * list模拟对列  特点有序可存储重复
 * @program: springDataredisdemo
 * @author: wzq
 * @create: 2019-08-21 09:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class Redis_ListText {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 保存list
     */
    @Test
    public void saveList() {
        redisTemplate.boundListOps("valueList").leftPush("曹操");
        redisTemplate.boundListOps("valueList").leftPush("董卓");
        redisTemplate.boundListOps("valueList").leftPush("袁绍");
    }
    /**
     * 查询list
     */
    @Test
    public void findList() {
        String valueList = (String)redisTemplate.boundListOps("valueList").rightPop();
        System.out.println(valueList);
    }
    /**
     * 删除list
     */
    @Test
    public void deleteList() {
      redisTemplate.delete("valueList");
    }

}
