package com.zanatciu.backend.domain.publication.service.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.publication.dto.PublicationDto;
import com.zanatciu.backend.domain.publication.model.Publication;
import com.zanatciu.backend.domain.publication.repo.PublicationRepo;
import com.zanatciu.backend.domain.publication.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublicationServiceImpl implements PublicationService {

    private PublicationRepo publicationRepo;
    private ModelMapper<Publication, PublicationDto> modelMapper;

    @Autowired
    public PublicationServiceImpl(
            PublicationRepo publicationRepo,
            ModelMapper<Publication, PublicationDto> modelMapper
    ) {
        this.publicationRepo = publicationRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public PublicationDto getById(String id) {
        Optional<Publication> publication = publicationRepo.findById(id);

        return publication.isPresent()
                ? publication.map(modelMapper::modelToDto).get()
                : null;
    }

    @Override
    public List<PublicationDto> getAll() {
        return publicationRepo.findAll()
                .stream()
                .map(modelMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PublicationDto> getByUsername(String username, String type) {
        return publicationRepo.findAllByUsernameAndType(username, type)
                .stream()
                .map(modelMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PublicationDto> getByType(String type, Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        return publicationRepo.findAllByType(type, pageable)
                .stream()
                .map(modelMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PublicationDto save(PublicationDto publicationDto) {

        Optional<Publication> publication = Optional.of(publicationDto).map(modelMapper::dtoToModel);
        if (publicationRepo.findByTitle(publicationDto.getTitle()).isPresent())
            return null;

        return Optional.of(publicationRepo.save(publication.get())).map(modelMapper::modelToDto).get();

    }

    @Override
    public PublicationDto save(PublicationDto publicationDto, String id) {
        Optional<Publication> newPub = Optional.of(publicationDto).map(modelMapper::dtoToModel);

        Optional<Publication> publication = publicationRepo.findById(id);

        if (!publication.isPresent()) return null;

        return publication.map((p) -> modelMapper.updateModel(newPub.get(), p)).map(p -> publicationRepo.save(p)).map(modelMapper::modelToDto).get();
    }

    @Override
    public void delete(String id) {
        publicationRepo.deleteById(id);
    }
}
