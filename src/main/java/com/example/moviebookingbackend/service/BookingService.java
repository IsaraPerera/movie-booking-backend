package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.dto.BookingDTO;
import java.util.List;

public interface BookingService {
    BookingDTO createBooking(BookingDTO dto, String userId);
    BookingDTO getBookingById(String id);
    List<BookingDTO> getCustomerBookings(String userId);
    BookingDTO cancelBooking(String id);
}