package com.example.moviebookingbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActionCategoryDTO implements Serializable {
    private String categoryId;
    private String name;
    private String description;
}
