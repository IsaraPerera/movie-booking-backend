package com.example.moviebookingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClimateActionDTO {
    private String climateActionId;
    private String title;
    private String description;
    private double estimatedCO2Reduction;
    private int points;

}
