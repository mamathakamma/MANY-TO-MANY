package com.example.mapping1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mapping1.entity.Projects;

public interface ProjectsRepo extends JpaRepository<Projects, Integer>{

}
