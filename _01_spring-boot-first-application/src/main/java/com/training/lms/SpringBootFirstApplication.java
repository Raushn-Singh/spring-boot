package com.training.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.training.app.Order;

//@ComponentScan("com.training")
@SpringBootApplication(scanBasePackages = {"com.training.app","com.training.lms"})
public class SpringBootFirstApplication {

    private final Student student;

    SpringBootFirstApplication(Student student) {
        this.student = student;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context=	SpringApplication.run(SpringBootFirstApplication.class, args);
		Student student=context.getBean("student",Student.class);
		System.out.println(student);
		Order order=context.getBean("order",Order.class);
		System.out.println(order.getProduct());
		
	}
	
	@Bean
	public Student Student2() {
		System.out.println("Creating Student 2 via Bean Method");
		return new Student();
	} //can we create own configuration class --> yes
	// access the bean -->yes
}
