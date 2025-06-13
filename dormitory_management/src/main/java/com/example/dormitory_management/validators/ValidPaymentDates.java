package com.example.dormitory_management.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PaymentDatesValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPaymentDates {
    String message() default "Paid date must not be before due date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

