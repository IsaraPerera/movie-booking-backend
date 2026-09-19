package com.example.moviebookingbackend.dao;

import com.example.moviebookingbackend.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingDAO extends JpaRepository<BookingEntity, String> {
    List<BookingEntity> findByUser_UserId(String userId);

    @Query("SELECT b FROM BookingEntity b WHERE b.show.showId = :showId AND b.bookingStatus = 'CONFIRMED'")
    List<BookingEntity> findConfirmedBookingsByShowId(@Param("showId") String showId);
}