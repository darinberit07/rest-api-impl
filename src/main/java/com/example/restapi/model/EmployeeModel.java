package com.example.restapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_DETAILS")
public class EmployeeModel {
	
	 @Id
	 @Column(name = "EMP_ID")
	 private String employeeId;
	 
	 @Column(name = "EMP_NAME")
	 private String employeeName;
	 
	 @Column(name = "EMP_DESGN")
	 private String employeeDesignation;
	 
	 @Column(name = "EMP_GRADE")
	 private String employeeGrade;
	 
	 @Column(name = "EMP_MOBILE_NO")
	 private String employeeMobileNumber;
	 
	public EmployeeModel() {}

	public EmployeeModel(String employeeId, String employeeName, String employeeDesignation, String employeeGrade,
			String employeeMobileNumber) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDesignation = employeeDesignation;
		this.employeeGrade = employeeGrade;
		this.employeeMobileNumber = employeeMobileNumber;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public String getEmployeeGrade() {
		return employeeGrade;
	}

	public void setEmployeeGrade(String employeeGrade) {
		this.employeeGrade = employeeGrade;
	}

	public String getEmployeeMobileNumber() {
		return employeeMobileNumber;
	}

	public void setEmployeeMobileNumber(String employeeMobileNumber) {
		this.employeeMobileNumber = employeeMobileNumber;
	}
	 
}
