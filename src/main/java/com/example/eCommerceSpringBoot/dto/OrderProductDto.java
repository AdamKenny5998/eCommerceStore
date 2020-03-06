/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.eCommerceSpringBoot.dto;

import com.example.eCommerceSpringBoot.model.Product;

/**
 *
 * @author Adam
 */
public class OrderProductDto {
    private Product product;
    private Integer quantity;
    
    public Product getProduct(){
        return product;
    }
    
    public void setProduct(Product product){
        this.product = product;
    }
    
    public Integer getQuantity(){
        return quantity;
    }
    
    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }
}
