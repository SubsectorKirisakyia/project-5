package com.example.dormitory_management.repository;

import com.example.dormitory_management.entity.RoomPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomPriceRepository extends JpaRepository<RoomPrice, Long> {
}