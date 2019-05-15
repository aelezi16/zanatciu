package com.zanatciu.backend.domain.settings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SettingsDto {

    private String username;
    private String color;
    private String theme;
}
