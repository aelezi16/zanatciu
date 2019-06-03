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

        dto.setId(publication.getId());
        dto.setTitle(publication.getTitle());
        dto.setDescription(publication.getDescription());
        dto.setRate(publication.getRate());
        dto.setUsername(publication.getUsername());
        dto.setRatingCount(publication.getRatingCount());
        dto.setTimestamp(publication.getTimestamp());
        dto.setType(publication.getType());

        return dto;
    }

    @Override
    public Publication dtoToModel(PublicationDto publicationDto) {
        Publication model = new Publication();

        if(publicationDto.getId()!=null)
            model.setId(publicationDto.getId());

        model.setTitle(publicationDto.getTitle());
        model.setDescription(publicationDto.getDescription());
        model.setRate(publicationDto.getRate());
        model.setUsername(publicationDto.getUsername());
        model.setRatingCount(publicationDto.getRatingCount());
        model.setTimestamp(new Date());
        model.setType(publicationDto.getType());

        return model;
    }

    @Override
    public Publication updateModel(Publication model1, Publication model2) {
        if(model1.getId() != null)
            model2.setId(model1.getId());
        if(model1.getUsername() != null)
            model2.setUsername(model1.getUsername());
        if(model1.getType() != null)
            model2.setType(model1.getType());
        if(model1.getRatingCount() != null)
            model2.setRatingCount(model1.getRatingCount());
        if(model1.getRate() != null)
            model2.setRate(model1.getRate());
        if(model1.getTitle() != null)
            model2.setTitle(model1.getTitle());
        if(model1.getDescription() != null)
            model2.setDescription(model1.getDescription());
        if(model1.getTimestamp() != null)
            model2.setTimestamp(model1.getTimestamp());

        return model2;
    }
}
