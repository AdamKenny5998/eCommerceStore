/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.javaRepositories;

import com.example.eCommerceSpringBoot.models.OrderProduct;
import com.example.eCommerceSpringBoot.models.OrderProductPK;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Adam
 */
public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductPK>{
    
}
