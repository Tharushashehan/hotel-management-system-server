package com.hotelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hotelmanagementsystem.model.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository <User, Long> {
	
}
