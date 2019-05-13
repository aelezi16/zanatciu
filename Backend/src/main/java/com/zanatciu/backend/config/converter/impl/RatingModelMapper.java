package com.zanatciu.backend.config.converter.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.rating.dto.RatingDto;
import com.zanatciu.backend.domain.rating.model.Rating;
import org.springframework.stereotype.Component;

@Component
public class RatingModelMapper implements ModelMapper<Rating, RatingDto> {
    @Override
    public RatingDto modelToDto(Rating rating) {
        return new RatingDto();
    }

    @Override
    public Rating dtoToModel(RatingDto ratingDto) {
        return new Rating();
    }
}
