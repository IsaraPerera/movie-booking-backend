package com.example.moviebookingbackend.dao;

import com.example.moviebookingbackend.entity.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowDAO extends JpaRepository<ShowEntity, String> {
    List<ShowEntity> findByMovie_MovieId(String movieId);

    @Query("SELECT s FROM ShowEntity s WHERE s.theatre.theatreId = :theatreId AND s.showDate = :showDate AND s.showTime = :showTime")
    List<ShowEntity> findConflictingShows(
            @Param("theatreId") String theatreId,
            @Param("showDate") String showDate,
            @Param("showTime") String showTime
    );
}