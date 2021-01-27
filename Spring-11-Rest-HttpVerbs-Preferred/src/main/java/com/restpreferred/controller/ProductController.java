package com.restpreferred.controller;

import com.restpreferred.entity.Product;
import com.restpreferred.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public List<Product> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return productService.getProducts();
    }

    @DeleteMapping(value = "/{id}")
    public List<Product> deleteProduct(@PathVariable("id") long id) {
        productService.delete(id);
        return productService.getProducts();
    }

    @PutMapping(value = "/{id}")
    public List<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return productService.getProducts();
    }

}
