package com.zanatciu.backend.domain.user.service.impl;

import com.zanatciu.backend.config.cache.MyCacheService;
import com.zanatciu.backend.config.converter.ModelMapper;
import com.zanatciu.backend.config.mail.service.SimpMailService;
import com.zanatciu.backend.domain.settings.dto.SettingsDto;
import com.zanatciu.backend.domain.user.dto.UserDto;
import com.zanatciu.backend.domain.user.model.User;
import com.zanatciu.backend.domain.user.repo.UserRepo;
import com.zanatciu.backend.domain.user.service.UserService;
import com.zanatciu.backend.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private ModelMapper<User, UserDto> modelMapper;
    private BCryptPasswordEncoder myPasswordEncoder;
    private MyCacheService myCacheService;
    private JwtProvider jwtProvider;
    private SimpMailService simpMailService;

    @Autowired
    public UserServiceImpl(
            UserRepo userRepo,
            ModelMapper<User, UserDto> modelMapper,
            BCryptPasswordEncoder myPasswordEncoder,
            JwtProvider jwtProvider,
            MyCacheService myCacheService,
            SimpMailService simpMailService
    ){
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.myPasswordEncoder = myPasswordEncoder;
        this.jwtProvider = jwtProvider;
        this.myCacheService = myCacheService;
        this.simpMailService = simpMailService;
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
        if(!userRepo.findByUsername(userDto.getUsername()).isPresent())
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
    public void logout() {
        org.springframework.security.core.userdetails.User details = (org.springframework.security.core.userdetails.User)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = details.getUsername();

        System.out.println("this" + username);

        myCacheService.logUserOut(username);
    }

    @Override
    public String refresh() {


        org.springframework.security.core.userdetails.User details = (org.springframework.security.core.userdetails.User)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = details.getUsername();

        logout();

        Optional<User> optionalUser = userRepo.findByUsername(username);

        if(!optionalUser.isPresent())return null;
        String token = jwtProvider.createToken(username, optionalUser.get().getRoles());
        myCacheService.logUserIn(token, username);
        Authentication auth = jwtProvider.getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(auth);

        return token;
    }

    @Override
    public void reset(String email) {
        Optional<User>  optionalUser = userRepo.findByEmail(email);

        if(optionalUser.isPresent()){

            String token = jwtProvider.createToken(optionalUser.get().getUsername(), optionalUser.get().getRoles());

            simpMailService.passwordResetMessage(email, token);

        }else {
            simpMailService.emailNotFoundMessage(email);
        }
    }

    @Override
    public void resetByToken(String token) {
        boolean flag = jwtProvider.validateToken(token);

        if(flag){
            String username = jwtProvider.getUsername(token);

            Optional<User> optionalUser = userRepo.findByUsername(username);

            if(optionalUser.isPresent()){

                String newPassword = generatePassword();

                String hashedPassword = myPasswordEncoder.encode(newPassword);

                User user = optionalUser.get();
                user.setPassword(hashedPassword);

                userRepo.save(user);

                simpMailService.passwordResetFinishedMessage(user.getEmail(), newPassword);

            }


        }
    }

    private String generatePassword(){
        String pswd = "";

        Random random = new Random();

        for(int i = 0; i < 10; i++){
            pswd += (char)random.nextInt(25) + 'a';
        }

        for(int i = 0; i < 5; i++){
            pswd += random.nextInt(10);
        }

        return pswd;
    }

}
