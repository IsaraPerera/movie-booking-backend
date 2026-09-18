package com.example.moviebookingbackend.controller;

import com.example.moviebookingbackend.exceptions.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.moviebookingbackend.dto.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse>handleDataNotFoundException(DataNotFoundException dataNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("ECO001","Required Data Not Found"));
    }
}