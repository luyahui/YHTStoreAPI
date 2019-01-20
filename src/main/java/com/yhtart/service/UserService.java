package com.yhtart.service;

import com.yhtart.model.User;
import com.yhtart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public User findUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }
}
