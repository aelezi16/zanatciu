package com.zanatciu.backend.config.converter.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.user.dto.UserDto;
import com.zanatciu.backend.domain.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserModelMapper implements ModelMapper<User, UserDto> {
    @Override
    public UserDto modelToDto(User user) {
        UserDto dto = new UserDto();

        dto.setId(user.getId());
        dto.setRoles(user.getRoles());
        dto.setUsername(user.getUsername());
        dto.setPassword("password");
        dto.setStatus(user.isStatus());

        return dto;
    }

    @Override
    public User dtoToModel(UserDto userDto) {
        User user = new User();
        if(userDto.getId() != null)
            user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setRoles(userDto.getRoles());
        user.setStatus(userDto.isStatus());
        user.setUsername(userDto.getUsername());

        return user;
    }
}
