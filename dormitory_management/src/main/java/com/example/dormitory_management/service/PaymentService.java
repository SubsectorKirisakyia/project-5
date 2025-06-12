package com.example.dormitory_management.service;

import com.example.dormitory_management.dto.PaymentDTO;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    PaymentDTO createPayment(PaymentDTO payment);
    PaymentDTO updatePayment(Long paymentId, PaymentDTO payment);
    void deletePayment(Long paymentId);
    Optional<PaymentDTO> getPaymentById(Long paymentId);
    List<PaymentDTO> getPayments();
}
