package com.zanatciu.backend.domain.rating.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    private String id;
    private String username;
    private String publicationId;

    @Max(5)
    @Min(0)
    private Double rate;

    @Max(50)
    private String message;

    private Date date;
}
