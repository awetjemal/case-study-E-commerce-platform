package com.casestudy.webapp.service;

import com.casestudy.webapp.model.Product;
import com.casestudy.webapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(int id) {
        return productRepository.findById(id);
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
