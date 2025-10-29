package com.market.saas.controller;

import com.market.saas.model.UserEntity;
import com.market.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Optional<UserEntity> buscarUsuarioPorId(@PathVariable Long id){
        return userService.findUserById(id);
    }
}
