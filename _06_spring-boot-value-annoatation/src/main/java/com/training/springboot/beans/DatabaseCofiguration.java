package com.training.springboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseCofiguration {
    @Value("${db.port.number}")
	//@Value("1521")  
	private int port;
    @Value("${db.url}")
	//@Value("localhost:1521:xe")
	private String url;
    @Value("${db.username}")
	//@Value("root")
	private String userName;
    @Value("${db.password}")
	//@Value("root")
	private String password;
	@Value("${spring.application.name}")
    private String appName;
    
	@Autowired
	private DbProfile dbProfile; //injection of reference of other bean object
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public DbProfile getDbProfile() {
		return dbProfile;
	}
	public void setDbProfile(DbProfile dbProfile) {
		this.dbProfile = dbProfile;
	}
	public DatabaseCofiguration() {
		System.out.println("Db is created...");
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
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
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
} 
