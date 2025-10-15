package org.example.bookapp.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.bookapp.mapper.UserMapper;
import org.example.bookapp.model.User;
import org.example.bookapp.request.user.UserLoginRequest;
import org.example.bookapp.response.ServerResponse;
import org.example.bookapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/auth/login")
    public ResponseEntity<Object> loginUser(@Valid @RequestBody UserLoginRequest userLoginRequest) {
        ServerResponse serverResponse = new ServerResponse();

        return ResponseEntity.status(HttpStatus.OK).body(serverResponse);
    }
}
