package com.zanatciu.backend.domain.rating.service.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.rating.dto.RatingDto;
import com.zanatciu.backend.domain.rating.model.Rating;
import com.zanatciu.backend.domain.rating.repo.RatingRepo;
import com.zanatciu.backend.domain.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepo ratingRepo;
    private ModelMapper<Rating, RatingDto> modelMapper;

    @Autowired
    public RatingServiceImpl(
        RatingRepo ratingRepo,
        ModelMapper<Rating, RatingDto> modelMapper
    ){
        this.ratingRepo = ratingRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public RatingDto getById(String id) {
        Optional<Rating> optionalRating = ratingRepo.findById(id);

        return optionalRating.isPresent()
                ? optionalRating.map(modelMapper::modelToDto).get()
                : null;
    }

    @Override
    public List<RatingDto> getByPublicationId(String publicationId) {
        return ratingRepo.findAllByPublicationId(publicationId)
                .stream()
                .map(modelMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RatingDto> getByUsername(String username) {
        return ratingRepo.findAllByUsername(username)
                .stream()
                .map(modelMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RatingDto save(RatingDto ratingDto) {
        Optional<Rating> rating = Optional.of(ratingDto).map(modelMapper::dtoToModel);

        if(ratingRepo.exists(Example.of(rating.get())))
            return null;

        return Optional.of(ratingRepo.save(rating.get())).map(modelMapper::modelToDto).get();
    }

    @Override
    public RatingDto save(RatingDto ratingDto, String id) {
        Optional<Rating> newRating = Optional.of(ratingDto).map(modelMapper::dtoToModel);

        Optional<Rating> rating = ratingRepo.findById(id);

        if(!rating.isPresent())return null;

        return rating.map((r)->modelMapper.updateModel(newRating.get(), r)).map(p -> ratingRepo.save(p)).map(modelMapper::modelToDto).get();
    }

    @Override
    public void delete(String id) {
        ratingRepo.deleteById(id);
    }
}
