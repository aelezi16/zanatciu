package com.zanatciu.backend.domain.user.service.impl;

import com.zanatciu.backend.config.cache.MyCacheService;
import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.domain.settings.dto.SettingsDto;
import com.zanatciu.backend.domain.user.dto.UserDto;
import com.zanatciu.backend.domain.user.model.User;
import com.zanatciu.backend.domain.user.repo.UserRepo;
import com.zanatciu.backend.domain.user.service.UserService;
import com.zanatciu.backend.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private ModelMapper<User, UserDto> modelMapper;
    private BCryptPasswordEncoder myPasswordEncoder;
    private MyCacheService myCacheService;
    private JwtProvider jwtProvider;

    @Autowired
    public UserServiceImpl(
            UserRepo userRepo,
            ModelMapper<User, UserDto> modelMapper,
            BCryptPasswordEncoder myPasswordEncoder,
            JwtProvider jwtProvider,
            MyCacheService myCacheService
    ){
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.myPasswordEncoder = myPasswordEncoder;
        this.jwtProvider = jwtProvider;
        this.myCacheService = myCacheService;
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
                    Optional.of(userDto).map(modelMapper::dtoToModel)
                            .map(u-> {
                                if(u.getPassword() != null)
                                    u.setPassword(myPasswordEncoder.encode(u.getPassword()));
                                return u;
                            }).get()
            )).map(modelMapper::modelToDto);

        return Optional.empty();
    }

    @Override
    public Optional<UserDto> update(UserDto userDto, String id) {
        if(userRepo.existsById(id)) {



            return Optional.of(userRepo.save(
                    Optional.of(userDto)
                            .map(modelMapper::dtoToModel)
                            .map((u) -> modelMapper.updateModel(u, userRepo.findById(id).get()))
                            .map(u-> {
                                if(u.getPassword() != null)
                                    u.setPassword(myPasswordEncoder.encode(u.getPassword()));
                                return u;
                            }).get()
            )).map(modelMapper::modelToDto);
        }

        return Optional.empty();
    }

    @Override
    public void delete(String id) {
        userRepo.deleteById(id);
    }

    @Override
    public String subscribe(String packageId, String userId) {
        return null;
    }

    @Override
    public Optional<SettingsDto> updateSettings(SettingsDto settingsDto, String username) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Optional<User> createBySignUp(UserDto userDto) {
        return Optional.empty();
    }

    @Override
    public String login(String username, String password) {
        Optional<User> optionalUser = findByUsername(username);

        if(optionalUser.isPresent()){

            if(!myPasswordEncoder.matches(password, optionalUser.get().getPassword()))
                return null;

            String token = jwtProvider.createToken(username, optionalUser.get().getRoles());
            myCacheService.logUserIn(token, username);
            Authentication auth = jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(auth);

            return token;
        }

        return null;
    }

    @Override
    public String signup(UserDto userDto) {
        Optional<UserDto> createdUser = create(userDto);

        if(createdUser.isPresent()){

            Optional<User> authUser = findByUsername(userDto.getUsername());

            if(!myPasswordEncoder.matches(userDto.getPassword(), authUser.get().getPassword()))
                return null;

            String token = jwtProvider.createToken(userDto.getUsername(), authUser.get().getRoles());
            myCacheService.logUserIn(token, userDto.getUsername());
            Authentication auth = jwtProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(auth);

            return token;

        }

        return null;
    }

    @Override
    public void loguot(String token, String username) {
        SecurityContextHolder.clearContext();
        myCacheService.logUserOut(token, username);
    }

}
