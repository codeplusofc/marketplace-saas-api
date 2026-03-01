package com.market.saas.service;
import com.market.saas.model.UserEntity;
import com.market.saas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import static com.market.saas.validator.UserValidator.validateUserFields;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity updateUsers(UserEntity userEntity, Long id) {
        validateUserFields(userEntity);
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

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity createUser(UserEntity userEntity){
        validateUserFields(userEntity);
        return userRepository.save(userEntity);
    }


    public void deleteUserById(Long id){
      userRepository.deleteById(id);
    }
}










