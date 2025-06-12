package com.example.dormitory_management.service;

import com.example.dormitory_management.dto.ContractDTO;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    ContractDTO createContract(ContractDTO contract);
    ContractDTO updateContract(Long contractId, ContractDTO contract);
    void deleteContract(Long contractId);
    Optional<ContractDTO> getContractById(Long contractId);
    List<ContractDTO> getAllContracts();
}
