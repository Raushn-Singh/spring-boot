package com.training.springboot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailsCrdentialsConfiguration {

	// filed injection
	//@Value("${app.mail.host}")
	private String emailHost;
	@Value("${app.mail.user}")
	private String emailId;
	//@Value("${app.mail.password}")
	private String password;
	@Autowired
	private DatabaseCofiguration databaseCofiguration;
	
//	
//	public EmailsCrdentialsConfiguration() {
//		super();
//	}
	public EmailsCrdentialsConfiguration(@Value("${app.mail.host}") String emailHost) {
		super();
		this.emailHost = emailHost;
		
	}
	public String getEmailHost() {
		return emailHost;
	}
	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	@Value("${app.mail.password}")
	public void setPassword( String password) {
		System.out.println("setEmailPassword");
		this.password = password;
	}
	
}
