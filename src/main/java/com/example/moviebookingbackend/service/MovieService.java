package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.dto.MovieDTO;
import java.util.List;

public interface MovieService {
    MovieDTO createMovie(MovieDTO dto);
    List<MovieDTO> getAllMovies();
    MovieDTO getMovieById(String id);
    MovieDTO updateMovie(String id, MovieDTO dto);
    void deleteMovie(String id);
}