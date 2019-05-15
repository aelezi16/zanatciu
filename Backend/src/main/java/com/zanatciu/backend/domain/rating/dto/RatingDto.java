package com.zanatciu.backend.domain.rating.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {

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
