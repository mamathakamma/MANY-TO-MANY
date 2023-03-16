package com.example.mapping1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapping1.dao.EmployeesDao;
import com.example.mapping1.entity.Employees;
import com.example.mapping1.exception.ResourceNotFoundException;
import com.example.mapping1.service.EmployeesService;

@RestController
@RequestMapping("employees")
public class EmployeesController {
	
	@Autowired
	private EmployeesService employeesService;
	
	@PostMapping
	public ResponseEntity<Employees> save(@RequestBody Employees employees)
	{
		return new ResponseEntity<Employees>(employeesService.save(employees), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<EmployeesDao> getAllEmployees()
	{
		return employeesService.getAllEmployees();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<EmployeesDao> getEmployeesById(@PathVariable int id) throws ResourceNotFoundException{
		return new ResponseEntity<EmployeesDao>(employeesService.getEmployeesById(id), HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<EmployeesDao> updateEmployee(@RequestBody Employees employees, @PathVariable int id) throws ResourceNotFoundException{
		return new ResponseEntity<EmployeesDao>(employeesService.updateEmployees(employees, id), HttpStatus.OK);
	}
	
	public void  deleteEmployees(@PathVariable int id) throws ResourceNotFoundException{
		employeesService.deleteEmployees(id);
	}
	
	
}
