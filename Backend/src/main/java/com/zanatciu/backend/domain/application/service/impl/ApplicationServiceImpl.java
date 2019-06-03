package com.zanatciu.backend.domain.application.service.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.application.dto.ApplicationDto;
import com.zanatciu.backend.domain.application.model.Application;
import com.zanatciu.backend.domain.application.repo.ApplicationRepo;
import com.zanatciu.backend.domain.application.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepo applicationRepo;
    private ModelMapper<Application, ApplicationDto> modelMapper;

    @Autowired
    public ApplicationServiceImpl(
        ApplicationRepo applicationRepo,
        ModelMapper<Application, ApplicationDto> modelMapper//,
    ){
        this.applicationRepo = applicationRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ApplicationDto> getAll() {
        return applicationRepo.findAll()
                .stream()
                .map(modelMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDto> getPerPublication(String id) {
        return applicationRepo.findAllByPublicationId(id)
                .stream()
                .map(modelMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationDto getById(String id) {
        Optional<Application> optionalApplication = applicationRepo.findById(id);

        return optionalApplication.isPresent()
                ? optionalApplication.map(modelMapper::modelToDto).get()
                : null;
    }

    @Override
    public ApplicationDto save(ApplicationDto applicationDto) {
        Optional<Application> application = Optional.of(applicationDto).map(modelMapper::dtoToModel);

        if(applicationRepo.exists(Example.of(application.get())))
            return null;

        Optional<Application> savedApplication = Optional.of(applicationRepo.save(application.get()));

        return savedApplication.isPresent()
                ? savedApplication.map(modelMapper::modelToDto).get()
                : null;
    }

    @Override
    public ApplicationDto save(ApplicationDto applicationDto, String id) {
        Optional<Application> optionalApplication = Optional.of(applicationDto).map(modelMapper::dtoToModel);

        Optional<Application> savedApplication = applicationRepo.findById(id);

        if(!savedApplication.isPresent())
            return null;
        return savedApplication.map(
                (a)-> modelMapper.updateModel(optionalApplication.get(), a)
        ).map(a -> applicationRepo.save(a))
         .map(modelMapper::modelToDto)
         .get();
    }

    @Override
    public void delete(String id) {
        applicationRepo.deleteById(id);
    }

    @Override
    public void evaluate(String applicationId, String verdict) {
        Optional<Application> optionalApplication = applicationRepo.findById(applicationId);

        if(optionalApplication.isPresent()){

            Application app = optionalApplication.get();

            if(!app.getStatus().equals("EXPIRED")){
                app.setStatus(verdict);
                applicationRepo.save(app);
                //Here send the notification
            }
        }
    }
}
