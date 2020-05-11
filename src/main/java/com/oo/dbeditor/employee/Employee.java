package com.oo.dbeditor.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	private String empID;
	private String firstName;
	private String lastName;
	private Integer salary; 
	
	public Employee() {
		
	}
	
	public Employee(String empID, String firstName, String lastName, Integer salary) {
		super();
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	
	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	
//	@Override
//	public String toString() {
//		return String.format("Employee[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
//	}
}
