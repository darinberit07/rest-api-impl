package com.example.restapi.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.restapi.model.EmployeeModel;

@DataJpaTest
class EmployeeRepositoryTest {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private EmployeeModel employee;

	@BeforeEach
	void setUp() throws Exception {
		employee = new EmployeeModel("E001", "ABC", "Intern", "T", "1234567890", "Intern");
		employeeRepository.save(employee);
	}

	@AfterEach
	void tearDown() throws Exception {
		employee = null;
		employeeRepository.deleteAll();
	}

	@Test
	void testFindByEmployeeDesignation() {
		List<EmployeeModel> empList = employeeRepository.findByEmployeeDesignation("Intern");
		assertThat(empList.get(0).getEmployeeDesignation()).isEqualTo(employee.getEmployeeDesignation());
		assertThat(empList.get(0).getEmployeeId()).isEqualTo(employee.getEmployeeId());
	}

	@Test
	void testFindByEmployeeBillability_Found() {
		List<EmployeeModel> empList = employeeRepository.findByEmployeeBillability("Intern");
		assertThat(empList.get(0).getEmployeeBillability()).isEqualTo(employee.getEmployeeBillability());
		assertThat(empList.get(0).getEmployeeId()).isEqualTo(employee.getEmployeeId());
	}
	
	@Test
	void testFindByEmployeeBillability_NotFound() {
		List<EmployeeModel> empList = employeeRepository.findByEmployeeBillability("Buffer");
		assertThat(empList.isEmpty()).isTrue();
	}
	
	@Test
	void testFindByEmployeeGrade() {
		List<EmployeeModel> empList = employeeRepository.findByEmployeeGrade("T");
		assertThat(empList.get(0).getEmployeeGrade()).isEqualTo(employee.getEmployeeGrade());
		assertThat(empList.get(0).getEmployeeId()).isEqualTo(employee.getEmployeeId());
	}


}
