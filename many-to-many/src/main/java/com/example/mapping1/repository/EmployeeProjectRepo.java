package com.example.mapping1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mapping1.entity.EmployeeProject;

public interface EmployeeProjectRepo extends JpaRepository<EmployeeProject, Integer> {

}
