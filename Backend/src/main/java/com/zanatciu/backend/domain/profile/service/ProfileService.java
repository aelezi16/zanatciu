package com.zanatciu.backend.domain.profile.service;

import com.zanatciu.backend.domain.profile.dto.ProfileDto;

public interface ProfileService {

    ProfileDto getById(String id);
    ProfileDto save(ProfileDto profileDto);

    String subscribe(String packageId, String userId);
}
