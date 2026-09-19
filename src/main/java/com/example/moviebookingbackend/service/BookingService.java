package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.dto.BookingDTO;
import java.util.List;

public interface BookingService {
    BookingDTO createBooking(BookingDTO dto, Long userId);
    BookingDTO getBookingById(Long id);
    List<BookingDTO> getCustomerBookings(Long userId);
    BookingDTO cancelBooking(Long id);
}