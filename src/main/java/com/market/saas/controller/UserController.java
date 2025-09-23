package com.market.saas.controller;


import com.market.saas.Usuario.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//TODO classe controlador
@RestController
//mapeia o caminho da requisição
@RequestMapping("/user")

public class UserController {

    //TODO teste
    @GetMapping
    public String ola(){
        return "ola mundo";
    }



    //TODO atualização put/user

    public interface UserRepository extends JpaRepository<User, Long>{

    }
    private UserRepository userRepository;

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userDetails){

        //Todo: Busca o usuario existente no banco por id
        Optional<User> optionalUser = userRepository.findById(id);

        //Todo: se não existir retorna erro
        if ((optionalUser.isEmpty())){
            return ResponseEntity.notFound().build();
        }

        //todo: se existir pega a entidade do optional
        User user = optionalUser.get();

        //todo: atualiza os campos da entidade
        user.setNome(userDetails.getNome());
        user.setEmail(userDetails.getEmail());
        user.setSenha(userDetails.getSenha());
        user.setRole(userDetails.getRole());


        //todo : Update no banco  e retorna a entidade atualizada //retorna 200ok com a entidade atualizada
        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }


    @GetMapping("/{id}")
    public User getUserByID (@PathVariable("id") String id) {
        // TODO simulando um usuario
        User user = new User();
        user.setNome("usuario" + id);
        user.setEmail("usuario" + id + "@test.com");
        return user;
    }
    @PostMapping("/{id}")
    public String User (@PathVariable ("id") String id,@RequestBody User body) {
        return "usuario" + body.getNome() + id;
    }

}
