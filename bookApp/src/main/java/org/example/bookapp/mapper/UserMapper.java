package org.example.bookapp.mapper;

import lombok.AllArgsConstructor;
import org.example.bookapp.dto.UserDTO;
import org.example.bookapp.model.Role;
import org.example.bookapp.model.User;
import org.example.bookapp.request.user.UserRegistrationRequest;
import org.example.bookapp.response.user.UserRegistrationResponse;
import org.example.bookapp.service.RoleService;
import org.springframework.stereotype.Component;

/*
private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String gender;
    private String address;
    private String phoneNumber;
* */
@Component
@AllArgsConstructor
public class UserMapper {

    private final RoleService roleService;
    private final RoleMapper roleMapper;

    public UserDTO toDTO(UserRegistrationRequest userRegistrationRequest) {
        return new UserDTO(
                userRegistrationRequest.getFirstName(),
                userRegistrationRequest.getLastName(),
                userRegistrationRequest.getEmail(),
                userRegistrationRequest.getPassword(),
                userRegistrationRequest.getGender(),
                userRegistrationRequest.getAddress(),
                userRegistrationRequest.getPhoneNumber(),
                userRegistrationRequest.getRoleName()
        );
    }

    public User toModel(UserDTO userDTO) {
        Role role = this.roleService.getRoleByRoleName(userDTO.getRoleName());
        return new User(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getGender(),
                userDTO.getAddress(),
                userDTO.getPhoneNumber(),
                role
        );
    }


    public UserRegistrationResponse toRegistrationResponse(User user) {
        return new UserRegistrationResponse(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getGender(),
                user.getAddress(),
                user.getPhoneNumber(),
                this.roleMapper.toDTO(user.getRole())
        );
    }


}
