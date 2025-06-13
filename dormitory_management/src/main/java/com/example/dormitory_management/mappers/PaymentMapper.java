package com.example.dormitory_management.mappers;

import com.example.dormitory_management.dto.PaymentDTO;
import com.example.dormitory_management.entity.Contract;
import com.example.dormitory_management.entity.Payment;

public class PaymentMapper {

    public static PaymentDTO toDTO(Payment entity) {
        if (entity == null) return null;

        return PaymentDTO.builder()
                .contractId(entity.getContract() != null ? entity.getContract().getContractId() : null)
                .amount(entity.getAmount())
                .dueDate(entity.getDueDate())
                .paidDate(entity.getPaidDate())
                .status(entity.getStatus())
                .build();
    }

    public static Payment toEntity(PaymentDTO dto, Contract contract) {
        if (dto == null) return null;

        Payment payment = new Payment();
        payment.setContract(contract);
        payment.setAmount(dto.getAmount());
        payment.setDueDate(dto.getDueDate());
        payment.setPaidDate(dto.getPaidDate());
        payment.setStatus(dto.getStatus() != null ? dto.getStatus() : Payment.PaymentStatus.UNPAID);
        return payment;
    }
}

