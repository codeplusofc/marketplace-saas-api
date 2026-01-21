package com.market.saas.controller;


import com.market.saas.model.PedidoEntity;
import com.market.saas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoservice;

    @PostMapping
    public ResponseEntity<PedidoEntity> criar(@RequestBody PedidoEntity dto) {
       PedidoEntity novoPedido = pedidoservice.criarPredido(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }
}
