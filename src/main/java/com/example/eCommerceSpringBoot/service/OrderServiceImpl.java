/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.service;

/**
 *
 * @author Adam
 */
import com.example.eCommerceSpringBoot.exception.ResourceNotFoundException;
import com.example.eCommerceSpringBoot.model.Order;
import com.example.eCommerceSpringBoot.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import com.example.eCommerceSpringBoot.repositories.ProductRepository;
import java.time.LocalDate;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    
    private OrderRepository orderRepository;
    
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    
    @Override
    public Iterable<Order> getAllOrders(){
        return this.orderRepository.findAll();
    }
    
    @Override
    public void update(Order order){
        this.orderRepository.save(order);
    }
    
    @Override
    public Order create(Order order){
        order.setDateCreated(LocalDate.now());
        
        return this.orderRepository.save(order);
    }
    
    
}
