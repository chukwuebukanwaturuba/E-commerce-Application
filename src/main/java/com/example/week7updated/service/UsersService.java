package com.example.week7updated.service;

import com.example.week7updated.model.UsersModel;
import com.example.week7updated.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private UsersRepository usersRepository;
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
//    public UsersModel registerUser(String login, String password, String email){
//        if (login !=null && password !=null){
//            UsersModel usersModel = new UsersModel();
//            usersModel.setLogin(login);
//            usersModel.setLogin(password);
//            usersModel.setLogin(email);
//           return usersRepository.save(usersModel);
//        } else {
//            UsersModel usersModel = new UsersModel();
//            usersModel.setLogin(login);
//            usersModel.setPassword(password);
//            usersModel.setEmail(email);
//            return usersRepository.save(usersModel);
//        }
//    }

    public UsersModel registerUser(String name, String password, String email){
        if (name ==null || password ==null){
            return null;
        } else {
            if (usersRepository.findFirstByName(name).isPresent()) {
                System.out.println("Duplicate login");
                return null;
            }
            UsersModel usersModel = new UsersModel();
            usersModel.setName(name);
            usersModel.setPassword(password);
            usersModel.setEmail(email);
            System.out.println("Saved: " + usersModel);
            return usersRepository.save(usersModel);
        }
    }
    public UsersModel authenticate(String login, String password) {
        return usersRepository.findByNameAndPassword(login, password).orElse(null);
    }
}
