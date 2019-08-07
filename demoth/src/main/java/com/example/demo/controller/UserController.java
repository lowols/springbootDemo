package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
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
		paramMap.put("msg","<h1>啦啦啦</h1>");
		Book book=new Book();
		book.setTitle("钢铁是怎样炼成的");
		Author author=new Author();
		author.setName("Michael");
		book.setAuthor(author);
		paramMap.put("book", book);	
		Book book2=new Book();
		book.setTitle("红楼梦");
		book2.setDesc("中国小说");
		List<Book>books=new ArrayList<Book>();
		books.add(book);
		books.add(book2);
		paramMap.put("books", books);
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
