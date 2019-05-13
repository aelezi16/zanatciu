package com.zanatciu.backend.domain.profile.controller;

import com.zanatciu.backend.domain.profile.dto.ProfileDto;
import com.zanatciu.backend.domain.profile.model.Profile;
import com.zanatciu.backend.domain.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProfileDto> getById(@PathVariable String id){
        ProfileDto dto = profileService.getById(id);

        return dto != null
                ? new ResponseEntity<ProfileDto>(dto, HttpStatus.OK)
                : new ResponseEntity<ProfileDto>(dto, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<ProfileDto> getByUsername(@PathVariable String username){
        return null;
    }

    @PostMapping
    public ResponseEntity<ProfileDto> post(@RequestBody ProfileDto profileDto){
        //here
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfileDto> update(@PathVariable String id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfileDto> delete(@PathVariable String id){
        return null;
    }

}
