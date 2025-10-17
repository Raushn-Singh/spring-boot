package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.springboot.beans.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		System.out.println("Args  size :"+args.length);
		System.out.println("Args  value "+args);
		for(String arg:args) {
		System.out.println(arg);	
		}
		
		System.out.println("Before Run Method");
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		// runner
		System.out.println("After run method");
		Product product = context.getBean(Product.class);
	    System.out.println(product);
	} 

}

// runners are executed immediately after sprigApplication#run() is executed
// runners are executed only once automatically
// runners are used to define logic for loading configuration values , properties , some logic executed
// run getting executed , calls Runner classes


//how to create Runners

//1.CommandLineRunner
//2.ApplicationRunner
// interface->abstract methods
// if we are created component classes by implementing any one of above Runner interface,then that class is called as spring boot runner class
// above Runner interface are having abstract mehtod
// each runner interface hvaing a single abstract method 
// in runner class implemented abstract is executed always
// required logic whic has to be executed we have write inside implemented of runner interface
//CommandLineRunner :
// public void run(String... args )throws Exception;
// How many runners can we add in a sb application?
// Ans: 0-n
// to execute runner in a specific order , we have to use an annotation calls
//@Order























