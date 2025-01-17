package com.casestudy.webapp.config;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
// this is optional to figure out if you want to try
//@TwoFieldsAreEqual(fieldOneName = "confirmPassword", fieldTwoName = "password", message = "Password and Conform Password must be the same.")
public class SignupFormBean {

    @Length(max = 50, message = "First name must be less than 50 characters.")
    @NotEmpty(message = "First Name is required.")
    private String firstName;

    @Length(max = 50, message = "Last name must be less than 50 characters.")
    @NotEmpty(message = "Last name is required.")
    private String lastName;

    @Length(max = 50, message = "Phone number must be less than 50 characters.")
    @NotEmpty(message = "Phone number is required.")
    private String phone;

    @NotEmpty(message = "Email is required.")
    private String email;

    @NotEmpty(message = "Password is required.")
    private String firstPassword;

    @NotEmpty(message = "Password confirmation is required.")
    private String secondPassword;

    @Length(max = 50, message = "Address line 1 must be less than 50 characters.")
    @NotEmpty(message = "Address Line 1 is required.")
    private String street;

    @Length(max = 50, message = "City must be less than 50 characters.")
    @NotEmpty(message = "City name is required.")
    private String city;

    @Length(max = 50, message = "Country must be less than 50 characters.")
    @NotEmpty(message = "State name is required.")
    private String state;

    @NotEmpty(message = "Zip code is required.")
    private String zipCode;

}