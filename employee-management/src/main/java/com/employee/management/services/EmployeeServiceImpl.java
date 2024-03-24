package com.employee.management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.entities.Employee;
import com.employee.management.exceptions.DataNotFoundException;
import com.employee.management.repositories.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	

	@Override
	public Employee saveEmployee(Employee employee) {
		
		Employee newEmployee = new Employee(employee.getEmpName(), employee.getDepartment(), employee.getSalary());
		return employeeRepository.save(newEmployee);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		
		Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
		
		if(optionalEmployee.isEmpty()) {
			throw new DataNotFoundException("No Employee exist with given id : " + empId);
		}
		 
		return optionalEmployee.get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		if(employees.size() == 0) {
			throw new DataNotFoundException("No Emplyees Data found.");
		}
		
		return employees;
	}

	@Override
	public Employee updateEmployeeById(Employee employee) {
		
		Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmpId());
		
		if(optionalEmployee.isEmpty()) {
			throw new DataNotFoundException("Can't Update employee because No Employee exist with given id : " + employee.getEmpId());
		}
		
		Employee emp = optionalEmployee.get();
		emp.setEmpName(employee.getEmpName());
		emp.setDepartment(employee.getDepartment());
		emp.setSalary(employee.getSalary());
		
		return employeeRepository.save(emp);
	}

	@Override
	public String deleteEmployeeById(int empId) {
		
		Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
		
		if(optionalEmployee.isEmpty()) {
			throw new DataNotFoundException("Can't Delete employee because No Employee exist with given id : " + empId);
		}
		
		employeeRepository.deleteById(empId);
		return "Employee deleted, id : " + empId;
	}

}
