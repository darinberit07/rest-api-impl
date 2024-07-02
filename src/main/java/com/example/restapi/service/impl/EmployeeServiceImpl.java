package com.example.restapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.restapi.exception.EmployeeDetailsConflictException;
import com.example.restapi.exception.EmployeeDetailsNotFoundException;
import com.example.restapi.exception.InvalidFieldsException;
import com.example.restapi.model.EmployeeModel;
import com.example.restapi.repository.EmployeeRepository;
import com.example.restapi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeModel getEmployeeDetails(String empId) {
		if(employeeRepository.findById(empId).isEmpty()) {
			throw new EmployeeDetailsNotFoundException("No record of employee "+empId+" is found in the database");
		}
		return employeeRepository.findById(empId).get();
	}

	@Override
	public List<EmployeeModel> getAllEmployeeDetails() {
		return employeeRepository.findAll();
	}

	@Override
	public String addEmployeeDetails(EmployeeModel employee) {
		if(employeeRepository.findById(employee.getEmployeeId()).isPresent()) {
			throw new EmployeeDetailsConflictException("The Employee record for "+employee.getEmployeeId()+" already exists in the database");
		}
		validateEmployee(employee);
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
	
	public void validateEmployee(EmployeeModel employee) {
        if (employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
            throw new InvalidFieldsException("Employee ID is invalid");
        }
        if (employee.getEmployeeName() == null || employee.getEmployeeName().isEmpty()) {
            throw new InvalidFieldsException("Employee name is invalid");
        }
        if (employee.getEmployeeDesignation() == null || employee.getEmployeeDesignation().isEmpty() || !isValidDesignation(employee.getEmployeeDesignation())) {
            throw new InvalidFieldsException("Employee designation is invalid");
        }
        if (employee.getEmployeeGrade() == null || employee.getEmployeeGrade().isEmpty() || !isValidGrade(employee.getEmployeeGrade())) {
            throw new InvalidFieldsException("Employee grade is invalid. Valid fields: T/A/B/C/D (grade is case sensitive)");
        }
        if (employee.getEmployeeMobileNumber() == null || employee.getEmployeeMobileNumber().isEmpty() || !employee.getEmployeeMobileNumber().matches("\\d{10}")) {
            throw new InvalidFieldsException("Employee mobile number is invalid");
        }
    }
	
	public boolean isValidGrade(String empGrade) {
		if(empGrade != "T" && empGrade!= "A" && empGrade != "B" && empGrade != "C" && empGrade != "D" )
			return false;
		return true;
	}
	
	public boolean isValidDesignation(String desgn) {
		if(desgn != "Trainee" && desgn != "Intern" && desgn != "Employee")
			return false;
		return true;
	}

}
