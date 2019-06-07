package com.zanatciu.backend.domain.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    private String id;
    private String applicantUsername;
    private String publicationId;
    private String publicationTitle;
    private String publicationOwnerUsername;
    private String message;
    private Date timestamp;

    //EXPIRED ACCEPTED REJECTED ACTIVE
    private String status;
}
