package com.our.spahotel.persistence;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Email
    private String username;
    @Size(min=10,max=10, message = "Telephone number must be 10 digits!")
    private String telephone;
    @Size(min=8, message = "Password must be at least 8 symbols")
    private String password;
    private String confirmedPassword;
    @OneToMany @Nullable
    private Set<Appointment> appointments;
    @OneToMany @Nullable
    private Set<Notification> notifications;
 }
