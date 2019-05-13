package com.zanatciu.backend.domain.auth.service.impl;

import com.zanatciu.backend.domain.auth.service.AuthService;
import com.zanatciu.backend.domain.user.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public String signup(UserDto userDto) {
        return null;
    }
}
