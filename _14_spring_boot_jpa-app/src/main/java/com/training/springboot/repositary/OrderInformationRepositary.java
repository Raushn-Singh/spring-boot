package com.training.springboot.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.entity.OrderInformation;

public interface OrderInformationRepositary extends JpaRepository<OrderInformation, Long> {

}
