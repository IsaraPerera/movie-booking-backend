package com.example.moviebookingbackend.dto;

import com.example.moviebookingbackend.entity.enums.ShowStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowDTO {
    private String id;
    private MovieDTO movie;
    private TheatreDTO theatre;
    private Long movieId;
    private Long theatreId;
    private LocalDate showDate;
    private LocalTime showTime;
    private Double ticketPrice; 
    private ShowStatus status;
}
