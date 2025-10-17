package com.training.springboot.beans;

import org.springframework.stereotype.Component;

@Component
public class Product {
     public Product() {
    	 System.out.println("Product is created");
     }
}
