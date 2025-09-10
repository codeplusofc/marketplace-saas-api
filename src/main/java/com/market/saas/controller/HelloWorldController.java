package com.market.saas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//CONTROLAR AS REQUISIÇÕES
//@RestController diz que essa classe é um controlador de requisições
@RestController
//@RequestMapping mapeia o caminho que a requisição irá percorrer
@RequestMapping("/hello")
public class HelloWorldController {

    //@GetMapping diz que essa fucnionalidade irá pegar e retornar um valor
    @GetMapping
    public String retornaHelloWorld(){
        return "Hello World";
    }
}
