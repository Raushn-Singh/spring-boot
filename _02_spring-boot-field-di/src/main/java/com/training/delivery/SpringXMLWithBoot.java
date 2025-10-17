package com.training.delivery;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXMLWithBoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ApplicationContext context=new ClassPathXmlApplicationContext("spring-beans.xml");
      
	}

}
