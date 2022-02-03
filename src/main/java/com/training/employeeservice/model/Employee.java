package com.training.employeeservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")
@Data @NoArgsConstructor
public class Employee {

	@Id
	@Column(name="employee_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String department;
	private int salary;
	
}
