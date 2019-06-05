package com.zanatciu.backend.domain.user.service;

import com.zanatciu.backend.domain.settings.dto.SettingsDto;
import com.zanatciu.backend.domain.user.dto.UserDto;
import com.zanatciu.backend.domain.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAll();
    Optional<UserDto> getById(String id);
    Optional<UserDto> getByUsername(String username);
    Optional<UserDto> create(UserDto userDto);
    Optional<UserDto> update(UserDto userDto, String id);
    void delete(String id);

    String subscribe(String packageId, String userId);

    Optional<SettingsDto> updateSettings(SettingsDto settingsDto, String username);

    Optional<User> findByUsername(String username);
    Optional<User> createBySignUp(UserDto userDto);
    String login(String username, String password);
    String signup(UserDto userDto);
    void logout();
    String refresh();
    void reset(String email);
    void resetByToken(String token);
}
