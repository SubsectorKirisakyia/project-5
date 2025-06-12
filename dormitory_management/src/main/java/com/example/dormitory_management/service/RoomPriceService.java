package com.example.dormitory_management.service;

import com.example.dormitory_management.dto.RoomPriceDTO;

import java.util.List;
import java.util.Optional;

public interface RoomPriceService {
    RoomPriceDTO createRoomPrice(RoomPriceDTO roomPrice);
    RoomPriceDTO updateRoomPrice(Long roomPriceId, RoomPriceDTO roomPrice);
    void deleteRoomPrice(Long roomPriceId);
    Optional<RoomPriceDTO> getRoomPriceById(Long roomPriceId);
    List<RoomPriceDTO> getAllRoomPrices();
}
