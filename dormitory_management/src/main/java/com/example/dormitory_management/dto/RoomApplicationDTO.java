package com.example.dormitory_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomApplicationDTO {
    private Long applicationId;
    private Long studentId;
    private Long roomId; // nullable if not yet assigned
    private LocalDateTime applyDate;
    private String status;
}

