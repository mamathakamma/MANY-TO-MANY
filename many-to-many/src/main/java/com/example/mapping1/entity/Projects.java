package com.example.mapping1.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="projects")
public class Projects {
	@Id
	@GeneratedValue
	private int empId;
	private int projectId;
	private String projectName;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinTable(name="employeeproject", joinColumns= {@JoinColumn(name="empId")}, inverseJoinColumns= {@JoinColumn(name="projectId")})
	Set<Employees> employees = new HashSet<Employees>();
}
