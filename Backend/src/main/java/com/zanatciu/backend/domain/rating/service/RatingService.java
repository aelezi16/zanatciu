package com.zanatciu.backend.domain.rating.service;

import com.zanatciu.backend.domain.rating.dto.RatingDto;

import java.util.List;

public interface RatingService {
    RatingDto getById(String id);
    List<RatingDto> getByPublicationId(String publicationId);
    List<RatingDto> getByUsername(String username);
    RatingDto save(RatingDto ratingDto);
    RatingDto save(RatingDto ratingDto, String id);
    void delete(String id);
}
