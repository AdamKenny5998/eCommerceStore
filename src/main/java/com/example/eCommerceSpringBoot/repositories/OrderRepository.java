/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.repositories;

/**
 *
 * @author Adam
 */

import com.example.eCommerceSpringBoot.model.Order;
import  org.springframework.data.repository.CrudRepository;
public interface OrderRepository extends CrudRepository<Order, Long>{
    
}
