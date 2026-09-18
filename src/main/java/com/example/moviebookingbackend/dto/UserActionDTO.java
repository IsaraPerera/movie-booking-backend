package com.example.moviebookingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserActionDTO {
    private String userActionId;
    private int Quantity;
    private double totalReduction;
    private String completedDate;
    private String userId;
    private String ClimateActionId;
}
