package com.example.Employee.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.example.Employee.entities.Employee;
import com.example.Employee.exception.ResourceNotFoundException;
import com.example.Employee.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		
		return (List<Employee>) employeeRepository.findAll();
	}

	public ResponseEntity<Employee> getEmpID(int id) throws ResourceNotFoundException{
		
		Employee employee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id : " + id));
		return ResponseEntity.ok().body(employee);
	}

	public void SaveOrUpdate(Employee emp) {
		
		employeeRepository.save(emp);
	}

	public Map<String, Boolean> deleteEmp(int id)  throws ResourceNotFoundException{
		Employee employee= employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Does not Exits for ID : " + id));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new java.util.HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
		
	}
	
	
	
}
