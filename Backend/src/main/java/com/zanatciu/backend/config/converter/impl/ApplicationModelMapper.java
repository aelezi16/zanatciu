package com.zanatciu.backend.config.converter.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.application.dto.ApplicationDto;
import com.zanatciu.backend.domain.application.model.Application;
import org.springframework.stereotype.Component;

@Component
public class ApplicationModelMapper implements ModelMapper<Application, ApplicationDto> {
    @Override
    public ApplicationDto modelToDto(Application application) {
        return new ApplicationDto();
    }

    @Override
    public Application dtoToModel(ApplicationDto applicationDto) {
        return new Application();
    }
}
