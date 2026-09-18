package com.example.moviebookingbackend.entity;

import com.example.moviebookingbackend.entity.enums.ShowStatus;
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
@Table(name = "shows")
public class ShowEntity {
    @Id
    private String showId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn(name = "theatre_id", nullable = false)
    private TheatreEntity theatre;

    private String showDate;
    private String showTime;
    private String ticketPrice;

    @Enumerated(EnumType.STRING)
    private ShowStatus showStatus;

    @OneToMany(mappedBy = "show")
    @JsonIgnore
    private List<BookingEntity> bookings;
}