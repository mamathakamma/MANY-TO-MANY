package com.example.mapping1.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="employeeproject")
public class EmployeeProject {
	@Id
	@GeneratedValue
	private int empId;
	private int projectId;
	
	@ManyToMany(cascade=CascadeType.ALL)
	Set<Employees>employees=new HashSet<Employees>();
	Set<Projects>projects=new HashSet<Projects>();
}
