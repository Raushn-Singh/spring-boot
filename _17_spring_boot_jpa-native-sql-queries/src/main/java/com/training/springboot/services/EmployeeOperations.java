package com.training.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springboot.model.Employee;
import com.training.springboot.repositary.EmployeeRepositary;

@Service
public class EmployeeOperations {

	@Autowired
	private EmployeeRepositary employeeRepositary;
	// Native sql:
	public void getAllEmployees() {
		List<Employee> list = employeeRepositary.getAllEmployees();
		list.forEach(System.out::println);
	}
	public void getAllEmployeesByEamil(String eamil) {
		List<Employee> list = employeeRepositary.getAllEmployeeByEmail(eamil);
		list.forEach(System.out::println);
	}
	public void getAllEmployeesByEamilAndGender(String eamil,String gender) {
		List<Employee> list = employeeRepositary.getAllEmployeesByEmailAndGender(eamil,gender);
		list.forEach(System.out::println);
	}
	
	public void  getEmployeeBySalaryAndWorkinHour() {
		List<Employee> list = employeeRepositary. getEmployeeBySalaryAndWorkinHour(500000.0,55.0f);
		list.forEach(System.out::println);
	}
	

    public void addEmployeeData() {
        int result = employeeRepositary.addEmployee(
                101L,
                "1999-10-15",
                "raushan786267@gmail.com",
                "Male",
                false,
                "2024-05-10",
                6206481133L,
                "Raushan Singh",
                "pass123",
                500000.0,
                55.0f
        );

        if (result > 0)
            System.out.println("✅ Employee inserted successfully!");
        else
            System.out.println("❌ Failed to insert employee!");
    }
    public void deleteEmployeeById(Long id) {
       

        employeeRepositary.deleteEmployeeById(id);

        System.out.println("🗑️ Employees with salary less than " + id + " have been deleted.");
    }
}
