package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.dto.GoalDTO;

import java.util.List;

public interface GoalService {
    void saveGoal(GoalDTO goal);
    GoalDTO getSelectedGoal(String goalId);
    List<GoalDTO> getAllGoals();
    void updateGoal(String goalId, GoalDTO goal);
    void deleteGoal(String goalId);
}
