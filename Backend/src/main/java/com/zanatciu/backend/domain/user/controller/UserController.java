package com.zanatciu.backend.domain.user.controller;

import com.zanatciu.backend.domain.user.dto.UserDto;
import com.zanatciu.backend.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> userDtoList = userService.getAll();

        return !userDtoList.isEmpty()
                ? new ResponseEntity<>(userDtoList, HttpStatus.OK)
                : new ResponseEntity<>(userDtoList, HttpStatus.NO_CONTENT);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable String id){
        Optional<UserDto> userDtoOptional = userService.getById(id);

        return userDtoOptional.isPresent()
                ? new ResponseEntity<>(userDtoOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> getByUsername(@PathVariable String username ){
        Optional<UserDto> userDtoOptional = userService.getByUsername(username);

        return userDtoOptional.isPresent()
                ? new ResponseEntity<>(userDtoOptional.get(), HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<UserDto> post(@Valid @RequestBody UserDto userDto){
        Optional<UserDto> userDtoOptional = userService.create(userDto);

        return userDtoOptional.isPresent()
                ? new ResponseEntity<>(userDtoOptional.get(), HttpStatus.ACCEPTED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto, @PathVariable String id){
        Optional<UserDto> userDtoOptional = userService.update(userDto, id);

        return userDtoOptional.isPresent()
                ? new ResponseEntity<>(userDtoOptional.get(), HttpStatus.ACCEPTED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        userService.delete(id);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
