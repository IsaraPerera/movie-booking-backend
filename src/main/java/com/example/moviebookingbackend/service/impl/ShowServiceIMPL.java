package com.example.moviebookingbackend.service.impl;

import com.example.moviebookingbackend.dao.ShowDAO;
import com.example.moviebookingbackend.dto.ShowDTO;
import com.example.moviebookingbackend.entity.ShowEntity;
import com.example.moviebookingbackend.exceptions.DataNotFoundException;
import com.example.moviebookingbackend.service.ShowService;
import com.example.moviebookingbackend.util.Conversion;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ShowServiceIMPL implements ShowService {

    private final Conversion conversion;
    private final ShowDAO showDAO;

    @Override
    public ShowDTO createShow(ShowDTO dto) {
        ShowEntity showEntity = conversion.toShowEntity(dto);
        ShowEntity savedEntity = showDAO.save(showEntity);
        return conversion.toShowDTO(savedEntity);
    }

    @Override
    public List<ShowDTO> getAllShows() {
        List<ShowEntity> showEntities = showDAO.findAll();
        return conversion.toShowDTOList(showEntities);
    }

    @Override
    public ShowDTO getShowById(String id) {
        ShowEntity showEntity = showDAO.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Show not found with id: " + id));
        return conversion.toShowDTO(showEntity);
    }

    @Override
    public List<ShowDTO> getShowsByMovieId(String movieId) {
        // Uncomment and use this once you add findByMovieId to your ShowDAO interface:
        // List<ShowEntity> showEntities = showDAO.findByMovieId(movieId);
        // return conversion.toShowDTOList(showEntities);

        return List.of();
    }
}