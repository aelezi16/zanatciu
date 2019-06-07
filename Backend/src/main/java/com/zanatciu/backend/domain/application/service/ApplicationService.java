package com.zanatciu.backend.domain.application.service;

import com.zanatciu.backend.domain.application.dto.ApplicationDto;

import java.util.List;

public interface ApplicationService {

    List<ApplicationDto> getAll();

    List<ApplicationDto> getPerPublication(String id);

    ApplicationDto getById(String id);

    ApplicationDto save(ApplicationDto applicationDto);

    ApplicationDto save(ApplicationDto applicationDto, String id);

    void delete(String id);

    void evaluate(String applicationId, String verdict);
}
