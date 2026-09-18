package com.example.moviebookingbackend.service.impl;

import com.example.moviebookingbackend.dao.GoalDAO;
import com.example.moviebookingbackend.dto.GoalDTO;
import com.example.moviebookingbackend.entity.GoalEntity;
import com.example.moviebookingbackend.exceptions.DataNotFoundException;
import com.example.moviebookingbackend.service.GoalService;
import com.example.moviebookingbackend.util.Conversion;
import com.example.moviebookingbackend.util.IDGenerate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Transactional
@Service
public class GoalServiceIMPL implements GoalService {
    private final Conversion conversion;
    private final GoalDAO goalDAO;
    @Override
    public void saveGoal(GoalDTO goal) {
        //generating id
        goal.setGoalId(IDGenerate.goalId());
        //save data
        GoalEntity goalEntity = conversion.toGoalEntity(goal);
        goalDAO.save(conversion.toGoalEntity(goal));

    }

    @Override
    public GoalDTO getSelectedGoal(String goalId) {
        GoalEntity goalEntity = goalDAO.findById(goalId)
                .orElseThrow(() ->new DataNotFoundException("Goal not Found"));
        return conversion.toGoalDTO(goalEntity);
    }

    @Override
    public List<GoalDTO> getAllGoals() {
        return conversion.toGoalDTOList(goalDAO.findAll());
    }

    @Override
    public void updateGoal(String goalId, GoalDTO goal) {
        System.out.println("To be updated the goal id : " +goalId+ "as:" + goal.toString());
    }

    @Override
    public void deleteGoal(String goalId) {
        GoalEntity foundGoal = goalDAO.findById(goalId)
                .orElseThrow(()->new DataNotFoundException("user not found"));
        goalDAO.delete(foundGoal);
    }
}
