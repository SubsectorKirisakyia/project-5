package com.example.dormitory_management.controller;

import com.example.dormitory_management.dto.ContractDTO;
import com.example.dormitory_management.exception.ResourceNotFoundException;
import com.example.dormitory_management.service.ContractService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @GetMapping
    public ResponseEntity<List<ContractDTO>> getAllContracts() {
        return ResponseEntity.ok(contractService.getAllContracts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractDTO> getContractById(@PathVariable Long id) {
        ContractDTO dto = contractService.getContractById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find contract"));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('admin', 'manager', 'staff')")
    public ResponseEntity<ContractDTO> createContract(@Valid @RequestBody ContractDTO contractDTO) {
        return ResponseEntity.ok(contractService.createContract(contractDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('admin', 'manager', 'staff')")
    public ResponseEntity<ContractDTO> updateContract(@PathVariable Long id, @Valid @RequestBody ContractDTO contractDTO) {
        return ResponseEntity.ok(contractService.updateContract(id, contractDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('admin', 'manager', 'staff')")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        contractService.deleteContract(id);
        return ResponseEntity.noContent().build();
    }
}