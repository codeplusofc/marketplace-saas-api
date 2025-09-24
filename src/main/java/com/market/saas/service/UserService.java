package com.market.saas.service;

import com.market.saas.model.UserEntity;
import com.market.saas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity userEntity){
        if (userEntity.getNome().isEmpty()){
            throw new RuntimeException("Nome invalido!");
        }
        return userRepository.save(userEntity);
    }

}
