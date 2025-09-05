package com.dcl.boot.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcl.boot.exception.EmailAlreadyExistsException;
import com.dcl.boot.exception.EmployeeObjectNotFoundByIdException;
import com.dcl.boot.exception.EmployeeObjectNotFoundByNameException;
import com.dcl.boot.exception.NoEmployeeObjectFoundException;
import com.dcl.boot.exception.PhoneNumberAlreadyExistsException;
import com.dcl.boot.model.Employee;
import com.dcl.boot.repository.EmployeeRepository;
import com.dcl.boot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		if (employeeRepository.existsByEmail(employee.getEmail())) {
			throw new EmailAlreadyExistsException("Email you are trying to insert is already present in the data base");
		} else if (employeeRepository.existsByMobile(employee.getMobile())) {
			throw new PhoneNumberAlreadyExistsException("Phone number you are trying to insert is already present in the data base");
		} else {
			employeeRepository.save(employee);
			return employee;
		}
	}

	@Override
	public List<Employee> findAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		if (employees.isEmpty()) {
			throw new NoEmployeeObjectFoundException("Unable to find any employee in the database");
		} else {
			return employees;
		}
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isEmpty()) {
			throw new EmployeeObjectNotFoundByIdException("failed to find the Employee object");
		} else {
			Employee emp = optional.get();
			return emp;
		}
	}

	@Override
	public Employee updateEmployeeById(int id, Employee employee) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isEmpty()) {
			throw new EmployeeObjectNotFoundByIdException("failed to find the Employee object");
		} else {
			Employee existingEmployee = optional.get();
			employee.setId(existingEmployee.getId());
			return employeeRepository.save(employee);
		}
	}

	@Override
	public Employee deleteEmployeeById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isEmpty()) {
			throw new EmployeeObjectNotFoundByIdException("failed to find the Employee object");
		} else {
			Employee existingEmployee = optional.get();
			employeeRepository.delete(existingEmployee);
			return existingEmployee;
		}
	}

	@Override
	public Employee findByFirstName(String firstName) {
		Employee employee = employeeRepository.findByFirstName(firstName);
		if (employee == null) {
			throw new EmployeeObjectNotFoundByNameException("failed to find the employee object");
		} else {
			return employee;
		}
	}

	@Override
	public Employee findByLastName(String lastName) {
		Employee employee = employeeRepository.findByLastName(lastName);
		if (employee == null) {
			throw new EmployeeObjectNotFoundByNameException("failed to find the employee object");
		} else {
			return employee;
		}
	}
}
