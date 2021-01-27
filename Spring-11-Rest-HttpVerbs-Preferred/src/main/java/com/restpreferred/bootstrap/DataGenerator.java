package com.restpreferred.bootstrap;

import com.restpreferred.entity.Product;
import com.restpreferred.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataGenerator implements CommandLineRunner {

    private ProductRepository productRepository;

    public DataGenerator(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Product pc = new Product("DELL");
        Product laptop = new Product("MACBOOK");
        Product phone = new Product("IPHONE");
        Product tablet = new Product("IPAD");

        productRepository.saveAll(Arrays.asList(pc, laptop, phone, tablet));
    }
}
