package com.oo.dbeditor.employee;

import org.springframework.web.bind.annotation.RestController;

import com.oo.dbeditor.employee.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employee")
	@CrossOrigin(origins = "http://localhost:8080")
	public List<Employee> getEmpTblDetails() {
		return empService.getAllEmpDetails();
	}	
	
	@PostMapping("/employee")
	@CrossOrigin(origins = "http://localhost:8080")
	public void addEmpDetails(Employee newEmp) {
		empService.addEmployee(newEmp);
	}
	
	@GetMapping("/employee/all")
	@CrossOrigin(origins = "http://localhost:8080")
	public Object getTableExcel() throws IOException {
		return empService.getFullTable();
	}

}
