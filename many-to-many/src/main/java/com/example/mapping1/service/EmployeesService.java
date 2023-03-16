package com.example.mapping1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mapping1.dao.EmployeesDao;
import com.example.mapping1.entity.Employees;
import com.example.mapping1.exception.ResourceNotFoundException;

@Service
public interface EmployeesService {

		Employees save(Employees employees);
		List<EmployeesDao> getAllEmployees();
		EmployeesDao getEmployeesById(int id) throws ResourceNotFoundException;
		EmployeesDao updateEmployees(Employees employees, int id) throws ResourceNotFoundException;
		void deleteEmployees(int id) throws ResourceNotFoundException;
		
}
