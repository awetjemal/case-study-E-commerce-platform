package com.casestudy.webapp.config;

import lombok.Data;

@Data
public class SignupFormClass {
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
