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
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password){
        String token = authService.login(username, password);
        return token != null
                ? new ResponseEntity<>(token, HttpStatus.ACCEPTED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity<String> signup(@RequestBody UserDto userDto){

        String token = authService.signup(userDto);
        return token != null
            ? new ResponseEntity<>(HttpStatus.ACCEPTED)
            : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public ResponseEntity logout(){
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/refresh")
    public ResponseEntity<String> refresh(){
        return null;
    }
}
