package com.training.springboot.modal;

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
@Table(name="employee")
public class Employee {
	
	@Id
    @Column(name="emp_id")
	private long empId;
	//Note: db table column name is exactly same to entity class property name 
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="salary")
	private float salary;
	@Column(name="city")
	private String city;
	@Column(name="gender")
	private String gender;
	@Column(name="country")
	private String country;
}
