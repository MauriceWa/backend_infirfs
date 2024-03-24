package com.example.todoappdeel3.dao;

import com.example.todoappdeel3.dto.ProductDTO;
import com.example.todoappdeel3.models.Product;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class ProductDAO {

    private final ProductRepository productRepository;

    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }


    @Transactional
    public void createProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO.name, productDTO.description, productDTO.price);
        this.productRepository.save(product);
    }

    public void updateProduct(ProductDTO productDTO, Long id) {
        Product product = this.productRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id)
        );

        product.setDescription(productDTO.description);
        product.setName(productDTO.name);
        product.setPrice(productDTO.price);

        this.productRepository.save(product);
    }


    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
