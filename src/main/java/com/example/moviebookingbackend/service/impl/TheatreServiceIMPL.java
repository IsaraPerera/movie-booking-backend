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
    public TheatreDTO createTheatre(TheatreDTO theatreDTO) {
        theatreDTO.setTheatreId(IDGenerate.theatreId());
        TheatreEntity theatreEntity = conversion.toTheatreEntity(theatreDTO);
        TheatreEntity savedEntity = theatreDAO.save(theatreEntity);
        return conversion.toTheatreDTO(savedEntity);
    }

    @Override
    public List<TheatreDTO> getAllTheatres() {
        List<TheatreEntity> theatreEntities = theatreDAO.findAll();
        return conversion.toTheatreDTOList(theatreEntities);
    }

    @Override
    public TheatreDTO getTheatreById(String id) {
        TheatreEntity theatreEntity = theatreDAO.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Theatre not found with id: " + id));
        return conversion.toTheatreDTO(theatreEntity);
    }

    @Override
    public TheatreDTO updateTheatre(String id, TheatreDTO theatreDTO) {
        TheatreEntity existingTheatre = theatreDAO.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Theatre not found with id: " + id));

        // Update fields (adjust these properties to match your actual entity/DTO fields)
        existingTheatre.setName(theatreDTO.getName());
        existingTheatre.setLocation(theatreDTO.getLocation());

        TheatreEntity updatedEntity = theatreDAO.save(existingTheatre);
        return conversion.toTheatreDTO(updatedEntity);
    }

    @Override
    public void deleteTheatre(String id) {
        TheatreEntity foundTheatre = theatreDAO.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Theatre not found with id: " + id));
        theatreDAO.delete(foundTheatre);
    }
}