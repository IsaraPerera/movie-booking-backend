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
    public static String movieId(){return "MV-"+UUID.randomUUID();}
    public static String bookingId(){
        return "BK-"+UUID.randomUUID();
    }
    public static String paymentId(){
        return "PM-"+UUID.randomUUID();
    }
    public static String showId(){
        return "SW-"+UUID.randomUUID();
    }
    public static String theatreId(){
        return "TH-"+UUID.randomUUID();
    }





}