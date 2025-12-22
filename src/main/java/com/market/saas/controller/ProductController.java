package com.market.saas.controller;

import com.market.saas.model.ProductEntity;
import com.market.saas.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@Valid @RequestBody ProductEntity product) {

        return ResponseEntity.status(201).body(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductEntity product) {

        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}