package com.zanatciu.backend.domain.user.service;

import com.zanatciu.backend.domain.user.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAll();
    Optional<UserDto> getById(String id);
    Optional<UserDto> getByUsername(String username);
    Optional<UserDto> create(UserDto userDto);
    Optional<UserDto> update(UserDto userDto, String id);
    void delete(String id);
}
