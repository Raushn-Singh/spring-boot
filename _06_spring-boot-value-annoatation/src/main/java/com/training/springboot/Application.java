package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.training.springboot.beans.AwsDatabaseConfiguration;
import com.training.springboot.beans.DatabaseCofiguration;
import com.training.springboot.beans.EmailsCrdentialsConfiguration;
import com.training.springboot.beans.org.OrganizationInfo;

@PropertySource("aws-database.properties")
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		DatabaseCofiguration cofiguration = context.getBean("databaseCofiguration",DatabaseCofiguration.class);
		
		System.out.println(cofiguration.getPort());
		System.out.println(cofiguration.getUrl());
		System.out.println(cofiguration.getUserName());
		System.out.println(cofiguration.getPassword());
		System.out.println(cofiguration.getAppName());
		System.out.println(cofiguration.getDbProfile());
		System.out.println(cofiguration.getDbProfile().getUrl());
		System.out.println("******* Email Data ****");
		EmailsCrdentialsConfiguration emailsCrdentialsConfiguration = context.getBean("emailsCrdentialsConfiguration",EmailsCrdentialsConfiguration.class);
		System.out.println(emailsCrdentialsConfiguration.getEmailHost());
		System.out.println(emailsCrdentialsConfiguration.getEmailId());
		System.out.println(emailsCrdentialsConfiguration.getPassword());
		System.out.println(emailsCrdentialsConfiguration.getClass());

	    System.out.println("***** Org Data ******");
	    OrganizationInfo info = context.getBean("organizationInfo",OrganizationInfo.class);
	    System.out.println(info.getOrgEmpCount());
        info.getDeptNames().forEach(System.out::println);
	
	    System.out.println("******************************");
	    AwsDatabaseConfiguration awsDatabaseConfiguration = context.getBean("awsDatabaseConfiguration",AwsDatabaseConfiguration.class);
	    System.out.println(awsDatabaseConfiguration.getAwsUserName());
	    System.out.println(awsDatabaseConfiguration.getAwsPassword());
	    System.out.println(awsDatabaseConfiguration.getAwsHost());
	
	}

}
