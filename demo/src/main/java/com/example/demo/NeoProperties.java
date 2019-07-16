package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class NeoProperties {
	@Value("${com.neo.title}")
	private String title;
	//省略getter settet方法

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	}
