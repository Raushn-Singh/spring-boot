package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.springboot.databse.DatabaseConnection;
import com.training.springboot.databse.EmailConnection;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		DatabaseConnection databaseConnection = context.getBean("databaseConnection",DatabaseConnection.class);
		System.out.println(databaseConnection);
		DatabaseConnection databaseConnection2 = context.getBean("databaseConnection",DatabaseConnection.class);
		System.out.println(databaseConnection2);
		EmailConnection emailConnection = context.getBean("emailConnection",EmailConnection.class);
		System.out.println(emailConnection);
		EmailConnection emailConnection2 = context.getBean("emailConnection2",EmailConnection.class);
		System.out.println(emailConnection2);
	}

}

//bean life cycle
// interface
// IntializingBean : Construction
// DisposableBean : destruction


// annotation configuration

