package com.example.dormitory_management.repository;

import com.example.dormitory_management.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
