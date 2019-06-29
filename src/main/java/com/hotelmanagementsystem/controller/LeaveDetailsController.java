package com.hotelmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import com.hotelmanagementsystem.exception.ResourceNotFoundException;
import com.hotelmanagementsystem.model.LeaveDetails;
import com.hotelmanagementsystem.repository.LeaveDetailRepository;

@RestController
@RequestMapping("/leaves")
public class LeaveDetailsController {
	
	@Autowired
	LeaveDetailRepository leaveDetailRepository;
	
	// Get All leaves
	@GetMapping("/leaves")
	public List<LeaveDetails> getAllLeaveDetails() {
	    return leaveDetailRepository.findAll();
	}
	
	//Create leaves
	@PostMapping("/leaves")
	public LeaveDetails createLeaveDetails(@Valid @RequestBody LeaveDetails leave) {
		System.out.println(leave);
	    return leaveDetailRepository.save(leave);
	}
	
	// Get a Single leaves
	@GetMapping("/leaves/{id}")
	public LeaveDetails getLeaveDetailsById(@PathVariable(value = "id") Long leaveId) {
	    return leaveDetailRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", userId));
	}
	
	// Update a user
	@PutMapping("/leaves/{id}")
	public LeaveDetails updateLeaveDetails(@PathVariable(value = "id") Long userId, @Valid @RequestBody LeaveDetails userDetails) {

		LeaveDetails user = leaveDetailRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

	    user.setUserFName(userDetails.getUserFName());
	    user.setUserLName(userDetails.getUserLName());
	    user.setUserType(userDetails.getUserType());
	    user.setUserImage(userDetails.getUserImage());
	    user.setUserAddrs(userDetails.getUserAddrs());
	    user.setUserPassword(userDetails.getUserPassword());

	    LeaveDetails updatedNode = leaveDetailRepository.save(user);
	    return updatedNode;
	}
	
	// Delete a user
	@DeleteMapping("/leaves/{id}")
	public Boolean deleteLeaveDetails(@PathVariable(value = "id") Long leaveId) {

		try {
			leaveDetailRepository.deleteById(leaveId);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
