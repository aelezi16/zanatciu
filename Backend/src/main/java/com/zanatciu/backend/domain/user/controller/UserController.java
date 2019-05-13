package com.zanatciu.backend.domain.user.controller;

import com.zanatciu.backend.domain.user.dto.UserDto;
import com.zanatciu.backend.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable String id){
        return null;
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> getByUsername(@PathVariable String username ){
        return null;
    }

    @PostMapping
    public ResponseEntity<UserDto> post(@Valid @RequestBody UserDto userDto){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto, @PathVariable String id){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        return null;
    }
}
