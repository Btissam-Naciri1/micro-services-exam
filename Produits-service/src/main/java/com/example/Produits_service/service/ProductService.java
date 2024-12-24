package com.example.Produits_service.service;


import com.example.Produits_service.model.Product;
import com.example.Produits_service.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Product findProductById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
