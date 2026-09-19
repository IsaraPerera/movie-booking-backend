package com.example.moviebookingbackend.util;

import com.example.moviebookingbackend.dto.*;
import com.example.moviebookingbackend.entity.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class Conversion {
    private final ModelMapper mapper;

    //    User-Conversion
    public UserDTO toUserDTO(UserEntity userEntity) {
        return mapper.map(userEntity, UserDTO.class);
    }

    public UserEntity toUserEntity(UserDTO userDTO) {
        return mapper.map(userDTO, UserEntity.class);
    }

    public List<UserDTO> toUserDTOList(List<UserEntity> userEntityList) {
        return mapper.map(userEntityList,
                new TypeToken<List<UserDTO>>() {
                }.getType()
        );
    }

    //    Booking-Conversion

    public BookingDTO toBookingDTO(BookingEntity BookingEntity) {
        return mapper.map(BookingEntity, BookingDTO.class);
    }

    public BookingEntity toBookingEntity(BookingDTO BookingDTO) {
        return mapper.map(BookingDTO, BookingEntity.class);
    }

    public List<BookingDTO> toBookingDTOList(List<BookingEntity> BookingEntities) {
        return mapper.map(BookingEntities,
                new TypeToken<List<BookingDTO>>() {
                }.getType()
        );

    }
    //    Movie-Conversion

    public MovieDTO toMovieDTO(MovieEntity MovieEntity) {
        return mapper.map(MovieEntity, MovieDTO.class);
    }

    public MovieEntity toMovieEntity(MovieDTO MovieDTO) {
        return mapper.map(MovieDTO, MovieEntity.class);
    }

    public List<MovieDTO> toMovieDTOList(List<MovieEntity> MovieEntities) {
        return mapper.map(MovieEntities,
                new TypeToken<List<MovieDTO>>() {
                }.getType()
        );
    }
    //    Payment Conversion

    public PaymentDTO toPaymentDTO(PaymentEntity PaymentEntity) {
        return mapper.map(PaymentEntity, PaymentDTO.class);

    }

    public PaymentEntity toPaymentEntity(PaymentDTO PaymentDTO) {
        return mapper.map(PaymentDTO, PaymentEntity.class);
    }

    public List<PaymentDTO> PaymentDTOList(List<PaymentEntity> PaymentEntities) {
        return mapper.map(PaymentEntities,
                new TypeToken<List<PaymentDTO>>() {
                }.getType()
        );
    }
    // Show Conversion
    public ShowDTO toShowDTO(ShowEntity ShowEntity){
        return mapper.map(ShowEntity, ShowDTO.class);
    }

    public ShowEntity toShowEntity(ShowDTO ShowDTO){  return mapper.map(ShowDTO, ShowEntity.class); }

    public List<ShowDTO> toShowDTOList(List<ShowEntity> ShowEntityList) {
        return mapper.map(ShowEntityList, new TypeToken<List<ShowDTO>>(){}.getType());
    }

    // Theatre Conversion
    public TheatreDTO toTheatreDTO(TheatreEntity TheatreEntity){
        return mapper.map(TheatreEntity, TheatreDTO.class);
    }

    public TheatreEntity toTheatreEntity(TheatreDTO TheatreDTO){  return mapper.map(TheatreDTO, TheatreEntity.class); }

    public List<TheatreDTO> toTheatreDTOList(List<TheatreEntity> TheatreEntityList) {
        return mapper.map(TheatreEntityList, new TypeToken<List<TheatreDTO>>(){}.getType());
    }

}