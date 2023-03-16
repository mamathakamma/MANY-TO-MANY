package com.example.mapping1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mapping1.entity.Employees;

public interface EmployeesRepo extends JpaRepository<Employees, Integer>{

}
