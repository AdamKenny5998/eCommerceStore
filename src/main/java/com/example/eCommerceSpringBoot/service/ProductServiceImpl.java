/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.service;

import com.example.eCommerceSpringBoot.service.ProductService;
import com.example.eCommerceSpringBoot.model.Product;
import com.example.eCommerceSpringBoot.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.example.eCommerceSpringBoot.repositories.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    
    private ProductRepository productRepository;
    
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    
    @Override
    public Iterable<Product> getAllProducts(){
        return productRepository.findAll();
    }
    
    @Override
    public Product getProduct(long id){
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
    
    @Override
    public Product save(Product product){
        return productRepository.save(product);
    }
}
