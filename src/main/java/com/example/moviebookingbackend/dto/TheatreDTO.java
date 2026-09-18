package com.example.moviebookingbackend.dto;

import com.example.moviebookingbackend.entity.enums.TheatreStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheatreDTO {
    private Long id;
    private String name;
    private String location;
    private Integer capacity; 
    private TheatreStatus status;
}
