package com.example.Employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.entities.Employee;
import com.example.Employee.exception.ResourceNotFoundException;
import com.example.Employee.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/emp")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmpID(@PathVariable ("id") int id) throws ResourceNotFoundException{
		return employeeService.getEmpID(id);
	}
	
	@PutMapping("/emp/add")
	public Employee updateEmp(@RequestBody Employee emp){
		 employeeService.SaveOrUpdate(emp);
		 return emp;
	}
	
	@DeleteMapping("/emp/{id}")
	public Map<String, Boolean> deleteEmp(@PathVariable ("id") int id)  throws ResourceNotFoundException{
		return employeeService.deleteEmp(id);
				 
	}
}
