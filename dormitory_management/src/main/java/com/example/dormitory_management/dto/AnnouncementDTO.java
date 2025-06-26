package com.example.dormitory_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnouncementDTO {
    @NotBlank(message = "Tiêu đề không để trống")
    @Size(max = 100, message = "Tiêu đề nhiều nhất phải dưới 100 ký tự")
    private String title;

    @NotBlank(message = "Nội dung không để trống")
    @Size(max = 1000, message = "Nội dung không thể chứa hơn 1000 ký tự")
    private String content;

    private LocalDateTime createdAt;
}

