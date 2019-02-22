package com.codecool.kulcssoft.repository;

import com.codecool.kulcssoft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAll();

    User getUserByUserId(Integer id);

    List<User> findAllByUserNameContaining(String search);
}
