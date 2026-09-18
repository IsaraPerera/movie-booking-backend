package com.example.moviebookingbackend.dto;

import com.example.moviebookingbackend.dto.enums.GoalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoalDTO {
    private String GoalId;
    private String title;
    private String targetReduction;
    private String targetDate;
    private GoalStatus status;
    private String userId;
}
