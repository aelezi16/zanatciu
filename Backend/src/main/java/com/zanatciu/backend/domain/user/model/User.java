package com.zanatciu.backend.domain.user.model;

import com.zanatciu.backend.domain.settings.model.Settings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class User {

    //sensitive
    @Id
    private String id;

    @Indexed(unique = true)
    private String username;
    private String password;
    private boolean status;

    private List<Role> roles;


    //insensitive
    private String firstName;
    private String lastName;
    private String gender;

    @Indexed(unique = true)
    private String personalNo;

    private String description;
    private Date birthday;
    private Double rating;
    private String email;

    private Settings settings;

    private String image;

}
