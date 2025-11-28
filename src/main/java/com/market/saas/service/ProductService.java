package com.market.saas.service;

import com.market.saas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public com.market.saas.model.ProductEntity createProduct(com.market.saas.model.ProductEntity product) {

        product.setSubtotal(product.getProductPrice() * product.getQuantity());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        productRepository.deleteById(id);
    }
    public com.market.saas.model.ProductEntity updateProduct(Long id, com.market.saas.model.ProductEntity product) {
        var existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductPrice(product.getProductPrice());
        existingProduct.setQuantity(product.getQuantity());


        existingProduct.setSubtotal(existingProduct.getProductPrice() * existingProduct.getQuantity());

        return productRepository.save(existingProduct);
    }
    public java.util.List<com.market.saas.model.ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}