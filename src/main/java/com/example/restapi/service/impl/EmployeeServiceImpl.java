package com.example.restapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		if(employeeRepository.findAll().isEmpty()) {
			throw new EmployeeDetailsNotFoundException("Database is empty, no record to fetch");
		}
		return employeeRepository.findAll();
	}
	
	@Override
	public List<EmployeeModel> getAllEmployeeDetailsByDesignation(String desgn) {
		if(employeeRepository.findAll().isEmpty()) {
			throw new EmployeeDetailsNotFoundException("Database is empty, no record to fetch");
		}
		return employeeRepository.findByEmployeeDesignation(desgn);
	}
	
	@Override
	public List<EmployeeModel> getAllEmployeeDetailsByGrade(String grade) {
		if(employeeRepository.findAll().isEmpty()) {
			throw new EmployeeDetailsNotFoundException("Database is empty, no record to fetch");
		}
		return employeeRepository.findByEmployeeGrade(grade);
	}

	@Override
	public List<EmployeeModel> getAllEmployeeDetailsByBillability(String billability) {
		if(employeeRepository.findAll().isEmpty()) {
			throw new EmployeeDetailsNotFoundException("Database is empty, no record to fetch");
		}
		return employeeRepository.findByEmployeeBillability(billability);
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
		if(employeeRepository.findById(empId).isEmpty()) {
			throw new EmployeeDetailsNotFoundException("No record of employee "+empId+" is found in the database to delete");
		}
		employeeRepository.deleteById(empId);
		return "Record deleted for EmployeeID: "+empId;
	}

	@Override
	public String deleteAllEmployeeDetails() {
		if(employeeRepository.findAll().isEmpty()) {
			throw new EmployeeDetailsNotFoundException("Database is Empty, nothing to delete");
		}
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
            throw new InvalidFieldsException("Employee designation is invalid. Valid designations: Trainee/Intern/Employee");
        }
        if (employee.getEmployeeGrade() == null || employee.getEmployeeGrade().isEmpty() || !isValidGrade(employee.getEmployeeGrade())) {
            throw new InvalidFieldsException("Employee grade is invalid. Valid fields: T/A/B/C/D (grade is case sensitive)");
        }
        if (employee.getEmployeeMobileNumber() == null || employee.getEmployeeMobileNumber().isEmpty() || !employee.getEmployeeMobileNumber().matches("\\d{10}")) {
            throw new InvalidFieldsException("Employee mobile number is invalid");
        }
        if(employee.getEmployeeBillability() == null || employee.getEmployeeBillability().isEmpty() || !isValidBillability(employee.getEmployeeBillability())) {
        	throw new InvalidFieldsException("Employee Billability Status is invalid. Valid fields: Billable/IP/Buffer/Intern");
        }
    }
	
	public boolean isValidGrade(String empGrade) {
		return empGrade.equals("T") || empGrade.equals("A") || empGrade.equals("B") || empGrade.equals("C") || empGrade.equals("D");
	}
	
	public boolean isValidDesignation(String desgn) {
		return desgn.equals("Trainee") || desgn.equals("Intern") || desgn.equals("Employee");
	}
	
	public boolean isValidBillability(String bill) {
		return bill.equals("Billable") || bill.equals("IP") || bill.equals("Buffer") || bill.equals("Intern");
	}

}
