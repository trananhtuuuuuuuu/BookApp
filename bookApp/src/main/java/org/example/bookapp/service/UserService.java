package org.example.bookapp.service;

import lombok.AllArgsConstructor;
import org.example.bookapp.dto.UserDTO;
import org.example.bookapp.exception.AlreadyExistsException;
import org.example.bookapp.exception.ResourceNotFoundException;
import org.example.bookapp.mapper.UserMapper;
import org.example.bookapp.model.Role;
import org.example.bookapp.model.User;
import org.example.bookapp.repository.UserRepository;
import org.example.bookapp.request.user.UserRegistrationRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    //private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;


    public boolean checkExistingUser(String email) {
        boolean exists = this.userRepository.existsByEmail(email);
        if (exists) {
            throw new AlreadyExistsException("User already exists");
        }
        return false;
    }

    public User createUser(UserRegistrationRequest userRegistrationRequest) {
        if(checkExistingUser(userRegistrationRequest.getEmail())) {
            throw new AlreadyExistsException("User already exists");
        }
        UserDTO userDTO = this.userMapper.toDTO(userRegistrationRequest);
        User user = this.userMapper.toModel(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }
}
