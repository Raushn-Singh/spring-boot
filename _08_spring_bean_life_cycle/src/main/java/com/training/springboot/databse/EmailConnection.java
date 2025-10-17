package com.training.springboot.databse;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
public class EmailConnection {
	
	//@Autowired : Notification
    
	public EmailConnection() {
      System.out.println("Email is created");
	}
    @PostConstruct
	public void logicBeanCreation() {
		System.out.println("this is life cycle method : After Construction and configuration");
	}
    @PreDestroy
	public void logicOnBeanDestruction() {
		System.out.println("This is life cycle method : Before Destruction");
	}
    public void email2LifeCycle() {
    	System.out.println("email2LifeCycle..............");
    }
    public void email2LifeCycleDestroy() {
    	System.out.println("email2LifeCycleDestroy.................................");
    }
//    public EmailConnection emailConnection3() {
//    	//notification.sendEmail();
//    }
}
