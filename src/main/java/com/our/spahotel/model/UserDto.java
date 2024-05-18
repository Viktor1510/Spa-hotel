package com.our.spahotel.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private String firstName;
    private String lastName;
    @Email
    private String email;
    @Size(min=10,max=10, message = "Telephone number must be 10 digits!")
    private String telephone;
    @Size(min=8, message = "Password must be at least 8 symbols")
    private String password;
    private String confirmedPassword;
}
