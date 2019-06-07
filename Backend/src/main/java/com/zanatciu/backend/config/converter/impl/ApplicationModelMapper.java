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

        if (application.getPublicationId() != null)
            dto.setPublicationId(application.getPublicationId());

        if (application.getId() != null)
            dto.setId(application.getId());
        if (application.getApplicantUsername() != null)
            dto.setApplicantUsername(application.getApplicantUsername());
        if (application.getPublicationTitle() != null)
            dto.setPublicationTitle(application.getPublicationTitle());
        if (application.getMessage() != null)
            dto.setMessage(application.getMessage());
        if (application.getTimestamp() != null)
            dto.setTimestamp(new Date());

        if (application.getPublicationOwnerUsername() != null)
            dto.setPublicationOwnerUsername(application.getPublicationOwnerUsername());

        if (application.getStatus() != null)
            dto.setStatus(application.getStatus());

        return dto;
    }

    @Override
    public Application dtoToModel(ApplicationDto applicationDto) {
        Application model = new Application();

        if (applicationDto.getId() != null)
            model.setId(applicationDto.getId());
        if (applicationDto.getApplicantUsername() != null)
            model.setApplicantUsername(applicationDto.getApplicantUsername());
        if (applicationDto.getPublicationId() != null)
            model.setPublicationId(applicationDto.getPublicationId());
        if (applicationDto.getPublicationTitle() != null)
            model.setPublicationTitle(applicationDto.getPublicationTitle());
        if (applicationDto.getPublicationOwnerUsername() != null)
            model.setPublicationOwnerUsername(applicationDto.getPublicationOwnerUsername());

        if (applicationDto.getStatus() != null)
            model.setStatus(applicationDto.getStatus());
        if (applicationDto.getMessage() != null)
            model.setMessage(applicationDto.getMessage());
        model.setTimestamp(new Date());

        return model;
    }

    @Override
    public Application updateModel(Application model1, Application model2) {

        if (model1.getId() != null)
            model2.setId(model1.getId());
        if (model1.getApplicantUsername() != null)
            model2.setApplicantUsername(model1.getApplicantUsername());
        if (model1.getMessage() != null)
            model2.setMessage(model1.getMessage());
        if (model1.getPublicationId() != null)
            model2.setPublicationId(model1.getPublicationId());
        if (model1.getPublicationTitle() != null)
            model2.setPublicationTitle(model1.getPublicationTitle());
        if (model1.getStatus() != null)
            model2.setStatus(model1.getStatus());
        if (model1.getTimestamp() != null)
            model2.setTimestamp(model1.getTimestamp());
        if (model1.getPublicationOwnerUsername() != null)
            model2.setPublicationOwnerUsername(model1.getPublicationOwnerUsername());

        return model2;
    }

}
