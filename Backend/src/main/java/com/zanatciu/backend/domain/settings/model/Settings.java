package com.zanatciu.backend.domain.settings.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Settings {


    private String username;

    private String theme;

    private String color;
}
