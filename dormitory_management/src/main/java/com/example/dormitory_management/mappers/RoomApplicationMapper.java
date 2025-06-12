package com.example.dormitory_management.mappers;

import com.example.dormitory_management.dto.RoomApplicationDTO;
import com.example.dormitory_management.entity.Room;
import com.example.dormitory_management.entity.RoomApplication;
import com.example.dormitory_management.entity.Student;

import java.time.LocalDateTime;

public class RoomApplicationMapper {

    public static RoomApplicationDTO toDTO(RoomApplication entity) {
        if (entity == null) return null;

        return RoomApplicationDTO.builder()
                .applicationId(entity.getApplicationId())
                .studentId(entity.getStudent() != null ? entity.getStudent().getStudentId() : null)
                .roomId(entity.getRoom() != null ? entity.getRoom().getRoomId() : null)
                .applyDate(entity.getApplyDate())
                .status(entity.getStatus())
                .build();
    }

    public static RoomApplication toEntity(RoomApplicationDTO dto, Student student, Room room) {
        if (dto == null) return null;

        RoomApplication app = new RoomApplication();
        app.setApplicationId(dto.getApplicationId());
        app.setStudent(student);
        app.setRoom(room); // nullable
        app.setApplyDate(dto.getApplyDate() != null ? dto.getApplyDate() : LocalDateTime.now());
        app.setStatus(dto.getStatus() != null ? dto.getStatus() : RoomApplication.ApplicationStatus.PENDING);
        return app;
    }
}

