package com.hotelmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import com.hotelmanagementsystem.exception.ResourceNotFoundException;
import com.hotelmanagementsystem.model.RoomCheckIn;
import com.hotelmanagementsystem.model.RoomDetails;
import com.hotelmanagementsystem.repository.RoomCheckInRepository;
import com.hotelmanagementsystem.repository.RoomDetailRepository;
import com.hotelmanagementsystem.utils.DateValidation;

@RestController
public class RoomCheckInController {

	@Autowired
	RoomCheckInRepository roomCheckInRepository;
	@Autowired
	RoomDetailRepository roomDetailRepository;
	

	// Get All check ins
	@GetMapping("/checkin")
	public List<RoomCheckIn> getAllRoomCheckIn() {
		return roomCheckInRepository.findAll();
	}

	// Create check ins
	@PostMapping("/rooms/{id}/checkin")
	public RoomCheckIn createRoomCheckIn(@PathVariable(value = "id") String roomId,
			@Valid @RequestBody RoomCheckIn checkin) {
		List<RoomCheckIn> checkins = roomCheckInRepository.findAll();
		if(DateValidation.compareDate(checkin.getStartDate(), checkin.getEndDate()) && DateValidation.dateCollision(checkin.getStartDate(), checkin.getEndDate(), checkins) == 0) {
			RoomDetails room = roomDetailRepository.findByRoomNo(roomId)
					.orElseThrow(() -> new ResourceNotFoundException("Note", "id", roomId));
			System.out.println(room);
			checkin.setRoomDetails(room);
			
			//return roomCheckInRepository.save(checkin);
			return checkin;
		}else {
			return null;
		}
		
		
	}

	// Get a Single check in
	@GetMapping("/checkin/{id}")
	public RoomCheckIn getRoomCheckInById(@PathVariable(value = "id") Long checkInId) {
		return roomCheckInRepository.findById(checkInId)
				.orElseThrow(() -> new ResourceNotFoundException("Note", "id", checkInId));
	}

	// Update a check in
	@PutMapping("/checkin/{id}")
	public RoomCheckIn updateRoomCheckIn(@PathVariable(value = "id") Long checkInId,
			@Valid @RequestBody RoomCheckIn checkIn) {

		RoomCheckIn roomCheckIn = roomCheckInRepository.findById(checkInId)
				.orElseThrow(() -> new ResourceNotFoundException("room check ins", "id", checkInId));

		roomCheckIn.setStartDate(checkIn.getStartDate());
		roomCheckIn.setStartDate(checkIn.getEndDate());
		roomCheckIn.setRemark(checkIn.getRemark());

		RoomCheckIn updatedNode = roomCheckInRepository.save(roomCheckIn);
		return updatedNode;
	}

	// Delete a rooms
	@DeleteMapping("/checkin/{id}")
	public Boolean deleteRoomCheckIn(@PathVariable(value = "id") Long roomCheckInId) {

		try {
			roomCheckInRepository.deleteById(roomCheckInId);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
