package service;

import com.market.saas.model.ProductEntity;
import com.market.saas.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity createProduct(ProductEntity productEntity){
        return productRepository.save(productEntity);
    }

}

