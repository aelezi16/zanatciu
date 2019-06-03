package com.zanatciu.backend.domain.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {


    private String id;
    private String applicantUsername;
    private String publicationId;
    private String publicationTitle;
    private String publicationOwnerUsername;
    private String message;
    private Date timestamp;

    private String status;
}
