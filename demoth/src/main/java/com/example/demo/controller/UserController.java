package com.example.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import beans.Author;
import beans.Book;

@Controller
public class UserController {
	@RequestMapping("goHome")
	public String index(Map<String,Object> paramMap) {
		paramMap.put("name", "李四");
		paramMap.put("age",30);
		Book book=new Book();
		book.setTitle("钢铁是怎样炼成的");
		Author author=new Author();
		author.setName("Michael");
		book.setAuthor(author);
		paramMap.put("book", book);																																																																																																							
		return "home";
	}
	
	@RequestMapping("homePage")
	public String goHome(Map<String,Object> paramMap) {
		//Bean构建  BeanService.class 要创建的Bean的Class对象 
		paramMap.put("name","张三");
		paramMap.put("age",36);
		return "home";
	}
	
}
