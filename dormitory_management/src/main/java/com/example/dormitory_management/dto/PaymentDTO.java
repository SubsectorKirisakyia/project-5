package com.example.dormitory_management.dto;

import com.example.dormitory_management.validators.ValidPaymentDates;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
@ValidPaymentDates
public class PaymentDTO {
    @NotNull(message = "Contract ID bắt buộc không để trống")
    private Long contractId;

    @NotNull(message = "Số lượng không để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Số lượng phải lớn hơn 0")
    private BigDecimal amount;

    @NotNull(message = "Ngày thanh toán phải được khai báo")
    private LocalDate dueDate;

    private LocalDate paidDate;

    @NotBlank(message = "Cần phải có tình trạng của status hóa đơn")
    @Pattern(regexp = "PAID|PENDING|OVERDUE", message = "Trạng thái phải là một trong: PAID, PENDING, OVERDUE")
    private String status;
}

