package com.example.demo.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.User;

@RestController
public class UserDataController {
	@RequestMapping("/getUser")
	@Cacheable(value="user-key")
	public User getUser() {
		User user=new User("aa@126.com","aa","aa123456","aa","123");
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		return user;
	}
	
	@RequestMapping("/uid")
	String uid(HttpSession session) {
		UUID uid=(UUID)session.getAttribute("uid");
		if(uid==null) {
			uid=UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return session.getId();
	}
}
