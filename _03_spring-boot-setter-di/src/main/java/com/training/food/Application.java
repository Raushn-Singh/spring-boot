package com.training.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.training.food.delivery.Order;
import com.training.food.delivery.OrderDelivery;
import com.training.food.delivery.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext context= SpringApplication.run(Application.class, args);
	
	 Order order=(Order)context.getBean("order");
	 System.out.println(order);
	 System.out.println(order.getProduct());
	 OrderDelivery orderDelivery = context.getBean("orderDelivery",OrderDelivery.class);
	 System.out.println(orderDelivery.getOrder());
	 System.out.println(orderDelivery.getOrder().getProduct());
	}

}
