package org.example.bookapp.response.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.bookapp.model.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResponse {
    private String FirstName;
    private String LastName;
    private String Email;
    private String gender;
    private String address;
    private String phoneNumber;
    private Role role;
}
