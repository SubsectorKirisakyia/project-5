package com.example.dormitory_management.repository;

import com.example.dormitory_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}