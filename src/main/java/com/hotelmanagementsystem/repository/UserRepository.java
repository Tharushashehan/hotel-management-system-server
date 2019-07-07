package com.hotelmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hotelmanagementsystem.model.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository <User, Long> {
	
    //SELECT * FROM user WHERE UserEmail = {email}
    Optional<User> findByUserEmail(@Param("UserEmail") String UserEmail);
	
}

