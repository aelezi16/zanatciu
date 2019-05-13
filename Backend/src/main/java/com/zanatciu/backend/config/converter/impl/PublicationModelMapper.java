package com.zanatciu.backend.config.converter.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.publication.dto.PublicationDto;
import com.zanatciu.backend.domain.publication.model.Publication;
import org.springframework.stereotype.Component;

@Component
public class PublicationModelMapper implements ModelMapper<Publication, PublicationDto> {
    @Override
    public PublicationDto modelToDto(Publication publication) {
        return new PublicationDto();
    }

    @Override
    public Publication dtoToModel(PublicationDto publicationDto) {
        return new Publication();
    }
}
