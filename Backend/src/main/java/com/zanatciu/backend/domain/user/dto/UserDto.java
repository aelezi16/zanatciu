package com.zanatciu.backend.domain.user.dto;

import com.zanatciu.backend.domain.settings.model.Settings;
import com.zanatciu.backend.domain.user.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

    private String id;
    private String username;
    private String password;
    private boolean status;
    private List<Role> roles;


    private String firstName;
    private String lastName;
    private String gender;
    private String personalNo;
    private String phoneNo;
    private String description;
    private Date birthday;
    private Double rating; //

    private String email;

    private Settings settings;//

    private String image;

}