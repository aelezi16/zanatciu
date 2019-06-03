package com.zanatciu.backend.domain.settings.service.impl;

import com.zanatciu.backend.domain.settings.dto.SettingsDto;
import com.zanatciu.backend.domain.settings.service.SettingsService;
import com.zanatciu.backend.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettingsServiceImpl implements SettingsService {

    private UserService userService;

    @Autowired
    public SettingsServiceImpl(
            UserService userService
    ){
        this.userService = userService;
    }

    @Override
    public SettingsDto update(SettingsDto settingsDto, String username) {

        Optional<SettingsDto> optionalSettings = userService.updateSettings(settingsDto, username);
        return optionalSettings.isPresent()? optionalSettings.get(): null;
    }
}
