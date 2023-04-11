package com.example.gli.dto;

import com.example.gli.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

import java.util.Date;

@Data
public class UserFormDto implements Serializable {
    private String name;
    private Gender gender;
    private Date dob;
    private String address;
    private String email;
    private Long userRoleId;

}