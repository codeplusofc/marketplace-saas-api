package com.market.saas.controller;

import com.market.saas.model.User;
import com.market.saas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userDetails){
        Optional<User> optionalUser = userRepository.findById(id);

        if ((optionalUser.isEmpty())){
            return ResponseEntity.notFound().build();
        }

        User user = optionalUser.get();

        user.setNome(userDetails.getNome());
        user.setEmail(userDetails.getEmail());
        user.setSenha(userDetails.getSenha());
        user.setRole(userDetails.getRole());

        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

}
