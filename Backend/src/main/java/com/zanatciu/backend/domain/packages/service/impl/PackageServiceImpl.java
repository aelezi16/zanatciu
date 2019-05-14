package com.zanatciu.backend.domain.packages.service.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.packages.dto.PackageDto;
import com.zanatciu.backend.domain.packages.model.Package;
import com.zanatciu.backend.domain.packages.repo.PackageRepo;
import com.zanatciu.backend.domain.packages.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PackageServiceImpl implements PackageService {

    private ModelMapper<Package, PackageDto> modelMapper;
    private PackageRepo packageRepo;

    @Autowired
    public PackageServiceImpl(
            ModelMapper<Package, PackageDto> modelMapper,
            PackageRepo packageRepo
            ){
        this.modelMapper = modelMapper;
        this.packageRepo = packageRepo;
    }

    @Override
    public List<PackageDto> getAll() {
        return packageRepo.findAll().stream().map(modelMapper::modelToDto).collect(Collectors.toList());
    }

    @Override
    public PackageDto save(PackageDto packageDto) {
        Optional<PackageDto> dto =  Optional.of(
                packageRepo.save(
                        Optional.of(packageDto).map(modelMapper::dtoToModel).get()
                )).map(modelMapper::modelToDto);
        return dto.isPresent() ? dto.get() : null;
    }

    @Override
    public void delete(String id) {
            packageRepo.delete(packageRepo.findById(id));
    }
}
