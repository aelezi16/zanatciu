package com.zanatciu.backend.domain.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    private String id;

    @NotBlank
    private String applicantUsername;

    @NotBlank
    private String publicationId;

    @NotBlank
    private Date timestamp;
}
