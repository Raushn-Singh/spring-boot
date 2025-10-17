package com.training.springboot.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(3)
@Component
public class PushNotification implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
      
		 
		for(String arg:args) {
			System.out.println(arg);
		}
		
		System.out.println("Sending push notification to manager team....");
      System.out.println("Email is send");
	}

}
