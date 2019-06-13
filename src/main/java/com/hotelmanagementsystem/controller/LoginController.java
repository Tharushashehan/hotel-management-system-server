package com.hotelmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import com.hotelmanagementsystem.exception.ResourceNotFoundException;
import com.hotelmanagementsystem.model.User;
import com.hotelmanagementsystem.repository.UserRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserRepository userRepository;

	// Get a Single user
	@GetMapping("/auth/{email}/{password}")
	public User getUserById(@PathVariable(value = "email") String userId,
			@PathVariable(value = "password") String userPassword) {
		System.out.println("login...");
		User user = userRepository.findByUserEmail(userId);
		if (userPassword.equals(String.valueOf(user.getUserPassword()))) {
			System.out.println("pass...");
			return user;
		} else {
			System.out.println("fail...");
			return null;
		}
	}

}
