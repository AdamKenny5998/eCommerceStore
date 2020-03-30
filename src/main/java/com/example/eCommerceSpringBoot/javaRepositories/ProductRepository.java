/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.javaRepositories;

import org.springframework.data.repository.CrudRepository;
import com.example.eCommerceSpringBoot.models.Product;

/**
 *
 * @author Adam
 */
public interface ProductRepository extends CrudRepository<Product, Long>{
    
}
