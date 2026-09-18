package com.example.moviebookingbackend.dao;

import com.example.moviebookingbackend.entity.MovieEntity;
import com.example.moviebookingbackend.entity.enums.MovieStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieDAO extends JpaRepository<MovieEntity, String> {
    List<MovieEntity> findByMovieStatus(MovieStatus movieStatus);
}