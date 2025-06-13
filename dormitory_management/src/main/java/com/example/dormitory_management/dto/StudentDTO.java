package com.example.dormitory_management.dto;
import com.example.dormitory_management.entity.Room;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    @NotBlank(message = "Full name is required")
    @Size(max = 100, message = "Full name must not exceed 100 characters")
    private String fullName;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "male|female", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Gender must be either 'male' or 'female'")
    private String gender;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @Size(max = 20, message = "Phone number must not exceed 20 characters")
    @Pattern(regexp = "\\+?\\d{0,20}", message = "Phone number must be numeric and may start with +")
    private String phone;

    @Email(message = "Email must be valid")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;

    @Size(max = 100, message = "Department name must not exceed 100 characters")
    private String department;

    @NotBlank(message = "Student code is required")
    @Size(max = 20, message = "Student code must not exceed 20 characters")
    private String studentCode;
}