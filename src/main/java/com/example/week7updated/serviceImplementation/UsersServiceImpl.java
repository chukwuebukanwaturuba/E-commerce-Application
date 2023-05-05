package com.example.week7updated.serviceImplementation;

import com.example.week7updated.dto.UserDTO;
import com.example.week7updated.model.UsersModel;
import com.example.week7updated.repository.UsersRepository;
import com.example.week7updated.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {

        this.usersRepository = usersRepository;
    }


    @Override
    public UsersModel registerUser(UserDTO userDTO) {
        Optional<UsersModel> existingUser = usersRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Account already exist " + userDTO.getEmail());
        }
        UsersModel usersModel = new UsersModel(userDTO);
        return usersRepository.save(usersModel);
    }

    @Override
    public UsersModel authenticate(UserDTO userDTO) {
        UsersModel usersModel = usersRepository.findByEmail(userDTO.getEmail()).get();
        if (userDTO.getPassword().equals(usersModel.getPassword())) {
            return usersModel;
        }
        return null;

    }

}
