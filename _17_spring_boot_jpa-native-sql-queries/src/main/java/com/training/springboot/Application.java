package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.springboot.services.EmployeeOperations;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeOperations operations = context.getBean(EmployeeOperations.class);
//		operations.getAllEmployees();
//		operations.getAllEmployeesByEamil("rohit@gmail.com");
//		operations.getAllEmployeesByEamilAndGender("raushan1@gmail.com","Male");
	    //operations.getEmployeeBySalaryAndWorkinHour();
	   // operations.addEmployeeData();
	    operations.deleteEmployeeById(1L);
	}
 
}
