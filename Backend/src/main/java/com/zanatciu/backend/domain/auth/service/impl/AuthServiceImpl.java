package com.zanatciu.backend.domain.auth.service.impl;

import com.zanatciu.backend.config.cache.MyCacheService;
import com.zanatciu.backend.domain.auth.service.AuthService;
import com.zanatciu.backend.domain.user.dto.UserDto;
import com.zanatciu.backend.domain.user.model.User;
import com.zanatciu.backend.domain.user.repo.UserRepo;
import com.zanatciu.backend.domain.user.service.UserService;
import com.zanatciu.backend.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    private MyCacheService myCacheService;
    private UserService userService;

    @Autowired
    public AuthServiceImpl(
        MyCacheService myCacheService,
        UserRepo userRepo
    ){
        this.myCacheService = myCacheService;
        this.userService = userService;
    }

    @Override
    public String login(String username, String password) {
        return userService.login(username, password);
    }

    @Override
    public String signup(UserDto userDto) {
        return userService.signup(userDto);
    }

    @Override
    public void logout(String token, String username) {
        userService.loguot(token, username);
    }
}
