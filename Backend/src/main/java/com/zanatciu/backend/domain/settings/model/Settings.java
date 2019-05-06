package com.zanatciu.backend.domain.settings.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Settings {

    @Id
    private String id;

    @NotBlank
    private String owner;

    private String theme;

    private String color;
}
