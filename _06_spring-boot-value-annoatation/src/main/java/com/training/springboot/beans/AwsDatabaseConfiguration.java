package com.training.springboot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AwsDatabaseConfiguration {
    @Value("${aws.db.url}")
	private String awsHost;
    @Value("${aws.db.user.name}")
	private String awsUserName;
    @Value("${aws.db.password}")
	private String awsPassword;
	public String getAwsHost() {
		return awsHost;
	}
	public void setAwsHost(String awsHost) {
		this.awsHost = awsHost;
	}
	public String getAwsUserName() {
		return awsUserName;
	}
	public void setAwsUserName(String awsUserName) {
		this.awsUserName = awsUserName;
	}
	public String getAwsPassword() {
		return awsPassword;
	}
	public void setAwsPassword(String awsPassword) {
		this.awsPassword = awsPassword;
	}
	
}
