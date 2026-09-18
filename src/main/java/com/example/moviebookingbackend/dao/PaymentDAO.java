package com.example.moviebookingbackend.dao;

import com.example.moviebookingbackend.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentDAO extends JpaRepository<PaymentEntity, String> {
    Optional<PaymentEntity> findByBooking_BookingId(String bookingId);
}