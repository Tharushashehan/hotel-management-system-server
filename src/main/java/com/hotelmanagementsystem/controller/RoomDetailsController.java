package com.hotelmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import com.hotelmanagementsystem.exception.ResourceNotFoundException;
import com.hotelmanagementsystem.model.RoomDetails;
import com.hotelmanagementsystem.repository.RoomDetailRepository;

@RestController
// @RequestMapping("/rooms")
public class RoomDetailsController {
	
	@Autowired
	RoomDetailRepository roomDetailRepository;
	
	// Get All rooms
	@GetMapping("/rooms")
	public List<RoomDetails> getAllRoomDetails() {
	    return roomDetailRepository.findAll();
	}
	
	//Create rooms
	@PostMapping("/room")
	public RoomDetails createRoomDetails(@Valid @RequestBody RoomDetails room) {
		System.out.println(room);
	    return roomDetailRepository.save(room);
	}
	
	// Get a Single rooms
	@GetMapping("/room/{id}")
	public RoomDetails getRoomDetailsById(@PathVariable(value = "id") Long roomId) {
	    return roomDetailRepository.findById(roomId)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", roomId));
	}
	
	// Update a rooms
	@PutMapping("/room/{id}")
	public RoomDetails updateRoomDetails(@PathVariable(value = "id") Long roomId, @Valid @RequestBody RoomDetails roomDetails) {

		RoomDetails room = roomDetailRepository.findById(roomId)
	            .orElseThrow(() -> new ResourceNotFoundException("room", "id", roomId));

		room.setRoomNo(roomDetails.getRoomNo());
		room.setRoomType(roomDetails.getRoomType());
		room.setRoomPrice(roomDetails.getRoomPrice());
		room.setRoomImage(roomDetails.getRoomImage());
		room.setRoomDiscription(roomDetails.getRoomDiscription());

	    RoomDetails updatedNode = roomDetailRepository.save(room);
	    return updatedNode;
	}
	
	// Delete a rooms
	@DeleteMapping("/room/{id}")
	public Boolean deleteRoomDetails(@PathVariable(value = "id") Long roomId) {

		try {
			roomDetailRepository.deleteById(roomId);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}
