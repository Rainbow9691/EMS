package com.dcl.boot.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.dcl.boot.model.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	List<Employee> findAllEmployees();

	Employee findById(int id);

	Employee updateEmployeeById(int id, Employee employee);

	Employee deleteEmployeeById(int id);

	Employee findByFirstName(String firstName);

	Employee findByLastName(String lastName);
}
