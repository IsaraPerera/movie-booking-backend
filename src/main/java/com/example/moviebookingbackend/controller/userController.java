package com.example.moviebookingbackend.controller;

import com.example.moviebookingbackend.dto.UserDTO;
import com.example.moviebookingbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class userController {
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(userController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>createUser(@RequestBody UserDTO userDTO){
        logger.info("Create User Detail Is {}",userDTO);
        userService.saveUser(userDTO);
        return  new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(value= "{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedUser(@PathVariable String userId) throws ChangeSetPersister.NotFoundException {
        return new  ResponseEntity<>(userService.getSelectedUser(userId), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDTO>>getAllUsers(){
        return  new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @PatchMapping(value ={"/{userId}"},consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateUser(@PathVariable String userId,@RequestBody UserDTO userDTO){
        userService.updateUser(userId, userDTO);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping(value = {"/{userId}"})
    public ResponseEntity<Void>deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
