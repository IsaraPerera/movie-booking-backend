package com.example.moviebookingbackend.entity;

import com.example.moviebookingbackend.entity.enums.BookingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "bookings")
public class BookingEntity {
    @Id
    private String bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private ShowEntity show;

    @Column(nullable = false)
    private String seatNumbers;
    private String numberOfTickets;
    private String totalAmount;
    private String bookingDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @OneToOne(mappedBy = "booking")
    @JsonIgnore
    private PaymentEntity payment;
}