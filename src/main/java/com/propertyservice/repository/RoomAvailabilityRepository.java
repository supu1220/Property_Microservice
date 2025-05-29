package com.propertyservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.propertyservice.entity.RoomAvailability;
import com.propertyservice.entity.Rooms;

public interface RoomAvailabilityRepository extends JpaRepository<RoomAvailability, Long> {

}