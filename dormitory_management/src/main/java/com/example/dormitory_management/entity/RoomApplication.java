package com.example.dormitory_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "room_applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "apply_date", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime applyDate = LocalDateTime.now();


    @Column(nullable = false)
    private String status = ApplicationStatus.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public class ApplicationStatus {
        public static final String PENDING = "pending";
        public static final String APPROVED = "approved";
        public static final String REJECTED = "rejected";
    }
}
