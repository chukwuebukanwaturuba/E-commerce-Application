package com.example.week7updated.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;


@Entity
@Table(name = "users_table")
@Data
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column
    String name;
    @Column
    String password;
    @Column
    String email;
}
