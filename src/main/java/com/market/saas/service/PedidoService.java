package com.market.saas.service;

import com.market.saas.model.PedidoEntity;
import com.market.saas.model.ProductEntity;
import com.market.saas.repository.PedidoRepository;
import com.market.saas.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public PedidoEntity criarPredido(PedidoEntity dto){
        PedidoEntity pedido = new PedidoEntity();

        return pedidoRepository.save(pedido);
    }
    List<ProductEntity> productEntityList =productRepository.findAll();



}
