package com.rest1.implementation;

import com.rest1.entity.Product;
import com.rest1.repository.ProductRepository;
import com.rest1.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> delete(long id) {
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @Override
    public List<Product> updateProduct(long id, Product product) {
        Product found = productRepository.findById(id).get();
        found.setName(product.getName());
        productRepository.save(found);
        return productRepository.findAll();
    }

    @Override
    public List<Product> createProduct(Product product) {
        productRepository.save(product);
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).get();
    }
}
