package com.example.moviebookingbackend.service.impl;

import com.example.moviebookingbackend.dao.BookingDAO;
import com.example.moviebookingbackend.dao.UserDAO;
import com.example.moviebookingbackend.dto.BookingDTO;
import com.example.moviebookingbackend.entity.BookingEntity;
import com.example.moviebookingbackend.entity.UserEntity;
import com.example.moviebookingbackend.exceptions.DataNotFoundException;
import com.example.moviebookingbackend.service.BookingService;
import com.example.moviebookingbackend.util.Conversion;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class BookingServiceIMPL implements BookingService {

    private final Conversion conversion;
    private final BookingDAO bookingDAO;
    private final UserDAO userDAO; // Needed to fetch the user if required when creating/fetching bookings

    @Override
    public BookingDTO createBooking(BookingDTO dto, String userId) {
        // Optional: verify user exists if needed
        UserEntity user = userDAO.findById(String.valueOf(userId))
                .orElseThrow(() -> new DataNotFoundException("User not found with id: " + userId));

        BookingEntity bookingEntity = conversion.toBookingEntity(dto);
        // Set user relationship if your entity requires it
        // bookingEntity.setUser(user);

        BookingEntity savedBooking = bookingDAO.save(bookingEntity);
        return conversion.toBookingDTO(savedBooking);
    }

    @Override
    public BookingDTO getBookingById(String id) {
        BookingEntity bookingEntity = bookingDAO.findById(String.valueOf(id))
                .orElseThrow(() -> new DataNotFoundException("Booking not found with id: " + id));
        return conversion.toBookingDTO(bookingEntity);
    }

    @Override
    public List<BookingDTO> getCustomerBookings(String userId) {
        // Assuming your BookingDAO has a method like findByUserId(Long userId) or findByUser(UserEntity user)
        // List<BookingEntity> entities = bookingDAO.findByUserId(userId);
        // return conversion.toBookingDTOList(entities);
        return List.of();
    }

    @Override
    public BookingDTO cancelBooking(String id) {
        BookingEntity bookingEntity = bookingDAO.findById(String.valueOf(id))
                .orElseThrow(() -> new DataNotFoundException("Booking not found with id: " + id));

        // Update status to cancelled (adjust according to your entity design)
        // bookingEntity.setStatus("CANCELLED");

        BookingEntity updatedBooking = bookingDAO.save(bookingEntity);
        return conversion.toBookingDTO(updatedBooking);
    }
}