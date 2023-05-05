package com.example.week7updated.model;


import com.example.week7updated.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Entity
@Table(name = "users_table")
@Data
@NoArgsConstructor
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String name;
    @Column
    String email;
    @Column
    String password;

    public UsersModel(UserDTO userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
    }
}
