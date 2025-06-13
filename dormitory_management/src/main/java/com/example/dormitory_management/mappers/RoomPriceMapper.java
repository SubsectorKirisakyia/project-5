package com.example.dormitory_management.mappers;

import com.example.dormitory_management.dto.RoomPriceDTO;
import com.example.dormitory_management.entity.Room;
import com.example.dormitory_management.entity.RoomPrice;

public class RoomPriceMapper {

    public static RoomPriceDTO toDTO(RoomPrice entity) {
        if (entity == null) return null;

        return RoomPriceDTO.builder()
                .roomId(entity.getRoom() != null ? entity.getRoom().getRoomId() : null)
                .pricePerStudent(entity.getPricePerStudent())
                .effectiveFrom(entity.getEffectiveFrom())
                .effectiveTo(entity.getEffectiveTo())
                .build();
    }

    public static RoomPrice toEntity(RoomPriceDTO dto, Room room) {
        if (dto == null) return null;

        RoomPrice price = new RoomPrice();
        price.setRoom(room);
        price.setPricePerStudent(dto.getPricePerStudent());
        price.setEffectiveFrom(dto.getEffectiveFrom());
        price.setEffectiveTo(dto.getEffectiveTo());
        return price;
    }

}

