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
// @RequestMapping("/leaves")
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
	    return leaveDetailRepository.findById(leaveId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", leaveId));
	}
	
	// Update a leave
	@PutMapping("/leaves/{id}")
	public LeaveDetails updateLeaveDetails(@PathVariable(value = "id") Long leaveId, @Valid @RequestBody LeaveDetails leaveDetails) {

		LeaveDetails leave = leaveDetailRepository.findById(leaveId)
	            .orElseThrow(() -> new ResourceNotFoundException("leave", "id", leaveId));

		leave.setEmpID(leaveDetails.getEmpID());
		leave.setStartingDate(leaveDetails.getStartingDate());
		leave.setEndDate(leaveDetails.getEndDate());
		leave.setLeaveDurationType(leaveDetails.getLeaveDurationType());
		leave.setLeaveType(leaveDetails.getLeaveType());
		leave.setRemark(leaveDetails.getRemark());

	    LeaveDetails updatedNode = leaveDetailRepository.save(leave);
	    return updatedNode;
	}
	
	// Delete a leave
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
