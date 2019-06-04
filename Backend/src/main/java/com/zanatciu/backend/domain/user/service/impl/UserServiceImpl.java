package com.zanatciu.backend.domain.user.service.impl;

import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.user.dto.UserDto;
import com.zanatciu.backend.domain.user.model.User;
import com.zanatciu.backend.domain.user.repo.UserRepo;
import com.zanatciu.backend.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private ModelMapper<User, UserDto> modelMapper;

    @Autowired
    public UserServiceImpl(
            UserRepo userRepo,
            ModelMapper<User, UserDto> modelMapper
    ){
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getAll() {
        return userRepo.findAll()
                .stream().map(modelMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> getById(String id) {

        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent())
            return optionalUser.map(modelMapper::modelToDto);
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> getByUsername(String username) {
        Optional<User> optionalUser = userRepo.findByUsername(username);
        if(optionalUser.isPresent())
            return optionalUser.map(modelMapper::modelToDto);
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> create(UserDto userDto) {
        if(!userRepo.existsById(userDto.getId()))
            return Optional.of(userRepo.save(
                    Optional.of(userDto).map(modelMapper::dtoToModel).get()
            )).map(modelMapper::modelToDto);

        return Optional.empty();
    }

    @Override
    public Optional<UserDto> update(UserDto userDto, String id) {
        if(userRepo.existsById(id)) {

            userDto.setId(id);

            return Optional.of(userRepo.save(
                    Optional.of(userDto).map(modelMapper::dtoToModel).get()
            )).map(modelMapper::modelToDto);
        }

        return Optional.empty();
    }

    @Override
    public void delete(String id) {
        userRepo.deleteById(id);
    }
}
