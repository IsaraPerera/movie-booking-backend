package com.example.moviebookingbackend.util;

import java.util.UUID;

public class IDGenerate {
    public static String climateActionId(){
        return "CA-"+UUID.randomUUID();
    }
    public static String actionCategoryId(){
        return "AC-"+UUID.randomUUID();
    }
    public static String goalId(){
        return "GL-"+UUID.randomUUID();
    }
    public static String userActionId(){
        return "UA-"+UUID.randomUUID();
    }
    public static String userId(){
        return "US-"+UUID.randomUUID();
    }

}