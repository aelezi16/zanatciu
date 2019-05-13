package com.zanatciu.backend.domain.profile.service.impl;

import com.zanatciu.backend.domain.profile.dto.ProfileDto;
import com.zanatciu.backend.domain.profile.model.Profile;
import com.zanatciu.backend.domain.profile.repo.ProfileRepo;
import com.zanatciu.backend.domain.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepo profileRepo;

    @Autowired
    public ProfileServiceImpl(ProfileRepo profileRepo){
        this.profileRepo = profileRepo;
    }

    @Override
    public ProfileDto getById(String id) {
        Optional<Profile> profile = profileRepo.findById(id);
        //here
        return null;
    }

    @Override
    public ProfileDto save(ProfileDto profileDto) {
        return null;
    }
}
