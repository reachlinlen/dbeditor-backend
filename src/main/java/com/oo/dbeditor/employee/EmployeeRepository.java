package com.oo.dbeditor.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query(nativeQuery = true, value="select * from employee limit :limits")
	public List<Employee> getEmpList(int limits);
	
}
