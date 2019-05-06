package com.zanatciu.backend.domain.publication.model;

import com.zanatciu.backend.domain.rating.model.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class Publication {

    @Id
    private String id;
    private String description;
    private String owner;

    private List<Rating> ratings;
    private List<String> applicationIds;

    private Date timestamp;
}
