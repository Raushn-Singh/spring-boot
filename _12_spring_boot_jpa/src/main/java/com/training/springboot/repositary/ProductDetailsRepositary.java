package com.training.springboot.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.entity.ProductDetails;


public interface ProductDetailsRepositary extends JpaRepository<ProductDetails, Integer>{

}
