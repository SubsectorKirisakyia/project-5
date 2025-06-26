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

    @NotBlank(message = "Giơi tính phải được khai báo")
    @Pattern(regexp = "male|female", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Giới tính phải là 'nam' hoặc 'nữ'")
    private String gender;

    @Past(message = "Ngày sinh phải là một thời điểm trong quá khứ")
    private LocalDate dateOfBirth;

    @Size(max = 20, message = "Số điện thoại không quá 20 ký tự")
    @Pattern(regexp = "\\+?\\d{0,20}", message = "Số điện thoại có thể bắt đầu bằng dấu + và bắt buộc chỉ có ký tự số sau đó")
    private String phone;

    @Email(message = "Email phải là trường hợp lệ, vd: 'user@email.com'")
    @Size(max = 100, message = "Email không quá 100 ký tự")
    private String email;

    @Size(max = 100, message = "Tên phòng ban không quá 100 ký tự")
    private String department;

    @NotBlank(message = "Mã sinh viên phải được khai báo")
    @Size(max = 20, message = "Mã sinh viên không quá 20 ký tự")
    private String studentCode;
}