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
    @NotNull(message = "Contract ID is required")
    private Long contractId;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be greater than zero")
    private BigDecimal amount;

    @NotNull(message = "Due date is required")
    private LocalDate dueDate;

    private LocalDate paidDate;

    @NotBlank(message = "Status is required")
    @Pattern(regexp = "PAID|PENDING|OVERDUE", message = "Status must be PAID, PENDING, or OVERDUE")
    private String status;
}

