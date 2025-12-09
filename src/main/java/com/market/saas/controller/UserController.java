package com.market.saas.controller;

import com.market.saas.model.UserEntity;
import com.market.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; // Import necessário
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public Optional<UserEntity> getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUsers(@RequestBody UserEntity userEntity, @PathVariable Long id){
        return userService.updateUsers(userEntity, id);
    }
}