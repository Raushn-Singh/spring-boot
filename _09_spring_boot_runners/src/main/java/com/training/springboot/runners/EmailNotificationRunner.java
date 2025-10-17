package com.training.springboot.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)
@Component
public class EmailNotificationRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
      
		for(String arg:args) {
			System.out.println(arg);
		}
		
		
		System.out.println("This is Command Line Runner .....*****8");
      // Logic
      System.out.println("your application is ready to start to do operation");
      System.out.println("Sending email to developer");
      // sent email logic
      System.out.println("email succesfully send");
	}
	public void runAnother() {
		System.out.println("This is not part of springbot runner method");
	}
	

}
