package com.example.moviebookingbackend.dao;

import com.example.moviebookingbackend.entity.ActionCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionCategoryDAO extends JpaRepository<ActionCategoryEntity, String> {

}
