package com.example.restapi.service;

import java.util.List;

import com.example.restapi.model.EmployeeModel;

public interface EmployeeService {
	EmployeeModel getEmployeeDetails(String empId);
	List<EmployeeModel> getAllEmployeeDetails();
	List<EmployeeModel> getAllEmployeeDetailsByDesignation(String desgn);
	List<EmployeeModel> getAllEmployeeDetailsByGrade(String grade);
	String addEmployeeDetails(EmployeeModel employee);
	String updateEmployeeDetails(String empId, EmployeeModel employee);
	String deleteEmployeeDetails(String empId);
	String deleteAllEmployeeDetails();
}
