package com.example.week7updated.model;

import com.example.week7updated.dto.AdminDTO;
import com.example.week7updated.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data

@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;


    public Admin() {

    }
    public Admin(AdminDTO adminDTO) {
        this.name = adminDTO.getName();
        this.email = adminDTO.getEmail();
        this.password = adminDTO.getPassword();
    }
}
