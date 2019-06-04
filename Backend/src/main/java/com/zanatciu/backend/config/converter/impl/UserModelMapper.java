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
        if(user.getId() != null)
            dto.setId(user.getId());
        if(user.getRoles() != null)
            dto.setRoles(user.getRoles());
        if(user.getUsername() != null)
            dto.setUsername(user.getUsername());
        if(user.getPassword() != null)
            dto.setPassword("password");
        if(user.isStatus())
            dto.setStatus(user.isStatus());
        if(user.getBirthday() != null)
            dto.setBirthday(user.getBirthday());

        if(user.getDescription() != null)
            dto.setDescription(user.getDescription());
        if(user.getGender() != null)
            dto.setGender(user.getGender());
        if(user.getImage() != null)
            dto.setImage(user.getImage());
        if(user.getFirstName() != null)
            dto.setFirstName(user.getFirstName());
        if(user.getLastName() != null)
            dto.setLastName(user.getLastName());
        if(user.getPersonalNo() != null)
            dto.setPersonalNo(user.getPersonalNo());
        if(user.getPhoneNo() != null)
            dto.setPhoneNo(user.getPhoneNo());
        if(user.getEmail() != null)
            dto.setEmail(user.getEmail());
        if(user.getDescription() != null)
            dto.setDescription(user.getDescription());
        if(user.getSettings() != null)
            dto.setSettings(user.getSettings());
        if(user.getRating() != null)
            dto.setRating(user.getRating());

        return dto;
    }

    @Override
    public User dtoToModel(UserDto userDto) {
        User user = new User();

        if(userDto.getId() != null)
            user.setId(userDto.getId());
        if(userDto.getPassword() != null)
            user.setPassword(userDto.getPassword());
        if(userDto.getRoles() != null)
            user.setRoles(userDto.getRoles());
        user.setStatus(userDto.isStatus());

        if(userDto.getUsername()!=null)
            user.setUsername(userDto.getUsername());


        if(userDto.getBirthday() != null)
            user.setBirthday(userDto.getBirthday());

        if(userDto.getDescription() != null)
            user.setDescription(userDto.getDescription());
        if(userDto.getGender() != null)
            user.setGender(userDto.getGender());
        if(userDto.getImage() != null)
            user.setImage(userDto.getImage());
        if(userDto.getFirstName() != null)
            user.setFirstName(userDto.getFirstName());
        if(userDto.getLastName() != null)
            user.setLastName(userDto.getLastName());
        if(userDto.getEmail() != null)
            user.setEmail(userDto.getEmail());
        if(userDto.getPersonalNo() != null)
            user.setPersonalNo(userDto.getPersonalNo());
        if(userDto.getPhoneNo() != null)
            user.setPhoneNo(userDto.getPhoneNo());
        if(userDto.getDescription() != null)
            user.setDescription(userDto.getDescription());
        if(userDto.getSettings() != null)
            user.setSettings(userDto.getSettings());
        if(userDto.getRating() != null)
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

        if(model1.getPhoneNo() != null)
            model2.setPhoneNo(model1.getPhoneNo());

        return model2;
    }
}
