package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.springboot.beans.Order;
import com.training.springboot.beans.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		  ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		Product product = context.getBean("product",Product.class);
		System.out.println(product);
		Product product2 = context.getBean("product",Product.class);
		System.out.println(product2);
		Order order = context.getBean("order",Order.class);
		System.out.println(order);
		System.out.println(order.getProduct());
		
		Order order1 = context.getBean("order",Order.class);
		System.out.println(order1);
		System.out.println(order1.getProduct());
		// DI : is it created a new Product to inject in Order ? No
	
	
		System.out.println("*********************** 2nd Product **** ");
		Product product3 = context.getBean("product2",Product.class);
		System.out.println(product3);
	}

	@Bean
	Product product2() {
		return new Product();
	}
}
// 5 beans scopes
// 1. singleton
// this bean scope is default bean scope 
// if we are not defined/configure any bean scope then spring container that bean scope as default
// this scope is taken a reference of from singleton design pattern
// whenever bean scope is singleton , container will create bean Object only once and same bean Object being used everywhere with beanId

// How to configure scope value
// XML : <bean id=beanId name=BeanClass scope=singleton>
// Annotation @Scope : by using this annotation we will configure scope of a bean
// @Scope(value="singleton")



// 2. prototype
// @Scope(value="prototype")
// whenever bean scope is prototype,container will create a new bean object every time
// 

// 3. request

// 4. session
// 5. application
// 6. webSocket


// bean : created by container
// 1. construction
// should logic executed/configuration
// making email connection
// making DB connection
// 2. configuration
// DI: SI,FI,CI

// 3. utilization
// execute logic/remove configuration:calling GC/Realsing Resources
// Closing DB connection
// Closing email connection
// 4. destruction 
