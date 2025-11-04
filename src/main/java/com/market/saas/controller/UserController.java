package com.market.saas.controller;

import com.market.saas.model.UserEntity;
import com.market.saas.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    @GetMapping
    public List<UserEntity> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserEntity findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@RequestBody UserEntity userEntity, @PathVariable Long id) {
        return userService.updateUser(userEntity, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
