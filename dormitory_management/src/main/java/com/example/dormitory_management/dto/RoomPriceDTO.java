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
    @NotNull(message = "Room ID phải được khai báo")
    private Long roomId;

    @NotNull(message = "Giá cho mỗi sinh viên phải được khai báo")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá phải lớn hơn 0")
    private BigDecimal pricePerStudent;

    @NotNull(message = "Ngày bắt đầu hiệu lực phải được khai báo")
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
}

