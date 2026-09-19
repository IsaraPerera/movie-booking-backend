package com.example.moviebookingbackend.service.impl;

import com.example.moviebookingbackend.dao.BookingDAO;
import com.example.moviebookingbackend.dto.BookingDTO;
import com.example.moviebookingbackend.entity.BookingEntity;
import com.example.moviebookingbackend.exceptions.DataNotFoundException;
import com.example.moviebookingbackend.service.BookingService;
import com.example.moviebookingbackend.util.Conversion;
import com.example.moviebookingbackend.util.IDGenerate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class BookingServiceIMPL implements BookingService {
    private final Conversion conversion;
    private final BookingDAO BookingDAO;
    @Override
    public void saveBooking(BookingDTO Booking) {
        //save data
        BookingEntity BookingEntity = conversion.toBookingEntity(Booking);
        BookingDAO.save(conversion.toBookingEntity(Booking));
    }

    @Override
    public BookingDTO getSelectedBooking(String BookingId) {
        BookingEntity BookingEntity = BookingDAO.findById(BookingId)
                .orElseThrow(() ->new DataNotFoundException("Booking not Found"));
        return conversion.toBookingDTO(BookingEntity);
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return conversion.toBookingDTOList(BookingDAO.findAll());
    }

    @Override
    public void updateBooking(String BookingId, BookingDTO Booking) {
        System.out.println("To be updated the Booking id : " +BookingId+ "as:" + Booking.toString());
    }

    @Override
    public void deleteBooking(String BookingId) {
        BookingEntity foundBooking = BookingDAO.findById(BookingId)
                .orElseThrow(()->new DataNotFoundException("user not found"));
        BookingDAO.delete(foundBooking);
    }

    @Override
    public BookingDTO createBooking(BookingDTO dto, Long userId) {
        return null;
    }

    @Override
    public BookingDTO getBookingById(Long id) {
        return null;
    }

    @Override
    public List<BookingDTO> getCustomerBookings(Long userId) {
        return List.of();
    }

    @Override
    public BookingDTO cancelBooking(Long id) {
        return null;
    }
}
