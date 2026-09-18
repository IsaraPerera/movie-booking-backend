package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.dto.ClimateActionDTO;

import java.util.List;

public interface ClimateActionService {
    void saveClimateAction(ClimateActionDTO climateAction);
    ClimateActionDTO getSelectedClimateAction(String climateActionId);
    List<ClimateActionDTO> getAllClimateActions();
    void updateClimateAction(String climateActionId, ClimateActionDTO climateAction);
    void deleteClimateAction(String climateActionId);
}
