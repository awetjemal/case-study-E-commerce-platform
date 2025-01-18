package com.casestudy.webapp.config;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupFormClass {


    @NotEmpty(message = "User's name cannot be empty.")
    @Size(min = 5, max = 250)
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
    private String street;
    private String city;
    private String state;
    private String zipCode;


}
