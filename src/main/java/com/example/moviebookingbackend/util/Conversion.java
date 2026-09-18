package com.example.moviebookingbackend.util;

import com.example.moviebookingbackend.dto.*;
import com.example.moviebookingbackend.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class Conversion {
    private final ModelMapper mapper;

    //    User-Conversion
    public UserDTO toUserDTO(UserEntityecho userEntityecho) {
        return mapper.map(userEntityecho, UserDTO.class);
    }

    public UserEntityecho toUserEntity(UserDTO userDTO) {
        return mapper.map(userDTO, UserEntityecho.class);
    }

    public List<UserDTO> toUserDTOList(List<UserEntityecho> userEntityechoList) {
        return mapper.map(userEntityechoList,
                new TypeToken<List<UserDTO>>() {
                }.getType()
        );
    }

    //    User-Action-Conversion

    public UserActionDTO toUserActionDTO(UserActionEntity userActionEntity) {
        return mapper.map(userActionEntity, UserActionDTO.class);
    }

    public UserActionEntity toUserActionEntity(UserActionDTO userActionDTO) {
        return mapper.map(userActionDTO, UserActionEntity.class);
    }

    public List<UserActionDTO> toUserActionDTOList(List<UserActionEntity> userActionEntities) {
        return mapper.map(userActionEntities,
                new TypeToken<List<UserActionDTO>>() {
                }.getType()
        );

    }
    //    Climate-Action-Conversion

    public ClimateActionDTO toClimateActionDTO(ClimateActionEntity climateActionEntity) {
        return mapper.map(climateActionEntity, ClimateActionDTO.class);
    }

    public ClimateActionEntity toClimateActionEntity(ClimateActionDTO climateActionDTO) {
        return mapper.map(climateActionDTO, ClimateActionEntity.class);
    }

    public List<ClimateActionDTO> toClimateActionDTOList(List<ClimateActionEntity> climateActionEntities) {
        return mapper.map(climateActionEntities,
                new TypeToken<List<ClimateActionDTO>>() {
                }.getType()
        );
    }
    //    Action Category-Conversion

    public ActionCategoryDTO toActionCategoryDTO(ActionCategoryEntity actionCategoryEntity) {
        return mapper.map(actionCategoryEntity, ActionCategoryDTO.class);

    }

    public ActionCategoryEntity toActionCategoryEntity(ActionCategoryDTO actionCategoryDTO) {
        return mapper.map(actionCategoryDTO, ActionCategoryEntity.class);
    }

    public List<ActionCategoryDTO> actionCategoryDTOList(List<ActionCategoryEntity> actionCategoryEntities) {
        return mapper.map(actionCategoryEntities,
                new TypeToken<List<ActionCategoryDTO>>() {
                }.getType()
        );
    }
    // Goal Conversion
    public GoalDTO toGoalDTO(GoalEntity goalEntity){
        return mapper.map(goalEntity, GoalDTO.class);
    }

    public GoalEntity toGoalEntity(GoalDTO goalDTO){  return mapper.map(goalDTO, GoalEntity.class); }

    public List<GoalDTO> toGoalDTOList(List<GoalEntity> goalEntityList) {
        return mapper.map(goalEntityList, new TypeToken<List<GoalDTO>>(){}.getType());
    }
}