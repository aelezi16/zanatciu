package com.zanatciu.backend.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class User {

    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String password;
    private boolean status;
    private List<Role> roles;
}
