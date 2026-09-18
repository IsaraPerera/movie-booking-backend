package com.example.moviebookingbackend.dao;

import com.example.moviebookingbackend.entity.UserActionEntity;
import com.example.moviebookingbackend.entity.UserEntityecho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActionDAO extends JpaRepository<UserActionEntity, String> {
    UserActionEntity user(UserEntityecho user);
}
