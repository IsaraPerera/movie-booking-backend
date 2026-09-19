package com.example.moviebookingbackend.entity;

import com.example.moviebookingbackend.entity.enums.MovieStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "movies")
public class MovieEntity implements Serializable {
    @Id
    private String movieId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private Integer duration; 
    private String language;
    private String genre;
    private String releaseDate;

    @Enumerated(EnumType.STRING)
    private MovieStatus movieStatus;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<ShowEntity> shows;
}