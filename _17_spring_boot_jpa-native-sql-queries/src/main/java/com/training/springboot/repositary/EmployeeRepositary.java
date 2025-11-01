package com.training.springboot.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.springboot.model.Employee;

import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepositary extends JpaRepository<Employee, Long>{

	// indexed query parameter
	@Query(value="SELECT * from employees",nativeQuery = true)
	List<Employee> getAllEmployees();
	
	@Query(value = "select * from employees where email=?1", nativeQuery = true)
	List<Employee> getAllEmployeeByEmail(String email);
	@Query(value = "select * from employees where email=?1 and gender=?2",nativeQuery = true)	
	List<Employee> getAllEmployeesByEmailAndGender(String email,String gender);

	// named query parameter
	@Query(value="select * from employees where salary< :salary and working_hour < :workinghour",nativeQuery = true)
	List<Employee> getEmployeeBySalaryAndWorkinHour(@Param("salary") Double salary,@Param("workinghour") Float workinghour);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO employees (emp_id, dob, email, gender, is_married, joined_at, mobile_no, name, password, salary, working_hour) " +
	               "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11)",
	       nativeQuery = true)
	int addEmployee(Long empId,
	                String dob,
	                String email,
	                String gender,
	                Boolean isMarried,
	                String joinedAt,
	                Long mobileNo,
	                String name,
	                String password,
	                Double salary,
	                Float workingHour);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM employees WHERE emp_id = ?1", nativeQuery = true)
	int deleteEmployeeById(Long id);
}
