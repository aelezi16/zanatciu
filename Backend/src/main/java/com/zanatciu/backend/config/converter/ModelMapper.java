package com.zanatciu.backend.config.converter;

public interface ModelMapper<Model, Dto> {

    Dto modelToDto(Model model);

    Model dtoToModel(Dto dto);

    Model updateModel(Model model1, Model model2);

}
