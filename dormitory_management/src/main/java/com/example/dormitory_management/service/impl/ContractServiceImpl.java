package com.example.dormitory_management.service.impl;


import com.example.dormitory_management.dto.ContractDTO;
import com.example.dormitory_management.entity.Contract;
import com.example.dormitory_management.entity.Room;
import com.example.dormitory_management.entity.Student;
import com.example.dormitory_management.mappers.ContractMapper;
import com.example.dormitory_management.repository.ContractRepository;
import com.example.dormitory_management.repository.RoomRepository;
import com.example.dormitory_management.repository.StudentRepository;
import com.example.dormitory_management.service.ContractService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService{
    private final ContractRepository contractRepository;
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;

    @Override
    public ContractDTO createContract(ContractDTO contractDTO) {
        Student student = studentRepository.
                findById(contractDTO.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found with ID for Contract: " + contractDTO.getStudentId()));
        Room room = roomRepository.
                findById(contractDTO.getRoomId())
                .orElseThrow(() -> new EntityNotFoundException("Room not found with ID for Contract: " + contractDTO.getRoomId()));
        Contract contract = ContractMapper.toEntity(contractDTO, student, room);
        return ContractMapper.toDTO(contractRepository.save(contract));
    }

    @Override
    public ContractDTO updateContract(Long contractId, ContractDTO updatedContract) {
        Contract existingContract = contractRepository.findById(contractId)
                .orElseThrow(() -> new EntityNotFoundException("Contract not found with ID: " + contractId));

        if (!updatedContract.getStudentId().equals(existingContract.getStudent().getStudentId())){
            Student student = studentRepository.findById(updatedContract.getStudentId())
                    .orElseThrow(() -> new EntityNotFoundException("Student not found with ID for Contract: " + updatedContract.getStudentId()));
            existingContract.setStudent(student);
        }

        if (!updatedContract.getRoomId().equals(existingContract.getRoom().getRoomId())){
            Room room = roomRepository.
                    findById(updatedContract.getRoomId())
                    .orElseThrow(() -> new EntityNotFoundException("Room not found with ID for Contract: " + updatedContract.getRoomId()));
            existingContract.setRoom(room);
        }

        existingContract.setEndDate(updatedContract.getEndDate());
        existingContract.setIsActive(updatedContract.getIsActive());
        existingContract.setStartDate(updatedContract.getStartDate());

        return ContractMapper.toDTO(contractRepository.save(existingContract));
    }

    @Override
    public void deleteContract(Long contractId) {
        if (!contractRepository.existsById(contractId)) {
            throw new EntityNotFoundException("Contract not found with ID: " + contractId);
        }
        contractRepository.deleteById(contractId);
    }

    @Override
    public Optional<ContractDTO> getContractById(Long contractId) {
        Contract contract = contractRepository.findById(contractId).orElseThrow(() -> new EntityNotFoundException("Contract was not found with ID: " + contractId));
        return Optional.of(ContractMapper.toDTO(contract));
    }

    @Override
    public List<ContractDTO> getAllContracts() {
        List<Contract> contractList = contractRepository.findAll();
        return contractList.stream().map(ContractMapper::toDTO).collect(Collectors.toList());
    }
}