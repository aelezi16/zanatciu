package com.zanatciu.backend.domain.publication.model;

import com.zanatciu.backend.domain.rating.model.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Publication {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    @Indexed(unique = true)
    private String title;

    private String type;
    private String description;
    private Integer rate;
    private Integer ratingCount;
    private Date timestamp;

}
