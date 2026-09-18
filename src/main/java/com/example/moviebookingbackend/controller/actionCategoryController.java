package com.example.moviebookingbackend.controller;

import com.example.moviebookingbackend.dto.ActionCategoryDTO;
import com.example.moviebookingbackend.service.ActionCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/actioncategory")
@RestController
@RequiredArgsConstructor
public class actionCategoryController {
    private final ActionCategoryService actionCategoryService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createActionCategory(@RequestBody ActionCategoryDTO actionCategoryDTO){
        actionCategoryService.createActionCategory(actionCategoryDTO);
        return  new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(value ={"/{actionCategoryId}"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActionCategoryDTO>getSelectedActionCategory(@PathVariable String actionCategoryId){
        return  new ResponseEntity<>(actionCategoryService.getSelectedActionCategory(actionCategoryId),HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActionCategoryDTO>>getActionCategories(){

        return  new ResponseEntity<>(actionCategoryService.getActionCategories(),HttpStatus.OK);


    }
    @PatchMapping(value ={"/{actionCategoryId}"},consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateActionCategory(@PathVariable String actionCategoryId,@RequestBody ActionCategoryDTO actionCategoryDTO){
        actionCategoryService.updateActionCategory(actionCategoryId,actionCategoryDTO);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping(value = {"/{actionCategoryId}"})
    public ResponseEntity<Void>deleteActionCategory(@PathVariable String actionCategoryId){
        actionCategoryService.deleteActionCategory(actionCategoryId);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
