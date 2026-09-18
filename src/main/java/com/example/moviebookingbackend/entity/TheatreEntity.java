package com.example.moviebookingbackend.entity;

import com.example.moviebookingbackend.entity.enums.TheatreStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "theatres")
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId; 

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    private Integer capacity; 

    @Enumerated(EnumType.STRING)
    private TheatreStatus theatreStatus;

    @OneToMany(mappedBy = "theatre")
    @JsonIgnore
    private List<ShowEntity> shows;
}