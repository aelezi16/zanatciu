package com.zanatciu.backend.domain.publication.service;

import com.zanatciu.backend.domain.publication.dto.PublicationDto;

import java.util.List;

public interface PublicationService {

    PublicationDto getById(String id);
    List<PublicationDto> getAll();
    List<PublicationDto> getByUsername(String username, String type);
    List<PublicationDto> getByType(String type, Integer page, Integer size);

    PublicationDto save(PublicationDto publicationDto);
    PublicationDto save(PublicationDto publicationDto, String id);
    void delete(String id);
}
