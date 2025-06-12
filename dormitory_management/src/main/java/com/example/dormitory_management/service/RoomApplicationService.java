package com.example.dormitory_management.service;

import com.example.dormitory_management.dto.RoomApplicationDTO;

import java.util.List;
import java.util.Optional;

public interface RoomApplicationService {
    RoomApplicationDTO createRoomApplication(RoomApplicationDTO roomApplication);
    RoomApplicationDTO updateRoomApplication(Long roomApplicationId, RoomApplicationDTO roomApplication);
    void deleteRoomApplication(Long roomApplicationId);
    Optional<RoomApplicationDTO> getRoomApplicationById(Long roomApplicationId);
    List<RoomApplicationDTO> getAllRoomApplications();
}
