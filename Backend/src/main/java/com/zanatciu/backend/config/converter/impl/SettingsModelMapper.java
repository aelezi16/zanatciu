package com.zanatciu.backend.config.converter.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.settings.dto.SettingsDto;
import com.zanatciu.backend.domain.settings.model.Settings;
import org.springframework.stereotype.Component;

@Component
public class SettingsModelMapper implements ModelMapper<Settings, SettingsDto> {
    @Override
    public SettingsDto modelToDto(Settings settings) {
        SettingsDto dto = new SettingsDto();

        dto.setColor(settings.getColor());
        dto.setUsername(settings.getUsername());
        dto.setTheme(settings.getTheme());

        return dto;

    }

    @Override
    public Settings dtoToModel(SettingsDto settingsDto) {
        Settings model = new Settings();

        model.setColor(settingsDto.getColor());
        model.setUsername(settingsDto.getUsername());
        model.setTheme(settingsDto.getTheme());
        return model;
    }
}
