package com.employee.management.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.management.entities.Employee;

@Service
public interface EmployeeService {

	public Employee saveEmployee(Employee employee); // Create
	
	public Employee getEmployeeById(int empId);  // Read
	
	public List<Employee> getAllEmployees(); //Read
	
	public Employee updateEmployeeById(Employee employee); // Update
	 
	public String deleteEmployeeById(int empId); // Delete
}
