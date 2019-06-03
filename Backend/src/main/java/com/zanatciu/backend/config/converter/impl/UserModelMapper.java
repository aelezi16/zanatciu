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

        dto.setBirthday(user.getBirthday());
        dto.setDescription(user.getDescription());
        dto.setGender(user.getGender());
        dto.setImage(user.getImage());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPersonalNo(user.getPersonalNo());
        dto.setEmail(user.getEmail());
        dto.setDescription(user.getDescription());
        dto.setSettings(user.getSettings());
        dto.setRating(user.getRating());

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


        user.setBirthday(userDto.getBirthday());
        user.setDescription(userDto.getDescription());
        user.setGender(userDto.getGender());
        user.setImage(userDto.getImage());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPersonalNo(userDto.getPersonalNo());
        user.setDescription(userDto.getDescription());
        user.setSettings(userDto.getSettings());
        user.setRating(userDto.getRating());

        return user;
    }

    @Override
    public User updateModel(User model1, User model2) {
        if(model1.getId() != null)
            model2.setId(model1.getId());
        if(model1.getPassword() != null)
            model2.setPassword(model1.getPassword());
        if(model1.getRoles() != null)
            model2.setRoles(model1.getRoles());

        model2.setStatus(model1.isStatus());

        if(model1.getUsername() != null)
            model2.setUsername(model1.getUsername());
        if(model1.getBirthday() != null)
            model2.setBirthday(model1.getBirthday());
        if(model1.getGender() != null)
            model2.setGender(model1.getGender());
        if(model1.getImage() != null)
            model2.setImage(model1.getImage());
        if(model1.getFirstName() != null)
            model2.setFirstName(model1.getFirstName());
        if(model1.getLastName() != null)
            model2.setLastName(model1.getLastName());
        if(model1.getEmail() != null)
            model2.setEmail(model1.getEmail());
        if(model1.getPersonalNo() != null)
            model2.setPersonalNo(model1.getPersonalNo());
        if(model1.getDescription() != null)
            model2.setDescription(model1.getDescription());
        if(model1.getSettings() != null)
            model2.setSettings(model1.getSettings());
        if(model1.getRating() != null)
            model2.setRating(model1.getRating());

        return model2;
    }
}
