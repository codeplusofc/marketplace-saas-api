package com.market.saas.service;

import com.market.saas.model.ProductEntity;
import com.market.saas.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity createProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity findProductById(Long id) {
        Optional<ProductEntity> productOpt = productRepository.findById(id);

        if (productOpt.isEmpty()) {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }

        return productOpt.get();
    }

    public ProductEntity updateProduct(ProductEntity productEntity, Long id) {
        Optional<ProductEntity> existingProduct = productRepository.findById(id);

        if (existingProduct.isEmpty()) {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }

        ProductEntity productToUpdate = existingProduct.get();
        productToUpdate.setNome(productEntity.getNome());
        productToUpdate.setPreco(productEntity.getPreco());
        productToUpdate.setDescricao(productEntity.getDescricao());
        productToUpdate.setVendedorId(productEntity.getVendedorId());

        return productRepository.save(productToUpdate);
    }

    public void deleteProduct(Long id) {
        Optional<ProductEntity> productOpt = productRepository.findById(id);

        if (productOpt.isEmpty()) {
            throw new RuntimeException("Produto não encontrado com ID: " + id);
        }

        productRepository.deleteById(id);
    }
}

