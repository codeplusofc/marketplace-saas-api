package com.market.saas.controller;

import com.market.saas.model.UserEntity;
import com.market.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public UserEntity criarUsuario (@RequestBody UserEntity user){
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        userService.delete(id);
    }
}

