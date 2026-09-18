package com.example.moviebookingbackend.dao;

import com.example.moviebookingbackend.entity.GoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalDAO extends JpaRepository<GoalEntity, String> {
}
