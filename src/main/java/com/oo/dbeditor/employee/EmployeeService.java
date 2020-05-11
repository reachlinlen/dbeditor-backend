package com.oo.dbeditor.employee;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	public List<Employee> getAllEmpDetails() {
		List<Employee> emp = new ArrayList<>();
		empRepository.findAll()
				.forEach(emp::add);
		return emp;
	}
	
	public void addEmployee(Employee emp) {
		empRepository.save(emp);
	}
	
}
