package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.springboot.operations.DatabaseOperationTwo;
import com.training.springboot.operations.DatabaseOperations;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		//DatabaseOperations operations = context.getBean("databaseOperations",DatabaseOperations.class);
		//operations.addProductInformation();
	    //operations.addUserInformation();
	    DatabaseOperationTwo databaseOperationTwo = context.getBean("databaseOperationTwo",DatabaseOperationTwo.class);
	               //databaseOperationTwo.addMoreProducts(); 
	               databaseOperationTwo.loadAllProducts();
	}
}
