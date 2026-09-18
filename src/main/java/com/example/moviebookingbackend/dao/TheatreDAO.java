package com.example.moviebookingbackend.dao;

import com.example.moviebookingbackend.entity.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreDAO extends JpaRepository<TheatreEntity, String> {
}