package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
	    OrderOperations operations = context.getBean(OrderOperations.class);
	    operations.addOrder();
	    operations.loadAllOrder(); 
	}
}
// none
// validate
// update
// create
// create-drop

