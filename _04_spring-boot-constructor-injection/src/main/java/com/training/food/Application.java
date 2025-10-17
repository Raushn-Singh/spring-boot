package com.training.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.food.delivery.Order;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=  SpringApplication.run(Application.class, args);
		Order order = context.getBean("order",Order.class);
		System.out.println(order);
		System.out.println(order.getProduct());
	}

}
