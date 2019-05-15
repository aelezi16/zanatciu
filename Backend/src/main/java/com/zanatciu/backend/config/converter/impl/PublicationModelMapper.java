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
}
