package com.hotelmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public User getUserById(@PathVariable(value = "email") String userEmail,
			@PathVariable(value = "password") String userPassword) {
		System.out.println("login...");
		
		try {
			User user = userRepository.findByUserEmail(userEmail)	;
			if (userPassword.equals(user.getUserPassword())) {
				System.out.println("pass...");
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}

	}

	@PostMapping("/authPost")
	public User getUserByIdP(@RequestParam("userEmail") String userEmail,
			@RequestParam("userPassword") String userPassword) {
		System.out.println("email : " + userEmail);
		System.out.println("password : " + userPassword);
		User user = userRepository.findByUserEmail(userEmail);

		if (user.getUserPassword() != null) {
			if (userPassword.equals(user.getUserPassword())) {
				System.out.println("pass...");
				return user;
			} else {
				return null;
			}
		} else {
			System.out.println("fail...");
			return null;
		}
	}

}
