package com.training.food.delivery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SpringConfigurationBeans {
	//@Primary
	@Bean("productTwo")
	public Product getProduct() {
		System.out.println("Object via configuration");
		return new Product();
	}
}
