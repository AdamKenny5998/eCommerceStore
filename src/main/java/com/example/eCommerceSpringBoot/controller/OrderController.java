/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.controller;

import com.example.eCommerceSpringBoot.dtoPackage.OrderProductDto;
import com.example.eCommerceSpringBoot.exceptionHandlers.ResourceNotFoundException;
import com.example.eCommerceSpringBoot.models.Order;
import com.example.eCommerceSpringBoot.models.OrderProduct;
import com.example.eCommerceSpringBoot.models.OrderStatus;
import com.example.eCommerceSpringBoot.services.OrderProductService;
import com.example.eCommerceSpringBoot.services.OrderService;
import com.example.eCommerceSpringBoot.services.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Adam
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    ProductService productService;
    OrderService orderService;
    OrderProductService orderProductService;

    public OrderController(ProductService productService, OrderService orderService, OrderProductService orderProductService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @NotNull Iterable<Order> list(){
        return this.orderService.getAllOrders();
    }
    
    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderForm form){
        List<OrderProductDto> formDtos = form.getProductOrders();
        validateProductsExistence(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);
        
        List<OrderProduct> orderProducts = new ArrayList<>();
        for(OrderProductDto dto : formDtos){
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto
            .getProduct()
            .getId()), dto.getQuantity())));
        }
        order.setOrderProducts(orderProducts);
        
        this.orderService.update(order);
        
        String uri  = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);
        
        return new ResponseEntity<>(order, headers,HttpStatus.CREATED);
    }
    
    private void validateProductsExistence(List<OrderProductDto> orderProducts){
        List<OrderProductDto> list = orderProducts
                .stream()
                .filter(op -> Objects.isNull(productService.getProduct(op
                .getProduct()
                .getId())))
                .collect(Collectors.toList());
        
        if(!CollectionUtils.isEmpty(list)){
            new ResourceNotFoundException("Product Not Found!");
        }
    }
    
    public static class OrderForm{
        private List<OrderProductDto> productOrders;
        
        public List<OrderProductDto> getProductOrders() {
            return productOrders;
        }
        
        public void setProductOrders(List<OrderProductDto> productOrders){
            this.productOrders = productOrders;
        }
    }
    
    
}