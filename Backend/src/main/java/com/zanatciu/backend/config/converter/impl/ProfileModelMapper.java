package com.zanatciu.backend.config.converter.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.profile.dto.ProfileDto;
import com.zanatciu.backend.domain.profile.model.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileModelMapper implements ModelMapper<Profile, ProfileDto> {
    @Override
    public ProfileDto modelToDto(Profile profile) {
        return new ProfileDto();
    }

    @Override
    public Profile dtoToModel(ProfileDto profileDto) {
        return new Profile();
    }
}
