package com.example.moviebookingbackend.controller;

import com.example.moviebookingbackend.dto.UserActionDTO;
import com.example.moviebookingbackend.service.UserActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/useractions")
@RequiredArgsConstructor
public class userActionController {
    private final UserActionService userActionService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUserAction(@RequestBody UserActionDTO userActionDTO){
        userActionService.saveUserAction(userActionDTO);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value ={"/{userActionId}"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserActionDTO>getSelectedUserAction(@PathVariable String userActionId){
        return  new ResponseEntity<>(userActionService.getSelectedUserAction(userActionId),HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserActionDTO>>getUserActions(){
        return  new ResponseEntity<>(userActionService.getAllUserActions(),HttpStatus.OK);
    }
    @PatchMapping(value ={"/{userActionId}"},consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateUserAction(@PathVariable String userActionId,@RequestBody UserActionDTO userActionDTO){
        userActionService.updateUserAction(userActionId,userActionDTO);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping(value = {"/{userActionId}"})
    public ResponseEntity<Void>deleteUserAction(@PathVariable String userActionId){
        userActionService.deleteUserAction(userActionId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
