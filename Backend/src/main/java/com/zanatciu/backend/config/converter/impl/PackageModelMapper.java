package com.zanatciu.backend.config.converter.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.packages.dto.PackageDto;
import com.zanatciu.backend.domain.packages.model.Package;
import org.springframework.stereotype.Component;

@Component
public class PackageModelMapper implements ModelMapper<Package, PackageDto> {

    @Override
    public PackageDto modelToDto(Package aPackage) {

        PackageDto dto = new PackageDto();

        dto.setId(aPackage.getId());
        dto.setDescription(aPackage.getDescription());
        dto.setPrice(aPackage.getPrice());
        dto.setTitle(aPackage.getTitle());
        dto.setPubAmount(aPackage.getPubAmount());

        return dto;
    }

    @Override
    public Package dtoToModel(PackageDto packageDto) {

        Package model = new Package();

        model.setId(packageDto.getId());
        model.setTitle(packageDto.getTitle());
        model.setDescription(packageDto.getDescription());
        model.setPrice(packageDto.getPrice());
        model.setPubAmount(packageDto.getPubAmount());

        return model;
    }

    @Override
    public Package updateModel(Package model1, Package model2) {
        if(model1.getId() != null)
            model2.setId(model1.getId());
        if(model1.getPrice() != null)
            model2.setPrice(model1.getPrice());
        if(model1.getPubAmount() != null)
            model2.setPubAmount(model1.getPubAmount());
        if(model1.getDescription() != null)
            model2.setDescription(model1.getDescription());
        if(model1.getTitle() != null)
            model2.setTitle(model1.getTitle());

        return model2;
    }
}
