package com.hotelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotelmanagementsystem.model.User;

@CrossOrigin(origins="*", allowedHeaders = "*", value = "*")
@RepositoryRestResource
public interface UserRepository extends JpaRepository <User, Long> {
	
    //SELECT * FROM user WHERE UserEmail = {email}
    User findByUserEmail(@Param("UserEmail") String UserEmail);
	
}

