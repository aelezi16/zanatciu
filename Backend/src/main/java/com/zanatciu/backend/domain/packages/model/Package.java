package com.zanatciu.backend.domain.packages.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Package {
    @Id
    private String id;
    @Indexed(unique = true)
    private String title;
    private String description;
    private Double price;
    private Integer pubAmount;
}
