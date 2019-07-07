package com.hotelmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hotelmanagementsystem.model.RoomDetails;

@RepositoryRestResource
public interface RoomDetailRepository extends JpaRepository <RoomDetails, Long> {
	
    //SELECT * FROM room_details WHERE roomNo = {RoomNo}
    Optional<RoomDetails> findByRoomNo(@Param("RoomNo") String RoomNo);
	
}

