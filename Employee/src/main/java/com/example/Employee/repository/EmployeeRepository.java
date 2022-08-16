package com.example.Employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Employee.entities.Employee;



public interface EmployeeRepository extends CrudRepository <Employee, Integer> {

}
