package com.training.springboot.databse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SprinBeansConfiguration {

	@Bean(initMethod = "email2LifeCycle",destroyMethod = "email2LifeCycleDestroy")
	public EmailConnection emailConnection2() {
		return new EmailConnection();
	}
	@Bean
	public EmailConnection emailConnection3() {
		return new EmailConnection();
	}
}
