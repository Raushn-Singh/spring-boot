package com.training.food.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDelivery {

	private String deliveryBoyName;
	@Autowired
	private Order order;
	public String getDeliveryBoyName() {
		return deliveryBoyName;
	}
	public void setDeliveryBoyName(String deliveryBoyName) {
		this.deliveryBoyName = deliveryBoyName;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
