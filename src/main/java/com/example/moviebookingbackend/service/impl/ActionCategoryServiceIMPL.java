package com.example.moviebookingbackend.service.impl;

import com.example.moviebookingbackend.dao.ActionCategoryDAO;
import com.example.moviebookingbackend.dto.ActionCategoryDTO;
import com.example.moviebookingbackend.entity.ActionCategoryEntity;
import com.example.moviebookingbackend.exceptions.DataNotFoundException;
import com.example.moviebookingbackend.service.ActionCategoryService;
import com.example.moviebookingbackend.util.Conversion;
import com.example.moviebookingbackend.util.IDGenerate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Transactional
@RequiredArgsConstructor
@Service
public class ActionCategoryServiceIMPL implements ActionCategoryService {
    private final Conversion conversion;
    private final ActionCategoryDAO actionCategoryDAO;
    @Override
    public void createActionCategory(ActionCategoryDTO actionCategory) {
        actionCategory.setCategoryId(IDGenerate.actionCategoryId());
        //save data
        ActionCategoryEntity actionCategoryEntity = conversion.toActionCategoryEntity(actionCategory);
        actionCategoryDAO.save(conversion.toActionCategoryEntity(actionCategory));
    }

    @Override
    public ActionCategoryDTO getSelectedActionCategory(String actionCategoryId) {
        ActionCategoryEntity actionCategoryEntity = actionCategoryDAO.findById(actionCategoryId)
                .orElseThrow(() ->new DataNotFoundException("ActionCategory not Found"));
        return conversion.toActionCategoryDTO(actionCategoryEntity);
    }

    @Override
    public List<ActionCategoryDTO> getActionCategories() {
        return conversion.actionCategoryDTOList(actionCategoryDAO.findAll());
    }

    @Override
    public void updateActionCategory(String actionCategoryId, ActionCategoryDTO actionCategory) {
        ActionCategoryEntity foundActionCategory= actionCategoryDAO.findById(actionCategoryId)
                .orElseThrow(() -> new DataNotFoundException("Action Category Not Found"));

        foundActionCategory.setName(actionCategory.getName());
        foundActionCategory.setDescription(actionCategory.getDescription());

    }

    @Override
    public void deleteActionCategory(String actionCategoryId) {
        ActionCategoryEntity foundActionCategory = actionCategoryDAO.findById(actionCategoryId)
                .orElseThrow(()->new DataNotFoundException("actionCategory not found"));
        actionCategoryDAO.delete(foundActionCategory);

    }
}
