package com.zanatciu.backend.config.converter.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.application.dto.ApplicationDto;
import com.zanatciu.backend.domain.application.model.Application;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ApplicationModelMapper implements ModelMapper<Application, ApplicationDto> {
    @Override
    public ApplicationDto modelToDto(Application application) {
        ApplicationDto dto = new ApplicationDto();

        dto.setId(application.getId());
        dto.setApplicantUsername(application.getApplicantUsername());
        dto.setPublicationId(application.getPublicationId());
        dto.setStatus(application.getStatus());
        dto.setMessage(application.getMessage());
        dto.setTimestamp(application.getTimestamp());

        return dto;
    }

    @Override
    public Application dtoToModel(ApplicationDto applicationDto) {
        Application model = new Application();

        if(applicationDto.getId() != null)
            model.setId(applicationDto.getId());

        model.setApplicantUsername(applicationDto.getApplicantUsername());
        model.setPublicationId(applicationDto.getPublicationId());
        model.setStatus("ACTIVE");
        model.setMessage(applicationDto.getMessage());
        model.setTimestamp(new Date());

        return model;
    }
}
