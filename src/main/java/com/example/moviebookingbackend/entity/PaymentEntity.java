package com.example.moviebookingbackend.entity;

import com.example.moviebookingbackend.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "payments")
public class PaymentEntity {
    @Id
    private String paymentId;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private BookingEntity booking;

    @Column(nullable = false)
    private String amount;

    @Column(nullable = false)
    private String paymentDate;

    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}