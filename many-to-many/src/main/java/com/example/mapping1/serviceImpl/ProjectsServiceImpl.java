package com.example.mapping1.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.mapping1.dao.ProjectsDao;
import com.example.mapping1.entity.Projects;
import com.example.mapping1.exception.ResourceNotFoundException;
import com.example.mapping1.repository.ProjectsRepo;
import com.example.mapping1.service.ProjectsService;

public class ProjectsServiceImpl implements ProjectsService {
	
	@Autowired
	private ProjectsRepo projectsRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Projects save(Projects projects) {
		return projectsRepo.save(projects);
	}

	@Override
	public List<ProjectsDao> getAllProjects() {
		List<Projects> projects = projectsRepo.findAll();
		List<ProjectsDao> projectsDaos = projects.stream().map(p -> modelMapper.map(p, ProjectsDao.class)).collect(Collectors.toList());
		return projectsDaos;
	}

	@Override
	public ProjectsDao getProjectsById(int id) throws ResourceNotFoundException {
		Optional<Projects> projects = projectsRepo.findById(id);
		if(projects.isPresent())
		{
			return modelMapper.map(projects, ProjectsDao.class);
		}
		else
		{
			throw new ResourceNotFoundException("Projects", id);
		}
	}

	@Override
	public ProjectsDao updateProjects(Projects projects, int id) throws ResourceNotFoundException {
		Projects existprojects = projectsRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Projects not found", id));
		existprojects.setProjectId(projects.getProjectId());
		existprojects.setProjectName(projects.getProjectName());
		projectsRepo.save(existprojects);
		return modelMapper.map(existprojects, ProjectsDao.class);
	}

	@Override
	public void deleteProjects(int id) throws ResourceNotFoundException {
		projectsRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Projects not found", id));
		projectsRepo.deleteById(id);
	}

}
