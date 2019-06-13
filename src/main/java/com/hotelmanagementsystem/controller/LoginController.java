package com.hotelmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
		User user = userRepository.findByUserEmail(userEmail);
		if (userPassword.equals(String.valueOf(user.getUserPassword()))) {
			System.out.println("pass...");
			return user;
		} else {
			System.out.println("fail...");
			return null;
		}
	}
	
	@PostMapping("/authPost")
	public User getUserByIdP(@RequestParam("userEmail") String userEmail, @RequestParam("userPassword") String userPassword) {
		System.out.println("email : " + userEmail);
		System.out.println("password : " + userPassword);
		User user = userRepository.findByUserEmail(userEmail);
		if (userPassword.equals(user.getUserPassword())) {
			System.out.println("pass...");
			return user;
		} else {
			System.out.println("fail...");
			return null;
		}
	}

}
