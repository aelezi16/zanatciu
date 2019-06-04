package com.zanatciu.backend.domain.auth.service.impl;

import com.zanatciu.backend.domain.auth.service.AuthService;
import com.zanatciu.backend.domain.user.dto.UserDto;
import com.zanatciu.backend.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {


    private UserService userService;

    @Autowired
    public AuthServiceImpl(
        UserService userService
    ){
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
    public void logout() {
        userService.logout();
    }

    @Override
    public String refresh() {
        return userService.refresh();
    }
}
