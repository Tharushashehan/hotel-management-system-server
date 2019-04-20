package com.hotelmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hotelmanagementsystem.model.RoomDetails;

@RepositoryRestResource
public interface RoomDetailRepository extends JpaRepository <RoomDetails, Long> {
	
}

