package com.market.saas.service;

import com.market.saas.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public User User (long id){
        Optional<User> user;
        user = userRepository.findAll(id);
        return null;
    }
}
