package com.dcl.boot.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.dcl.boot.model.Employee;
import com.dcl.boot.service.EmployeeService;
import com.dcl.boot.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public ResponseEntity<ResponseStructure<Employee>> addEmployee(@RequestBody @Valid Employee employee) {
		Employee employee1 = employeeService.addEmployee(employee);

		ResponseStructure<Employee> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("Employee object created successfully");
		rs.setData(employee1);

		return new ResponseEntity<ResponseStructure<Employee>>(rs, HttpStatus.CREATED);
	}

	@GetMapping("/employees")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAll() {
		List<Employee> employees = employeeService.findAllEmployees();

		ResponseStructure<List<Employee>> rs = new ResponseStructure<List<Employee>>();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("all employee data found successfully");
		rs.setData(employees);

		return new ResponseEntity<ResponseStructure<List<Employee>>>(rs, HttpStatus.FOUND);
	}

	@GetMapping("/employees/id/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findById(@PathVariable int id) {
		Employee employee = employeeService.findById(id);
		ResponseStructure<Employee> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("Employee data found successfully");
		rs.setData(employee);

		return new ResponseEntity<ResponseStructure<Employee>>(rs, HttpStatus.FOUND);
	}

	@PutMapping("/employees/id/{id}")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployeeById(@PathVariable int id,
			@RequestBody Employee employee) {
		Employee employee1 = employeeService.updateEmployeeById(id, employee);
		ResponseStructure<Employee> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Employee data updated successfully");
		rs.setData(employee1);

		return new ResponseEntity<ResponseStructure<Employee>>(rs, HttpStatus.OK);
	}

	@DeleteMapping("/employees/id/{id}")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployeeById(@PathVariable int id) {

		Employee employee = employeeService.deleteEmployeeById(id);

		ResponseStructure<Employee> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.NO_CONTENT.value());
		rs.setMessage("Employee data deleted successfully");
		rs.setData(employee);

		return new ResponseEntity<ResponseStructure<Employee>>(rs, HttpStatus.NO_CONTENT);
	}

	@GetMapping("/employees/firstname/{firstName}")
	public ResponseEntity<ResponseStructure<Employee>> findByFirstName(@PathVariable String firstName) {
		Employee employee = employeeService.findByFirstName(firstName);

		ResponseStructure<Employee> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("Employee data found successfully");
		rs.setData(employee);

		return new ResponseEntity<ResponseStructure<Employee>>(rs, HttpStatus.FOUND);
	}

	@GetMapping("/employees/lastname/{lastName}")
	public ResponseEntity<ResponseStructure<Employee>> findByLastName(@PathVariable String lastName) {
		Employee employee = employeeService.findByLastName(lastName);

		ResponseStructure<Employee> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.FOUND.value());
		rs.setMessage("Employee data found successfully");
		rs.setData(employee);

		return new ResponseEntity<ResponseStructure<Employee>>(rs, HttpStatus.FOUND);
	}

}
