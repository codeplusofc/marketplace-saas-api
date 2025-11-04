package com.market.saas.service;

import com.market.saas.model.UserEntity;
import com.market.saas.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity findUserById(Long id) {
        Optional<UserEntity> userOpt = userRepository.findById(id);

        if (userOpt.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }

        return userOpt.get();
    }

    public UserEntity updateUser(UserEntity userEntity, Long id) {
        Optional<UserEntity> existingUser = userRepository.findById(id);

        if (existingUser.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }

        UserEntity userToUpdate = existingUser.get();
        userToUpdate.setNome(userEntity.getNome());
        userToUpdate.setCpf(userEntity.getCpf());
        userToUpdate.setIdade(userEntity.getIdade());

        return userRepository.save(userToUpdate);
    }

    public void deleteUser(Long id) {
        Optional<UserEntity> userOpt = userRepository.findById(id);

        if (userOpt.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }

        userRepository.deleteById(id);
    }
}
