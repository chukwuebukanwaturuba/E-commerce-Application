package com.example.week7updated.service;

import com.example.week7updated.dto.UserDTO;
import com.example.week7updated.model.UsersModel;
import com.example.week7updated.repository.UsersRepository;
import org.apache.catalina.User;

import java.util.List;

public interface UsersService {
    UsersModel registerUser(UserDTO userDTO);

    UsersModel authenticate(UserDTO userDTO);


}
