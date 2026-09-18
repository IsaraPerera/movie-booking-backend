package com.example.moviebookingbackend.dao;

import com.example.moviebookingbackend.entity.ClimateActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClimateActionDAO extends JpaRepository<ClimateActionEntity, String> {
}
