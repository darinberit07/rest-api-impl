package com.example.restapi.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.restapi.exception.EmployeeDetailsConflictException;
import com.example.restapi.exception.EmployeeDetailsNotFoundException;
import com.example.restapi.exception.InvalidFieldsException;
import com.example.restapi.model.EmployeeModel;
import com.example.restapi.repository.EmployeeRepository;

class EmployeeServiceImplTest {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	private EmployeeModel employee;
	AutoCloseable autoCloseable;

	@BeforeEach
	void setUp() throws Exception {
		autoCloseable = MockitoAnnotations.openMocks(this);
		employee = new EmployeeModel("E001", "ABC", "Intern", "T", "1234567890", "Intern");
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void testGetEmployeeDetails() {
		when(employeeRepository.findById("E001")).thenReturn(Optional.ofNullable(employee));
		EmployeeModel retrievedEmployee = employeeService.getEmployeeDetails("E001");
		assertNotNull(retrievedEmployee);
		assertThat(retrievedEmployee.getEmployeeName()).isEqualTo(employee.getEmployeeName());
	}

	@Test
	void testGetAllEmployeeDetails() {
		when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
		List<EmployeeModel> retrievedEmployeeList = employeeService.getAllEmployeeDetails();
		assertFalse(retrievedEmployeeList.isEmpty());
	}
	
	@Test
	void testGetEmployeeDetails_NotFound() {
		when(employeeRepository.findById("E001")).thenReturn(Optional.empty());
		assertThrows(EmployeeDetailsNotFoundException.class, ()->employeeService.getEmployeeDetails("E001"));
	}
	
	@Test
	void testGetAllEmployeeDetails_NotFound() {
		when(employeeRepository.findAll()).thenReturn(List.of());
		assertThrows(EmployeeDetailsNotFoundException.class, ()->employeeService.getAllEmployeeDetails());
	}

	@Test
	void testAddEmployeeDetails() {
		when(employeeRepository.findById(anyString())).thenReturn(Optional.empty());
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertThat(employeeService.addEmployeeDetails(employee))
			.isEqualTo("Employee record with Id: "+employee.getEmployeeId()+" is successfully created");
		
	}
	
	@Test
	void testAddEmployeeDetails_Conflict() {
		when(employeeRepository.findById(employee.getEmployeeId())).thenReturn(Optional.ofNullable(employee));
		assertThrows(EmployeeDetailsConflictException.class, ()->employeeService.addEmployeeDetails(employee));
	}

	@Test
	void testUpdateEmployeeDetails() {
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertThat(employeeService.updateEmployeeDetails(employee.getEmployeeId(), employee))
			.isEqualTo("Employee record with Id: "+employee.getEmployeeId()+" is successfully updated");
	}

	@Test
	void testDeleteEmployeeDetails() {
		when(employeeRepository.findById(anyString())).thenReturn(Optional.ofNullable(employee));
		doNothing().when(employeeRepository).deleteById("E001");
		assertThat(employeeService.deleteEmployeeDetails("E001"))
			.isEqualTo("Record deleted for EmployeeID: E001");
	}

	@Test
	void testDeleteAllEmployeeDetails() {
		when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));
		doNothing().when(employeeRepository).deleteAll();
		assertThat(employeeService.deleteAllEmployeeDetails())
			.isEqualTo("All employee records are successfully deleted");
	}

	@Test
	void testValidateEmployee() {
		employee.setEmployeeGrade("X"); //Invalid grade
		assertThrows(InvalidFieldsException.class, ()->employeeService.validateEmployee(employee));
		
		employee.setEmployeeMobileNumber("123456789"); //9 numbers instead of 10
		assertThrows(InvalidFieldsException.class, ()->employeeService.validateEmployee(employee));
		
	}

}
