package com.training.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.employeeservice.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	//Naming Convention has to be followed #JPQL
	public List<Employee> findByName(String name);
	public List<Employee> findByDepartment(String department);
	public List<Employee> findBySalaryGreaterThan(int salary);
	
	//CustomQuery
	@Query(value="FROM Employee WHERE department=?1 AND salary=?2")
	public List<Employee> findByDepartmentAndSalary(String department, int salary);

}
