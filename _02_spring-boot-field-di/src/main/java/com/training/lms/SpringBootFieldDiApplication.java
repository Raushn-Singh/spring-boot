package com.training.lms;

import com.training.lms.delivey.CartItems;
import com.training.lms.delivey.OrderDetails;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class SpringBootFieldDiApplication {

  
	public static void main(String[] args) {
	ConfigurableApplicationContext context=	SpringApplication.run(SpringBootFieldDiApplication.class, args);
	OrderDetails orderDetails = context.getBean("orderDetails",OrderDetails.class);
	System.out.println(orderDetails.getCartItems());
	System.out.println(orderDetails.getOrderAmount());
	System.out.println(orderDetails.getUserEmail());
	System.out.println(orderDetails.getCartItems());
	
	}
	//@Primary
	@Bean
	public CartItems cartItems2() {
		System.out.println("CartItems is created");
		CartItems items=new CartItems();
		items.setNoOfItems(2);
		ArrayList<String> foodItems=new ArrayList<>();
		foodItems.add("Sweets");
		foodItems.add("Chocalte");
		items.setItemNames(foodItems);
		return items;				
	}
}
