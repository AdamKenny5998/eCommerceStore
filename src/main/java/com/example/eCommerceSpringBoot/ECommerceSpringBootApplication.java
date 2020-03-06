package com.example.eCommerceSpringBoot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.example.eCommerceSpringBoot.model.Product;
import com.example.eCommerceSpringBoot.service.ProductService;

@ComponentScan({"com.example.eCommerceSpringBoot.service"})
@SpringBootApplication
public class ECommerceSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceSpringBootApplication.class, args);
    }
    
    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "test",  "test", 300.00));
        };
    }
}
