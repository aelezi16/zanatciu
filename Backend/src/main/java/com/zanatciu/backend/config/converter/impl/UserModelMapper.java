package com.zanatciu.backend.config.converter.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.user.dto.UserDto;
import com.zanatciu.backend.domain.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper implements ModelMapper<User, UserDto> {
    @Override
    public UserDto modelToDto(User user) {
        return new UserDto();
    }

    @Override
    public User dtoToModel(UserDto userDto) {
        return new User();
    }
}
