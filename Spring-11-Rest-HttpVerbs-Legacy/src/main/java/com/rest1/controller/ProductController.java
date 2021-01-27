package com.rest1.controller;

import com.rest1.entity.Product;
import com.rest1.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public @ResponseBody Product getProduct(@PathVariable("id") long id) {
        return productService.getProduct(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public @ResponseBody List<Product> createProduct(@RequestBody Product product) {
        productService.createProduct(product);
        return productService.getProducts();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public @ResponseBody List<Product> deleteProduct(@PathVariable("id") long id) {
        productService.delete(id);
        return productService.getProducts();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public @ResponseBody List<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return productService.getProducts();
    }

}
