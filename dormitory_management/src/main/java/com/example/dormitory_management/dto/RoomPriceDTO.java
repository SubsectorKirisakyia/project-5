package com.example.dormitory_management.dto;

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
    private Long priceId;
    private Long roomId;
    private BigDecimal pricePerStudent;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
}

