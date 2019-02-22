package com.codecool.kulcssoft.service;

import com.codecool.kulcssoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void deleteUserById(Integer id){
        userRepository.delete(userRepository.getUserByUserId(id));
    }

}
