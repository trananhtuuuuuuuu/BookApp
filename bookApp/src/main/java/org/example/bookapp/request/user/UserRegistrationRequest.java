package org.example.bookapp.request.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {
    @NotBlank(message = "firstName is mandatory")
    @Size(min = 2)
    private String firstName;

    @NotBlank(message = "lastName is mandatory")
    @Size(min = 2)
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    @NotBlank(message = "Gender is mandatory")
    @Size(min = 4, max = 6)
    private String gender;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank(message = "PhoneNumber is mandatory")
    @Column(length = 11)
    private String phoneNumber;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, max = 20)
    private String password;

    private String roleName;
}
