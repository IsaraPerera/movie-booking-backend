package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.dto.UserActionDTO;

import java.util.List;


public interface UserActionService {
    void saveUserAction(UserActionDTO userAction);
    UserActionDTO getSelectedUserAction(String userActionId);
    List<UserActionDTO> getAllUserActions();
    void updateUserAction(String userActionId, UserActionDTO userAction);
    void deleteUserAction(String userActionId);
}
