package com.example.moviebookingbackend.service.impl;

import com.example.moviebookingbackend.dao.PaymentDAO;
import com.example.moviebookingbackend.dto.PaymentDTO;
import com.example.moviebookingbackend.entity.PaymentEntity;
import com.example.moviebookingbackend.exceptions.DataNotFoundException;
import com.example.moviebookingbackend.service.PaymentService;
import com.example.moviebookingbackend.util.Conversion;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class PaymentServiceIMPL implements PaymentService {

    private final Conversion conversion;
    private final PaymentDAO paymentDAO;

    @Override
    public PaymentDTO processPayment(PaymentDTO dto) {
        PaymentEntity paymentEntity = conversion.toPaymentEntity(dto);
        PaymentEntity savedPayment = paymentDAO.save(paymentEntity);
        return conversion.toPaymentDTO(savedPayment);
    }



    @Override
    public PaymentDTO getPaymentByBookingId(String bookingId) {
        PaymentEntity paymentEntity = paymentDAO.findByBookingId(bookingId)
                .orElseThrow(() -> new DataNotFoundException("Payment not found for booking id: " + bookingId));
        return conversion.toPaymentDTO(paymentEntity);
    }
}