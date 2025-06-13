package com.example.dormitory_management.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {
    @NotBlank(message = "Room number is required")
    @Size(max = 10, message = "Room number must be at most 10 characters")
    private String roomNumber;

    @Min(value = 1, message = "Capacity must be at least 1")
    private int capacity;

    @Min(value = 0, message = "Current occupancy must be 0 or more")
    private int currentOccupancy;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "male|female", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Gender must be either 'male' or 'female'")
    private String gender;

    @NotBlank(message = "Status is required")
    @Pattern(regexp = "available|full", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Status must be either 'available' or 'full'")
    private String status;
}
