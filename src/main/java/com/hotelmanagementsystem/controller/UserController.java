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
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	// Get All users
	@GetMapping("/user-list")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Create User
	@PostMapping("/create")
	public User createUser(@Valid @RequestBody User user) {
		System.out.println(user);
		return userRepository.save(user);
	}

	// Get a Single user
	@GetMapping("/single-user/{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", userId));
	}

	// Update a user
	@PostMapping("/put-user/{id}")
	public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

		user.setUserFName(userDetails.getUserFName());
		user.setUserLName(userDetails.getUserLName());
		user.setUserType(userDetails.getUserType());
		user.setUserImage(userDetails.getUserImage());
		user.setUserAddrs(userDetails.getUserAddrs());
		user.setUserPassword(userDetails.getUserPassword());

		User updatedNode = userRepository.save(user);
		return updatedNode;
	}

	// Delete a user
	@PostMapping("/delete-user/{id}")
	public Boolean deleteUser(@PathVariable(value = "id") Long userId) {

		try {
			userRepository.deleteById(userId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
