package com.example.dormitory_management.repository;

import com.example.dormitory_management.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}