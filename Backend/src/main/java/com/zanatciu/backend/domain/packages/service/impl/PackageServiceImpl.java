package com.zanatciu.backend.domain.packages.service.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.packages.dto.PackageDto;
import com.zanatciu.backend.domain.packages.model.Package;
import com.zanatciu.backend.domain.packages.repo.PackageRepo;
import com.zanatciu.backend.domain.packages.service.PackageService;
import com.zanatciu.backend.domain.profile.repo.ProfileRepo;
import com.zanatciu.backend.domain.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PackageServiceImpl implements PackageService {

    private ModelMapper<Package, PackageDto> modelMapper;
    private PackageRepo packageRepo;
    private ProfileService profileService;

    @Autowired
    public PackageServiceImpl(
            ModelMapper<Package, PackageDto> modelMapper,
            PackageRepo packageRepo,
            ProfileService profileService
            ){
        this.modelMapper = modelMapper;
        this.packageRepo = packageRepo;
        this.profileService = profileService;
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
            packageRepo.delete(packageRepo.findById(id).get());
    }

    @Override
    public ResponseEntity subscribe(String packageId, String userId) {
        String status = profileService.subscribe(packageId, userId);
        return status.equals("OK")
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
