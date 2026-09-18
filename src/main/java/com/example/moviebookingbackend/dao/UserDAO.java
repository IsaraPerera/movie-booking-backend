package com.example.moviebookingbackend.dao;

import com.example.moviebookingbackend.entity.UserEntityecho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<UserEntityecho, String> {
    Optional<UserEntityecho> findByEmail(String email);
    boolean existsByEmail(String email);
}
