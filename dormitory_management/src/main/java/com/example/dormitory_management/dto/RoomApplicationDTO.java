package com.example.dormitory_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotNull(message = "Student ID phải được khai báo")
    private Long studentId;

    private Long roomId;

    @NotNull(message = "Apply date is required")
    private LocalDateTime applyDate;

    @NotBlank(message = "Status is required")
    @Pattern(regexp = "pending|approved|rejected", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Status must be one of: pending, approved, or rejected")
    private String status;
}

