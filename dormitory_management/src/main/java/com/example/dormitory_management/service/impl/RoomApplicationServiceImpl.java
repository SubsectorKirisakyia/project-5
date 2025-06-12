package com.example.dormitory_management.service.impl;


import com.example.dormitory_management.dto.RoomApplicationDTO;
import com.example.dormitory_management.dto.RoomApplicationDTO;
import com.example.dormitory_management.entity.Room;
import com.example.dormitory_management.entity.RoomApplication;
import com.example.dormitory_management.entity.Student;
import com.example.dormitory_management.exception.ResourceNotFoundException;
import com.example.dormitory_management.mappers.RoomApplicationMapper;
import com.example.dormitory_management.repository.RoomApplicationRepository;
import com.example.dormitory_management.repository.RoomRepository;
import com.example.dormitory_management.repository.StudentRepository;
import com.example.dormitory_management.service.RoomApplicationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomApplicationServiceImpl implements RoomApplicationService{
    private final RoomApplicationRepository roomApplicationRepository;
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;

    @Override
    public RoomApplicationDTO createRoomApplication(RoomApplicationDTO roomApplicationDTO) {
        Student student = studentRepository.findById(roomApplicationDTO.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find Student with ID to assign to Room Application"));
        Room room = roomRepository.findById(roomApplicationDTO.getRoomId())
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find Room with ID to assign to Room Application"));
        RoomApplication roomApplication = RoomApplicationMapper.toEntity(roomApplicationDTO, student, room);
        return RoomApplicationMapper.toDTO(roomApplicationRepository.save(roomApplication));
    }

    @Override
    public RoomApplicationDTO updateRoomApplication(Long roomApplicationId, RoomApplicationDTO updatedRoomApplication) {
        RoomApplication existingRoomApplication = roomApplicationRepository.findById(roomApplicationId)
                .orElseThrow(() -> new EntityNotFoundException("RoomApplication not found with ID: " + roomApplicationId));
        Student student = studentRepository.findById(updatedRoomApplication.getStudentId()).orElseThrow(() -> new EntityNotFoundException("Unable to assign Student for room application"));

        existingRoomApplication.setStatus(updatedRoomApplication.getStatus());
        existingRoomApplication.setApplyDate(updatedRoomApplication.getApplyDate());
        existingRoomApplication.setStudent(student);

        return RoomApplicationMapper.toDTO(roomApplicationRepository.save(existingRoomApplication));
    }

    @Override
    public void deleteRoomApplication(Long roomApplicationId) {
        if (!roomApplicationRepository.existsById(roomApplicationId)) {
            throw new EntityNotFoundException("RoomApplication not found with ID: " + roomApplicationId);
        }
        roomApplicationRepository.deleteById(roomApplicationId);
    }

    @Override
    public Optional<RoomApplicationDTO> getRoomApplicationById(Long roomApplicationId) {
        RoomApplication roomApplication = roomApplicationRepository.findById(roomApplicationId).orElseThrow(() -> new EntityNotFoundException("RoomApplication was not found with ID: " + roomApplicationId));
        return Optional.of(RoomApplicationMapper.toDTO(roomApplication));
    }

    @Override
    public List<RoomApplicationDTO> getAllRoomApplications() {
        List<RoomApplication> roomApplicationList = roomApplicationRepository.findAll();
        return roomApplicationList.stream().map(RoomApplicationMapper::toDTO).collect(Collectors.toList());
    }
}