package com.zanatciu.backend.domain.profile.service;

import com.zanatciu.backend.domain.profile.dto.ProfileDto;
import com.zanatciu.backend.domain.settings.dto.SettingsDto;

import java.util.Optional;

public interface ProfileService {

    ProfileDto getById(String id);
    ProfileDto save(ProfileDto profileDto);

    String subscribe(String packageId, String userId);

    Optional<SettingsDto> updateSettings(SettingsDto settingsDto, String username);
}
