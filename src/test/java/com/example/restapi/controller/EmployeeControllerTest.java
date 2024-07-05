package com.example.restapi.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.restapi.model.EmployeeModel;
import com.example.restapi.service.impl.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeServiceImpl employeeService;

	
	EmployeeModel employee;
	
	@BeforeEach
	void setUp() throws Exception {
		employee = new EmployeeModel("E001", "ABC", "Intern", "T", "1234567890", "Intern");
	}

	@Test
	void testGetEmployeeDetails() throws Exception{
		when(employeeService.getEmployeeDetails("E001")).thenReturn(employee);

        this.mockMvc.perform(get("/employee/get/id/E001"))
        	.andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.employeeId").value("E001"));
	}

	@Test
	void testGetAllEmployeeDetails() throws Exception{
		when(employeeService.getAllEmployeeDetails()).thenReturn(Arrays.asList(employee));
		
		this.mockMvc.perform(get("/employee/get/all"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].employeeId").value("E001"));
		
	}

	@Test
	void testAddEmployeeDetails() throws Exception{
		String requestJson = new ObjectMapper().writeValueAsString(employee);
		
		when(employeeService.addEmployeeDetails(any(EmployeeModel.class))).thenReturn("Employee record with Id: "+employee.getEmployeeId()+" is successfully created");
		
		this.mockMvc.perform(post("/employee/add/new")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson)
			)
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string("Employee record with Id: "+employee.getEmployeeId()+" is successfully created"));
	}

	@Test
	void testUpdateEmployeeDetails() throws Exception{
		String requestJson = new ObjectMapper().writeValueAsString(employee);
		
		when(employeeService.updateEmployeeDetails(eq(employee.getEmployeeId()), any(EmployeeModel.class)))
			.thenReturn("Employee record with Id: "+employee.getEmployeeId()+" is successfully updated");
		
		this.mockMvc.perform(put("/employee/update/id/"+employee.getEmployeeId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestJson)
			)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string("Employee record with Id: "+employee.getEmployeeId()+" is successfully updated"));
	}

	@Test
	void testDeleteEmployeeDetails() throws Exception{
		when(employeeService.deleteEmployeeDetails("E001")).thenReturn("Record deleted for EmployeeID: E001");
		
		this.mockMvc.perform(delete("/employee/delete/id/E001"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string("Record deleted for EmployeeID: E001"));
	}

	@Test
	void testDeleteAllEmployeeDetails() throws Exception{
		when(employeeService.deleteAllEmployeeDetails()).thenReturn("All employee records are successfully deleted");
		
		this.mockMvc.perform(delete("/employee/delete/all"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string("All employee records are successfully deleted"));
	}

}
