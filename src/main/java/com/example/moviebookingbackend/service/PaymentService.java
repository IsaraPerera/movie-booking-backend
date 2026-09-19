package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.dto.PaymentDTO;

public interface PaymentService {
    PaymentDTO processPayment(PaymentDTO dto);
    PaymentDTO getPaymentByBookingId(String bookingId);
}