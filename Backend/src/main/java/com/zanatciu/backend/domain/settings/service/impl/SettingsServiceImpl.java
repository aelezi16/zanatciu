package com.zanatciu.backend.domain.settings.service.impl;

import com.zanatciu.backend.domain.profile.service.ProfileService;
import com.zanatciu.backend.domain.settings.dto.SettingsDto;
import com.zanatciu.backend.domain.settings.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettingsServiceImpl implements SettingsService {

    private ProfileService profileService;

    @Autowired
    public SettingsServiceImpl(
            ProfileService profileService
    ){
        this.profileService = profileService;
    }

    @Override
    public SettingsDto update(SettingsDto settingsDto, String username) {

        Optional<SettingsDto> optionalSettings = profileService.updateSettings(settingsDto, username);
        return optionalSettings.isPresent()? optionalSettings.get(): null;
    }
}
