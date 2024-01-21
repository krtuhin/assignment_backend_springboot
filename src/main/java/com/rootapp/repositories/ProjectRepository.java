package com.rootapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rootapp.entities.Project;

public interface ProjectRepository extends MongoRepository<Project, Long> {

}
