package com.zanatciu.backend.domain.user.service.impl;

import com.zanatciu.backend.domain.user.model.User;
import com.zanatciu.backend.domain.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetails implements UserDetailsService {

    private UserRepo userRepo;

    @Autowired
    public MyUserDetails(
            UserRepo userRepo
    ) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> user = userRepo.findByUsername(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User does not exist");
        }

        User usr = user.get();

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(usr.getPassword())
                .authorities(usr.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

    public boolean findByUsername(String username) {
        return userRepo.findByUsername(username).isPresent();
    }
}
