package com.example.mapping1.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.mapping1.dao.EmployeesDao;
import com.example.mapping1.entity.Employees;
import com.example.mapping1.exception.ResourceNotFoundException;
import com.example.mapping1.repository.EmployeesRepo;
import com.example.mapping1.service.EmployeesService;

public class EmployeesServiceImpl implements EmployeesService {
	
	@Autowired
	private EmployeesRepo employeesRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Employees save(Employees employees) {
		return employeesRepo.save(employees);
	}

	@Override
	public List<EmployeesDao> getAllEmployees() {
		List<Employees> employees = employeesRepo.findAll();
		List<EmployeesDao> employeesDaos = employees.stream().map(e -> modelMapper.map(e,EmployeesDao.class)).collect(Collectors.toList());
		return employeesDaos;
	}

	@Override
	public EmployeesDao getEmployeesById(int id) throws ResourceNotFoundException {
		Optional<Employees> employees = employeesRepo.findById(id);
		if(employees.isPresent())
		{
			return modelMapper.map(employees, EmployeesDao.class);
		}
		else
		{
			throw new ResourceNotFoundException("Employees", id);
		}
	}

	@Override
	public EmployeesDao updateEmployees(Employees employees, int id) throws ResourceNotFoundException {
		Employees existemployees = employeesRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employees not present", id));
		existemployees.setFirstName(employees.getFirstName());
		existemployees.setLastName(employees.getLastName());
		existemployees.setProjects(employees.getProjects());
		employeesRepo.save(existemployees);
		return modelMapper.map(existemployees, EmployeesDao.class);
	}

	@Override
	public void deleteEmployees(int id) throws ResourceNotFoundException {
		employeesRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employees not found", id));
		employeesRepo.deleteById(id);		
	}
}
