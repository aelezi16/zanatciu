package com.zanatciu.backend;

import com.zanatciu.backend.domain.user.dto.UserDto;
import com.zanatciu.backend.domain.user.model.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class BackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        RestTemplate restTemplate = new RestTemplate();
//        String signUserUp = "http://localhost:8080/auth/signup";
//
//        List<Role> roles = new ArrayList<>();
//        roles.add(Role.JOB_SEEKER);
//        roles.add(Role.JOB_PROVIDER);
//
//        UserDto userDto = new UserDto();
//        userDto.setPhoneNo("ani");
//        userDto.setRating(5.0);
//        userDto.setEmail("eamil");
//        userDto.setPersonalNo("perno");
//        userDto.setLastName("ani");
//        userDto.setRoles(roles);
//        userDto.setUsername("ani");
//        userDto.setPassword("ani");
//        userDto.setFirstName("ani");
//        userDto.setBirthday(new Date());
//
//
//        ResponseEntity<String> res = restTemplate.postForEntity(signUserUp, userDto, String.class);
//        String token = res.getBody();

//        System.out.println(new Date().);



    }
}
