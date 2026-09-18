package com.example.moviebookingbackend.dto;

import com.example.moviebookingbackend.entity.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private Long id;
    private Long userId;
    private String userName;
    private ShowDTO show;

    private Long showId;
    private List<String> seatNumbers;
    private Integer numberOfTickets;

    private Double totalAmount; 
    private LocalDateTime bookingDate;
    private BookingStatus status;
}
