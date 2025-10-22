package com.market.saas.controller;

import com.market.saas.model.ProductEntity;
import org.springframework.web.bind.annotation.*;
import com.market.saas.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity productEntity) {
        return productService.createProduct(productEntity);
    }

    @GetMapping
    public List<ProductEntity> findAllProducts(){
        return productService.findAllProducts();
    }
}
