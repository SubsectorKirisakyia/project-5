package com.example.dormitory_management.service.impl;


import com.example.dormitory_management.dto.RoomPriceDTO;
import com.example.dormitory_management.entity.Room;
import com.example.dormitory_management.entity.RoomPrice;
import com.example.dormitory_management.mappers.RoomPriceMapper;
import com.example.dormitory_management.repository.RoomPriceRepository;
import com.example.dormitory_management.repository.RoomRepository;
import com.example.dormitory_management.service.RoomPriceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomPriceServiceImpl implements RoomPriceService{

    private final RoomPriceRepository roomPriceRepository;
    private final RoomRepository roomRepository;
    @Override
    public RoomPriceDTO createRoomPrice(RoomPriceDTO roomPriceDTO) {
        Room room = roomRepository.findById(roomPriceDTO.getRoomId()).orElseThrow(()-> new EntityNotFoundException("Unable to assign Room for Pricing..."));
        RoomPrice roomPrice = RoomPriceMapper.toEntity(roomPriceDTO, room);
        return RoomPriceMapper.toDTO(roomPriceRepository.save(roomPrice));
    }

    @Override
    public RoomPriceDTO updateRoomPrice(Long roomPriceId, RoomPriceDTO updatedRoomPrice) {
        Room room = roomRepository.findById(updatedRoomPrice.getRoomId()).orElseThrow(()-> new EntityNotFoundException("Unable to assign Room for Pricing..."));
        RoomPrice existingRoomPrice = roomPriceRepository.findById(roomPriceId)
                .orElseThrow(() -> new EntityNotFoundException("RoomPrice not found with ID: " + roomPriceId));

        existingRoomPrice.setRoom(room);
        existingRoomPrice.setPricePerStudent(updatedRoomPrice.getPricePerStudent());
        existingRoomPrice.setEffectiveFrom(updatedRoomPrice.getEffectiveFrom());
        existingRoomPrice.setEffectiveTo(updatedRoomPrice.getEffectiveTo());

        return RoomPriceMapper.toDTO(roomPriceRepository.save(existingRoomPrice));
    }

    @Override
    public void deleteRoomPrice(Long roomPriceId) {
        if (!roomPriceRepository.existsById(roomPriceId)) {
            throw new EntityNotFoundException("RoomPrice not found with ID: " + roomPriceId);
        }
        roomPriceRepository.deleteById(roomPriceId);
    }

    @Override
    public Optional<RoomPriceDTO> getRoomPriceById(Long roomPriceId) {
        RoomPrice roomPrice = roomPriceRepository.findById(roomPriceId).orElseThrow(() -> new EntityNotFoundException("RoomPrice was not found with ID: " + roomPriceId));
        return Optional.of(RoomPriceMapper.toDTO(roomPrice));
    }

    @Override
    public List<RoomPriceDTO> getAllRoomPrices() {
        List<RoomPrice> roomPriceList = roomPriceRepository.findAll();
        return roomPriceList.stream().map(RoomPriceMapper::toDTO).collect(Collectors.toList());
    }
}