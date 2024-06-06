package com.example.restapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.model.EmployeeModel;
import com.example.restapi.repository.EmployeeRepository;
import com.example.restapi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired(required = false)
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeModel getEmployeeDetails(String empId) {
		return employeeRepository.findById(empId).get();
	}

	@Override
	public List<EmployeeModel> getAllEmployeeDetails() {
		return employeeRepository.findAll();
	}

	@Override
	public String addEmployeeDetails(EmployeeModel employee) {
		employeeRepository.save(employee);
		return "Employee record with Id: "+employee.getEmployeeId()+" is successfully created";
	}

	@Override
	public String updateEmployeeDetails(String empId, EmployeeModel employee) {
		employeeRepository.save(employee);
		return "Employee record with Id: "+employee.getEmployeeId()+" is successfully updated";
	}

	@Override
	public String deleteEmployeeDetails(String empId) {
		employeeRepository.deleteById(empId);
		return "Record deleted for EmployeeID: "+empId;
	}

	@Override
	public String deleteAllEmployeeDetails() {
		employeeRepository.deleteAll();
		return "All employee records are successfully deleted";
	}

}
