package com.example.dormitory_management.service.impl;

import com.example.dormitory_management.dto.PaymentDTO;
import com.example.dormitory_management.entity.Contract;
import com.example.dormitory_management.entity.Payment;
import com.example.dormitory_management.exception.ResourceNotFoundException;
import com.example.dormitory_management.mappers.PaymentMapper;
import com.example.dormitory_management.repository.ContractRepository;
import com.example.dormitory_management.repository.PaymentRepository;
import com.example.dormitory_management.service.PaymentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    private final ContractRepository contractRepository;

    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        Contract contract = contractRepository.findById(paymentDTO.getContractId())
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find Contract with ID: "+paymentDTO.getContractId()+" to assign to Payment"));
        Payment payment = PaymentMapper.toEntity(paymentDTO, contract);
        return PaymentMapper.toDTO(paymentRepository.save(payment));
    }

    @Override
    public PaymentDTO updatePayment(Long paymentId, PaymentDTO updatedPayment) {
        Payment existingPayment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with ID: " + paymentId));

        existingPayment.setAmount(updatedPayment.getAmount());
        existingPayment.setDueDate(updatedPayment.getDueDate());
        existingPayment.setStatus(updatedPayment.getStatus());
        existingPayment.setPaidDate(updatedPayment.getPaidDate());

        if(!updatedPayment.getContractId().equals(existingPayment.getContract().getContractId())){
            Contract contract = contractRepository.findById(updatedPayment.getContractId())
                    .orElseThrow(() -> new EntityNotFoundException("Contract not found with ID for payment: " + updatedPayment.getContractId()));
            existingPayment.setContract(contract);
        }


        return PaymentMapper.toDTO(paymentRepository.save(existingPayment));
    }

    @Override
    public void deletePayment(Long paymentId) {
        if (!paymentRepository.existsById(paymentId)) {
            throw new EntityNotFoundException("Payment not found with ID: " + paymentId);
        }
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public Optional<PaymentDTO> getPaymentById(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElseThrow(() -> new EntityNotFoundException("Payment was not found with ID: " + paymentId));
        return Optional.of(PaymentMapper.toDTO(payment));
    }

    @Override
    public List<PaymentDTO> getPayments() {
        List<Payment> paymentList = paymentRepository.findAll();
        return paymentList.stream().map(PaymentMapper::toDTO).collect(Collectors.toList());
    }
}