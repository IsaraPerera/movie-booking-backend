package com.example.moviebookingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse implements Serializable {
    private String errorCode;
    private String errorDescription;

}
