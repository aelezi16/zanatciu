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

        return dto;
    }

    @Override
    public Package dtoToModel(PackageDto packageDto) {

        Package model = new Package();

        model.setId(packageDto.getId());
        model.setTitle(packageDto.getTitle());
        model.setDescription(packageDto.getDescription());
        model.setPrice(packageDto.getPrice());

        return model;
    }
}
