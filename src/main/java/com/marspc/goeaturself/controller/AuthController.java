package com.marspc.goeaturself.controller;

import com.marspc.goeaturself.domain.User;
import com.marspc.goeaturself.exception.ExceptionHandling;
import com.marspc.goeaturself.exception.domain.EmailExistsException;
import com.marspc.goeaturself.exception.domain.UserNotFoundException;
import com.marspc.goeaturself.exception.domain.UsernameExistsException;
import com.marspc.goeaturself.security.JWTTokenProvider;
import com.marspc.goeaturself.service.AuthService;
import com.marspc.goeaturself.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {"/", "/auth"})
public class AuthController extends ExceptionHandling {

    private AuthService authService;
    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JWTTokenProvider jwtTokenProvider;


    @Autowired
    public AuthController(AuthService authService, UserService userService, AuthenticationManager authenticationManager, JWTTokenProvider jwtTokenProvider) {
        this.authService = authService;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) throws UserNotFoundException, EmailExistsException, UsernameExistsException {
        User newUser = authService.register(user.getFirstName(), user.getUsername(), user.getEmail(), user.getPassword());
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}
