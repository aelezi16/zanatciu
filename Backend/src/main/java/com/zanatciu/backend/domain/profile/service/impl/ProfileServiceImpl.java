package com.zanatciu.backend.domain.profile.service.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.profile.dto.ProfileDto;
import com.zanatciu.backend.domain.profile.model.Profile;
import com.zanatciu.backend.domain.profile.repo.ProfileRepo;
import com.zanatciu.backend.domain.profile.service.ProfileService;
import com.zanatciu.backend.domain.settings.dto.SettingsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepo profileRepo;
    private ModelMapper<Profile, ProfileDto> modelMapper;

    @Autowired
    public ProfileServiceImpl(
            ProfileRepo profileRepo,
            ModelMapper<Profile, ProfileDto> modelMapper
    ){
        this.profileRepo = profileRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProfileDto getById(String id) {
        Optional<Profile> profile = profileRepo.findById(id);
        return profile.isPresent()
                ? profile.map(modelMapper::modelToDto).get()
                : null;
    }

    @Override
    public ProfileDto save(ProfileDto profileDto) {
        Optional<ProfileDto> optionalProfileDto = Optional.of(profileDto);
        Optional<Profile> profile = profileRepo.save(optionalProfileDto.map(modelMapper::dtoToModel).get());
        return profile.isPresent()
                ? profile.map(modelMapper::modelToDto).get()
                : null;
    }

    @Override
    public String subscribe(String packageId, String userId) {
        return null;
    }

    @Override
    public Optional<SettingsDto> updateSettings(SettingsDto settingsDto, String username) {
        return Optional.empty();
    }
}
