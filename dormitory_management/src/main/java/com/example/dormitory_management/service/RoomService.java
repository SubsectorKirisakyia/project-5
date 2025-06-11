package com.example.dormitory_management.service;

import com.example.dormitory_management.dto.RoomDTO;
import com.example.dormitory_management.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    RoomDTO createRoom(RoomDTO room);
    RoomDTO updateRoom(Long roomId, RoomDTO room);
    void deleteRoom(Long roomId);
    Optional<RoomDTO> getRoomById(Long roomId);
    List<RoomDTO> getAllRooms();
}
