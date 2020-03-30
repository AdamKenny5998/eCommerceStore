/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.controller;

import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.eCommerceSpringBoot.models.Product;
import com.example.eCommerceSpringBoot.services.ProductService;

/**
 *
 * @author Adam
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    
    private ProductService service;
    
    public ProductController(ProductService productService){
        this.service = productService;
    }
    
    @GetMapping(value = {"","/"})
    public Iterable<Product> getProducts(){
        return service.getAllProducts();
    }
    
    
}
