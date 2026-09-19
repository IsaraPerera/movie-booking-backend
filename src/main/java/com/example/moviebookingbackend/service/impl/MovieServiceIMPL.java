package com.example.moviebookingbackend.service.impl;

import com.example.moviebookingbackend.dao.MovieDAO;
import com.example.moviebookingbackend.dto.MovieDTO;
import com.example.moviebookingbackend.entity.MovieEntity;
import com.example.moviebookingbackend.exceptions.DataNotFoundException;
import com.example.moviebookingbackend.service.MovieService;
import com.example.moviebookingbackend.util.Conversion;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class MovieServiceIMPL implements MovieService {

    private final Conversion conversion;
    private final MovieDAO movieDAO;

    @Override
    public MovieDTO createMovie(MovieDTO dto) {
        MovieEntity movieEntity = conversion.toMovieEntity(dto);
        MovieEntity savedEntity = movieDAO.save(movieEntity);
        return conversion.toMovieDTO(savedEntity);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieEntity> movieEntities = movieDAO.findAll();
        return conversion.toMovieDTOList(movieEntities);
    }

    @Override
    public MovieDTO getMovieById(String id) {
        MovieEntity movieEntity = movieDAO.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Movie not found with id: " + id));
        return conversion.toMovieDTO(movieEntity);
    }

    @Override
    public MovieDTO updateMovie(String id, MovieDTO dto) {
        MovieEntity existingMovie = movieDAO.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Movie not found with id: " + id));

        // Update fields (adjust these to match your MovieEntity properties)
        existingMovie.setTitle(dto.getTitle());
        // existingMovie.setDescription(dto.getDescription());

        MovieEntity updatedEntity = movieDAO.save(existingMovie);
        return conversion.toMovieDTO(updatedEntity);
    }

    @Override
    public void deleteMovie(String id) {
        MovieEntity foundMovie = movieDAO.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Movie not found with id: " + id));
        movieDAO.delete(foundMovie);
    }
}