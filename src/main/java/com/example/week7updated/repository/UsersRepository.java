package com.example.week7updated.repository;

import com.example.week7updated.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<UsersModel, Integer> {

   Optional<UsersModel> findByNameAndPassword(String name, String password);

   Optional<UsersModel> findFirstByName(String name);
}
