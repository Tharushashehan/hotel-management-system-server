package com.hotelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hotelmanagementsystem.model.RoomCheckIn;
import com.hotelmanagementsystem.model.RoomDetails;

@RepositoryRestResource
public interface RoomCheckInRepository extends JpaRepository <RoomCheckIn, Long> {
	
}

