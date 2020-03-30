/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.javaRepositories;

/**
 *
 * @author Adam
 */

import com.example.eCommerceSpringBoot.models.Order;
import  org.springframework.data.repository.CrudRepository;
public interface OrderRepository extends CrudRepository<Order, Long>{
    
}
