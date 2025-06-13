package com.example.dormitory_management.mappers;

import com.example.dormitory_management.dto.ContractDTO;
import com.example.dormitory_management.entity.Contract;
import com.example.dormitory_management.entity.Room;
import com.example.dormitory_management.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

public class ContractMapper {

    public static ContractDTO toDTO(Contract entity) {
        if (entity == null) return null;

        return ContractDTO.builder()
                .studentId(entity.getStudent() != null ? entity.getStudent().getStudentId() : null)
                .roomId(entity.getRoom() != null ? entity.getRoom().getRoomId() : null)
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .isActive(entity.getIsActive())
                .build();
    }

    public static Contract toEntity(ContractDTO dto, Student student, Room room) {
        if (dto == null) return null;

        return Contract.builder()
                .student(student)
                .room(room)
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .isActive(dto.getIsActive() != null ? dto.getIsActive() : true)
                .build();
    }

}

