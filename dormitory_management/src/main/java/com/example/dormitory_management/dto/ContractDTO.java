package com.example.dormitory_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractDTO {
    private Long contractId;
    private Long studentId;
    private Long roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;
}

