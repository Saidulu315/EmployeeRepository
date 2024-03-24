package com.employee.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.employee.management.entities.Employee;
import com.employee.management.services.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	
	
	@PostMapping("/save")
	public ResponseEntity<Employee> save(@RequestBody Employee employee){
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.saveEmployee(employee));
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getById(@PathVariable int id){
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Employee>> getAll(){
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployees());
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateById(@RequestBody Employee employee){
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployeeById(employee));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable int id){
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteEmployeeById(id));
	}

}
