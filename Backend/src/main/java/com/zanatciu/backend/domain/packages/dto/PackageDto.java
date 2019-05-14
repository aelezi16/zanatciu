package com.zanatciu.backend.domain.packages.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageDto {

    private String id;
    private String title;
    private String description;
    private Double price;
}
