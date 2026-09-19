package com.example.moviebookingbackend.service.impl;

import com.example.moviebookingbackend.dao.TheatreDAO;
import com.example.moviebookingbackend.dto.TheatreDTO;
import com.example.moviebookingbackend.entity.TheatreEntity;
import com.example.moviebookingbackend.exceptions.DataNotFoundException;
import com.example.moviebookingbackend.service.TheatreService;
import com.example.moviebookingbackend.util.Conversion;
import com.example.moviebookingbackend.util.IDGenerate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class TheatreServiceIMPL implements TheatreService {
    private final Conversion conversion;
    private final TheatreDAO theatreDAO;
    @Override
    public void saveTheatre(TheatreDTO theatre) {


    }

    @Override
    public TheatreDTO getSelectedTheatre(String theatreId) {
        TheatreEntity theatreEntity = theatreDAO.findById(theatreId)
                .orElseThrow(() ->new DataNotFoundException("Theatre not Found"));
        return conversion.toTheatreDTO(theatreEntity);
    }

    @Override
    public TheatreDTO createTheatre(TheatreDTO theatreDTO) {
        //generating id
        theatreDTO.setTheatreId(IDGenerate.theatreId());
        //save data
        TheatreEntity theatreEntity = conversion.toTheatreEntity(theatreDTO);
        theatreDAO.save(conversion.toTheatreEntity(theatreDTO));
    }

    @Override
    public List<TheatreDTO> getAllTheatres() {
        return conversion.toTheatreDTOList(theatreDAO.findAll());
    }

    @Override
    public TheatreDTO getTheatreById(Long id) {
        return null;
    }

    @Override
    public TheatreDTO updateTheatre(Long id, TheatreDTO dto) {
        return null;
    }

    @Override
    public void deleteTheatre(Long id) {

    }

    @Override
    public void updateTheatre(String theatreId, TheatreDTO theatre) {
        System.out.println("To be updated the theatre id : " +theatreId+ "as:" + theatre.toString());
    }

    @Override
    public void deleteTheatre(String theatreId) {
        TheatreEntity foundTheatre = theatreDAO.findById(theatreId)
                .orElseThrow(()->new DataNotFoundException("user not found"));
        theatreDAO.delete(foundTheatre);
    }
}
