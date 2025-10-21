package com.training.springboot.entity;

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
  private Long empId;
  private String name;
  private int age;
  private double salary;
  private String city;
  private String gender;
  private String country;

}
