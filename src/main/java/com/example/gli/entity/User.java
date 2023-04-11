package com.example.gli.entity;

import com.example.gli.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "tb_master_user")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank
    private Gender gender;

    @Column(nullable = false)
    @NotBlank
    private Date dob;

    @Column(nullable = false)
    @NotBlank
    private String address;

    @Column(nullable = false)
    @Email(message = "Email should be valid")
    private String email;


    @ManyToOne
    @JoinColumn(name = "userRoleId")
    private UserRole userRole;
}
