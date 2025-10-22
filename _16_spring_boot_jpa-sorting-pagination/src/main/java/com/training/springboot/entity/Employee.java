package com.training.springboot.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
public class Employee {
	@Id
	@Column(name="emp_id")
	private Long empId;
	private String name;
	private String email;
	private String password;
	private String gender;
	private Long mobileNo;
	private Boolean isMarried;
	private Float workingHour;
	private Double salary;
	private LocalDate dob;
	private LocalDateTime joinedAt;
}
