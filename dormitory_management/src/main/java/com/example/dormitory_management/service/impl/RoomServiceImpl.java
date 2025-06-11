package com.example.dormitory_management.service.impl;

import com.example.dormitory_management.dto.RoomDTO;
import com.example.dormitory_management.entity.Room;
import com.example.dormitory_management.exception.ResourceNotFoundException;
import com.example.dormitory_management.mappers.RoomMapper;
import com.example.dormitory_management.repository.RoomRepository;
import com.example.dormitory_management.service.RoomService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setRoomNumber(roomDTO.getRoomNumber());
        room.setStatus(roomDTO.getStatus());
        room.setCapacity(roomDTO.getCapacity());
        room.setCurrentOccupancy(room.getCurrentOccupancy());
        room.setGender(room.getGender());
        return RoomMapper.toDTO(roomRepository.save(room));
    }

    @Override
    public RoomDTO updateRoom(Long roomId, RoomDTO updatedRoom) {
        Room existingRoom = roomRepository.findById(roomId)
                .orElseThrow(() -> new EntityNotFoundException("Room not found with ID: " + roomId));

        existingRoom.setRoomNumber(updatedRoom.getRoomNumber());
        existingRoom.setCapacity(updatedRoom.getCapacity());
        existingRoom.setCurrentOccupancy(updatedRoom.getCurrentOccupancy());
        existingRoom.setGender(updatedRoom.getGender());
        existingRoom.setStatus(updatedRoom.getStatus());

        return RoomMapper.toDTO(roomRepository.save(existingRoom));
    }

    @Override
    public void deleteRoom(Long roomId) {
        if (!roomRepository.existsById(roomId)) {
            throw new EntityNotFoundException("Room not found with ID: " + roomId);
        }
        roomRepository.deleteById(roomId);
    }

    @Override
    public Optional<RoomDTO> getRoomById(Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room was not found with ID: " + roomId));
        return Optional.of(RoomMapper.toDTO(room));
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        List<Room> allRooms = roomRepository.findAll();
        return allRooms.stream().map(RoomMapper::toDTO).collect(Collectors.toList());
    }
}
