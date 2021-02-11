package com.jwt.controller;

import com.jwt.annotation.DefaultExceptionMessage;
import com.jwt.entity.AuthenticationRequest;
import com.jwt.entity.ResponseWrapper;
import com.jwt.entity.User;
import com.jwt.exceptions.ServiceException;
import com.jwt.service.UserService;
import com.jwt.util.JWTUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Authenticate Controller", description = "Authenticate API")
public class AuthenticationController {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JWTUtil jwtUtil;

    public AuthenticationController(UserService userService, AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    @DefaultExceptionMessage(defaultMessage = "Bad Credentials")
    @Operation(summary = "Login to application")
    public ResponseEntity<ResponseWrapper> doLogin(@RequestBody AuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        User foundUser = userService.readByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(authenticationToken);
        String jwtToken = jwtUtil.generateToken(foundUser);
        return ResponseEntity
                .ok(new ResponseWrapper("Login Successful!", jwtToken));
    }

    @PostMapping("/create-user")
    @DefaultExceptionMessage(defaultMessage = "User already exists, please try with another user")
    @Operation(summary = "Create new user")
    public ResponseEntity<ResponseWrapper> createAccount(@RequestBody  User user) throws ServiceException {
        User createdUser = userService.createUser(user);
        return ResponseEntity
                .ok(new ResponseWrapper("User has been successfully created!", createdUser));
    }

}
