package com.example.mapping1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapping1.dao.ProjectsDao;
import com.example.mapping1.entity.Projects;
import com.example.mapping1.exception.ResourceNotFoundException;
import com.example.mapping1.service.ProjectsService;

@RestController
@RequestMapping("projects")
public class ProjectsController {
	
	@Autowired
	private ProjectsService projectsService;
	
	@PostMapping
	public ResponseEntity<Projects> save(@RequestBody Projects projects){
		return new ResponseEntity<Projects>(projectsService.save(projects), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<ProjectsDao> getAllProjects()
	{
		return projectsService.getAllProjects();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProjectsDao> getProjectsById(@PathVariable int id) throws ResourceNotFoundException{
		return new ResponseEntity<ProjectsDao>(projectsService.getProjectsById(id), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProjectsDao> updateProjects(@RequestBody Projects projects, @PathVariable int id) throws ResourceNotFoundException{
		return new ResponseEntity<ProjectsDao>(projectsService.getProjectsById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public void deleteProjectsById(@PathVariable int id) throws ResourceNotFoundException{
		projectsService.deleteProjects(id);
	}
}
