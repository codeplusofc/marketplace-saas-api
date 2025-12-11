package com.market.saas.controller;

import com.market.saas.model.UserEntity;
import com.market.saas.repository.UserRepository;
import com.market.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUsers(@RequestBody UserEntity userEntity, @PathVariable Long id){
        return userService.updateUsers(userEntity, id);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        return ResponseEntity.status(201).body(userService.createUser(userEntity));
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>>getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity>deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();


    }
}
