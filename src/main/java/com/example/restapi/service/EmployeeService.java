package com.example.restapi.service;

import java.util.List;

import com.example.restapi.model.EmployeeModel;

public interface EmployeeService {
	EmployeeModel getEmployeeDetails(String empId);
	List<EmployeeModel> getAllEmployeeDetails();
	String addEmployeeDetails(EmployeeModel employee);
	String updateEmployeeDetails(String empId, EmployeeModel employee);
	String deleteEmployeeDetails(String empId);
	String deleteAllEmployeeDetails();
}
