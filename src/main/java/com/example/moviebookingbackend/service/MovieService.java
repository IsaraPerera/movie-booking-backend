package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.dto.MovieDTO;
import java.util.List;

public interface MovieService {
    MovieDTO createMovie(MovieDTO dto);
    List<MovieDTO> getAllMovies();
    MovieDTO getMovieById(Long id);
    MovieDTO updateMovie(Long id, MovieDTO dto);
    void deleteMovie(Long id);
}