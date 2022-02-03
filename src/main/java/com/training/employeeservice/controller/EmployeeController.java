package com.training.employeeservice.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.employeeservice.model.Employee;
import com.training.employeeservice.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployeeDetails()
	{
		List<Employee> employeeList = employeeRepository.findAll();
		
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("content-type", "application/json");
//		headers.add("time-stamp", LocalDateTime.now().toString());
//		headers.add("token", "dgf45g4df5g4g78");
		
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> findEmployeeDetailsById(@PathVariable int id)
	{
		Employee employee = employeeRepository.findById(id).get();
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee)
	{
		Employee savedEmployee = employeeRepository.save(employee); 
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable int id)
	{
		employeeRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
	{
		Employee updatedEmployee = employeeRepository.save(employee);
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("/employees/name/{name}")
	public ResponseEntity<List<Employee>> findEmployeeByName(@PathVariable String name)
	{
		List<Employee> result=employeeRepository.findByName(name);
		return new ResponseEntity<>(result, HttpStatus.FOUND);		
	}
	
	@GetMapping("/employees/department/{department}")
	public ResponseEntity<List<Employee>> findEmployeeDetailsByDepartment(@PathVariable String department)
	{
		List<Employee> result = employeeRepository.findByDepartment(department);
		return new ResponseEntity<>(result, HttpStatus.FOUND);
	}
	
	@GetMapping("/employees/salary/{salary}")
	public ResponseEntity<List<Employee>> findEmployeeDetailsBySalary(@PathVariable int salary)
	{
		List<Employee> result = employeeRepository.findBySalaryGreaterThan(salary);
		return new ResponseEntity<>(result, HttpStatus.FOUND);
	}
	
	@GetMapping("/employees/department/{department}/{salary}")
	public ResponseEntity<List<Employee>> findEmployeeByDepartmentAndSalary(@PathVariable String department,@PathVariable int salary)
	{
		List<Employee> result = employeeRepository.findByDepartmentAndSalary(department, salary);
		return new ResponseEntity<>(result, HttpStatus.FOUND);
	}

}
