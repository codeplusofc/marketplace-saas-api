package com.market.saas.controller;

import com.market.saas.model.UserEntity;
import com.market.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
//aqui a busca sera por id
    @GetMapping("/{id}")
    public Optional<UserEntity> buscarUsuarioPorId(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUsers(@RequestBody UserEntity userEntity, @PathVariable Long id){
        return userService.updateUsers(userEntity, id);
    }
    //post=Postando=criando user e retornando status 201
    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        return ResponseEntity.status(201).body(userService.createUser(userEntity));
    }

    //metodo mapeando todos os user
    @GetMapping
    public List<UserEntity> getALLUsers(){
        return userService.findALLUser();
    }
}
