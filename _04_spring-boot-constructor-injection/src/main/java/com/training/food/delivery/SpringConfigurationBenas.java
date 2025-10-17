package com.training.food.delivery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SpringConfigurationBenas {
 // @Primary
	@Bean
	public Product getProduct() {
    	System.out.println("Product is created");
		return new Product();
	}
}
