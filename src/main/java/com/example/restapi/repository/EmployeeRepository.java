package com.example.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, String>{
	List<EmployeeModel> findByEmployeeDesignation(String desgn);
	List<EmployeeModel> findByEmployeeBillability(String billability);
	List<EmployeeModel> findByEmployeeGrade(String grade);
}
