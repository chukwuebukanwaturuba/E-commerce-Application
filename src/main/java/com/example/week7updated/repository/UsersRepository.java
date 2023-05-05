package com.example.week7updated.repository;

import com.example.week7updated.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Long> {

   Optional<UsersModel> findFirstByName(String name);

   Optional<UsersModel> findByEmail(String email);
}
