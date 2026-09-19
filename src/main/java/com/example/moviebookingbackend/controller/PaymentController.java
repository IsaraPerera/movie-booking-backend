package com.example.moviebookingbackend.controller;

import com.example.moviebookingbackend.dto.PaymentDTO;
import com.example.moviebookingbackend.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentDTO> processPayment(@RequestBody PaymentDTO paymentDTO) {
        return new ResponseEntity<>(paymentService.processPayment(paymentDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentByBookingId(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPaymentByBookingId(id));
    }
}