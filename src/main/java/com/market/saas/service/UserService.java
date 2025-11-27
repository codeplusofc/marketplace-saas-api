package com.market.saas.service;

import com.market.saas.model.UserEntity;
import com.market.saas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity updateUsers(UserEntity userEntity, Long id) {
        var databaseUsers = userRepository.findById(id);

        if (databaseUsers.isEmpty()) {
            throw new RuntimeException("User not finded");
        }

        databaseUsers.get().setNome(userEntity.getNome());
        databaseUsers.get().setCpf(userEntity.getCpf());
        databaseUsers.get().setIdade(userEntity.getIdade());

        return userRepository.save(databaseUsers.get());
    }

    public Optional<UserEntity> findUserById(Long id) {
        var user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new RuntimeException("Não foi encontrado nenhum usuario com esse id");
        }
        return userRepository.findById(id);
    }
}
