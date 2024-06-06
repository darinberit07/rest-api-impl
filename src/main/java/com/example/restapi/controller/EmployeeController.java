package com.example.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.EmployeeModel;
import com.example.restapi.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("get/id/{empId}")
	public EmployeeModel getEmployeeDetails(@PathVariable String empId) {
		return employeeService.getEmployeeDetails(empId);
	}
	
	@GetMapping("get/all")
	public List<EmployeeModel> getAllEmployeeDetails(){
		return employeeService.getAllEmployeeDetails();
	}
	
	@PostMapping("add/new")
	public String addEmployeeDetails(@RequestBody EmployeeModel employee) {
		return employeeService.addEmployeeDetails(employee);
	}
	
	@PutMapping("update/id/{empId}")
	public String updateEmployeeDetails(@PathVariable String empId, @RequestBody EmployeeModel employee) {
		return employeeService.updateEmployeeDetails(empId, employee);
	}
	
	@DeleteMapping("delete/id/{empId}")
	public String deleteEmployeeDetails(@PathVariable String empId) {
		return employeeService.deleteEmployeeDetails(empId);
	}
	
	@DeleteMapping("delete/all")
	public String deleteAllEmployeeDetails() {
		return employeeService.deleteAllEmployeeDetails();
	}
}
