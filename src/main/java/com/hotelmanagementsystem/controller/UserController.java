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
	
	//Create User
	@PostMapping("/create")
	public User createUser(@Valid @RequestBody User user) {
	    return userRepository.save(user);
	}
	
	// Get a Single user
	@GetMapping("/single-user/{id}")
	public User getUserById(@PathVariable(value = "id") Long userId) {
	    return userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", userId));
	}
	
	// Update a user
	@PutMapping("/put-user/{id}")
	public User updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {

	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

	    user.setFirst_name(userDetails.getFirst_name());
	    user.setLast_name(userDetails.getLast_name());
	    user.setUser_type(userDetails.getUser_type());
	    user.setUser_image(userDetails.getUser_image());
	    user.setUser_addrs(userDetails.getUser_addrs());
	    user.setUser_password(userDetails.getUser_password());

	    User updatedNode = userRepository.save(user);
	    return updatedNode;
	}
	
	// Delete a user
	@PutMapping("/delete-user/{id}")
	public User deleteUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails) {

	    User user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
	    
	    user.setStatus_code(false);

	    User deletedNote = userRepository.save(user);
	    return deletedNote;
	}

}
