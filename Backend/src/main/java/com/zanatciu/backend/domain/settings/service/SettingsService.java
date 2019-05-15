package com.zanatciu.backend.domain.settings.service;

import com.zanatciu.backend.domain.settings.dto.SettingsDto;

public interface SettingsService {
    SettingsDto update(SettingsDto settingsDto, String username);
}
