package com.example.dormitory_management.dto;

import com.example.dormitory_management.validators.ValidDateRange;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ValidDateRange
public class ContractDTO {
    @NotNull(message = "Student ID bắt buộc không để trống")
    private Long studentId;

    @NotNull(message = "Room ID bắt buộc không để trống")
    private Long roomId;

    @NotNull(message = "Ngày đăng ký không để trống")
    private LocalDate startDate;

    @NotNull(message = "Ngày kết thúc phải được điền")
    @Future(message = "Ngày kết thúc phải là một thời điểm trong những ngày tiếp theo")
    private LocalDate endDate;

    @NotNull(message = "Trạng thái phải được khai báo")
    private Boolean isActive;
}

