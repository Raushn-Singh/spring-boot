package com.training.lms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.lms.app.Product;

@Configuration
public class SpringBeansConfiguration {

	@Bean
	public Product product1() {
		System.out.println("Product is created via bean Method");
		return new Product();
	}
}
