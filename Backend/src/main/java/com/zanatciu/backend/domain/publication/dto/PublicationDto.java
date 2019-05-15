package com.zanatciu.backend.domain.publication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDto {

    private String id;
    private String username;
    private String title;
    private String description;
    private String type;
    private Integer rate;
    private Integer ratingCount;
    private Date timestamp;

    private String ratingsUri;
    private String applicationsUri;
}
