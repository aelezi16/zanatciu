package com.zanatciu.backend.domain.profile.dto;

import com.zanatciu.backend.domain.settings.model.Settings;
import java.util.Date;

public class ProfileDto {

    private String id;

    private String firstName;
    private String lastName;
    private String gender;
    private String personalNo;
    private String username;
    private String description;
    private Date birthday;
    private Double rating;
    private String email;

    private Settings settings;

    private String image;
}
