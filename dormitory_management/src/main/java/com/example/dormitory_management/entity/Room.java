package com.example.dormitory_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    @Column(nullable = false, length = 10)
    private String roomNumber;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private int currentOccupancy = 0;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String status = RoomStatus.AVAILABLE;

    public class Gender {
        public static final String MALE = "male";
        public static final String FEMALE = "female";
    }


    public class RoomStatus {
        public static final String AVAILABLE = "available";
        public static final String FULL = "full";
    }
}
