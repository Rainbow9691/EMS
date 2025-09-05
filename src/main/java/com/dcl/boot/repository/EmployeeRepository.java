package com.dcl.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dcl.boot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//	save()
//	findById()
//	findAll()
//	deleteById()
//	deleteAll()

	@Query("SELECT e FROM Employee e WHERE e.firstName = ?1")
	Employee findByFirstName(String firstName);

//	@Query(value = "select * from Employee where lastName =:m",nativeQuery = true )
//	Employee findByLastName(@Param("m") String lastName);

	@Query("SELECT e FROM Employee e WHERE e.lastName = ?1")
	Employee findByLastName(String lastName);

	boolean existsByEmail(String email);

	boolean existsByMobile(long mobile);
}
