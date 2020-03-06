/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.service;

import com.example.eCommerceSpringBoot.model.Order;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author Adam
 */
@Validated
public interface OrderService {
    @NotNull Iterable<Order> getAllOrders();
    
    Order create(@NotNull(message="The order cannot be null.") @Valid Order order);
    
    void update(@NotNull(message = "The order cannot be null")@Valid Order order);
    
    
}
