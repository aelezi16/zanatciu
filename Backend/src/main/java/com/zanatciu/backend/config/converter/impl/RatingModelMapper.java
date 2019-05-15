package com.zanatciu.backend.config.converter.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.rating.dto.RatingDto;
import com.zanatciu.backend.domain.rating.model.Rating;
import org.springframework.stereotype.Component;

@Component
public class RatingModelMapper implements ModelMapper<Rating, RatingDto> {

    @Override
    public RatingDto modelToDto(Rating rating) {

        RatingDto dto = new RatingDto();

        dto.setId(rating.getId());
        dto.setUsername(rating.getUsername());
        dto.setMessage(rating.getMessage());
        dto.setPublicationId(rating.getPublicationId());
        dto.setDate(rating.getDate());

        return dto;
    }

    @Override
    public Rating dtoToModel(RatingDto ratingDto) {

        Rating model = new Rating();

        if(ratingDto.getId() != null)
            model.setId(ratingDto.getId());

        model.setId(ratingDto.getId());
        model.setUsername(ratingDto.getUsername());
        model.setMessage(ratingDto.getMessage());
        model.setPublicationId(ratingDto.getPublicationId());
        model.setDate(ratingDto.getDate());

        return model;
    }
}
