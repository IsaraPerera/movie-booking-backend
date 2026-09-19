package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.dto.ShowDTO;
import java.util.List;

public interface ShowService {
    ShowDTO createShow(ShowDTO dto);
    List<ShowDTO> getAllShows();
    ShowDTO getShowById(Long id);
    List<ShowDTO> getShowsByMovieId(Long movieId);
}