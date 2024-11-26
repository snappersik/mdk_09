package com.aptproject.springlibraryproject.library.dto;

import lombok.Data;

import java.util.List;

@Data
public class RegistrationUserDto {
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String address;
    private RoleDTO role;
    private List<Long> userBooksRent;
}
