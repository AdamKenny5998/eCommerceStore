package com.example.eCommerceSpringBoot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.example.eCommerceSpringBoot.models.Product;
import com.example.eCommerceSpringBoot.services.ProductService;
import java.util.ArrayList;

@ComponentScan({"com.example.eCommerceSpringBoot"})
@SpringBootApplication
public class ECommerceSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceSpringBootApplication.class, args);
    }
    
    @Bean
    CommandLineRunner runner(ProductService productService) {
        ArrayList<Product> prodList = new ArrayList<Product>();

        
        return args -> {
            for(Product p : prodList)
            productService.save(p);
        };
    }
}

//When running the application, access the h2-console by localhost:8080/console