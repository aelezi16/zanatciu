package com.zanatciu.backend.config.converter.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.publication.dto.PublicationDto;
import com.zanatciu.backend.domain.publication.model.Publication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PublicationModelMapper implements ModelMapper<Publication, PublicationDto> {

    @Value(value = "${server:uri}")
    private String server;
    @Value("${server:port}")
    private String port;

    @Override
    public PublicationDto modelToDto(Publication publication) {
        PublicationDto dto = new PublicationDto();


        if (publication.getPrice() != null)
            dto.setPrice(publication.getPrice());
        if (publication.getImage() != null)
            dto.setImage(publication.getImage());
        if (publication.getId() != null)
            dto.setId(publication.getId());
        if (publication.getTitle() != null)
            dto.setTitle(publication.getTitle());
        if (publication.getDescription() != null)
            dto.setDescription(publication.getDescription());
        if (publication.getRate() != null)
            dto.setRate(publication.getRate());
        if (publication.getUsername() != null)
            dto.setUsername(publication.getUsername());
        if (publication.getRatingCount() != null)
            dto.setRatingCount(publication.getRatingCount());
        if (publication.getTimestamp() != null)
            dto.setTimestamp(publication.getTimestamp());
        if (publication.getType() != null)
            dto.setType(publication.getType());
        return dto;
    }

    @Override
    public Publication dtoToModel(PublicationDto publicationDto) {
        Publication model = new Publication();

        if (publicationDto.getTitle() != null)
            model.setTitle(publicationDto.getTitle());
        if (publicationDto.getDescription() != null)
            model.setDescription(publicationDto.getDescription());
        if (publicationDto.getRate() != null)
            model.setRate(publicationDto.getRate());

        if (publicationDto.getId() != null)
            model.setId(publicationDto.getId());
        if (publicationDto.getUsername() != null)
            model.setUsername(publicationDto.getUsername());
        if (publicationDto.getRatingCount() != null)
            model.setRatingCount(publicationDto.getRatingCount());
        if (publicationDto.getTimestamp() != null)
            model.setTimestamp(new Date());
        if (publicationDto.getType() != null)
            model.setType(publicationDto.getType());

        if (publicationDto.getPrice() != null)
            model.setPrice(publicationDto.getPrice());
        if (publicationDto.getImage() != null)
            model.setImage(publicationDto.getImage());

        return model;
    }

    @Override
    public Publication updateModel(Publication model1, Publication model2) {
        if (model1.getId() != null)
            model2.setId(model1.getId());
        if (model1.getUsername() != null)
            model2.setUsername(model1.getUsername());
        if (model1.getType() != null)
            model2.setType(model1.getType());
        if (model1.getRatingCount() != null)
            model2.setRatingCount(model1.getRatingCount());
        if (model1.getRate() != null)
            model2.setRate(model1.getRate());
        if (model1.getTitle() != null)
            model2.setTitle(model1.getTitle());
        if (model1.getDescription() != null)
            model2.setDescription(model1.getDescription());
        if (model1.getTimestamp() != null)
            model2.setTimestamp(model1.getTimestamp());

        if (model1.getPrice() != null)
            model2.setPrice(model1.getPrice());
        if (model1.getImage() != null)
            model2.setImage(model1.getImage());

        return model2;
    }
}
