/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.service;

import com.example.eCommerceSpringBoot.model.OrderProduct;
import com.example.eCommerceSpringBoot.repositories.OrderProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Adam
 */
@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService{
    
    private OrderProductRepository orderProductRepository;
    
    public OrderProductServiceImpl(OrderProductRepository orderProductRepository){
        this.orderProductRepository = orderProductRepository;
    }
    
    @Override
    public OrderProduct create(OrderProduct orderProduct){
        return this.orderProductRepository.save(orderProduct);
    }
    
    
}
