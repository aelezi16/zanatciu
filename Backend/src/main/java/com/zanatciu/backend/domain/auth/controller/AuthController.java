package com.zanatciu.backend.domain.auth.controller;


import com.zanatciu.backend.domain.auth.service.AuthService;
import com.zanatciu.backend.domain.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    private  AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(@RequestParam String username, @RequestParam String password){
        return authService.login(username, password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public String signup(@RequestBody UserDto userDto){

        return authService.signup(userDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public ResponseEntity logout(
            @RequestParam String token, @RequestParam String username
    ){
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/refresh")
    public String refresh(@RequestParam String token, @RequestParam String username){
        return authService.refresh(token, username);
    }
}
