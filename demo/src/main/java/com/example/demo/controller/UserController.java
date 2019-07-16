package com.example.demo.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.demo.NeoProperties;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class UserController {
	@Value("${com.neo.title}")
	private String title;
	 @Autowired
	 private ServletContext servletContext;
	 @Autowired
	 private NeoProperties neoPro2;
	@RequestMapping("homePage")
	public String goHome(Map<String,Object> paramMap) {
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		ConfigurableApplicationContext cont = (ConfigurableApplicationContext) ac;
		DefaultListableBeanFactory dbf = (DefaultListableBeanFactory) cont.getBeanFactory();
		//Bean构建  BeanService.class 要创建的Bean的Class对象  
		NeoProperties student= (NeoProperties) cont.getBean(NeoProperties.class);
		paramMap.put("name","张三"+"333"+student.getTitle()+neoPro2.getTitle());
		paramMap.put("age",36);
		return "home";
	}
	
	
}
