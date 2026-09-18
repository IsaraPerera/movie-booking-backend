package com.example.moviebookingbackend.controller;

import com.example.moviebookingbackend.dto.ClimateActionDTO;
import com.example.moviebookingbackend.service.ClimateActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/climateaction")
@RestController
@RequiredArgsConstructor
public class climateActionController {
    private final ClimateActionService climateActionService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createClimateAction(@RequestBody ClimateActionDTO climateActionDTO){
        climateActionService.saveClimateAction(climateActionDTO);
        return  new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(value ={"/{climateActionId}"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClimateActionDTO>getSelectedClimateAction(@PathVariable String climateActionId){

        return  new ResponseEntity<>(climateActionService.getSelectedClimateAction(climateActionId) ,HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClimateActionDTO>>getActionCategories(){
        return  new ResponseEntity<>(climateActionService.getAllClimateActions(),HttpStatus.OK);


    }
    @PatchMapping(value ={"/{climateActionId}"},consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateClimateAction(@PathVariable String climateActionId,@RequestBody ClimateActionDTO climateActionDTO){
        climateActionService.updateClimateAction(climateActionId,climateActionDTO);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping(value = {"/{climateActionId}"})
    public ResponseEntity<Void>deleteClimateAction(@PathVariable String climateActionId){
        climateActionService.deleteClimateAction(climateActionId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
