package com.zanatciu.backend.domain.auth.service;

import com.zanatciu.backend.domain.user.dto.UserDto;

public interface AuthService {

    String login(String username, String password);

    String signup(UserDto userDto);

    void logout();

    String refresh();

    void reset(String email);

    void resetByToken(String token);
}
