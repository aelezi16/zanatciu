package com.zanatciu.backend.domain.auth.service;

import com.zanatciu.backend.domain.user.dto.UserDto;

public interface AuthService {

    String login(String username, String password);

    String signup(UserDto userDto);

    void logout(String token, String username);

    String refresh(String token, String username);
}
