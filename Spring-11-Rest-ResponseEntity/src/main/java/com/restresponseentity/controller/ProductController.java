package com.restresponseentity.controller;

import com.restresponseentity.entity.Product;
import com.restresponseentity.entity.ResponseWrapper;
import com.restresponseentity.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "v1");
        responseHttpHeaders.set("Operation", "Get List");
        return ResponseEntity
                .ok()
                .headers(responseHttpHeaders)
                .body(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<List<Product>> createProduct(@RequestBody Product product) {
        List<Product> set = productService.createProduct(product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version", "v1")
                .header("Operation", "Create")
                .body(set);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") long id) {
        HttpHeaders responseHttpHeaders = new HttpHeaders();
        responseHttpHeaders.set("Version", "v1");
        responseHttpHeaders.set("Operation", "Delete");
        return ResponseEntity
                .status(HttpStatus.OK)
                .headers(responseHttpHeaders)
                .body(productService.getProducts());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<List<Product>> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Version", "v1");
        map.add("Operation", "Update");
        List<Product> list = productService.updateProduct(id, product);
        return new ResponseEntity<>(list, map, HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<ResponseWrapper> readAllProducts() {
        return ResponseEntity
                .ok(new ResponseWrapper("Products have been successfully retrieved!", productService.getProducts()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct2(@PathVariable("id") long id) {
        ResponseWrapper wrapper = new ResponseWrapper("Product has been successfully deleted!");
        Product product = productService.getProduct(id);
        wrapper.setData(product);
        productService.delete(id);
        return ResponseEntity
                .ok(wrapper);
    }

    @DeleteMapping("/delete2/{id}")
    public ResponseEntity<ResponseWrapper> deleteProduct3(@PathVariable("id") long id) {
        ResponseWrapper wrapper = new ResponseWrapper("Product has been successfully deleted!");
        Product product = productService.getProduct(id);
        wrapper.setData(product);
        productService.delete(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(wrapper);
    }

}
