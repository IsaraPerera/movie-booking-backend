package com.example.moviebookingbackend.dto;

import com.example.moviebookingbackend.entity.enums.MovieStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private String id;
    private String title;
    private String description;
    private Integer duration; 
    private String language;
    private String genre;
    private String releaseDate;
    private MovieStatus status;
}
