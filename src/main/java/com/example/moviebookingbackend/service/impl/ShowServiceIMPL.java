package com.example.moviebookingbackend.service.impl;

import com.example.moviebookingbackend.dao.ShowDAO;
import com.example.moviebookingbackend.dto.ShowDTO;
import com.example.moviebookingbackend.entity.ShowEntity;
import com.example.moviebookingbackend.exceptions.DataNotFoundException;
import com.example.moviebookingbackend.service.ShowService;
import com.example.moviebookingbackend.util.Conversion;
import com.example.moviebookingbackend.util.IDGenerate;
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
    public void saveShow(ShowDTO show) {
        //generating id
        show.setId(IDGenerate.showId());
        //save data
        ShowEntity showEntity = conversion.toShowEntity(show);
        showDAO.save(conversion.toShowEntity(show));

    }

    @Override
    public ShowDTO getSelectedShow(String showId) {
        ShowEntity showEntity = showDAO.findById(showId)
                .orElseThrow(() ->new DataNotFoundException("Show not Found"));
        return conversion.toShowDTO(showEntity);
    }

    @Override
    public ShowDTO createShow(ShowDTO dto) {
        return null;
    }

    @Override
    public List<ShowDTO> getAllShows() {
        return conversion.toShowDTOList(showDAO.findAll());
    }

    @Override
    public ShowDTO getShowById(Long id) {
        return null;
    }

    @Override
    public List<ShowDTO> getShowsByMovieId(Long movieId) {
        return List.of();
    }

    @Override
    public void updateShow(String showId, ShowDTO show) {
        System.out.println("To be updated the show id : " +showId+ "as:" + show.toString());
    }

    @Override
    public void deleteShow(String showId) {
        ShowEntity foundShow = showDAO.findById(showId)
                .orElseThrow(()->new DataNotFoundException("user not found"));
        showDAO.delete(foundShow);
    }
}
