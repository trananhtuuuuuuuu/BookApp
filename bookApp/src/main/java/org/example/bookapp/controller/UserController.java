package org.example.bookapp.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.bookapp.mapper.UserMapper;
import org.example.bookapp.model.User;
import org.example.bookapp.request.user.UserRegistrationRequest;
import org.example.bookapp.response.ServerResponse;
import org.example.bookapp.response.user.UserRegistrationResponse;
import org.example.bookapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;


    @PostMapping("/registrations")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {

        ServerResponse serverResponse = new ServerResponse();
        User user = this.userService.createUser(userRegistrationRequest);
        UserRegistrationResponse userRegistrationResponse = this.userMapper.toRegistrationResponse(user);

        serverResponse.setStatusCode(HttpStatus.CREATED.value());
        serverResponse.setMessage("Successfully");
        serverResponse.setData(userRegistrationResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(serverResponse);
    }

}
