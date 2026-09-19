package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.dto.TheatreDTO;
import java.util.List;

public interface TheatreService {
    TheatreDTO createTheatre(TheatreDTO dto);
    List<TheatreDTO> getAllTheatres();
    TheatreDTO getTheatreById(Long id);
    TheatreDTO updateTheatre(Long id, TheatreDTO dto);
    void deleteTheatre(Long id);
}