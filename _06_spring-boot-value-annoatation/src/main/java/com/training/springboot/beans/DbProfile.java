package com.training.springboot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("production")
public class DbProfile {
   //@Value("localhost:1521:xe")
	@Value("${db.url}")
   private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	} 
	
}
