package com.market.saas.controller;

import com.market.saas.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserController {
    private UserService userService;

    @GetMapping("/{id}")
    public User buscarUsuarioPorId(@PathVariable Long id){
        return userService.User(id);
    }





}
