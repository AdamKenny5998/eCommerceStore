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
        Product prod1 = new Product(2L, "PS4", "no_image", 200.0);
        Product prod2 = new Product(3L, "Test3", "no_image", 300.0);
        prodList.add(prod1);
        prodList.add(prod2);
        
        return args -> {
            
            for(Product p : prodList)
            productService.save(p);
            
        };
    }
}

//When running the application, access the h2-console by localhost:8080/console