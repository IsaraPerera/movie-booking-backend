package com.example.moviebookingbackend.controller;

import com.example.moviebookingbackend.dto.GoalDTO;
import com.example.moviebookingbackend.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/goals")
@RequiredArgsConstructor
public class goalController {
    private final GoalService goalService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createGoal(@RequestBody GoalDTO goalDTO){
        goalService.saveGoal(goalDTO);
        return  new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(value ={"/{goalId}"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GoalDTO>getSelectedGoal(@PathVariable String goalId){

        return  new ResponseEntity<>(goalService.getSelectedGoal(goalId),HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GoalDTO>>getGoals(){
        return  new ResponseEntity<>(goalService.getAllGoals(),HttpStatus.OK);


    }
    @PatchMapping(value ={"/{goalId}"},consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateGoal(@PathVariable String goalId,@RequestBody GoalDTO goalDTO){
        goalService.updateGoal(goalId,goalDTO);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping(value = {"/{goalId}"})
    public ResponseEntity<Void>deleteGoal(@PathVariable String goalId){
        goalService.deleteGoal(goalId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
