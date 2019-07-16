package com.example.demo;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Model.User;
import Model.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@EnableJpaRepositories("Model")
@EntityScan("Model")
public class UserRepositoryTests {
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void test() throws Exception{
		Date date =new Date();
		DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
		String formattedDate=dateFormat.format(date);
		
		userRepository.save(new User("aa1","aa@126.com","aa","aa123456",formattedDate));
		userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",formattedDate));
		userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",formattedDate));
		
		Assert.assertEquals("bb2",userRepository.findByUserNameOrEmail("bb", "xx126.com").getNickName());
		userRepository.delete(userRepository.findByUserName("aa"));
	}
	
}
