package com.restapi.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterRequest {

    @NotEmpty
    @Size(min = 4, message = "Username should have at least 4 characters")
    private String username;

    @Email
    private String email;


    @NotEmpty
    @Size(min = 3, message = "Password should have at least 2 characters")
    private String password;

    @NotEmpty
    @Size(min = 3, message = "Name should have at least 3 characters")
    private String name;
}
