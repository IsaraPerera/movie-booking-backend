package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.dto.ActionCategoryDTO;

import java.util.List;

public interface ActionCategoryService {
    void createActionCategory(ActionCategoryDTO actionCategory);
    ActionCategoryDTO getSelectedActionCategory(String actionCategoryId);
    List<ActionCategoryDTO> getActionCategories();
    void updateActionCategory(String actionCategoryId, ActionCategoryDTO actionCategory);
    void deleteActionCategory(String actionCategoryId);
}
