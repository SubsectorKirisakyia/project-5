package com.example.dormitory_management.user_management;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String fullName;
    @NotBlank
    @Pattern(regexp = "admin|manager|staff", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Role must be one of: admin, manager, or staff")
    private String role;
}

