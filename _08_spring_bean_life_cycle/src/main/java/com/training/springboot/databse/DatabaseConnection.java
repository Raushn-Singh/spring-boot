package com.training.springboot.databse;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Scope("prototype")
@Component
public class DatabaseConnection implements InitializingBean,DisposableBean{

	@Value("localhost:1521")
	private String url;
	private String userName;
	private String passsword;
	public DatabaseConnection() {
		System.out.println("Database is created");
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	@Value("root")
	public void setUserName(String userName) {
		System.out.println("Setting the value of username");
		this.userName = userName;
	}
	public String getPasssword() {
		return passsword;
	}
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
	System.out.println("This is afterPropertiesSet call......");
	}
	@Override
	public void destroy() throws Exception {
     System.out.println("releasing resorces");
	}
}
