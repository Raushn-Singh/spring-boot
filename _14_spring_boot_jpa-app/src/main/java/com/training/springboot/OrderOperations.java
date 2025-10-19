package com.training.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.springboot.entity.OrderInformation;
import com.training.springboot.repositary.OrderInformationRepositary;

@Component
public class OrderOperations {
   @Autowired
	public OrderInformationRepositary orderRepositary;
	
   // add an order
   public void addOrder() {
	   OrderInformation order=new OrderInformation(1, "raushan786267@gmail.com",3 ,"Raushan Singh" , "6206481133", "Buxar", 802111, 500000);
	   orderRepositary.save(order);
   }
   public void loadAllOrder() {
	  List<OrderInformation> list = orderRepositary.findAll();
	  list.forEach(System.out::println);
   }
}
