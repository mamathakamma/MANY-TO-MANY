package com.example.mapping1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mapping1.dao.ProjectsDao;
import com.example.mapping1.entity.Projects;
import com.example.mapping1.exception.ResourceNotFoundException;

@Service
public interface ProjectsService {
	
	Projects save(Projects projects);
	List<ProjectsDao> getAllProjects();
	ProjectsDao getProjectsById(int id) throws ResourceNotFoundException;
	ProjectsDao updateProjects(Projects projects, int id) throws ResourceNotFoundException;
	void deleteProjects(int id) throws ResourceNotFoundException;
}