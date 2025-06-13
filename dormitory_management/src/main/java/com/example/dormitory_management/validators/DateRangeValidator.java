package com.example.dormitory_management.validators;

import com.example.dormitory_management.dto.ContractDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, ContractDTO> {

    @Override
    public boolean isValid(ContractDTO contract, ConstraintValidatorContext context) {
        if (contract.getStartDate() == null || contract.getEndDate() == null) {
            return true; // Let @NotNull handle missing values
        }
        return contract.getStartDate().isBefore(contract.getEndDate());
    }
}

