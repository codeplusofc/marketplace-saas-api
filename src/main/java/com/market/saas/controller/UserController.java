package com.market.saas.controller;

import com.market.saas.model.UserEntity;
import com.market.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable long id, @RequestBody UserEntity userEntityDetails) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);

        if ((optionalUser.isEmpty())){
            return ResponseEntity.notFound().build();
        }

        UserEntity userEntity = optionalUser.get();

        userEntity.setNome(userEntityDetails.getNome());
        userEntity.setEmail(userEntityDetails.getEmail());
        userEntity.setSenha(userEntityDetails.getSenha());
        userEntity.setRole(userEntityDetails.getRole());

        UserEntity updatedUserEntity = userRepository.save(userEntity);
        return ResponseEntity.ok(updatedUserEntity);
         }

        @PostMapping
        public UserEntity createUser (@RequestBody UserEntity userEntity){
            return userService.createUser(userEntity);
        }
    }
