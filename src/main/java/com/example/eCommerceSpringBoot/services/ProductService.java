/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.services;


import com.example.eCommerceSpringBoot.models.Product;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author Adam
 */
@Validated
public interface ProductService {
    @NotNull Iterable<Product> getAllProducts();
    
    Product getProduct(@Min(value=1L, message = "Invlaid product ID.")long id);
    
    Product save(Product product);
}
