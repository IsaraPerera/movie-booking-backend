package com.example.moviebookingbackend.service.impl;

import com.example.moviebookingbackend.dao.UserDAO;
import com.example.moviebookingbackend.dto.UserDTO;
import com.example.moviebookingbackend.entity.UserEntity;
import com.example.moviebookingbackend.exceptions.DataNotFoundException;
import com.example.moviebookingbackend.service.UserService;
import com.example.moviebookingbackend.util.Conversion;
import com.example.moviebookingbackend.util.IDGenerate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceIMPL implements UserService {
    private final UserDAO userDAO;
    private final Conversion conversion;
    @Override
    public void saveUser(UserDTO user) {
        //generating id
        user.setUserId(IDGenerate.userId());
        //save data
        UserEntity userEntity = conversion.toUserEntity(user);
        userDAO.save(conversion.toUserEntity(user));
    }

    @Override
    public UserDTO getSelectedUser(String userId) throws ChangeSetPersister.NotFoundException{
        UserEntity userEntity = userDAO.findById(userId)
                .orElseThrow(() ->new DataNotFoundException("User not Found"));
        return conversion.toUserDTO(userEntity);

    }

    @Override
    public List<UserDTO> getAllUsers() {
         return conversion.toUserDTOList(userDAO.findAll());

    }

    @Override
    public void updateUser(String userId,UserDTO user) {
        UserEntity foundUser = userDAO.findById(userId)
                .orElseThrow(() ->new DataNotFoundException("User not Found"));
        foundUser.setEmail(user.getEmail());
        foundUser.setRole(user.getRole());
        foundUser.setFirstName(user.getFirstName());
        foundUser.setLastName(user.getLastName());
        foundUser.setEmail(user.getEmail());
    }

    @Override
    public void deleteUser(String userId) {
        UserEntity foundUser = userDAO.findById(userId)
                .orElseThrow(()->new DataNotFoundException("user not found"));
        userDAO.delete(foundUser);
    }


}
