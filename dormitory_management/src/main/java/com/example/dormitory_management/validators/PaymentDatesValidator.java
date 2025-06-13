package com.example.dormitory_management.validators;

import com.example.dormitory_management.dto.PaymentDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PaymentDatesValidator implements ConstraintValidator<ValidPaymentDates, PaymentDTO> {

    @Override
    public boolean isValid(PaymentDTO dto, ConstraintValidatorContext context) {
        if (dto.getPaidDate() == null || dto.getDueDate() == null) {
            return true; // @NotNull will handle null dueDate, paidDate may be optional
        }
        return !dto.getPaidDate().isBefore(dto.getDueDate());
    }
}

