package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	 /**
     *新增此方法
     */
     @Override
   protected SpringApplicationBuilder configure( SpringApplicationBuilder builder) {
       // 注意这里要指向原先用main方法执行的Application启动类
       return builder.sources(DemoApplication.class);
   }

}
