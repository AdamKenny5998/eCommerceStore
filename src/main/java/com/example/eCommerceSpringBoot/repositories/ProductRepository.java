/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.eCommerceSpringBoot.model.Product;

/**
 *
 * @author Adam
 */
public interface ProductRepository extends CrudRepository<Product, Long>{
    
}
