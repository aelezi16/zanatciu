package com.zanatciu.backend.domain.packages.service;

import com.zanatciu.backend.domain.packages.dto.PackageDto;

import java.util.List;

public interface PackageService {
    List<PackageDto> getAll();

    PackageDto save(PackageDto packageDto);
    void delete(String id);
}
