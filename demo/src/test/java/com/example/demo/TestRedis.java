package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.redis.core.ValueOperations;

import Model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Test
	public void test() throws Exception{
		stringRedisTemplate.opsForValue().getAndSet("aaa", "111");
		Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
	}
	
	@Test
	public void testObj()throws Exception{
		User user=new User("aa@126.com","aa","aa123456","aa","123");
		ValueOperations<String,User>operations=redisTemplate.opsForValue();
		operations.set("com.neox",user);
		operations.set("com.neo.f",user,1,TimeUnit.MICROSECONDS);
		Thread.sleep(1000);
		boolean exists=redisTemplate.hasKey("com.neo.f");
		if(exists) {
			System.out.println("exists is true");
		}else {
			System.out.println("exists is false");
		}
		
	}
	
}
