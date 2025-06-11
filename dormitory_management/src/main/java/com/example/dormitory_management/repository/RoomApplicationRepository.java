package com.example.dormitory_management.repository;

import com.example.dormitory_management.entity.RoomApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomApplicationRepository extends JpaRepository<RoomApplication, Long> {
}