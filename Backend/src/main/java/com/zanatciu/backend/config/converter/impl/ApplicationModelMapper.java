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

    @Override
    public Application updateModel(Application model1, Application model2) {

        if(model1.getId() != null)
            model2.setId(model1.getId());
        if(model1.getApplicantUsername() != null)
            model2.setApplicantUsername(model1.getApplicantUsername());
        if(model1.getMessage() != null)
            model2.setMessage(model1.getMessage());
        if(model1.getPublicationId() != null)
            model2.setPublicationId(model1.getPublicationId());
        if(model1.getStatus() != null)
            model2.setStatus(model1.getStatus());
        if(model1.getTimestamp() != null)
            model2.setTimestamp(model1.getTimestamp());

        return model2;
    }

}
