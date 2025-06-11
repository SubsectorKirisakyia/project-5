package com.example.dormitory_management.mappers;

import com.example.dormitory_management.dto.RoomDTO;
import com.example.dormitory_management.entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    public static RoomDTO toDTO(Room room) {
        if (room == null) return null;

        return RoomDTO.builder()
                .roomId(room.getRoomId())
                .roomNumber(room.getRoomNumber())
                .capacity(room.getCapacity())
                .currentOccupancy(room.getCurrentOccupancy())
                .gender(room.getGender())
                .status(room.getStatus())
                .build();
    }

    public static Room toEntity(RoomDTO dto) {
        if (dto == null) return null;

        return Room.builder()
                .roomId(dto.getRoomId())
                .roomNumber(dto.getRoomNumber())
                .capacity(dto.getCapacity())
                .currentOccupancy(dto.getCurrentOccupancy())
                .gender(dto.getGender())
                .status(dto.getStatus())
                .build();
    }
}
