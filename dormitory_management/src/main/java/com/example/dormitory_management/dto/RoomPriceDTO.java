package com.example.dormitory_management.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomPriceDTO {
    @NotNull(message = "Room ID is required")
    private Long roomId;

    @NotNull(message = "Price per student is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    private BigDecimal pricePerStudent;

    @NotNull(message = "Effective from date is required")
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
}

