package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.dto.UserDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO user);
    UserDTO getSelectedUser(String userId) throws ChangeSetPersister.NotFoundException;
    List<UserDTO> getAllUsers();
    void updateUser(String userId, UserDTO user);
    void deleteUser(String userId);
}
