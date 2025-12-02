package com.market.saas.service;

import com.market.saas.exception.NotFoundException;
import com.market.saas.model.ProductEntity;
import com.market.saas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new NotFoundException("Produto não encontrado");
        }
        productRepository.deleteById(id);
    }

    public ProductEntity updateProduct(Long id, ProductEntity product) {
        var existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductPrice(product.getProductPrice());
        existingProduct.setQuantity(product.getQuantity());

        return productRepository.save(existingProduct);
    }

    public List<ProductEntity> getAllProducts() {
        var products = productRepository.findAll();

        if (products.isEmpty()){
            throw new NotFoundException("Nenhum produto encontrado");
        }

        return products;
    }
}