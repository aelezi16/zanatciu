package com.zanatciu.backend.domain.profile.model;

import com.zanatciu.backend.domain.settings.model.Settings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    private String id;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String gender;
    @NotBlank
    private String personalNo;
    @NotBlank
    private String username;
    private String description;
    private Date birthday;
    private Double rating;
    @NotBlank
    private String email;

    @Indexed(unique = true)
    private Settings settings;


    private String profileImage;

}
